
package yhx.learning.base.functionalInterface;


@FunctionalInterface
public interface FunctionalInterfaceMain extends ParamInterface{

     void test();

    @Override
    String toString();

   default String toString2(){
       return "toString";
   }

    @Override
    default String hello(String name) {
        return null;
    }

    static String staticHello(String name){
       return "static hello "+name;
    }


}
