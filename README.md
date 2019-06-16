# baseKnowledge
基础知识训练

## 泛型

### 上下边界

泛型中可以通过extends，super 实现上下边界，更多限制(& 操作符)泛型。
上下边界遵循PECS（producer extends, consumer super）规则，即生产者 extends，消费者 super

#### extends 

**只能从集合中获取类型** ，有且只能是该父级类型，其他类型编译错误。因为集合中只能知道具体类型的父级类型是指定，
且子类型可以隐式转换成父级类型
不能向集合中插入值类型，因为兄弟集合不能相互隐式转换

#### super

**只能向集合中插入对象**， 有且只能插入该下界类型或者子类（子类可以隐式转换成父类）
**不能从集合中获取对象**,无法得知集合中具体类型


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

