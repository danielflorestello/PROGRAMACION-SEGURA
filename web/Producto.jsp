<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/estilos-cliente.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <body>
        <div class="contenedor">
            <header>		
                <h3 style=" position: fixed; background-color: white; opacity: .9; left: 0;right: 0; ">[-- Platos --]</h3>
            </header>
            
            <div class="col-sm-15" style="padding-top: 4rem;">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th style="display: flex; "> <img src="img/opciones.png" alt="32" height="32"/></th>
                            <th>CODIGO</th>                        
                            <th>NOMBRE</th>
                            <th>PRECIO</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach var="pro" items="${producto}">
                            <tr>
                                <td>
                                    <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&id=${pro.getId()}">Eliminar</a>
                                </td>

                                <td>${pro.getId()}</td>
                                <td>${pro.getNom()}</td>
                                <td>S/. ${pro.getPrec()}</td>
                                <td>${pro.getStock()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>           

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
