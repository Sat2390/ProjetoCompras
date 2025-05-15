package principal;

import compra.Compras;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Compras> lista = new ArrayList<>();

        System.out.println("Quanto é o seu limite?");
        double limite = sc.nextDouble();
        sc.nextLine();

        double totalGasto = 0;

        while (true) {
            System.out.println("Qual é o produto que você deseja? (ou digite 'sair' para finalizar)");
            String produto = sc.nextLine();

            if (produto.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Quanto custa este produto?");
            double valor = sc.nextDouble();
            sc.nextLine();

            if (totalGasto + valor > limite) {
                System.out.println("Você ultrapassou o limite! Produto não adicionado.");
            } else {
                lista.add(new Compras(produto, valor));
                totalGasto += valor;
                System.out.printf("Produto %s adicionado. Total gasto: R$%.2f\n", produto, totalGasto);
            }
        }
        lista.sort(Comparator.comparingDouble(Compras::getValor).reversed());

        System.out.println("\nProdutos comprados:");
        for (Compras c : lista) {
            System.out.println(c);
        }

        System.out.println("\n===== RELATÓRIO FINAL =====");
        System.out.printf("Total de produtos comprados: %d\n", lista.size());
        System.out.printf("Total gasto: R$%.2f\n", totalGasto);
        System.out.printf("Limite disponível restante: R$%.2f\n", limite - totalGasto);

        sc.close();
    }
}
