class ArvoreBinariaDeBusca {
    private class No {
        private Produto produto;
        private No esquerda, direita;

        No(Produto produto) {
            this.produto = produto;
        }
    }

    private No raiz;

    // Método Para Inserir/Atualizar Produto
    public void inserirProduto(Produto novoProduto) {
        raiz = inserirProdutoRecursivo(raiz, novoProduto);
    }

    private No inserirProdutoRecursivo(No noAtual, Produto novoProduto) {
        if (noAtual == null) {
            return new No(novoProduto);
        }

        int comparacao = Integer.compare(novoProduto.getID(), noAtual.produto.getID());

        if (comparacao < 0) {
            noAtual.esquerda = inserirProdutoRecursivo(noAtual.esquerda, novoProduto);
        } else if (comparacao > 0) {
            noAtual.direita = inserirProdutoRecursivo(noAtual.direita, novoProduto);
        } else {
            noAtual.produto = noAtual.produto.atualizarQuantidade(novoProduto.getQtd());
        }

        return noAtual;
    }

    // Método Exibir Elementos em Ordem Crescente
    public void exibirEmOrdemCrescente() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(No no) {
        if (no != null) {
            exibirEmOrdemRecursivo(no.esquerda);
            System.out.println("ID: " + no.produto.getID() + ", Nome: " + no.produto.getNome() + ", Quantidade: " + no.produto.getQtd());
            exibirEmOrdemRecursivo(no.direita);
        }
    }

    // Método Checar Produto Pelo ID
    public Produto ChecaProduto(int ID) {
        No resultado = ChecaProdutoRecursivo(raiz, ID);
        if (resultado != null) {
            return resultado.produto;
        } else {
            return null;
        }
    }

    private No ChecaProdutoRecursivo(No no, int ID) {
        if (no == null || no.produto.getID() == ID) {
            return no;
        }

        if (ID < no.produto.getID()) {
            return ChecaProdutoRecursivo(no.esquerda, ID);
        } else {
            return ChecaProdutoRecursivo(no.direita, ID);
        }
    }

    // Método Para Remover Produto Pelo ID
    public void removerProduto(int ID) {
        raiz = removerProdutoRecursivo(raiz, ID);
    }

    private No removerProdutoRecursivo(No no, int ID) {
        if (no == null) {
            return null;
        }

        if (ID < no.produto.getID()) {
            no.esquerda = removerProdutoRecursivo(no.esquerda, ID);
        } else if (ID > no.produto.getID()) {
            no.direita = removerProdutoRecursivo(no.direita, ID);
        } else {
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            No menor = retornarMenorProduto(no.direita);
            no.produto = menor.produto;
            no.direita = removerProdutoRecursivo(no.direita, menor.produto.getID());
        }

        return no;
    }

    // Método Para Retornar Menor Produto da Árvore
    private No retornarMenorProduto(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    // Método Retornar Produto de Maior ID
    public Produto retornarProdutoMaiorID() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return null;
        }
        No maior = retornarMaiorProduto(raiz);
        System.out.println("ID: " + maior.produto.getID() + ", Nome: " + maior.produto.getNome() + ", Quantidade: " + maior.produto.getQtd());
        return maior.produto;
    }

    // Método Retornar Produto de Menor ID
    public Produto retornarProdutoMenorID() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return null;
        }
        No menor = retornarMenorProduto(raiz);
        System.out.println("ID: " + menor.produto.getID() + ", Nome: " + menor.produto.getNome() + ", Quantidade: " + menor.produto.getQtd());
        return menor.produto;
    }

    // Método Para Retornar Maior Produto da Árvore
    private No retornarMaiorProduto(No no) {
        while (no.direita != null) {
            no = no.direita;
        }
        return no;
    }
}
