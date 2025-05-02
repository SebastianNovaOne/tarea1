import java.util.ArrayList;

public class Deposito<T> {
    private final ArrayList<T> items;

    public Deposito() {
        items = new ArrayList<>();
    }

    public void agregar(T item){
        items.add(item);
    }
}
