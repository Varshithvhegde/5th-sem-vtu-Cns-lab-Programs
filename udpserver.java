import java.io.*;
import java.net.*;
import java.util.Scanner;
public class udpserver {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds =new DatagramSocket(1200);
        byte[] recieve=new byte[1024];
        byte[] sending=new byte[1024];
        while(true)
        {
            DatagramPacket dp = new DatagramPacket(recieve,recieve.length);
            ds.receive(dp);
            String rcv =new String(dp.getData());
            System.out.println("Client : "+rcv);
            InetAddress cip=dp.getAddress();
            int Port= dp.getPort();
            System.out.println("Enter the data to semd to the client");
            String send=sc.next();
            // send.sendData();
            sending=send.getBytes();
            DatagramPacket dpp =new DatagramPacket(sending,sending.length,cip,Port);
            ds.send(dpp);
        }

        
    }
}
