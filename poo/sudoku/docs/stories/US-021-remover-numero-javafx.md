# US-021 — Remover número pela interface JavaFX

## Informações Gerais

> **ID:** US-021  
> **Sprint:** Sprint 21  
> **Prioridade:** 🔴 Alta  
> **Status:** 🟢 Concluída

---

## 🎯 Objetivo

Implementar a possibilidade de remover uma jogada realizada pelo jogador
através da interface gráfica JavaFX.

---

## ✅ Critérios de Aceitação

* [x] O jogador deve conseguir selecionar, pela interface JavaFX, uma casa que contenha uma jogada realizada por ele.
* [x] Ao solicitar a remoção, o número inserido pelo jogador deve ser removido da casa selecionada.
* [x] Após uma remoção válida, a interface deve atualizar visualmente a casa, deixando de apresentar o número removido.
* [x] Números pertencentes à configuração inicial do tabuleiro não podem ser removidos pela interface.
* [x] Ao solicitar a remoção de uma casa que não possui uma jogada do jogador, a aplicação deve tratar a situação sem alterar o estado do tabuleiro.
* [x] Após uma remoção válida ou uma tentativa inválida, a aplicação deve permanecer funcional e permitir a continuidade da interação com o tabuleiro.

---

## 🎯 Escopo

* Permitir selecionar uma casa que contenha uma jogada definitiva realizada pelo jogador.
* Disponibilizar uma interação na GUI para solicitar a remoção da jogada.
* Encaminhar a solicitação pela arquitetura existente, sem implementar a regra de Sudoku diretamente na camada JavaFX.
* Remover a jogada da casa selecionada.
* Atualizar a representação visual da casa após a remoção.
* Impedir a remoção de números pertencentes à configuração inicial do tabuleiro.
* Tratar a tentativa de remoção de uma casa sem jogada do jogador.
* Garantir que a partida continue funcional após a operação.

---

## 🚫 Fora de Escopo

* Remoção de candidatos/rascunhos — será tratada pela US-022.
* Limpeza de todas as jogadas — responsabilidade da US-023.
* Finalização da partida — US-024.
* Salvar a partida pela GUI — US-025.
* Continuar partida pela GUI — US-026.
* Alterações estruturais na arquitetura que não sejam necessárias para implementar a remoção.
* Redesign ou refinamento geral da experiência visual da GUI — US-027.
* Distribuição/empacotamento da aplicação — US-028.
* Paridade funcional completa entre JavaFX e Console.

---

## 🔗 Dependências

| ID       | Dependência                                                           | Situação      |
| -------- | --------------------------------------------------------------------- | ------------- |
| **D-01** | Funcionalidades de seleção e interação da GUI desenvolvidas na US-020 | 🟢 Disponível |
| **D-02** | Arquitetura definida na US-019 / ADR-011                              | 🟢 Disponível |
| **D-03** | Capacidade existente de remover uma jogada no domínio/aplicação       | 🟢 Disponível |
| **D-04** | Estado atual do código da US-020                                      | 🟢 Validado   |

---

## 🧩 Tasks

### TASK-001 — Expor operação de remoção na aplicação

**Objetivo:**

Disponibilizar a operação de remoção existente em `JogoSudoku` para que possa ser utilizada pela interface JavaFX, mantendo `Casa.removerNumero()` como responsável pela regra de domínio.

A alteração deverá preservar a arquitetura existente e não deverá introduzir uma refatoração ampla de `JogoSudoku`.

**Status:** 🟢 Concluída.

#### Validação

A operação foi validada através do fluxo Console:

* remoção de uma jogada realizada pelo jogador;
* tentativa de remoção de uma casa fixa;
* tentativa de remoção de uma casa vazia;
* permanência do estado do tabuleiro após tentativas inválidas;
* continuidade da interação com a aplicação.

A operação de remoção apresentou o comportamento esperado em todos os cenários testados.

#### Correção incidental identificada durante a validação

Durante a validação do fluxo de remoção pela interface Console, foi identificado que `executarMenuPartida()` apresentava a mensagem `Jogada removida` independentemente do resultado da operação.

A implementação foi ajustada para que a confirmação seja apresentada somente quando a remoção é efetivamente realizada.

A correção foi validada para:

* remoção válida;
* tentativa de remoção de casa fixa;
* tentativa de remoção de casa vazia.

**Status:** 🟢 Concluída.

---

### TASK-002 — Integrar solicitação de remoção à interface JavaFX

**Objetivo:**

Implementar no `JavaFXController` o fluxo necessário para que uma solicitação de remoção seja encaminhada à aplicação utilizando a casa atualmente selecionada.

A interface JavaFX deverá utilizar o ponto de entrada da aplicação, sem manipular diretamente `Casa` ou `Tabuleiro`.

A forma de interação utilizada pelo jogador para solicitar a remoção será definida durante a implementação da interface.

**Status:** 🟢 Concluída.

#### Validação

* Botão **Remover** integrado à interface JavaFX.
* Remoção sem seleção tratada corretamente.
* Solicitação de remoção de casa vazia tratada corretamente.
* Remoção de jogada realizada pelo jogador validada.
* Tentativa de remoção de casa fixa tratada corretamente.
* Aplicação permaneceu funcional após as operações.
* `mvn clean compile` executado com sucesso.

---

### TASK-003 — Atualizar a representação visual após remoção

**Objetivo:**

Garantir que, após uma remoção válida, a interface JavaFX seja atualizada a partir do estado real do `Tabuleiro`.

A atualização deverá refletir a remoção do número e preservar a possibilidade de interação com a casa e com as demais casas do tabuleiro.

**Status:** 🟢 Concluída.

#### Validação

* Remoção de número e atualização visual da própria casa validadas.
* Interação com a mesma casa após a remoção validada.
* Interação com outras casas após a remoção validada.
* Seleção visual após a atualização do tabuleiro validada.
* Nenhuma alteração de código necessária.

---

### TASK-004 — Validar a User Story

**Objetivo:**

Validar o comportamento completo definido nos critérios de aceitação da US-021, incluindo:

* seleção de uma casa contendo uma jogada realizada pelo jogador;
* remoção da jogada;
* atualização visual;
* tentativa de remoção de uma casa fixa;
* tentativa de remoção de uma casa sem jogada do jogador;
* continuidade da interação após operações válidas ou inválidas;
* preservação do funcionamento da interface Console;
* ausência de regressão na arquitetura existente.

**Status:** 🟢 Concluída.

#### Validação

* Todos os critérios de aceitação da US-021 foram validados.
* Remoção de jogadas pela interface JavaFX validada.
* Tratamento de tentativas inválidas validado.
* Atualização visual e continuidade da interação validadas.
* Funcionamento da interface Console preservado.
* Ausência de regressão arquitetural validada.

---

## 🧪 Critérios de Validação

| ID       | Validação                                          | Resultado esperado                             | Status |
| -------- | -------------------------------------------------- | ---------------------------------------------- | ------ |
| **V-01** | Selecionar uma casa contendo uma jogada do jogador | Casa selecionada corretamente                  | 🟢     |
| **V-02** | Solicitar remoção da jogada                        | Número é removido                              | 🟢     |
| **V-03** | Observar a casa após remoção                       | Interface deixa de apresentar o número         | 🟢     |
| **V-04** | Tentar remover número fixo                         | Operação recusada e estado preservado          | 🟢     |
| **V-05** | Tentar remover casa sem jogada do jogador          | Operação tratada sem alteração indevida        | 🟢     |
| **V-06** | Interagir novamente após remoção válida            | Tabuleiro continua funcional                   | 🟢     |
| **V-07** | Interagir novamente após tentativa inválida        | Aplicação continua funcional                   | 🟢     |
| **V-08** | Executar fluxo equivalente pelo Console            | Funcionalidade existente permanece funcionando | 🟢     |
| **V-09** | Verificar separação arquitetural                   | JavaFX não contém regras de remoção do Sudoku  | 🟢     |

---

## 📋 Definition of Done

### 🧪 Funcional

* [x] US-021 atende aos critérios de aceitação CA-01 a CA-06.
* [x] Critérios de validação V-01 a V-09 executados.
* [x] Remoção de jogada realizada corretamente pela JavaFX.
* [x] Tentativas inválidas não corrompem o estado da partida.
* [x] Console permanece funcional.

### 🏗️ Técnico

* [x] A regra de remoção permanece no domínio (`Casa.removerNumero()`).
* [x] JavaFX não implementa regras do Sudoku.
* [x] `JavaFXController` utiliza o ponto de entrada da aplicação.
* [x] Nenhuma alteração arquitetural desnecessária foi introduzida.
* [x] Não foram criadas abstrações ou refatorações fora do escopo da US-021.

### 🔍 Qualidade

* [x] Código revisado.
* [x] Projeto compila com Maven.
* [x] Testes/validações existentes executados conforme aplicável.
* [x] Não existem regressões conhecidas relacionadas à alteração.

### 📚 Documentação

* [x] `sprint-21.md` atualizado com o resultado da execução.
* [x] `US-021-remover-numero-javafx.md` atualizado com o resultado final.
* [x] Journal/registro de desenvolvimento atualizado conforme o fluxo do projeto.
* [x] Nenhum ADR novo criado sem necessidade arquitetural concreta.

### 🌿 Git

* [x] Alterações organizadas em commits lógicos.
* [x] Commits seguem Conventional Commits.
* [x] Alterações finais preparadas para commit.
* [x] Branch sincronizada com `origin`.
* [x] Repositório preparado para permanecer em estado limpo ao final da operação de commit/push.
