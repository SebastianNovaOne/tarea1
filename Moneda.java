public abstract class Moneda implements Comparable<Moneda> {

    public abstract int getValor();

    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (serie: " + this.hashCode() + ", valor: $" + getValor() + ")";
    }
}

