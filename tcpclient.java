import java.io.*;
import java.net.*;
import java.io.*;
public class tcpclient {
    public static void main(String args[]) throws UnknownHostException, IOException{
        Socket sock=new Socket("localhost",8000);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fname = bf.readLine();
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwriter=new PrintWriter(ostream,true);
        pwriter.println(fname);
        InputStream iStream=sock.getInputStream();
        BufferedReader breader= new BufferedReader(new InputStreamReader(iStream));
        String str;
        while((str=breader.readLine())!=null){
            System.out.println(str);
        }
        pwriter.close();
        sock.close();
    }
    
}
