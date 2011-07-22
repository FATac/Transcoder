package org.i2cat.tapies.transcoder.analysis;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/test/org/i2cat/tapies/transcoder/analysis/GetContainerInfoTest.java $
//Revision: $Revision: 207 $
//Last modified: $Date: 2011-06-03 21:35:16 +0200 (Fri, 03 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.io.IOException;

import org.junit.Test;


public class GetContainerInfoTest {

	/*
	 * Take the info of the container 
	 */
	@Test
	public void getContainerInfo() throws IOException {
		GetContainerInfo info = new GetContainerInfo();
		info.printInfo("test.dv");
	}

}
