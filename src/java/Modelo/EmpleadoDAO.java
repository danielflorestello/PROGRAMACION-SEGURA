package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String usuario, String clave) {
        Empleado em = new Empleado();
        String sql = "select E.IdEmpleado, E.Nombre, E.Apellido, E.Dni, E.Telefono, E.Usuario, E.Clave, "
                + "E.IdRol, R.NombreRol from empleado E "
                + "inner join rol R on R.IdRol = E.IdRol "
                + "where Usuario=? and Clave=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                em.setIdEmpleado(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setDni(rs.getInt(4));
                em.setTelefono(rs.getInt(5));
                em.setUsuario(rs.getString(6));
                em.setClave(rs.getString(7));
                em.setIdRol(rs.getInt(8));
                em.setNombreRol(rs.getString(9));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return em;
    }

    //OPERACIONES PARA EL SISTEMA
    public List listar() {
        String sql = "select E.IdEmpleado, E.Nombre, E.Apellido, E.Dni, E.Telefono, E.Usuario, E.Clave, "
                + "E.IdRol, R.NombreRol from empleado E "
                + "inner join rol R on R.IdRol = E.IdRol";
        List<Empleado> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setIdEmpleado(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setDni(rs.getInt(4));
                em.setTelefono(rs.getInt(5));
                em.setUsuario(rs.getString(6));
                em.setClave(rs.getString(7));
                em.setIdRol(rs.getInt(8));
                em.setNombreRol(rs.getString(9));
                lista.add(em);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }

    /*public int agregar(Empleado em) {
        String sql = "insert into empleado (Dni,Nombres,Apellidos,Telefono,User) values(?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getApe());
            ps.setString(4, em.getTel());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setApe(rs.getString(4));
                emp.setTel(rs.getString(5));
                emp.setUser(rs.getString(6));

            }
            
        } catch (SQLException e) {
            
        }
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set Dni=?,Nombres=?,Apellidos=?,Telefono=?,User=? where IdEmpleado=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getApe());
            ps.setString(4, em.getTel());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }*/
}
