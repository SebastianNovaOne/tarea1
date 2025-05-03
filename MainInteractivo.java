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
        }
    }
}
