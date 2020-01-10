package my.lab.four.service.impl;

import my.lab.four.entity.Point;
import my.lab.four.repository.PointRepository;
import my.lab.four.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Point addPoint(Point point) {
        return pointRepository.saveAndFlush(point);
    }

}
