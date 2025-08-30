package sudoku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // iniciando o jogo
        Jogo jogo = new Jogo();
        int opcao = -1;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Iniciar um novo o jogo");
            System.out.println("2. Mostrar tabuleiro");
            System.out.println("3. Colocar um novo número");
            System.out.println("4. Remover um número");
            System.out.println("5. Verificar jogo");
            System.out.println("6. Verificar status do jogo");
            System.out.println("7. Limpar");
            System.out.println("8. finalizar o jogo");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // iniciar um novo jogo
                    jogo.novoJogo(args);

                    break;
                case 2: // mostrar tabuleiro
                    jogo.getTabuleiro().exibir();
                    break;
                case 3: // adicionar um número
                    System.out.println(" Informe a linha de 0 a 8:");
                    int linha = scanner.nextInt(); // linha

                    System.out.println("Informe a coluna de 0 a 8:");
                    int coluna = scanner.nextInt(); // coluna

                    System.out.println("Informe o número que voçê quer adicionar de 0 a 8:");
                    int valor = scanner.nextInt();
                    jogo.colocarNumero(linha, coluna, valor);
                    jogo.getTabuleiro().exibir();
                    break;

                case 4: // remover número
                    System.out.println(" Informe a linha de 0 a 8:");
                    int linhaRemover = scanner.nextInt(); // linha

                    System.out.println("Informe a coluna de 0 a 8:");
                    int colunaRemover = scanner.nextInt(); // coluna
                    jogo.removerNumero(linhaRemover, colunaRemover);
                    jogo.getTabuleiro().exibir();

                case 5: // verificar jogo
                    System.out.println("Verificando jogo...");
                    jogo.verificarJogo();

                    break;
                case 6: // retornar status do jogo
                    jogo.verificarStatusDoJogo();
                    break;
                case 7: // limpar jogo
                    jogo.limpar();
                    break;
                case 8:
                    jogo.finalizarJogo();

                default:
                    break;
            }

        } while (opcao != 0);
        {

        }

    }
}