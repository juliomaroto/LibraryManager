/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import static com.sun.javafx.PlatformUtil.isLinux;
import static com.sun.javafx.PlatformUtil.isWindows;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionDAO{
    
    public String searchQuery (GestionDTO q){
               
    return "select * from Library where nombre like '"+q.getNombre()+"%' and isbn like '"+q.getIsbn()+"%' and author like '"+q.getAutor()+"%' and genre like '"+q.getGenre()+"%';";
        
    }
    
    public String updateQuery(GestionDTO q){
      
       return "UPDATE Library SET nombre='"+q.getNombre()+"',author='"+q.getAutor()+"', price='"+q.getPrecio()+"', genre ='"+q.getGenre()+"', publisher='"+q.getEditorial()+"', isbn='"+q.getIsbn()+"', pages='"+q.getPaginas()+"', stock='"+q.getStock()+"' where id ='"+q.getId()+"';";
    }
    
    public String insertQuery(GestionDTO q){
        
        return "insert into Library(nombre, price, author, genre, publisher, isbn, pages, stock)"
                + "VALUES('"+q.getNombre()+"', '"+q.getPrecio()+"', '"+q.getAutor()+"', '"+q.getGenre()+"' , '"+q.getEditorial()+"', '"+q.getIsbn()+"', '"+q.getPaginas()+"', '"+q.getStock()+"');";      
    }
    
    public String deleteQuery(GestionDTO q){
        
        return "delete from Library where id ='"+q.getId()+"'";
    }
    
    public Collection<GestionDTO> obtenerDatos(String tQuery, GestionDTO q ) throws Exception{
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String args = null;
        
        
        ArrayList<GestionDTO> ret = null;
        
        try {
             
            Class.forName("org.sqlite.JDBC");
            
            String OS = System.getProperty("os.name").toLowerCase();
            
            if(isWindows()){
               con = DriverManager.getConnection("jdbc:sqlite:.\\src\\res\\db\\gestion.db");
            } else if (isLinux()) {
                con = DriverManager.getConnection("jdbc:sqlite:./src/res/db/gestion.db");
            }
 
            stmt = con.createStatement();
            
            switch (tQuery) {
                case "update":
                case "insert":
                case "delete":
                    switch (tQuery) {
                        case "update":
                            args = this.updateQuery(q);
                            break;
                        case "insert":
                            args = this.insertQuery(q);
                            break;
                        case "delete":
                            args = this.deleteQuery(q);
                            break;
                    }
                    
                    stmt.executeUpdate(args);
                    
                    con.setAutoCommit(true);
                    return null;
                    
                case "search":
                    args = this.searchQuery(q);
                    rs = stmt.executeQuery(args);
                    
                    ret = new ArrayList<>();
                    
                    GestionDTO dto = null;
                    
                    while(rs.next()){
                        dto = new GestionDTO();
                        dto.setId(rs.getLong("id"));
                        dto.setNombre(rs.getString("nombre"));
                        dto.setPrecio(rs.getDouble("price"));
                        dto.setAutor(rs.getString("author"));
                        dto.setGenre(rs.getString("genre"));
                        dto.setEditorial(rs.getString("publisher"));
                        dto.setIsbn(rs.getString("isbn"));
                        dto.setPaginas(rs.getLong("pages"));
                        dto.setStock(rs.getLong("stock"));
                        ret.add(dto);
                    }    
            }
            return ret;
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs!=null) rs.close();
                if (stmt != null) stmt.close();
            } catch(Exception ex){
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
}
       
    
