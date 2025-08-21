package sudoku;

public class Tabuleiro {
    // Declara e inicializa uma matriz 9x9 de objetos Celula.
    // Cada posição da matriz representa uma célula do tabuleiro de Sudoku.
    // Usamos 'private' para proteger o acesso direto à matriz, seguindo o princípio
    // de encapsulamento
    private Celula[][] matriz = new Celula[9][9];
    // Removido construtor incorreto da classe Tabuleiro.

    // métodos
    public void inicializar(String[] args) {
        // Preencher cada posição com uma nova célula vazia
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = new Celula(0, false);

            }
        }
        // Preencher com os números fixos vindos do args
        for (String arg : args) {
            // dividindo a String
            String[] partes = arg.split(",");
            int x = Integer.parseInt(partes[0]);
            int y = Integer.parseInt(partes[1]);
            int valor = Integer.parseInt(partes[2]);
            // fixar os números pra o usuario não alterar
            matriz[x][y].setValor(valor);
            matriz[x][y].setFixa(true);
        }
    }

    public void exibir() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = new Celula(0, false);
                // Exibe o valor da célula na posição (i, j)
                System.out.println(matriz[i][j].getValor());
            }
        }

    }

}
