package sudoku;

public class Celula {
    // criando os atributos privados para encapsulamento
    private int valor;
    private boolean fixa;

    // inicializando o a classe com o construtor
    public Celula(int valor, boolean fixa) {
        this.valor = valor;
        this.fixa = fixa;

    }
    // Getters e Setters

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (!fixa) { // o valor so pode mudar se não for fixo
            this.valor = valor;
        }
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }

    // Método que limpa o valor da célula, se ela não for fixa
    public void limpar() {
        // Verifica se a célula NÃO é fixa (ou seja, foi preenchida pelo jogador)
        if (!fixa) {
            // Se não for fixa, então podemos apagar o valor (voltar para 0)
            this.valor = 0;
        }
    }

}
