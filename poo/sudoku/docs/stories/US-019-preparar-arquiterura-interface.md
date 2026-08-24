# US-019 — Preparar arquitetura para múltiplas interfaces

## Informações Gerais

> **ID:** US-019  
> **Sprint:** Sprint 19  
> **Prioridade:** 🔴 Alta  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Separar o fluxo da aplicação da tecnologia utilizada para interação com
o usuário, preparando o projeto para suportar diferentes interfaces
sem comprometer o domínio, as regras do Sudoku e a persistência existentes.

A aplicação deverá possuir uma separação clara entre:

* o fluxo e a orquestração da aplicação;
* a interface utilizada pelo usuário;
* o domínio do Sudoku;
* a persistência dos dados.

---

## 🧭 Contexto

A aplicação atualmente possui seu fluxo principal fortemente associado
à interface de console.

A próxima evolução do produto prevê a criação de uma interface gráfica
desktop.

Antes dessa implementação, é necessário preparar a arquitetura para
que diferentes interfaces possam utilizar as funcionalidades existentes
sem duplicação das regras de negócio ou dependência direta dos
componentes de console.

A arquitetura deverá estabelecer o `JogoSudoku` como responsável pela
orquestração do fluxo da aplicação, enquanto a interface deverá ser
responsável pelo canal de interação com o usuário.

A interface de console existente deverá permanecer como uma forma válida
de interação com a aplicação durante esta etapa.

---

## 📐 Diretriz Arquitetural

A separação desejada deverá seguir conceitualmente:

```text
┌─────────────────────────────┐
│ Interface                   │
│ Console / Futura GUI        │
└──────────────┬──────────────┘
               │ interação
               ▼
┌─────────────────────────────┐
│ JogoSudoku                  │
│ Orquestração da aplicação   │
└──────────────┬──────────────┘
               │
       ┌───────┴────────┐
       ▼                ▼
┌─────────────┐  ┌──────────────┐
│ Domínio     │  │ Persistência │
│ Sudoku      │  │              │
└─────────────┘  └──────────────┘
```

O `JogoSudoku` deverá atuar como ponte entre a interface e as operações
da aplicação, sem assumir responsabilidades específicas de apresentação.

A interface não deverá reproduzir regras do Sudoku ou lógica da partida.

O domínio e a persistência não deverão depender da tecnologia utilizada
para interação com o usuário.

A implementação deverá ser incremental e somente as abstrações
necessárias deverão ser introduzidas durante a execução das Tasks.

---

## 📌 Resultado Esperado

Ao final desta User Story:

* o domínio deverá permanecer independente da interface;
* a persistência deverá permanecer independente da interface;
* o `JogoSudoku` deverá concentrar a orquestração do fluxo da aplicação;
* a interação com o usuário deverá estar desacoplada da implementação
  específica de console;
* a interface de console deverá continuar funcionando;
* o comportamento funcional existente deverá ser preservado;
* uma futura interface gráfica deverá poder utilizar o fluxo da aplicação
  sem duplicação das regras existentes;
* a arquitetura deverá estar preparada para a implementação da primeira
  versão gráfica do produto.

---

## ✅ Critérios de Aceitação

* [x] O domínio do Sudoku não deverá possuir dependências da interface
  utilizada para interação com o usuário.

* [x] A persistência não deverá possuir dependências da interface
  utilizada para interação com o usuário.

* [x] O fluxo da aplicação deverá estar separado das responsabilidades
  específicas da interface.

* [x] O `JogoSudoku` deverá permanecer responsável pela orquestração
  das operações da partida.

* [x] A interface deverá ser responsável pelas operações específicas
  de entrada e apresentação ao usuário.

* [x] As operações e regras da partida deverão poder ser utilizadas por
  uma futura interface gráfica sem duplicação da lógica existente.

* [x] A aplicação deverá continuar funcionando através da interface
  de console após a refatoração.

* [x] As funcionalidades existentes deverão manter seu comportamento
  após a preparação arquitetural.

* [x] A arquitetura resultante deverá permitir a implementação de uma
  nova interface sem necessidade de alterar as regras fundamentais
  do domínio.

---

## 🚫 Fora de Escopo

* Implementação da interface gráfica;
* definição do design visual;
* escolha definitiva do framework gráfico;
* animações;
* distribuição da aplicação;
* empacotamento do jogo;
* níveis de dificuldade;
* estatísticas;
* inteligência artificial;
* novas regras de Sudoku;
* implementação de funcionalidades de produto não relacionadas à
  preparação arquitetural.

---

## 🧩 Estratégia de Implementação

A implementação será conduzida de forma incremental.

O primeiro passo será mapear as responsabilidades atualmente
concentradas no fluxo da partida, identificando:

* responsabilidades de orquestração;
* responsabilidades específicas da interface;
* dependências entre essas responsabilidades;
* pontos de acoplamento que precisam ser reduzidos.

As abstrações arquiteturais serão definidas a partir dessas descobertas,
evitando introduzir padrões ou estruturas sem necessidade comprovada.

A implementação deverá preservar o funcionamento do console durante
todo o processo.

---

## 🧩 Tasks

### TASK-001 — Mapear responsabilidades da interface atual

**Objetivo:**

Identificar as responsabilidades atualmente concentradas no fluxo
da aplicação e separar conceitualmente:

* orquestração;
* entrada do usuário;
* apresentação;
* domínio;
* persistência.

**Ponto inicial de análise:**

`JogoSudoku.executarMenuPartida()`

**Identificado:**

* **Entrada**: `ConsoleInput`;
* **Apresentação**: `ConsolePrinter` e `MenuPartida`;
* **Orquestração**: `JogoSudoku`;
* **Operações da aplicação/domínio**: métodos acionados pelo `JogoSudoku`;
* **Persistência**: acessada através das operações de persistência;
* **Acoplamento identificado**: `JogoSudoku` depende diretamente dos componentes de Console.

Conclusão: a responsabilidade de interação está misturada à orquestração da aplicação.

**Status:** ✅ Concluída

---

### TASK-002 — Definir contrato de interação da aplicação

**Objetivo:**

Definir a abstração necessária para separar o fluxo da aplicação
da tecnologia utilizada pela interface.

A definição deverá ser baseada nas descobertas realizadas na
TASK-001.

**Decisão**

> O contrato de interação será baseado nas operações da aplicação, utilizando tipos específicos para representar os dados necessários. 
> `JogoSudoku` será a implementação do contrato e permanecerá responsável pela orquestração do fluxo, 
> enquanto as interfaces serão responsáveis pela interação com o usuário e pela tradução de seus dados para o contrato da aplicação.

**Status:** ✅ Concluída

---

### TASK-003 — Adaptar a interface Console

**Objetivo:**

Adaptar a implementação de console para utilizar o contrato definido
na etapa arquitetural anterior.

O comportamento atual do console deverá ser preservado.

**Implementação:**

A interface Console foi adaptada aos contratos definidos na
TASK-002:

* `ConsoleInput` implementa `InterfaceUsuario`;
* `ConsolePrinter` implementa `InterfaceApresentacao`.

A implementação existente foi preservada, mantendo as responsabilidades
específicas da interação via console.

A criação dos contratos não alterou as regras de negócio nem a lógica
existente da aplicação.

**Validação:**

Foi executado o fluxo de continuação de uma partida utilizando a
interface Console.

Foi possível:

* carregar uma partida persistida;
* exibir o tabuleiro;
* acessar o menu da partida;
* informar uma coordenada;
* informar uma jogada;
* aplicar a jogada ao tabuleiro;
* visualizar o resultado no console;
* receber e tratar uma jogada inválida.

Também foi verificado que uma regra existente da aplicação permaneceu
funcionando após a adaptação, impedindo a substituição de uma jogada
existente.

A validação completa dos fluxos da aplicação será realizada na
TASK-005.

**Resultado:**

A implementação Console passou a utilizar os contratos de entrada e
apresentação definidos para a aplicação, preservando o comportamento
existente.

**Status:** ✅ Concluída

---

### TASK-004 — Desacoplar `JogoSudoku` da implementação Console

**Objetivo:**

Remover progressivamente as dependências diretas do `JogoSudoku`
em relação aos componentes específicos da interface de console.

**Status:** ✅ Concluída

---

### TASK-005 — Validar o fluxo completo via Console

**Objetivo:**

Garantir que a refatoração arquitetural preserve o comportamento
funcional existente.

Deverão ser validados os principais fluxos da aplicação:

* novo jogo;
* inserir número;
* inserir/remover candidato;
* remover jogada;
* limpar jogadas;
* consultar status;
* salvar partida;
* continuar partida;
* voltar;
* encerrar.

**Validação realizada:**

Foi executado manualmente o fluxo completo da aplicação através da
interface Console após a refatoração arquitetural.

Foram validados os seguintes comportamentos:

* criação de uma nova partida;
* exibição do tabuleiro;
* inserção de número em uma casa editável;
* inserção de candidato;
* remoção de candidato;
* remoção de uma jogada existente;
* limpeza das jogadas realizadas;
* consulta do status da partida;
* salvamento da partida;
* retorno ao menu principal;
* continuação da partida salva;
* recuperação do estado persistido;
* retorno ao menu principal;
* encerramento da aplicação.

Também foi verificado que o comportamento das operações permaneceu
preservado após o desacoplamento da implementação Console.

A partida salva foi posteriormente carregada através da opção
"Continuar", demonstrando que a integração entre a aplicação
refatorada e a persistência permaneceu funcional.

**Resultado:**

O fluxo completo da aplicação permanece funcional através da
interface Console após a refatoração arquitetural.

A validação confirmou que a separação entre a interface e a
orquestração não introduziu regressões funcionais nos fluxos
testados.

**Status:** ✅ Concluída

---

### TASK-006 — Avaliar o resultado arquitetural

**Objetivo:**

Verificar se a arquitetura resultante permite a implementação de
uma segunda interface sem duplicação das regras da aplicação.

Caso sejam identificados novos pontos de acoplamento relevantes,
estes deverão ser analisados antes da conclusão da US.

**Avaliação:**

A arquitetura resultante atende ao objetivo definido para esta etapa.

Foi verificado que:

* `JogoSudoku` não depende mais diretamente das implementações
  específicas do Console;
* `InterfaceUsuario` e `InterfaceApresentacao` representam os contratos
  utilizados pela orquestração da aplicação;
* `ConsoleInput` e `ConsolePrinter` permanecem encapsulados como
  implementações específicas da interface Console;
* o domínio permanece independente da tecnologia de interação;
* a persistência permanece independente da tecnologia de interação;
* uma futura interface poderá implementar os contratos existentes sem
  duplicar as regras da aplicação.

Não foram identificados pontos de acoplamento relevantes que justifiquem
novas abstrações ou refatorações nesta etapa.

**Decisão:**

Não serão introduzidas novas abstrações neste momento. A arquitetura
atual atende ao objetivo da TASK-006 e permite avançar para a avaliação
tecnológica da próxima fase.

**Status:** ✅ Concluída

---

### TASK-007 — Avaliar estratégia tecnológica da próxima fase

**Objetivo:**

Registrar as conclusões arquiteturais necessárias para orientar
a futura implementação da interface gráfica.

A avaliação deverá considerar também os impactos sobre:

* sistema de build;
* gerenciamento de dependências;
* execução;
* testes;
* futura distribuição da aplicação.

A escolha da tecnologia gráfica será realizada nesta Task caso existam informações suficientes para uma decisão fundamentada.

**Estado atual identificado:**

* Java: OpenJDK 26 — Amazon Corretto;
* compilação e execução atualmente realizadas através do IntelliJ IDEA;
* não foi identificado Maven ou Gradle no projeto;
* dependência externa atualmente gerenciada manualmente através de
  `lib/postgresql-42.7.13.jar`;
* persistência utilizando PostgreSQL via JDBC;
* testes organizados no diretório `test/`.

**Avaliação do sistema de build:**

Foram consideradas as alternativas Maven e Gradle para substituir o
gerenciamento manual atual de compilação e dependências.

Considerando o tamanho e a complexidade atual do projeto, o estágio de
aprendizado, a necessidade de tornar o build independente da IDE e a
futura introdução de uma interface gráfica, **Maven foi definido como a
opção recomendada para a próxima fase**.

A escolha não representa uma avaliação negativa do Gradle. A decisão
considera principalmente a simplicidade, a forte convenção de projetos
Java e a adequação do Maven às necessidades atuais do Sudoku.

**Decisão:**

A migração para Maven deverá ser considerada parte da preparação
tecnológica da próxima fase, permitindo centralizar:

* gerenciamento de dependências;
* compilação;
* execução de testes;
* empacotamento;
* configuração do projeto.

A implementação do Maven ainda não será realizada nesta etapa da
TASK-007, pois a configuração definitiva deverá considerar também a
tecnologia gráfica escolhida.

### Avaliação da tecnologia gráfica

Foram avaliadas as alternativas Swing e JavaFX para a implementação da
futura interface gráfica desktop.

Considerando os objetivos do projeto, a evolução prevista da interface,
a necessidade de manter uma separação clara entre apresentação e
orquestração e o caráter de aprendizado e construção de portfólio
técnico, **JavaFX foi definido como a tecnologia gráfica escolhida para
a próxima fase do projeto**.

A escolha considera JavaFX mais adequado ao projeto por oferecer uma
abordagem moderna para construção de interfaces Java, maior capacidade
de evolução visual e melhor alinhamento com a proposta de transformar a
interface do Sudoku em uma camada independente da lógica da aplicação.

Swing foi considerado tecnicamente viável, porém não foi escolhido para
a próxima fase.

A decisão não altera a arquitetura definida na US-019. A futura
interface JavaFX deverá utilizar os contratos e o fluxo da aplicação
existentes, sem duplicar regras de negócio ou lógica de partida.

**Tecnologia gráfica escolhida:** JavaFX.

**Sistema de build recomendado:** Maven.

**Implementação:** será realizada em etapa posterior, após a conclusão
da preparação arquitetural da US-019.

**Status:** ✅ Concluída

---
## 🏛️ Decisões Arquiteturais

* ADR-011 — Separação entre interface e orquestração da aplicação

---

## 🎯 Definition of Done

* [x] Arquitetura refatorada conforme os critérios definidos;
* [x] Domínio independente da interface;
* [x] Persistência independente da interface;
* [x] Orquestração da aplicação separada das responsabilidades
  específicas da interface;
* [x] Console funcionando após a refatoração;
* [x] Funcionalidades existentes validadas;
* [x] Testes manuais/regressivos realizados;
* [x] Código revisado;
* [x] Documentação atualizada;
* [x] Decisões arquiteturais relevantes registradas;
* [x] Build executado com sucesso;
* [x] Commit realizado;
* [x] Push realizado.