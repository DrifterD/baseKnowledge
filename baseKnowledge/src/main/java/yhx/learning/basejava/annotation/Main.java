

package yhx.learning.basejava.annotation;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args){

        TestPOJO pojo=new TestPOJO();
        Method[] methods=pojo.getClass().getDeclaredMethods();

        for(Method method:methods){

            Test testAnnotation=method.getAnnotation(Test.class);
            if(null!=testAnnotation) {
                System.out.println(testAnnotation.count() + "," + testAnnotation.value());
            }
        }



    }
}
