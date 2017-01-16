package annotation;

/**
 * Created by macbook on 2017/1/16.
 */
public class Car {
    @MyAnnotation(name = "hyd",value = 1)
    public static void main(String[] args){
        System.out.println("I am main method");
    }
    @MyAnnotation(name ="hyd2",value = 2)
    public void demo(){
        System.out.println("I am demo method");
    }
}
