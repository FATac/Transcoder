package org.i2cat.tapies.transcoder.transco;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/MoveThread.java $
//Revision: $Revision: 183 $
//Last modified: $Date: 2011-05-05 15:31:32 +0200 (Thu, 05 May 2011) $
//Modified by: $Author: javier_lopez $
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread to move a file.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 183 $
 * 
 */
public class MoveThread implements Runnable {

	/**
	 * File to be moved
	 */
	private File from;
	/**
	 * File to move to
	 */
	private File to;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public void run() {
		logger.debug("Moving " + from.getAbsolutePath() + " to "
				+ to.getAbsolutePath());
		from.renameTo(to);
	}

	/**
	 * Constructor
	 * 
	 * @param from
	 *            File to be moved
	 * @param to
	 *            File to move to
	 */
	public MoveThread(String from, String to) {
		this.from = new File(from);
		this.to = new File(to);
	}

}
