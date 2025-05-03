import java.util.*;

public class MainInteractivo {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Expendedor expendedor = new Expendedor(10);

        while (true) {
            System.out.println("\nMenu de Expendedor");
            System.out.println("1. Coca Cola");
            System.out.println("2. Sprite");
            System.out.println("3. Fanta");
            System.out.println("4. Snickers");
            System.out.println("5. Super8");
            System.out.println("6. Salir");
            System.out.print("Seleccione Producto (1-6): ");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Saliendo");
                break;
            }

            System.out.print("Ingrese valor de moneda: ");
            int valorMoneda = scanner.nextInt();
            Moneda moneda = crearMoneda(valorMoneda);

            try {
                Comprador comprador = new Comprador(moneda, opcion - 1, expendedor);
                System.out.println("Producto consumido: " + comprador.getProductoConsumido());
                System.out.println("Vuelto recibido: $" + comprador.getVueltoTotal());
            }

            catch (PagoIncorrectoException | NoHayProductoException | PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static Moneda crearMoneda(int valor) {
        switch (valor) {
            case 100:
                return new Moneda100();
            case 500:
                return new Moneda500();
            case 1000:
                return new Moneda1000();
            default:
                System.out.println("Moneda no valida.");
                return null;
        }
    }
}
