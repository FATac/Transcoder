package org.i2cat.tapies.transcoder.transco.extras.tools;
//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/tools/VolumeAdjustTool.java $
//Revision: $Revision: 204 $
//Last modified: $Date: 2011-06-03 21:24:21 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.image.BufferedImage;
import java.nio.ShortBuffer;

import com.xuggle.xuggler.IAudioSamples;

/**
 * Class to adjust the volume of all the samples by the same factor.
 * 
 @author $Author: javier_lopez $
 * @version $Revision: 204 $
 * 
 */
public class VolumeAdjustTool implements TapiesTool {
	// the amount to adjust the volume by

	private double mVolume;

	/**
	 * Construct a volume adjustor.
	 * 
	 * @param volume
	 *            the volume muliplier, values between 0 and 1 are recommended.
	 */

	public VolumeAdjustTool(double volume) {
		mVolume = volume;
	}

	/** {@inheritDoc} */

	
	public void onAudioSamples(IAudioSamples audioSamples) {
		// get the raw audio byes and adjust it's value

		ShortBuffer buffer = audioSamples.getByteBuffer().asShortBuffer();
		for (int i = 0; i < buffer.limit(); ++i)
			buffer.put(i, (short) (buffer.get(i) * mVolume));

		// call parent which will pass the audio onto next tool in chain

	}

	
	public void onVideoPicture(BufferedImage bi, String timestamp) {
		// Do nothing
	}

	@Override
	public void cleanConfig() {
		// TODO Auto-generated method stub
		
	}
}