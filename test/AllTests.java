//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/test/AllTests.java $
//Revision: $Revision: 191 $
//Last modified: $Date: 2011-05-18 15:48:23 +0200 (Wed, 18 May 2011) $
//Modified by: $Author: javier_lopez $

/*
 * 
 */
import org.i2cat.tapies.transcoder.analysis.GetContainerInfoTest;
import org.i2cat.tapies.transcoder.analysis.SystemStatisticsTest;
import org.i2cat.tapies.transcoder.configuration.GetXuggleSupportTest;
import org.i2cat.tapies.transcoder.input.VideoGetterTest;
import org.i2cat.tapies.transcoder.transco.QueueTest;
import org.i2cat.tapies.transcoder.transco.TransLoadTest;
import org.i2cat.tapies.transcoder.transco.TranscoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	GetContainerInfoTest.class, 
	SystemStatisticsTest.class,
	GetXuggleSupportTest.class, 
	VideoGetterTest.class, 
	QueueTest.class, 
	TranscoTest.class,
	TransLoadTest.class
	})
public class AllTests {

}
