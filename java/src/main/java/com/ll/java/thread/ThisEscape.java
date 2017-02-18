package com.ll.java.thread;
/**
 * 构造函数中发布内部类：可能导致外部类还未创建完成即被调用
 * @author ll
 *
 */
public class ThisEscape {

	public ThisEscape() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(ThisEscape.this);
			}
		});
	}
	
	public void doSomething(){
		System.out.println("this escape");
	}
	
	@Override
	public String toString() {
		return "我是外部类";
	}
}

class MyThread extends Thread{
	public MyThread() {}
	
	public MyThread(Runnable task){
		
	}
}