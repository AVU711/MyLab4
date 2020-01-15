package my.lab.four.util;

import my.lab.four.entity.Point;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PointsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Point.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Point point = (Point) o;
        try{
            Double x = Double.parseDouble(point.getX());
        }catch (NumberFormatException e){
            errors.rejectValue("x", "", "Неверно задана координата X");
        }
        try {
            Double y = Double.parseDouble(point.getY());
            if (!((y > -3) && (y < 3))){
                errors.rejectValue("y", "", "Значение должно быть между -3 и 3");
            }
        }catch (NumberFormatException e){
            errors.rejectValue("y", "", "Неверно задана координата Y");
        }
        try{
            Double R = Double.parseDouble(point.getR());
        }catch (NumberFormatException | NullPointerException e){
            errors.rejectValue("R", "", "Неверно задан параметр R");
        }
    }
}
