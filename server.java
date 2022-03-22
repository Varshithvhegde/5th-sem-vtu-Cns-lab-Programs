import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket servsock =new ServerSocket(8000);
        Socket sock=servsock.accept();
        InputStream iStream=sock.getInputStream();
        BufferedReader file=new BufferedReader(new InputStreamReader(iStream));
        String fname=file.readLine();
        BufferedReader bff=new BufferedReader(new FileReader(fname));
        OutputStream oStream =sock.getOutputStream();
        PrintWriter pwriter=new PrintWriter(oStream,true);
        String str;
        while((str=bff.readLine())!=null){
            pwriter.println(str);
        }
        sock.close();
        bff.close();
    }
}