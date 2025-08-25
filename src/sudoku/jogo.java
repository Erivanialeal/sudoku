package sudoku;

public class Jogo {
    // atributos
    private Tabuleiro tabuleiro;
    private String status;

    // construtor
    public Jogo() {
        tabuleiro = new Tabuleiro();
        status = "EM ANDAMENTO";
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String novoJogo(String[] args) {
        // iniciar um novo tabuleiro.
        this.tabuleiro = new Tabuleiro();
        tabuleiro.inicializar(args);
        // definir o status do jogo
        status = "Incompleto";
        // verificar se contém erros
        if (tabuleiro.contemErros()) {
            System.out.println("O jogo foi inicializado com erros nos valores fixo");
            status = "COM ERROS";
        } else {
            System.out.println("Novo jogo inicializado com sucesso");
        }
        return status;

    }

    public void colocarNumero(int x, int y, int valor) {
        // pegar o tabuleiro do jogo
        Celula celula = tabuleiro.getCelula(x, y);
        // verificar se os numero são fixo
        // se for fixo não pode ser alterado
        if (celula.isFixa()) {
            System.out.println("O valor é fixo, não pode ser alterado.");
            // se não for fixo adicionamos valor no tabuleiro
        } else {
            celula.setValor(valor);
            System.out.println("Valor" + valor + "Adicioando com sucesso.");

        }

    }
}
