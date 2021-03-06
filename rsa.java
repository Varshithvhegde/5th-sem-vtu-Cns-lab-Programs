import java.util.Random;
import java.io.*;
import java.util.*;
import java.net.*;
import java.math.BigInteger;
public class rsa {
    
        private BigInteger p,q,phi,e,d,n;
        private int bitlength =1024;
        private Random r;
        public rsa(){
            r =new Random();
            p=BigInteger.probablePrime(bitlength, r);
            q=BigInteger.probablePrime(bitlength, r);
            n=p.multiply(q);
            phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
            e=BigInteger.probablePrime(bitlength/2, r);
            while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0){
                e.add(BigInteger.ONE);
            }
            d=e.modInverse(phi);
        }
        public rsa(BigInteger e,BigInteger d,BigInteger n){
            this.e=e;
            this.d=d;
            this.n=n;
        }
        public static void main(String args[]) throws Exception{
            rsa r1= new rsa();
            // DataInputStream in = new DataInputStream(System.in);
            Scanner sc = new Scanner(System.in);
            String teststring="";
            System.out.println("Enter Plain Text");
            teststring = sc.next();
            System.out.println("Encrypting string "+teststring);
            System.out.println("In bytes "+byteToString(teststring.getBytes()));
            byte[] encrypted =r1.encrypt(teststring.getBytes());
            byte[] decrypted =r1.decrypt(encrypted);
            System.out.println("Decrypting bytes"+byteToString(decrypted));
            System.out.println("Decrypted string"+new String(decrypted));
            
        }
        private static String byteToString(byte[] encrypted){
            String text="";
            for(byte b:encrypted){
                text+=Byte.toString(b);
            }
            return text;
        }
        public byte[] encrypt(byte[] message){
            return(new BigInteger(message)).modPow(e,n).toByteArray();
        }
        public byte[] decrypt(byte[] message){
            return(new BigInteger(message)).modPow(d,n).toByteArray();
        }
    
}
