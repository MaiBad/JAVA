<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
          integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Alumnos</title>
</head>
<body>
    <body>
        
        <!--CABECERO-->
        <jsp:include page="layouts/header.jsp"/>
        
        <section id="container">
            <div class="list-cards">
                
                <!--LISTADO-->
                <jsp:include page="layouts/listadoAlumnos.jsp"/>
                
            </div>
                
            <!--INFO LATERAL-->
            <jsp:include page="layouts/asideAlumnos.jsp"/>
            
        </section>
            
        <!--MODAL ADD-->
        <jsp:include page="layouts/modalAlumnos.jsp"/>
        
        <!--SCRIPT-->
        <script src="js/main.js"></script>
    </body>
</body>
</html>