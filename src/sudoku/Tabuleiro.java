package sudoku;

import java.util.HashSet;
import java.util.Set;

public class Tabuleiro {
    // Cria uma matriz 9x9 de objetos Celula, que será o tabuleiro.
    private Celula[][] matriz = new Celula[9][9];
    // Define os valores iniciais do Sudoku.
    private final int[][] template = {
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };

    public Tabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = new Celula(template[i][j], template[i][j] != 0); // Inicializa cada célula com valor do
                                                                                // template e fixa se não for 0

            }
        }
    }

    // Método para preencher os números fixos vindos do args
    public void inicializar(String[] args) {
        for (String arg : args) {
            String[] partes = arg.split(",");
            if (partes.length == 3) {
                try {
                    int x = Integer.parseInt(partes[0]);
                    int y = Integer.parseInt(partes[1]);
                    int valor = Integer.parseInt(partes[2]);

                    if (x >= 0 && x < 9 && y >= 0 && y < 9 && valor >= 1 && valor <= 9) {
                        matriz[x][y].setValor(valor);
                        matriz[x][y].setFixa(true);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter: " + arg);
                }
            } else {
                System.out.println("Formato inválido: " + arg);
            }
        }
    }

    public void exibir() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                int valor = matriz[i][j].getValor();
                System.out.print(valor == 0 ? ". " : valor + " ");
            }
            System.out.println();
        }
    }

    public void colocarNumero(int x, int y, int valor) {
        // veficar se a célula não é fixa
        if (!matriz[x][y].isFixa()) {
            // se não for fixa, colocar o valor
            matriz[x][y].setValor(valor);

        }

    }

    public void removerNumero(int x, int y) {
        // verifica se a celula não é fixa
        if (!matriz[x][y].isFixa()) {
            // se não for fixa, limpar o valor
            matriz[x][y].limpar();
        }
    }

    public void limpar() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // verificar se a celula não é fixa
                if (!matriz[i][j].isFixa()) {
                    // se não for fixa limpar o valor
                    matriz[i][j].limpar();
                }
            }
        }

    }

    public boolean estaCompleto() {
        // Verificar se todas as celulas estão preenchidas
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Se alguma célula tiver valor 0, o tabuleiro não está completo
                if (matriz[i][j].getValor() == 0) {
                    return false;
                }
            }
        }
        // Se todas as células estão preenchidas, o tabuleiro está completo
        return true;
    }

    public boolean contemErros() {
        // verificando erros em linhas
        for (int i = 0; i < 9; i++) {
            // criando o set vazio
            Set<Integer> linha = new HashSet<>();
            // coluna
            for (int j = 0; j < 9; j++) {
                int valor = matriz[i][j].getValor();
                if (valor != 0) {
                    if (!linha.add(valor)) {
                        return true; // numero repetido de linha
                    }
                }
            }
        }
        // verificar colunas
        for (int j = 0; j < 9; j++) {
            Set<Integer> coluna = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                int valor = matriz[i][j].getValor();
                if (valor != 0) {
                    if (!coluna.add(valor)) {
                        return true; // numero repetido na coluna
                    }
                }
            }

        }
        // verificar quadrados 3x3
        for (int blocoX = 0; blocoX < 3; blocoX++) {
            for (int blocoY = 0; blocoY < 3; blocoY++) {
                Set<Integer> quadrado = new HashSet<>();
                for (int i = blocoX * 3; i < (blocoX + 1) * 3; i++) {
                    for (int j = blocoY * 3; j < (blocoY + 1) * 3; j++) {
                        int valor = matriz[i][j].getValor();
                        if (valor != 0) {
                            if (!quadrado.add(valor)) {
                                return true; // numero repetido no quadrado
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public Celula getCelula(int x, int y) {
        return matriz[x][y];
    }
}
