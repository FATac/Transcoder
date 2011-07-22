package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/TaskInputParameters.java $
//Revision: $Revision: 183 $
//Last modified: $Date: 2011-05-05 15:31:32 +0200 (Thu, 05 May 2011) $
//Modified by: $Author: javier_lopez $
import com.xuggle.xuggler.IMetaData;

/**
 * Class that wraps the input parameters of a {@link TranscodingTask}.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 183 $
 * 
 */
public class TaskInputParameters {

	/**
	 * String that says where is the original video to transcode.
	 */
	private String originalVideoPath = "";
	/**
	 * Float that says when the transcode must start.
	 */
	private float offset;
	/**
	 * Float that says how much time the transcode must last
	 */
	private float duration;
	/**
	 * The metadata of the video. See {@link IMetaData}
	 */
	private IMetaData metaData;

	/**
	 * The constructor
	 */
	public TaskInputParameters() {
		metaData = IMetaData.make();
	}

	/**
	 * @return the originalVideoPath
	 */
	public String getOriginalVideoPath() {
		return originalVideoPath;
	}

	/**
	 * @param originalVideoPath
	 *            the originalVideoPath to set
	 */
	public void setOriginalVideoPath(String originalVideoPath) {
		this.originalVideoPath = originalVideoPath;
	}

	/**
	 * @return the offset
	 */
	public float getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(float offset) {
		this.offset = offset;
	}

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

}
