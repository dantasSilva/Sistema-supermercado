package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.Produto;

public class Programa 
{
	public static void main(String[] args) 
	{
		Scanner sc =  new Scanner (System.in);
		List <Produto> produtos = new ArrayList<>();
		System.out.print("A lista contém quantos produtos? ");
		int quantidadeProdutos = sc.nextInt();
		for (int i = 0; i<quantidadeProdutos; i++) 
		{
			System.out.println();
			System.out.print("Produto: ");
			String nome = sc.next();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			System.out.print("Preço unitário: ");
			double preco = sc.nextDouble();
			produtos.add(new Produto(nome, quantidade, preco));
		}
		
		double valorTotal = 0;
		for (Produto produto : produtos ) 
		{
			valorTotal+=produto.getQuantidade()*produto.getPreco();
		}
		System.out.println();
		System.out.print("Valor total: R$ "+valorTotal);
		
		sc.close();
	}
}
