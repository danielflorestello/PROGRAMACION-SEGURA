package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {
    
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    
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
        
        HttpSession session = null;
        String accion = request.getParameter("accion");
        String mensaje = null;
        int intentos = 0;
        
        if (accion.equalsIgnoreCase("Ingresar")) {
            String usuario = request.getParameter("txtuser");
            String clave = request.getParameter("txtpass");
            em = edao.validar(usuario, clave);
                
            if (usuario.equals(em.getUsuario()) & clave.equals(em.getClave())) {

                if (em.getNombreRol().equals("Administrador")) {
                    session = request.getSession();
                    session.setAttribute("usuario", em);
                    request.getRequestDispatcher("Controlador?menu=Administrador").forward(request, response);

                } else if (em.getNombreRol().equals("Empleado")) {
                    session = request.getSession();
                    session.setAttribute("usuario", em);
                    request.getRequestDispatcher("Controlador?menu=Empleado").forward(request, response);
                }

            } else {
                mensaje = "!Las credenciales no son correctas¡";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
            
        } else {
            session = request.getSession();
            session.setAttribute("usuario", null);
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
