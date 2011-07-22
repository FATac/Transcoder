package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/TaskImpl.java $
//Revision: $Revision: 214 $
//Last modified: $Date: 2011-06-07 12:06:00 +0200 (Tue, 07 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.util.Set;

/**
 * A test implementation of {@link Task}
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 214 $
 * 
 */
public class TaskImpl implements Task {

	private int id;
	private TaskStatus status;

	public TaskImpl() {
		id = 0;
		status = TaskStatus.QUEUED;
	}
	
	@Override
	public TaskInputParameters getCommonInputParameters() {

		return null;
	}

	@Override	
	public void setCommonInputParameters(
			TaskInputParameters commonInputParameters) {

	}

	@Override	
	public TaskOutputResults getCommonOutputParameters() {

		return null;
	}

	@Override	
	public void setCommonOutputParameters(
			TaskOutputResults commonOutputParameters) {

	}

	@Override	
	public int getId() {

		return id;
	}

	@Override	
	public void setId(int id) {

	}

	@Override	
	public TaskStatus getStatus() {

		return status;
	}

	@Override
	public int getStatusIntValue() {
		
		return 0;
	}

	@Override
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public Set<SubTask> getSubTaskList() {
		return null;
	}

	@Override
	public SubTask getSubTask(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int putSubTask(SubTask subtask) {
		return 0;
	}
}
