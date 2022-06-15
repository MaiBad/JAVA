package dominio;

public class Prestamo {
    private int idPrestamo;
    private String fechaI;
    private String fechaF;
    private int alumno,libro;
    
    private String alumnoO,libroO;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo(String fechaI, String fechaF, int alumno, int libro) {
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.alumno = alumno;
        this.libro = libro;
    }

    public Prestamo(int idPrestamo, String fechaI, String fechaF, int alumno, int libro) {
        this.idPrestamo = idPrestamo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.alumno = alumno;
        this.libro = libro;
    }
    
     public Prestamo(int idPrestamo, String fechaI, String fechaF, String alumnoO, String libroO) {
        this.idPrestamo = idPrestamo;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.alumnoO = alumnoO;
        this.libroO = libroO;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }
 
    public String getAlumnoO() {
        return alumnoO;
    }

    public void setAlumnoO(String alumnoO) {
        this.alumnoO = alumnoO;
    }

    public String getLibroO() {
        return libroO;
    }

    public void setLibroO(String libroO) {
        this.libroO = libroO;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", fechaI=" + fechaI + ", fechaF=" + fechaF + ", alumno=" + alumno + ", libro=" + libro + ", alumnoO=" + alumnoO + ", libroO=" + libroO + '}';
    }


    
    
    
    
}
