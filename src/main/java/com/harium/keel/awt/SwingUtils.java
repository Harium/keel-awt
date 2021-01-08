package com.harium.keel.awt;

import com.harium.keel.core.source.ImageSource;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingUtils {

  public static void openDialog(BufferedImage image) {
    ImageIcon wrapper = new ImageIcon(image);

    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(new JLabel(wrapper));
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void openDialog(ImageSource imageSource) {
    BufferedImage image = new BufferedImage(imageSource.getWidth(), imageSource.getHeight(),
        BufferedImage.TYPE_INT_RGB);
    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        image.setRGB(x, y, imageSource.getRGB(x, y));
      }
    }
    openDialog(image);
  }

}
