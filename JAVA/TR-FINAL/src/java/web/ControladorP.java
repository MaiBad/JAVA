package web;

import datos.AlumnoDAO;
import datos.LibroDAO;
import datos.PrestamoDAO;
import dominio.Alumno;
import dominio.Libro;
import dominio.Prestamo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorP")
public class ControladorP extends HttpServlet{
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        this.cargarAlumnos(request);
        this.cargarLibros(request);
        List<Prestamo> prestamos = new PrestamoDAO().listar();
        //LISTA DE PRESTAMOS
        request.setAttribute("prestamos",prestamos);
        //NUMERO DE PRESTAMOS
        request.setAttribute("totalPrestamos",prestamos.size());
        request.getRequestDispatcher("prestamos.jsp").forward(request,response); 
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        this.accionDefault(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "insertarP":
                    this.insertarPrestamo(request, response);
                    break;
                default:
                    this.accionDefault(request,response);
            }
        }else{
            this.accionDefault(request,response);
        }
    }
    //MÉTODO PARA INSERTAR PRESTAMO
    private void insertarPrestamo(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String fechai=request.getParameter("fechai");
        String fechaf=request.getParameter("fechaf");
        int alumno=Integer.parseInt(request.getParameter("alumno"));
        int libro=Integer.parseInt(request.getParameter("libro"));
        
        Prestamo prestamo = new Prestamo(fechai,fechaf,alumno,libro);
        
        int registrosModificados = new PrestamoDAO().insertar(prestamo);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    } 
   
    //CARGAR ALUMNOS EN EL COMBOBOX
    private void cargarAlumnos(HttpServletRequest request){
        AlumnoDAO a=new AlumnoDAO();
        List<Alumno> alumnos = null;
        try{
            alumnos=a.listar();
            request.setAttribute("alumnos", alumnos);
        }catch(Exception e){
            System.out.println("No se puedo cargar los alumnos!");
        }finally{
            a=null;
            alumnos=null;
        }
    }
    
    //CARGAR LIBROS EN EL COMBOBOX
    private void cargarLibros(HttpServletRequest request){
        LibroDAO l=new LibroDAO();
        List<Libro> libros = null;
        try{
            libros=l.listar();
            request.setAttribute("libros", libros);
        }catch(Exception e){
            System.out.println("No se puedo cargar los libros!");
        }finally{
            l=null;
            libros=null;
        }
    }
}
