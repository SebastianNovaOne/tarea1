public enum ProductoEnum {
    COCACOLA(900),
    SPRITE(900),
    FANTA(900),
    SNICKERS(400),
    SUPER8(100);

    private final int precio;

    ProductoEnum(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}