package com.harium.keel.awt.util;

import com.harium.etyl.commons.graphics.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorUtilsTest {

    @Test
    public void testEqualColors() {
        Assert.assertTrue(ColorUtils.equals(Color.WHITE, Color.WHITE));
        Assert.assertTrue(ColorUtils.equals(new Color(0, 0, 0), new Color(0, 0, 0)));
    }

    @Test
    public void testDifferentColors() {
        Assert.assertFalse(ColorUtils.equals(Color.WHITE, Color.BLACK));
        Assert.assertFalse(ColorUtils.equals(new Color(1, 0, 0), new Color(0, 0, 0)));
        Assert.assertFalse(ColorUtils.equals(new Color(0, 1, 0), new Color(0, 0, 0)));
        Assert.assertFalse(ColorUtils.equals(new Color(0, 0, 1), new Color(0, 0, 0)));
    }

}
