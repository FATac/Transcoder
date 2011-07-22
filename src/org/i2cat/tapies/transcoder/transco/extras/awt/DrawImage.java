package org.i2cat.tapies.transcoder.transco.extras.awt;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/awt/DrawImage.java $
//Revision: $Revision: 183 $
//Last modified: $Date: 2011-05-05 15:31:32 +0200 (Thu, 05 May 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Class used to draw an AWT image given a {@link Graphics} instance.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 183 $
 * 
 */
@SuppressWarnings("serial")
public class DrawImage extends Frame {
	/**
	 * The {@link Image} to draw.
	 */
	private Image image;
	/**
	 * The path to the image file.
	 */
	private String dir;
	/**
	 * The x coordinate to start to draw.
	 */
	private int x;
	/**
	 * The y coordinate to start to draw.
	 */
	private int y;
	/**
	 * The desired width of the image.
	 */
	private int width;
	/**
	 * The desired height of the image.
	 */
	private int height;

	/**
	 * The constructor
	 * 
	 * @param path
	 *            Path to the image file.
	 */
	public DrawImage(String path) {
		this.dir = path;
	}

	/**
	 * Method to set the coordinates, height and width of the desired image.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setCoords(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Method to paint the given image with the given parameters.
	 * 
	 * @param g
	 * @param framenumber
	 */
	public void paint(Graphics g, String framenumber) {
		// TODO: Check if image is opened correctly.
		image = Toolkit.getDefaultToolkit().getImage(dir);
		g.drawImage(image, x, y, width, height, this);
	}

}