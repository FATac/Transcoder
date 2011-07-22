package org.i2cat.tapies.transcoder.transco.extras.tools;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/tools/TimeStampTool.java $
//Revision: $Revision: 204 $
//Last modified: $Date: 2011-06-03 21:24:21 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import com.xuggle.xuggler.IAudioSamples;

/**
 * Adds a timestamp graphic in every frame to show the timestamps.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 204 $
 * 
 */
public class TimeStampTool implements TapiesTool {
	/** {@inheritDoc} */

//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void onVideoPicture(BufferedImage bi, String timestamp) {
//		System.out.println(new SystemStatistics().getSystemLoadAverage());
		// get the graphics for the image
		//long time1 = System.currentTimeMillis();
		Graphics2D g = bi.createGraphics();

		// establish the timestamp and how much space it will take

		String timeStampStr = timestamp;
		Rectangle2D bounds = g.getFont().getStringBounds(timeStampStr,
				g.getFontRenderContext());

		// compute the amount to inset the time stamp and translate the
		// image to that position

		double inset = bounds.getHeight() / 2;
		g.translate(inset, bi.getHeight() - inset);

		// draw a white background and black timestamp text

		g.setColor(Color.WHITE);
		g.fill(bounds);
		g.setColor(Color.BLACK);
		g.drawString(timeStampStr, 0, 0);

		// call parent which will pass the video onto next tool in chain
		//long time2 = System.currentTimeMillis();
		//long timet = time2 - time1;
		// logger.debug("Add timestamp in " + timet + " ms");
	}

	public void onAudioSamples(IAudioSamples audioSamples) {
	}

	@Override
	public void cleanConfig() {
		// TODO Auto-generated method stub
		
	}
}