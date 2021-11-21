package Yuzi.experiment2.q1;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Window extends JFrame {
    JTextField text;
    JButton button;
    JPasswordField password;

    public Window() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(null);
        JLabel jl1 = new JLabel("用户名：");
        jl1.setBounds(30, 50, 100, 30);
        add(jl1);
        text = new JTextField(10);
        text.setBounds(80, 50, 150, 30);
        add(text);
        password = new JPasswordField(10);
        JLabel jl2 = new JLabel("密码：");
        jl2.setBounds(42, 100, 100, 30);
        add(jl2);
        password.setBounds(80, 100, 150, 30);
        add(password);
        button = new JButton("确定");
        button.setBounds(115, 150, 70, 30);
        add(button);
    }

}


public class Main {
    public static void main(String[] args) {
        Window win = new Window();
        win.setBounds(500, 200, 310, 260);
        win.setTitle("登录");
    }
}
