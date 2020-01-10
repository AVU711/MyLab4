package my.lab.four.repository;

import my.lab.four.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point,Integer> {
}
