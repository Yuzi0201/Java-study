package Yuzi.experiment1.q1;

import java.util.Random;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        while (true) {
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            Scanner s = new Scanner(System.in);
            System.out.print("请输入一个1-100之间的数： ");
            int cin = s.nextInt();
            int counter = 1;
            while (cin != i) {
                if (cin > i)
                    System.out.print("猜大了！再猜： ");
                else
                    System.out.print("猜小了！再猜： ");
                counter++;
                cin = s.nextInt();
            }
            System.out.println("猜对了！你一共猜了" + counter + "次！");
            System.out.println("输入exit退出，其他键重玩");
            String restart=s.next();
            if (restart.equals("exit"))
                System.exit(0);
        }
    }
}
