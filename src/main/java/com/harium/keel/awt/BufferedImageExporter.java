package com.harium.keel.awt;

import com.harium.keel.core.Exporter;
import com.harium.keel.core.source.ImageSource;

import java.awt.image.BufferedImage;

public class BufferedImageExporter implements Exporter<BufferedImage> {

    @Override
    public BufferedImage export(ImageSource source) {
        BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                image.setRGB(x, y, source.getRGB(x, y));
            }
        }

        return image;
    }
}
