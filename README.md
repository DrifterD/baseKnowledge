# baseKnowledge
基础知识训练

## 线程

### 锁 Lock
这里主要介绍Lock，弱化synchronized.相比较synchronized而言，lock更有一下优点：
 1. 可以尝试获取非堵塞锁
 2.能被中断的获取锁，获取到锁的线程发生中断，则中断异常被抛出，锁被释放
 3.超时获取锁，在指定时间内获取锁，否则直接返回

一下是Lock API

|方法名称|描述|
|--------|-----|
|void lock()| 获取锁|
|voidlockInterruptibly() throws InterruptedException| 可以中断的获取锁和lock()不同之处在于该方法或响应中断，即锁的获取中可以中断当前线程|
|boolean tryLock()|尝试获取非堵塞锁，true获取成功，反之false|
|boolean tryLock(Long time,TimeUnit unit) throws Interruptibly|超时获取锁。1.当有效时间内获取锁返回；2.当超时返回；3.在超时时间内线程中断返回|
|void unlock()|释放锁|
|Condition newCondition()|获取等待通知组件，该组件和当前锁绑定，只有获取当前锁才可以调用组件的wait方法，调用后，释放锁|

锁使用的模板：

```
Lock lock=new ReentrantLock();
lock.lock();

try{
}finally{
//必须释放锁资源
lock.unlock();
}
```

#### 重入锁 ReentrantLock
该锁支持一个线程对资源的重复加锁，reentrantLock 还支持公平和非公平锁
这里介绍下ReentrantLock 自有的API




#### read write lock

