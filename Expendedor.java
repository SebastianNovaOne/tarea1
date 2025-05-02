public class Expendedor {
    private final Deposito<Producto>[] depositos;
    private final Deposito<Moneda> depositoVuelto = new Deposito<>();

    public Expendedor(int cantidadInicial) {
        depositos = new Deposito[ProductoEnum.values().length];
        for (int i = 0; i < ProductoEnum.values().length; i++) {
            depositos[i] = new Deposito<>();
            for (int j = 0; j < cantidadInicial; j++) {
                depositos[i].agregar(crearProducto(ProductoEnum.values()[i]));
            }
        }
    }
}
