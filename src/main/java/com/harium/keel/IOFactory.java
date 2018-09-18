package com.harium.keel;

import com.harium.keel.awt.BufferedImageLoader;
import com.harium.keel.awt.BufferedImageExporter;
import com.harium.keel.core.Loader;

public class IOFactory {

    public BufferedImageExporter getExporter() {
        return new BufferedImageExporter();
    }

    public Loader getLoader() {
        return new BufferedImageLoader();
    }

}
