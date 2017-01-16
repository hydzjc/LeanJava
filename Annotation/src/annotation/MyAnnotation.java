package annotation;
import java.lang.annotation.*;

/**
 * Created by macbook on 2017/1/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited

public @interface MyAnnotation {
    public String name();
    public int value();
}