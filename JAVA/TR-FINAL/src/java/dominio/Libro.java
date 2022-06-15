package dominio;

public class Libro {
    
    private int idLibro,paginasLibro;
    private String nombreLibro,autorLibro,editorialLibro,fechaLibro;

    public Libro() {
    }

    public Libro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(String nombreLibro, String autorLibro,int paginasLibro, 
            String editorialLibro, String fechaLibro) {
        this.paginasLibro = paginasLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        this.editorialLibro = editorialLibro;
        this.fechaLibro = fechaLibro;
    }

    public Libro(int idLibro, String nombreLibro, 
            String autorLibro,int paginasLibro, String editorialLibro, String fechaLibro) {
        this.idLibro = idLibro;
        this.paginasLibro = paginasLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        this.editorialLibro = editorialLibro;
        this.fechaLibro = fechaLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getPaginasLibro() {
        return paginasLibro;
    }

    public void setPaginasLibro(int paginasLibro) {
        this.paginasLibro = paginasLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getEditorialLibro() {
        return editorialLibro;
    }

    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    public String getFechaLibro() {
        return fechaLibro;
    }

    public void setFechaLibro(String fechaLibro) {
        this.fechaLibro = fechaLibro;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", paginasLibro=" + paginasLibro + ", nombreLibro=" + nombreLibro + ", autorLibro=" + autorLibro + ", editorialLibro=" + editorialLibro + ", fechaLibro=" + fechaLibro + '}';
    }
    
    
}
