package org.i2cat.tapies.transcoder.transco.extras.tools;
//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/tools/ImageTool.java $
//Revision: $Revision: 204 $
//Last modified: $Date: 2011-06-03 21:24:21 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.image.BufferedImage;

import org.i2cat.tapies.transcoder.transco.extras.awt.DrawImage;

import com.xuggle.xuggler.IAudioSamples;

/**
 * Class to draw an image into another AWT image passed by xuggle. Depends on
 * DrawImage to make the AWT stuff.
 * 
 @author $Author: javier_lopez $
 * @version $Revision: 204 $
 * 
 */
public class ImageTool implements TapiesTool {

	/**
	 * X coordinate to start drawing.
	 */
	private int x;
	/**
	 * Y coordinate to start drawing.
	 */
	private int y;
	/**
	 * Desired width of the image.
	 */
	private int width;
	/**
	 * Desired height of the image.
	 */
	private int height;
	/**
	 * Place the image in the left superior corner and with only 1 pixel of
	 * separation.
	 */
	public final static int LEFT_SUP_CORNER_1 = 1;
	/**
	 * Place the image in the right superior corner and with only 1 pixel of
	 * separation.
	 */
	public final static int RIGHT_SUP_CORNER_1 = 2;
	/**
	 * Place the image in the left inferior corner and with only 1 pixel of
	 * separation.
	 */
	public final static int LEFT_INF_CORNER_1 = 3;
	/**
	 * Place the image in the right inferior corner and with only 1 pixel of
	 * separation.
	 */
	public final static int RIGHT_INF_CORNER_1 = 4;

	/**
	 * Place the image in the left superior corner and with only 5 pixel of
	 * separation.
	 */
	public final static int LEFT_SUP_CORNER_5 = 5;
	/**
	 * Place the image in the right superior corner and with only 5 pixel of
	 * separation.
	 */
	public final static int RIGHT_SUP_CORNER_5 = 6;
	/**
	 * Place the image in the left inferior corner and with only 5 pixel of
	 * separation.
	 */
	public final static int LEFT_INF_CORNER_5 = 7;
	/**
	 * Place the image in the right inferior corner and with only 5 pixel of
	 * separation.
	 */
	public final static int RIGHT_INF_CORNER_5 = 8;

	/**
	 * Place the image in the left superior corner and with only 10 pixel of
	 * separation.
	 */
	public final static int LEFT_SUP_CORNER_10 = 9;
	/**
	 * Place the image in the right superior corner and with only 10 pixel of
	 * separation.
	 */
	public final static int RIGHT_SUP_CORNER_10 = 10;
	/**
	 * Place the image in the left inferior corner and with only 10 pixel of
	 * separation.
	 */
	public final static int LEFT_INF_CORNER_10 = 11;
	/**
	 * Place the image in the right inferior corner and with only 10 pixel of
	 * separation.
	 */
	public final static int RIGHT_INF_CORNER_10 = 12;

	/**
	 * Place the image in the left superior corner and with only 20 pixel of
	 * separation.
	 */
	public final static int LEFT_SUP_CORNER_20 = 13;
	/**
	 * Place the image in the right superior corner and with only 20 pixel of
	 * separation.
	 */
	public final static int RIGHT_SUP_CORNER_20 = 14;
	/**
	 * Place the image in the left inferior corner and with only 20 pixel of
	 * separation.
	 */
	public final static int LEFT_INF_CORNER_20 = 15;
	/**
	 * Place the image in the right inferior corner and with only 20 pixel of
	 * separation.
	 */
	public final static int RIGHT_INF_CORNER_20 = 16;

	/**
	 * Place the image in the left superior corner and with only 50 pixel of
	 * separation.
	 */
	public final static int LEFT_SUP_CORNER_50 = 17;
	/**
	 * Place the image in the right superior corner and with only 50 pixel of
	 * separation.
	 */
	public final static int RIGHT_SUP_CORNER_50 = 18;
	/**
	 * Place the image in the left inferior corner and with only 50 pixel of
	 * separation.
	 */
	public final static int LEFT_INF_CORNER_50 = 19;
	/**
	 * Place the image in the right inferior corner and with only 50 pixel of
	 * separation.
	 */
	public final static int RIGHT_INF_CORNER_50 = 20;

	/**
	 * Auxiliar variable to store the corner where to put the image.
	 */
	private int corner;
	/**
	 * Video height.
	 */
	private int videoHeight;
	/**
	 * Video Height
	 */
	private int videoWidth;
	/**
	 * An instance of {@link DrawImage} to do the AWT stuff.
	 */
	private DrawImage drawImage;
	/**
	 * Auxiliar variable to know if this is configured or not.
	 */
	private boolean configured = false;
	/**
	 * A counter.
	 */
	private int counter = 0;

	/**
	 * Method to configure the object. Set the coordinates (x,y) in function of
	 * the given corner number.
	 */
	private void configure() {
		switch (corner) {
		case LEFT_SUP_CORNER_1:
			x = 1;
			y = 1;
			break;

		case LEFT_INF_CORNER_1:
			x = 1;
			y = videoHeight - 1 - height;
			break;

		case RIGHT_SUP_CORNER_1:
			x = videoWidth - 1 - width;
			y = 1;
			break;

		case RIGHT_INF_CORNER_1:
			x = videoWidth - 1 - width;
			y = videoHeight - 1 - height;
			break;

		case LEFT_SUP_CORNER_5:
			x = 5;
			y = 5;
			break;

		case LEFT_INF_CORNER_5:
			x = 5;
			y = videoHeight - 5 - height;
			break;

		case RIGHT_SUP_CORNER_5:
			x = videoWidth - 5 - width;
			y = 5;
			break;

		case RIGHT_INF_CORNER_5:
			x = videoWidth - 5 - width;
			y = videoHeight - 5 - height;
			break;

		case LEFT_SUP_CORNER_10:
			x = 10;
			y = 10;
			break;

		case LEFT_INF_CORNER_10:
			x = 10;
			y = videoHeight - 10 - height;
			break;

		case RIGHT_SUP_CORNER_10:
			x = videoWidth - 10 - width;
			y = 10;
			break;

		case RIGHT_INF_CORNER_10:
			x = videoWidth - 10 - width;
			y = videoHeight - 10 - height;
			break;

		case LEFT_SUP_CORNER_20:
			x = 20;
			y = 20;
			break;

		case LEFT_INF_CORNER_20:
			x = 20;
			y = videoHeight - 20 - height;
			break;

		case RIGHT_SUP_CORNER_20:
			x = videoWidth - 20 - width;
			y = 20;
			break;

		case RIGHT_INF_CORNER_20:
			x = videoWidth - 20 - width;
			y = videoHeight - 20 - height;
			break;

		case LEFT_SUP_CORNER_50:
			x = 50;
			y = 50;
			break;

		case LEFT_INF_CORNER_50:
			x = 50;
			y = videoHeight - 50 - height;
			break;

		case RIGHT_SUP_CORNER_50:
			x = videoWidth - 50 - width;
			y = 50;
			break;

		case RIGHT_INF_CORNER_50:
			x = videoWidth - 50 - width;
			y = videoHeight - 50 - height;
			break;

		default:
			x = 1;
			y = 1;
			break;
		}
		configured = true;
		// Configure drawImage instance
		drawImage.setCoords(x, y, width, height);
	}

	/**
	 * Called when a video picture is decoded from the video.
	 * 
	 * @param bi
	 *            {@link BufferedImage} representation of the video frame.
	 */
	public void onVideoPicture(BufferedImage bi) {

		//long time1 = System.currentTimeMillis();
		counter++;
		// If it isn't configured, configure it.
		if (!configured) {
			this.videoHeight = bi.getHeight();
			this.videoWidth = bi.getWidth();
			configure();
		}
		// Paint
		drawImage.paint(bi.getGraphics(), Integer.toString(counter));
		//long time2 = System.currentTimeMillis();
		//long timet = time2 - time1;
		// logger.debug("Draw Image in " + timet + " ms");
	}

	/**
	 * Constructor
	 * 
	 * @param fileName
	 *            Path to the image
	 * @param width
	 *            Desired with of the image
	 * @param height
	 *            Desired height of the image
	 * @param corner
	 *            Where to put the image
	 */
	public ImageTool(String fileName, int width, int height, int corner) {
		this.width = width;
		this.height = height;
		// If not specified default is left superior corner 1 pixel
		if (corner == 0) {
			this.corner = LEFT_SUP_CORNER_1;
		}
		this.corner = corner;
		drawImage = new DrawImage(fileName);

	}

	
	public void onVideoPicture(BufferedImage bi, String timestamp) {
		// Call our onVideoPicture and ignore timestamp (we don't need it).
		onVideoPicture(bi);
	}

	
	public void onAudioSamples(IAudioSamples audioSamples) {
		// Does nothing
	}

	@Override
	public void cleanConfig() {
		this.configured = false;
	}
	
}
