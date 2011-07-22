package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/Task.java $
//Revision: $Revision: 214 $
//Last modified: $Date: 2011-06-07 12:06:00 +0200 (Tue, 07 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.util.Set;

import org.i2cat.tapies.transcoder.transco.Transcoder;

/**
 * Interface that represents the methods that a Task have to implement. A Task
 * will be executed by {@link Transcoder}.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 214 $
 * 
 */
public interface Task {
	
    public enum TaskStatus {QUEUED, IN_PROCESS, PROCESSED_OK, PROCESSED_WITH_PROBLEMS, SRC_NOT_FOUND }
	
	public TaskInputParameters getCommonInputParameters();

	public void setCommonInputParameters(
			TaskInputParameters commonInputParameters);

	public TaskOutputResults getCommonOutputParameters();

	public void setCommonOutputParameters(
			TaskOutputResults commonOutputParameters);

	public int getId();

	public void setId(int id);

	public int putSubTask(SubTask subtask);
	
	public SubTask getSubTask(int id);
	
	public Set<SubTask> getSubTaskList();

	public TaskStatus getStatus();
	
	public int getStatusIntValue();

	public void setStatus(TaskStatus status);
	
//	public List<TapiesTool> getTools();
//
//	public int putTool(TapiesTool tool);
//	
//	public void clearTools();
//	
//	public void cleanConfigTools();
	
	
}
