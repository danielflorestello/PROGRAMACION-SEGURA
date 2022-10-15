<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Iniciar Sesion</title>
        <link rel="shorcut icon" type="image/x-icon" href="img/iconoPollo.png">
    </head>

    <body>
        <aside class="izquierda">
            <div>
                <div >
                    <div>
                        <form class="formulario" action="Validar" method="POST">
                            <div class="form-group text-center"> 
                                <img src="img/loginPollo.png" alt="70" width="70"/>
                            </div>

                            <div class="form-group"> 
                                <input type="text" name="txtuser" placeholder="Usuario" class="form-control">
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input id="input" type="password" name="txtpass" placeholder="Contraseña" class="form-control">
                                    </div>
                                    
                                    <div id="boton" class="btn btn-secondary align-self-center"><span id="icon" class="bi bi-eye"></span></div>
                                </div>
                            </div>

                            <input type="submit" name="accion" value="Ingresar" class="btn btn-danger btn-block">
                        </form>
                    </div>
                </div>
            </div>
        </aside> 

        <aside class="derecha">
            <img src="img/LogoPollo.jpg" alt="630" width=630"/>
        </aside>
        
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/login.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
