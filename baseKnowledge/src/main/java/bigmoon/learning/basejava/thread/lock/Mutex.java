/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: Mutex.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock {

	private static class Sync extends AbstractQueuedSynchronizer{

		@Override
		protected boolean tryAcquire(int arg) {
			if(compareAndSetState(0,1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			if(getState()==0){
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected int tryAcquireShared(int arg) {
			// TODO Auto-generated method stub
			return super.tryAcquireShared(arg);
		}

		@Override
		protected boolean tryReleaseShared(int arg) {
			// TODO Auto-generated method stub
			return super.tryReleaseShared(arg);
		}

		@Override
		protected boolean isHeldExclusively() {
			return getState()==1;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
		Condition newCondition(){return new ConditionObject();}
		
	}
	
	private final Sync sync=new Sync();
	
	public void lock() {
		sync.acquire(1);
		
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
		
	}

	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, time);
	}

	public void unlock() {
		sync.release(1);		
	}

	public Condition newCondition() {
		return sync.newCondition();
	}

}
