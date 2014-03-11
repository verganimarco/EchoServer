package echoserver;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer
{
    public static void main(String[] args)throws IOException
    {
        ServerSocket ss=new ServerSocket(2000);
        while(true)
        {
            new EchoServerThread(ss.accept()).start();
        }
    }
}


