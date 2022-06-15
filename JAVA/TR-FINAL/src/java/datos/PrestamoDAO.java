package datos;

import dominio.Prestamo;
import java.sql.*;
import java.util.*;

public class PrestamoDAO {

    //CONSULTAS SQL
    private static final String SQL_SELECT = "SELECT p.id_prestamo,p.fecha_ini,p.fecha_fin,concat_ws(SPACE(1),a.nombre_alumno,a.apellido_alumno) AS alumno,l.nombre_libro FROM prestamo p\n"
            + "INNER JOIN alumno a ON p.id_alumno=a.id_alumno\n"
            + "INNER JOIN libro l ON p.id_libro=l.id_libro;";

    private static final String SQL_INSERT = "INSERT INTO prestamo(fecha_ini,"
            + "fecha_fin,id_alumno,id_libro) VALUES(?,?,?,?)";

    //METODO LISTAR PRESTAMOS
    public List<Prestamo> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Prestamo pres = null;

        List<Prestamo> prestamos = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPrestamo = rs.getInt("id_prestamo");
                String fechaI = rs.getString("fecha_ini");
                String fechaF = rs.getString("fecha_fin");
                String alumno = rs.getString("alumno");
                String libro = rs.getString("nombre_libro");
                pres = new Prestamo(idPrestamo, fechaI, fechaF, alumno, libro);
                prestamos.add(pres);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return prestamos;
    }
    //METODO INSERTAR LIBRO
    public int insertar(Prestamo prestamo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, prestamo.getFechaI());
            stmt.setString(2, prestamo.getFechaF());
            stmt.setInt(3, prestamo.getAlumno());
            stmt.setInt(4, prestamo.getLibro());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return registros;
    }
}
