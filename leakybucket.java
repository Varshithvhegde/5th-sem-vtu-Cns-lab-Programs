import java.io.*;
import java.util.*;
public class leakybucket {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int l=0;
    
    System.out.println("Enter the bucket size");
    int size=sc.nextInt();
    int a[]= new int[size];
    System.out.println("Enter the no of packets");
    int p=sc.nextInt();
    System.out.println("Enter the data");
    for(int i=0;i<p;i++){
        a[i]=sc.nextInt();
    }
    System.out.println("Enter the output rate");
    int out=sc.nextInt();
    for(int i=0;i<p;i++){
        // a[i]=a[i]+1;
        if(a[i]>=size){
            System.out.println("Bucket overflow :"+(a[i]-1));
        }
        else if(a[i]==out){
            System.out.println("Packet transmitted : "+a[i]);
        }
        else if(a[i]==0){
            System.out.println("Invalid packet");
        }
        else if(a[i]>out){
            while(a[i]!=0 && a[i]>out){
                System.out.println("Packet Transmitted : "+out);
                a[i]=a[i]-out;
            }
      
    }
    else{
        System.out.println("Packet Transmitted : "+a[i]);
        }
    }   

}
}
