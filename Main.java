public class Main {

    public static void main(String[] args) {
        ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca();

        // Adicionando Relação Inicial de Produtos ao Estoque
        estoque.inserirProduto(new Produto(1000, "Geladeira", 10));
        estoque.inserirProduto(new Produto(1001, "AirFryer", 50));
        estoque.inserirProduto(new Produto(1002, "TV", 20));
        estoque.inserirProduto(new Produto(1003, "Laptop", 15));
        estoque.inserirProduto(new Produto(1004, "Cafeteira", 75));
        estoque.inserirProduto(new Produto(1005, "Playstation", 25));
        estoque.inserirProduto(new Produto(1006, "Xbox", 25));
        
        // Exibindo Estoque Inicial em Ordem Crescente (ID)
        exibirProdutosEmOrdemCrescente(estoque);
        
        // Adiciona 10 Geladeiras ao Estoque
        System.out.println("\nAdicionando Geladeira (ID = 1000) ao estoque. Quantidade = 10.");
        estoque.inserirProduto(new Produto(1000, "Geladeira", 10));
        
        // Remove Playstation (ID = 1005) do Estoque
        removerProduto(estoque, 1005);
        
        // Buscando Produto Playstation (Removido) e Geladeira (Acrescido em 10 Unidades)
        buscarProduto(estoque, 1000);
        buscarProduto(estoque, 1005);
        
        // Retorna Produto Com Menor ID
        exibirProdutoMenorID(estoque);
        
        // Retorna Produto Com Maior ID
        exibirProdutoMaiorID(estoque);

        // Exibindo Estoque Final em Ordem Crescente (ID)
        exibirProdutosEmOrdemCrescente(estoque);
    }

    private static void buscarProduto(ArvoreBinariaDeBusca estoque, int idProduto) {
        Produto produto = estoque.ChecaProduto(idProduto);
        if (produto != null) {
            System.out.println("\nProduto encontrado - ID: " + produto.getID() + ", Nome: " + produto.getNome() + ", Quantidade: " + produto.getQtd());
        } else {
            System.out.println("\nProduto com ID " + idProduto + " não encontrado.");
        }
    }

	private static void exibirProdutosEmOrdemCrescente(ArvoreBinariaDeBusca estoque) {
        System.out.println("\nProdutos em ordem crescente de ID:");
        estoque.exibirEmOrdemCrescente();
    }

    private static void exibirProdutoMenorID(ArvoreBinariaDeBusca estoque) {
        System.out.println("\nProduto com menor ID:");
        estoque.retornarProdutoMenorID();
    }
    
    private static void exibirProdutoMaiorID(ArvoreBinariaDeBusca estoque) {
        System.out.println("\nProduto com maior ID:");
        estoque.retornarProdutoMaiorID();
    }


    private static void removerProduto(ArvoreBinariaDeBusca estoque, int idProduto) {
        System.out.println("\nRemovendo produto com ID " + idProduto + ":");
        estoque.removerProduto(idProduto);
    }
}
