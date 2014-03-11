package echoserver;

import java.net.Socket;
import java.io.*;

public class EchoServerThread extends Thread {
    private Socket s;
    public boolean testo=true;
    public boolean maiuscole=true;
    
    public EchoServerThread(Socket s){
        this.s = s;
    }
    public void run(){
         BufferedReader in=null;
         PrintWriter out=null;
         try{
           in=new BufferedReader(new InputStreamReader(s.getInputStream()));
           out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
           while(testo==true){
                String s=in.readLine();
                String f = "fine";
                String m = "maiuscole:on";
                String m1 = "maiuscole:off";
                if(s.equals(f)){
                   in.close();
                   out.close();
                   System.out.println ("Server: " + s); 
                }
                else if(s.equals(m)){
                  maiuscole=false;
                  System.out.println ("Server: " + s); 
                }
                else if(s.equals(m1)){
                  maiuscole=true;
                  System.out.println ("Server: " + s); 
                }
                else{
                    System.out.println ("Server: " + s); 
                    if(maiuscole==true){
                        out.println(s.toLowerCase());
                    }
                    else{
                        out.println(s.toUpperCase());
                    }
                }

            }
        }catch(IOException ex){}
        try{
            s.close();
        }catch(IOException ex){} 
    }
}