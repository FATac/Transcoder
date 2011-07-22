package org.i2cat.tapies.transcoder.transco;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.i2cat.tapies.transcoder.analysis.SystemStatistics;
import org.i2cat.tapies.transcoder.entities.SubTask;
import org.i2cat.tapies.transcoder.entities.SubTaskInputParameters;
import org.i2cat.tapies.transcoder.entities.TaskInputParameters;
import org.i2cat.tapies.transcoder.entities.TranscodingTask;
import org.i2cat.tapies.transcoder.tasks.TaskManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TransLoadTest {

	private static List <String> filesToBeRemoved;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static SystemStatistics ss;
	private static TranscodingTask tt;
	private static String transcodedVideoFilePath = "rsc/tmp/";
	
	private static final int num = 5;

	/*
	 * Transcode 2 videos with each specified configuration
	 * using the task manager also check the load of the system 
	 * if that load is above the 90% the transco ends
	 */
	
	
	@BeforeClass
	public static void setUp() {
		
		ss = SystemStatistics.getInstance();
		filesToBeRemoved = new ArrayList<String>();
		
		// Generic transco properties, entity will be filled later
		File fileIn = new File("test.dv");
		tt = new TranscodingTask();
		tt.setId(0);
		SubTask subtask1 = new SubTask();

		TaskInputParameters cip = new TaskInputParameters();
		cip.setOriginalVideoPath(fileIn.getAbsolutePath());
		tt.setCommonInputParameters(cip);
		SubTaskInputParameters sip = new SubTaskInputParameters();
		

		// Audio
		sip.setAudioBitrate("128000");
		sip.setAudioChannels("2");
		sip.setAudioCodec("libfaac");
		sip.setAudioSampleRate("44100");

		// Video
		sip.setDeinterlace(true);
		sip.setFps("25");
		sip.setHeight("720");
		sip.setWidth("576");
		sip.setVideoBitrate("1000000");
		sip.setVideoCodec("libx264");
		sip.setVideoBitrateTolerance("100000");
		sip.setPresetFile("h264presets.txt");
	
		subtask1.setInparameters(sip);
		subtask1.setId(0);
		tt.putSubTask(subtask1);
	}
	
	@Test
	public void transcodeLoadCheck() {

		try {
			SafeEnqueue(num);
			// Wait until all enqueued tasks finish
			while(TaskManager.getInstance().inQueueWaiting() || 
					TaskManager.getInstance().getRunningTasks() != 0) {
				Thread.sleep(1000);
			}
			
			logger.debug("Finished, executed " + filesToBeRemoved.size() +"/" + num + " tasks");
			
		} catch (Exception e) {
			Assert.fail("I/O Exception!");
		}
	}
	
	public void SafeEnqueue(int num) throws IOException {
		
		for (int i = 0; i < num; i++){
			/*
			 *  check the load of the system if its
			 *  above of 90 % the transcode doesn't begins 
			 */
			double avgCpuLoad = ss.getSystemLoadAverage();
			
			if(avgCpuLoad < 0.9) {
				SubTask subtask = tt.getSubTask(0);
				File fileOut = new File(transcodedVideoFilePath + 
						"tmp" + i + ".mp4");
				fileOut.createNewFile();
				subtask.getInparameters().setContainer("mp4");	
				subtask.getInparameters().setOutVideoPath(fileOut.getAbsolutePath());
				filesToBeRemoved.add(fileOut.getAbsolutePath());
				tt.setId(i);
				TaskManager.getInstance().enqueueNewTask(tt);
				System.out.println("runing task " + 
						TaskManager.getInstance().getRunningTasks() );
			} else {
				logger.debug("Task not executed due CPU load: " + avgCpuLoad);
			} try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Assert.fail("InterruptedException!");
			}
		}
	}
	
	@AfterClass
	public static void cleanUp() {
		for (String filePath : filesToBeRemoved) {
			new File(filePath).delete();
		}
	}
			
	public static void main(String[] args)  {
		new TransLoadTest().transcodeLoadCheck();
	}
}
