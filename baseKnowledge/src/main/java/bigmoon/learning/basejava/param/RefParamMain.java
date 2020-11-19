package bigmoon.learning.basejava.param;

/**
 * @author
 * @date 2020/11/19
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class RefParamMain {

    public static void main(String[] args) {
        Data data=new Data(10,500);
//        System.out.println("前："+data);
//        refParam(data);
//        System.out.println("后:"+data);

        //----------------------引用new-------------------

        System.out.println("前："+data);
        Data result=refNewParam(data);
        System.out.println("后:"+data);
        System.out.println("后返回值:"+result);

    }


    /**
     * 引用类型
     *
     * @param data
     * @return
     */
    public static Data refParam(Data data) {
        int tmp = data.a;
        data.a = data.b;
        data.b = tmp;
        return data;
    }

    /**
     * 引用 new赋值类型
     *
     * @param data
     * @return
     */
    public static Data refNewParam(Data data) {
        Data data1 = new Data(data.b, data.a);
        data = data1;
        return data;
    }

}
