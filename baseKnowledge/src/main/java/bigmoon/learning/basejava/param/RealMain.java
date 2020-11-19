package bigmoon.learning.basejava.param;

/**
 * @author
 * @date 2020/11/19
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class RealMain {


    public static void main(String[] args) {

        Integer a=300,b=500;
        int a1=30,b1=50;
        System.out.println("--------------------------值类型变更-----------------------------");
        System.out.println("原始基本a=:"+a+",b=："+b);
        System.out.println("原始基本a1=:"+a1+",b1=："+b1);
        realParam(a,b);
        realParam2(a1,b1);
        System.out.println("执行后基本引用a=:"+a+",b=："+b);
        System.out.println("执行后基本a=:"+a1+",b=："+b1);
    }



    /**
     * 引用 new赋值类型
     *
     * @return
     */
    public static void realParam(Integer a,Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
        System.out.println("函数内值：a="+a+",b="+b);
    }

    /**
     * 引用 new赋值类型
     *
     * @return
     */
    public static void realParam2(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("函数内值：a="+a+",b="+b);
    }
}
