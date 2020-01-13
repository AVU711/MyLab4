package my.lab.four.service;

import my.lab.four.entity.Point;

import java.util.ArrayList;

public interface PointService {

    Point addPoint(Point point);

    ArrayList<Point> getAll();

}
