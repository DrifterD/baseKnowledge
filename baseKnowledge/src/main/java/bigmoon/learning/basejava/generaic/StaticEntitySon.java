package bigmoon.learning.basejava.generaic;

/**
 * @author bigmoon
 * @date 2/10/21
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class StaticEntitySon extends StaticEntity {

    private int test;


    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public StaticEntitySon(String name, int age) {
        super(name,age);
        this.test=1000;
    }



}
