/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteajaxaemet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {
    public static ArrayList<Municipio> recuperarMunicipiosPorNombre(String parte_nombre)
    {ArrayList<Municipio> lista=new ArrayList<>();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bd_municipios";
            Connection conexion=DriverManager.getConnection(url,"root","");
            Statement stmt=conexion.createStatement();
            String query="SELECT * FROM municipios WHERE nombre LIKE '"+parte_nombre+"%'";
            ResultSet rs=stmt.executeQuery(query);
           
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String cod_municipio=rs.getString("cod_municipio");
                // public Municipio(String cod_municipio, String id_provincia, String nombre)
                String id_provincia=rs.getString("id_provincia");
                Municipio m=new Municipio(cod_municipio, id_provincia, nombre);
                lista.add(m);
                
            }
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return lista;     
    }
}
