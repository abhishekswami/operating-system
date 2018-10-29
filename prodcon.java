//Q : the queue that you’re trying to synchronize
//Producer : the threaded object that is producing queue entries
//Consumer : the threaded object that is consuming queue entries
//PC : the driver class that creates the single Q, Producer, and Consumer.
import java.util.concurrent.Semaphore; 

class Q 
{ 
	int item; 
	static Semaphore semCon = new Semaphore(0); 
	
	static Semaphore semProd = new Semaphore(1); 
	
void get() 
	{ 
		try { 
			semCon.acquire(); 
		} 
		catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		} 
		
		System.out.println("Consumer consumed item : " + item); 
		 
		semProd.release(); 
	} 
	
	void put(int item) 
	{ 
		try { 
			semProd.acquire(); 
		} catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		} 
		
		// producer producing an item 
		this.item = item; 
		
		System.out.println("Producer produced item : " + item); 
		
		semCon.release(); 
	} 
} 

// Producer class 
class Producer implements Runnable 
{ 
	Q q; 
	Producer(Q q) { 
		this.q = q; 
		new Thread(this, "Producer").start(); 
	} 
	
	public void run() { 
		for(int i=0; i < 5; i++) 
			// producer put items 
			q.put(i); 
	} 
} 

// Consumer class 
class Consumer implements Runnable 
{ 
	Q q; 
	Consumer(Q q){ 
		this.q = q; 
		new Thread(this, "Consumer").start(); 
	} 
	
	public void run() 
	{ 
		for(int i=0; i < 5; i++) 
			// consumer get items 
			q.get(); 
	} 
} 

// Driver class 
class PC 
{ 
	public static void main(String args[]) 
	{ 
		// creating buffer queue 
		Q q = new Q(); 
		
		// starting consumer thread 
		new Consumer(q); 
		
		// starting producer thread 
		new Producer(q); 
	} 
}
/*output:
Producer produced item : 0
Consumer consumed item : 0
Producer produced item : 1
Consumer consumed item : 1
Producer produced item : 2
Consumer consumed item : 2
Producer produced item : 3
Consumer consumed item : 3
Producer produced item : 4
Consumer consumed item : 4/*
