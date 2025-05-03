import java.util.*;

/**
 * Clase principal para realizar pruebas con el expendedor de productos.
 * Ejecuta pruebas de compra, manejo de excepciones y ordenamiento de monedas.
 */
public class MainPrueba {

    /**
     * Metodo principal que ejecuta varias pruebas de compra y validacion de excepciones.
     * Prueba de compra de productos, manejo de pagos insuficientes, productos no disponibles
     * y monedas nulas. Tambien se ordenan las monedas por su valor.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Expendedor expendedor = new Expendedor(10);

            Moneda moneda100 = new Moneda100();
            Moneda moneda500 = new Moneda500();
            Moneda moneda1000 = new Moneda1000();

            Comprador comprador1 = new Comprador(moneda1000, 1, expendedor);
            System.out.println("Producto consumido: " + comprador1.getProductoConsumido());
            System.out.println("Vuelto recibido: $" + comprador1.getVueltoTotal());

            try {
                Comprador comprador2 = new Comprador(moneda100, 2, expendedor);
            } catch (PagoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            try {
                Comprador comprador3 = new Comprador(moneda500, 3, expendedor);
            } catch (NoHayProductoException e) {
                System.out.println(e.getMessage());
            }

            try {
                Comprador comprador4 = new Comprador(null, 4, expendedor);
            } catch (PagoIncorrectoException e) {
                System.out.println(e.getMessage());
            }

            List<Moneda> monedas = Arrays.asList(moneda500, moneda100, moneda1000);
            Collections.sort(monedas);
            System.out.println("Monedas ordenadas:");
            for (Moneda moneda : monedas) {
                System.out.println(moneda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}