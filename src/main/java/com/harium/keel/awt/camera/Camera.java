package com.harium.keel.awt.camera;

import java.awt.image.BufferedImage;

public interface Camera {
	
	BufferedImage getBufferedImage();

	boolean isOpen();
	
}
