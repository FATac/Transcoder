package org.i2cat.tapies.transcoder.tasks;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/tasks/TaskExecutor.java $
//Revision: $Revision: 194 $
//Last modified: $Date: 2011-05-30 15:49:37 +0200 (Mon, 30 May 2011) $
//Modified by: $Author: javier_lopez $
import java.util.Observable;
import java.util.Observer;

import org.i2cat.tapies.transcoder.entities.Task;
import org.i2cat.tapies.transcoder.transco.NewTranscoder;
import org.i2cat.tapies.transcoder.transco.Transcoder;

/**
 * Thread to call {@link Transcoder} to execute a {@link Task}
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 194 $
 * 
 */
public class TaskExecutor extends Observable implements Runnable, Observer {

	/**
	 * The task to execute.
	 */
	private Task task;
	/**
	 * A {@link Transcoder} to execute the task.
	 */
	private NewTranscoder transcoder = new NewTranscoder();

	/**
	 * The constructor
	 * 
	 * @param task
	 *            the Task to be executed.
	 */
	public TaskExecutor(Task task) {
		this.task = task;
		transcoder.addObserver(this);
	}

	/**
	 * Method to run the thread and execute the {@link Task}.
	 */
	
	public void run() {

		try {
			transcoder.transcode(task);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * When the {@link Transcoder} ends with the Task execution will return the
	 * task to the {@link TaskExecutor} and it will return to the main
	 * {@link TaskManager}.
	 */
	
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}

}
