/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author Damian
 */
public class ServidorThread implements Runnable {
    
    
    
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();//ArrayList
    
    
    public ServidorThread(Socket socket1,LinkedList users){
        socket = socket1;
        usuarios = users;
    }

    @Override
    public void run() {
        
         try {
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Ha iniciado un chat....");
            
            
            
            while(true){
               String recibido = in.readUTF();
                
                for (int i = 0; i < usuarios.size(); i++) {
                    out = new DataOutputStream(usuarios.get(i).getOutputStream());
                    out.writeUTF(recibido);
                }
            }
        } catch (IOException e) {
          
         System.out.println("Exeption.......");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
