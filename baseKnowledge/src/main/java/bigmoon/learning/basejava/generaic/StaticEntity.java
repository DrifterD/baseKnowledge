package bigmoon.learning.basejava.generaic;

/**
 * @author bigmoon
 * @date 2/10/21
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class StaticEntity {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static StaticEntity newInstance(String name, int age){
       return new StaticEntity(name,age);
    }

    protected StaticEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
