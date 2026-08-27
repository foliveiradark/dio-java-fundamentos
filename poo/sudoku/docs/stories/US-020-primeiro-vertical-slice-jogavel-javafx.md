# US-020 — Primeiro vertical slice jogável com JavaFX

## Informações Gerais

> **ID:** US-020  
> **Sprint:** Sprint 20  
> **Prioridade:** 🔴 Alta  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Criar a primeira versão gráfica do Sudoku utilizando JavaFX,
implementando um **vertical slice pequeno, porém realmente jogável**.

A primeira versão deverá permitir que o usuário percorra o fluxo
essencial de uma partida através da interface gráfica:

```text
Abrir aplicação
↓
Nova partida
↓
Visualizar tabuleiro
↓
Selecionar casa
↓
Inserir número
↓
Visualizar resultado
```

O objetivo desta User Story não é reproduzir imediatamente todas as
funcionalidades existentes na interface Console.

A prioridade será validar a integração entre:

* arquitetura da aplicação;
* sistema de build;
* JavaFX;
* interface gráfica;
* fluxo da partida;
* domínio existente.

A implementação deverá estabelecer uma primeira versão executável e
jogável sobre a qual as funcionalidades gráficas restantes poderão ser
evoluídas incrementalmente.

---

## 🧭 Contexto

A US-019 preparou a arquitetura da aplicação para permitir diferentes
interfaces sem duplicação das regras do Sudoku.

Durante essa etapa foram definidas:

* separação entre interface e orquestração;
* `InterfaceUsuario`;
* `InterfaceApresentacao`;
* `JogoSudoku` como responsável pela orquestração;
* independência do domínio em relação à interface;
* independência da persistência em relação à interface.

Também foram definidas as tecnologias para a próxima fase:

* **Maven** como sistema de build;
* **JavaFX** como tecnologia para a interface gráfica desktop.

A Sprint 20 representa a primeira implementação concreta dessa nova
direção.

A abordagem escolhida será incremental.

Em vez de transportar imediatamente todas as funcionalidades do
Console para a interface gráfica, será desenvolvido inicialmente um
fluxo vertical completo, capaz de demonstrar que a aplicação pode ser
executada graficamente e utilizada para realizar uma operação real de
uma partida.

---

## 📐 Diretriz Arquitetural

A interface JavaFX deverá utilizar a arquitetura preparada na US-019.

Conceitualmente:

```text
┌─────────────────────────────┐
│ Interface JavaFX            │
│                             │
│ Tela / Componentes gráficos │
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

A interface JavaFX não deverá reproduzir regras do Sudoku.

As regras de validação e alteração do estado da partida deverão
permanecer nas camadas responsáveis por essas operações.

A implementação deverá utilizar as abstrações e responsabilidades
definidas na US-019, evitando criar uma segunda implementação das
regras da aplicação especificamente para a GUI.

---

## 🛠️ Estratégia Tecnológica

### Maven

A configuração do Maven fará parte desta User Story.

O Maven será introduzido como sistema de build do projeto, permitindo
centralizar:

* gerenciamento de dependências;
* compilação;
* execução;
* testes;
* configuração do projeto;
* preparação para empacotamento futuro.

A configuração deverá contemplar as dependências necessárias para
execução da aplicação JavaFX.

A migração deverá preservar o funcionamento existente do projeto.

### JavaFX

JavaFX será utilizado como tecnologia da primeira interface gráfica
desktop.

A implementação deverá priorizar uma estrutura simples e adequada ao
estágio atual do projeto, evitando antecipar complexidade de
arquitetura visual que ainda não seja necessária.

---

## 📌 Resultado Esperado

Ao final desta User Story:

* o projeto deverá possuir configuração Maven funcional;
* as dependências necessárias deverão ser gerenciadas pelo Maven;
* a aplicação deverá iniciar por uma aplicação JavaFX;
* deverá existir uma primeira interface gráfica funcional;
* deverá ser possível iniciar uma nova partida através da GUI;
* o tabuleiro deverá ser apresentado graficamente;
* o usuário deverá conseguir selecionar uma casa editável;
* o usuário deverá conseguir inserir um número;
* o resultado da jogada deverá ser refletido visualmente;
* as regras existentes do Sudoku deverão continuar sendo utilizadas;
* a GUI não deverá duplicar as regras fundamentais do domínio;
* o Console deverá permanecer preservado, salvo alterações técnicas
  necessárias à migração para Maven;
* a aplicação deverá continuar compilando e executando corretamente;
* deverá existir uma primeira versão gráfica realmente jogável;
* a arquitetura deverá estar preparada para evolução incremental da GUI.

---

## ✅ Critérios de Aceitação

* [x] O projeto deverá possuir um `pom.xml` funcional.

* [x] As dependências necessárias para execução do JavaFX deverão ser
  gerenciadas pelo Maven.

* [x] O projeto deverá compilar utilizando Maven.

* [x] A aplicação deverá iniciar por uma aplicação JavaFX.

* [x] A GUI deverá permitir iniciar uma nova partida.

* [x] A GUI deverá apresentar visualmente o tabuleiro da partida.

* [x] O usuário deverá conseguir selecionar uma casa editável.

* [x] O usuário deverá conseguir inserir um número na casa selecionada.

* [x] O resultado da operação deverá ser apresentado visualmente no
  tabuleiro.

* [x] As regras existentes da aplicação deverão ser utilizadas pela GUI,
  sem duplicação das regras fundamentais do Sudoku.

* [x] Casas que não podem receber alterações deverão permanecer
  protegidas pelas regras existentes.

* [x] O fluxo essencial de uma partida deverá funcionar de forma
  contínua através da GUI.

* [x] A interface Console deverá permanecer funcional após a introdução
  do Maven e da primeira GUI.

* [x] O projeto deverá compilar e executar corretamente após a
  configuração do Maven.

* [x] A implementação deverá manter a separação arquitetural definida
  na US-019.

---

## 🚫 Fora de Escopo

* Paridade funcional completa com o Console;
* candidatos;
* sistema de rascunhos na GUI;
* salvar partida pela GUI;
* continuar partida pela GUI;
* estatísticas;
* menus completos do jogo;
* níveis de dificuldade;
* cronômetro;
* sistema de vitória;
* animações avançadas;
* efeitos sonoros;
* personalização visual avançada;
* responsividade avançada;
* distribuição da aplicação;
* instalador;
* empacotamento definitivo;
* integração com banco de dados específica da GUI;
* novas regras de Sudoku.

As funcionalidades excluídas poderão ser incorporadas em futuras
User Stories.

---

## 🧩 Estratégia de Implementação

A implementação será conduzida incrementalmente.

A primeira etapa será configurar o Maven e estabelecer uma base de
execução JavaFX.

Em seguida será criada a estrutura mínima da aplicação gráfica.

A implementação deverá evoluir em pequenos incrementos:

1. configuração do Maven;
2. configuração do JavaFX;
3. inicialização da aplicação gráfica;
4. criação da primeira tela;
5. apresentação do tabuleiro;
6. seleção de uma casa;
7. entrada de um número;
8. integração com o fluxo da aplicação;
9. atualização visual do resultado;
10. validação do vertical slice completo.

A complexidade visual deverá ser introduzida somente quando necessária
para cumprir o objetivo da User Story.

O foco desta Sprint será **jogabilidade e integração**, e não
acabamento visual definitivo.

---

## 🧩 Tasks

### TASK-001 — Configurar Maven

**Objetivo:**

Introduzir o Maven como sistema de build do projeto.

Deverão ser configurados:

* `pom.xml`;
* versão do Java utilizada pelo projeto;
* compilação;
* dependências;
* estrutura de testes;
* execução básica do projeto.

A configuração deverá preservar as funcionalidades existentes.

**Implementação:**

O projeto foi migrado para a estrutura padrão Maven:

```text
src/main/java
src/test/java
```

Foi configurado o `pom.xml` com:

* Java 26;
* PostgreSQL `42.7.13`;
* configuração de compilação;
* execução da aplicação através do Maven.

A dependência PostgreSQL anteriormente mantida em `lib/` foi removida,
passando a ser gerenciada pelo Maven.

**Validação:**

Foram executados com sucesso:

```bash
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass=Main
```

A aplicação iniciou corretamente e o IntelliJ IDEA reconheceu o projeto
como Maven, incluindo a dependência PostgreSQL.

Os arquivos existentes em `src/test/java` permanecem como testes manuais;
nenhum teste automatizado foi executado pelo Maven nesta etapa.

**Resultado:**

O Maven foi integrado com sucesso ao projeto, passando a gerenciar a
compilação e as dependências externas.

A aplicação permanece funcional e a estrutura está preparada para as
próximas etapas da US-020.

**Status:** ✅ Concluída

---

### TASK-002 — Configurar JavaFX

**Objetivo:**

Configurar o projeto Maven para disponibilizar os recursos necessários
ao desenvolvimento com JavaFX.

Deverão ser configurados:

* dependência do JavaFX;
* plugin de execução do JavaFX;
* compatibilidade com a versão do Java utilizada.

A configuração deverá permitir a compilação e execução de aplicações
JavaFX através do Maven.

**Implementado:**

* Dependência `javafx-controls` configurada;
* `javafx-maven-plugin` configurado;
* Compatibilidade Java 26 + JavaFX 26.0.1 validada;

**Validação:**

* `mvn clean compile` → BUILD SUCCESS;

**Status:** ✅ Concluída

---

### TASK-003 — Criar aplicação JavaFX mínima

**Objetivo:**

Criar uma aplicação JavaFX mínima para validar a configuração realizada
na TASK-002.

A aplicação deverá possuir um ponto de entrada gráfico e abrir uma
janela funcional quando executada através do Maven.

**Implementado:**

* Criado o ponto de entrada da aplicação JavaFX;
* Criada uma aplicação JavaFX mínima;
* Configurado o `mainClass` para execução através do Maven;
* Janela gráfica exibida com sucesso.

**Validação:**

* `mvn javafx:run` → aplicação executada com sucesso;
* Janela JavaFX aberta e exibindo a mensagem de teste.

**Status:** ✅ Concluída

---

### TASK-004 — Criar primeira tela do Sudoku

**Objetivo:**

Criar a estrutura visual inicial da interface gráfica do Sudoku.

A tela deverá apresentar os elementos mínimos necessários para
representar uma partida de Sudoku, estabelecendo a base visual para as
próximas evoluções da interface.

**Implementado:**

* Criada a janela principal da aplicação JavaFX;
* Criado o título da aplicação;
* Criada a grade principal de 9×9 células;
* Criadas as divisões visuais dos blocos 3×3;
* Definida identidade visual inicial da tela;
* Definido fundo da aplicação e área visual da grade;
* Definidas dimensões e espaçamentos iniciais da interface;
* Criada representação visual de número definitivo;
* Criada representação visual de candidatos em mini grade 3×3;
* Criada representação de célula vazia;
* Validados visualmente os diferentes estados de uma célula;
* Mantida a implementação incremental, utilizando dados de teste
  exclusivamente para validação visual.

**Validação:**

* Aplicação executada através de `mvn javafx:run`;
* Janela gráfica aberta corretamente;
* Grade 9×9 exibida e centralizada;
* Divisões dos blocos 3×3 identificadas visualmente;
* Número definitivo exibido centralizado e em destaque;
* Candidatos exibidos nas posições correspondentes da mini grade 3×3;
* Células vazias representadas corretamente;
* Interface visualmente validada em célula de 60×60 pixels;
* Diferentes estados de uma célula representados corretamente.

**Observação:**

Os valores utilizados nesta Task são dados de teste destinados
exclusivamente à validação visual da interface.

**Status:** ✅ Concluída

---

### TASK-005 — Apresentar o tabuleiro

**Objetivo:**

Integrar o estado do tabuleiro existente à interface JavaFX.

O tabuleiro deverá ser apresentado graficamente respeitando a
configuração da partida.

**Implementado:**

* Criada a implementação JavaFX de `InterfaceApresentacao` através da
  classe `JavaFXPrinter`;
* Transferida para `JavaFXPrinter` a responsabilidade de renderização
  do tabuleiro;
* `JavaFXPrinter` passou a receber o `Tabuleiro` real da aplicação;
* `JogoSudoku` passou a disponibilizar o `Tabuleiro` atual através de
  `getTabuleiro()`;
* Removida da `SudokuApplication` a responsabilidade de construir
  visualmente as células do tabuleiro;
* Mantida a representação visual das casas fixas;
* Mantida a representação visual das casas vazias;
* Mantida a representação visual dos candidatos existentes;
* Preservada a configuração real do tabuleiro, sem criação de dados
  artificiais.

**Validação:**

* Compilação realizada através de `mvn clean compile`;
* Aplicação executada através de `mvn javafx:run`;
* Janela gráfica aberta corretamente;
* Tabuleiro inicial apresentado corretamente;
* Casas fixas carregadas conforme a configuração existente;
* Casas vazias permaneceram vazias;
* Candidatos inexistentes não foram apresentados;
* Números artificiais não foram apresentados;
* Candidatos artificiais não foram apresentados;
* Tabuleiro apresentado através do estado real pertencente ao
  `JogoSudoku`.

**Status:** ✅ Concluída

---

### TASK-006 — Implementar seleção de casa

**Objetivo:**

Permitir que o usuário selecione uma casa do tabuleiro através da
interface gráfica.

A seleção deverá possuir uma indicação visual suficiente para que o
usuário compreenda qual casa está ativa.

**Implementado:**

* Implementado mecanismo de seleção de células por clique;
* Integrada a seleção visual ao `JavaFXPrinter`;
* Criado controle das coordenadas da célula selecionada;
* Implementada indicação visual para a célula ativa;
* Implementado retorno visual da célula anterior ao estado normal;
* Integrada a seleção ao `JavaFXController`;
* Mantida a distinção entre apresentação e lógica de aplicação.

**Validação:**

* Aplicação executada através de `mvn javafx:run`;
* Compilação realizada corretamente;
* Célula visualmente destacada ao receber um clique;
* Ao selecionar uma nova célula, a seleção anterior é removida;
* Seleção validada em diferentes posições do tabuleiro;
* Seleção validada tanto em células fixas quanto editáveis;
* Coordenadas da célula selecionada recebidas corretamente pelo
  `JavaFXController`;
* Fluxo do Console permaneceu funcional e sem alterações.

**Status:** ✅ Concluída

---

### TASK-007 — Implementar inserção de número

**Objetivo:**

Permitir que o usuário informe um número para a casa selecionada.

A operação deverá utilizar o fluxo da aplicação existente, evitando
duplicação das regras de negócio na interface gráfica.

**Implementado:**

* Criado campo de entrada numérica na interface JavaFX;
* Integrado o campo de entrada ao `JavaFXController`;
* Implementado o recebimento do número pelo Controller;
* Implementada a criação de uma `Jogada` do tipo `DEFINITIVA`;
* Utilizada a casa previamente selecionada para determinar a posição da
  jogada;
* Integrada a operação ao `JogoSudoku` através do fluxo existente;
* Mantidas as regras de negócio fora da interface gráfica.

**Validação:**

* Aplicação executada através de `mvn javafx:run`;
* Entrada de número realizada através do `TextField`;
* Tentativa de inserção sem casa selecionada tratada corretamente;
* Casa selecionada corretamente recebida pelo `JavaFXController`;
* Número informado convertido em `Jogada` do tipo `DEFINITIVA`;
* Jogada encaminhada corretamente ao `JogoSudoku`;
* Número inserido corretamente na casa selecionada;
* Resultado apresentado no tabuleiro através do fluxo existente.

**Status:** ✅ Concluída

---

### TASK-008 — Atualizar visualmente o resultado

**Objetivo:**

Atualizar a representação gráfica do tabuleiro após uma jogada válida.

O usuário deverá conseguir perceber visualmente que o estado da partida
foi alterado.

**Implementado:**

* Integrada a atualização visual do tabuleiro ao fluxo de inserção de
  número;
* Após uma jogada definitiva válida, o estado atualizado da partida passou
  a ser refletido visualmente na célula correspondente;
* Mantida a utilização do `JogoSudoku` como responsável pela execução da
  jogada;
* Mantida a responsabilidade do `JavaFXPrinter` pela representação visual
  do tabuleiro;
* Corrigido o comportamento que impedia a seleção de novas células após
  uma jogada;
* Preservado o mecanismo de seleção visual implementado na TASK-006;
* Mantida a possibilidade de realizar novas jogadas após a atualização
  visual.

**Validação:**

* Projeto compilado através de `mvn clean compile`;
* Aplicação executada através de `mvn javafx:run`;
* Casa editável selecionada corretamente;
* Número válido informado e inserido através do fluxo existente;
* Número inserido apresentado visualmente na célula correspondente;
* Após a inserção do número, outras células permaneceram selecionáveis;
* Seleção visual continuou funcionando após a atualização do tabuleiro;
* Foi realizada uma segunda seleção em outra célula;
* Foi realizada uma segunda inserção de número em outra casa;
* O fluxo de seleção e inserção permaneceu funcional após múltiplas
  interações.

**Correção realizada:**

Durante a implementação foi identificado que, após a inserção de um
número, a interface deixava de permitir a seleção de novas células.

O comportamento foi corrigido para que a atualização visual do resultado
não interrompa o mecanismo de seleção do tabuleiro.

**Resultado:**

A GUI agora reflete visualmente uma jogada definitiva válida e permanece
interativa após a atualização, permitindo que o usuário continue
selecionando células e realizando novas jogadas.

**Status:** ✅ Concluída

---

# TASK-009 — Validar regras existentes através da GUI

**Objetivo:**

Garantir que a interface gráfica utilize corretamente as regras
existentes da aplicação.

Deverão ser validados, no mínimo:

* inserção em casa editável;
* tentativa de alteração de casa não editável;
* comportamento de uma jogada inválida, conforme as regras existentes.

**Implementado:**

* Implementado `JavaFXPrinter.exibirErro(String mensagem)`;
* Utilizado `Alert` do JavaFX para apresentação das mensagens de erro;
* Mantido o processamento das regras de validação no fluxo existente da
  aplicação;
* A GUI permanece responsável apenas pela interação e apresentação,
  sem duplicação das regras do Sudoku;
* Campo de entrada é limpo após o processamento da jogada.

**Validação:**

  * Casa selecionada corretamente;
  * Número válido aceito;
  * Número exibido visualmente no tabuleiro;
  * `TextField` limpo;
  * Aplicação permanece ativa.
  * Tentativa de alteração rejeitada pela regra existente;
  * `Alert` de erro apresentado corretamente;
  * Alerta fechado através do botão `Ok`;

**Resultado:**

A GUI demonstrou utilizar corretamente as regras existentes da aplicação
para jogadas válidas e inválidas.

Os erros são apresentados ao usuário sem encerramento da aplicação,
permitindo a continuidade da partida.

A validação também confirmou a manutenção da separação entre a interface
JavaFX e as regras de negócio existentes.

**Status:** ✅ Concluída

---

### TASK-010 — Validar o vertical slice completo

**Objetivo:**

Validar o fluxo completo definido para a Sprint:

```text
Abrir aplicação
↓
Nova partida
↓
Visualizar tabuleiro
↓
Selecionar casa
↓
Inserir número
↓
Visualizar resultado
```

Também deverá ser verificado que a introdução do Maven e JavaFX não
comprometeu o funcionamento do Console.

**Validação:**

* Fluxo completo da GUI executado com sucesso;
* Seleção de diferentes casas funcionando;
* Inserção de números válidos funcionando;
* Atualização visual do tabuleiro funcionando;
* Validação de jogada existente funcionando por mensagem de erro;
* Interação com a aplicação permanece ativa após mensagens de erro;
* Campo de entrada é limpo após a operação;
* Aplicação Console executada via Maven com sucesso;
* Persistência e continuidade da partida no Console permanecem funcionando;
* `mvn clean compile` executado com sucesso;
* `mvn javafx:run` executado com sucesso.

**Status:** ✅ Concluída

---

### TASK-011 — Avaliar resultado arquitetural

**Objetivo:**

Avaliar se a primeira implementação JavaFX respeitou a separação
arquitetural definida na US-019.

Deverá ser verificado especialmente:

* ausência de regras duplicadas na GUI;
* utilização adequada do fluxo da aplicação;
* independência do domínio;
* manutenção da separação entre interface e aplicação;
* ausência de abstrações prematuras.

**Resultado:**

A implementação JavaFX manteve a separação arquitetural definida,
utilizando o fluxo existente da aplicação para executar as jogadas,
sem duplicar regras de negócio na interface gráfica.

A GUI permanece responsável pela interação e apresentação, enquanto
as regras continuam centralizadas na camada de aplicação e domínio.

Não foram identificadas abstrações prematuras relevantes nesta etapa.

**Status:** ✅ Concluída

---

## 🏛️ Decisões Arquiteturais

* ADR-011 — Separação entre interface e orquestração da aplicação
  *(definido na US-019)*

Novos ADRs somente deverão ser criados caso uma decisão arquitetural
relevante seja identificada durante a implementação da Sprint.

---

## 🎯 Definition of Done

* [x] Maven configurado e funcional;
* [x] Dependências JavaFX gerenciadas pelo Maven;
* [x] Projeto compilando através do Maven;
* [x] Aplicação JavaFX iniciando corretamente;
* [x] Primeira tela gráfica implementada;
* [x] Tabuleiro apresentado na GUI;
* [x] Seleção de casa funcionando;
* [x] Inserção de número funcionando;
* [x] Resultado da jogada apresentado visualmente;
* [x] Regras existentes preservadas;
* [x] Console preservado;
* [x] Vertical slice validado;
* [x] Código revisado;
* [x] Documentação atualizada;
* [x] Build executada com sucesso;
* [x] Commit realizado;
* [x] Push realizado.