
package bigmoon.learning.base.functionalInterface;

/**
 函数式接口：即在函数中可以定义抽象接口，可以再接口中直接运行。java 8中新概念。 同时引入新注解：@FunctionalInterface.
 标识该接口是函数式接口，该注解非必填（建议填写）。在接口中定义抽象方法虚拟机会自动判断。
 注：

 1.函数式接口（添加FunctionalInterface）有且只有一个抽象方法,abstract
 2.实现Object 方法的抽象类不计算在函数式接口中
 3.接口中一旦存在抽象方法，jvm 编译器则默认为函数式接口
 4.接口中可以实现静态方法，直接调用静态方法
 5.接口支持 default 方法。default 不能override object 的方法（例如：toString...）.可以在子类中被调用，也可被重现
 */

public class Main implements  FunctionalInterfaceMain {

    public static void main(String[] args){
    
        System.out.println("test");
        System.out.println(FunctionalInterfaceMain.staticHello("bigmoon"));
    }

    @Override
    public void test() {
    }

}
