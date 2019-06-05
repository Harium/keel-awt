package com.harium.keel.awt.capture;

import com.harium.keel.awt.source.BufferedImageSource;
import com.harium.keel.core.source.ImageSource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RobotShotter {

    private Robot robot;
    private Rectangle rectangle;
    private BufferedImageSource source;

    public RobotShotter() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        rectangle = new Rectangle();
        source = new BufferedImageSource();
    }

    public ImageSource captureScreen(int x, int y, int width, int height) {
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;

        source.setImage(captureScreenAsImage(rectangle));
        return source;
    }

    public BufferedImage captureScreenAsImage(Rectangle rectangle) {
        return robot.createScreenCapture(rectangle);
    }

}
