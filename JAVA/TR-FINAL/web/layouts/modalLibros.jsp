<div class="modal-container">
    <div class="modal modal-close">
        <div class="form-header">
            <h3 class="title">Añadir Libro</h2>
            <button class="btn-close"><i class="fa-solid fa-xmark"></i></button>
        </div>
        <form class="form" action="${pageContext.request.contextPath}/Controlador?accion=insertar" 
              method="POST">
            <input class="inputs" type="text" id="nombre" name="nombre" placeholder="Nombre" required>
            <input class="inputs" type="text" id="autor" name="autor" placeholder="Autor" required>
            <input class="inputs" type="number" id="paginas" name="paginas" placeholder="Paginas" required>
            <input class="inputs" type="text" id="editorial" name="editorial" placeholder="Editorial" required>
            <input class="inputs" type="date" id="fecha" name="fecha" required>
            <input class="inputs mod" type="submit" value="Añadir">
        </form>
    </div>
</div>