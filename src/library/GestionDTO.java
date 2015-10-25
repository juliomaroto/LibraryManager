/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author julio
 */
public class GestionDTO 
{    
    private long id = 0, stock = 0, paginas = 0;
    private double precio = 0;

    private String nombre ="", autor ="", editorial ="", isbn="", genre = "";
 
    GestionDTO(){};

    GestionDTO
        
        (
            long id,
            String nombre,
            double precio, 
            String autor,
            String genero,
            String editorial,
            String isbn,
            long paginas,
            long stock
        )
    {
    
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
        genre = genero;
        this.editorial = editorial;
        this.isbn = isbn;
        this.paginas = paginas;
        this.stock = stock;
    
    }
    
    
    GestionDTO (String sBookName, String sIsbn, String sAutor, String sGenre){
        nombre = sBookName;
        autor = sAutor;
        genre = sGenre;
        isbn = sIsbn;
        
    }
    
    GestionDTO
        (
            String nombre,
            double precio,
            String autor,
            String genero, 
            String editorial, 
            String isbn, 
            int paginas,
            long stock
        )
    {
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
        genre = genero;
        this.editorial = editorial;
        this.isbn = isbn;
        this.paginas = paginas;
        this.stock = stock;
    }
    
//Getters y setters
    
    /**
     * @return the id
     */
    public long getId() 
    {
        return id;
    }

    /**
     * @return the stock
     */
    public long getStock() 
    {
        return stock;
    }

    /**
     * @return the nombre
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * @return the autor
     */
    public String getAutor() 
    {
        return autor;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() 
    {
        return editorial;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() 
    {
        return isbn;
    }

    /**
     * @return the genre
     */
    public String getGenre() 
    {
        return genre;
    }

    /**
     * @return the args
     */

    /**
     * @return the precio
     */
    public double getPrecio() 
    {
        return precio;
    }

    /**
     * @return the paginas
     */
    public long getPaginas() 
    {
        return paginas;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) 
    {
        this.id = id;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(long stock) 
    {
        this.stock = stock;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) 
    {
        this.autor = autor;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) 
    {
        this.editorial = editorial;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) 
    {
        this.genre = genre;
    }

    /**
     * @param args the args to set
     */
  

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(long paginas) 
    {
        this.paginas = paginas;
    }
}
