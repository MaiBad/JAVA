package web;

import datos.AlumnoDAO;
import dominio.Alumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorA")
public class ControladorA extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "editarA":
                    this.editarAlumno(request, response);
                    break;
                case "eliminarA":
                    this.eliminarAlumno(request, response);
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
        List<Alumno> alumnos = new AlumnoDAO().listar();
        //LISTA DE ALUMNOS
        request.setAttribute("alumnos",alumnos);
        //NUMERO DE ALUMNOS
        request.setAttribute("totalAlumnos",alumnos.size());
        request.getRequestDispatcher("alumnos.jsp").forward(request,response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){
                case "insertarA":
                    this.insertarAlumno(request, response);
                    break;
                case "modificarA":
                    this.modificarAlumno(request, response);
                    break;
                default:
                    this.accionDefault(request,response);
            }
        }else{
            this.accionDefault(request,response);
        }
    }
    
    //MÉTODO PARA INSERTAR ALUMNO
    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        int edad=Integer.parseInt(request.getParameter("edad"));
        String correo=request.getParameter("correo");
        
        Alumno alumno = new Alumno(nombre,apellido,edad,correo);
        
        int registrosModificados = new AlumnoDAO().insertar(alumno);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    } 
    //MÉTODO PARA EDITAR ALUMNO
    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        Alumno alumno = new AlumnoDAO().encontrar(new Alumno(idAlumno));
        request.setAttribute("alumno",alumno);
        request.getRequestDispatcher("editAlumnos.jsp").forward(request,response);
    }
    //MÉTODO PARA MODIFICAR ALUMNO
    private void modificarAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("idAlumno"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        int edad=Integer.parseInt(request.getParameter("edad"));
        String correo=request.getParameter("correo");
        
        Alumno alumno = new Alumno(id,nombre,apellido,edad,correo);
        
        int registrosModificados = new AlumnoDAO().actualizar(alumno);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    }
    //MÉTODO PARA ELIMINAR ALUMNO
    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("idAlumno"));
        
        Alumno alumno = new Alumno(id);
        
        int registrosModificados = new AlumnoDAO().eliminar(alumno);
        System.out.println("registrosModificados = "+registrosModificados);
        
        this.accionDefault(request, response);
    }
}
