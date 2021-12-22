package Yuzi.experiment2.q2;
import javax.swing.*;

public class Main {
    public static void main(String args[]){
        JFrame f = new JFrame("Menu");   //创建一个窗口
        f.setSize(400,200);  //设置窗口的大小
        f.setLocationRelativeTo(null);  //设置窗口的位置为中央位置
        f.setResizable(false);   //设置窗口大小不能
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar mb = new JMenuBar();    //创建一个菜单条
        f.setJMenuBar(mb);               //将菜单条加入窗口
        JMenu JMenu_File = new JMenu("File");    //创建菜单File
        JMenu JMenu_Format = new JMenu("Format");  //创建菜单Format
        JMenu JMenu_Help = new JMenu("Help");    //创建菜单Help
        mb.add(JMenu_File);   //将File菜单加入菜单条
        mb.add(JMenu_Format); //将Format菜单加入菜单条
        mb.add(JMenu_Help); //将Help菜单加入菜单条
        JMenu JMenu_Format_Chinese = new JMenu("中文");  //创建一个子菜单中文
        JMenu JMenu_Format_Hexadecimal = new JMenu("进制");//创建一个子菜单进制
        JMenu_Format.add(JMenu_Format_Chinese); //将子菜单中文加入Format菜单中
        JMenu_Format.addSeparator();   //添加一个分隔符
        JMenu_Format.add(JMenu_Format_Hexadecimal);  //将子菜单进制加入Format菜单中
        JMenuItem JMenu_Format_Hexadecimal_binary = new JMenuItem("二进制");   //创建一个菜单项二进制
        JMenuItem JMenu_Format_Hexadecimal_octal = new JMenuItem("八进制");    //创建一个菜单项八进制
        JMenuItem JMenu_Format_Hexadecimal_hexadecimal = new JMenuItem("十六进制");  //创建一个菜单项十六进制
        JMenu_Format_Hexadecimal.add(JMenu_Format_Hexadecimal_binary); //将菜单项二进制加入子菜单进制中
        JMenu_Format_Hexadecimal.add(JMenu_Format_Hexadecimal_octal);
        JMenu_Format_Hexadecimal.add(JMenu_Format_Hexadecimal_hexadecimal);
        f.setVisible(true); //显示窗口
    }
}
