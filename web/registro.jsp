
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Registro Usuario</title>
        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Font-->
        <link rel="stylesheet" type="text/css" href="css/opensans-font.css">
        <link rel="stylesheet" type="text/css" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
        <!-- Main Style Css -->
        <link rel="stylesheet" href="css/styler.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="css/main.css">

    </head>
    <body>
        <div class="page-content">
            <div class="form-v1-content">
                <div class="wizard-form">
                    <form class="form-register" action="RegistrarUsuario" method="post" enctype="multipart/form-data">
                        <div id="form-total">

                            <!-- SECTION 1 -->
                            <h2>
                                <p class="step-icon"><span>01</span></p>
                                <span class="step-text">Informacion Personal</span>
                            </h2>

                            <section>
                                <div class="wizard-header">
                                    <h3 class="heading">Informacion Personal</h3>
                                    <p>Por favor ingrese su informacion personal</p>
                                </div>

                                <%@include file="/ArchivosHTML/datosUsuario.html" %>
                                <!-- SECTION 2 -->
                            </section>
                            <h2>
                                <p class="step-icon"><span>02</span></p>
                                <span class="step-text">Informacion de la cuenta</span>
                            </h2>
                            <section>
                                <div class="inner">
                                    <div class="wizard-header">
                                        <h3 class="heading">Informacion de la cuenta</h3>
                                        <p>Por favor ingrese la informacion para iniciar sesion dentro del sistema</p>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-holder form-holder-2">
                                            <fieldset>
                                                <legend>User</legend>
                                                <input type="text" name="user" id="user" class="form-control"placeholder="Your User" required>
                                            </fieldset>
                                        </div>
                                    </div>



                                    <div class="form-row">
                                        <div class="form-holder form-holder-2">
                                            <fieldset>
                                                <legend>Password</legend>
                                                <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" required>
                                            </fieldset>
                                        </div>

                                    </div>
                                    <div class="form-row">

                                        <div class="form-holder form-holder-2">
                                            <div class="value">
                                                <div class="input-group">
                                                    <div class="rs-select2 js-select-simple select--no-search">
                                                        <select name="subject" required>
                                                            <option value="">Choose option</option>
                                                            <option value="1">Editor</option>
                                                            <option value="2">Suscriptor</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="container-login100-form-btn">

                                        <button class="login100-form-btn">
                                            Completar Registro
                                        </button>

                                    </div>

                                </div>

                        </div>

                    </form>
                    <div class="container-login100-form-btn">
                        <a href="login.jsp">
                            <button class="btn-block">
                                Ya tienes una cuenta? Inicia sesion
                            </button>
                        </a>
                    </div>
                </div>
            </div>

        </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery.steps.js"></script>
    <script src="js/mainr.js"></script>

</body>
</html>