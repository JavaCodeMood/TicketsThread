package com.createThread;

/*�����̵߳����ַ�ʽ��
 * 1.�̳�Thread��
 * 2.ʵ��Runnable�ӿ�
 * */

//����һ���߳���
class MyThread extends Thread{
	private int ticketsCount = 5;  //һ����5�Ż�Ʊ
	private String name;   //���ڣ������̵߳�����
	
	public MyThread(String name){
		this.name = name;
	}
	
	//���������̵߳ķ���
	@Override
	public void run() {
		//���ticketsCount��Ϊ0��˵�����л�Ʊ�����Լ�����
		while(ticketsCount > 0){
			ticketsCount--;  //�������Ʊ��������һ��
			System.out.println(name +"����1��Ʊ��ʣ��Ʊ��Ϊ"+ticketsCount);
		}
		
	}
}

public class TicketsThread {

	public static void main(String[] args) {
		//����3���̣߳�ģ������������Ʊ
		MyThread mt1 = new MyThread("����1");
		MyThread mt2 = new MyThread("����2");
		MyThread mt3 = new MyThread("����3");
		
		//�����������̣߳����Ǵ��ڿ�ʼ��Ʊ
		mt1.start();
		mt2.start();
		mt3.start();

	}
	/*
	 * �ܹ�ֻ��5�Ż�Ʊ��ÿ����������5�Σ��������15��Ʊ�����ǲ������
	 * ÿ��ticketsCount�Ƕ�����  
	 * */

}
