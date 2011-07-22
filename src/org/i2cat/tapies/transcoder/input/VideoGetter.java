package org.i2cat.tapies.transcoder.input;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/input/VideoGetter.java $
//Revision: $Revision: 217 $
//Last modified: $Date: 2011-06-07 12:08:36 +0200 (Tue, 07 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that can acquire a remote video.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 217 $
 * 
 */
public class VideoGetter {
	/**
	 * The logger
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to get a remote video.
	 * 
	 * @param remotepath
	 *            String with the URL to download the video.
	 * @param localpath
	 *            String with the URL to save the video.
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void getVideoHTTP(String remotepath, String localpath) throws IOException {
		logger.debug("Getting " + remotepath + " and saving to "
				+ localpath);

		URL targetUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		targetUrl = new URL(remotepath);
		URLConnection connection = targetUrl.openConnection();

		try {

			bis = new BufferedInputStream( connection.getInputStream() );
			bos = new BufferedOutputStream(
					new FileOutputStream(new File(localpath) ) );

			int i;

			while ((i = bis.read()) != -1) {
				bos.write(i);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* 
			 * Be sure of closing the bis and bos instances 
			 * even if the sockets get stuck or whatever
			 */
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
