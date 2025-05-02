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

    public Producto comprarProducto(Moneda moneda, ProductoEnum producto)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("Moneda nula.");
        }

        int indice = producto.ordinal();
        if (depositos[indice] == null)  {
            depositoVuelto.agregar(moneda);
            throw new NoHayProductoException(("No disponible."));

        }

        int precio = producto.getPrecio();
        int pago = moneda.getValor();

        if (pago < precio) {
            depositoVuelto.agregar(moneda);
            throw new PagoInsuficienteException("Pago insuficiente.");
        }

        Producto prod = depositos[indice].retirar();
        if (prod == null) {
            depositoVuelto.agregar(moneda);
            throw new NoHayProductoException("Sin stock.");
        }

        int vuelto = pago - precio;
        while (vuelto >= 100) {
            depositoVuelto.agregar(new Moneda100());
            vuelto -= 100;
        }


        
    }
}
