package com.harium.keel.awt;

import com.harium.etyl.linear.Point2D;
import com.harium.keel.feature.Component;
import com.harium.keel.feature.MaskComponent;

import java.awt.*;

public class PolygonHelper {

    public static Polygon getBoundingBox(Component component) {
        Polygon p = new Polygon();

        p.addPoint(component.getLowestX(), component.getLowestY());
        p.addPoint(component.getHighestX(), component.getLowestY());
        p.addPoint(component.getHighestX(), component.getHighestY());
        p.addPoint(component.getLowestX(), component.getHighestY());

        return p;
    }

    public static Polygon getPolygon(Component component) {

        Polygon p = new Polygon();

        for (Point2D point : component.getPoints()) {
            p.addPoint((int) point.getX(), (int) point.getY());
        }

        return p;
    }

    public static void mergePolygon(Component component, Polygon p) {
        for (int i = 0; i < p.npoints; i++) {
            Point2D point = new Point2D(p.xpoints[i], p.ypoints[i]);
            component.add(point);
        }
    }

    public static Polygon getBoundingBox(MaskComponent component) {
        Polygon p = new Polygon();

        p.addPoint(component.getLowestX(), component.getLowestY());
        p.addPoint(component.getHighestX(), component.getLowestY());
        p.addPoint(component.getHighestX(), component.getHighestY());
        p.addPoint(component.getLowestX(), component.getHighestY());

        return p;
    }

    public static void mergePolygon(MaskComponent component, Polygon p) {
        for (int i = 0; i < p.npoints; i++) {
            Point2D point = new Point2D(p.xpoints[i], p.ypoints[i]);
            component.add(point);
        }
    }

}
