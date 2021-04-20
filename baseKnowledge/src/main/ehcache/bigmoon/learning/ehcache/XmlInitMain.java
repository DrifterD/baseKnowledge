package bigmoon.learning.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * @author bigmoon
 * @date 1/3/21
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class XmlInitMain {
    public static void main(String[] args) {

        XmlConfiguration xmlConfiguration=new XmlConfiguration(XmlInitMain.class.getClass().getResource("/ehcache.config.xml"));
        CacheManager cacheManager= CacheManagerBuilder.newCacheManager(xmlConfiguration);
        cacheManager.init();
        Cache<String,String> testCache=cacheManager.getCache("test",String.class,String.class);

        testCache.put("abc","abc123");
        testCache.put("a","a1");
        testCache.remove("a");
        System.out.println(testCache.get("abc"));

    }
}
