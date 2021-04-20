# ehcache
ehcache 也是一个非常好用的内存框架，除了常规的redis必须学习之外，可以略微学习下ehcache。以备不时之需.目前使用版本是 3.8版本，较为老旧版本这里也直接跳过不学习咯。

## 环境
* ehcache v3.x
* jdk 1.8+

## 概念
### store tire
目前ehcache内存支持三种层级：heap,off-heap,disk.每个层级度可以设置大小，单位也相对灵活。主要分为对象数量和存储大小 
[原文参考]()
### expire
三种过期机制：
* 无过期机制，永远不会过期在缓存中
* time to live ttl:从创建开始固定周期时间之后自动过期
* time to idle tti:从最后一次访问开始固定周期时间之后过期；
[原文参考](https://www.ehcache.org/documentation/3.8/expiry.html)

## 
