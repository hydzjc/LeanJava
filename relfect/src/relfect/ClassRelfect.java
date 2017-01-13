package relfect;
import java.lang.reflect.*;
/**
 * Created by macbook on 2017/1/13.
 * 实例化Class的方法(4种方法)
 */

public class ClassRelfect {

    private static Class c;
    private static Car car = new Car();
    private static String className = "relfect.Car";

    //实例化Class的方法(4种方法)：
    //java.lang.Class  反射的源头
    public static void createClass() throws ClassNotFoundException {
        System.out.println(" ");
        System.out.println("createClass()");
        //方法一 : 调用运行时类的.class属性
        c = Car.class;
        System.out.println("方法一 : 调用运行时类的.class属性: " + c.toString());
        //方法二 : 通过运行时类的对象，调用getClass()方法
        c = car.getClass();
        System.out.println("方法二 : 通过运行时类的对象，调用getClass()方法: "+c.toString());

        //方法三 : 调用Class的静态方法forName(String className)
        c = Class.forName(Car.class.getName().toString());
        //c = Class.forName(className);
        System.out.println("方法三 : 调用Class的静态方法forName(String className): "+c.toString());

        //方法四：通过类的加载器
//      ClassLoader classLoader = this.getClass().getClassLoader();
        ClassLoader classLoader = Car.class.getClassLoader();
        c = classLoader.loadClass(className);
        System.out.println("方法四：通过类的加载器: "+c.toString());
    }
    //创建对应的运行时类的对象
    public static void createInstance(Class c) throws Exception{
        //方法一：调用Class的newInstance方法创建运行时类的对象
        System.out.println(" ");
        System.out.println("createInstance()");
        car = (Car)c.newInstance();
        System.out.println("方法一：调用Class的newInstance方法创建运行时类的对象  --car: "+car);

        //方法二：调用指定的构造器创建运行时类的对象
        //我们指定public类型的构造方法Car(String name,int age,int id)来创建对象
        Class[] cArg = new Class[3];
        cArg[0]=String.class;
        cArg[1]=int.class;
        cArg[2]=int.class;
        Constructor constructor = c.getDeclaredConstructor(cArg);

        car = (Car) constructor.newInstance( "xxx",10,1 );
        System.out.println("方法二：调用指定的构造器(public)创建运行时类的对象 --car: "+car);

        //我们指定private类型的构造方法Car(String name)来创建对象
        constructor = c.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        car = (Car) constructor.newInstance("****");
        System.out.println("方法二：调用指定的构造器(private)创建运行时类的对象 --car: "+car);
    }
    private static void getConstructs(Class c) {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("getConstructs");
        //getConstructors  此方法为获取类的public的构造方法
        System.out.println("getConstructors为获取类的public的构造方法 ");
        Constructor[] constructors1 = c.getConstructors();
        for(int i=0;i<constructors1.length;i++){
            System.out.println("constructors ["+i+"] :"+constructors1[i]);
        }
        //getDeclaredConstructors为获取类本身自己定义的所有构造方法
        System.out.println("getDeclaredConstructors此方法为获取类本身自己定义的所有构造方法 ");
        Constructor[] constructors2 = c.getDeclaredConstructors();
        for(int i=0;i<constructors2.length;i++){
            System.out.println("constructors ["+i+"] :"+constructors2[i]);
        }
    }
    //获取类的方法
    private static void getMethods(Class c) {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("getMethods");
        //getMethods 此方法为获取类的public方法，包括父类的public方法
        System.out.println("getMethods  此方法为获取类的public方法，包括父类的public方法 ");
        Method[] method1 = c.getMethods();
        for(int i=0;i<method1.length;i++){
            System.out.println("method1 ["+i+"] :"+method1[i]);
        }

        //getDeclaredMethods  此方法为获取类本身声明的所有方法，包括private
        System.out.println(" ");
        System.out.println("getDeclaredMethods  此方法为获取类本身声明的所有方法，包括private ");
        Method[] method2 = c.getDeclaredMethods();
        for(int i=0;i<method2.length;i++){
            System.out.println("method2 ["+i+"] :"+method2[i]);
        }
    }
    //获取类的属性
    private static void GetFields(Class c) {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("GetFields");
        //getFields 此方法为获取类的public属性，包括父类的public属性
        System.out.println("getFields 此方法为获取类的public属性，包括父类的public属性 ");
        Field[] field1 = c.getFields();
        for(int i=0;i<field1.length;i++){
            System.out.println("field1 ["+i+"] :"+field1[i]);
        }

        System.out.println(" ");
        //getDeclaredFields 此方法为获取类的本身声明的所有属性，包括private
        System.out.println("getDeclaredFields 此方法为获取类的本身声明的所有属性，包括private ");
        Field[] field2 = c.getDeclaredFields();
        for(int i=0;i<field2.length;i++){
            System.out.println("field2 ["+i+"] :"+field2[i]);
        }
    }
    //获取类的其它信息，如包，父类，接口，内部类等等
    private static void getClassOtherInfo(Class c) {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("getClassOtherInfo");
        //获取类的包
        String p = c.getPackage().toString();
        System.out.println("类的包名："+p);
        //获取类的父类
        Class parentClass = c.getSuperclass();
        System.out.println("类的父类："+parentClass.getName());

        //获取类的接口
        Class[] interfaces =c.getInterfaces();
        if(interfaces.length >0){
            System.out.println("类的接口：");
            for(int i=0;i<interfaces.length;i++){
                System.out.println("interfaces["+i+"] :"+interfaces[i]);
            }
        }

        //获取类的内部类
        //getDeclaredClasses方法获取类本身定义的所有内部类，包括private
        Class[] innerClass1 =c.getDeclaredClasses();
        if(innerClass1.length >0){
            System.out.println("类的所有内部类 ，包括private：");
            for(int i=0;i<innerClass1.length;i++){
                System.out.println("innerClass1["+i+"] :"+innerClass1[i]);
            }
        }

        //同理getClasses方法获取类的public内部类，包括父类的public内部类
        Class[] innerClass2 =c.getClasses();
        if(innerClass2.length >0){
            System.out.println("类的public内部类，包括父类的public内部类：");
            for(int i=0;i<innerClass2.length;i++){
                System.out.println("innerClass2["+i+"] :"+innerClass2[i]);
            }
        }
    }

    //2.3.1 对指定构造方法进行操作
    private static void callConstruct(Class c) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("callConstruct");

        //对private类型的构造方法进行操作
        Constructor constructor1 = c.getDeclaredConstructor(String);
        constructor1.setAccessible(true);
        car = (Car)constructor1.newInstance("zsmj");
        System.out.println("car:"+car);

        //对public类型的构造方法进行操作
        Constructor constructor2 = c.getDeclaredConstructor(String.class,int.class,int.class);
        //constructor2.setAccessible(true);
        car = (Car)constructor2.newInstance("yyf",10,2);
        System.out.println("car:"+car);
    }
    //2.3.2 对指定方法进行操作
    private static void callMethod(Class c) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("callMethod");

        //1.对private类型的方法进行操作
        //getDeclaredMethod 方法获取类本身声明的方法，包括private类型的方法
        System.out.println("getDeclaredMethod 方法获取类本身声明的方法，包括private类型的方法，以setName方法为例:");
        Method m1 = c.getDeclaredMethod("setName", String.class);
        m1.setAccessible(true);
        System.out.println("修改前的person:"+car);
        m1.invoke(car, "yyf_01");
        System.out.println("修改后的person:"+car);

        //2.对public类型的方法进行操作，包括父类的方法
        //getMethod 对public类型的方法进行操作，包括父类的方法
        //2.1 以运行类的本身声明的public类型的setAge方法为例
        System.out.println("getMethod 对public类型的方法进行操作，包括父类的方法,以类本身的setAge方法为例:");
        Method m2 = c.getMethod("setAge", int.class);
        System.out.println("修改前的person:"+car);
        m2.invoke(car, 11);
        System.out.println("修改后的person:"+car);

        //2.2 以运行类的父类声明的public类型的setWeight方法为例
        System.out.println("getMethod 对public类型的方法进行操作，包括父类的方法,以父类的setWeight方法为例:");
        Method m3 = c.getMethod("setWeight", int.class);
        System.out.println("修改前的person:"+car);
        m3.invoke(car, 100);
        System.out.println("修改后的person:"+car);

        //3.对static类型的方法进行操作，以类本身的showWeather静态方法为例
        System.out.println("getMethod 对public类型的方法进行操作，包括父类的方法,以父类的showWeather方法为例:");
        Method m4 = c.getMethod("showWeather");
        m4.invoke(null);

        //4 获取指定方法的返回值,以类本身的private类型的getName方法为例
        System.out.println("获取指定方法的返回值,以类本身的private类型的getName方法为例:");
        Method m5 = c.getDeclaredMethod("getName");
        m5.setAccessible(true);
        String name = (String)m5.invoke(car);
        System.out.println("name:"+name);
    }
    //2.3.3 对指定属性进行操作
    private static void callField(Class c) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(" ");
        System.out.println("callField");

        //1.对public类型的属性进行操作，以类本身的public属性id为例:
        System.out.println("对public类型的属性进行操作，以类本身的public属性id为例");
        Field f1 = c.getField("id");
        int id = (int)f1.get(car);
        System.out.println("修改前person对象的id="+id);
        f1.set(car, 3);
        id = (int)f1.get(car);
        System.out.println("修改后person对象的id="+id);

        //2.对private类型的属性进行操作，以类本身的private属性age为例:
        System.out.println("对private类型的属性进行操作，以类本身的private属性age为例:");
        Field f2 = c.getDeclaredField("age");
        f2.setAccessible(true);
        int age = (int)f2.get(car);
        System.out.println("修改前person对象的age="+age);
        f2.set(car, 12);
        age = (int)f2.get(car);
        System.out.println("修改后person对象的age="+age);

        //3.对static类型的属性进行操作，以类本身的static属性weather为例:
        System.out.println("对static类型的属性进行操作，以类本身的static属性weather为例:");
        Field f3 = c.getDeclaredField("weather");
        f3.setAccessible(true);
        String weather = (String)f3.get(car);
        System.out.println("修改前person对象的weather="+weather);
        //f3.set(car, "今天天气好凉爽！！");
        f3.set(null, "今天天气好凉爽！！");
        weather = (String)f3.get(car);
        System.out.println("修改后person对象的weather="+weather);
    }

    public static void main(){
        ClassRelfect x = new ClassRelfect();
        //x.createClass();
    }
}


