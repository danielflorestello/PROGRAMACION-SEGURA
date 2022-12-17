<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        
        <style>
            @media print{
                .parte01,.parte02, .btn{
                    display: none;
                }
            }
        </style>
    </head>
    
    <body>
        <div style="display:flex;">
            <div class="col-sm-4 parte01">
                <div class="card "style="border-radius: 10px;border: 1px solid darkgray;box-shadow: 0 0 20px 1px rgba(0,0,0,0.3);margin-top: 60px;">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group" >
                                <label>Datos del Clientes</label>
                            </div>
                            
                            <div class="form-group d-flex">
                                <div class="col-sm-6 ">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="DNI">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-dark">Buscar</button>
                                </div>
                                    
                                <div class="col-sm-6">
                                    <input type="text" name="nombresclientes" value="${c.getNom()} ${c.getApe()}" placeholder="Datos Cliente"class="form-control ">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label> Datos del plato</label>
                            </div>
                                
                            <div class="form-group d-flex">
                                <div class="col-sm-6 ">
                                    <input type="text" name="codigoproducto"  value="${producto.getId()}"class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-dark">Buscar</button>
                                </div>
                                    
                                <div class="col-sm-6">
                                    <input type="text" name="nombresproducto" value="${producto.getNom()} " class="form-control"placeholder="Datos Producto">
                                </div>
                            </div>
                                
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrec()}" class="form-control" placeholder="s/.0.00">
                                </div>
                                
                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" min="1" placeholder="" class="form-control">
                                </div>
                                
                                <div class="col-sm-3">
                                    <input type="text" name="stock"  value="${producto.getStock()}" placeholder="" class="form-control" readonly="">
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-success">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <div class="col-sm-4">
                <div class="card" style="border-radius: 10px;border: 1px solid darkgray;box-shadow: 0 0 20px 1px rgba(0,0,0,0.3);margin-top: 60px;">
                    <div class="card-body">
                        <div style="display: flex; justify-content: center;">
                            <img src="img/iconoPollo.png" alt="100" width="100" />
                        </div>
                        
                        <div class="d-flex col-sm-8 ">
                            <label>Nro.Serie: </label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>N°</th>                                    
                                    <th>Plato</th>                                    
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>

                                </tr>
                            </thead>
                            
                            <tbody>
                                <c:forEach var="lista" items="${lista}" >
                                    <tr>
                                        <td>${lista.getItem()}</td>                                   
                                        <td>${lista.getDescripcionP()}</td>
                                        <td>${lista.getCantidad()}</td>
                                        <td>${lista.getSubtotal()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                        
                    <div class="card-footer">
                        <div class="col-sm-8">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class=" btn btn-success">Generar Venta</a>           
                            <a href="Controlador?menu=NuevaVenta&accion=Cancelar"  class=" btn btn-danger">Cancelar</a>
                        </div>
                        
                        <div class="col-sm-6 ml-auto">
                            <div><label>Total</label></div>
                            <input type="text" name="txtTotal"  value="S/. ${totalpagar}"class="from-control">
                        </div>
                    </div>
                </div>
            </div>

            <div class="card parte02" style="  border-radius: 5px;box-shadow: 0 0 20px 1px rgba(0,0,0,0.3);margin-top: 60px; width: 90%;">
                <div  style="  display: flex;background-color: #dc3545;color: white;text-align: center; ">
                    <div style=" padding: 10px 5px 10px 5px;" >
                        <h4>Platos</h4>  
                    </div>
                    
                    <div style=" padding: 10px 5px 10px 5px;">
                        <a href="Controlador?menu=Agregar_producto"target="myFrame" class=" btn btn-success">Agregar</a>     
                    </div>
                </div>
                
                <iframe style="border-radius: 5px;height: 100%; width: 100%; border: none;" src="Controlador?menu=vista_producto&accion=Listar" name="myFrame"></iframe>
                
                <div style="  display: flex; background-color: #dc3545;color: white; text-align: center;">
                    <div style=" padding: 10px 5px 10px 5px;">
                        <h4>Clientes</h4> 
                    </div>
                    
                    <div style=" padding: 10px 5px 10px 5px;">
                        <a href="Controlador?menu=Agregar_cliente" target="myFrame" class=" btn btn-success">Agregar</a>
                    </div>
                </div>
                
                <iframe style="height: 100%; width: 100%; border: none;" src="Controlador?menu=vista_cliente&accion=Listar" name="myFrame"></iframe>
            </div>
        </div>
                        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
