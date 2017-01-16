package annotation;
import java.lang.reflect.Method;

/**
 * Created by macbook on 2017/1/16.
 */
public class AnnotationParse {
    public static void main(String[] args) throws SecurityException, ClassNotFoundException{ß
        String clazz = "annotation.Car";
        Method[]  demoMethod = AnnotationParse.class.getClassLoader().loadClass(clazz).getMethods();

    for(Method method: demoMethod){
        if (method.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation carInfo = method.getAnnotation(MyAnnotation.class);
            System.out.println("method:" + method);
            System.out.println("name= " + carInfo.name() +
                            ";\n" +
                    "value =" + carInfo.value() + ";");

        }
    }

    }
}
