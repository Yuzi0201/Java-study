package Yuzi.experiment3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Server {
    //定义Map集合用于存储用户的Socket以及用户的名字   key:Socket    Value:用户名
    public final static Map<Socket,String> socketsMaps = Collections.synchronizedMap(new HashMap<Socket,String>());

}

class ThreadServer extends Thread {
    private Socket socket;
    ThreadServer(){};
    ThreadServer(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            while(true)
            {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String data = dataInputStream.readUTF();

                if(data.startsWith("①②③④")&&data.endsWith("①②③④"))
                {
                    //发送过来的是用户名
                    //将Socket以及用户名字都存放在Map集合中
                    Server.socketsMaps.put(socket, data.replace("①②③④",""));
                    //获取所有的key(Socket)，将所有用户的名字发送至客户端
                    Set<Socket> sockets = Server.socketsMaps.keySet();
                    //获取所有的用户的名字，将这些名字拼装成一个字符串
                    Collection<String> names = Server.socketsMaps.values();
                    StringBuffer sbf = new StringBuffer();
                    for(String userName :names)
                    {
                        sbf.append(userName).append(",");
                    }
                    System.out.println("sbf:"+sbf.toString());
                    for(Socket soc:sockets)
                    {
                        DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
                        dataOutputStream.writeUTF("①②③④"+sbf.toString()+"①②③④");
                        dataOutputStream.flush();
                    }
                }
                else{
                    //发送过来的是聊天信息
                    //获取所有的key(Socket)，将所有用户的名字发送至客户端
                    Set<Socket> sockets = Server.socketsMaps.keySet();
                    //將聊天信息广播出去
                    for(Socket soc:sockets)
                    {
                        DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
                        dataOutputStream.writeUTF("[ "+Server.socketsMaps.get(socket)+" ]说："+data);
                        dataOutputStream.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
