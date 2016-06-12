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
import java.sql.Date;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
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
    
    btnSeleccionarHotel,
    btnReservar,
    btnAceptarFianza,
    btnCancelarFianza,
    
    btnPuntoRuta,
    btnAgregarRuta,
    btnAsignarRuta,
    
    
    //ACCIONES ADMIN
    
    btnLimpiar,
    btnAñadir,
    btnEliminar,
    btnModificar,
    
   
    
    
    
}

public enum MouseMVC{
     jTable1,
     
     comboPuntos,
     
     comboHoteles,
     
     //ACCIONES ADMIN
     tablaAdmin,
     
     tablaAsignarViaje,
     tablaAsignarRuta,
     
     
}


public void iniciar (){
    
    System.out.println("iniar");
    
    //iniciamos el panel de bienvenida
    this.vista.setVisible(true);
    
    
    this.vista.btnAdmin.setActionCommand("btnAdmin");
    this.vista.btnAdmin.addActionListener(this);
    
    
    this.vista.btnCliente.setActionCommand("btnCliente");
    this.vista.btnCliente.addActionListener(this);
    
    
    this.vista.btnSeleccionarHotel.setActionCommand("btnSeleccionarHotel");
    this.vista.btnSeleccionarHotel.addActionListener(this);
    
    this.vista.btnReservar.setActionCommand("btnReservar");
    this.vista.btnReservar.addActionListener(this);
    
    this.vista.btnAceptarFianza.setActionCommand("btnAceptarFianza");
    this.vista.btnAceptarFianza.addActionListener(this);
    
    this.vista.btnCancelarFianza.setActionCommand("btnCancelarFianza");
    this.vista.btnCancelarFianza.addActionListener(this);
    
    this.vista.btnAgregarRuta.setActionCommand("btnAgregarRuta");
    this.vista.btnAgregarRuta.addActionListener(this);
    
    this.vista.btnPuntoRuta.setActionCommand("btnPuntoRuta");
    this.vista.btnPuntoRuta.addActionListener(this);
    
    this.vista.btnAsignarRuta.setActionCommand("btnAsignarRuta");
    this.vista.btnAsignarRuta.addActionListener(this);
    
    
    
    
    
    this.vista.btnLimpiar.setActionCommand("btnLimpiar");
    this.vista.btnLimpiar.addActionListener(this);
    
    this.vista.btnAñadir.setActionCommand("btnAñadir");
    this.vista.btnAñadir.addActionListener(this);
    
    this.vista.btnEliminar.setActionCommand("btnEliminar");
    this.vista.btnEliminar.addActionListener(this);
    
    this.vista.btnModificar.setActionCommand("btnModificar");
    this.vista.btnModificar.addActionListener(this);
    
    
    
    
    
            
            
    
    this.vista.jTable1.addMouseListener(this);
    this.vista.jTable1.setName("jTable1");
    
    this.vista.comboPuntos.addMouseListener(this);
    this.vista.comboPuntos.setName("comboPuntos");
    
    
    this.vista.comboHoteles.addMouseListener(this);
    this.vista.comboHoteles.setName("comboHoteles");
    
    this.vista.tablaAdmin.addMouseListener(this);
    this.vista.tablaAdmin.setName("tablaAdmin");
    
    this.vista.tablaAsignarViaje.addMouseListener(this);
    this.vista.tablaAsignarViaje.setName("tablaAsignarViaje");
   
    this.vista.tablaAsignarRuta.addMouseListener(this);
    this.vista.tablaAsignarRuta.setName("tablaAsignarRuta");
    
            
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         switch ( AccionMVC.valueOf( e.getActionCommand() ) ){
             
            case btnAdmin:
                
                this.vista.dialogoAdmin.setVisible(true);
                this.vista.dialogoAdmin.setLocationRelativeTo(vista);
                System.out.println("vista cargada");
                this.vista.tablaAdmin.setModel(this.modelo.rellenarTablaViajes());
                System.out.println("tabla cargada");
                
                break;
                        
                
                //this.vista.dialogoContraseña.setVisible(true);
                
               
                
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
                
                
            case btnReservar:
                
                this.vista.dialogoReserva.setVisible(true);
                this.vista.dialogoReserva.setLocationRelativeTo(null);
                
                break;
                
                
            case btnCancelarFianza:
                
                this.vista.dialogoReserva.setVisible(false);
                
                break;
                
                
            case btnPuntoRuta:
                
                this.vista.dialogoPuntoRuta.setVisible(true);
                this.vista.dialogoPuntoRuta.setLocationRelativeTo(null);
                
                break;
                
                
            case btnAgregarRuta:
                
                String nombre_puntoA = this.vista.txtNombreA.getText();
                String tipoA = this.vista.txtTipoA.getText();
                String hotelA = this.vista.txtHotelA.getText();
                
                if(tipoA.equals("visita")){
                    hotelA = "Visita, Hotel No Disponible" ;
                }
                
                this.modelo.añadirPunto(nombre_puntoA, tipoA, hotelA);
                
                
                String nombre_puntoB = this.vista.txtNombreB.getText();
                String tipoB = this.vista.txtTipoB.getText();
                String hotelB = this.vista.txtHotelB.getText();
                
                if(tipoB.equals("visita")){
                    hotelB = "Visita, Hotel No Disponible" ;
                }
                
                this.modelo.añadirPunto(nombre_puntoB, tipoB, hotelB);
                
               
                String puntoA = this.vista.txtNombreA.getText();
                String puntoB = this.vista.txtNombreB.getText();
                
                this.modelo.añadirRuta(puntoA, puntoB);
                
                
                this.vista.txtNombreA.setText("");
                this.vista.txtNombreB.setText("");
                this.vista.txtTipoA.setText("");
                this.vista.txtTipoB.setText("");
                this.vista.txtHotelA.setText("");
                this.vista.txtHotelB.setText("");
                
                break;
                
                
            case btnAsignarRuta:
                
                this.vista.dialogoAsignarRuta.setVisible(true);
                this.vista.dialogoAsignarRuta.setLocationRelativeTo(null);
                
                this.vista.tablaAsignarViaje.setModel(this.modelo.rellenarTablaViajes());
                
                this.vista.tablaAsignarRuta.setModel(this.modelo.rellenarTablaRutas());
                
                break;
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            case btnLimpiar:

                this.vista.txtIdAdmin.setText("");
                this.vista.txtNombreAdmin.setText("");
                this.vista.txtCategoriaAdmin.setText("");
                this.vista.txtDescripcionAdmin.setText("");
                this.vista.txtFechaSalida.setText("");
                this.vista.txtFechaLlegada.setText("");
                
                break;
                
            case btnAñadir:
                
                String nombre, categoria, descripcion;
                
                nombre = this.vista.txtNombreAdmin.getText();
                categoria = this.vista.txtCategoriaAdmin.getText();
                descripcion = this.vista.txtDescripcionAdmin.getText();
                
                String fechasalida = this.vista.txtFechaSalida.getText();
                String fechallegada = this.vista.txtFechaLlegada.getText();
                
                this.modelo.añadirViaje(nombre, categoria, descripcion, fechasalida, fechallegada);
                
                this.vista.tablaAdmin.setModel(this.modelo.rellenarTablaViajes());
                
                
                
                break;
                
                
            case btnEliminar: 
                
                String id = this.vista.txtIdAdmin.getText();
                
                System.out.println("El id del viaje a eliminar es "+id);
                
                this.modelo.eliminarViaje(id);
                
                this.vista.tablaAdmin.setModel(this.modelo.rellenarTablaViajes());
                
                
                
                break;
                
            case btnModificar:
                
                String nombre_modificar = this.vista.txtNombreAdmin.getText();
                String categoria_modificar = this.vista.txtCategoriaAdmin.getText();
                String descripcion_modificar = this.vista.txtDescripcionAdmin.getText();
                String salida_modificar = this.vista.txtFechaSalida.getText();
                String llegada_modificar = this.vista.txtFechaLlegada.getText();
                String id_modificar = this.vista.txtIdAdmin.getText();
                
                this.modelo.moificarViaje(nombre_modificar, categoria_modificar, descripcion_modificar, salida_modificar, llegada_modificar, id_modificar);
                
                this.vista.tablaAdmin.setModel(this.modelo.rellenarTablaViajes());
                
                break;
                
            case btnSeleccionarHotel:
                
                if(this.vista.comboHoteles.getSelectedItem()!="Visita, Hotel No Disponible"){
                
                 String hotel = (String) this.vista.comboHoteles.getSelectedItem();
                 
                this.vista.listaHoteles.setModel(this.modelo.rellenaListaHoteles(hotel));
                
               
                 //int i = this.vista.listaHoteles.getComponentCount();
                
                //this.vista.listaHoteles.setModel(this.modelo.rellenaListaHoteles(hotel, i));
                
                  //  System.out.println("Elementos =  "+i);
               break;
               
               
            
                
                              
                }
            
            
             
           
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
                this.vista.txtSalidaCliente.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 4) ));
                this.vista.txtLlegadaCliente.setText( String.valueOf( this.vista.jTable1.getValueAt(fila, 5) ));
                
                
                int id = Integer.parseInt(this.vista.txtId.getText());
                
                this.vista.comboPuntos.setModel(this.modelo.rellenaComboPuntos(id));
            }
                break;
                
            
            case tablaAdmin:
                
                System.out.println("Entra en el case tablaAdmin");
             fila = this.vista.tablaAdmin.rowAtPoint(e.getPoint());
             
            if (fila > -1){            
                   
                this.vista.txtIdAdmin.setText( String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 0) ));
                this.vista.txtNombreAdmin.setText( String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 1) ));
                this.vista.txtCategoriaAdmin.setText( String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 2) ));
                this.vista.txtDescripcionAdmin.setText( String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 3) ));
                this.vista.txtFechaSalida.setText(String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 4) ));
                this.vista.txtFechaLlegada.setText(String.valueOf( this.vista.tablaAdmin.getValueAt(fila, 5) ));
                
               
            }
            
                break;
            
            case tablaAsignarViaje:
                 
                System.out.println("Entra en el case tablaAsignarViaje");
             fila = this.vista.tablaAsignarViaje.rowAtPoint(e.getPoint());
             
            if (fila > -1){            
                   
                this.vista.txtAsignarViaje.setText( String.valueOf( this.vista.tablaAsignarViaje.getValueAt(fila, 0) ));
                this.vista.txtAsignarSalida.setText( String.valueOf( this.vista.tablaAsignarViaje.getValueAt(fila, 4) ));
                this.vista.txtAsignarLlegada.setText( String.valueOf( this.vista.tablaAsignarViaje.getValueAt(fila, 5) ));
                
            }
                
                
                break;
                
            case tablaAsignarRuta:

            System.out.println("Entra en el case tablaAsignarViaje");
         fila = this.vista.tablaAsignarRuta.rowAtPoint(e.getPoint());

        if (fila > -1){            

            this.vista.txtAsignarRuta.setText( String.valueOf( this.vista.tablaAsignarRuta.getValueAt(fila, 0) ));
           

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
                
               
                
                System.out.println("termina comboHoteles");
                
                break;
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
