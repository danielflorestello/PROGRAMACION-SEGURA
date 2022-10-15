package Modelo;

public class Producto {
    int id;
    String nom;
    double prec;
    int stock;

    public Producto() {
    }

    public Producto(int id, String nom, double prec, int stock) {
        this.id = id;
        this.nom = nom;
        this.prec = prec;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
