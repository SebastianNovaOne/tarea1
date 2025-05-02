public abstract class Producto {
    protected int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    public abstract String getNombre();
}