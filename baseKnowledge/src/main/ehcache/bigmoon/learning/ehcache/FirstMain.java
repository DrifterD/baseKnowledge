package bigmoon.learning.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.CacheManagerConfiguration;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import sun.lwawt.macosx.CSystemTray;

import java.io.File;

/**
 * @author bigmoon
 * @date 12/30/20
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class FirstMain {

    public static void main(String[] args) {

//        persistentCache();
        defaultCache();

    }

    private static void defaultCache() {

        //创建 preConfigured 缓存,10对象,如果超过则之前的会被摒弃
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class,
                                ResourcePoolsBuilder.heap(10))
                                .build())
                .build(true); //在此之前创立的缓存管理并未初始化，所以这里必须初始化。或者
//        使用CacheManagerBuilder.init()

        Cache<Integer, String> preConfiguredCache = cacheManager.getCache("preConfigured", Integer.class, String.class);

        for (int x = 0; x < 14; x++) {
            preConfiguredCache.put(x, "value" + x);
        }

        System.out.println("-------------------------------");
        for (int x = 0; x < 14; x++) {
            System.out.println(preConfiguredCache.get(x));
        }
    }

    /**
     * 持久化缓存策略
     * 支持超出部分序列化到磁盘中
     */
    private static void persistentCache(){

        CacheManager cacheManager=CacheManagerBuilder.newCacheManagerBuilder().
                with(CacheManagerBuilder.persistence(
                new File(FirstMain.class.getClassLoader().getResource("").getPath(), "myData")))
                .withCache("persistence",CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,String.class,
                        ResourcePoolsBuilder.heap(1).offheap(1, MemoryUnit.MB).disk(100,MemoryUnit.MB,true))).build(true);

        Cache<String,String> cache=cacheManager.getCache("persistence",String.class,String.class);

        if(cache.get("test")!=null){
            System.out.println("直接从磁盘加载上来的");
            System.out.println("result="+cache.get("test"));
        }else{
            System.out.println("没有这个key数据，手动添加一个");
            cache.put("test","看看还在不在");
            System.out.println("result="+cache.get("test"));
        }
        cacheManager.close();
    }

}
