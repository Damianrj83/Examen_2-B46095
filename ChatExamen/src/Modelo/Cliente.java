/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.ChatFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

/**
 *
 * @author Damian Rojas
 */
public class Cliente implements Runnable{

    
    //     ChatFrame chatFrame;
     ChatFrame chatFrame;
      Socket cliente;
     DataOutputStream out;
     DataInputStream in;
    
     int puerto = 2020;
     //puerto = chatFrame.getTextPuerto();
   
     String host = "localhost";
     String mensajes = "";
    JTextArea jTextArea1;
    
    
    public Cliente(JTextArea jTextArea1){//JTextArea o jTetxtField
        try {
            cliente = new Socket(host,puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//Fin constructor
    
    
    
    
    
    @Override
    public void run() {
        
        
         try{
            
            while(true){
                mensajes += in.readUTF();
                jTextArea1.setText(mensajes);
            }
        }catch(Exception ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public void enviarMsg(String mensaje){
        try {
            out.writeUTF(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}//Fin clase
