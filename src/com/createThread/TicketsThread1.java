package com.createThread;

/*�����̵߳����ַ�ʽ��
 * 1.�̳�Thread��
 * 2.ʵ��Runnable�ӿ�
 * */

//����һ���߳���
class MyThread1 implements Runnable{
	private int ticketsCount = 5;  //һ����5�Ż�Ʊ
	
	@Override
	public void run() {
		//���ticketsCount��Ϊ0��˵�����л�Ʊ�����Լ�����
		while(ticketsCount > 0 ){
			ticketsCount--;
			//Thread.currentThread().getName()   ��õ�ǰ�̵߳�����
			System.out.println(Thread.currentThread().getName() +"����1��Ʊ��ʣ��Ʊ��Ϊ"+ticketsCount);
		}
		
	}
}

public class TicketsThread1 {

	public static void main(String[] args) {
		MyThread1 mt = new MyThread1();
		//���������߳�,��ģ��������Ʊ����
		Thread th1 = new Thread(mt,"����1");
		Thread th2 = new Thread(mt,"����2");
		Thread th3 = new Thread(mt,"����3");
		//���������̣߳������������ڿ�ʼ��Ʊ
		th1.start();
		th2.start();
		th3.start();

	}
	
	/*
	 * ÿ��ticketsCount�ǹ����
	 * */

}
