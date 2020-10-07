package bigmoon.learning.base.lambda;

/**
 * lambda 外部变量和实例变量
 */
public class TestParam {

    //实例变量（属性）；线程共享的
    private String str1="hello";
    public static void main(String[] args) {
        TestParam test=new TestParam();
        test.test();
//        test();
    }

    public void test(){

        //局部变量，放在栈中的，是线程私有的；
//        String str1="abc";

        Runnable thread=()->{
//            当使用局部变量时时无法在lambda中修改，这样会引起线程安全问题
            //当使用实例的属性（即this）时候，时可以修改内容。线程共享数据
            str1+="abc";System.out.println(str1);};
//        str1="abcde";
        thread.run();


    }


    /**
     * 测试下lambda中的变量是否会被外界引用
     * 不会
     */
    public void test2(){
        Runnable thread=()->{
            String str2="abc";
            System.out.println(str2);
            str2+=" edf";
            System.out.println(str2);

        };
        //str2="1234";  str2 无法被lambda以外引用
        thread.run();
    }
}
