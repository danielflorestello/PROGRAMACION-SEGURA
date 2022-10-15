package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente Buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "Select * from cliente where Dni=" + dni;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setApe(rs.getString(4));
                c.setDir(rs.getString(5));
            }
            
        } catch (SQLException e) {
            
        }
        return c;
    }

    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setApe(rs.getString(4));
                cl.setDir(rs.getString(5));
                lista.add(cl);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }

    public int agregar(Cliente cl) {
        String sql = "insert into cliente (Dni,Nombres,Apellidos,Direccion) values(?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getApe());
            ps.setString(4, cl.getDir());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente clip = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                clip.setDni(rs.getString(2));
                clip.setNom(rs.getString(3));
                clip.setApe(rs.getString(4));
                clip.setDir(rs.getString(5));
            }
            
        } catch (SQLException e) {
            
        }
        return clip;
    }

    public int actualizar(Cliente cl) {
        String sql = "update cliente set Dni=?,Nombres=?,Apellidos=?,Direccion=? where IdCliente=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getApe());
            ps.setString(4, cl.getDir());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}
