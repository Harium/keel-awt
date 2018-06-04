package com.harium.keel.awt.export;

import com.harium.keel.core.export.Exporter;
import com.harium.keel.core.source.ImageSource;

import java.awt.image.BufferedImage;

public class BufferedImageExporter implements Exporter<BufferedImage> {

    @Override
    public BufferedImage export(ImageSource source) {
        BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int j = 0; j < source.getHeight(); j++) {
            for (int i = 0; i < source.getWidth(); i++) {
                image.setRGB(i, j, source.getRGB(i, j));
            }
        }

        return image;
    }
}
