<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/agregar_empleado.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <body>
        <h2>Agregar Empleado</h2>
        
        <div class="formulario">
            <form  action="Controlador?menu=Empleado" method="POST">
                <div class="form-group">
                    <input type="text" value="${empleado.getDni()}" name="txtDni" placeholder="Dni" class="form-control">
                </div>
                
                <div class="form-group">
                    <input type="text" value="${empleado.getNom()}" name="txtNombres" placeholder="Nombre"class="form-control">
                </div>
                
                <div class="form-group">
                    <input type="text"  value="${empleado.getApe()}"name="txtApellidos" placeholder="Apellido" class="form-control">
                </div>
                
                <div class="form-group">
                    <input type="text" value="${empleado.getTel()}" name="txtTelefono" placeholder="Telefono"class="form-control">
                </div>
                
                <div class="form-group">
                    <input type="text" value="${empleado.getUser()}" name= "txtUsuario" placeholder="Usuario" class="form-control">
                </div>
                
                <input type="submit" name="accion" value="Agregar" class="btn btn-dark">
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
