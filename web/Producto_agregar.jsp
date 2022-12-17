<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/agregar_producto.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script src="js/jquery-3.1.1.min.js"></script>
    </head>
    
    <body>
        <h2>Agregar Plato</h2>
        
        <div class="formulario">
            <form name="form">
                <div class="form-group">
                    <input id="nombre" type="text"  name="txtNombres" placeholder="Plato"class="form-control">
                </div>
                
                <div class="form-group">
                    <input id="precio" type="text" name="txtPre" placeholder="Precio" class="form-control">
                </div>
                
                <div class="form-group">
                    <input id="stock" type="text"  name="txtStock" placeholder="Cantidad"class="form-control">
                </div>
                
                <input id="agregarProducto" type="button" value="Agregar" class="btn btn-dark">
            </form>
        </div>
        
        <div> 
            <img src="img/polloani.gif" alt="75" width=75" />      
        </div>
        
        <script src="js/acciones.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
