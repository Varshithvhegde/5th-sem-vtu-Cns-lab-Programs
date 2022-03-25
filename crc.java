import java.net.*;
import java.io.*;
import java.util.Scanner;
public class crc {
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the data word");
            String data = sc.nextLine();
            System.out.println("Enter the generator polynomial");
            String gen = sc.nextLine();
            String  code = data;

            while(code.length()<(data.length()+gen.length()-1)){
                code = code+"0";
            }
            System.out.println("COde transmitted is : "+code);
            code = code +div(code,gen);
            
            String rem =div(code,gen);
            if(Integer.parseInt(rem)==0){
                System.out.println("No error");
            }
            else{
                System.out.println("Error in data");
            }
            System.out.println("Enter the position to alter the message");
            int pos= sc.nextInt();
            if(code.charAt(pos)=='0'){
                code = code.substring(0,pos)+"1"+code.substring(pos+1);
            }
            else{
                code = code.substring(0,pos)+"0"+code.substring(pos+1);
            }
            System.out.println("Altered data is "+code);
            if(Integer.parseInt(div(code,gen))==0){
                System.out.println("No error");
            }
            else{
                System.out.println("Error in data");
            }
        }
         static String div(String num1,String num2){
            int pointer = num2.length();
            String result = num1.substring(0,pointer);
            String reminder="";
            for(int i=0;i<pointer;i++){
                if(result.charAt(i)==num2.charAt(i)){
                    reminder+="0";
                }
                else{
                    reminder+="1";
                }

            }   
            while(pointer<num1.length()){
                if(reminder.charAt(0)=='0'){
                    reminder=reminder.substring(1,reminder.length());
                    reminder=reminder+String.valueOf(num1.charAt(pointer));
                    pointer++;
                }
                result=reminder;
            
                reminder="";
                if(result.charAt(0)!='0'){
                    for(int i=0;i<num2.length();i++){
                        if(result.charAt(i)==num2.charAt(i)){
                            reminder+="0";
                        }
                        else{
                            reminder+="1";
                        }
                    }
                }
                else{
                    reminder=result;
                }
                
                
                
            }
            return reminder.substring(1,reminder.length());
                     
        }
}
