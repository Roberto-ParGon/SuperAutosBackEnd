package mx.uv;

public class Auto {
    private String id;
    private String nombre;
    private String modelo;
    private String marca;  
    private int puertas;  
    private String clase;
    private double precio;
    private String imagen;

    public Auto() {
    }

    public Auto(String id, String nombre, String modelo, String marca, int puertas, String clase, double precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.puertas = puertas;
        this.clase = clase;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}   
    
}
