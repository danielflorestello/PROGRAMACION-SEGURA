package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Encriptado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    int intentos;
    int empleado;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = null;
        String accion = request.getParameter("accion");       
        int timeout = 5*60;
        
        String mensaje = "    <div style=\"text-align: center;\n"
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
                            + "                 <h3> ¡Usuario y/o contraseña incorrectos! </h3>\n"
                            + "                 <button  class=\" btn btn-danger  btn-lg\"><a style=\"color: white;text-decoration: none;\" href=\"javascript:cerrarr()\">Ok</a></button>"
                            + "<script>function abrir(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"block\";\n"
                            + "			}\n"
                            + "			function cerrarr(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"none\";\n"
                            + "			}</script>";
        
        String mensaje1 = "   <div style=\"text-align: center;\n"
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
                            + "                 <h3> ¡No se permiten los caracteres especiales! </h3>\n"
                            + "                 <button  class=\" btn btn-danger  btn-lg\"><a style=\"color: white;text-decoration: none;\" href=\"javascript:cerrarr()\">Ok</a></button>"
                            + "<script>function abrir(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"block\";\n"
                            + "			}\n"
                            + "			function cerrarr(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"none\";\n"
                            + "			}</script>";
        
        String mensaje2 = "   <div style=\"text-align: center;\n"
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
                            + "                 <h3> ¡Número de intentos excedidos! </h3>\n"
                            + "                 <button  class=\" btn btn-danger  btn-lg\"><a style=\"color: white;text-decoration: none;\" href=\"javascript:cerrarr()\">Ok</a></button>"
                            + "<script>function abrir(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"block\";\n"
                            + "			}\n"
                            + "			function cerrarr(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"none\";\n"
                            + "			}</script>";
        
        String mensaje3 = "   <div style=\"text-align: center;\n"
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
                            + "                 <h3> ¡El usuario tiene sesión activa! </h3>\n"
                            + "                 <button  class=\" btn btn-danger  btn-lg\"><a style=\"color: white;text-decoration: none;\" href=\"javascript:cerrarr()\">Ok</a></button>"
                            + "<script>function abrir(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"block\";\n"
                            + "			}\n"
                            + "			function cerrarr(){\n"
                            + "				document.getElementById(\"ventana\").style.display=\"none\";\n"
                            + "			}</script>";
        
        
        switch (accion) {
            case "Ingresar":
                String usuario = request.getParameter("txtuser");
                String clave = Encriptado.getMD5(request.getParameter("txtpass"));
                
                intentos = intentos + 1;
                
                if (intentos < 3) {
                    
                    if (usuario.matches("[a-zA-Z1-9]*")) {

                        em = edao.validar(usuario, clave);

                        if (usuario.equals(em.getUsuario()) & clave.equals(em.getClave())) {

                            if (em.getNombreRol().equals("Administrador")) {
                                session = request.getSession();
                                intentos = 0;
                                
                                session.setAttribute("usuario", em);
                                request.getRequestDispatcher("Controlador?menu=Administrador").forward(request, response);
                                
                                //redireccion y tiempo limite
                                session.setMaxInactiveInterval(timeout);
                                response.setHeader("Refresh", timeout + "; URL=index.jsp");
                                                                
                            } else if (em.getNombreRol().equals("Empleado")) {
                                session = request.getSession();
                                intentos = 0;
                                
                                session.setAttribute("usuario", em);
                                request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                                
                                //redireccion y tiempo limite
                                session.setMaxInactiveInterval(timeout);
                                response.setHeader("Refresh", timeout + "; URL=index.jsp");
                            }
                            
                        } else {

                            request.setAttribute("mensaje", mensaje);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("mensaje", mensaje1);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    
                } else {
                    request.setAttribute("mensaje", mensaje2);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                break;             
                
            default:
                session = request.getSession();
                session.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
