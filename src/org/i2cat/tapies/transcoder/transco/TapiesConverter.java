package org.i2cat.tapies.transcoder.transco;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/TapiesConverter.java $
//Revision: $Revision: 183 $
//Last modified: $Date: 2011-05-05 15:31:32 +0200 (Thu, 05 May 2011) $
//Modified by: $Author: javier_lopez $
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import org.i2cat.tapies.transcoder.transco.extras.tools.TapiesTool;

import com.xuggle.xuggler.Converter;
import com.xuggle.xuggler.IAudioSamples;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

/**
 * The main class of the overall transcoder. Performs all the transcode stuff
 * extending the Xuggle's {@link Converter} class. Offers support to add a tool
 * chain to process every frame and for example add images, subtitle, etc..
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 183 $
 * 
 */
public class TapiesConverter extends Converter {

	/**
	 * {@link IConverter} class to translate to/from {@link BufferedImage}
	 * to/from {@link IVideoPicture}. Note that is not the same as
	 * {@link Converter}
	 */
	private IConverter converter = null;
	/**
	 * Boolean to know if the converter is created or not.
	 */
	private boolean created = false;
	/**
	 * A list of {@link TapiesTool} to process every frame.
	 */
	private List<TapiesTool> tools = null;

	/**
	 * Called internally by {@link Converter} when audio samples are decoded
	 */
	
	protected IAudioSamples alterAudioFrame(IAudioSamples audioFrame) {
		return super.alterAudioFrame(audioFrame);
	}

	/**
	 * Called internally by {@link Converter} when a video frame is decoded.
	 */
	
	protected IVideoPicture alterVideoFrame(IVideoPicture videoFrame) {

		// If the converter is not yet created, create it.
		if (!created) {
			converter = ConverterFactory.createConverter(
					ConverterFactory.XUGGLER_BGR_24, videoFrame);
			created = true;
		}

		// For every tool, translate from IVideoPicture to BufferedImage pass
		// it, process it and translate again to IVideoPicture
		IVideoPicture tmp = videoFrame;
		for (int i = 0; i < tools.size(); i++) {
			BufferedImage bi = converter.toImage(tmp);
			tools.get(i).onVideoPicture(bi, videoFrame.getFormattedTimeStamp());
			tmp = converter.toPicture(bi, videoFrame.getTimeStamp());
		}

		return tmp;
	}

	/**
	 * Constructor
	 * 
	 * @param tools
	 *            The list of tools to process the frames.
	 */
	public TapiesConverter(List<TapiesTool> tools) {
		this.tools = tools;
	}

	/**
	 * Constructor
	 */
	public TapiesConverter() {
		this.tools = new Vector<TapiesTool>();
	}

	/**
	 * @return the converter
	 */
	public IConverter getConverter() {
		return converter;
	}

	/**
	 * @param converter
	 *            the converter to set
	 */
	public void setConverter(IConverter converter) {
		this.converter = converter;
	}

	/**
	 * @return the created
	 */
	public boolean isCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(boolean created) {
		this.created = created;
	}

	/**
	 * @return the tools
	 */
	public List<TapiesTool> getTools() {
		return tools;
	}

	/**
	 * @param tools
	 *            the tools to set
	 */
	public void setTools(List<TapiesTool> tools) {
		this.tools = tools;
	}
}
