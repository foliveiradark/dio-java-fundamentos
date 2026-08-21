# US-017 — Sistema de rascunhos

---

## Informações Gerais

> **ID:** US-017  
> **Sprint:** Sprint 17  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída.

---

## 🎯 Objetivo

Permitir que o jogador registre números candidatos nas casas editáveis do Sudoku durante a resolução da partida.

Os candidatos deverão representar possibilidades de preenchimento sem alterar o número definitivo da casa.

A funcionalidade deverá ser integrada ao domínio existente sem criar dependência entre a lógica do Sudoku e a sintaxe específica da interface de console.

---

## 📋 Contexto

A funcionalidade de rascunhos é um requisito opcional apresentado no exercício de Sudoku da DIO.

Durante a análise do requisito, foi definido que uma casa poderá possuir múltiplos números candidatos simultaneamente.

A funcionalidade será implementada considerando a arquitetura existente e o princípio de independência entre domínio e interface, permitindo que a mesma operação possa ser utilizada futuramente por uma interface gráfica.

---

## ✅ Critérios de Aceitação

- Permitir múltiplos candidatos em uma mesma casa editável.
- Permitir adicionar um candidato quando ele ainda não existir.
- Permitir remover um candidato quando ele já existir.
- Informar ao jogador o resultado da operação.
- Impedir a utilização de candidatos em casas fixas.
- Representar os candidatos utilizando `Set<Integer>`.
- Remover automaticamente todos os candidatos quando um número definitivo for atribuído à casa.
- Não recuperar candidatos anteriores quando o número definitivo for removido.
- Manter a sintaxe utilizada para rascunhos como responsabilidade da interface.
- Não permitir que o domínio dependa da sintaxe específica do console.
- Permitir que uma futura interface gráfica utilize as mesmas operações do domínio.
- Preservar as regras existentes de validação e funcionamento do Sudoku.

---

# 🔧 Tarefas Técnicas

## TASK-001

Implementar a representação dos candidatos na entidade `Casa`.

Os candidatos deverão ser armazenados utilizando `Set<Integer>`.

A coleção deverá permanecer encapsulada na entidade, evitando que outras camadas manipulem diretamente sua estrutura interna.

**Status:** ✅ Concluída.

---

## TASK-002

Implementar a operação de domínio responsável por adicionar ou remover um candidato.

A operação deverá funcionar como toggle:

- candidato inexistente → adicionar;
- candidato existente → remover.

A operação deverá:

- validar o número utilizando a regra existente da entidade;
- impedir alterações em casas fixas;
- alterar somente o conjunto de candidatos;
- informar ao fluxo da aplicação se o candidato foi adicionado ou removido.

**Status:** ✅ Concluída.

---

## TASK-003

Implementar as regras de consistência entre candidatos e número definitivo.

Ao atribuir um número definitivo a uma casa editável:

- todos os candidatos existentes deverão ser removidos;
- a casa deverá permanecer sem candidatos enquanto possuir um número definitivo.

Ao remover posteriormente o número definitivo:

- nenhum candidato anterior deverá ser restaurado.

A entidade `Casa` deverá ser responsável por garantir essa consistência.

**Status:** ✅ Concluída.

---

## TASK-004

Garantir que casas fixas não possam receber candidatos.

Casas fixas já possuem a regra de não alteração utilizada pelas operações de preenchimento e remoção.

A mesma regra deverá ser aplicada à operação de candidatos.

A validação deverá permanecer no domínio, evitando duplicação da regra nas camadas superiores.

**Status:** ✅ Concluída.

---

## TASK-005

Implementar a interpretação da sintaxe de rascunho na interface de console.

A interface deverá reconhecer:

- `5` → jogada definitiva;
- `*5` → operação de candidato.

A interpretação do prefixo `*` deverá permanecer restrita à camada de interface.

O domínio deverá receber a intenção da operação e o valor numérico, sem conhecimento da sintaxe utilizada pelo console.

**Status:** ✅ Concluída.

---

## TASK-006

Implementar o feedback apresentado ao jogador após uma operação de candidato.

O fluxo deverá permitir que o jogador compreenda claramente a operação realizada.

Deverão existir mensagens distintas para:

- candidato adicionado;
- candidato removido;
- tentativa de operação em casa fixa;
- entrada inválida.

A responsabilidade pelas mensagens permanecerá na camada de interface.

**Status:** ✅ Concluída.

---

## TASK-007

Implementar a apresentação dos candidatos na interface de console.

A `Casa` continua responsável pelo conjunto de candidatos, mas disponibiliza uma consulta sem permitir que outra camada altere diretamente esse conjunto.

Os candidatos deverão ser apresentados dentro da própria célula do tabuleiro, permitindo visualizar múltiplos candidatos simultaneamente sem comprometer a legibilidade da interface.

A forma de renderização deverá permanecer como responsabilidade da interface de console.

A representação visual não deverá alterar a representação utilizada pelo domínio.

**Status:** ✅ Concluída.

### Implementação

Foi criada na classe `ConsolePrinter` a representação visual da `Casa` utilizando uma grade interna 3×3.

Cada posição da grade corresponde a um possível candidato:

```text
1 2 3
4 5 6
7 8 9
```

Quando a casa está vazia, somente os candidatos existentes são apresentados em suas respectivas posições.

Quando a casa possui um número definitivo, o número é apresentado centralizado na célula.

A construção da representação foi encapsulada no método:

```java
construirLinhasCasa(Casa casa)
```

A implementação mantém a responsabilidade de apresentação exclusivamente na camada `ui`.

---

## TASK-008

Integrar a operação de rascunho ao fluxo atual da partida.

A integração deverá preservar as responsabilidades existentes entre:

- `JogoSudoku`;
- `Casa`;
- `Tabuleiro`;
- `ConsoleInput`;
- `ConsolePrinter`.

O `JogoSudoku` deverá coordenar o fluxo da operação, enquanto:

- `ConsoleInput` interpreta a entrada;
- `Casa` executa a operação de domínio;
- `ConsolePrinter` apresenta o resultado ao jogador.

**Status:** ✅ Concluída.

---

## TASK-009

Validar a funcionalidade de rascunhos em diferentes situações da partida.

**Critérios mínimos:**

- adicionar um candidato;
- adicionar múltiplos candidatos;
- remover um candidato;
- informar novamente um candidato já existente;
- tentar adicionar candidato em casa fixa;
- definir número definitivo em casa com candidatos;
- verificar remoção automática dos candidatos;
- remover posteriormente o número definitivo;
- verificar que candidatos anteriores não são restaurados;
- visualizar o estado atualizado da casa;
- preservar o funcionamento das regras existentes do Sudoku.

**Status:** ✅ Concluída.

---

## TASK-010

Validar a Definition of Done da US-017.

**Status:** ✅ Concluída.

---

# 📌 Decisões Consolidadas

As decisões abaixo foram discutidas durante a análise da US-017 e estão consideradas encerradas para esta implementação.

### Operação de candidato

A operação de candidato será realizada por meio de um **toggle**.

Se o candidato não existir, será adicionado.

Se o candidato já existir, será removido.

---

### Representação no domínio

Os candidatos serão representados na entidade `Casa` utilizando:

`Set<Integer>`

A coleção permanecerá encapsulada na entidade.

---

### Casas fixas

Casas fixas não poderão possuir candidatos.

A regra será garantida pela própria entidade `Casa`, utilizando o estado `fixa` já existente.

---

### Número definitivo

Ao atribuir um número definitivo a uma casa editável, todos os candidatos existentes deverão ser removidos automaticamente.

A remoção posterior do número definitivo não deverá restaurar candidatos anteriores.

---

### Sintaxe da interface

A interface de console utilizará:

```text
5
```

para representar uma jogada definitiva e:

```text
*5
```

para representar uma operação de candidato.

Essa sintaxe pertence exclusivamente à interface.

O domínio não deverá conhecer o prefixo `*`.

---

### Feedback ao jogador

A interface deverá informar explicitamente o resultado da operação.

Exemplos:

```text
Candidato 5 adicionado.
```

```text
Candidato 5 removido.
```

A geração dessas mensagens pertence à interface.

---

### Apresentação dos candidatos

Os candidatos serão apresentados visualmente dentro da própria célula do tabuleiro utilizando uma grade interna 3×3.

A correspondência visual adotada é:

```text
1 2 3
4 5 6
7 8 9
```

O número definitivo é apresentado centralizado.

A forma específica de renderização pertence à interface de console.

A representação visual não deverá determinar a estrutura do domínio.

---

## 🧪 Validações realizadas

As regras do domínio, a interpretação da entrada de rascunhos, o feedback ao jogador e a apresentação visual foram implementados e validados de forma controlada utilizando o IntelliJ IDEA e a execução da partida pelo console.

### TASK-001

Foi validada a criação e manutenção do conjunto de candidatos na entidade `Casa`.

**Resultado:** ✅ Validado.

---

### TASK-002

Foram validados:

- adição de candidato;
- remoção do candidato por toggle;
- rejeição de número fora do intervalo permitido;
- rejeição de candidato em casa fixa.

**Resultado:** ✅ Validado.

---

### TASK-003

Foram validados:

- remoção automática dos candidatos ao definir um número definitivo;
- não restauração dos candidatos após remoção do número definitivo;
- preservação dos candidatos quando uma tentativa de preenchimento inválida ocorre.

**Resultado:** ✅ Validado.

---

### TASK-004

Foi validado que uma casa fixa não permite a inclusão ou remoção de candidatos.

A regra permanece protegida pela entidade `Casa`, evitando que a camada de aplicação ou interface precise duplicar essa validação.

**Resultado:** ✅ Validado.

---

### TASK-005

Foi validada a interpretação das entradas de jogada na interface de console.

Entradas testadas:

| Entrada | Número | Tipo |
|---|---:|---|
| `5` | 5 | `DEFINITIVA` |
| `*5` | 5 | `CANDIDATO` |
| `*9` | 9 | `CANDIDATO` |

Também foram validadas entradas inválidas:

- `*10`;
- `10`.

Essas entradas foram rejeitadas pela interface, mantendo a sintaxe `*` fora do domínio.

Foi também validado o fluxo completo no console:

- entrada de jogada definitiva;
- entrada de candidato;
- tentativa de candidato em casa fixa;
- rejeição de entrada inválida;
- retorno à leitura de uma nova jogada.

**Resultado:** ✅ Validado.

---

### TASK-006

Foi validado o feedback apresentado ao jogador após uma operação de candidato.

Foi realizado um teste manual utilizando a mesma casa para verificar o comportamento de toggle:

```text
A5
N
*9
```

Resultado:

`Candidato 9 adicionado.`

Em seguida, a mesma operação foi realizada novamente:

```text
A5
N
*9
```

Resultado:

`Candidato 9 removido.`

O teste confirmou que:

- o resultado `true` retornado por `alternarCandidato()` é interpretado como candidato adicionado;
- o resultado `false` é interpretado como candidato removido;
- a operação de toggle é executada uma única vez;
- o número do candidato é apresentado corretamente na mensagem;
- a apresentação das mensagens permanece sob responsabilidade do `ConsolePrinter`.

**Resultado:** ✅ Validado.

---

### TASK-007

Foi realizada validação manual da representação de:

- casa vazia;
- casa com número definitivo;
- casa com múltiplos candidatos;
- adição e remoção de candidatos durante uma partida real.

Também foi validada a preservação da estrutura visual do tabuleiro, incluindo:

- cabeçalho das colunas;
- identificadores das linhas;
- bordas;
- separadores dos blocos 3×3;
- alinhamento das células.

**Resultado:** ✅ Validado.

---

### TASK-008

Foi realizado teste integrado utilizando uma partida real pelo console.

O fluxo validado foi:

```text
Coordenada
    ↓
ConsoleInput
    ↓
TipoJogada
    ↓
JogoSudoku
    ↓
Casa
    ↓
ConsolePrinter
```

Foi validada a inclusão de candidatos em uma casa editável e a atualização imediata da representação visual do tabuleiro.

Também foi validada a integração entre a alteração do estado da `Casa` e sua posterior renderização pelo `ConsolePrinter`.

**Resultado:** ✅ Validado.

---

### TASK-009

Foram realizados testes manuais durante a execução da partida.

#### Múltiplos candidatos

Foi utilizada a mesma casa para adicionar diferentes candidatos:

```text
*2
*7
*9
```

A representação visual confirmou os candidatos nas posições correspondentes da grade 3×3.

**Resultado:** ✅ Validado.

#### Remoção de candidato

Um candidato existente foi informado novamente.

Exemplo:

```text
*5
```

Resultado:

```text
Candidato 5 removido.
```

A representação visual confirmou a remoção somente daquele candidato.

**Resultado:** ✅ Validado.

#### Número definitivo

Uma casa contendo candidatos recebeu um número definitivo.

Exemplo:

```text
8
```

Os candidatos desapareceram automaticamente e o número definitivo passou a ser apresentado centralizado na casa.

**Resultado:** ✅ Validado.

#### Tentativa de candidato em casa preenchida

Após o preenchimento definitivo da casa, foi realizada nova tentativa de inclusão de candidato.

Exemplo:

```text
*2
```

Resultado:

```text
Não é possível adicionar candidatos a uma casa preenchida.
```

A operação não alterou o estado da casa.

**Resultado:** ✅ Validado.

#### Integração com o fluxo da partida

Após cada operação, o tabuleiro foi renderizado novamente e apresentou o estado atualizado da casa.

O fluxo de limpeza das jogadas e consulta do status da partida continuou funcionando normalmente.

**Resultado:** ✅ Validado.

---

### TASK-010

Foi realizada a validação da Definition of Done da US-017.

Foram confirmados:

- implementação das funcionalidades previstas;
- integração entre domínio, serviço e interface;
- preservação das regras existentes;
- validação manual dos principais cenários;
- apresentação dos candidatos na interface;
- encapsulamento da representação dos candidatos;
- independência do domínio em relação à sintaxe do console;
- funcionamento integrado da partida.

A funcionalidade foi validada por meio da execução da aplicação e dos cenários definidos na TASK-009.

**Resultado:** ✅ Validado.

---

# 🔗 Dependências

- US-001 — Visualizar o tabuleiro.
- US-004 — Inserir um número.
- US-007 — Remover um número.
- US-015 — Melhorar a experiência visual do tabuleiro.
- PR-001 — Independência do domínio em relação à interface.

---

# 📚 Documentação Relacionada

### Princípios

- PR-001 — Independência do domínio em relação à interface.

### ADRs

- ADR-001 — Separação entre domínio e interface.
- ADR-005 — Organização da interface de console.
- ADR-008 — Reorganização da execução das funcionalidades.

### Roadmap

- Fase 6 — Evolução do Produto.
- Fase 7 — Interface Gráfica.

---

# 📊 Status

✅ Concluída.

As decisões arquiteturais e funcionais necessárias para a implementação da US-017 foram consolidadas.

As TASKs 001 a 010 foram implementadas, validadas e revisadas.

Neste momento, a funcionalidade possui:

- representação de candidatos no domínio;
- operação de toggle;
- regras de consistência entre candidato e número definitivo;
- proteção de casas fixas;
- interpretação da sintaxe `*1` até `*9` na interface;
- representação da intenção da jogada por meio de `TipoJogada`;
- encapsulamento da sintaxe específica do console;
- feedback ao jogador para adição e remoção de candidatos;
- apresentação visual dos candidatos em uma grade 3×3;
- integração da funcionalidade ao fluxo da partida;
- validação funcional dos principais cenários da US-017.

