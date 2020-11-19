package bigmoon.learning.base.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 主要对predicate api使用
 * predicate 支持 nagate,or,and 等操作组合成复杂的predicate
 * @author bigmoon
 * @date 2020/11/12
 *
 * @return
 */
public class PredicateMain {

    public static void main(String[] args) {
        Predicate<String> predicate=item->item.equalsIgnoreCase("def");
        List<String> list=new ArrayList<>();
        list.add("asdf");
        list.add("def");
        list.add("bcd");
        //nagate predicata 操作
        list.stream().filter(predicate.negate()).forEach(item-> System.out.println(item));
        System.out.println("predicate or operation");
        list.stream().filter(predicate.or(item->item.equalsIgnoreCase("bcd"))).forEach(item-> System.out.println(item));
    }
}
