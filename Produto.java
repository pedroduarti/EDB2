class Produto {
    private final int ID;
    private final int qtd;
    private final String nome;

    // Construtor Para Produto
    public Produto(int ID, String nome, int qtd) {
        this.ID = ID;
        this.qtd = qtd;
        this.nome = nome;
    }

    // Métodos de Acesso
    public int getQtd() {
        return this.qtd;
    }

    public int getID() {
        return this.ID;
    }

    public String getNome() {
        return this.nome;
    }

    // Método Para Criar um Novo Produto Com a Quantidade Atualizada
    public Produto atualizarQuantidade(int novaQtd) {
        return new Produto(this.ID, this.nome, this.qtd + novaQtd);
    }
}
