package Modelo;

public class Cliente {
    int id;
    String dni;
    String nom;
    String ape;
    String dir;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nom, String ape, String dir) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.ape = ape;
        this.dir = dir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
}
