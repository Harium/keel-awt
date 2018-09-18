package com.harium.keel.awt;

import com.harium.etyl.geometry.Point2D;
import com.harium.keel.feature.MaskFeature;
import com.harium.keel.feature.PointFeature;

import java.awt.*;

public class PolygonHelper {

    public static Polygon getBoundingBox(PointFeature feature) {
        Polygon p = new Polygon();

        p.addPoint(feature.getLowestX(), feature.getLowestY());
        p.addPoint(feature.getHighestX(), feature.getLowestY());
        p.addPoint(feature.getHighestX(), feature.getHighestY());
        p.addPoint(feature.getLowestX(), feature.getHighestY());

        return p;
    }

    public static Polygon getPolygon(PointFeature feature) {

        Polygon p = new Polygon();

        for (Point2D point : feature.getPoints()) {
            p.addPoint((int) point.getX(), (int) point.getY());
        }

        return p;
    }

    public static void mergePolygon(PointFeature feature, Polygon p) {
        for (int i = 0; i < p.npoints; i++) {
            Point2D point = new Point2D(p.xpoints[i], p.ypoints[i]);
            feature.add(point);
        }
    }

    public static Polygon getBoundingBox(MaskFeature feature) {
        Polygon p = new Polygon();

        p.addPoint(feature.getLowestX(), feature.getLowestY());
        p.addPoint(feature.getHighestX(), feature.getLowestY());
        p.addPoint(feature.getHighestX(), feature.getHighestY());
        p.addPoint(feature.getLowestX(), feature.getHighestY());

        return p;
    }

    public static void mergePolygon(MaskFeature feature, Polygon p) {
        for (int i = 0; i < p.npoints; i++) {
            Point2D point = new Point2D(p.xpoints[i], p.ypoints[i]);
            feature.add(point);
        }
    }

}
