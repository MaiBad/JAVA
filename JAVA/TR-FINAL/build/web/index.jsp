<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Bienvenido</title>
    <style>
        body{
            background:linear-gradient(0,rgba(0, 0, 0, 0.8),rgba(0, 0, 0, 0.8)),url(${pageContext.request.contextPath}/img/fondo.jpg);
            background-attachment: fixed;
            background-position: center;
            background-size: cover;
        }
    </style>
</head>
<body>
    <!--CABECERO-->
    <jsp:include page="layouts/header.jsp"/>
        
    <section id="container">
        <h1 class="title">LA GRAN BIBLIOTECA</h1>
        <a href="layouts/refresh/reLibros.jsp">
            <button class="button">Empezar <i class="fa-solid fa-angle-right"></i></button></a>
    </section>
    
    <!--SCRIPT-->
<script src="js/main.js"></script>
</body>
</html>