<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-container">
    <div class="modal modal-close">
        <div class="form-header">
            <h3 class="title">Añadir Prestamo</h2>
            <button class="btn-close"><i class="fa-solid fa-xmark"></i></button>
        </div>
        <form class="form" action="${pageContext.request.contextPath}/ControladorP?accion=insertarP" 
              method="POST">
            <input class="inputs" type="date" id="fechai" name="fechai" placeholder="Fecha de prestamo"  required>
            <input class="inputs" type="date" id="fechaf" name="fechaf" placeholder="Fecha de devolución" required>
                
            <select class="inputs" name="alumno">
                <c:forEach var="alum" items="${alumnos}">
                    <option value="${alum.idAlumno}"
                            <c:if test="${alum.idAlumno}==${prestamo.alumno.idAlumno}"> 
                                selected
                            </c:if>
                            >${alum.nombre} ${alum.apellido}</option>
                </c:forEach>
            </select>
             <select class="inputs" name="libro">
                <c:forEach var="lib" items="${libros}">
                    <option value="${lib.idLibro}"
                            <c:if test="${lib.idLibro}==${prestamo.libro.idLibro}"> 
                                selected
                            </c:if>
                            >${lib.nombreLibro}</option>
                </c:forEach>
            </select>
            <input class="inputs mod" type="submit" value="Añadir">
        </form>
    </div>
</div>