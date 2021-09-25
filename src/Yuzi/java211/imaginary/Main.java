package Yuzi.java211.imaginary;

import java.util.Scanner;

class plural {
    private double real;
    private double imaginary;
    Scanner s = new Scanner(System.in);

    public plural() {
        real = 0;
        imaginary = 0;
    }

    public void initplural() {
        real = s.nextDouble();
        imaginary = s.nextDouble();
    }

    public String toString() {
        return (real + " + " + imaginary + "i");
    }

    public static String add(plural a, plural b) {
        plural c = new plural();
        c.real = a.real + b.real;
        c.imaginary = a.imaginary + b.imaginary;
        return c.toString();
    }

    public static String subtract(plural a, plural b) {
        plural c = new plural();
        c.real = a.real - b.real;
        c.imaginary = a.imaginary - b.imaginary;
        return c.toString();
    }

    public static String multiply(plural a, plural b) {
        plural c = new plural();
        c.real = a.real * b.real - a.imaginary * b.imaginary;
        c.imaginary = a.imaginary * b.real + a.real * b.imaginary;
        return c.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        plural a = new plural();
        plural b = new plural();
        System.out.print("Please input A's real and imaginary: ");
        a.initplural();
        System.out.println("A is:" + a.toString());
        System.out.print("Please input B's real and imaginary: ");
        b.initplural();
        System.out.println("B is:" + b.toString());
        System.out.println("A + B = " + plural.add(a, b));
        System.out.println("A - B = " + plural.subtract(a, b));
        System.out.println("A * B = " + plural.multiply(a, b));
    }
}