package bigmoon.learning.basejava.generaic;

/**
 * @author bigmoon
 * @date 2/10/21
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public interface TestGeneraic<T extends StaticEntity> {

    default T test(){
       return (T)T.newInstance("abc",1);
    }

    T generate();
}
