/*******************************************************************************
 * Copyright (c) 2008, 2010 Xuggle Inc.  All rights reserved.
 *  
 * This file is part of Xuggle-Xuggler-Main.
 *
 * Xuggle-Xuggler-Main is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Xuggle-Xuggler-Main is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Xuggle-Xuggler-Main.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/

package org.i2cat.tapies.transcoder.transco;

//File name: $HeadURL: http://svn.i2cat.net/repos/Tapies/Transcoder/src/org/i2cat/tapies/transcoder/transco/ThumbsThread.java $
//Revision: $Revision: 183 $
//Last modified: $Date: 2011-05-05 15:31:32 +0200 (Thu, 05 May 2011) $
//Modified by: $Author: javier_lopez $
import com.xuggle.mediatool.MediaListenerAdapter;

/**
 * Make thumbnails of a given file.
 * 
 * @author $Author: javier_lopez $
 * @version $Revision: 183 $
 */

public class ThumbsThread extends MediaListenerAdapter implements Runnable {

	
	public void run() {
		// TODO Auto-generated method stub

	}
	//
	// private Random rnd = new Random();
	// private int index1 = 0;
	// private int index2 = 0;
	// private int index3 = 0;
	// private Long actualtimestamp = new Long(-1);
	// private IMediaReader reader = null;
	// private int generatedimages = 0;
	// private File smallimageA;
	// private File smallimageB;
	// private File smallimageC;
	// private File mediumimageA;
	// private File mediumimageB;
	// private File mediumimageC;
	// private File bigimageA;
	// private File bigimageB;
	// private File bigimageC;
	// private File vbigimageA;
	// private File vbigimageB;
	// private File vbigimageC;
	//
	// /**
	// * The video stream index, used to ensure we display frames from one and
	// * only one video stream from the media container.
	// */
	//
	// private int mVideoStreamIndex = -1;
	//
	// /**
	// * Construct a DecodeAndCaptureFrames which reads and captures frames from
	// a
	// * video file.
	// *
	// * @param filename
	// * the name of the media file to read
	// */
	//
	// public ThumbsThread(String from, Object video, String to) {
	// // create a media reader for processing video
	//
	// reader = ToolFactory.makeReader(from);
	//
	// // stipulate that we want BufferedImages created in BGR 24bit color
	// // space
	// reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
	//
	// // note that DecodeAndCaptureFrames is derived from
	// // MediaReader.ListenerAdapter and thus may be added as a listener
	// // to the MediaReader. DecodeAndCaptureFrames implements
	// // onVideoPicture().
	//
	// reader.addListener(this);
	//
	// // Set the random indexes to take thumbnails
	// index1 = rnd
	// .nextInt(Integer.parseInt(video.getDurationinseconds()) / 1000);
	// index2 = rnd
	// .nextInt(Integer.parseInt(video.getDurationinseconds()) / 1000);
	// index3 = rnd
	// .nextInt(Integer.parseInt(video.getDurationinseconds()) / 1000);
	//
	// // We set the files...
	//
	// // SMALL IMAGES ARE FROM 118x66
	// smallimageA = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "a_litt.png");
	// smallimageA.mkdirs();
	// smallimageB = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "b_litt.png");
	// smallimageB.mkdirs();
	// smallimageC = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "c_litt.png");
	// smallimageC.mkdirs();
	//
	// // Med are from 184x104
	// mediumimageA = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "a_med.png");
	// mediumimageA.mkdirs();
	// mediumimageB = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "b_med.png");
	// mediumimageB.mkdirs();
	// mediumimageC = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "c_med.png");
	// mediumimageC.mkdirs();
	//
	// // Big are of 400x226
	// bigimageA = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "a_big.png");
	// bigimageA.mkdirs();
	// bigimageB = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "b_big.png");
	// bigimageB.mkdirs();
	// bigimageC = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "c_big.png");
	// bigimageC.mkdirs();
	//
	// // Very bigs are of 640x360
	// vbigimageA = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "a_vbig.png");
	// vbigimageA.mkdirs();
	// vbigimageB = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "b_vbig.png");
	// vbigimageB.mkdirs();
	// vbigimageC = new File(to + "/" + video.getId() + "/" + video.getId()
	// + "c_vbig.png");
	// vbigimageC.mkdirs();
	//
	// }
	//
	// /**
	// * Called after a video frame has been decoded from a media stream.
	// * Optionally a BufferedImage version of the frame may be passed if the
	// * calling {@link IMediaReader} instance was configured to create
	// * BufferedImages.
	// *
	// * This method blocks, so return quickly.
	// */
	//
	// public void onVideoPicture(IVideoPictureEvent event) {
	//
	// try {
	// // if the stream index does not match the selected stream index,
	// // then have a closer look
	//
	// if (event.getStreamIndex() != mVideoStreamIndex) {
	// // if the selected video stream id is not yet set, go ahead an
	// // select this lucky video stream
	//
	// if (-1 == mVideoStreamIndex)
	// mVideoStreamIndex = event.getStreamIndex();
	//
	// // otherwise return, no need to show frames from this video
	// // stream
	//
	// else
	// return;
	// }
	//
	// // if uninitialized, backdate mLastPtsWrite so we get the very
	// // first frame
	//
	// // if it's time to write the next frame
	//
	// if (event.getTimeStamp(TimeUnit.SECONDS) == (index1)
	// || event.getTimeStamp(TimeUnit.SECONDS) == (index2)
	// || event.getTimeStamp(TimeUnit.SECONDS) == (index3)) {
	//
	// if (event.getTimeStamp(TimeUnit.SECONDS) > actualtimestamp) {
	//
	// BufferedImage smallimage = new BufferedImage(118, 66,
	// BufferedImage.TYPE_3BYTE_BGR);
	// BufferedImage medimage = new BufferedImage(184, 104,
	// BufferedImage.TYPE_3BYTE_BGR);
	// BufferedImage bigimage = new BufferedImage(400, 226,
	// BufferedImage.TYPE_3BYTE_BGR);
	// BufferedImage vbigimage = new BufferedImage(640, 360,
	// BufferedImage.TYPE_3BYTE_BGR);
	//
	// Graphics2D graphics2Dsmall = smallimage.createGraphics();
	// graphics2Dsmall.setRenderingHint(
	// RenderingHints.KEY_INTERPOLATION,
	// RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	// graphics2Dsmall.drawImage(event.getImage(), 0, 0, 118, 66,
	// null);
	//
	// Graphics2D graphics2Dmed = medimage.createGraphics();
	// graphics2Dmed.setRenderingHint(
	// RenderingHints.KEY_INTERPOLATION,
	// RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	// graphics2Dmed.drawImage(event.getImage(), 0, 0, 184, 104,
	// null);
	//
	// Graphics2D graphics2Dbig = bigimage.createGraphics();
	// graphics2Dbig.setRenderingHint(
	// RenderingHints.KEY_INTERPOLATION,
	// RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	// graphics2Dbig.drawImage(event.getImage(), 0, 0, 400, 226,
	// null);
	//
	// Graphics2D graphics2Dvbig = vbigimage.createGraphics();
	// graphics2Dvbig.setRenderingHint(
	// RenderingHints.KEY_INTERPOLATION,
	// RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	// graphics2Dvbig.drawImage(event.getImage(), 0, 0, 640, 360,
	// null);
	//
	// actualtimestamp = event.getTimeStamp(TimeUnit.SECONDS);
	//
	// if (generatedimages == 0) {
	// // Print A
	// ImageIO.write(smallimage, "png", smallimageA);
	// ImageIO.write(medimage, "png", mediumimageA);
	// ImageIO.write(bigimage, "png", bigimageA);
	// ImageIO.write(vbigimage, "png", vbigimageA);
	// }
	//
	// if (generatedimages == 1) {
	// // Print B
	// ImageIO.write(smallimage, "png", smallimageB);
	// ImageIO.write(medimage, "png", mediumimageB);
	// ImageIO.write(bigimage, "png", bigimageB);
	// ImageIO.write(vbigimage, "png", vbigimageB);
	// }
	// if (generatedimages == 2) {
	// // Print C
	// ImageIO.write(smallimage, "png", smallimageC);
	// ImageIO.write(medimage, "png", mediumimageC);
	// ImageIO.write(bigimage, "png", bigimageC);
	// ImageIO.write(vbigimage, "png", vbigimageC);
	// }
	// // clean up
	// graphics2Dsmall.dispose();
	// graphics2Dbig.dispose();
	// graphics2Dmed.dispose();
	// graphics2Dvbig.dispose();
	//
	// generatedimages++;
	// }
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void run() {
	// // read out the contents of the media file, note that nothing else
	// // happens here. action happens in the onVideoPicture() method
	// // which is called when complete video pictures are extracted from
	// // the media source
	//
	// while (reader.readPacket() == null)
	// do {
	// } while (false);
	//
	// }
}