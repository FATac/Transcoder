package org.i2cat.tapies.transcoder.configuration;
//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/test/org/i2cat/tapies/transcoder/configuration/GetAvailableCodecTest.java $
//Revision: $Revision: 237 $
//Last modified: $Date: 2011-07-14 13:47:54 +0200 (Thu, 14 Jul 2011) $
//Modified by: $Author: javier_lopez $
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetXuggleSupportTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * List of formats available
	 */
	@Test
	public void getSupportedFormats() {
		logger.debug("getSupportedFormats()");
		List<String> s = GetXuggleSupport.getSupportedFormats();
		for (String string : s) {
			logger.debug(string);
		}
		logger.debug("getSupportedFormats() finished");
	}
	
	@Test 
	public void getSupportedVideoFormats() {
		logger.debug("getSupportedVideoFormats()");
		List<String> s = GetXuggleSupport.getSupportedVideoFormats();
		for (String string : s) {
			logger.debug(string);
		}
		logger.debug("getSupportedVideoFormats() finished");
	}
	
	@Test 
	public void getSupportedAudioFormats() {
		logger.debug("getSupportedAudioFormats()");
		List<String> s = GetXuggleSupport.getSupportedAudioFormats();
		for (String string : s) {
			logger.debug(string);
		}
		logger.debug("getSupportedAudioFormats() finished");
	}
	

	
	/*
	 * List of video codecs availables 
	 */
	@Test
	public void getVideoCodecs() {

		logger.info("Get video codecs");
		List<String> sup4 = GetXuggleSupport.getVideoSupportedCodecs();
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End video codecs\n");
	}
	
	@Test
	public void getVideoCodecsInContainer() {

		logger.info("Get video codecs in container");
		List<String> sup4 = GetXuggleSupport.getVideoSupportedCodecs("webm");
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End video codecs\n");
	}
	
	
	/*
	 * List of audio codecs availables 
	 */
	@Test
	public void getAudioCodecs() {
		logger.info("Get audio codecs");
		List<String> sup4 = GetXuggleSupport.getAudioSupportedCodecs();
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End audio codecs\n");
	}
	
	@Test
	public void getAudioCodecsInContainer() {

		logger.info("Get audio codecs in container ");
		List<String> sup4 = GetXuggleSupport.getAudioSupportedCodecs("webm");
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End audio codecs\n");
	}
	
	@Test
	public void getAudioCodecsInContainer2() {

		logger.info("Get audio codecs in container ");
		List<String> sup4 = GetXuggleSupport.getAudioSupportedCodecs("mp3");
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End audio codecs\n");
	}
	
	
	/*
	 * List of all codecs availables 
	 */
	@Test
	public void getAllCodecs() {
		logger.info("Get all codecs");
		List<String> sup4 = GetXuggleSupport.getAllSupportedCodecs();
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End all codecs\n");

	}

	@Test
	public void getSubtitleCodecs() {
		logger.info("Get subtitle codecs");
		List<String> sup4 = GetXuggleSupport.getSubtitleSupportedCodecs();
		for (int i = 0; i < sup4.size(); i++) {
			logger.debug(sup4.get(i));
		}
		logger.info("End sub codecs\n");
	}
	
	
	
	
	
}
