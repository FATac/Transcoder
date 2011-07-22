package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/TaskOutputResults.java $
//Revision: $Revision: 212 $
//Last modified: $Date: 2011-06-06 17:33:44 +0200 (Mon, 06 Jun 2011) $
//Modified by: $Author: javier_lopez $
import com.xuggle.xuggler.IMetaData;

/**
 * Class that wraps the output parameters that describe the output files.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 212 $
 * 
 */
public class TaskOutputResults {

	/**
	 * Average time to transcode of all the subtasks.
	 */
	private float averageTimeToTranscode;
	/**
	 * Duration of the output files.
	 */
	private float duration;
	/**
	 * Metadata of the output files. See {@link IMetaData}
	 */
	private IMetaData metaData;
	/**
	 * Where the thumbnails ara stored.
	 */
	private String thumbnails;

	/**
	 * @return the duration
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}

	/**
	 * @return the metaData
	 */
	public IMetaData getMetaData() {
		return metaData;
	}

	/**
	 * @param metaData
	 *            the metaData to set
	 */
	public void setMetaData(IMetaData metaData) {
		this.metaData = metaData;
	}

	/**
	 * @return the thumbnails
	 */
	public String getThumbnails() {
		return thumbnails;
	}

	/**
	 * @param thumbnails
	 *            the thumbnails to set
	 */
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	/**
	 * @return the averageTimeToTranscode
	 */
	public float getAverageTimeToTranscode() {
		return averageTimeToTranscode;
	}

	/**
	 * @param averageTimeToTranscode the averageTimeToTranscode to set
	 */
	public void setAverageTimeToTranscode(float averageTimeToTranscode) {
		this.averageTimeToTranscode = averageTimeToTranscode;
	}
}
