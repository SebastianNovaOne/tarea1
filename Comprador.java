/**
 * Clase que representa a un comprador que adquiere un producto desde un expendedor.
 * Registra el nombre del producto consumido y el total del vuelto recibido.
 */
public class Comprador {
    private int totalVuelto;
    private String productoConsumido;

    /**
     * Constructor que realiza la compra de un producto desde un expendedor.
     *
     * @param m             Moneda utilizada para realizar la compra.
     * @param tipoProducto  Indice del producto segun el orden en ProductoEnum.
     * @param expendedor    Expendedor desde el cual se realiza la compra.
     * @throws PagoIncorrectoException   Si la moneda es nula.
     * @throws NoHayProductoException    Si el producto no esta disponible.
     * @throws PagoInsuficienteException Si la moneda no cubre el precio del producto.
     */
    public Comprador(Moneda m, int tipoProducto, Expendedor expendedor)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        Producto producto = expendedor.comprarProducto(m, ProductoEnum.values()[tipoProducto]);
        if (producto != null) {
            productoConsumido = producto.getNombre();
            totalVuelto = 0;
            Moneda monedaRecibida;
            while ((monedaRecibida = expendedor.getVuelto()) != null) {
                totalVuelto += monedaRecibida.getValor();
            }
        }
    }

    /**
     * Retorna el nombre del producto consumido.
     *
     * @return Nombre del producto o null si no se consumo ninguno.
     */
    public String getProductoConsumido() {
        return productoConsumido;
    }

    /**
     * Retorna el total del vuelto recibido en la compra.
     *
     * @return Monto total del vuelto.
     */
    public int getVueltoTotal() {
        return totalVuelto;
    }
}