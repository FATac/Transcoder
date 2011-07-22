package org.i2cat.tapies.transcoder.analysis;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/analysis/GetContainerInfo.java $
//Revision: $Revision: 202 $
//Last modified: $Date: 2011-06-03 21:17:18 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;
import com.xuggle.xuggler.IContainer.Type;

/**
 * Get the media's information in a container.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 202 $
 * 
 */
public class GetContainerInfo {

	/**
	 * private instance of logger of this class.
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Check if a file is or not a video 
	 * 
	 * @param file 
	 * 			  String with the path to the file to analyze.
	 * @return boolean
	 * 			  True if can open the file and if the file is or not a video
	 */
	public boolean checkContainer(String file) {
		
		IContainer container = IContainer.make();

		if (container.open(file, Type.READ, null) < 0) {
			return false;
		}
		return true;
		
	}
	
	public Properties getResolution(String file) throws Exception {
		
		IContainer container = IContainer.make();
		if (container.open(file, Type.READ, null) < 0) {
				throw new IOException("Could not find the file");
		}
		
		// Access to the container info
		int numStreams = container.getNumStreams();
		
		int i = 0;
		// and iterate through the streams to print their meta data
		while(i < numStreams) {
			// Find the stream object
			IStream stream = container.getStream(i);
			// Get the pre-configured decoder that can decode this stream;
			IStreamCoder coder = stream.getStreamCoder();
			if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {
				logger.debug("width:" + coder.getWidth());
				logger.debug("height:" + coder.getHeight());
				
				Properties prop = new Properties();
				prop.put("width", coder.getWidth());
				prop.put("height", coder.getHeight());
				return prop;
			}
			i++;
		}
		throw new Exception("The file is not a video");
	}
	
	
	/**
	 * Give the information of the streams that are in the specified file.
	 * 
	 * @param file
	 *            String with the path to the file to analyze.
	 * @throws IOException 
	 */
	public void printInfo(String file) throws IOException {
		// Open container with xuggle API
		IContainer container = IContainer.make();
		if (container.open(file, Type.READ, null) < 0) {
				throw new IOException("Could not find the file");
		}		
		
		// Access to the container info
		int numStreams = container.getNumStreams();

		// Print the information with the logger
		logger.debug("File " + file + " has " + numStreams + " streams");
		logger.debug("Duration(ms)" + container.getDuration() / 1000);
		logger.debug("Start time(ms)" + container.getStartTime() / 1000);
		logger.debug("file size (bytes)" + container.getFileSize());
		logger.debug("bit rate:" + container.getBitRate());

		// and iterate through the streams to print their meta data
		for (int i = 0; i < numStreams; i++) {
			// Find the stream object
			IStream stream = container.getStream(i);
			// Get the pre-configured decoder that can decode this stream;
			IStreamCoder coder = stream.getStreamCoder();

			// and now print out the meta data.
			logger.debug("stream " + i);
			logger.debug("type: " + coder.getCodecType());
			logger.debug("codec:" + coder.getCodecID());
			logger.debug("Duration(ms)" + stream.getDuration() / 1000);
			logger.debug("Start time(ms)" + stream.getStartTime() / 1000);

			logger.debug("language: " + stream.getLanguage());
			logger.debug("timebase: " + stream.getTimeBase().getNumerator()
					+ "/" + stream.getTimeBase().getDenominator());
			logger.debug("coder tb: " + coder.getTimeBase().getNumerator()
					+ "/" + coder.getTimeBase().getDenominator());

			if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {
				logger.debug("sample rate:" + coder.getSampleRate());
				logger.debug("channels:" + coder.getChannels());
				logger.debug("format: " + coder.getSampleFormat());
			} else if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {
				logger.debug("width:" + coder.getWidth());
				logger.debug("height:" + coder.getHeight());
				logger.debug("format:  " + coder.getPixelType());
				logger.debug("frame-rate: " + coder.getFrameRate().getDouble());
			}
		}
	}
}
