package org.i2cat.tapies.transcoder.configuration;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/configuration/GetAvailableCodecs.java $
//Revision: $Revision: 234 $
//Last modified: $Date: 2011-07-05 11:04:47 +0200 (Tue, 05 Jul 2011) $
//Modified by: $Author: javier_lopez $
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainerFormat;
import com.xuggle.xuggler.ICodec.ID;

/**
 * Gives the codecs for MUX/DEMUX that XUGGLE has available.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 234 $
 */
public class GetXuggleSupport {

	/**
	 * Method that returns a list of strings that contains the supported output
	 * containers
	 * 
	 * @return a list of strings with the supported containers.
	 */
	public static List<String> getSupportedFormats() {

		Set<String> set = new HashSet<String>(getSupportedVideoFormats());
		set.addAll(getSupportedAudioFormats());
		
		List <String> ret = new Vector<String>(set);
		Collections.sort(ret);
		return ret;
	}
	
	
	public static List<String> getSupportedVideoFormats() {
		
		List<IContainerFormat> list = new Vector<IContainerFormat>(
				IContainerFormat.getInstalledOutputFormats());
		List<String> ret = new Vector<String>();
		
		for (IContainerFormat icf : list) {
			
			if (!icf.getOutputDefaultVideoCodec().equals(ID.CODEC_ID_NONE)) {
				if (!ret.contains(icf.getOutputFormatShortName()))
					ret.add(icf.getOutputFormatShortName());
				
			} else if (icf.getOutputCodecsSupported().size() > 0) {
				// Check if the list contains a VideoCodec
				boolean videoCodec = false;
				
			    for(ID id : icf.getOutputCodecsSupported()) {
			    	ICodec codec = ICodec.findEncodingCodec(id);
			    	
			    	if (codec != null && codec.canEncode() && 
			    		codec.getType().equals(ICodec.Type.CODEC_TYPE_VIDEO)) {
			    			videoCodec = true;
			    			break;
			    	}	
			    }
			    
			    if (videoCodec) {
					if (!ret.contains(icf.getOutputFormatShortName()))
						ret.add(icf.getOutputFormatShortName());
			    }

			}
			
		}
		
		Collections.sort(ret);
		return ret;
	}
	
	public static List<String> getSupportedAudioFormats() {
		
		List<IContainerFormat> list = new Vector<IContainerFormat>(
				IContainerFormat.getInstalledOutputFormats());
		List<String> ret = new Vector<String>();
		
		for (IContainerFormat icf : list) {

			if (!icf.getOutputDefaultAudioCodec().equals(ID.CODEC_ID_NONE)) {
				if (!ret.contains(icf.getOutputFormatShortName()))
					ret.add(icf.getOutputFormatShortName());
				
			} else if (icf.getOutputCodecsSupported().size() > 0) {
				// Check if the list contains a VideoCodec
				boolean audioCodec = false;
				
			    for(ID id : icf.getOutputCodecsSupported()) {
			    	ICodec codec = ICodec.findEncodingCodec(id);
			    	
			    	if (codec != null && codec.canEncode() && 
			    		codec.getType().equals(ICodec.Type.CODEC_TYPE_AUDIO)) {
			    			audioCodec = true;
			    			break;
			    	}	
			    }
			    
			    if (audioCodec) {
					if (!ret.contains(icf.getOutputFormatShortName()))
						ret.add(icf.getOutputFormatShortName());
			    }
			}

		}
		
		Collections.sort(ret);
		return ret;
	}
	

	/**
	 * Method that gives all the supported codecs.
	 * 
	 * @return a list of strings with the supported codecs
	 */
	public static List<String> getAllSupportedCodecs() {
		List<ICodec> codecs = new Vector<ICodec>(ICodec.getInstalledCodecs());
	    List<String> ret = new Vector<String>();
	    
		for (int i = 0; i < codecs.size(); i++) {
			if (codecs.get(i).canEncode()) {
				ret.add(codecs.get(i).getName());
			}
		}
		return ret;
	}
	
	/**
	 * Method that gives all the audio supported codecs.
	 * 
	 * @return a list of strings with the supported audio codecs.
	 */
	public static List<String> getAudioSupportedCodecs() {
		List<ICodec> codecs = new Vector<ICodec>(ICodec.getInstalledCodecs());
		List<String> ret = new Vector<String>();
		for (int i = 0; i < codecs.size(); i++) {
			if (codecs.get(i).getType() == com.xuggle.xuggler.ICodec.Type.CODEC_TYPE_AUDIO)
				if (codecs.get(i).canEncode()) {
					ret.add(codecs.get(i).getName());
				}
		}
		return ret;
	}

	/**
	 * Method that gives all the video supported codecs.
	 * 
	 * @return a list of strings with the supported video codecs.
	 */
	public static List<String> getVideoSupportedCodecs() {
		List<ICodec> codecs = new Vector<ICodec>(ICodec.getInstalledCodecs());
		List<String> ret = new Vector<String>();
		for (int i = 0; i < codecs.size(); i++) {
			if (codecs.get(i).getType() == com.xuggle.xuggler.ICodec.Type.CODEC_TYPE_VIDEO)
				if (codecs.get(i).canEncode()) {
					ret.add(codecs.get(i).getName());
				}
		}
		return ret;
	}

	/**
	 * Method that gives all the subtitle supported codecs.
	 * 
	 * @return a list of strings with the supported subtitle codecs.
	 */
	public static List<String> getSubtitleSupportedCodecs() {
		List<ICodec> codecs = new Vector<ICodec>(ICodec.getInstalledCodecs());
		List<String> ret = new Vector<String>();
		for (int i = 0; i < codecs.size(); i++) {
			if (codecs.get(i).getType() == com.xuggle.xuggler.ICodec.Type.CODEC_TYPE_SUBTITLE)
				if (codecs.get(i).canEncode()) {
					ret.add(codecs.get(i).getName());
				}
		}
		return ret;
	}
	
	public static List<String> getAllCodecsSupported(String shortNameContainer) {

		Set<String> set = new HashSet<String>(getVideoSupportedCodecs(shortNameContainer));
		set.addAll(getAudioSupportedCodecs(shortNameContainer));
		
		List <String> ret = new Vector<String>(set);
		Collections.sort(ret);
		return ret;
	}
	
	
	public static List<String> getAudioSupportedCodecs(String shortNameContainer) {
		
		List<String> ret = new Vector<String>();
		
	    IContainerFormat icf = IContainerFormat.make();
	    icf.setOutputFormat(shortNameContainer, null, null);
	   
	    // Get Default Codec
	    
	    if (!icf.getOutputDefaultAudioCodec().equals(ID.CODEC_ID_NONE)) {
			ret.add(ICodec.findEncodingCodec(icf.getOutputDefaultAudioCodec()).getName());
	    }
	    
	    // Get All Codecs
	    
	    if (icf.getOutputCodecsSupported().size() > 0) {
			
		    for(ID id : icf.getOutputCodecsSupported()) {
		    	ICodec codec = ICodec.findEncodingCodec(id);
		    	
		    	if (codec != null && codec.canEncode() && 
		    		codec.getType().equals(ICodec.Type.CODEC_TYPE_AUDIO)) {
		    		if (!ret.contains(codec.getName()))
						ret.add(codec.getName());
		    	}	
		    }
		}
		Collections.sort(ret);
		return ret;
		
	}
	
	public static List<String> getVideoSupportedCodecs(String shortNameContainer) {
		
		List<String> ret = new Vector<String>();
		
	    IContainerFormat icf = IContainerFormat.make();
	    icf.setOutputFormat(shortNameContainer, null, null);
	   
	    // Get Default Codec
	    
	    if (!icf.getOutputDefaultVideoCodec().equals(ID.CODEC_ID_NONE)) {
	    	ret.add(ICodec.findEncodingCodec(icf.getOutputDefaultVideoCodec()).getName());
	    }
	    
	    // Get All Codecs
	    
	    if (icf.getOutputCodecsSupported().size() > 0) {
			
		    for(ID id : icf.getOutputCodecsSupported()) {
		    	ICodec codec = ICodec.findEncodingCodec(id);
		    	
		    	if (codec != null && codec.canEncode() && 
		    		codec.getType().equals(ICodec.Type.CODEC_TYPE_VIDEO)) {
		    		if (!ret.contains(codec.getName()))
						ret.add(codec.getName());
		    	}	
		    }
		}
		Collections.sort(ret);
		return ret;
		
	}

}
