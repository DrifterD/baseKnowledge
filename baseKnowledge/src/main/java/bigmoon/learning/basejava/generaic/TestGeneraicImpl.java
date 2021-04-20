package bigmoon.learning.basejava.generaic;

/**
 * @author bigmoon
 * @date 2/10/21
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class TestGeneraicImpl implements TestGeneraic<StaticEntitySon>{

    @Override
    public StaticEntitySon generate() {
        return null;
    }

    public static void main(String[] args) {
        TestGeneraicImpl testGeneraic=new TestGeneraicImpl();
        StaticEntity staticEntity= testGeneraic.test();
        System.out.println(staticEntity.getClass());
    }
}
