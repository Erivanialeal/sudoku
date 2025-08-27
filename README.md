# 88888888888
Um desafio para praticar POO, esse desafio faz parte do BootCamp da GFT da plataforma DIO.

## Descrição do projeto.
> O projeto Sudoku em Java tem como objetivo implementar o jogo clássico de Sudoku no terminal. O jogador poderá iniciar um novo jogo, inserir números, remover números, visualizar o tabuleiro, verificar o status do jogo e finalizar a partida quando estiver correta.

# Classe Celula.
Representa uma posição do tabuleiro do Sudoku (9x9).
Cada célula pode conter:
* Um  inteiro (`valor`).
* Uma indicação se é fixa ou não (`fixa`).
# Classe Tabuleiro.
Representa a estrutura principal do jogo ela armazena e manipula a matriz 9x9
de Celula.
## Atributos.
` private Celula[][] matriz = new Celula[9][9];`
`private final int[][] template `

## Métodos.
* inicializar():
    Recebe um array de Strings no formato "x,y,valor", onde cada elemento representa uma célula fixa do Sudoku. O método percorre esse array, interpreta as posições e valores, e preenche o tabuleiro com os números iniciais do jogo. Esses valores são marcados como fixos, ou seja, não podem ser alterados pelo jogador durante a partida.

* exibir()
    Exibe o tabuleiro de Sudoku no terminal, organizando visualmente os números em uma grade 9x9. O método insere divisões horizontais e verticais para destacar os blocos 3x3, facilitando a leitura e a identificação de cada região do jogo. Células vazias são representadas por um ponto (.), enquanto as preenchidas mostram seus respectivos valores.

* colocarNumero
* removerNumero
* limpar()
* estaCompleto()
* contemErros()
* getCelula