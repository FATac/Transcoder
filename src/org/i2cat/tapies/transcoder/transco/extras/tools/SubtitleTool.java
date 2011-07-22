package org.i2cat.tapies.transcoder.transco.extras.tools;
//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/tools/SubtitleTool.java $
//Revision: $Revision: 210 $
//Last modified: $Date: 2011-06-06 13:04:55 +0200 (Mon, 06 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.image.BufferedImage;

import org.i2cat.tapies.transcoder.transco.extras.awt.DrawSrtSubtitle;
import org.i2cat.tapies.transcoder.transco.extras.awt.DrawSubSubtitle;
import org.i2cat.tapies.transcoder.util.Util;

import com.xuggle.xuggler.IAudioSamples;

/**
 * Class to get subtitle from a file and paint it into a frame of a video (AWT
 * Image) provided by xuggle. The object detects the format of the subtitle and
 * takes a decision on how to parse it.
 * 
 @author $Author: javier_lopez $
 * @version $Revision: 210 $
 * 
 */
public class SubtitleTool implements TapiesTool {
	/**
	 * Instance of {@link DrawSubSubtitle} to draw .sub subtitle.
	 */
	private DrawSubSubtitle dss = null;
	/**
	 * Instance of {@link DrawSrtSubtitle} to draw .srt subtitle
	 */
	private DrawSrtSubtitle dsrts = null;
	/**
	 * Counter to know frame number.
	 */
	private long counter = 0;
	/**
	 * Auxiliar variable to know if this is configured or not.
	 */
	private boolean configured = false;
	/**
	 * Desired width of the image.
	 */
	private int width;
	/**
	 * Desired height of the image.
	 */
	private int height;

	/**
	 * Constructor
	 * 
	 * @param fileName
	 *            The path to subtitle.
	 */
	public SubtitleTool(String fileName) {
		// Get the extension
		String ext = Util.getExtension(fileName);
		// Take a decision
		if (ext.compareTo("sub") == 0) {
			dss = new DrawSubSubtitle(fileName);
		}
		if (ext.compareTo("srt") == 0) {
			dsrts = new DrawSrtSubtitle(fileName);
		}

	}

	
	public void onVideoPicture(BufferedImage bi, String timestamp) {
//		System.out.println(new SystemStatistics().getSystemLoadAverage());
		//long time1 = System.currentTimeMillis();
		if(!configured) {
			width = bi.getWidth();
			height = bi.getHeight();
			configured = true;
		}
		// Paint differently if is a .sub or .srt
		if (dss != null) {
//			dss.paint(bi.getGraphics(), counter, (bi.getWidth() / 2) - 100,
//					bi.getHeight() - 5);
			dss.paint(bi.getGraphics(), counter, width, height);
		}

		if (dsrts != null) {
//			dsrts.paint(bi.getGraphics(), timestamp, (bi.getWidth() / 2) - 100,
//					bi.getHeight() - 5);
			dsrts.paint(bi.getGraphics(), timestamp, width, height);
		}

		//long time2 = System.currentTimeMillis();
		//long timet = time2 - time1;
		// logger.debug("Add subtitle in " + timet + " ms");
		counter++;
	}

	
	public void onAudioSamples(IAudioSamples audioSamples) {
		// Do nothing
	}


	@Override
	public void cleanConfig() {
		this.configured = false;
	}

}
