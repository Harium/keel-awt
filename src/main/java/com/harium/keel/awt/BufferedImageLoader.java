package com.harium.keel.awt;

import com.harium.keel.awt.source.BufferedImageSource;
import com.harium.keel.core.Loader;
import com.harium.keel.core.source.ImageSource;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BufferedImageLoader implements Loader {

    @Override
    public ImageSource load(String path) {
        File file = new File(path);

        try {
            BufferedImageSource source = new BufferedImageSource();
            source.setImage(ImageIO.read(file));
            return source;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
