package sudoku;

import java.io.ObjectInputFilter.Status;
import java.util.Scanner;

public class Jogo {
    // atributos
    private Tabuleiro tabuleiro;
    private String status;

    // construtor
    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.status = "NAO INICIADO";
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
        if (status != null && !status.equals("NAO INICIADO")) {
            System.out.println("Já existe um jogo em andamento ou finalizado. Reinicie para começar outro.");
            return status;

        }
        // iniciar um novo tabuleiro.
        this.tabuleiro = new Tabuleiro();
        tabuleiro.inicializar(args);
        // definir o status do jogo
        status = "INCOMPLETO";
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
        if (status.equals("NAO INICIADO")) {
            System.out.println("Você precisa iniciar um novo jogo primeiro!");
            return;
        }

        // pegar o tabuleiro do jogo
        Celula celula = tabuleiro.getCelula(x, y);
        // verificar se os numero são fixo
        // se for fixo não pode ser alterado
        if (celula.isFixa()) {
            System.out.println("O valor é fixo, não pode ser alterado.");
            // se não for fixo adicionamos valor no tabuleiro
        } else {
            celula.setValor(valor);
            System.out.println("Valor:" + valor + "Adicioando com sucesso.");

        }

    }

    public void removerNumero(int x, int y) {
        if (status.equals("NAO INICIADO")) {
            System.out.println("Você precisa iniciar um novo jogo primeiro!");
            return;
        }

        // pegar o tabuleiro do jogo
        Celula celula = tabuleiro.getCelula(x, y);

        // se for fixo não pode ser alterado
        if (celula.isFixa()) {
            System.out.println("O valor é fixo, não pode ser alterado.");
            // se não for fixo removemos do tabuleiro
        } else {
            int valorRemovido = celula.getValor();// pega o valor antes de apagar
            celula.limpar(); // limapando o numero da celula
            System.out.println("Número removido com sucesso da célula [" + x + "][" + y + "]");
        }

    }

    public void verificarJogo() {
        if (status.equals("NAO INICIADO")) {
            System.out.println("Você precisa iniciar um novo jogo primeiro!");
            return;
        }
        // mostrar tabuleiro
        tabuleiro.exibir();
        // se tabuleiro estiver com erros
        if (tabuleiro.contemErros()) {
            System.out.println("O jogo comtem erros!");
            status = "CONTEM ERROS";
        } else if (tabuleiro.estaCompleto()) {
            System.out.println("O tabuleiro está completo, VOCÊ GANHOU O JOGO.");
            status = "COMPLETO";

        } else {
            System.out.println("O jogo está em andamento");
            status = "INCOMPLETO";
        }
    }

    public void verificarStatusDoJogo() {
        if (status.equals("NAO INICIADO")) {
            System.out.println("Você precisa iniciar um novo jogo primeiro!");
            return;
        }
        boolean completo = tabuleiro.estaCompleto(); // tabuleiro esta completo?
        boolean erros = tabuleiro.contemErros(); // há erros?
        // Se tabuleiro está completo e não contem erros
        if (completo && !erros) {
            System.out.println("O tabuleiro está completo, e não contem erros. ");
            status = "COMPLETO";
        } else if (completo && erros) {
            System.out.println("O tabuleiro está completo e contem erros");
            status = "COMTÉM ERROS";

        } else if (!completo && erros) {
            System.out.println("O tabuleiro está incompleto e com erros");
            status = "INCOMPLETO COM ERROS";

        } else {
            System.out.println("O tabuleiro está incompleto");
            status = "iNCOMPLETO";
        }
    }

    public boolean pedirConfirmação() {
        Scanner scanner = new Scanner(System.in);
        // pedir a confirmação
        System.out.println("DESEJA EXCLUIR O JOGO Sim ou Não?");
        String resposta = scanner.nextLine();
        // verificar resposta
        return resposta.equalsIgnoreCase("Sim");
    }

    public void limpar() {
        // Verificar o status do jogo.
        if (status.equals("COMPLETO")) {
            System.out.println("O jogo já foi ganho deseja mesmo reniciar");
        }
        // pedir a confirmação da limpeza do jogo
        boolean confirmar = pedirConfirmação();
        if (confirmar) {
            tabuleiro.limpar();
            System.out.println("Jogo limpo com sucesso");
            // atualizar o status
            status = "NAO INICIADO";
        } else {
            System.out.println("O jogo continua normalmente");
        }
    }

    public void finalizarJogo() {
        // perguntar ao jogador se quer mesmo finalizar.
        System.out.println("Deseja realmente finalizar esse jogo?");
        boolean confirmar = pedirConfirmação();
        if (!confirmar) {
            System.out.println("O jogo continua normalmente");
            return;

        }
        // verificar se o jogo está completo?
        if (!tabuleiro.estaCompleto() || tabuleiro.contemErros()) {
            System.out.println("O jogo não está completo ou contém erros. Tem certeza que deseja finalizar");
            confirmar = pedirConfirmação();
            if (!confirmar) {
                System.out.println("O jogo continua normalmente");
                return;
            }
        }
        status = "FINALIZADO";
        System.out.println("Jogo finalizado com sucesso!");
    }
}
