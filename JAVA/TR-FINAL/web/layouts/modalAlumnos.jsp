<div class="modal-container">
    <div class="modal modal-close">
        <div class="form-header">
            <h3 class="title">Añadir Alumno</h2>
            <button class="btn-close"><i class="fa-solid fa-xmark"></i></button>
        </div>
        <form class="form" action="${pageContext.request.contextPath}/ControladorA?accion=insertarA" 
              method="POST">
            <input class="inputs" type="text" id="nombre" name="nombre" placeholder="Nombre" required>
            <input class="inputs" type="text" id="apellido" name="apellido" placeholder="Apellido" required>
            <input class="inputs" type="number" id="edad" name="edad" placeholder="Edad" required>
            <input class="inputs" type="text" id="correo" name="correo" placeholder="Correo" required>
            <input class="inputs mod" type="submit" value="Añadir">
        </form>
    </div>
</div>