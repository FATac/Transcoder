package org.i2cat.tapies.transcoder.entities;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/entities/SubTaskOutputResults.java $
//Revision: $Revision: 212 $
//Last modified: $Date: 2011-06-06 17:33:44 +0200 (Mon, 06 Jun 2011) $
//Modified by: $Author: javier_lopez $
import java.util.List;
import java.util.Vector;

/**
 * Parameters that gives a description of the generated video. This can allow to
 * check if the transcoding process will result OK.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 212 $
 * 
 */
public class SubTaskOutputResults {

	/**
	 * The filesize of the output file.
	 */
	private float filesize;
	/**
	 * The url where the video is stored.
	 */
	private String url;
	/**
	 * The video codec of the output file.
	 */
	private String videoCodec;
	/**
	 * The audio codec of the output file.
	 */
	private String audioCodec;
	/**
	 * The width of the output file.
	 */
	private int width;
	/**
	 * The height of the output file.
	 */
	private int height;
	/**
	 * The audio bitrate of the output file.
	 */
	private float audioBitrate;
	/**
	 * The video bitrate of the output file.
	 */
	private float videoBitrate;
	/**
	 * The audio bitrate of the output file.
	 */
	private int audioSampleRate;
	/**
	 * The time that has happened to transcode
	 * 
	 **/
	private float timetotranscode;
	/**
	 * The CPU consumed to do the transcode.
	 */
	private float cpuConsumed;
	/**
	 * The memory consumed to do the transcode.
	 */
	private long memoryConsumed;
	/**
	 * The average PSNR of the output video compared with the original video.
	 */
	private double psnr;
	/**
	 * A list of String containing the errors occurred during the transcode.
	 */
	private List<String> errors = new Vector<String>();
	/**
	 * Represent the load average consumed by the transcoding process.
	 */
	private double loadAverage;

	/**
	 * Represent the load averaged by the file size.
	 */
	private float loadByByte;
	
	private float memoryConsumedByByte;

	/**
	 * @return the loadByByte
	 */
	public float getLoadByByte() {
		return loadByByte;
	}

	/**
	 * @param loadByByte the loadByByte to set
	 */
	public void setLoadByByte(float loadByByte) {
		this.loadByByte = loadByByte;
	}

	/**
	 * @return the memoryConsumedByByte
	 */
	public float getMemoryConsumedByByte() {
		return memoryConsumedByByte;
	}

	/**
	 * @param memoryConsumedByByte the memoryConsumedByByte to set
	 */
	public void setMemoryConsumedByByte(float memoryConsumedByByte) {
		this.memoryConsumedByByte = memoryConsumedByByte;
	}

	/**
	 * @return the loadAverage
	 */
	public double getLoadAverage() {
		return loadAverage;
	}

	/**
	 * @param loadAverage
	 *            the loadAverage to set
	 */
	public void setLoadAverage(double loadAverage) {
		this.loadAverage = loadAverage;
	}

	/**
	 * @return the filesize
	 */
	public float getFilesize() {
		return filesize;
	}

	/**
	 * @param filesize
	 *            the filesize to set
	 */
	public void setFilesize(float filesize) {
		this.filesize = filesize;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the videoCodec
	 */
	public String getVideoCodec() {
		return videoCodec;
	}

	/**
	 * @param videoCodec
	 *            the videoCodec to set
	 */
	public void setVideoCodec(String videoCodec) {
		this.videoCodec = videoCodec;
	}

	/**
	 * @return the audioCodec
	 */
	public String getAudioCodec() {
		return audioCodec;
	}

	/**
	 * @param audioCodec
	 *            the audioCodec to set
	 */
	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the audioBitrate
	 */
	public float getAudioBitrate() {
		return audioBitrate;
	}

	/**
	 * @param audioBitrate
	 *            the audioBitrate to set
	 */
	public void setAudioBitrate(float audioBitrate) {
		this.audioBitrate = audioBitrate;
	}

	/**
	 * @return the videoBitrate
	 */
	public float getVideoBitrate() {
		return videoBitrate;
	}

	/**
	 * @param videoBitrate
	 *            the videoBitrate to set
	 */
	public void setVideoBitrate(float videoBitrate) {
		this.videoBitrate = videoBitrate;
	}

	/**
	 * @return the audioSampleRate
	 */
	public int getAudioSampleRate() {
		return audioSampleRate;
	}

	/**
	 * @param audioSampleRate
	 *            the audioSampleRate to set
	 */
	public void setAudioSampleRate(int audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
	}

	/**
	 * @return the timetotranscode
	 */
	public float getTimetotranscode() {
		return timetotranscode;
	}

	/**
	 * @param timetotranscode
	 *            the timetotranscode to set
	 */
	public void setTimetotranscode(float timetotranscode) {
		this.timetotranscode = timetotranscode;
	}

	/**
	 * @return the cpuConsumed
	 */
	public float getCpuConsumed() {
		return cpuConsumed;
	}

	/**
	 * @param cpuConsumed
	 *            the cpuConsumed to set
	 */
	public void setCpuConsumed(float cpuConsumed) {
		this.cpuConsumed = cpuConsumed;
	}

	/**
	 * @return the memoryConsumed
	 */
	public long getMemoryConsumed() {
		return memoryConsumed;
	}

	/**
	 * @param memoryConsumed
	 *            the memoryConsumed to set
	 */
	public void setMemoryConsumed(long memoryConsumed) {
		this.memoryConsumed = memoryConsumed;
	}

	/**
	 * @return the psnr
	 */
	public double getPsnr() {
		return psnr;
	}

	/**
	 * @param psnr
	 *            the psnr to set
	 */
	public void setPsnr(double psnr) {
		this.psnr = psnr;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void addError(String error) {
		errors.add(error);
	}

}
