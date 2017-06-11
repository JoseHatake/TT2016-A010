/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Lock
 */
public class Servidor {
    private final static int PORT = 5000;

    public static void main(String[] args){
        ServerSocket ss;
        try{
            ss=new ServerSocket(PORT);
            while(true){
                Socket socket;
                socket=ss.accept();
                Hilo hilo=new Hilo(socket);
                new Thread(hilo).start();
            }
        }catch(Exception e){
            System.out.println("que dice el server que ahorita no joven");
        }
    }
    
}
