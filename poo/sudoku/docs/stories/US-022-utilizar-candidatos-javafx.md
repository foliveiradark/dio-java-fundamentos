# US-022 — Utilizar candidatos pela interface JavaFX

## Informações Gerais

> **ID:** US-022  
> **Sprint:** Sprint 22  
> **Prioridade:** 🔴 Alta  
> **Status:** ✅ Concluída.

---

## 🎯 Objetivo

Permitir que o jogador utilize candidatos pela interface JavaFX, podendo adicionar e remover possibilidades em uma casa vazia durante a resolução do Sudoku.

---

## ✅ Critérios de Aceitação

* [x] **CA-01** — O jogador deve conseguir selecionar uma casa vazia pela interface JavaFX e adicionar um candidato a ela.
* [x] **CA-02** — O jogador deve conseguir adicionar múltiplos candidatos à mesma casa vazia.
* [x] **CA-03** — Ao adicionar um candidato que já esteja registrado na casa, o candidato deve ser removido, mantendo o comportamento de alternância já definido no domínio.
* [x] **CA-04** — A interface deve refletir visualmente os candidatos atualmente registrados na casa.
* [x] **CA-05** — O jogador não deve conseguir adicionar ou remover candidatos de uma casa que contenha um número definitivo.
* [x] **CA-06** — O jogador não deve conseguir adicionar ou remover candidatos de uma casa fixa.
* [x] **CA-07** — Uma tentativa inválida de utilizar candidatos deve ser tratada sem alterar indevidamente o estado do tabuleiro.
* [x] **CA-08** — A utilização de candidatos pela JavaFX deve utilizar as operações existentes da aplicação e do domínio, sem reproduzir regras de candidatos na interface.
* [x] **CA-09** — O comportamento já existente da interface Console para candidatos deve permanecer funcional.

---

## 🎯 Escopo

* Disponibilizar na interface JavaFX uma interação para utilização de candidatos, permitindo ao jogador indicar um número como candidato da casa selecionada.
* Permitir adicionar e remover candidatos utilizando o comportamento de alternância já existente no domínio.
* Permitir múltiplos candidatos na mesma casa, respeitando as regras já implementadas em `Casa`.
* Integrar a interação da JavaFX ao fluxo da aplicação, utilizando `JogoSudoku.executarJogada(...)` e `TipoJogada.CANDIDATO`, sem acesso direto da interface às regras do domínio.
* Atualizar a representação visual da casa após a alteração dos candidatos, refletindo o estado atual do `Tabuleiro`.
* Tratar as situações em que a operação não pode ser realizada, incluindo:
    * nenhuma casa selecionada;
    * casa fixa;
    * casa contendo número definitivo;
    * demais erros de domínio já existentes.
* Preservar o comportamento existente da interface Console, garantindo que a introdução da funcionalidade na JavaFX não altere o fluxo já existente.
* Manter a separação de responsabilidades definida nas Sprints anteriores, sem transferir regras de candidatos para a camada JavaFX.

---

## 🚫 Fora de Escopo

* Alterações ou refatorações na lógica de candidatos do domínio, já implementada na `Casa`.
* Criação de novas regras de validação de candidatos que não sejam necessárias para os critérios desta US.
* Alteração do comportamento de candidatos na interface Console.
* Implementação de limpeza de todas as jogadas definitivas, prevista na US-023.
* Implementação da finalização/conclusão da partida, prevista na US-024.
* Persistência de alterações realizadas durante a partida, prevista nas US-025 e US-026.
* Refinamento geral da experiência visual da JavaFX, além do necessário para disponibilizar e visualizar os candidatos, previsto na US-027.
* Distribuição da aplicação como produto desktop, prevista na US-028.
* Mudanças arquiteturais não necessárias para atender aos critérios desta US.
* Paridade funcional completa entre JavaFX e Console.

---

## 🔗 Dependências

| ID       | Dependência                                                                                                                                                          | Situação     |
|----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| **D-01** | **US-017 — Sistema de rascunhos:** disponibiliza as operações e regras de candidatos no domínio e estabelece o comportamento funcional que será exposto pela JavaFX. | 🟢 Concluída |
| **D-02** | **US-019 — Preparar arquitetura para múltiplas interfaces:** estabelece a separação entre interface, orquestração e domínio utilizada pela JavaFX.                   | 🟢 Concluída |
| **D-03** | **US-020 — Implementar JavaFX GUI:** disponibiliza a estrutura inicial da interface JavaFX, seleção de casas e integração com `JogoSudoku`.                          | 🟢 Concluída |
| **D-04** | **US-021 — Remover número pela interface JavaFX:** mantém o fluxo atual de seleção e interação com uma casa, servindo como base para a nova interação de candidatos. | 🟢 Concluída |

---

## 7. Decisões Técnicas

### Utilização de `JogoSudoku.executarJogada()` como ponto de entrada

A JavaFX deverá encaminhar a intenção de adicionar ou remover candidato para `JogoSudoku`, utilizando `Jogada` com `TipoJogada.CANDIDATO`.

A interface não deverá chamar diretamente `Casa.alternarCandidato()`.

Essa abordagem preserva a separação estabelecida na US-019:

**JavaFX → JogoSudoku → Domínio**

### Reutilização de `Casa.alternarCandidato()`

A regra de alternância existente será mantida:

* candidato inexistente → adiciona;
* candidato existente → remove.

Não será criada uma nova implementação específica para JavaFX.

### Regras de candidatos permanecem fora da JavaFX

A interface será responsável pela interação e apresentação, enquanto as validações permanecem no domínio e na aplicação.

Situações como casa fixa, casa preenchida ou candidato inválido deverão continuar sendo tratadas pelas regras existentes.

### Representação visual dos candidatos pertence à JavaFX

A interface deverá consultar o estado atual da casa ou do tabuleiro e representar os candidatos existentes.

Não será criada uma segunda estrutura de candidatos exclusivamente para a interface.

### Manutenção da arquitetura existente

A US-022 deverá utilizar a arquitetura existente, sem introduzir novos serviços, interfaces ou camadas apenas para suportar candidatos.

As decisões registradas nesta seção são decorrentes das decisões já estabelecidas nas US-017 e US-019. Não foi identificada, neste momento, necessidade de criação de nova ADR.

---

## 🧩 Tasks

### TASK-001 — Implementar modo de candidatos na JavaFX

**Objetivo:**

Disponibilizar na interface JavaFX um modo de entrada de candidatos que permita ao jogador indicar que o número selecionado deve ser tratado como candidato da casa selecionada, encaminhando essa intenção para `JogoSudoku` por meio de `Jogada` com `TipoJogada.CANDIDATO`.

**Status:** ✅ Concluído.

#### Validação

* [x] A interface permite ativar o modo candidato.
* [x] A interface permite retornar ao modo normal.
* [x] O modo normal gera jogadas `DEFINITIVA`.
* [x] O modo candidato gera jogadas `CANDIDATO`.
* [x] A alternância entre os modos não interfere na seleção da casa.
* [x] A seleção da casa permanece funcional.
* [x] A JavaFX não acessa diretamente `Casa.alternarCandidato()`.
* [x] A JavaFX utiliza `JogoSudoku.executarJogada()` para encaminhar a operação.
* [x] A lógica existente de candidatos é reutilizada.
* [x] O fluxo existente de jogadas definitivas permanece funcional.
* [x] Um candidato adicionado é refletido visualmente no mini-grid da casa.
* [x] A repetição do mesmo candidato o remove.
* [x] É possível manter múltiplos candidatos na mesma casa.
* [x] Casas fixas rejeitam operações de candidatos.
* [x] Casas preenchidas com jogadas definitivas rejeitam operações de candidatos.
* [x] Operações sem casa selecionada não alteram o estado do tabuleiro.
* [x] O feedback da operação de candidato ocorre pela atualização visual do tabuleiro.
* [x] A implementação JavaFX não mantém estado paralelo dos candidatos.
* [x] O fluxo de candidatos não gera exceção durante a atualização do tabuleiro.

#### Resultado

O modo de candidatos foi integrado à interface JavaFX utilizando o fluxo existente de `JogoSudoku` e `Casa`, sem duplicação das regras de domínio na camada de apresentação.

A interface permite alternar entre jogadas definitivas e candidatos, adicionar e remover candidatos e manter múltiplas possibilidades em uma mesma casa. A representação visual dos candidatos é derivada diretamente do estado atual da `Casa`.

As restrições existentes para casas fixas e casas preenchidas permanecem sendo aplicadas pelo domínio e apresentadas pela JavaFX.

Como decisão específica da implementação JavaFX, não são exibidas mensagens textuais para adição ou remoção de candidatos. A atualização visual do mini-grid é considerada feedback suficiente para essa operação.

#### Observações

A apresentação visual do botão de alternância do modo candidato permanece fora do escopo deste TASK e poderá ser refinada posteriormente.

---

### TASK-002 — Exibir e atualizar candidatos na interface JavaFX

**Objetivo:**

Permitir que a interface JavaFX represente visualmente os candidatos atualmente registrados em uma casa, atualizando sua apresentação após a inclusão ou remoção de um candidato.

**Status:** ✅ Concluído.

#### Validação

* [x] Uma casa vazia apresenta a área destinada aos candidatos.
* [x] Os candidatos são apresentados em uma organização 3×3.
* [x] Um candidato adicionado aparece visualmente na posição correspondente.
* [x] Um candidato removido deixa de ser apresentado.
* [x] Múltiplos candidatos são apresentados simultaneamente.
* [x] A representação visual corresponde ao estado atual da `Casa`.
* [x] A JavaFX não mantém uma coleção paralela de candidatos.
* [x] Uma casa com número definitivo continua sendo apresentada corretamente.
* [x] Uma casa sem candidatos continua sendo apresentada corretamente.

#### Resultado

A interface JavaFX passou a representar visualmente os candidatos registrados em uma casa vazia por meio de uma organização interna 3×3, sem linhas internas visíveis.

A representação é reconstruída a partir do estado atual da `Casa`, garantindo que inclusões e remoções sejam refletidas no tabuleiro sem manutenção de estado paralelo na camada JavaFX.

Casas preenchidas continuam sendo apresentadas com o número definitivo, enquanto casas vazias sem candidatos permanecem corretamente representadas.

#### Observações

Durante a validação foi identificado que pressionar `Enter` com o campo de número vazio provoca `NumberFormatException`.

O comportamento não interfere na representação dos candidatos e não bloqueia este TASK. A melhoria da validação e do feedback da entrada numérica será tratada posteriormente no refinamento da interação JavaFX.

Também foi mantida a decisão de não desenhar linhas internas na área 3×3 dos candidatos, evitando sobrecarregar visualmente o tabuleiro. A organização espacial dos candidatos é suficiente para comunicar suas posições.

#### Code Review

**Status:** ✅ Aprovado.

A implementação foi revisada considerando:

* reconstrução do tabuleiro a partir do `Tabuleiro`;
* separação entre número definitivo e candidatos;
* leitura dos candidatos diretamente da `Casa`;
* ausência de estado paralelo na JavaFX;
* organização correta dos candidatos na matriz 3×3;
* atualização visual após alterações no estado do domínio;
* manutenção da separação de responsabilidades entre domínio e interface.

---

### TASK-003 — Tratar restrições e estados inválidos

**Objetivo:**

Garantir que a utilização de candidatos pela interface JavaFX trate corretamente situações em que a operação não pode ser realizada, preservando o estado do tabuleiro e utilizando as validações existentes da aplicação e do domínio.

**Status:** ✅ Concluído.

#### Validação

* [x] A tentativa de utilizar candidato sem selecionar uma casa é tratada.
* [x] A tentativa de utilizar candidato em uma casa fixa é rejeitada.
* [x] A tentativa de utilizar candidato em uma casa preenchida é rejeitada.
* [x] Um candidato inválido é rejeitado pelas validações existentes.
* [x] A operação inválida não altera indevidamente o estado do tabuleiro.
* [x] O usuário recebe feedback sobre a operação inválida.
* [x] A interface permanece funcional após uma operação inválida.
* [x] A JavaFX não duplica as regras de validação existentes no domínio.

#### Resultado

As situações inválidas da utilização de candidatos pela JavaFX passaram a ser tratadas sem alteração indevida do estado do tabuleiro.

A ausência de seleção é identificada pelo `JavaFXController`, que utiliza a abstração `InterfaceApresentacao` para solicitar o feedback ao usuário. A implementação concreta `JavaFXPrinter` apresenta o erro por meio de `Alert`, evitando o uso do console como mecanismo de feedback da interface gráfica.

As demais restrições continuam sendo validadas pelas camadas existentes: casas fixas e preenchidas são rejeitadas pelo domínio, e candidatos fora do intervalo permitido continuam sendo rejeitados por `Casa`. A JavaFX não duplica essas regras.

Após uma operação inválida, a interface permanece funcional e uma operação válida pode ser realizada normalmente.

#### Decisão técnica

O `JavaFXController` passou a receber uma dependência de `InterfaceApresentacao` por injeção de dependência.

A decisão mantém o Controller desacoplado da implementação concreta `JavaFXPrinter` e preserva a separação de responsabilidades:

* `JavaFXController` gerencia o estado da interação e identifica ausência de seleção;
* `JogoSudoku` coordena as operações do jogo;
* `Casa` mantém as regras de validação do domínio;
* `InterfaceApresentacao` define o contrato de apresentação;
* `JavaFXPrinter` implementa a apresentação gráfica dos erros.

#### Code Review

**Status:** ✅ Aprovado.

A implementação foi revisada considerando:

* tratamento de ausência de seleção;
* rejeição de casas fixas e preenchidas;
* rejeição de candidatos inválidos;
* preservação do estado após operações inválidas;
* continuidade do fluxo após erro;
* uso da abstração `InterfaceApresentacao`;
* ausência de duplicação das regras de domínio na JavaFX;
* encapsulamento da dependência `InterfaceApresentacao`;
* nomenclatura adequada da dependência no construtor.

---

### TASK-004 — Integrar e validar fluxo completo de candidatos pela JavaFX

**Objetivo:**

Integrar as funcionalidades desenvolvidas nas TASKs anteriores e validar o fluxo completo de utilização de candidatos pela interface JavaFX, garantindo que a interação, o estado do domínio e a representação visual permaneçam consistentes.

**Status:** ✅ Concluído.

#### Validação

* [x] É possível selecionar uma casa vazia.
* [x] É possível ativar e desativar o modo candidato.
* [x] É possível adicionar um candidato.
* [x] O candidato adicionado é apresentado visualmente.
* [x] É possível adicionar múltiplos candidatos na mesma casa.
* [x] É possível remover um candidato utilizando a mesma interação.
* [x] A remoção atualiza corretamente a representação visual.
* [x] É possível remover individualmente um candidato sem afetar os demais.
* [x] O fluxo de jogadas definitivas permanece funcional.
* [x] A conversão de candidatos para jogada definitiva remove corretamente os candidatos da casa.
* [x] Uma tentativa de adicionar candidato em casa preenchida é rejeitada.
* [x] Uma tentativa de adicionar candidato em casa fixa é rejeitada.
* [x] Um candidato inválido é rejeitado sem alterar o estado da casa.
* [x] Após uma operação inválida, uma operação válida pode ser realizada normalmente.
* [x] A ausência de seleção é tratada sem alteração do tabuleiro.
* [x] A remoção de jogada definitiva permanece funcional.
* [x] A interface Console permanece funcional.
* [x] O fluxo completo respeita a separação JavaFX → JogoSudoku → Domínio.

#### Resultado

O fluxo completo de utilização de candidatos pela interface JavaFX foi integrado e validado com sucesso.

A interface permite selecionar uma casa vazia, ativar o modo candidato e adicionar ou remover candidatos individualmente. Múltiplos candidatos podem coexistir na mesma casa e sua representação visual permanece sincronizada com o estado atual do domínio.

Também foi validado o fluxo entre candidatos e jogadas definitivas. Ao inserir um número definitivo em uma casa que possuía candidatos, os candidatos são removidos pelo próprio domínio, mantendo apenas o número definitivo.

As restrições existentes foram preservadas. Casas fixas e casas preenchidas rejeitam operações de candidato, números fora do intervalo permitido são rejeitados e operações inválidas não alteram indevidamente o estado do tabuleiro. Após uma operação inválida, a interface permanece funcional e permite a continuidade da partida.

A ausência de seleção também é tratada pela interface JavaFX por meio de `InterfaceApresentacao`, sem transferir para `JogoSudoku` a responsabilidade pelo estado de interação da interface.

A regressão da remoção de jogadas definitivas, implementada na US-021, permaneceu funcional. Após a remoção, a casa retorna ao estado vazio e a área destinada aos candidatos é novamente apresentada.

O comportamento de candidatos da interface Console também foi validado, incluindo adição, múltiplos candidatos e remoção individual, sem regressão identificada.

#### Evidências de integração

O fluxo validado mantém a seguinte separação de responsabilidades:

`JavaFXController` → `JogoSudoku` → `Casa`

O `JavaFXController` determina o tipo da jogada e cria a `Jogada` correspondente, enquanto `JogoSudoku` permanece responsável pela orquestração e `Casa` mantém as regras de candidatos.

A `JavaFXPrinter` reconstrói a representação visual a partir do estado atual do `Tabuleiro` e das `Casa`, sem manter uma coleção paralela de candidatos.

Não foram identificadas alterações arquiteturais necessárias durante a integração.

#### Regressão

Foram validados os seguintes fluxos relacionados às funcionalidades anteriores:

* jogada definitiva;
* remoção de jogada definitiva;
* rejeição de alteração em casa fixa;
* preservação do estado após operações inválidas;
* funcionamento dos candidatos no Console.

Nenhuma regressão foi identificada.

#### Code Review

**Status:** ✅ Aprovado.

A implementação foi revisada considerando:

* integração entre `SudokuApplication`, `JavaFXController` e `JavaFXPrinter`;
* utilização de `JogoSudoku.executarJogada()` como ponto de entrada das jogadas;
* utilização de `TipoJogada.CANDIDATO`;
* reutilização de `Casa.alternarCandidato()`;
* ausência de regras de candidatos duplicadas na JavaFX;
* ausência de estado paralelo de candidatos;
* atualização visual a partir do estado real do domínio;
* tratamento de operações inválidas;
* manutenção da separação de responsabilidades;
* preservação das funcionalidades anteriores.

Não foram identificadas alterações necessárias para a conclusão deste TASK.

#### Observações

Durante as validações permaneceram identificados dois pontos de melhoria já conhecidos e fora do escopo deste TASK:

* pressionar `Enter` com o campo de número vazio provoca `NumberFormatException`;
* o botão de modo candidato apresenta o símbolo `✏` em vez da representação esperada `✏️` no ambiente atual.

Esses pontos permanecem candidatos a refinamento futuro da interação JavaFX e não bloqueiam a conclusão da US-022.

#### Resultado final

O fluxo completo de candidatos foi integrado, validado funcionalmente, submetido a Code Review e aprovado sem necessidade de alterações adicionais no código.

---

## 🧪 Critérios de Validação

| ID       | Validação                                                                                     | Resultado esperado                                                                                                                                      | Status |
|----------|-----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| **V-01** | Selecionar uma casa vazia e ativar o modo candidato.                                          | A casa é selecionada e o modo candidato permanece ativo para a próxima entrada.                                                                         | ✅     |
| **V-02** | Informar um número em uma casa vazia no modo candidato.                                       | O número é registrado como candidato e aparece visualmente na posição correspondente da casa.                                                           | ✅     |
| **V-03** | Adicionar múltiplos candidatos à mesma casa.                                                  | Todos os candidatos selecionados permanecem registrados e são apresentados simultaneamente.                                                             | ✅     |
| **V-04** | Informar novamente um candidato já registrado.                                                | O candidato é removido e deixa de ser apresentado visualmente.                                                                                          | ✅     |
| **V-05** | Alternar entre modo normal e modo candidato.                                                  | No modo normal, o número continua sendo tratado como jogada definitiva; no modo candidato, é tratado como candidato.                                    | ✅     |
| **V-06** | Tentar utilizar candidato sem selecionar uma casa.                                            | A operação é rejeitada, o usuário recebe feedback e o tabuleiro permanece inalterado.                                                                   | ✅     |
| **V-07** | Tentar utilizar candidato em uma casa fixa.                                                   | A operação é rejeitada, o usuário recebe feedback e o estado da casa permanece inalterado.                                                              | ✅     |
| **V-08** | Tentar utilizar candidato em uma casa contendo número definitivo.                             | A operação é rejeitada, o usuário recebe feedback e o número definitivo permanece inalterado.                                                           | ✅     |
| **V-09** | Executar uma operação inválida e, em seguida, uma operação válida.                            | A operação válida continua funcionando normalmente e o estado do tabuleiro permanece consistente.                                                       | ✅     |
| **V-10** | Executar o fluxo existente de candidatos pela interface Console após as alterações da JavaFX. | O comportamento de candidatos no Console permanece funcional e sem regressões.                                                                          | ✅     |
| **V-11** | Executar o fluxo completo JavaFX de candidatos.                                               | A intenção da interface é encaminhada por `JogoSudoku`, a regra é aplicada no domínio e a representação visual corresponde ao estado real do tabuleiro. | ✅     |

---

## 📋 Definition of Done

### 🧪 Funcional

* [x] Todos os Critérios de Aceitação da US-022 atendidos.
* [x] Todos os Critérios de Validação executados com resultado satisfatório.
* [x] Adição e remoção de candidatos funcionando pela JavaFX.
* [x] Múltiplos candidatos funcionando na mesma casa.
* [x] Modo normal e modo candidato funcionando corretamente.
* [x] Tratamento dos estados inválidos funcionando.
* [x] Fluxo existente do Console validado sem regressões.

### 🏗️ Técnico

* [x] JavaFX utiliza `JogoSudoku` como ponto de entrada para a operação.
* [x] `TipoJogada.CANDIDATO` e `Casa.alternarCandidato()` são reutilizados.
* [x] Nenhuma regra de candidatos é duplicada na JavaFX.
* [x] A JavaFX não mantém uma estrutura paralela para o estado dos candidatos.
* [x] A arquitetura existente permanece preservada.
* [x] Projeto compila corretamente com Maven.
* [x] Não foram introduzidas alterações arquiteturais desnecessárias.

### 🔍 Qualidade

* [x] Código revisado após a implementação.
* [x] Fluxos válidos e inválidos foram testados.
* [x] Não foram identificadas regressões no fluxo de jogadas definitivas.
* [x] Não foram identificadas regressões no Console.
* [x] Não existem erros ou comportamentos inconsistentes conhecidos que bloqueiem a conclusão da US-022.

### 📚 Documentação

* [x] Documento da US-022 atualizado com o resultado final da implementação.
* [x] Documento da Sprint 22 atualizado com a execução e encerramento.
* [x] Diário de Desenvolvimento atualizado.
* [x] Changelog atualizado.
* [x] Backlog atualizado.
* [x] Roadmap atualizado, caso a conclusão da US altere seu estado.
* [x] ADR atualizada somente se surgir uma decisão arquitetural que justifique alteração; caso contrário, nenhuma nova ADR será criada.

### 🌿 Git

* [x] Alterações revisadas antes do commit.
* [x] Commit seguindo Conventional Commits.
* [x] Commit realizado na branch definida pelo projeto.
* [x] Alterações enviadas para o repositório remoto.
* [x] Working tree limpa após o encerramento.
* [x] Estado final do repositório corresponde à implementação documentada.
