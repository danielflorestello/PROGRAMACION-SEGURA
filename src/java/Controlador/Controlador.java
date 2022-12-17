package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Encriptado;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();

    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    
    Encriptado enc = new Encriptado();
    
    int ide, idc, idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;
    VentaDAO vdao = new VentaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("Vendedor")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
            
        } else if (menu.equals("Administrador")) {
            request.getRequestDispatcher("Administrador/Principal_Admin.jsp").forward(request, response);
        }

        //MENU CLIENTE ----------------------------------------------------------------------
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String ape = request.getParameter("txtApellidos");
                    String dir = request.getParameter("txtDir");
                    c.setDni(dni);
                    c.setNom(nom);
                    c.setApe(ape);
                    c.setDir(dir);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.eliminar(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        
        //Vista cliente------------------------------------------------------------------------------------------------------       
        if (menu.equals("vista_cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("vista_cliente.jsp").forward(request, response);
        }

        //MENU PRODUCTO---------------------------------------------------------------------
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("producto", lista);
                    break;
                    
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String pre = request.getParameter("txtPre");
                    String stock = request.getParameter("txtStock");
                    p.setNom(nom);
                    p.setPrec(Double.parseDouble(pre));
                    p.setStock(Integer.parseInt(stock));
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.eliminar(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        //Vista producto--------------------------------------------------------------------------------------------------------
        if (menu.equals("vista_producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("producto", lista);
                    break;
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("vista_producto.jsp").forward(request, response);
        }
        
        //MENU EMPLEADO ----------------------------------------------------------------------
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;

                case "Agregar":
                    String nombre = request.getParameter("txtNombres");
                    String apellido = request.getParameter("txtApellidos");
                    String dni = request.getParameter("txtDni");
                    String tel = request.getParameter("txtTelefono");
                    String usuario = request.getParameter("txtUsuario");
                    String clave = Encriptado.getMD5(request.getParameter("txtClave"));
                    int rol = 2;
                    
                    em = edao.validarRegistro(nombre, apellido);
                    
                    if (nombre.equals(em.getNombre()) & apellido.equals(em.getApellido())) {
                        request.setAttribute("mensaje", "    <div style=\"text-align: center;\n"
                            + "                background: white;\n"
                            + "                display: block;\n"
                            + "                width: 30%;\n"
                            + "                padding: 33px;\n"
                            + "                border-radius:10px;\n"
                            + "                position: absolute;\n"
                            + "                left: 35%;\n"
                            + "                top: 30%;\n"
                            + "                box-shadow: 0 0 50px 10px rgba(0,0,0,0.3);\" class=\"Ventana-cerrar\" id=\"ventana\">\n"
                            + "		\n"
                            + "                 <h3> ¡El empleado ya está registrado! </h3>\n"
                            + "                 <button  class=\" btn btn-danger  btn-lg\"><a style=\"color: white;text-decoration: none;\" href=\"javascript:cerrarr()\">Ok</a></button>"
                            + "<script>function abrir(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"block\";\n"
                            + "			}\n"
                            + "			function cerrarr(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"none\";\n"
                            + "			}</script>");
                    request.getRequestDispatcher("Controlador?menu=Agregar_empleado").forward(request, response);
                    
                    } else {
                        em.setNombre(nombre);
                        em.setApellido(apellido);
                        em.setDni(dni);
                        em.setTelefono(tel);
                        em.setUsuario(usuario);
                        em.setClave(clave);
                        em.setIdRol(rol);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    }
                                                        
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                case "Actualizar":
                    String nom1 = request.getParameter("txtNombres");
                    String ape1 = request.getParameter("txtApellidos");
                    String dni1 = request.getParameter("txtDni");
                    String tel1 = request.getParameter("txtTelefono");
                    String user1 = request.getParameter("txtUsuario");
                    em.setNombre(nom1);
                    em.setApellido(ape1);
                    em.setDni(dni1);
                    em.setTelefono(tel1);
                    em.setUsuario(user1);
                    em.setIdEmpleado(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();            
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        //MENU AGREGAR EMPLEADO----------------------------------------------------------------
        if (menu.equals("Agregar_empleado")) {
            request.getRequestDispatcher("Empleado_agregar.jsp").forward(request, response);
        }
        
        //MENI AGREGAR CLIENTE
        if (menu.equals("Agregar_cliente")) {
            request.getRequestDispatcher("Cliente_agregar.jsp").forward(request, response);
        }

        //MENU AGREGAR PRODUCTO----------------------------------------------------------------------
        if (menu.equals("Agregar_producto")) {
            request.getRequestDispatcher("Producto_agregar.jsp").forward(request, response);
        }

        //MENU VENTAS-------------------------------------------------------------------------
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    c.setDni(dni);
                    c = cdao.Buscar(dni);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    break;
                    
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId(id);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                    
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                    
                case "GenerarVenta":
                    //Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr = aO.buscar(idproducto);
                        int sac = pr.getStock() - cantidad;
                        aO.actulizarstock(idproducto, sac);
                    }
                    
                    //guardar venta
                    v.setIdcliente(c.getId());
                    v.setIdempleado(1);
                    v.setNumserie(numeroserie);
                    v.setFecha("2021-07-20");
                    v.setMonto(totalPagar);
                    vdao.guardarVenta(v);
                    
                    //guardar detalle
                    int idv = Integer.parseInt(vdao.IdVentas());
                    
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    break;
                    
                case "Cancelar":
                    request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);
                    break;
                    
                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    numeroserie = vdao.GenerarSerie();
                    
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                        
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
