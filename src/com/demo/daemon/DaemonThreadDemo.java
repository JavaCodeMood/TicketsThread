package com.demo.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/*线程分为两类：
 * 1.用户线程
 * 2.守护线程
 * 
 * */

//定义一个线程类
class DaemonThread implements Runnable{
	@Override
	public void run() {
		System.out.println("进入守护线程"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程"+Thread.currentThread().getName());
		
	}
	
	//该方法实现向文件中写数据
	private void writeToFile() throws Exception{
		//创建文件对象
		File filename = new File("E:"+File.separator+"test.txt");
		//向文件中写数据
		OutputStream os = new FileOutputStream(filename,true);
		int count = 0;  //每写一次数据，count就++
		while(count < 999){
			os.write(("\r\nJava Thread"+count).getBytes());
			System.out.println("守护线程"+ Thread.currentThread().getName()+"向文件中写入了Java Thread"+count++);
			Thread.sleep(10000);  //休眠1秒  每隔一秒写一次数据
		}
	}
}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("程序进入了主线程"+Thread.currentThread().getName());
		DaemonThread daemonThread = new DaemonThread();
		Thread thread = new Thread(daemonThread);
		thread.setDaemon(true);   //设置为守护线程
		thread.start();   //守护线程启动
		
		//阻塞线程
		Scanner sc = new Scanner(System.in);
		sc.next();
		
		System.out.println("程序退出了主线程"+Thread.currentThread().getName());

	}

}
