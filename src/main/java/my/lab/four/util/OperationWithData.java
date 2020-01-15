package my.lab.four.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class OperationWithData {

    public String getResult(double x, double y, double R){
        if ((x>=0 && y>=0 && x<=R && y<=R) || (x<0 && y>0 && (x*x + y*y <= R*R/4)) || (x > 0 && y < 0 && (y <= 2*x - R))){
            return "Попадение";
        }
        else{
            return "Промах";
        }
    }
}
