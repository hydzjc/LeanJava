package relfect;

/**
 * Created by macbook on 2017/1/13.
 */
public class Car extends Wheel implements Klaxon{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int color;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int size;
    public static String sign = "大黄蜂";
    public Car(){
        super();
        System.out.print("Creat Car");
    }
    private   Car(String name){
        super();
        this.name = name;
    }
    public Car(String name,int size,int color) {
        super();
        this.name = name;
        this.size = size;
        this.color = color;
        System.out.println("Car--Car(String name,int age,int id)");
    }
    public class innerCar{

    }
    private class innerpriCar{

    }
    @Override
    public String toString() {
        return "Persion [name=" + name + ", color=" + color + ", size=" + size +",sign="+sign+ "]---"+super.toString();
    }
    //@Override
    public void speak(String talk) {
        // TODO Auto-generated method stub
        System.out.println("talk: "+ talk);
    }

}
