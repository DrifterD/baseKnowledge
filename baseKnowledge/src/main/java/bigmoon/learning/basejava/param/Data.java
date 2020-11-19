package bigmoon.learning.basejava.param;

import java.util.StringJoiner;

/**
 * @author
 * @date 2020/11/19
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class Data {

    int a;
    int b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Data.class.getSimpleName() + "[", "]")
                .add("a=" + a)
                .add("b=" + b)
                .toString();
    }
}
