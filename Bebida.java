public class Bebida extends Producto {
    private String nombre;

    public Bebida(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }
}