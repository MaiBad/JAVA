package datos;

import dominio.Libro;
import java.sql.*;
import java.util.*;

public class LibroDAO {

    //CONSULTAS SQL
    private static final String SQL_SELECT = "SELECT * FROM libro";

    private static final String SQL_SELECT_BY_ID = "SELECT id_libro,nombre_libro,autor_libro,"
            + "paginas_libro,editorial_libro,fecha_libro FROM libro WHERE id_libro=?";

    private static final String SQL_INSERT = "INSERT INTO libro(nombre_libro,autor_libro,"
            + "paginas_libro,editorial_libro,fecha_libro) VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE libro SET nombre_libro=?,autor_libro=?,"
            + "paginas_libro=?,editorial_libro=?,fecha_libro=? WHERE id_libro=?";

    private static final String SQL_DELETE = "DELETE FROM libro WHERE id_libro=?";

    //METODO LISTAR LIBROS
    public List<Libro> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Libro libro = null;

        List<Libro> libros = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idLibro = rs.getInt("id_libro");
                String nombreLibro = rs.getString("nombre_libro");
                String autorLibro = rs.getString("autor_libro");
                int paginasLibro = rs.getInt("paginas_libro");
                String editorialLibro = rs.getString("editorial_libro");
                String fechaLibro = rs.getString("fecha_libro");
                libro = new Libro(idLibro, nombreLibro, autorLibro, 
                        paginasLibro, editorialLibro, fechaLibro);
                libros.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return libros;
    }

    //METODO ENCONTRAR LIBRO
    public Libro encontrar(Libro libro) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, libro.getIdLibro());
            rs = stmt.executeQuery();
            rs.next();
                String nombreLibro = rs.getString("nombre_libro");
            String autorLibro = rs.getString("autor_libro");
            int paginasLibro = rs.getInt("paginas_libro");
            String editorialLibro = rs.getString("editorial_libro");
            String fechaLibro = rs.getString("fecha_libro");
            
            libro.setNombreLibro(nombreLibro);
            libro.setAutorLibro(autorLibro);
            libro.setPaginasLibro(paginasLibro);
            libro.setEditorialLibro(editorialLibro);
            libro.setFechaLibro(fechaLibro);
            
            
            
        } catch (SQLException ex) {
            System.out.println("");
            ex.printStackTrace(System.out);
            
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return libro;
    }
    //METODO INSERTAR LIBRO
    public int insertar(Libro libro){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, libro.getNombreLibro());
            stmt.setString(2,libro.getAutorLibro());
            stmt.setInt(3, libro.getPaginasLibro());
            stmt.setString(4, libro.getEditorialLibro());
            stmt.setString(5, libro.getFechaLibro());
            
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
    //METODO ACTUALIZAR LIBRO
    public int actualizar(Libro libro){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, libro.getNombreLibro());
            stmt.setString(2,libro.getAutorLibro());
            stmt.setInt(3, libro.getPaginasLibro());
            stmt.setString(4, libro.getEditorialLibro());
            stmt.setString(5, libro.getFechaLibro());
            stmt.setInt(6, libro.getIdLibro());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
    //METODO ELIMINAR LIBRO
    public int eliminar(Libro libro){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, libro.getIdLibro());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
}
