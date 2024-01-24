package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Data {
  private int x;
  private double y;
  private String s;

  // constructor does NOT initialize this thing!
  // consequently it's not "sound" until later...
  public Data() {
  }

  public Data(int x, double y, String s) {
    this.x = x;
    this.y = y;
    this.s = s;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setS(String s) {
    this.s = s;
  }

  public int getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public String getS() {
    return s;
  }

  @Override
  public String toString() {
    return "Data{" +
        "x=" + x +
        ", y=" + y +
        ", s='" + s + '\'' +
        '}';
  }
}

class MyProducer implements Runnable {
  private BlockingQueue<Data> bqd;

  public MyProducer(BlockingQueue<Data> bqd) {
    this.bqd = bqd;
  }

  @Override
  public void run() {
    System.out.println("MyProducer starting in thread: " + Thread.currentThread());
    try {
      for (int i = 0; i < 5_000; i++) { // 50_000 milliseconds...
        if (i % 100 == 0) System.out.print("."); // progress...
        double d = Math.random() * 10_000;
        Data data = new Data(); // "transactionally unsound" at this point, but not shared
        data.setY(d); // still transactionally unsound :)
        Thread.sleep((int) (Math.random() * 10)); // short pause (simulating longer running compuation
        data.setS("Value: " + d); // STILL transactionaly unsound :)
        data.setX((int) d); // OK NOW we're "sound"
        bqd.put(data);
        data = null; // MUST NOT USE THIS OBJECT AGAIN (not even for reading!!)
      }
      // finished sending... Send "Poison pill" (special version of data) to indicate
      // that we've finished.
      // BTW, shutdown of threads is one of the harder problems, this is "cheating" somewhat!...
      bqd.put(new Data(-1, -1, null)); // this will never be "valid data"
    } catch (InterruptedException ie) {
      // this won't happen here
      // threads receive "interrupts" as a notification to shut themselves down
      // this happens if some other thread calls "t.interrupt()", and we're not
      // going to do that.
      System.out.println("Interupt!!! That can't happen :)");
    }
    System.out.println("MyProducer completed");
  }
}

class MyConsumer implements Runnable {
  private BlockingQueue<Data> bqd;

  public MyConsumer(BlockingQueue<Data> bqd) {
    this.bqd = bqd;
  }

  @Override
  public void run() {
    System.out.println("MyConsumer starting in thread: " + Thread.currentThread());
//    boolean finished = false;
    int failures = 0;
    int dataCount = 0;
    try {
      while (true) {
        // this also delays, idea is producer might fill the queue, or consumer
        // might empty it, but data should not be lost, overwritten before use,
        // nor reused, despite that...
        Thread.sleep((int) (Math.random() * 10));
        Data d = bqd.take();
        // check for shutdown request
        if (d.getS() == null) {
          if (d.getX() != -1 || d.getY() != -1) {
            failures++;
            System.out.println("Bad poison pill: " + d + " quitting");

          }
          System.out.println("Poison pill, quitting!");
//          finished = true; // irrelevant!
          break;
        }
        // check the "transactional integrity" of the received data
        if (!(d.getS().equals("Value: " + d.getY()) ||
            (d.getX() == (int) d.getY()))) {
          System.out.println("**** ERROR got bad data! " + d);
          failures++;
        }
        dataCount++;
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted consumer!?? That can't happen either!");
    }
    System.out.println("MyConsumer completed after " + dataCount +
        " data items, and " + failures + " failures");
  }
}

public class ProducerConsumer {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Data> bqd = new ArrayBlockingQueue<>(10);

    MyProducer prod = new MyProducer(bqd);
    MyConsumer cons = new MyConsumer(bqd);

    Thread pThread = new Thread(prod);
    Thread cThread = new Thread(cons);
    pThread.start();
    cThread.start();

    // wait for both to finish...
    pThread.join();
    cThread.join();
    System.out.println("producer and consumer shut down, quitting...");
  }
}
