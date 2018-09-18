package com.harium.keel.awt.source;

import com.harium.keel.core.source.ImageSourceImpl;

import java.awt.image.BufferedImage;


public class BufferedImageSource extends ImageSourceImpl {

    private BufferedImage image;

    public BufferedImageSource() {
        super();
    }

    public BufferedImageSource(BufferedImage image) {
        super();
        this.image = image;
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getRGB(int x, int y) {
        return image.getRGB(x, y);
    }

    @Override
    public void setRGB(int x, int y, int rgb) {
        image.setRGB(x, y, rgb);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
