package org.i2cat.tapies.transcoder.transco.extras.awt;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/awt/DrawSrtSubtitle.java $
//Revision: $Revision: 210 $
//Last modified: $Date: 2011-06-06 13:04:55 +0200 (Mon, 06 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

@SuppressWarnings("serial")
/**
 * Class to parse and draw a .srt subtitle file in an AWT image. The format to parse is the following:<br>
 1st line: integer<br>
 2nd line: StartTime --> EndTime<br>
 3rd line: Subtitle1<br>
 4th line: Subtitle2<br>
 ...
 Last line in white
 <br><br>
 where StartTime and EndTime are strings in this format:
 HH:MM:SS,DECIMALS, for instance:<br>

 1<br>
 00:00:00,1234 --> 00:00:18,652<br>
 ¿Quieres escuchar una locura?<br>

 @author $Author: javier_lopez $
 * @version $Revision: 210 $
 * 
 */
public class DrawSrtSubtitle extends Frame {

	/**
	 * The subtitle file. Note that is a {@link RandomAccessFile} where we can
	 * go wherever we want.
	 */
	private RandomAccessFile raf;
	/**
	 * The starting time to the actual subtitle.
	 */
	private String starttime = "";
	/**
	 * The endtime to the actual subtitle.
	 */
	private String endtime = "";
	/**
	 * Auxiliar variable to get the start hour for a given string.
	 */
	private int starthour = 0;
	/**
	 * Auxiliar variable to get the start minute for a given string.
	 */
	private int startminute = 0;
	/**
	 * Auxiliar variable to get the start second for a given string.
	 */
	private float startseconds = 0;
	/**
	 * Auxiliar variable to get the end hour for a given string.
	 */
	private int endhour = 0;
	/**
	 * Auxiliar variable to get the end minute for a given string.
	 */
	private int endminute = 0;
	/**
	 * Auxiliar variable to get the end seconds for a given string.
	 */
	private float endseconds = 0;
	/**
	 * Auxiliar variable to store the subtitle.
	 */
	private String subtitle;
	/**
	 * Auxiliar variable to know if the subtitle is now parsed or not.
	 */
	private boolean gotcha = false;

	/**
	 * A counter to get control over the number of processed frames.
	 */
	private int counter = 0;

	/**
	 * Temporal variable to know how many chars we have to move to read the
	 * text.
	 */
	private long moveon = 0;

	/**
	 * Constructor
	 * 
	 * @param fileName
	 *            Path of the srt subtitle.
	 */
	public DrawSrtSubtitle(String fileName) {
		try {
			// Open a random access file in read only mode
			raf = new RandomAccessFile(fileName, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get the subtitle text according to a video timestamp.
	 * 
	 * @param timestamp
	 *            Timestamp of the video in the xuggle format.
	 * @return a String with the subtitle according to the given timestamp.
	 * @throws IOException
	 */
	public synchronized String getText(String timestamp) throws IOException {

		counter++;

		int videohour = getHours(timestamp);
		int videominute = getMinutes(timestamp);
		float videoseconds = getSeconds(timestamp);

		/*
		 * If we have exceed the end time (endhour, endminute and endsecond),
		 * then we have to update the start and end frame of the subtitle.
		 */

		if (videohour >= endhour) {

			if (videominute >= endminute) {

				if (videoseconds > endseconds) {

					updateStartAndEndTime();
					// Backtracking to get the new subtitle text. The index will
					// be updated for sure.
					return getText(timestamp);
				}
			}
		}

		// If we have not reached yet the start hour and not exceed the end
		// minute.
		if (videohour >= starthour) {
			if (videohour <= endhour) {
				// If we have not reached yet the start minute and not exceed
				// the end minute.
				if (videominute >= startminute) {
					if (videominute <= endminute) {
						// If we have not reached yet the start second and not
						// exceed the end second.
						if (videoseconds >= startseconds) {
							if (videoseconds <= endseconds) {
								// Then, we have to read the subtitle text.
								if (gotcha == false) {
									raf.seek(raf.getFilePointer() + moveon);
									String line = "";
									String ret = "";
									int i = 0;

									line = raf.readLine();
									while (!line.isEmpty()) {

										if (i == 0) {
											ret = line;
										} else {
											ret = ret + " " + line;
										}
										line = raf.readLine();

										i++;

									}

									subtitle = ret;
									// System.out.println("Subtitle: " +
									// subtitle);
									// We've read the subtitle. The next time
									// don't need to parse again, return it
									// directly
									gotcha = true;
								}
								// If gotcha = true, the subtitle is already
								// parsed, then return it directly.
								// System.out.println("Subtitle: " + subtitle);
								return subtitle;
							}
						}
					}
				}
			}
		}

		return "";

	}

	/**
	 * Method to update the start and end time
	 * 
	 * @throws IOException
	 */
	private synchronized void updateStartAndEndTime() throws IOException {

		// We can assume that when this method is called, the subtitle hasn't
		// been read yet.
		gotcha = false;

		// Parse time.

		// Avoid the first integer line
		long firstPointer = raf.getFilePointer();
		//String line1 = raf.readLine();
		raf.readLine();
		
		// Get the line to parse: StartTime --> EndTime
		String toparse = raf.readLine();
		long lastPointer = raf.getFilePointer();

		// Split by -->
		String[] test = toparse.split(" --> ");

		// Replace , by . to fulfill xuggle format.
		starttime = test[0].replace(",", ".");

		endtime = test[1].replace(",", ".");

		// Now we've get the string, get the integers and float.
		this.starthour = getHours(starttime);
		this.startminute = getMinutes(starttime);
		this.startseconds = getSeconds(starttime);

		this.endhour = getHours(endtime);
		this.endminute = getMinutes(endtime);
		this.endseconds = getSeconds(endtime);
		raf.seek(firstPointer);

		moveon = (lastPointer - firstPointer);

	}

	/**
	 * Method to paint a subtitle according to the given timestamp into an AWT
	 * image passed by xuggle in a {@link Graphics} way.
	 * 
	 * @param g
	 *            The graphics of the image
	 * @param timestamp
	 *            The xuggle formatted video timestamp.
	 * @param x
	 *            X coord.
	 * @param y
	 *            Y coord.
	 */
	public void paint(Graphics g, String timestamp, int bWidth, int bHeight) {
		try {
			// The first time update directly.
			if (counter == 0) {
				updateStartAndEndTime();
			}
			// Get text
			String sub = getText(timestamp);
			if (sub.length() > 0) {
				
				FontMetrics fm   = g.getFontMetrics();
				int textWidth  = (int) fm.getStringBounds(sub, g).getWidth();
	
				// Center text horizontally and set on the 95% to the bottom
				int x = (bWidth  - textWidth)  / 2;
				int y = (int) (bHeight*(0.95));
	
				g.drawString(sub, x, y);  // Draw the string.
			}
			counter++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get the seconds for a xuggle formatted timestamp string.
	 * 
	 * @param s
	 *            timestamp
	 * @return float with the seconds.
	 */
	private float getSeconds(String s) {
		return Float.parseFloat(s.split(":")[2]);
	}

	/**
	 * Method to get the minutes for a xuggle formatted timestamp string.
	 * 
	 * @param s
	 *            timestamp
	 * @return integer with the minutes.
	 */
	private int getMinutes(String s) {
		return Integer.parseInt(s.split(":")[1]);
	}

	/**
	 * Method to get the hours for a xuggle formatted timestamp string.
	 * 
	 * @param s
	 *            timestamp
	 * @return integer with the hours.
	 */
	private int getHours(String s) {
		return Integer.parseInt(s.split(":")[0]);
	}

	// public static void main(String[] args) throws IOException {
	// DrawSrtSubtitle dss = new DrawSrtSubtitle(
	// "/home/galera/Documents/Tapies/Pruebas xuggle/Subtitulos/Lost.S05E09.HDTV.XviD-NoTV_By.Thinkywinki.srt");
	// System.out.println("@00:00:00.000" + dss.getText("00:00:00.000"));
	// System.out.println("@00:00:15.123" + dss.getText("00:00:15.123"));
	// System.out.println("@00:00:23.982" + dss.getText("00:00:23.982"));
	// System.out.println("@00:00:27.100" + dss.getText("00:00:27.100"));
	// System.out.println("@00:00:27.124" + dss.getText("00:00:27.124"));
	// System.out.println("@00:00:27.125" + dss.getText("00:00:27.125"));
	// System.out.println("@00:00:28.125" + dss.getText("00:00:28.125"));
	// System.out.println("@00:00:28.625" + dss.getText("00:00:28.625"));
	// System.out.println("@00:00:28.653" + dss.getText("00:00:28.653"));
	// System.out.println("@00:00:29.126" + dss.getText("00:00:29.126"));
	// System.out.println("@00:00:30.532" + dss.getText("00:00:30.532"));
	// System.out.println("@00:00:33.021" + dss.getText("00:00:33.021"));
	// System.out.println("@00:00:33.022" + dss.getText("00:00:33.022"));
	// System.out.println("@00:00:34.601" + dss.getText("00:00:34.601"));
	// System.out.println("@00:00:34.901" + dss.getText("00:00:34.901"));
	// }

}
