# US-023 — Limpar jogadas pela interface JavaFX

> **Status:** 🟢 Concluída 
> **Sprint:** Sprint 23  
> **Prioridade:** Média

---

## Objetivo

Permitir que o jogador utilize a interface JavaFX para limpar as jogadas realizadas durante a partida.

A operação deve remover os números definitivos inseridos pelo jogador, mantendo os números fixos e os candidatos existentes.

---

## Problema

A aplicação já possui a funcionalidade de limpeza de jogadas, porém ela está disponível somente através do fluxo da interface Console.

A interface JavaFX precisa disponibilizar essa mesma operação sem duplicar a regra de negócio.

---

## Comportamento esperado

Ao solicitar a limpeza:

1. o jogador inicia a operação pela interface JavaFX;
2. a aplicação solicita confirmação;
3. se a operação for cancelada, o tabuleiro permanece inalterado;
4. se confirmada, os números definitivos inseridos pelo jogador são removidos;
5. números fixos permanecem;
6. candidatos existentes permanecem;
7. a interface apresenta o estado atualizado do tabuleiro.

A operação não depende de uma célula estar selecionada.

---

## Critérios de aceitação

### AC01 — Iniciar limpeza

- [x] Deve ser possível iniciar a operação de limpeza pela interface JavaFX.

### AC02 — Solicitar confirmação

- [x] A interface deve solicitar confirmação antes de executar a limpeza.

### AC03 — Cancelar limpeza

- [x] Ao cancelar a confirmação, nenhuma alteração deve ocorrer no tabuleiro.

### AC04 — Remover jogadas do jogador

- [x] Ao confirmar, números definitivos inseridos pelo jogador devem ser removidos.

### AC05 — Preservar números fixos

- [x] Números definidos originalmente no tabuleiro devem permanecer.

### AC06 — Preservar candidatos

- [x] Candidatos existentes devem permanecer após a limpeza.

### AC07 — Atualizar interface

- [x] Após a limpeza, a representação JavaFX deve refletir o estado atual do domínio.

### AC08 — Não depender de seleção

- [x] A operação deve funcionar independentemente da célula atualmente selecionada.

### AC09 — Reutilizar regra existente

- [x] A implementação JavaFX não deve duplicar a regra de limpeza existente no domínio.

### AC10 — Preservar funcionalidades existentes

- [x] As operações de inserir, remover e trabalhar com candidatos devem continuar funcionando.

### AC11 — Preservar Console

- [x] O fluxo existente da interface Console deve continuar funcionando.

---

## Escopo

### Incluído

* Ação de limpeza na JavaFX.
* Confirmação da operação.
* Encaminhamento pela camada de aplicação.
* Reutilização de `Tabuleiro.limparJogadas()`.
* Atualização visual do tabuleiro.
* Testes e validação de regressão.

### Não incluído

* Alteração da regra de limpeza do domínio.
* Remoção de candidatos.
* Reinício completo da partida.
* Alteração de `Casa.removerNumero()`.
* Persistência.
* Finalização da partida.
* Refinamento geral da interface.
* Distribuição desktop.

---

## Decisões técnicas

### DEC-001 — Candidatos permanecem

A limpeza remove somente números definitivos inseridos pelo jogador.

Candidatos não serão removidos.

### DEC-002 — Regra permanece no domínio

A operação continuará sendo realizada por `Tabuleiro.limparJogadas()`.

A interface JavaFX apenas inicia a operação através das camadas existentes.

### DEC-003 — Confirmação antes da execução

Por se tratar de uma operação global sobre o tabuleiro, a JavaFX deverá solicitar confirmação antes de executá-la.

### DEC-004 — Sem novo ADR

A implementação segue a arquitetura já estabelecida e não introduz uma decisão arquitetural que justifique novo ADR.

---

## Dependências

* `JogoSudoku`
* `Tabuleiro.limparJogadas()`
* `JavaFXController`
* `JavaFXPrinter`
* Arquitetura definida no `ADR-011-separacao-interface-aplicacao.md`

---

## TASKs

### TASK-001 — Preparar interação de limpeza na JavaFX

Definir e implementar o ponto de entrada da operação na interface, incluindo confirmação e cancelamento.

**Status:** ✅ Concluída

**Resultado:**

* Botão `Limpar Jogadas` adicionado à interface JavaFX.
* Ação encaminhada pelo `JavaFXController`.
* Confirmação implementada no `JavaFXPrinter`.
* Cancelamento impede a execução da operação.
* Execução da limpeza permanece reservada à TASK-002.
* Interface `InterfaceUsuario` e regra de negócio não foram alteradas.
* Validação manual realizada com sucesso.
* `mvn clean compile` executado com sucesso.
* `mvn test` executado com sucesso, porém nenhum teste automatizado foi reconhecido/executado.

---

### TASK-002 — Expor a operação pela camada de aplicação

Disponibilizar a limpeza através de `JogoSudoku`, mantendo a regra no domínio.

**Status:** ✅ Concluída

**Resultado:**

* Operação `limparJogadas()` disponibilizada em `JogoSudoku`.
* `JavaFXController` passou a solicitar a operação através da camada de aplicação após a confirmação.
* Regra de limpeza permanece em `Tabuleiro`.
* Interface é atualizada após a operação.
* Validação funcional realizada com sucesso.
* `mvn clean compile` executado com sucesso.
* Identificada melhoria de UX: evitar a confirmação quando não houver jogadas definitivas para limpar.

---

### TASK-003 — Integrar a ação ao JavaFX

Conectar a ação da interface ao Controller e atualizar a apresentação após a operação.

**Status:** ✅ Concluída

**Resultado:**

* Verificação de existência de jogadas definitivas adicionada antes da confirmação.
* Mensagem informativa apresentada quando não há jogadas para limpar.
* Limpeza executada através de `JogoSudoku` após confirmação.
* Tabuleiro reapresentado após a limpeza confirmada.
* Cancelamento mantém o estado do tabuleiro sem alterações.
* `JogoSudoku.apresentarTabuleiro()` criado para centralizar a apresentação do estado atual.
* `InterfaceApresentacao.exibirInformacao()` adicionada para mensagens informativas.
* Regra de identificação de jogadas centralizada em `Casa.possuiJogada()` e `Tabuleiro.possuiJogadasParaLimpar()`.
* Testes unitários adicionados para as novas regras de domínio.
* Validação funcional realizada com sucesso nos fluxos de limpeza e regressão.
* `mvn clean compile` executado com sucesso.
* 5 testes automatizados executados com sucesso.

---

### TASK-004 — Validar comportamento e regressões

Validar os critérios de aceitação e verificar que as funcionalidades existentes continuam operacionais.

**Status:** ✅ Concluída

**Resultado:**

* Critérios de aceitação da US-023 validados com sucesso.
* Fluxos de limpeza, confirmação e cancelamento validados na interface JavaFX.
* Preservação de células fixas e candidatos validada.
* Independência da operação em relação à célula atualmente selecionada validada.
* Funcionalidades existentes de inserção, remoção e interação com o tabuleiro validadas por regressão.
* Funcionamento da interface Console preservado.
* `mvn clean test` executado com sucesso.
* 5 testes automatizados executados com sucesso, sem falhas, erros ou testes ignorados.
* Compilação limpa das classes de produção e de teste realizada com sucesso.

---

### TASK-005 — Code Review e encerramento

Executar Code Review, validar DoD, atualizar documentação, realizar commit, push e confirmar working tree limpo.

**Status:**✅ Concluída

---

## Validação

A validação realizada durante a US-023 comprovou:

* remoção das jogadas do jogador;
* preservação das casas fixas;
* preservação dos candidatos;
* cancelamento sem alteração;
* atualização da interface;
* funcionamento independente da célula atualmente selecionada;
* ausência de duplicação da regra de negócio;
* ausência de regressões na JavaFX;
* ausência de regressões no Console.

A validação automatizada foi concluída com `mvn clean test`, totalizando 5 testes executados com sucesso, sem falhas, erros ou testes ignorados.

---

## DoD

A US estará concluída quando:

1. [x] todos os critérios de aceitação forem atendidos;
2. [x] implementação estiver integrada à arquitetura existente;
3. [x] testes e validações forem realizados;
4. [x] Code Review estiver aprovado;
5. [x] documentação estiver atualizada;
6. [x] commit estiver realizado conforme Conventional Commits;
7. [x] alterações estiverem publicadas no Git;
8. [x] working tree estiver limpo.

---
