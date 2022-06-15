package datos;

import dominio.Alumno;
import java.sql.*;
import java.util.*;

public class AlumnoDAO {
     //CONSULTAS SQL
    private static final String SQL_SELECT = "SELECT * FROM alumno";

    private static final String SQL_SELECT_BY_ID = "SELECT id_alumno,nombre_alumno,apellido_alumno,"
            + "edad_alumno,correo_alumno FROM alumno WHERE id_alumno=?";

    private static final String SQL_INSERT = "INSERT INTO alumno(nombre_alumno,apellido_alumno,"
            + "edad_alumno,correo_alumno) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE alumno SET nombre_alumno=?,apellido_alumno=?,"
            + "edad_alumno=?,correo_alumno=? WHERE id_alumno=?";

    private static final String SQL_DELETE = "DELETE FROM alumno WHERE id_alumno=?";

    //METODO LISTAR ALUMNOS
    public List<Alumno> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno alumno = null;

        List<Alumno> alumnos = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAlumno = rs.getInt("id_alumno");
                String nombreA = rs.getString("nombre_alumno");
                String apellidoA = rs.getString("apellido_alumno");
                int edadA = rs.getInt("edad_alumno");
                String correoA = rs.getString("correo_alumno");
                alumno = new Alumno(idAlumno, nombreA, apellidoA, 
                        edadA, correoA);
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return alumnos;
    }

    //METODO ENCONTRAR ALUMNO
    public Alumno encontrar(Alumno alumno) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, alumno.getIdAlumno());
            rs = stmt.executeQuery();
            rs.next();
            String nombreA = rs.getString("nombre_alumno");
            String apellidoA = rs.getString("apellido_alumno");
            int edadA = rs.getInt("edad_alumno");
            String correoA = rs.getString("correo_alumno");
            
            alumno.setNombre(nombreA);
            alumno.setApellido(apellidoA);
            alumno.setEdad(edadA);
            alumno.setCorreo(correoA);     
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return alumno;
    }
    //METODO INSERTAR ALUMNO
    public int insertar(Alumno alumno){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2,alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getCorreo());
            
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
    //METODO ACTUALIZAR ALUMNO
    public int actualizar(Alumno alumno){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2,alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getCorreo());
            stmt.setInt(5, alumno.getIdAlumno());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
    //METODO ELIMINAR ALUMNO
    public int eliminar(Alumno alumno){
        Connection con = null;
        PreparedStatement stmt = null;
        int registros=0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getIdAlumno());
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
