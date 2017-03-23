package com.createThread;

/*创建线程的两种方式：
 * 1.继承Thread类
 * 2.实现Runnable接口
 * */

//定义一个线程类
class MyThread extends Thread{
	private int ticketsCount = 5;  //一共有5张火车票
	private String name;   //窗口，就是线程的名字
	
	public MyThread(String name){
		this.name = name;
	}
	
	//创建启动线程的方法
	@Override
	public void run() {
		//如果ticketsCount不为0，说明还有火车票，可以继续卖
		while(ticketsCount > 0){
			ticketsCount--;  //如果还有票，就卖掉一张
			System.out.println(name +"卖了1张票，剩余票数为"+ticketsCount);
		}
		
	}
}

public class TicketsThread {

	public static void main(String[] args) {
		//创建3个线程，模拟三个窗口卖票
		MyThread mt1 = new MyThread("窗口1");
		MyThread mt2 = new MyThread("窗口2");
		MyThread mt3 = new MyThread("窗口3");
		
		//启动这三个线程，就是窗口开始卖票
		mt1.start();
		mt2.start();
		mt3.start();

	}
	/*
	 * 总共只有5张火车票，每个窗口卖了5次，结果卖出15张票，这是不合理的
	 * 每个ticketsCount是独立的  
	 * */

}
