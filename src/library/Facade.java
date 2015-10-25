/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author julio
 */
public class Facade {
     
    public Collection<GestionDTO> obtenerLibros(GestionDTO q){
        
        GestionDAO gDAO = new GestionDAO();
        Collection<GestionDTO> coll = null;
        
         try {
            coll = gDAO.obtenerDatos("search",q);
        } catch (Exception ex) {
            Logger.getLogger
            (
                Window.class.getName()).log(Level.SEVERE, null, ex
            );
        }
            return coll;
    }
    
    public void altaLibro(GestionDTO q){
        GestionDAO gDAO = new GestionDAO();
               
        try {
            gDAO.obtenerDatos("insert",q);
        } catch (Exception ex) {
            Logger.getLogger
            (
                Window.class.getName()).log(Level.SEVERE, null, ex
            );
        }
    }
    
    public void eliminarLibro(GestionDTO q){
        
        GestionDAO gDAO = new GestionDAO();
        
        try 
        {
           gDAO.obtenerDatos("delete",q);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger
            (
                Window.class.getName()).log(Level.SEVERE, null, ex
            );
        }
    }
    
    public void actualizarLibros(GestionDTO q)
    {
        
        GestionDAO gDAO = new GestionDAO();
               
        try 
        {
            gDAO.obtenerDatos("update", q);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger
                (
                    Window.class.getName()).log(Level.SEVERE, null, ex
                );
        }
    }  
}
