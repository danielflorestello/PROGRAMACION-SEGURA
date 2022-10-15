package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = " select * from producto where IdProducto=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrec(rs.getDouble(3));
                p.setStock(rs.getInt(4));
            }
            
        } catch (SQLException e) {
            
        }
        return p;
    }

    public int actulizarstock(int id, int stock) {
        String sql = "update producto set Stock=? where IdProducto=? ";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPrec(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                lista.add(pro);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }

    public int agregar(Producto pro) {
        String sql = "insert into producto (Nombres,Precio,Stock) values(?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPrec());
            ps.setInt(3, pro.getStock());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto prod = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                prod.setNom(rs.getString(2));
                prod.setPrec(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
            }
            
        } catch (SQLException e) {
            
        }
        return prod;
    }

    public int actualizar(Producto pro) {
        String sql = "update producto set Dni=?,Nombres=?,Apellidos=?,Direccion=? where IdCliente=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPrec());
            ps.setInt(3, pro.getStock());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
        } catch (SQLException e) {
            
        }
    }
}
