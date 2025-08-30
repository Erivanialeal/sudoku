# Resumo.

Um desafio para praticar POO, esse desafio faz parte do BootCamp da GFT da plataforma DIO.
Nesse desafio usei o Java puro apenas praticando com a linguagem.

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

* colocarNumero()

    Este método insere um número em uma célula específica do tabuleiro de Sudoku. ele 
    também garante que o jogador só possa modificar valores não fixos do tabuleiro.

* removerNumero()

    Aqui segue a mesma lógica, porém invés de colocar número ele vai remover o número.

* limpar()
    Pecorre cada linha e coluna, verifica os números que são fixos se forem fixos não podem
    ser alterados se não forem fixos a celula é limpa.

* estaCompleto()

    Esse métado verifica se o tabuleiro está completo, pecorrendo linhas e colunas
    verificando os valores que são fixos e os que não são e fazendo a alteração em números
    não fixos.

* contemErros()

    Verificação de erros, de linhas, colunas, quadrados 3x3 e tabuleiro 9x9, usamos o HashSet para não permitir números duplicados.

* getCelula()

# Classe Jogo.

    A classe jogo é responsavél por gerenciar a lógica da partida, ela atua como uma camada
    de controle entre jogador e tabuleiro.

## Atributos.
    ` private Tabuleiro tabuleiro;`

    `private String status;`

## Métados.

* novoJogo()
    
Verifica se não há um jogo em andamento ou já finalizado antes de iniciar uma nova partida. Se estiver tudo certo, cria um novo tabuleiro e define o status como

* colocarNumero()
    Só permite inserir um número se o jogo já tiver sido iniciado. Antes de adicionar, verifica se a célula não é fixa, ou seja, se pode ser alterada pelo jogador.


* removerNumero()
    Segue a mesma lógica do método anterior, mas faz o oposto: remove o número da célula, desde que ela não seja fixa e o jogo esteja iniciado.

* verificarJogo()
    Exibe o tabuleiro e avalia o estado atual do jogo. Informa se está completo, se contém erros ou se ainda está incompleto.

* verificarStatusDoJogo()
    Retorna o status atual do jogo como uma string. Pode ser "NAO INICIADO", "INCOMPLETO", "COMPLETO", "CONTEM ERROS", etc.

* pedirComFirmacao()
    Solicita ao jogador uma confirmação antes de executar ações importantes, como limpar ou reiniciar o jogo. Retorna verdadeiro ou falso com base na resposta.

* limpar()
    Verifica o status do jogo e pede confirmação antes de apagar os números inseridos pelo jogador. Mantém os números fixos e atualiza o status do jogo.

* finalizarJogo()
    Tenta encerrar a partida. Só permite finalizar se o tabuleiro estiver completo e sem erros. Caso contrário, informa ao jogador que ainda há espaços a preencher ou erros a corrigir.



