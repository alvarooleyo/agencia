/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modelo;
import vista.interfaz;

/**
 *
 * @author alvaro
 */
public class controlador implements ActionListener, MouseListener{
    //instancia a nuestra interfaz
    interfaz vista;
    
    //instancia a nuestro modelo
    modelo modelo = new modelo();
    
    
public controlador (interfaz vista){
    this.vista = vista;
    
    System.out.println("Construyendo controlador");
}

public enum AccionMVC{
    
    btnCliente,
    btnAdmin,
    
    btnAceptarContraseña,
    txtContraseña,
    
   
    
    
    
}

public enum MouseMVC{
     jTable1,
     
     comboPuntos,
     
     comboHoteles,
}


public void iniciar (){
    
    System.out.println("iniar");
    
    //iniciamos el panel de bienvenida
    this.vista.setVisible(true);
    
    
    this.vista.btnAdmin.setActionCommand("btnAdmin");
    this.vista.btnAdmin.addActionListener(this);
    
    
    this.vista.btnCliente.setActionCommand("btnCliente");
    this.vista.btnCliente.addActionListener(this);
    
    this.vista.jTable1.addMouseListener(this);
    this.vista.jTable1.setName("jTable1");
    
    this.vista.comboPuntos.addMouseListener(this);
    this.vista.comboPuntos.setName("comboPuntos");
    
    
    this.vista.comboHoteles.addMouseListener(this);
    this.vista.comboHoteles.setName("comboHoteles");
   
    
            
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         switch ( AccionMVC.valueOf( e.getActionCommand() ) ){
             
            case btnAdmin:
                
                this.vista.dialogoAdmin.setVisible(true);
                this.vista.dialogoAdmin.setLocationRelativeTo(vista);
                        
                
                //this.vista.dialogoContraseña.setVisible(true);
                
                break;
                
            //case btnAceptarContraseña:
                    
                //String pass = this.vista.txtContraseña.getText();
                
                //if(pass=="admin"){ 
               // this.vista.dialogoAdmin.setVisible(true);
                //}else
                //    System.out.println("contraseña incorrecta");
               // break;
                 
            case btnCliente:
               
                this.vista.dialogoCliente.setVisible(true);
                this.vista.dialogoCliente.setLocationRelativeTo(null);
                System.out.println("vista cargada");
                this.vista.jTable1.setModel(this.modelo.rellenarTablaViajes());
                System.out.println("tabla cargada");
                
                break;
                
            
            
             
           
         }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        int fila;
        switch (controlador.MouseMVC.valueOf(e.getComponent().getName())){ 

            case   jTable1:
                System.out.println("Entra en el case tabla");
             fila = this.vista.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1){            
                
                
                this.vista.txtId.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 0) ));
                this.vista.txtNombre.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 1) ));
                this.vista.txtCategoria.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 2) ));
                this.vista.txtDescripcion.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 3) ));
                
                int id = Integer.parseInt(this.vista.txtId.getText());
                
                this.vista.comboPuntos.setModel(this.modelo.rellenaComboPuntos(id));
            }
                break;
                
            case comboPuntos:
                
                System.out.println("entra en comboPuntos");
                
                String nombre_punto = (String)this.vista.comboPuntos.getSelectedItem();
                
                this.vista.comboHoteles.setModel(this.modelo.rellenarComboHotel(nombre_punto));
                
                System.out.println("Rellena el combo hoteles");
                
                break;
                
            case comboHoteles:
                System.out.println("Entra en comboHoteles");
                
                String hotel = (String) this.vista.comboHoteles.getSelectedItem();
                
                this.vista.listaHoteles.setModel(this.modelo.rellenaListaHoteles(hotel));
                
                System.out.println("termina comboHoteles");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
