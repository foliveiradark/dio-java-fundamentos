# 📚 Documento de Requisitos

---

# 🎯 Objetivo

Desenvolver um sistema que permita ao usuário jogar Sudoku, inicialmente pelo terminal, com possibilidade de evolução para uma interface gráfica.

---

# 📝 Requisitos Funcionais

### RF-001
O sistema deve permitir iniciar uma partida de Sudoku.

---

### RF-002
O sistema deve permitir preencher uma casa do tabuleiro.

---

### RF-003
O sistema deve permitir remover um número inserido pelo jogador.

---

### RF-004
O sistema deve validar se o estado atual do jogo está correto.

---

### RF-005
O sistema deve iniciar uma nova partida carregando um tabuleiro parcialmente preenchido.

---

### RF-006
Os números iniciais do tabuleiro devem ser considerados fixos e não poderão ser alterados ou removidos pelo jogador.

---

### RF-007
As demais casas deverão iniciar vazias e poderão ser preenchidas pelo jogador.

---

### RF-008
O sistema deve permitir ao jogador verificar se existem conflitos no estado atual do tabuleiro.

---

### RF-009
Quando existirem conflitos, o sistema deverá informar ao jogador quais regras do Sudoku foram violadas.

> Atualmente o sistema informa apenas o status geral da partida. A identificação detalhada dos conflitos poderá ser implementada em versões futuras.

---

### RF-010
O sistema não deverá permitir que a partida seja finalizada enquanto existirem conflitos ou casas vazias.

---

### RF-011
O sistema deve permitir remover todas as jogadas realizadas pelo jogador, preservando os números fixos do tabuleiro.

---

### RF-012
O sistema deve solicitar confirmação antes de executar operações destrutivas, como remover uma jogada ou limpar o tabuleiro.

---

### RF-013
O sistema deve validar as entradas informadas pelo usuário, tratando entradas vazias, inválidas ou incompatíveis com o tipo esperado.

---

### RF-014
O sistema deve permitir que as coordenadas sejam informadas no formato **A1–I9**, convertendo automaticamente esse formato para os índices internos utilizados pelo domínio.

---

### RF-015
O sistema deve validar as opções disponíveis no Menu Principal, impedindo a seleção de opções inexistentes.

---

### RF-016
O sistema deve apresentar o tabuleiro de forma organizada, destacando visualmente os blocos 3×3 e identificando linhas e colunas para facilitar a interação do jogador.

---

# 📝 Requisitos Não Funcionais

### RNF-001
A aplicação deverá ser desenvolvida em Java.

---

### RNF-002
A lógica de negócio deverá permanecer desacoplada da interface de usuário.

---

### RNF-003
A arquitetura deverá seguir o princípio da separação de responsabilidades entre domínio, serviços e interface.

---

### RNF-004
As validações das entradas do usuário deverão permanecer centralizadas na camada de interface (`ConsoleInput`).

---

### RNF-005
A impressão das informações deverá permanecer centralizada na camada de interface (`ConsolePrinter`).

---

### RNF-006
A aplicação deverá continuar funcionando após entradas inválidas do usuário, solicitando novas informações sempre que necessário.

---

### RNF-007
A interface em modo texto deverá priorizar legibilidade e facilidade de uso, sem impactar as regras de negócio da aplicação.

---

### RNF-008
O projeto deverá ser desenvolvido de forma incremental, mantendo a documentação técnica sincronizada com a evolução do software.

---