<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        <script src="js/jquery-3.1.1.min.js"></script>
    </head>
    
    <body>
        <header style="background-color: white; opacity: .9;" >		
            <h3 style=" position: fixed;  left: 0;right: 0; ">[-- Empleados --]</h3>
        </header>
        
        <div class="d-flex">
            <div class="col-sm-8"style="padding-top: 4rem;">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th style="display: flex; justify-content: center; "> <img src="img/opciones.png" alt="32" height="32"/></th>  
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRE</th>
                            <th>APELLIDOS</th>
                            <th>TELEFONO</th>
                            <th>USUARIO</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>
                                    <a class="btn btn-danger"  href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getIdEmpleado()}">X</a>
                                    <a class="btn btn-dark" href="Controlador?menu=Empleado&accion=Editar&id=${em.getIdEmpleado()}">Editar</a>      
                                </td>

                                <td>${em.getIdEmpleado()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNombre()}</td>
                                <td>${em.getApellido()}</td>
                                <td>${em.getTelefono()}</td>
                                <td>${em.getUsuario()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <div style=" position: fixed;left:600px;right: 20px;text-align: center;">    
                <div class="card col-sm-4" style="border: 1px solid darkgray;box-shadow: 0 0 20px 1px rgba(0,0,0,0.3);margin-left: 400px;margin-top: 60px;">
                    <div class="card-body">
                        <div class="formulario" style="border-radius: 50px">
                            <h2 class="text-center">Editar Empleado</h2>
                            
                            <form name="form">
                                <div class="form-group">
                                    <input id="dni" type="text" value="${empleado.getDni()}" name="txtDni" placeholder="Dni" class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <input id="nombre" type="text" value="${empleado.getNombre()}" name="txtNombres" placeholder="Nombre"class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <input id="apellido" type="text"  value="${empleado.getApellido()}"name="txtApellidos" placeholder="Apellido" class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <input id="telefono" type="text" value="${empleado.getTelefono()}" name="txtTelefono" placeholder="Telefono"class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <input id="usuario" type="text" value="${empleado.getUsuario()}" name= "txtUsuario" placeholder="Usuario" class="form-control">
                                </div>
                                
                                <input id="actualizarEmpleado" type="button" value="Actualizar" class="btn btn-success">
                            </form>
                        </div>
                    </div>  
                </div>  
            </div>           
        </div>
                                
        <script src="js/acciones.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
