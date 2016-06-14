/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvaro
 */
public class modelo extends database {
    
    
    public modelo () {}
    
    
    
    
    public DefaultTableModel rellenarTablaViajes() {
        
        System.out.println("Entra");
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"id","nombre","categoria","descripcion", "fecha salida", "fecha llegada"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      String a;
        a = "SELECT count(*) as total FROM viaje";
        System.out.println("Despues del string a");
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement(a);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][7];
        System.out.println("Sigue");
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM viaje");
         ResultSet res = pstm.executeQuery();
         int i=0;
         
            
         while(res.next()){
             
                data[i][0] = res.getString( "id_viaje" );
                data[i][1] = res.getString( "nombre_viaje" );
                data[i][2] = res.getString( "categoria" );
                data[i][3] = res.getString( "descripcion" );
                data[i][4] = res.getString("fecha_salida" );
                data[i][5] = res.getString( "fecha_llegada" );
                
            i++;
            
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    
    
    public DefaultTableModel rellenarTablaRutas() {
        
        System.out.println("Entra");
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"id","nombre"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      String a;
        a = "SELECT count(*) as total FROM ruta";
        System.out.println("Despues del string a");
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement(a);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][3];
        System.out.println("Sigue");
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM ruta");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
             
                data[i][0] = res.getString( "id_ruta" );
                data[i][1] = res.getString( "nombre_ruta" );
                
                
            i++;
            
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    
    public DefaultTableModel rellenarTablaHoteles(String id_cliente) {
        
        System.out.println("Entra");
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"HOTEL"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      String a;
        a = "SELECT count(*) as total FROM alojamiento";
        System.out.println("Despues del string a");
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement(a);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][3];
        System.out.println("Sigue");
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT nombre_hotel FROM alojamiento where id_cliente='"+id_cliente+"'");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
             
                data[i][0] = res.getString( "nombre_hotel" );
                
                
            i++;
            
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    public DefaultTableModel rellenarTablaResumenReserva(String id_cliente) {
        
        System.out.println("Entra");
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"ID CLIENTE", "ID VIAJE", "FECHA SALIDA", "FIANZA"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      String a;
        a = "SELECT count(*) as total FROM reserva";
        System.out.println("Despues del string a");
      try{
         PreparedStatement pstm = this.getConexion().prepareStatement(a);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][4];
        System.out.println("Sigue");
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM reserva where id_cliente='"+id_cliente+"'");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
             
                data[i][0] = res.getString( "id_cliente" );
                data[i][1] = res.getString( "id_viaje" );
                data[i][2] = res.getString( "fecha_salida" );
                data[i][3] = res.getString( "fianza" );
                
                
            i++;
            
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    
    
    
    
    //con el siguiente metodo cargamos el jList de puntos que tiene el viaje
    public DefaultComboBoxModel rellenaComboPuntos(int id){
        
    DefaultComboBoxModel vector = new DefaultComboBoxModel();
        
       int total=0;
       
       try{
           //se arma la consulta
           PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM puntoruta");
           //se ejecuta la consulta
           ResultSet res1 = pstm.executeQuery();
           res1.next();
           total = res1.getInt("total");
           res1.close(); 
       }catch(SQLException e){
          System.err.println( e.getMessage() );
 
      }
       int i=0;
         Object[] data = new String[total];       
         String q = "select nombre_punto from puntoruta where id_punto in (select id_punto from rutatienepunto where id_ruta in (select id_ruta from viajetieneruta where id_viaje='"+id+"'));" ;       
         try {
              //se arma la consulta
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            //se ejecuta la consulta
            ResultSet resultado=pstm.executeQuery();
            while(resultado.next()){
                data[i]=resultado.getString("nombre_punto");
                vector.addElement(data[i].toString());
                i++;
         }
            pstm.close();
            resultado.close();
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
         return vector;
    }
    
    
    
    
    
    
    public DefaultComboBoxModel rellenarComboHotel(String nombre_punto){
         DefaultComboBoxModel vector = new DefaultComboBoxModel();
        
       int total=0;
       
       try{
           //se arma la consulta
           PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM puntoruta");
           //se ejecuta la consulta
           ResultSet res1 = pstm.executeQuery();
           res1.next();
           total = res1.getInt("total");
           res1.close(); 
       }catch(SQLException e){
          System.err.println( e.getMessage() );
 
    }
       int i=0;
         Object[] data = new String[total];       
         String q="select hotel from puntoruta where nombre_punto='"+nombre_punto+"';";      
         try {
              //se arma la consulta
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            //se ejecuta la consulta
            ResultSet resultado=pstm.executeQuery();
            while(resultado.next()){
                data[i]=resultado.getString("hotel");
                vector.addElement(data[i].toString());
                i++;
         }
            pstm.close();
            resultado.close();
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
         return vector;
    }
    
    public DefaultListModel rellenaListaHoteles(String hotel){
        
        DefaultListModel vector = new DefaultListModel();
        
       int total=0;
       
       try{
           //se arma la consulta
           PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM puntoruta");
           //se ejecuta la consulta
           ResultSet res1 = pstm.executeQuery();
           res1.next();
           total = res1.getInt("total");
           res1.close(); 
       }catch(SQLException e){
          System.err.println( e.getMessage() );
 
      }
       int i=0;
         Object[] data = new String[total];       
         String q = "select hotel from puntoruta where hotel='"+hotel+"' and hotel !='Visita, Hotel No Disponible';" ;       
         try {
              //se arma la consulta
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            //se ejecuta la consulta
            ResultSet resultado=pstm.executeQuery();
            while(resultado.next()){
                data[i]=resultado.getString("hotel");
                vector.addElement(data[i].toString());
                i++;
                
         }
            pstm.close();
            resultado.close();
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
         return vector;
    
        
    } 
    
    
     public void añadirViaje(String nombre,String categoria,String descripcion, Date fecha_salida, Date fecha_llegada){
         
           String q="insert into viaje (nombre_viaje, categoria, descripcion, fecha_salida, fecha_llegada) values ('"+nombre+"','"+categoria+"','"+descripcion+"', '"+fecha_salida+"', '"+fecha_llegada+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
     
     public void eliminarViaje(String id){
        String q="delete from viaje where id_viaje='"+id+"'";
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 JOptionPane.showMessageDialog(null,"No se puede realizar la operación:\nZona actualmente activa");
                 }
    }
     
     
     public void moificarViaje(String nombre_viaje,String categoria ,String descripcion, String fechaSalida, String fechaLlegada, String id){
        String q="update viaje set nombre_viaje ='"+nombre_viaje+"', categoria='"+categoria+"', descripcion='"+descripcion+"', fecha_salida='"+fechaSalida+"', fecha_llegada='"+fechaLlegada+"' where id_viaje='"+id+"';";
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
    
     
     public void añadirPunto(String id_punto, String nombre_punto, String tipo, String hotel){
         
           String q="insert into puntoruta (id_punto, nombre_punto, tipo, hotel) values ('"+id_punto+"','"+nombre_punto+"','"+tipo+"','"+hotel+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
     
     public void añadirRuta(String id_ruta,String puntoA, String puntoB){
         
           String q="insert into ruta (id_ruta, nombre_ruta) values ('"+id_ruta+"','"+puntoA+"-"+puntoB+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
     public void añadirRutaTienePunto(String id_ruta, String id_punto){
         
           String q="insert into rutatienepunto (id_ruta, id_punto) values ('"+id_ruta+"', '"+id_punto+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
     public void asignarRuta(String id_viaje, String id_ruta, Date fechasalida, Date fechallegada){
         
           String q="insert into viajetieneruta (id_viaje, id_ruta, fecha_salida, fecha_llegada) values ('"+id_viaje+"', '"+id_ruta+"', '"+fechasalida+"', '"+fechallegada+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
            }
        
    }
    
     public String getContraseña(){
       
         String q = "select contraseña from contraseña";
          try{
              PreparedStatement pstm = this.getConexion().prepareStatement(q);
              pstm.execute();
              pstm.close();
              JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
             }
        return q;
     
    }
     
     
     public void añadirAlojamiento(String id_cliente,  String nombre_hotel){
         
           String q="insert into alojamiento (id_cliente, nombre_hotel) values ('"+id_cliente+"','"+nombre_hotel+"')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
     public void eliminaHotel(String id_cliente, String nombre_hotel){
        String q="delete from alojamiento where id_cliente='"+id_cliente+"' and nombre_hotel='"+nombre_hotel+"';";
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 System.err.println( e.getMessage() );
                 JOptionPane.showMessageDialog(null,"No se puede realizar la operación:\nZona actualmente activa");
                 }
    }
     
     public void añadirReserva(String id_cliente, String id_viaje, String fecha_salida){
         
           String q="insert into reserva (id_cliente, id_viaje, fecha_salida, fianza) values ('"+id_cliente+"','"+id_viaje+"','"+fecha_salida+"', 'pagada')";
           System.out.println(q);
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(q);
             pstm.execute();
             pstm.close();
             JOptionPane.showMessageDialog(null,"Operación Realizada");
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"Error: Los datos son incorrectos.\nReviselos y vuelva a intentarlo");
                 System.err.println( e.getMessage() );
                 }
        
    }
     
}


