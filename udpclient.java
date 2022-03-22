import java.io.*;
import java.net.*;
import java.util.Scanner;
public class udpclient {
    public static void main(String args[]) throws IOException,BindException{
        DatagramSocket ds =new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        byte[] sending = new byte[1024];
        byte[] receive = new byte[1024];
        System.out.println("Enter the data to send to server");
        String send=sc.next();
        InetAddress ip = InetAddress.getByName("localhost");
        sending=send.getBytes();
        DatagramPacket dp = new DatagramPacket(sending, sending.length,ip,1200);
        ds.send(dp);
        DatagramPacket dpp = new DatagramPacket(receive,receive.length);
        ds.receive(dpp);
        String msg=new String(dpp.getData());
        System.out.println("Server : "+msg);
        }
}
