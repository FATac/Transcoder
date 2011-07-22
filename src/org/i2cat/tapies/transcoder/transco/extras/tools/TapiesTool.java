package org.i2cat.tapies.transcoder.transco.extras.tools;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/extras/tools/TapiesTool.java $
//Revision: $Revision: 204 $
//Last modified: $Date: 2011-06-03 21:24:21 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.image.BufferedImage;

import com.xuggle.xuggler.IAudioSamples;

/**
 * Interface for the processing tools to apply to the transcode.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 204 $
 * 
 */
public interface TapiesTool {

	/**
	 * Called when a video picture is decoded by xuggle.
	 * 
	 * @param bi
	 *            a BufferedImage representation of the video frame.
	 * @param timestamp
	 *            A Xuggle formatted timestamp.
	 */
	public void onVideoPicture(BufferedImage bi, String timestamp);

	/**
	 * Called when audio samples are decoded by xuggle.
	 * 
	 * @param audioSamples
	 *            the audio samples to deal with.
	 */
	public void onAudioSamples(IAudioSamples audioSamples);

	/**
	 * Called when a Tool configuration should be reset, usually
	 * after each SubTask call or before a new one starts
	 */
	public void cleanConfig();
}
