package com.demo.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/*�̷߳�Ϊ���ࣺ
 * 1.�û��߳�
 * 2.�ػ��߳�
 * 
 * */

//����һ���߳���
class DaemonThread implements Runnable{
	@Override
	public void run() {
		System.out.println("�����ػ��߳�"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�˳��ػ��߳�"+Thread.currentThread().getName());
		
	}
	
	//�÷���ʵ�����ļ���д����
	private void writeToFile() throws Exception{
		//�����ļ�����
		File filename = new File("E:"+File.separator+"test.txt");
		//���ļ���д����
		OutputStream os = new FileOutputStream(filename,true);
		int count = 0;  //ÿдһ�����ݣ�count��++
		while(count < 999){
			os.write(("\r\nJava Thread"+count).getBytes());
			System.out.println("�ػ��߳�"+ Thread.currentThread().getName()+"���ļ���д����Java Thread"+count++);
			Thread.sleep(10000);  //����1��  ÿ��һ��дһ������
		}
	}
}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("������������߳�"+Thread.currentThread().getName());
		DaemonThread daemonThread = new DaemonThread();
		Thread thread = new Thread(daemonThread);
		thread.setDaemon(true);   //����Ϊ�ػ��߳�
		thread.start();   //�ػ��߳�����
		
		//�����߳�
		Scanner sc = new Scanner(System.in);
		sc.next();
		
		System.out.println("�����˳������߳�"+Thread.currentThread().getName());

	}

}
