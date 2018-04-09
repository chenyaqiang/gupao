package com.gupao.statics;

import com.gupao.statics.hungry.HungrySingleton;
import com.gupao.statics.lazy.LazyInnerClass;
import com.gupao.statics.lazy.LazySingleton;
import com.gupao.statics.register.RegisterSingleton;

import java.util.concurrent.CountDownLatch;

public class Test {
	public static void main(String[] args) {
		// 1.一般方式
		/*for (int i = 0; i < 1000; i++) {
			Thread currentThread = new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "---" + LazySingleton.getInstance());
			});
			currentThread.setName("Thread" + i);
			currentThread.start();
		}*/

		// 2.CountDownLatch(信号枪)来实现线程万箭齐发，CountDownLatch一般用在主线程等待子线程运行结束，然后再继续运行
		int count = 300;
		CountDownLatch latch = new CountDownLatch(count);
		Thread currentThread = null;
		for (int i = 0; i < count; i++) {
			currentThread = new Thread(() -> {
				try {
					// await方法会将线程阻塞在这里，知道count=0，释放所有的共享锁
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 等count=0时，会有大批的线程同时访问getInstance方法
				//System.out.println(Thread.currentThread().getName() + "---" + LazyInnerClass.getInstance());
				System.out.println(Thread.currentThread().getName() + "---" + RegisterSingleton.getInstance("com.gupao.statics.register.RegisterSingleton"));
			});
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentThread.setName("Thread" + i);
			currentThread.start();
			latch.countDown();
		}
		System.out.println("Main thread end");
	}
}
