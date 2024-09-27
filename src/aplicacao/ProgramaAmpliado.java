package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import entidades.Produto;

public class ProgramaAmpliado 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        int quantidadeProdutos = 0;
        boolean entradaValida = false;
        while (!entradaValida) 
        {
            try 
            {
                System.out.print("A lista contém quantos produtos? ");
                quantidadeProdutos = sc.nextInt();
                if (quantidadeProdutos <= 0) {System.out.println("A lista deve ter uma quantidade de produtos positiva.");} 
                else 
                {
                    entradaValida = true;
                    for (int i = 0; i < quantidadeProdutos; i++) 
                    {
                        System.out.println();
                        System.out.print("Produto: ");
                        String nome = sc.next();
                        int quantidade = tratamentoErroQuantidade(sc);
                        double preco = tratamentoErroPreco(sc);
                        produtos.add(new Produto(nome, quantidade, preco));
                        
                    }
                    System.out.println();
                    if (produtos.isEmpty()) {
                        System.out.println("A lista de produtos está vazia.");
                    } else {
                        double valorTotal = calcularValorTotal(produtos);
                        System.out.print("Valor total: R$ " + valorTotal);
                    }
                }
            } catch (InputMismatchException e) 
            {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro positivo.");
                sc.nextLine();
                System.out.println();
            }
        }
        sc.close();
    }

    public static double calcularValorTotal(List<Produto> produtos) 
    {
        double valorTotal = 0;
        for (Produto produto : produtos) 
        {
            valorTotal += produto.getQuantidade() * produto.getPreco();
        }
        return valorTotal;
    }
    
    private static int tratamentoErroQuantidade(Scanner sc) 
    {
        int quantidade = 0;
        boolean entradaValida = false;
        while (!entradaValida) 
        {
            try 
            {
                System.out.print("Quantidade:");
                quantidade = sc.nextInt();
                if (quantidade <= 0) 
                {System.out.println("A quantidade deve ser positiva.");} 
                else {entradaValida = true;}
            } 	catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro positivo.");
                sc.nextLine();
                System.out.println();
            }
        }
        return quantidade;
    }
    
    private static double tratamentoErroPreco(Scanner sc) 
    {
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) 
        {
            try 
            {
                System.out.print("Preço unitário:");
                valor = sc.nextDouble();
                if (valor <= 0) {
                    System.out.println("Valor deve ser positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número positivo.");
                sc.nextLine();
                System.out.println();
            }
        }
        return valor;
    }
}
