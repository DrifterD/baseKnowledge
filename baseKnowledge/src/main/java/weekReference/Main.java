package weekReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args){

        System.out.println(testWeek());

    }

    static String testWeek(){
        String a="a";

        WeakReference<String> b=new WeakReference<String>(a);
        WeakHashMap<String,Integer> map=new WeakHashMap<>();
        map.put(b.get(),1);
        a=null;
        System.gc();
        String c="";
        try{
            c = b.get().replace("a", "b");
            return c;
        }catch (Exception ex){
            c="c";
            return c;
        }finally{
            c+="d";
            return c+"e";
        }
    }

    static String PhantomReference(){

        String a="a";
        //PhantomReference<String> pr=new PhantomReference<String >(a);
        return a;
    }

}
