package Yuzi.experiment1.q2;

import java.util.Scanner;

abstract class Employee {
    protected
    double basic_salary;
    Scanner s = new Scanner(System.in);

    public
    abstract void ComputeSalary();
}

class Manager extends Employee {

    @Override
    public void ComputeSalary() {
        System.out.print("请输入Manager的基本工资： ");
        basic_salary = s.nextDouble();
        System.out.println("这位Manager的工资为： " + basic_salary);
    }
}

class Salesman extends Employee {
    private
    double commission;

    @Override
    public void ComputeSalary() {
        System.out.print("请输入Salesman的基本工资： ");
        basic_salary = s.nextDouble();
        System.out.print("请输入Salesman的销售提成： ");
        commission = s.nextDouble();
        System.out.println("这位Salesman的工资为： " + (basic_salary + commission));
    }
}

class Worker extends Employee {
    private
    int workdays;

    @Override
    public void ComputeSalary() {
        System.out.print("请输入Worker的每日工资： ");
        basic_salary = s.nextDouble();
        System.out.print("请输入Worker的工作天数： ");
        workdays = s.nextInt();
        System.out.println("这位Worker的工资为： " + (basic_salary * workdays));
    }
}

public class main {
    public static void main(String[] args) {
        System.out.println("Welcome to the salary calculation system!!");
        Manager m = new Manager();
        Salesman s = new Salesman();
        Worker w = new Worker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the number of employee type:");
            System.out.println("1.Manager 2.Salesman 3.Worker");
            switch (scanner.nextInt()) {
                case 1:
                    m.ComputeSalary();
                    break;
                case 2:
                    s.ComputeSalary();
                    break;
                case 3:
                    w.ComputeSalary();
                    break;
                default:
                    System.out.println("Wrong input!Please enter 1,2 or 3!!");
                    break;
            }
            System.out.println("enter 1 to quit, 2 to continue:  ");
            if (scanner.nextInt() == 1)
                System.exit(0);
        }
    }
}