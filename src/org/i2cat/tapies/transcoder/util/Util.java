package org.i2cat.tapies.transcoder.util;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/util/Util.java $
//Revision: $Revision: 205 $
//Last modified: $Date: 2011-06-03 21:25:16 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.io.File;
import java.util.List;
import java.util.Vector;

import org.i2cat.tapies.transcoder.entities.SubTaskInputParameters;

/**
 * Util class for Tapies Transcoder.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 205 $
 * 
 */
public class Util {
	/**
	 * Given a path to a file returns the extension of the file.
	 * 
	 * @param path
	 *            Path to the given file.
	 * @return the extension of the given file.
	 */
	public static String getExtension(String path) {
		File f = new File(path);
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (f.isDirectory())
			ext = null;
		else if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	/**
	 * Parse a {@link SubTaskInputParameters} and returns a string array with
	 * the parameters parse in a manner that xuggle can understand.
	 * 
	 * @param sip
	 * @return
	 */
	public static String[] parseParameters(SubTaskInputParameters sip) {

		List<String> parameterlist = new Vector<String>();
		// General parameters
		if (sip.getContainer() != null && !sip.getContainer().isEmpty()) {
			parameterlist.add("--containerformat");
			parameterlist.add(sip.getContainer());
		}

		// Audio parameters
		if (sip.getAudioBitrate() != null && !sip.getAudioBitrate().isEmpty()) {
			parameterlist.add("--abitrate");
			parameterlist.add(sip.getAudioBitrate());
		}

		if (sip.getAudioCodec() != null && !sip.getAudioCodec().isEmpty()) {
			parameterlist.add("--acodec");
			parameterlist.add(sip.getAudioCodec());
		}

		if (sip.getAudioChannels() != null && !sip.getAudioChannels().isEmpty()) {
			parameterlist.add("--achannels");
			parameterlist.add(sip.getAudioChannels());
		}

		if (sip.getAudioSampleRate() != null
				&& !sip.getAudioSampleRate().isEmpty()) {
			parameterlist.add("--asamplerate");
			parameterlist.add(sip.getAudioSampleRate());
		}

		// Video parameters

		if (sip.getVideoCodec() != null && !sip.getVideoCodec().isEmpty()) {
			parameterlist.add("--vcodec");
			parameterlist.add(sip.getVideoCodec());
		}
		if (sip.getVideoBitrate() != null && !sip.getVideoBitrate().isEmpty()) {
			parameterlist.add("--vbitrate");
			parameterlist.add(sip.getVideoBitrate());
		}

		if (sip.getVideoBitrateTolerance() != null
				&& !sip.getVideoBitrateTolerance().isEmpty()) {
			parameterlist.add("--vbitratetolerance");
			parameterlist.add(sip.getVideoBitrateTolerance());
		}
			
		if (sip.getWidth() != null && sip.getHeight() != null ) {
			parameterlist.add("--vresolution");
			parameterlist.add(sip.getWidth() + ":" + sip.getHeight());
		}

		if (sip.getPresetFile() != null && !sip.getPresetFile().isEmpty()) {
			parameterlist.add("--vpreset");
			parameterlist.add(sip.getPresetFile());
		}

		return parameterlist.toArray(new String[0]);

	}

}
