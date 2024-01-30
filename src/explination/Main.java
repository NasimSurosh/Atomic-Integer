package explination;

import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread{
  
  AtomicInteger count = new AtomicInteger();
  
  @Override
  public void run() {
    
    int maxValue = 30000;   // with small number we cannot see the problem
    
    for(int i = 0; i< maxValue; i++) {
      count.incrementAndGet();
      //count.addAndGet(1);
    }
    
    
  }
}

public class Main {

  public static void main(String[] args) throws InterruptedException {
    
    Counter counter = new Counter();
    
    Thread thread1 = new Thread(counter, "Thread1");
    Thread thread2 = new Thread(counter, "Thread2");
    
    thread1.start();
    thread2.start();
    
    thread1.join();
    thread2.join();

    System.out.println(counter.count);
    
  }

}
