package relfect;

/**
 * Created by macbook on 2017/1/13.
 */
public class Wheel {


    public int length;
    private  int weight;
    //@Override
    public String toString(){
        return "Wheel [length=" + length + ", weight=" + weight + "]";
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    private int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }
    public class InnerCar{

    }
}
