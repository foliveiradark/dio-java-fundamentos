# US-018 — Continuar partida

---

## Informações Gerais

> **ID:** US-018  
> **Sprint:** Sprint 18  
> **Prioridade:** 🟢 Baixa  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo

Permitir que o jogador salve uma partida em andamento e posteriormente
continue a partida a partir do estado salvo, preservando seu progresso.

A partida salva deverá preservar tanto as jogadas definitivas quanto os
rascunhos realizados pelo jogador.

A funcionalidade utiliza persistência em banco de dados PostgreSQL.

A estrutura de dados utilizada pela persistência está documentada em
`02-modelagem.md`.

---

# 📋 Contexto

Atualmente, o estado da partida existe em memória durante a execução da
aplicação.

A US-018 introduz persistência para permitir que o estado da partida seja
armazenado e posteriormente reconstruído.

A modelagem separa a configuração permanente do Sudoku do progresso
produzido durante uma partida.

A definição estrutural dessa persistência está registrada em
`02-modelagem.md`.

---

# 🎯 Escopo

A US-018 contempla:

* salvar explicitamente uma partida em andamento;
* persistir as jogadas definitivas realizadas pelo jogador;
* persistir os rascunhos/candidatos realizados pelo jogador;
* carregar uma partida previamente salva;
* continuar a partida a partir do estado carregado;
* permitir apenas uma partida salva/ativa por vez;
* solicitar confirmação antes de sobrescrever uma partida existente;
* informar o jogador sobre o resultado das operações;
* retornar ao fluxo anterior após o salvamento;
* utilizar PostgreSQL como mecanismo de persistência.

---

# 🚫 Fora do Escopo

Não fazem parte desta User Story:

* histórico de partidas;
* múltiplas partidas salvas simultaneamente;
* cadastro de jogadores;
* autenticação;
* contas de usuário;
* sincronização entre dispositivos;
* seleção de partidas salvas;
* níveis de dificuldade;
* geração automática de Sudoku;
* interface gráfica Swing;
* estatísticas da partida;
* salvamento automático a cada jogada.

Essas funcionalidades poderão ser avaliadas em futuras User Stories.

---

# 🧠 Regra de domínio — alteração de jogada definitiva

Durante a validação da US-018 foi identificado e posteriormente definido
o comportamento para uma casa editável que já possui uma jogada definitiva.

Uma jogada definitiva existente não pode ser substituída diretamente.

Para realizar uma nova jogada na mesma casa, o jogador deve primeiro
remover a jogada existente utilizando a funcionalidade explícita:

```text
3 - Remover jogada
```

A regra definida é:

```text
Casa vazia
   │
   ├── inserir definitiva → permitido
   │
   └── inserir candidato  → permitido
```

e:

```text
Casa com definitiva
   │
   ├── inserir definitiva → rejeitado
   │
   └── inserir candidato  → rejeitado
```

Para realizar uma nova jogada:

```text
Casa com definitiva
        ↓
Remover jogada
        ↓
Casa vazia
        ↓
Nova jogada
```

A regra pertence ao domínio e é implementada por meio de
`Casa.preencher()`.

A regra correspondente para candidatos é implementada por
`Casa.alternarCandidato()`.

Dessa forma:

```text
preencher()
    ↓
casa preenchida
    ↓
nova definitiva rejeitada
```

e:

```text
alternarCandidato()
    ↓
casa preenchida
    ↓
candidato rejeitado
```

A mensagem atualmente apresentada para tentativa de substituição é:

```text
Não é possível substituir uma jogada existente. Remova a jogada primeiro.
```

---

# 💾 Persistência

A US-018 utiliza o modelo de persistência definido em
`02-modelagem.md`.

A persistência diferencia:

```text
configuração permanente
        ↓
TABULEIRO → CASA
```

de:

```text
progresso da partida
        ↓
PARTIDA → ESTADO_CASA → CANDIDATO
```

A estrutura física, os relacionamentos, as chaves, as constraints e as
responsabilidades dos componentes de persistência estão documentados em
`02-modelagem.md`.

---

# 🗄️ Banco de Dados

A tecnologia de persistência utilizada é:

**PostgreSQL**

O PostgreSQL é executado em ambiente Docker durante o desenvolvimento.

O banco utilizado pela aplicação é:

```text
sudoku
```

O schema está registrado em:

```text
database/schema.sql
```

A implementação utiliza JDBC para comunicação entre Java e PostgreSQL.

---

# 🔌 Integração Java com PostgreSQL

A aplicação utiliza uma camada específica de persistência:

```text
persistence
├── ConnectionFactory
├── TabuleiroRepository
└── PartidaRepository
```

A responsabilidade estrutural desses componentes está definida em
`02-modelagem.md`.

A US-018 utiliza essa camada para realizar as operações necessárias à
funcionalidade:

* salvar;
* carregar;
* sobrescrever uma partida existente.

---

# 🖥️ Interface

A interface atual permanece sendo o console.

O Menu Principal apresenta:

```text
1 - Novo jogo
2 - Continuar
0 - Sair
```

O Menu da Partida apresenta:

```text
1 - Fazer jogada
2 - Salvar partida
3 - Remover jogada
4 - Limpar jogadas
5 - Consultar Status
0 - Voltar
```

O salvamento e o carregamento estão integrados ao fluxo da aplicação.

O controle de estado do salvamento utiliza:

```text
partidaSalva
```

Esse controle permite distinguir uma partida ainda não salva de uma
partida que já possui um estado persistido.

A sintaxe específica do console permanece restrita à camada de
interface.

---

# 🔄 Fluxo de salvamento

O fluxo implementado é:

```text
Partida em andamento
        ↓
2 - Salvar partida
        ↓
Verificar partidaSalva
        │
        ├── false
        │     ↓
        │   salvar diretamente
        │
        └── true
              ↓
        solicitar confirmação
              ↓
          ┌───┴───┐
          │       │
          S       N
          │       │
          ↓       ↓
     sobrescrever  cancelar
          │
          ↓
      PostgreSQL
```

Quando a partida ainda não foi salva:

```text
partidaSalva = false
```

o estado atual é persistido diretamente.

Quando a partida já possui um salvamento:

```text
partidaSalva = true
```

o sistema solicita confirmação antes de substituir o estado persistido.

Após o salvamento, o sistema informa:

```text
Partida salva com sucesso.
```

e retorna ao menu da partida.

O cancelamento retorna ao menu sem executar a operação de sobrescrita.

---

# 🔄 Fluxo de continuar

A opção `2 - Continuar` utiliza o `PartidaRepository` para localizar e
carregar uma partida salva.

O fluxo é:

```text
Menu Principal
      ↓
2 - Continuar
      ↓
buscar última partida
      ↓
carregar estado persistido
      ↓
reconstruir Tabuleiro
      ↓
exibir tabuleiro
      ↓
Menu da partida
```

Quando não existe partida salva, o sistema informa a ausência de dados e
retorna ao Menu Principal.

---

# 🧪 Validações realizadas

## Partida sem dados salvos

Foi validado o cenário:

```text
Banco sem partida salva
        ↓
2 - Continuar
        ↓
Sistema identifica ausência
        ↓
Mensagem apresentada
        ↓
Retorno ao Menu Principal
```

**Resultado:** ✅ Validado

---

## Persistência de partida e candidatos

Foi validado o ciclo:

```text
Banco inicialmente limpo
        ↓
Nova partida criada
        ↓
A9 = 7
        ↓
A7 = candidato 8
        ↓
A7 = candidato 9
        ↓
Salvar partida
        ↓
Encerrar aplicação
        ↓
Executar novamente
        ↓
2 - Continuar
        ↓
Estado restaurado
```

Foram recuperados:

```text
A9 = 7
A7 → candidatos 8 e 9
```

**Resultado:** ✅ Validado

---

## Cancelamento da sobrescrita

Foi validado o comportamento:

```text
Partida salva
      ↓
Alteração realizada
      ↓
Salvar partida
      ↓
Confirmação solicitada
      ↓
N
      ↓
Operação cancelada
```

O estado anteriormente salvo permaneceu preservado.

Alterações realizadas posteriormente ao último salvamento não fazem
parte do estado restaurado quando a aplicação é encerrada sem novo
salvamento.

**Resultado:** ✅ Validado

---

## Regra de alteração de jogada definitiva

A regra de alteração de jogadas definitivas foi implementada no domínio
e validada por meio do `CasaTestManual`.

Foi validado:

```text
Casa vazia
      ↓
preencher(7)
      ↓
número 7 inserido
```

Uma nova tentativa de preenchimento foi rejeitada.

Após a remoção da jogada, uma nova inserção foi permitida.

Também foi validado:

```text
casa preenchida
      ↓
alternarCandidato()
      ↓
operação rejeitada
```

E:

```text
candidatos
   ↓
preencher()
   ↓
candidatos removidos
```

**Resultado geral:** ✅ Validado

---

# ✅ Critérios de Aceitação

* [x] Salvar o estado atual da partida em andamento no banco de dados
  PostgreSQL.
* [x] Preservar as jogadas definitivas realizadas pelo jogador ao salvar
  a partida.
* [x] Preservar os candidatos das casas ao salvar a partida.
* [x] Disponibilizar os candidatos nas respectivas casas durante o
  carregamento da partida.
* [x] Carregar uma partida salva por meio da opção `2 - Continuar`.
* [x] Informar que não há jogo salvo e voltar ao Menu Principal se o
  jogador selecionar `2 - Continuar` sem dados salvos.
* [x] Solicitar confirmação antes de substituir uma partida salva
  existente.
* [x] Manter a partida anteriormente salva quando o jogador cancela a
  sobrescrita.
* [x] Exibir uma mensagem de sucesso após salvar o jogo.
* [x] Retornar ao fluxo da partida após o salvamento.
* [x] Sobrescrever o estado de uma partida existente sem criar uma nova
  `PARTIDA`.
* [x] Persistir a atualização de uma partida existente por meio do
  `PartidaRepository`.
* [x] Integrar a operação de sobrescrita ao fluxo de `JogoSudoku`.
* [x] Não solicitar confirmação ao salvar uma nova partida.
* [x] Solicitar confirmação em salvamentos posteriores.
* [x] Cancelar a operação quando o jogador responder `N`.
* [x] Preservar o último snapshot salvo após o cancelamento.

---

# 🧩 TASKs

## TASK-001 — Especificar o estado persistível da partida

Identificar quais informações precisam ser armazenadas para reconstruir
uma partida.

A definição do estado persistível foi registrada em
`02-modelagem.md`.

**Status:** ✅ Concluída

---

## TASK-002 — Modelar a persistência

Definir como o estado da partida será representado em um banco
relacional.

Foram definidos e documentados:

* modelo conceitual;
* modelo lógico;
* modelo relacional;
* relacionamentos;
* PKs;
* FKs;
* regras de unicidade;
* regras de integridade.

O modelo foi registrado em `02-modelagem.md`.

**Status:** ✅ Concluída

---

## TASK-003 — Definir arquitetura de persistência

Definir como o código Java se comunicará com o PostgreSQL preservando a
separação de responsabilidades.

Foi definida e implementada a estrutura:

```text
persistence
├── ConnectionFactory
├── TabuleiroRepository
└── PartidaRepository
```

**Status:** ✅ Concluída

---

## TASK-004 — Preparar ambiente PostgreSQL

Configurar o PostgreSQL e criar o banco de desenvolvimento.

O PostgreSQL foi configurado em ambiente Docker e o banco `sudoku` foi
disponibilizado.

O schema foi aplicado por meio de:

```text
database/schema.sql
```

**Status:** ✅ Concluída

---

## TASK-005 — Aprender SQL necessário

Praticar os comandos SQL necessários para a implementação da User Story.

Foram praticados diretamente no PostgreSQL:

* criação de tabelas;
* inserção de registros;
* consultas;
* inspeção de tabelas;
* inspeção de constraints;
* transações;
* `SAVEPOINT`;
* `ROLLBACK`;
* `CHECK`;
* `UNIQUE`;
* `FOREIGN KEY`.

**Status:** ✅ Concluída

---

## TASK-006 — Integrar Java ao PostgreSQL

Estabelecer a comunicação entre Java e PostgreSQL utilizando JDBC.

Foram concluídos e validados:

* inclusão do driver PostgreSQL;
* carregamento do driver;
* criação do `ConnectionFactory`;
* obtenção de conexão JDBC;
* conexão com o banco `sudoku`;
* utilização de `PreparedStatement`;
* utilização da conexão pelos repositories.

**Status:** ✅ Concluída

---

## TASK-007 — Implementar persistência da configuração do tabuleiro

Persistir a configuração permanente do Sudoku, separando-a do estado
produzido durante uma partida.

A implementação foi realizada por meio do `TabuleiroRepository`.

**Status:** ✅ Concluída

---

## TASK-008 — Compreender o Repository

Estudar a responsabilidade do padrão Repository antes da implementação
da persistência da partida.

Foram considerados:

* responsabilidade do repository;
* relação entre domínio e persistência;
* objetos recebidos e retornados;
* consultas SQL;
* `PreparedStatement`;
* transações;
* tratamento de `SQLException`;
* limites da camada de persistência.

**Status:** ✅ Concluída

---

## TASK-009 — Definir e implementar PartidaRepository

Definir e implementar o repository responsável pela persistência e
recuperação do estado da partida.

O `PartidaRepository` passou a trabalhar com:

```text
PARTIDA
    ↓
ESTADO_CASA
    ↓
CANDIDATO
```

A implementação permite:

* salvar a partida;
* localizar a última partida salva;
* obter o tabuleiro associado;
* carregar o estado persistido;
* sobrescrever uma partida existente.

**Status:** ✅ Concluída

---

## TASK-010 — Implementar carregamento

Implementar a reconstrução de uma partida a partir dos dados persistidos.

O `PartidaRepository` foi integrado ao fluxo de `2 - Continuar`.

O cenário sem partida salva também foi validado.

**Status:** ✅ Concluída

---

## TASK-011 — Integrar opção "Salvar"

Adicionar o salvamento ao fluxo da partida.

O `MenuPartida` passou a concentrar:

```text
1 - Fazer jogada
2 - Salvar partida
3 - Remover jogada
4 - Limpar jogadas
5 - Consultar Status
0 - Voltar
```

O fluxo de salvamento foi integrado ao `JogoSudoku`.

Uma nova partida é salva diretamente.

Uma partida já salva exige confirmação antes da sobrescrita.

O cancelamento foi validado.

**Status:** ✅ Concluída

---

## TASK-012 — Integrar opção "Continuar"

Ativar a opção `2 - Continuar` do Menu Principal.

O fluxo foi integrado ao `JogoSudoku`.

Foi validado tanto o carregamento de uma partida existente quanto o
retorno ao Menu Principal quando não existe partida salva.

**Status:** ✅ Concluída

---

## TASK-013 — Implementar sobrescrita

Implementar a atualização do estado de uma partida existente sem criar
uma nova `PARTIDA`.

A operação foi implementada no `PartidaRepository`.

Foi validado que:

* a mesma `PARTIDA` permanece sendo utilizada;
* o estado persistido é atualizado;
* a confirmação é solicitada antes da sobrescrita;
* o cancelamento preserva o último estado salvo.

**Status:** ✅ Concluída

---

## TASK-014 — Validar persistência completa

Validar o ciclo:

```text
Nova partida
↓
Jogadas
↓
Rascunhos
↓
Salvar
↓
Encerrar aplicação
↓
Abrir aplicação novamente
↓
Continuar
↓
Estado restaurado
```

Foram validados:

* persistência de jogadas definitivas;
* persistência de candidatos;
* carregamento;
* sobrescrita;
* salvamento inicial;
* confirmação de sobrescrita;
* cancelamento;
* preservação do último estado salvo;
* descarte de alterações não salvas;
* cenário sem partida salva.

**Status:** ✅ Concluída

---

## TASK-015 — Code Review

Realizar revisão técnica da implementação.

A revisão considerou:

* responsabilidades dos repositories;
* tratamento de exceções;
* transações;
* consultas SQL;
* separação entre domínio e persistência;
* duplicação de código;
* nomenclatura;
* legibilidade;
* arquitetura;
* responsabilidade das regras implementadas em `Casa`;
* consistência entre `Casa.preencher()` e
  `Casa.alternarCandidato()`.

A regra definida para alteração de jogada definitiva foi considerada como
comportamento intencional do domínio.

**Status:** ✅ Concluída

---

## TASK-016 — Atualizar documentação e DoD

Atualizar os artefatos da Sprint e validar a Definition of Done.

A User Story foi atualizada com base nas validações realizadas durante a
Sprint.

**Status:** ✅ Concluída

---

# 📌 Dependências

* US-001 — Visualizar o tabuleiro;
* US-002 — Carregar o tabuleiro inicial;
* US-004 — Inserir um número;
* US-007 — Remover um número;
* US-017 — Sistema de rascunhos.

---

# 🔗 Relação com User Stories Futuras

A persistência implementada nesta User Story poderá servir como base para
futuras funcionalidades, incluindo:

* Estatísticas da partida;
* histórico de partidas;
* exportação de partidas;
* evolução da interface gráfica;
* outras funcionalidades dependentes de persistência.

A interface gráfica Swing permanece fora do escopo da US-018.

---

# ✔ Critério Final

A **US-018 — Continuar partida** foi concluída após o atendimento dos
critérios de aceitação, conclusão das TASKs previstas, validação da
implementação e atualização dos artefatos da Sprint.

A funcionalidade permite:

```text
iniciar uma partida
      ↓
fazer jogadas
      ↓
fazer rascunhos
      ↓
salvar
      ↓
encerrar a aplicação
      ↓
abrir novamente
      ↓
continuar a partida
      ↓
encontrar o estado salvo preservado
```

Também permite:

```text
partida já salva
      ↓
nova alteração
      ↓
Salvar
      ↓
solicitar confirmação
      ↓
S → sobrescrever
N → cancelar
```

No caso de cancelamento:

```text
jogador responde N
      ↓
operação cancelada
      ↓
último estado salvo permanece preservado
      ↓
alterações posteriores não salvas são descartadas
```

Também foi consolidada a regra de alteração das jogadas:

```text
Casa vazia
      ↓
nova jogada
      ↓
permitida
```

Enquanto:

```text
Casa preenchida
      ↓
nova jogada
      ↓
rejeitada
      ↓
remover jogada primeiro
```

A mesma proteção é aplicada aos candidatos:

```text
Casa preenchida
      ↓
novo candidato
      ↓
rejeitado
```

A estrutura técnica da persistência e sua modelagem estão documentadas
em `02-modelagem.md`, enquanto as decisões arquiteturais relevantes estão
registradas nas ADRs correspondentes.

**Status final:** ✅ Concluída