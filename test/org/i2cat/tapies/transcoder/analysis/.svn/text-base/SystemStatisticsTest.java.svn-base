package org.i2cat.tapies.transcoder.analysis;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemStatisticsTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static SystemStatistics ss;

	/* 
	 * Initialization method of the System Statistics
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		ss = SystemStatistics.getInstance();
	}

	/*
	 * Time of CPU, User and System in specified moment 
	 */
	@Test
	public void testGetCpuTimes() {
		logger.info("CPU time " + ss.getCpuTime());
		logger.info("User time " + ss.getUserTime());
		logger.info("System time " + ss.getSystemTime());

	}
	
	/*
	 * Statistics of CPU, User and System when is running our process
	 */
	@Test
	public void testGetCpuTimesRunning() {
		

		
		long cpuTime = ss.getCpuTime();
		long userTime = ss.getUserTime();
		long systemTime = ss.getSystemTime();
		
		doCpuSpinning(10000000);
		
		cpuTime = ss.getCpuTime() - cpuTime;
		userTime = ss.getUserTime() - userTime;
		systemTime = ss.getSystemTime() - systemTime;
		
		logger.info("CPU time consumed " + ss.getCpuTime());
		logger.info("User time consumed " + ss.getUserTime());
		logger.info("System time consumed " + ss.getSystemTime());
		

	}

	/*
	 * Get the load average of the system in a specified moment
	 */
	@Test
	public void testGetLoadAverage() throws IOException {
		
		double loadAverage = ss.getSystemLoadAverage();
		logger.info("loadAverage: " + loadAverage);
	
		
	}
	
	/*
	 * Consumed load average of the system when is running our process
	 */
	@Test
	public void testGetLoadAverageRunning() {
		
		double loadAverage = ss.getSystemLoadAverage();	
		doCpuSpinning(1000000000);
		loadAverage = ss.getSystemLoadAverage() - loadAverage;
		logger.info("Delta loadAverage: " + loadAverage);

	}
	
	/**
	 * Method to waste some CPU
	 * @param iterations number of iterations
	 * @throws IOException
	 */
	private void doCpuSpinning(int iterations) {
		
		int r = 1, i = 1;
				
		while (i < iterations) {
			r = ((r*i)/i); 
			i++;
		}
	}
}
