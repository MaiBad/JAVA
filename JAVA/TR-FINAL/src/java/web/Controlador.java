package web;

import datos.*;
import dominio.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "editar":
                    this.editarLibro(request, response);
                    break;
                case "eliminar":
                    this.eliminarLibro(request, response);
                    break;      
                default:
                    this.accionDefault(request,response);
            }
        }else{
            this.accionDefault(request,response);
        }
    }
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        List<Libro> libros = new LibroDAO().listar();
        List<Alumno> alumnos = new AlumnoDAO().listar();
        System.out.println("libros = "+libros);
        //LISTA DE LIBROS
        request.setAttribute("libros",libros);
        //NUMERO DE LIBROS
        request.setAttribute("totalLibros",libros.size());
        request.getRequestDispatcher("libros.jsp").forward(request,response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "insertar":
                    this.insertarLibro(request, response);
                    break;
                case "modificar":
                    this.modificarLibro(request, response);
                    break;
                default:
                    this.accionDefault(request,response);
            }
        }else{
            this.accionDefault(request,response);
        }
    }
    //MÉTODO PARA INSERTAR LIBRO
    private void insertarLibro(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String nombre=request.getParameter("nombre");
        String autor=request.getParameter("autor");
        int paginas=Integer.parseInt(request.getParameter("paginas"));
        String editorial=request.getParameter("editorial");
        String fecha=request.getParameter("fecha");
        
        Libro libro = new Libro(nombre,autor,paginas,editorial,fecha);
        
        int registrosModificados = new LibroDAO().insertar(libro);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    } 
    //MÉTODO PARA EDITAR LIBRO
    private void editarLibro(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        Libro libro = new LibroDAO().encontrar(new Libro(idLibro));
        request.setAttribute("libro",libro);
        request.getRequestDispatcher("editLibros.jsp").forward(request,response);
    }
    //MÉTODO PARA MODIFICAR LIBRO
    private void modificarLibro(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("idLibro"));
        String nombre=request.getParameter("nombre");
        String autor=request.getParameter("autor");
        int paginas=Integer.parseInt(request.getParameter("paginas"));
        String editorial=request.getParameter("editorial");
        String fecha=request.getParameter("fecha");
        
        Libro libro = new Libro(id,nombre,autor,paginas,editorial,fecha);
        
        int registrosModificados = new LibroDAO().actualizar(libro);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    }
    //MÉTODO PARA ELIMINAR LIBRO
    private void eliminarLibro(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("idLibro"));
        
        Libro libro = new Libro(id);
        
        int registrosModificados = new LibroDAO().eliminar(libro);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    }
}
