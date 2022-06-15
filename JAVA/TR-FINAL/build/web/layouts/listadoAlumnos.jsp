<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="alumno" items="${alumnos}">      
    <div class="card">
        <div class="item">
            <i class="fa-solid fa-user"></i>
            <ul class="list-info">
                <li class="item-info"><b>ID:</b> ${alumno.idAlumno}</li>
                <li class="item-info"><b>Nombre:</b>  ${alumno.nombre}</li>
                <li class="item-info"><b>Apellido:</b>  ${alumno.apellido}</li>
                <li class="item-info"><b>Edad:</b>  ${alumno.edad}</li>
                <li class="item-info"><b>Correo:</b>  ${alumno.correo}</li>
            </ul>
        </div>
        <div class="item-operation">
            <a href="${pageContext.request.contextPath}/ControladorA?accion=editarA&idAlumno=${alumno.idAlumno}"><button class="button"><i class="fa-solid fa-pen-to-square"></i> Modificar</button></a>
        </div>
    </div>
</c:forEach>