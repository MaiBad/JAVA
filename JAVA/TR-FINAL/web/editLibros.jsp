<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
              integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Modificar Libro</title>
    </head>
    <body>
        
        <!--CABECERO-->
        <jsp:include page="layouts/header.jsp"/>
      
        <section id="container-form">
        <div class="form-container">
            <div class="form-header">
                <h3 class="title">Editar Libro</h2>
            </div>
            <form class="form-edit"
                action="${pageContext.request.contextPath}/Controlador?accion=modificar&idLibro=${libro.idLibro}"
                method="POST">
                <input class="inputs" type="text" id="nombre" name="nombre" placeholder="Nombre"
                    value="${libro.nombreLibro}" required>
                <input class="inputs" type="text" id="autor" name="autor" placeholder="Autor"
                    value="${libro.autorLibro}" required>
                <input class="inputs" type="number" id="paginas" name="paginas" placeholder="Paginas"
                    value="${libro.paginasLibro}" required>
                <input class="inputs" type="text" id="editorial" name="editorial" placeholder="Editorial"
                    value="${libro.editorialLibro}" required>
                <input class="inputs" type="date" id="fecha" name="fecha" value="${libro.fechaLibro}" required>
                <input class="inputs save" type="submit" value="Guardar">
            </form>
            <a href="${pageContext.request.contextPath}/Controlador?accion=eliminar&idLibro=${libro.idLibro}"><button class="button-delete"><i class="fa-solid fa-trash"></i> Eliminar</button></a>
        </div>
    </section>
        
        <!--SCRIPT-->
        <script src="js/main.js"></script>
    </body>
</html>
