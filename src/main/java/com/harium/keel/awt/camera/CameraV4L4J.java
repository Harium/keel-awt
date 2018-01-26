package com.harium.keel.awt.camera;

import au.edu.jcu.v4l4j.*;
import au.edu.jcu.v4l4j.exceptions.StateException;
import au.edu.jcu.v4l4j.exceptions.V4L4JException;

import java.awt.image.BufferedImage;

/**
 * Class to abstract the V4L4j without sarxos Camera
 * <p>
 * Hint to deal with libjpeg.so.8 not found:
 * ln -s /usr/lib/libjpeg.so.62.2.0 /usr/lib/libjpeg.so.8
 */

public class CameraV4L4J implements CaptureCallback, Camera {

    /**
     * WebCam - v4l4j
     */

    private BufferedImage buffer;

    private int width = 640;
    private int height = 480;
    private int std = V4L4JConstants.STANDARD_WEBCAM;
    private int channel = 0;
    private boolean open = false;

    private String device = "/dev/video0";

    private VideoDevice videoDevice;
    private FrameGrabber frameGrabber;

    public CameraV4L4J() {
        this(0);
    }

    public CameraV4L4J(int id) {
        device = "/dev/video" + Integer.toString(id);

        try {
            initFrameGrabber();
        } catch (V4L4JException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        startCapture();

    }

    private void initFrameGrabber() throws V4L4JException {

        videoDevice = new VideoDevice(device);
        frameGrabber = videoDevice.getJPEGFrameGrabber(width, height, channel, std, 80);
        frameGrabber.setCaptureCallback(this);
        width = frameGrabber.getWidth();
        height = frameGrabber.getHeight();

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //System.out.println("Starting capture at "+width+"x"+height);
    }

    public void startCapture() {

        if (frameGrabber == null) {
            showError();
            return;
        }

        try {
            frameGrabber.startCapture();
            open = true;
        } catch (V4L4JException e) {
            showError();
            e.printStackTrace();
        }
    }

    private void showError() {
        System.err.println("Error starting the capture");
        cleanupCapture();
    }

    private void cleanupCapture() {
        try {
            frameGrabber.stopCapture();
        } catch (StateException ex) {
            // the frame grabber may be already stopped, so we just ignore
            // any exception and simply continue.
        }

        // release the frame grabber and video device
        videoDevice.releaseFrameGrabber();
        videoDevice.release();
    }

    public VideoDevice getVideoDevice() {
        return videoDevice;
    }

    public FrameGrabber getFrameGrabber() {
        return frameGrabber;
    }

    public void exceptionReceived(V4L4JException e) {
        e.printStackTrace();
    }

    public void nextFrame(VideoFrame frame) {
        buffer = frame.getBufferedImage();
        frame.recycle();
    }

    public BufferedImage getBufferedImage() {
        return buffer;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

}
