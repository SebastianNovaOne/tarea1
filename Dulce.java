/**
 * Clase que representa un dulce.
 * Hereda de la clase producto.
 */
public class Dulce extends Producto {
    private String nombre;

    /**
     * Constructor de la clase dulce.
     *
     * @param nombre Nombre del dulce.
     * @param precio Precio del dulce.
     */
    public Dulce(String nombre, int precio) {
        super(precio);
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre del dulce.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
}