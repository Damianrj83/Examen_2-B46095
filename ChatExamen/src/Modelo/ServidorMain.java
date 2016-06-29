/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Vista.ChatFrame;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author damian rojas
 */
public class ServidorMain {
    
    static final int  puerto = Integer.parseInt(JOptionPane.showInputDialog(null,""));
    
     ChatFrame chatFrame;
    
    
    public ServidorMain(){
    
    this.chatFrame = new ChatFrame();
    }
    
   
    
    
    //private final int puerto = 2020;
    //int puerto = (Integer.parseInt(chatFrame.getTextPuerto()));
    private final int numConexiones = 500;
   
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
       
   
    public void listen(){
        try {
            
            ServerSocket servidor = new ServerSocket(puerto,numConexiones);
            
            while(true){
                System.out.println("Escuchando....");
                
                Socket cliente = servidor.accept();
                usuarios.add(cliente);
               
                
                
                
                Runnable  correr = new ServidorThread(cliente,usuarios);
                Thread hilo1 = new Thread(correr);
                hilo1.start();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServidorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
        ServidorMain servidor = new ServidorMain();
        servidor.listen();
    }
    
    
     public Socket agregar(Socket cliente){
    //Socket socket =null;
        usuarios.add(cliente);
        return cliente;
    }
   
    
}//Fin clase
