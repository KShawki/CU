import java.io.*;
import java.net.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6600);
            Socket socket = ss.accept();

            while(true) {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String str = (String) dis.readUTF();

                if(str.equals("end")) {
                    ss.close();
                    break;
                }
                System.out.println("Message: " + str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}