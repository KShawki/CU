import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scan = new Scanner(System.in);
            Socket cs = new Socket("127.0.0.1", 6600);
            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
            String msg = "";

            System.out.println("Enter Your Message: ");
            for(int i=0; i<10; i++) {
                msg = scan.nextLine();
                dos.writeUTF(msg);
                dos.flush();

                if(msg.equals("end")) {
                    break;
                }
            }
            dos.close();
            cs.close();
            scan.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
