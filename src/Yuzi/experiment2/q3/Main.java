package Yuzi.experiment2.q3;

class Station extends Thread {
    public Station(String s) {
        setName(s);
    }

    static int ticket = 20;
    static final Object ob = "114514";

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (ticket > 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 卖出了" + (ticket--) + "号票！");

                } else {
                    System.out.println("票卖完了");
                    ticket--;
                }
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Station s1 = new Station("窗口1");
        Station s2 = new Station("窗口2");
        Station s3 = new Station("窗口3");
        s1.start();
        s2.start();
        s3.start();
    }
}
