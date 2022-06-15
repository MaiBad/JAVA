<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
    <thead class="table-head">
        <tr>
            <th>ID</th>
            <th>ALUMNO</th>
            <th>LIBRO</th>
            <th>FECHA DE PR�STAMO</th>
            <th>FECHA DE DEVOLUCI�N</ht>
        </tr>
    </thead>
    <tbody class="table-body">
        <c:forEach var="prestamo" items="${prestamos}"> 
        <tr>
            <td>${prestamo.idPrestamo}</td>
            <td>${prestamo.alumnoO}</td>
            <td>${prestamo.libroO}</td>
            <td>${prestamo.fechaI}</td>
            <td>${prestamo.fechaF}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>