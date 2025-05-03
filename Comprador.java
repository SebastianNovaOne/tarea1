public class Comprador {
    private int totalVuelto;
    private String productoConsumido;

    public Comprador(Moneda m, int tipoProducto, Expendedor expendedor)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        Producto producto = expendedor.comprarProducto(m, ProductoEnum.values()[tipoProducto]);
        if (producto != null) {
            productoConsumido = producto.getNombre();
            totalVuelto = 0;
            Moneda monedaRecibida;
            while ((monedaRecibida = expendedor.getVuelto()) != null) {
                totalVuelto = totalVuelto + monedaRecibida.getValor();
            }
        }
    }

    public String getProductoConsumido() {
        return productoConsumido;
    }

    public int getVueltoTotal() {
        return totalVuelto;
    }
}
