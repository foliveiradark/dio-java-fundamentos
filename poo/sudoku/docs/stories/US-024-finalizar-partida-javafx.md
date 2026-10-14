# US-024 — Finalizar partida pela interface JavaFX

## 📌 Identificação

* **Projeto:** Sudoku Java
* **Sprint:** 24
* **Status:** 🟢 Concluída
* **Prioridade:** 🟠 Média

---

## 🎯 Objetivo

Permitir que o jogador acompanhe e conclua uma partida de Sudoku utilizando a interface JavaFX, aproveitando a verificação de status já existente na aplicação.

A interface deverá contemplar tanto:

* a **verificação automática** do estado da partida após uma jogada;
* uma **ação explícita para verificar o status da partida** quando o jogador desejar.

Quando o Sudoku estiver corretamente resolvido, a interface deverá apresentar a conclusão da partida ao jogador.

---

## 🧭 Contexto

A aplicação já possui uma interface JavaFX funcional, construída progressivamente nas Sprints anteriores.

A Sprint 23 implementou a limpeza das jogadas realizadas pelo jogador pela interface JavaFX, mantendo:

* números fixos preservados;
* jogadas do jogador removíveis;
* candidatos preservados;
* atualização visual do tabuleiro;
* funcionamento da interface Console.

A US-024 dá continuidade à evolução da interface JavaFX, agora tratando a conclusão e a verificação do estado da partida.

A aplicação já possui uma regra de verificação do status da partida na camada de aplicação. A US-024 deverá integrar essa capacidade à experiência da interface JavaFX, evitando a duplicação das regras de conclusão na camada de apresentação.

---

## 📐 Decisões

### DT01 — Estratégia de verificação e finalização

A determinação do status da partida permanece sob responsabilidade de `JogoSudoku`, na camada de aplicação, utilizando as regras existentes para consultar o estado do tabuleiro.

A interface JavaFX será responsável por acionar a consulta de status nos momentos previstos pela US-024 e apresentar o resultado ao jogador, sem implementar regras próprias para determinar se o Sudoku está completo ou correto.

#### Verificação automática

Após uma jogada definitiva realizada pela JavaFX, o controlador deverá solicitar a consulta do status à camada de aplicação.

Quando o resultado for `COMPLETA_VALIDA`, a JavaFX deverá apresentar o diálogo de conclusão da partida.

Jogadas realizadas no modo candidato não deverão disparar essa consulta automática.

#### Verificação manual

A JavaFX deverá disponibilizar uma ação explícita para que o jogador possa solicitar a verificação do status da partida.

Essa ação deverá utilizar o mesmo método de consulta disponibilizado por `JogoSudoku`, aplicando a mesma regra de determinação do status utilizada no fluxo automático.

Quando o resultado for `COMPLETA_VALIDA`, a JavaFX deverá apresentar o diálogo de conclusão. Para os demais estados, deverá apresentar a mensagem correspondente ao status identificado.

#### Princípio arquitetural

- **JavaFX:** coordena a interação, aciona a consulta nos momentos previstos e apresenta o resultado.
- **JogoSudoku:** disponibiliza a consulta e centraliza a determinação do status na camada de aplicação.
- **Domínio:** fornece as informações e verificações necessárias sobre o estado do tabuleiro.

#### Justificativa

A decisão:

- aproveita o comportamento de verificação já existente;
- evita a duplicação das regras de negócio na camada de apresentação;
- mantém a separação de responsabilidades estabelecida pelo ADR-011;
- permite a conclusão automática após uma jogada definitiva;
- permite que o jogador solicite explicitamente a verificação do status;
- utiliza a mesma regra de determinação do status nos fluxos automático e manual.

---

### DT02 — Apresentação dos estados da partida

A interface JavaFX deverá utilizar o resultado de `StatusPartida` para apresentar ao jogador o estado atual da partida.

Os estados deverão ser tratados da seguinte forma:

* `INCOMPLETA` → informar que a partida ainda possui casas que precisam ser preenchidas;
* `COMPLETA_INVALIDA` → informar que o tabuleiro está preenchido, porém contém erros;
* `COMPLETA_VALIDA` → informar que o Sudoku foi corretamente resolvido e que a partida foi concluída.

A JavaFX será responsável apenas pela apresentação desses estados. A determinação do estado continuará sendo realizada pela aplicação a partir das regras existentes.

A apresentação deverá utilizar os mecanismos de comunicação já adotados pela interface JavaFX.

---

### DT03 — Comportamento da interface após `COMPLETA_VALIDA`

Ao identificar o estado `COMPLETA_VALIDA`, a interface JavaFX deverá apresentar a conclusão da partida ao jogador.

A US-024 não deverá implementar um novo ciclo de vida explícito para a partida nem introduzir uma nova máquina de estados.

Ao concluir a partida, a JavaFX deverá apresentar uma caixa de diálogo com:

* **Sair** — encerra a aplicação;
* **Nova partida** — permanece apresentada, porém desabilitada.

O fluxo de criação de uma nova partida pela JavaFX permanece fora do escopo da US-024.

As funcionalidades futuras relacionadas a **nova partida**, **salvar** e **continuar** permanecem previstas no Product Backlog.

---

## 📋 Critérios de Aceitação

**AC01 — Consulta manual**

A interface JavaFX disponibiliza uma ação para que o jogador possa consultar manualmente o status da partida.

**AC02 — Utilização da verificação existente**

A consulta manual utiliza a verificação de status existente na camada de aplicação.

**AC03 — Partida incompleta**

Quando o status for `INCOMPLETA`, a interface informa que a partida ainda possui casas vazias que precisam ser preenchidas.

**AC04 — Partida completa inválida**

Quando o status for `COMPLETA_INVALIDA`, a interface informa que o tabuleiro está preenchido, porém contém erros.

**AC05 — Partida completa válida**

Após uma jogada, a aplicação verifica automaticamente o status da partida e, quando o resultado for `COMPLETA_VALIDA`, inicia o fluxo de conclusão.

**AC06 — Diálogo de conclusão**

Quando a partida estiver `COMPLETA_VALIDA`, a interface apresenta uma caixa de diálogo informando que o Sudoku foi corretamente resolvido e concluído.

**AC07 — Opção Sair**

A caixa de diálogo de conclusão disponibiliza a opção **Sair**.

Ao selecionar **Sair**, a aplicação é encerrada.

**AC08 — Opção Nova partida**

A caixa de diálogo de conclusão apresenta a opção **Nova partida** como desabilitada.

A US-024 não implementa o fluxo de criação de uma nova partida pela JavaFX.

**AC09 — Mesma regra de verificação**

A verificação automática e a consulta manual utilizam a mesma regra de determinação do status da partida.

**AC10 — Ausência de regras duplicadas**

A interface JavaFX não implementa regras próprias para determinar se o Sudoku está completo ou correto.

**AC11 — Preservação das funcionalidades existentes**

A implementação da US-024 preserva o comportamento existente das funcionalidades de:

* realizar jogadas;
* remover jogadas;
* utilizar candidatos;
* limpar jogadas.

---

## 🛠️ TASKs

### TASK-001 — Preparar a verificação de status para uso pela JavaFX

Adequar a camada de aplicação para disponibilizar à JavaFX a consulta do `StatusPartida`, preservando a responsabilidade da verificação em `JogoSudoku`.

**Status:** 🟢 Concluída

---

### TASK-002 — Implementar a verificação manual na JavaFX

Adicionar à interface JavaFX uma ação para consulta manual do status da partida e apresentar os estados `INCOMPLETA` e `COMPLETA_INVALIDA` de acordo com DT02.

- Implementação: ✅
- Compilação: ✅
- Estado `INCOMPLETA`: ✅ validado manualmente
- Cobertura unitária dos três estados: ✅ TASK-005
- Validação integrada da apresentação dos estados: ✅ TASK-006

**Status:** 🟢 Concluída

---

### TASK-003 — Integrar a verificação automática após uma jogada

Integrar o resultado de status ao fluxo de jogada definitiva da JavaFX, iniciando o fluxo de conclusão quando a partida estiver `COMPLETA_VALIDA`.

- Implementação: ✅
- Compilação: ✅
- Jogada candidata não dispara consulta automática: ✅ validado manualmente
- Jogada definitiva dispara consulta automática: ✅ validado manualmente
- Cobertura unitária dos três estados: ✅ TASK-005
- Validação integrada do fluxo automático: ✅ TASK-006

**Status:** 🟢 Concluída

---

### TASK-004 — Implementar o diálogo de conclusão

Implementar o diálogo apresentado quando a partida estiver `COMPLETA_VALIDA`, incluindo:

- opção **Sair**;
- opção **Nova partida** desabilitada;
- encerramento da aplicação ao selecionar **Sair**.

- Implementação: ✅
- Compilação: ✅
- Diálogo de conclusão exibido: ✅ validado manualmente
- Opção **Sair**: ✅ validado manualmente
- Opção **Nova partida** desabilitada: ✅ validado manualmente
- Encerramento da aplicação ao selecionar **Sair**: ✅ validado manualmente
- Validação integrada do fluxo de conclusão: ✅ TASK-006

**Status:** 🟢 Concluída

---

### TASK-005 — Criar testes automatizados do comportamento de status

Criar testes JUnit para verificar o resultado de `consultarStatusPartida()` nos três estados previstos, utilizando o tabuleiro inicial criado por `new JogoSudoku(null, null)` e preenchendo as casas vazias nos cenários de tabuleiro completo.

- `INCOMPLETA`: ✅ teste implementado e executado
- `COMPLETA_VALIDA`: ✅ teste implementado e executado
- `COMPLETA_INVALIDA`: ✅ teste implementado e executado
- Execução da suíte: ✅ `BUILD SUCCESS`

**Status:** 🟢 Concluída

---

### TASK-006 — Validar integração e regressões

Validar a US-024 de forma integrada, verificando:

- fluxos automático e manual;
- apresentação dos estados da partida;
- diálogo de conclusão;
- opção **Sair**;
- opção **Nova partida** desabilitada;
- funcionalidades JavaFX existentes;
- interface Console;
- testes automatizados aplicáveis;
- ausência de regressões.

**Status:** ✅ Concluída

**Evidências de validação**

- **Compilação Maven:** `BUILD SUCCESS` após o ajuste final no `JavaFXController`.
- **Suíte automatizada:** 8 testes executados, sem falhas ou erros.
- **Consulta manual de status:** estados `INCOMPLETA` e `COMPLETA_INVALIDA` validados.
- **Conclusão automática:** partida `COMPLETA_VALIDA` reconhecida após a jogada definitiva, com abertura automática do diálogo de conclusão.
- **Diálogo de conclusão:** mensagem apresentada corretamente; opção **Sair** ativa e opção **Nova partida** desabilitada.
- **Encerramento da aplicação:** opção **Sair** validada.
- **Funcionalidades JavaFX existentes:** candidatos, jogadas definitivas, remoção e limpeza de jogadas validados nos cenários executados.
- **Interface Console:** inicialização e encerramento validados, com `BUILD SUCCESS`.
- **Regressões:** não foram identificadas nos cenários executados.

**Observação sobre a validação dos estados:** a consulta manual de `COMPLETA_VALIDA` não foi testada isoladamente, pois o fluxo normal conclui a partida automaticamente. O método foi revisado para encaminhar esse estado diretamente ao diálogo de conclusão, sem exibir previamente a mensagem informativa genérica.

**Correção identificada durante a revisão técnica**

Durante a revisão do fluxo de execução de jogadas, foi identificado que o controlador poderia consultar automaticamente o status da partida mesmo quando uma jogada definitiva fosse rejeitada por uma `IllegalArgumentException` tratada por `JogoSudoku.executarJogada()`.

**Ajuste implementado**

- O método `JogoSudoku.executarJogada()` passou a retornar `boolean`, indicando o resultado da operação: `true` quando executada com sucesso e `false` quando a exceção prevista é tratada.
- O `JavaFXController` passou a consultar automaticamente o status somente quando a jogada foi executada com sucesso e seu tipo é `DEFINITIVA`.
- O fluxo de consulta manual do status foi mantido independente desse retorno.

**Validação após o ajuste**

- **Testes automatizados:** 8 testes executados, sem falhas ou erros; `BUILD SUCCESS`.
- **Validação manual:** comportamento conferido após o ajuste, sem problemas identificados nos cenários executados.
- **Revisão do diff:** `git diff --check` executado sem apontamentos.

A correção não altera o escopo da US-024 nem a decisão arquitetural de utilização do JavaFX. Ela reforça a condição para disparar a verificação automática de conclusão após uma jogada definitiva.

---

## 🔍 Code Review

**Status:** ✅ Realizado

**Escopo da revisão**

Foram revisados os componentes envolvidos na consulta do status da partida e na conclusão pela interface JavaFX, considerando a separação de responsabilidades, o reaproveitamento das regras existentes e a cobertura dos testes automatizados.

### Arquivos revisados

**`service/JogoSudoku.java`**

- A determinação do status permanece centralizada na camada de aplicação.
- O método público `consultarStatusPartida()` disponibiliza a consulta para a interface.
- A classificação considera a existência de casas vazias, os erros nas linhas, colunas e blocos e, por fim, o estado completo e válido.
- A implementação aproveita as verificações existentes no tabuleiro, sem duplicar regras na apresentação.

**Resultado:** ✅ A responsabilidade de determinar o status está concentrada na camada de aplicação.

**`ui/javafx/JavaFXController.java`**

- A verificação manual consulta `JogoSudoku.consultarStatusPartida()`.
- Após uma jogada definitiva executada com sucesso, o controlador consulta o status e inicia o fluxo de conclusão quando recebe `COMPLETA_VALIDA`.
- Quando uma jogada é rejeitada e `JogoSudoku.executarJogada()` retorna `false`, a consulta automática não é realizada.
- Jogadas realizadas no modo candidato não disparam a consulta automática.
- O estado `COMPLETA_VALIDA` encaminha o fluxo ao diálogo de conclusão; os demais estados são apresentados por meio do mecanismo de comunicação da interface.

**Resultado:** ✅ Os fluxos manual e automático reutilizam a mesma consulta de status, sem implementar regras próprias de validação do Sudoku na JavaFX.

**`ui/javafx/SudokuApplication.java`**

- O botão **Status** está conectado ao método `controller.verificarStatusPartida()`.
- O controller recebe as dependências necessárias para consultar a aplicação e apresentar os resultados.
- A ligação entre o botão e o fluxo de consulta está adequada.

**Resultado:** ✅ Não foram identificadas alterações necessárias nesse arquivo para atender à US-024.

**`service/JogoSudokuTest.java`**

- Há testes para o estado `INCOMPLETA`.
- Há teste para o estado `COMPLETA_VALIDA`.
- Há teste para o estado `COMPLETA_INVALIDA`.
- Os testes utilizam o tabuleiro criado por `new JogoSudoku(null, null)`, mantendo a abordagem compatível com o desenho atual da aplicação.

**Resultado:** ✅ Os três estados previstos possuem cobertura unitária, e a suíte executada apresentou `BUILD SUCCESS`.

### Decisão de arquitetura e documentação

A decisão DT01 foi ajustada para refletir a implementação existente: a camada JavaFX coordena os momentos em que a consulta é acionada, enquanto `JogoSudoku` centraliza a determinação do status.

Essa adequação documental preserva a separação de responsabilidades e evita uma refatoração sem justificativa técnica concreta.

### Resultado geral

**Conclusão:** ✅ Code Review realizado, sem alterações adicionais necessárias nos arquivos analisados para o escopo revisado da US-024.

Durante a revisão, foi corrigido o fluxo de consulta automática após jogadas rejeitadas. O ajuste foi validado com a suíte automatizada, composta por 8 testes sem falhas ou erros, e por verificação manual dos cenários executados.

A revisão considerou o código apresentado, os resultados de compilação e testes e as evidências de validação manual registradas na TASK-006. Não representa uma auditoria independente de todo o repositório.

A revisão não substitui a validação integrada nem o fechamento Git. Commit, push e confirmação do estado limpo do working tree permanecem no processo de consolidação e fechamento da Sprint.

---

## 🧪 Validação

A US-024 foi validada por meio de testes automatizados, verificações manuais da interface JavaFX e testes de regressão dos fluxos existentes.

- **Testes automatizados:** 8 testes executados, sem falhas ou erros.
- **Verificação de status:** estados `INCOMPLETA`, `COMPLETA_VALIDA` e `COMPLETA_INVALIDA` cobertos por testes unitários.
- **Interface JavaFX:** consulta manual, verificação automática após jogada definitiva e diálogo de conclusão validados nos cenários executados.
- **Encerramento:** opção `Sair` validada; opção `Nova partida` permanece desabilitada.
- **Regressão:** funcionalidades existentes e interface Console verificadas nos cenários registrados na TASK-006.

**Limitação registrada:** a consulta manual do estado `COMPLETA_VALIDA` não foi testada isoladamente. O encaminhamento desse estado ao diálogo de conclusão foi revisado no código.

As evidências detalhadas estão registradas na TASK-006.

---

## 📐 Definition of Done

- [x] Implementação das TASKs concluída.
- [x] Critérios de aceitação validados conforme as evidências registradas.
- [x] Testes automatizados aplicáveis criados ou atualizados e executados.
- [x] Regressões verificadas nos cenários executados.
- [x] Interface JavaFX validada.
- [x] Interface Console preservada.
- [x] Code Review realizado e registrado.
- [x] Documentação atualizada para refletir as decisões e evidências da implementação.

> Commit, push e estado limpo do working tree serão tratados no processo de consolidação e fechamento Git, não como condição lógica da conclusão técnica da US.
