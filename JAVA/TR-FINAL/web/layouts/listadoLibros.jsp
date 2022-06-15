<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="libro" items="${libros}">      
    <div class="card">
        <div class="item">
            <i class="fa-solid fa-book"></i>
            <ul class="list-info">
                <li class="item-info"><b>ID:</b> ${libro.idLibro}</li>
                <li class="item-info"><b>Nombre:</b>  ${libro.nombreLibro}</li>
                <li class="item-info"><b>Autor:</b>  ${libro.autorLibro}</li>
                <li class="item-info"><b>Paginas:</b>  ${libro.paginasLibro}</li>
                <li class="item-info"><b>Editorial:</b>  ${libro.editorialLibro}</li>
                <li class="item-info"><b>Fecha de lanzamiento:</b>  ${libro.fechaLibro}</li>  
            </ul>
        </div>
        <div class="item-operation">
            <a href="${pageContext.request.contextPath}/Controlador?accion=editar&idLibro=${libro.idLibro}"><button class="button"><i class="fa-solid fa-pen-to-square"></i> Modificar</button></a>
        </div>
    </div>
</c:forEach>