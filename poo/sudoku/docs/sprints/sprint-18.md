# 🔄 Sprint 18 — Continuar partida

## 🎯 Objetivo da Sprint

Implementar a funcionalidade de **salvar e continuar uma partida de Sudoku**, permitindo que o jogador interrompa uma partida em andamento e posteriormente retome o jogo a partir do estado salvo.

A Sprint introduziu a **persistência de dados em PostgreSQL** na aplicação Java, incluindo a modelagem relacional, integração JDBC e restauração do estado da partida.

---

## 📦 Escopo

* US-018 — Continuar partida.

---

## ✅ Critérios de Aceitação

* Salvar o estado atual da partida em banco de dados PostgreSQL.
* Preservar jogadas definitivas.
* Preservar candidatos.
* Restaurar corretamente o estado salvo.
* Permitir continuar a partida através da opção `2 - Continuar`.
* Informar quando não houver partida salva.
* Solicitar confirmação antes de sobrescrever uma partida existente.
* Manter a partida anterior quando a sobrescrita for cancelada.
* Informar o sucesso do salvamento.
* Retornar ao fluxo da partida após o salvamento.

**Resultado:** todos os critérios foram implementados e validados durante a Sprint.

---

# 📋 Planejamento da Sprint

## Sprint Review

### User Story concluída

* **US-018 — Continuar partida** ✅

A funcionalidade foi integrada à aplicação e validada por meio dos fluxos de salvamento, carregamento e sobrescrita da partida.

---

### Entregas realizadas

#### Modelagem da persistência

Foi definido o modelo relacional responsável por separar a configuração permanente do Sudoku do estado de uma partida.

A estrutura utiliza:

```text
TABULEIRO
    │
    └── CASA

PARTIDA
    │
    └── ESTADO_CASA
            │
            └── CANDIDATO
```

A modelagem e suas decisões arquiteturais estão documentadas nos respectivos artefatos da Sprint.

#### Banco de dados PostgreSQL

Foi criado e validado o schema relacional contendo:

* `tabuleiro`;
* `casa`;
* `partida`;
* `estado_casa`;
* `candidato`.

Foram utilizadas restrições de integridade, incluindo chaves primárias,
chaves estrangeiras, referências compostas, `UNIQUE`, `NOT NULL` e
`CHECK`.

#### Integração Java ↔ PostgreSQL

Foi implementada a camada de persistência utilizando JDBC, incluindo:

* criação de partidas;
* persistência do estado das casas;
* persistência dos candidatos;
* carregamento de partidas;
* restauração de jogadas;
* restauração de candidatos;
* sobrescrita do estado de uma partida.

#### Transações

A persistência de `PartidaRepository` e `TabuleiroRepository` passou a utilizar transações explícitas.

As operações críticas seguem o fluxo:

```text
BEGIN
  ↓
operações de persistência
  ↓
COMMIT
```

Em caso de falha:

```text
BEGIN
  ↓
falha
  ↓
ROLLBACK
```

Além da implementação, o comportamento de `ROLLBACK` foi validado
empiricamente por meio de falhas controladas durante a persistência.

Foi confirmado que uma operação interrompida não deixa registros
parciais no banco.

#### Fluxo de partida

O `MenuPartida` passou a concentrar diretamente as operações:

1. Fazer jogada
2. Salvar partida
3. Remover jogada
4. Limpar jogadas
5. Consultar Status
6. Voltar

A reorganização eliminou a dependência entre operações independentes
dentro do fluxo de `Fazer jogada`.

O fluxo foi validado manualmente.

#### Code Review

Foi realizada a revisão técnica da implementação da US-018.

Foram identificados e tratados os principais pontos levantados durante
a revisão:

* atomicidade de `PartidaRepository.salvar()`;
* atomicidade de `TabuleiroRepository.salvar()`;
* apresentação de erros no `service`;
* comportamento de substituição de jogadas definitivas;
* consistência entre as regras de preenchimento e remoção;
* pontos de atenção relacionados ao modelo de domínio e persistência.

Os dois pontos de atomicidade foram corrigidos com transações explícitas
e tiveram seu comportamento de `ROLLBACK` validado por testes controlados.

A decisão de não permitir substituição direta de uma jogada definitiva
foi incorporada ao comportamento do domínio.

---

## 📌 Débitos técnicos

Não permanecem pendências técnicas bloqueadoras para a conclusão da
US-018.

Foi registrada como **dívida técnica futura** a configuração de conexão
do `ConnectionFactory`, atualmente contendo URL, usuário e senha
diretamente no código.

Essa questão não foi alterada nesta Sprint por não representar um
problema da implementação da US-018 no contexto educacional atual.

---

## 📚 Aprendizados da Sprint

A Sprint proporcionou a aplicação prática de conceitos relacionados a:

* modelagem relacional;
* PostgreSQL;
* JDBC;
* `Connection`;
* `PreparedStatement`;
* `ResultSet`;
* chaves estrangeiras;
* integridade referencial;
* transações;
* `COMMIT`;
* `ROLLBACK`;
* persistência de estado;
* restauração de objetos de domínio;
* separação entre domínio e persistência;
* revisão técnica de código.

A implementação também permitiu observar, na prática, que uma operação
de negócio composta por várias operações de banco deve ser tratada como
uma unidade transacional quando sua execução parcial poderia gerar um
estado inconsistente.

---

## 🔗 Relações

### Roadmap

* Fase 6 — Evolução do Produto.
* Fase 7 — Interface Gráfica.

### Princípios

* PR-001 — Independência do domínio em relação à interface.

### ADRs relacionados

* ADR-001 — Separação entre domínio e interface.
* ADR-005 — Organização da interface de console.
* ADR-008 — Reorganização da execução das funcionalidades.
* ADR-009 — Persistência das casas do tabuleiro como registros individuais.
* ADR-010 — Garantia de integridade entre partida, tabuleiro e casa.

### User Story

* US-018 — Continuar partida ✅

### Task principal

* TASK-015 — Code Review ✅

---

## 🏁 Encerramento da Sprint

A Sprint 18 atingiu seu objetivo.

A aplicação passou a possuir uma camada de persistência funcional para
salvar, carregar e sobrescrever partidas de Sudoku utilizando PostgreSQL.

A implementação foi submetida a validações funcionais, testes de
integridade e Code Review, incluindo a comprovação do comportamento
transacional diante de falhas controladas.

A **US-018 — Continuar partida** está concluída.

---

## Status

**Concluída** ✅
