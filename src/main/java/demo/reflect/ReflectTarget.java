package demo.reflect;

/**
 * Created by jjj
 * at 2020-05-22
 **/
public class ReflectTarget {
    public String name;
    protected String protect;
    private String privat;
    public void show1(String s){
        System.out.println("调用了公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了默认的，无参的show3()");
    }
    private String show4(int index){
        System.out.println("调用了私有的，并且有返回值的，int参数的show4(): index = " + index);
        return "show4result";
    }
    public ReflectTarget(String str) {
        System.out.println("this is param str construct");
    }

    public ReflectTarget() {
        System.out.println("this is default construct");
    }

    private  ReflectTarget(int index) {
        System.out.println("private construct");
    }

    protected  ReflectTarget(int index,String str) {
        System.out.println("protected construct");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //获取class的方式1
        ReflectTarget reflectTarget = new ReflectTarget();
        Class target = reflectTarget.getClass();
        //获取class的方式2
        Class target2 = ReflectTarget.class;
        //获取class的方式3
        Class target3 = Class.forName("demo.reflect.ReflectTarget");
        //运行中 一个类只有一个class对象产生
    }
}
