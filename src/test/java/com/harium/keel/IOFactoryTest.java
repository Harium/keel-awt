package com.harium.keel;

import org.junit.Assert;
import org.junit.Test;

public class IOFactoryTest {

    @Test
    public void testGet() {
        Assert.assertNotNull(new IOFactory().getExporter());
        Assert.assertNotNull(new IOFactory().getLoader());
    }

}
