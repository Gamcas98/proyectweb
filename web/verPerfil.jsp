

    <%@page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Ver Perfil</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrapp.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/resume.min.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>


    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Nombre del wey</span>
                <span class="d-none d-lg-block">
                    <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="images/profile.jpg" alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <%@include file="/ArchivosHTML/barraPerfil.html"  %>
                </ul>
            </div>
        </nav>

        <div class="container-fluid p-0">

            <%@include file="contenidoPerfil.jsp"  %>
        </div>



        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jqueryp.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/resume.min.js"></script>

    </body>

</html>
