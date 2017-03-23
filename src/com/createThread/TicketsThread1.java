package com.createThread;

/*创建线程的两种方式：
 * 1.继承Thread类
 * 2.实现Runnable接口
 * */

//创建一个线程类
class MyThread1 implements Runnable{
	private int ticketsCount = 5;  //一共有5张火车票
	
	@Override
	public void run() {
		//如果ticketsCount不为0，说明还有火车票，可以继续卖
		while(ticketsCount > 0 ){
			ticketsCount--;
			//Thread.currentThread().getName()   获得当前线程的名字
			System.out.println(Thread.currentThread().getName() +"卖了1张票，剩余票数为"+ticketsCount);
		}
		
	}
}

public class TicketsThread1 {

	public static void main(String[] args) {
		MyThread1 mt = new MyThread1();
		//创建三个线程,来模拟三个售票窗口
		Thread th1 = new Thread(mt,"窗口1");
		Thread th2 = new Thread(mt,"窗口2");
		Thread th3 = new Thread(mt,"窗口3");
		//启动三个线程，就是三个窗口开始卖票
		th1.start();
		th2.start();
		th3.start();

	}
	
	/*
	 * 每个ticketsCount是共享的
	 * */

}
