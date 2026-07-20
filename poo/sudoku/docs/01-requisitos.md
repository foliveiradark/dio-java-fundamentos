# 📚 Documento de Requisitos

---

## 🎯  Objetivo

> Desenvolver um sistema que permita ao usuário jogar Sudoku, inicialmente pelo terminal, com possibilidade de evolução para uma interface gráfica.

---

## 📝 Requisitos Funcionais

### RF-001
> O sistema deve permitir iniciar uma partida de Sudoku.

### RF-002
> O sistema deve permitir preencher uma casa do tabuleiro.

### RF-003
> O sistema deve permitir remover um número inserido pelo jogador.


### RF-004
> O sistema deve validar se o estado atual do jogo está correto.

### RF-005
> O sistema deve iniciar uma nova partida carregando um tabuleiro parcialmente preenchido.

### RF-006
> Os números iniciais do tabuleiro devem ser considerados fixos e não poderão ser alterados ou removidos pelo jogador.


### RF-007
>As demais casas deverão iniciar vazias e poderão ser preenchidas pelo jogador.

### RF-008
>O sistema deve permitir ao jogador verificar se existem conflitos no estado atual do tabuleiro.

### RF-009
>Quando existirem conflitos, o sistema deverá informar ao jogador quais regras do Sudoku foram violadas.  
>*(Decidir se a mensagem será simples ou detalhada.)*

### RF-010
>O sistema não deverá permitir que a partida seja finalizada enquanto existirem conflitos ou casas vazias.

---

## 📝 Requisitos Não Funcionais

### RNF-001