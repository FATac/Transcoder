package org.i2cat.tapies.transcoder.tasks;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/tasks/TaskManager.java $
//Revision: $Revision: 221 $
//Last modified: $Date: 2011-06-07 16:01:32 +0200 (Tue, 07 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import org.i2cat.tapies.transcoder.entities.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manager to control the input/output queues of Tasks. There is one input queue
 * and one output queue.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 221 $
 * 
 */
public class TaskManager extends Observable implements Observer {

	/**
	 * integer to indicate the maximum task in the queues.
	 */
	private static final int MAX_RUNNING_TASKS = 5;

	/**
	 * The instance of this class.
	 */
	private static TaskManager instance;
	/**
	 * The logger for this class.
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * The input queue, implemented with a {@link LinkedList}
	 */
	private Queue<Task> inQueue;
	/**
	 * The output queue, implemented with a {@link LinkedList}
	 */
	private Queue<Task> outQueue;

	/**
	 * integer to indicate the number of tasks running.
	 */
	private int runningTasks;

	/**
	 * Method to get an instance of this class. Singleton, if there is not
	 * instance is created and returned.
	 * 
	 * @return the instance.
	 */
	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		return instance;
	}

	/**
	 * Constructor
	 */
	private TaskManager() {
		inQueue = new LinkedList<Task>();
		outQueue = new LinkedList<Task>();
		runningTasks = 0;
	}

	
	/**
	 * Method called when the {@link TaskExecutor} ends with a task execution.
	 * The task is placed in the output queue and executeTask is called to
	 * continue executing new tasks in the queues.
	 */

	public void update(Observable obj, Object arg) {
		if (arg instanceof Task) {
			Task task = (Task) arg;
			logger.info("Finished task......" + task.getId());
			enqueueFinnishedTask(task);
			
			/* Notify external registered Observers */
			if(countObservers() > 0) {
				logger.info("Calling observers!");
				setChanged();
				notifyObservers();
				

			}
				
//			for (int i = 0; i < task.getSubtasklist().size(); i++) {
//				logger.info("********** STATISTICS ***************");
//				logger.info("Memory consumed "
//						+ task.getSubtasklist().get(i).getOutparameters()
//								.getMemoryConsumed());
//				logger.info("Load average consumed "
//						+ task.getSubtasklist().get(i).getOutparameters()
//								.getLoadAverage());
//				logger.info("Averafe time to transco "
//						+ SystemStatistics.getInstance()
//								.averageTimeToTranscode());
//				logger.info("System load average"
//						+ SystemStatistics.getInstance().getSystemLoadAverage());
//				logger.info("Time transcode per byte"
//						+ SystemStatistics.getInstance().transcodeTimePerByte());
//				logger.info("Videos processed"
//						+ SystemStatistics.getInstance().getVideosProcessed());
//				logger.info("Average file size"
//						+ SystemStatistics.getInstance().averageFileSize());
//				logger.info("********************************");
//			}
			runningTasks--;
			executeTask();
		}
	}

	/**
	 * Method to execute the first task in the input queue. The task is executed
	 * with {@link TaskExecutor}.
	 */
	public void executeTask() {
		if (runningTasks < MAX_RUNNING_TASKS && inQueueWaiting()) {

			runningTasks++;

			try {
				Task t = getTask();
				logger.info("Launched task...." + t.getId() + ", there are "
						+ inQueue.size() + " pending tasks.");
				TaskExecutor taskExec = new TaskExecutor(t);
				taskExec.addObserver(this);

				Thread th = new Thread(taskExec);
				th.start();
			} catch (NoSuchElementException e) {
				logger.error("No more tasks on queue.");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to place a task in the input queue.
	 * 
	 * @param task
	 */
	public void enqueueNewTask(Task task) {
		inQueue.add(task);
		executeTask();
	}

	/**
	 * Method to get the first task in the input queue.
	 * 
	 * @return the first task.
	 */
	private Task getTask() {
		return inQueue.poll();
	}

	/**
	 * Method to enqueue a task in the output queue.
	 * 
	 * @param task
	 */
	public void enqueueFinnishedTask(Task task) {
		outQueue.add(task);
	}

	/**
	 * Method to get the first finished task.
	 * 
	 * @return the first finished task.
	 */
	public Task pollFinnishedTask() {
		return outQueue.poll();
	}

	/**
	 * Method to know if there are any tasks waiting in the input queue.
	 * 
	 * @return true if there are any task in the queue or false if there aren't
	 *         tasks in the queues.
	 * 
	 */
	public boolean inQueueWaiting() {
		return !inQueue.isEmpty();
	}

	/**
	 * Method to know if there are any tasks waiting in the output queue.
	 * 
	 * @return true if there are any task in the output queue or false if there
	 *         aren't tasks.
	 */
	public boolean outQueueWaiting() {
		return !outQueue.isEmpty();
	}

	/**
	 * Method to output the size of the queue
	 * 
	 * @return size of the output queue
	 */
	public int getOutputQueueSize(){
		return outQueue.size();
	}
	
	
	/**
	 * Method to get the status of the queues.
	 * 
	 * @return String with the status
	 */
	public String queueStatus() {
		return ("in: " + inQueue.size() + " out: " + outQueue.size());
	}

	/**
	 * Method to get the number of running tasks
	 * @return int with the number of tasks running on the system
	 */
	public int getRunningTasks() {
		return runningTasks;
	}
}
