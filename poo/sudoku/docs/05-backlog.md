# Product Backlog

---

# 🎯 Objetivo

O Product Backlog representa a lista priorizada de funcionalidades e
evoluções do projeto.

As User Stories serão selecionadas para as Sprints conforme a evolução
do desenvolvimento e a estratégia definida para o produto.

---

# MVP — Fundação do Produto

## US-001 — Visualizar o tabuleiro

**Como jogador**

Quero visualizar o tabuleiro

Para acompanhar o estado atual do jogo.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-002 — Carregar o Tabuleiro Inicial

**Como jogador**

Quero iniciar uma nova partida

Para começar um novo Sudoku.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-003 — Menu Principal

**Como jogador**

Quero visualizar o menu principal

Para iniciar uma nova partida ou acessar as opções do jogo.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-004 — Inserir um número

**Como jogador**

Quero inserir um número em uma posição

Para resolver o Sudoku.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-005 — Tratar jogadas inválidas

**Como jogador**

Quero receber mensagens claras quando realizar uma jogada inválida

Para continuar a partida sem que a aplicação seja encerrada.

**Critérios:**

* Não encerrar a aplicação após erro;
* Exibir mensagem amigável;
* Permitir nova tentativa.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-006 — Melhorar a identificação das coordenadas do tabuleiro

**Como jogador**

Quero visualizar linhas e colunas identificadas

Para localizar facilmente as posições do tabuleiro.

**Critérios:**

* Exibir índices de linhas;
* Exibir índices de colunas;
* Facilitar a interação do jogador.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-007 — Remover um número

**Como jogador**

Quero remover uma jogada

Para corrigir um erro.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-008 — Verificar o status do jogo

**Como jogador**

Quero saber se o jogo está incompleto, completo ou contém erros

Para acompanhar meu progresso.

Prioridade: 🟠 Média

Status: ✅ Concluído

---

## US-009 — Limpar o tabuleiro

**Como jogador**

Quero remover todas as jogadas realizadas

Para manter apenas os números fixos.

Prioridade: 🟠 Média

Status: ✅ Concluído

---

## US-010 — Finalizar partida

**Como jogador**

Quero concluir a partida

Para finalizar o Sudoku quando ele estiver corretamente resolvido.

Prioridade: 🟠 Média

Status: ✅ Concluído

---

## US-011 — Validar entradas vazias e inválidas do usuário

**Como jogador**

Quero que o sistema trate entradas vazias ou inválidas

Para evitar o encerramento inesperado da aplicação e receber mensagens de erro amigáveis.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-012 — Permitir entrada de coordenadas em formato A1–I9

**Como jogador**

Quero informar as coordenadas utilizando letras e números

Para localizar as casas do tabuleiro de forma mais intuitiva.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-013 — Validar respostas de confirmação (S/N)

**Como jogador**

Quero informar apenas respostas válidas nas confirmações do sistema

Para evitar que entradas incorretas sejam interpretadas automaticamente como "Não".

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-014 — Validar opções do Menu Principal

**Como jogador**

Quero receber uma mensagem quando informar uma opção inexistente no menu

Para entender que a opção informada não é válida e poder escolher novamente.

### Critérios

* aceitar apenas opções existentes;
* exibir mensagem amigável;
* solicitar novamente a opção;
* manter a aplicação em execução.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-015 — Refinar a interface visual do tabuleiro

**Como jogador**

Quero visualizar um tabuleiro com melhor organização visual

Para facilitar a leitura durante a partida.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

# Evolução do Produto

## US-016 — Interface gráfica (Swing)

**Como jogador**

Quero jogar Sudoku através de uma interface gráfica desktop

Para ter uma experiência de jogo agradável, intuitiva e visualmente diferenciada.

### Evolução do escopo

A US-016 foi originalmente prevista como uma melhoria visual da interface
existente.

Posteriormente, seu escopo foi ampliado para representar a transição da
aplicação em modo console para uma aplicação desktop gráfica, jogável e
distribuível.

Durante a US-019, a tecnologia gráfica foi avaliada e **JavaFX foi definida
como a tecnologia escolhida para a próxima fase**.

Por esse motivo, a US-016 não será implementada com Swing.

A implementação da interface gráfica foi desmembrada em uma nova User Story,
US-020, criada para representar explicitamente a implementação da interface
JavaFX.

Prioridade: 🟢 Baixa

Status: 🔄 Reclassificada

> A US-016 é mantida como registro histórico da evolução do requisito.
> Sua implementação foi substituída pela US-020 — Interface gráfica JavaFX.

---

## US-017 — Sistema de rascunhos

**Como jogador**

Quero inserir números de rascunho nas casas do Sudoku

Para registrar possibilidades enquanto resolvo a partida.

### Origem

Requisito opcional do exercício da DIO:

> Ter a opção de colocar números de rascunho nos quadrados,
> seguindo o modelo proposto na seção "Modelo de rascunho".

### Interpretação adotada

Uma mesma casa poderá conter múltiplos números de rascunho
simultaneamente, representando diferentes possibilidades para aquela casa.

### Critérios de aceitação

* Permitir inserir números de rascunho em uma casa;
* Permitir múltiplos números de rascunho simultaneamente na mesma casa;
* Permitir adicionar individualmente um número de rascunho;
* Permitir remover individualmente um número de rascunho;
* Os números de rascunho devem utilizar os valores de 1 a 9;
* A representação dos rascunhos deve seguir o modelo apresentado no exercício.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-018 — Continuar partida

**Como jogador**

Quero continuar uma partida iniciada

Para não perder meu progresso.

Prioridade: 🟢 Baixa

Status: ✅ Concluído

---

## US-019 — Preparar arquitetura para múltiplas interfaces

**Como desenvolvedor**

Quero separar o fluxo da aplicação da tecnologia de interface utilizada

Para permitir a evolução da aplicação de console para uma interface gráfica
sem comprometer o domínio, as regras do jogo e a persistência existentes.

Prioridade: 🔴 Alta

Status: ✅ Concluído

### Resultado

A arquitetura foi preparada para suportar diferentes interfaces.

Foram definidos contratos de interação e apresentação, o `JogoSudoku`
foi desacoplado das implementações específicas do Console e os fluxos
existentes foram validados após a refatoração.

Também foram definidas as tecnologias para a próxima fase:

* **Sistema de build:** Maven;
* **Tecnologia gráfica:** JavaFX.

---

## US-020 — Implementar interface gráfica JavaFX

**Como jogador**

Quero jogar Sudoku por uma interface gráfica desktop em JavaFX

Para ter uma experiência de jogo agradável, intuitiva e visualmente
diferenciada.

### Contexto

A US-020 representa a próxima etapa da evolução do produto após a
preparação arquitetural realizada pela US-019.

A arquitetura existente deverá ser utilizada como base para a
implementação da interface gráfica, evitando duplicação das regras do
Sudoku e mantendo a separação entre interface, aplicação, domínio e
persistência.

A implementação deverá considerar as decisões registradas durante a
US-019:

* JavaFX como tecnologia gráfica;
* Maven como sistema de build;
* `JogoSudoku` como responsável pela orquestração da aplicação;
* interface desacoplada das regras do domínio;
* persistência independente da interface.

O detalhamento das Tasks e do escopo de implementação será realizado
durante o planejamento da Sprint correspondente.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-021 — Remover número pela interface JavaFX

**Como jogador**

Quero remover uma jogada pela interface gráfica

Para corrigir um número inserido anteriormente.

Prioridade: 🔴 Alta

Status: ✅ Concluído

---

## US-022 — Utilizar candidatos pela interface JavaFX

**Como jogador**

Quero inserir e remover números de rascunho pela interface gráfica

Para registrar e ajustar possibilidades durante a resolução do Sudoku.

Prioridade: 🔴 Alta

Status: ⏳ Backlog

---

## US-023 — Limpar jogadas pela interface JavaFX

**Como jogador**

Quero limpar as jogadas realizadas pela interface gráfica

Para remover minhas alterações e manter apenas os números fixos do tabuleiro.

Prioridade: 🟠 Média

Status: ⏳ Backlog

---

## US-024 — Finalizar partida pela interface JavaFX

**Como jogador**

Quero finalizar a partida pela interface gráfica

Para concluir o Sudoku quando ele estiver corretamente resolvido.

Prioridade: 🟠 Média

Status: ⏳ Backlog

---

## US-025 — Salvar partida pela interface JavaFX

**Como jogador**

Quero salvar minha partida pela interface gráfica

Para preservar meu progresso e continuar posteriormente.

Prioridade: 🟠 Média

Status: ⏳ Backlog

---

## US-026 — Continuar partida pela interface JavaFX

**Como jogador**

Quero continuar uma partida salva pela interface gráfica

Para retomar meu progresso sem precisar iniciar uma nova partida.

Prioridade: 🟠 Média

Status: ⏳ Backlog

---

## US-027 — Refinar experiência de interação da GUI

**Como jogador**

Quero uma interface gráfica com interações mais claras e consistentes

Para jogar Sudoku de forma mais intuitiva e agradável.

Prioridade: 🟡 Média

Status: ⏳ Backlog

---

## US-028 — Preparar distribuição da aplicação desktop

**Como usuário**

Quero executar a aplicação desktop fora do ambiente de desenvolvimento

Para utilizar o Sudoku como uma aplicação independente.

Prioridade: 🟢 Baixa

Status: ⏳ Backlog

---

# Próximas Evoluções Planejadas

A próxima etapa do projeto consiste na ampliação progressiva da interface
gráfica JavaFX, incorporando funcionalidades já existentes no domínio e na
interface Console.

As próximas evoluções estão registradas e priorizadas no Product Backlog,
a partir da US-021.

---

# Evoluções Futuras

Funcionalidades que poderão ser consideradas após a consolidação da
aplicação desktop e da infraestrutura necessária para sua evolução:

* níveis de dificuldade;
* progressão;
* gerador automático de Sudoku;
* resolver Sudoku automaticamente;
* estatísticas da partida;
* histórico de partidas;
* exportar partidas.

---

# Visão Futura

Possibilidades ainda fora do escopo atual:

* interação com IA durante as partidas;
* recursos inteligentes de auxílio ao jogador;
* novas formas de interação e experiência.

Essas funcionalidades dependerão da evolução técnica e da validação do
produto ao longo do projeto.