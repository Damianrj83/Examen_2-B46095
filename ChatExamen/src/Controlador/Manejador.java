/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ServidorMain;
import Vista.ChatFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Damian B46095
 */
public class Manejador implements ActionListener{

    ServidorMain servidorMain;
    ChatFrame chatFrame;
    //boolean estado = true;
    public Manejador(ChatFrame chatFrame){
    this.chatFrame = chatFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Crear usuario")){
            System.out.println("pasa");
           chatFrame.habiblitar(true);
           //servidorMain.usuarios.add(cliente);
            
        }
        
        if(e.getActionCommand().equals("Aceptar")){
            
           //chatFrame.habiblitar(false);
            
        }
         if(e.getActionCommand().equals("Enviar")){
            System.out.println("envio mensaje exitoso");
            chatFrame.enviarMensaje();
           
            
        }
        
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
