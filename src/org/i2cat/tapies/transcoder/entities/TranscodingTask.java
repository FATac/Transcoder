package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/TranscodingTask.java $
//Revision: $Revision: 214 $
//Last modified: $Date: 2011-06-07 12:06:00 +0200 (Tue, 07 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.util.HashSet;
import java.util.Set;

import org.i2cat.tapies.transcoder.transco.Transcoder;

/**
 * Task that will be executed by {@link Transcoder}. One Task can have N
 * {@link SubTask}, that have the same original file, but different transcode
 * parameters.
 * 
 * The common parameters are defined in this class. The specific parameters of
 * every transcode are specified in the class {@link SubTask}.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 214 $
 * 
 */
public class TranscodingTask implements Task {

	/**
	 * The common input parameters wrapped in a {@link TaskInputParameters}
	 */
	private TaskInputParameters commonInputParameters = new TaskInputParameters();

	/**
	 * The common output parameters wrapped in a {@link TaskOutputResults}
	 */
	private TaskOutputResults commonOutputParameters = new TaskOutputResults();
	/**
	 * The id of the {@link TranscodingTask}
	 */
	private int id;
	/**
	 * The list of {@link SubTask} that has the {@link TranscodingTask}
	 */
	private Set<SubTask> subtasklist = new HashSet<SubTask>();
	/**
	 * The status of the task.
	 */
	private TaskStatus status = TaskStatus.QUEUED;

	/**
	 * @return the commonInputParameters
	 */
	@Override
	public TaskInputParameters getCommonInputParameters() {
		return commonInputParameters;
	}

	/**
	 * @param commonInputParameters
	 *            the commonInputParameters to set
	 */
	@Override
	public void setCommonInputParameters(
			TaskInputParameters commonInputParameters) {
		this.commonInputParameters = commonInputParameters;
	}


	/**
	 * @return the commonOutputParameters
	 */
	@Override
	public TaskOutputResults getCommonOutputParameters() {
		return commonOutputParameters;
	}

	/**
	 * @param commonOutputParameters
	 *            the commonOutputParameters to set
	 */
	@Override
	public void setCommonOutputParameters(
			TaskOutputResults commonOutputParameters) {
		this.commonOutputParameters = commonOutputParameters;
	}

	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	@Override
	public TaskStatus getStatus() {
		return status;
	}
	@Override
	public int getStatusIntValue() {
		return status.ordinal();
	}

	/**
	 * @param status
	 *            the status to set
	 */
	@Override
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	@Override
	public Set<SubTask> getSubTaskList() {
		return subtasklist;
	}
	@Override
	public SubTask getSubTask(int id) {
		for (SubTask s : subtasklist) {
			if (s.getId() == id)
				return s;
		}
		return null;
	}
	@Override
	public int putSubTask(SubTask subtask) {
		
		subtasklist.add(subtask);
		return 0;
	}
	
	



}
