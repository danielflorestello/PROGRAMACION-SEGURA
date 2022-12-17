<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos_principal.css" rel="stylesheet" type="text/css"/>
        <title>POLLERIA</title>
        <link rel="shorcut icon" type="image/x-icon" href="img/iconoPollo.png">
    </head>
    
    <body>
        <form action="Validar" method="POST">
            <div style="text-align: center;
                 background: white;
                 display: none;
                 width: 30%;
                 padding: 33px;
                 border-radius:10px;
                 position: absolute;
                 left: 35%;
                 top: 30%;
                 box-shadow: 0 0 50px 10px rgba(0,0,0,0.3);" class="Ventana-cerrar" id="ventana">

                <h3> ${usuario.getNombre()}, ¿seguro que quiere cerrar sesion?</h3>
                <button name="accion" value="Salir" href="#" class=" btn btn-success  btn-lg">SI</button>
                <button class=" btn btn-danger  btn-lg"><a style="color: white;text-decoration: none;" href="javascript:cerrarr()">No</a></button>
            </div>
        </form>
                
        <nav class="navbar navbar-expand-lg navbar-light bg-danger">              
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNav" >
                <ul class="navbar-nav" >
                    <li class="nav-item active">
                        <a style="color: white" class="nav-link" ><strong>POLLERIA</strong></a>
                    </li>
                </ul>
            </div>
            
            <!-- PARA AGREGAR-->        
            <div class="dropdown-container">
                <span style="color: white; padding: 10px 20px 10px 20px;">Opciones</span>
                <ul>
                    <li>
                        <a style="color: white"class="nav-link " href="Controlador?menu=Agregar_empleado" target="myFrame">Agregar Empleado</a>
                    </li>
                </ul>

            </div>

            <!-- PARA INFORMACION-->
            <div class="dropdown-container">
                <span style="color: white; padding: 10px 20px 10px 20px;">Informacion</span>
                
                <ul>
                    <li>
                        <a style="color: white"class="nav-link" class="dropdown-item"href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                        <div class="dropdown-divider"></div>
                        <a style="color: white"class="nav-link" class="dropdown-item" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        <div class="dropdown-divider"></div>
                        <a style="color: white"class="nav-link "class="dropdown-item" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Cliente</a>
                    </li>
                </ul>
            </div>

            <div class="dropdown" >
                <button class=" btn btn-danger"><a href="javascript:abrir()"><img src="img/apagado.png" alt="30" width="20"/></a></button>
            </div>
        </nav>
                
        <div class="container mt-10" >
            <h1>Bienvenido, <strong>${usuario.getNombre()}</strong> <strong>${usuario.getApellido()}</strong></h1>
        </div>
        
        <script  type="text/javascript">
            function abrir() {
                document.getElementById("ventana").style.display = "block";
            }
            
            function cerrarr() {
                document.getElementById("ventana").style.display = "none";
            }
        </script>
        
        <c:if test="${empty usuario}">
            <script>
                window.addEventListener("load",function(){
                    location.href = "../index.jsp";
                });
            </script>
        </c:if>
                
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
