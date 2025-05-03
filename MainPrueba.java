public class MainPrueba {
    public static void main(String[] args){
        try {
            Expendedor expendedor = new Expendedor(10);

            Moneda moneda100 = new Moneda100();
            Moneda moneda500 = new Moneda500();
            Moneda moneda1000 = new Moneda1000();

            Comprador comprador1 = new Comprador(moneda1000, 1, expendedor);
            System.out.println("Producto consumido: " + comprador1.getProductoConsumido());
            System.out.println("Vuelto recibido: $" + comprador1.getVueltoTotal());
        }
    }
}
