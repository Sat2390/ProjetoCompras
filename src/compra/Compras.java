package compra;

public class Compras {
    private final String nome;
    private final double valor;

    public Compras(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("%s - R$%.2f", nome, valor);
    }
}
