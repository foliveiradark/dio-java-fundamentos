# Sprint 20 — Primeiro vertical slice jogável com JavaFX

---

## 📋 Informações Gerais

> **Projeto:** Sudoku Java  
> **Sprint:** Sprint 20  
> **User Story:** US-020 — Primeiro vertical slice jogável com JavaFX  
> **Prioridade:** 🔴 Alta  
> **Status:** ✅ Concluída

---

## 🎯 Objetivo da Sprint

Criar a primeira versão gráfica realmente jogável do Sudoku utilizando
JavaFX.

A Sprint teve como objetivo entregar um **vertical slice funcional**,
contemplando o fluxo essencial:

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

O objetivo não foi alcançar paridade funcional com a interface Console.

A prioridade foi validar a integração entre a arquitetura preparada na
Sprint 19, o novo sistema de build Maven, JavaFX e o fluxo real da partida.

---

## 🧭 Contexto

A Sprint 19 concluiu a preparação arquitetural da aplicação para
múltiplas interfaces.

Como resultado, foram estabelecidos:

* `JogoSudoku` como responsável pela orquestração;
* contratos de interação;
* separação entre interface e aplicação;
* independência do domínio;
* independência da persistência;
* Console preservado como implementação existente.

A Sprint 19 também definiu:

```text
Maven → sistema de build
JavaFX → tecnologia gráfica
```

A Sprint 20 iniciou a implementação dessa direção tecnológica.

Foi utilizada a estratégia de **vertical slice jogável** em vez de buscar
inicialmente a paridade funcional completa com o Console.

Essa abordagem permitiu validar uma primeira versão gráfica funcional antes
de ampliar progressivamente a interface.

---

## 🏁 Escopo da Sprint

### Incluído

* configuração do Maven;
* configuração das dependências JavaFX;
* validação do novo sistema de build;
* criação da aplicação JavaFX;
* criação da primeira interface gráfica;
* apresentação do tabuleiro;
* seleção de casas;
* inserção de números;
* atualização visual do tabuleiro;
* utilização das regras existentes;
* validação do fluxo vertical completo;
* preservação do Console;
* avaliação arquitetural da primeira implementação gráfica;
* atualização da documentação.

### Não incluído

* paridade funcional completa com o Console;
* candidatos;
* persistência pela GUI;
* continuar partida pela GUI;
* menus completos;
* estatísticas;
* níveis de dificuldade;
* cronômetro;
* animações avançadas;
* efeitos sonoros;
* distribuição da aplicação;
* instalador;
* empacotamento definitivo;
* funcionalidades adicionais de produto.

---

## 🏛️ Direção Arquitetural

A implementação utilizou a arquitetura estabelecida na US-019.

A direção conceitual permanece:

```text
┌─────────────────────────────┐
│ JavaFX                      │
│ Interface gráfica           │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│ JogoSudoku                  │
│ Orquestração                │
└──────────────┬──────────────┘
               │
       ┌───────┴────────┐
       ▼                ▼
┌─────────────┐  ┌──────────────┐
│ Domínio     │  │ Persistência │
└─────────────┘  └──────────────┘
```

A interface gráfica não passou a assumir responsabilidades pertencentes
ao domínio ou à persistência.

A implementação foi realizada de forma incremental, sem introdução de
abstrações adicionais que não fossem necessárias para o vertical slice.

---

## 🛠️ Estratégia Tecnológica

### Maven

O Maven foi configurado durante a Sprint 20 como infraestrutura necessária
para a implementação da nova interface.

O projeto passou a utilizar o Maven para gerenciamento das dependências e
execução do processo de build.

A adoção do Maven também estabelece uma base independente da configuração
específica da IDE para as próximas etapas de desenvolvimento.

### JavaFX

JavaFX foi integrado ao projeto para construção da primeira interface
gráfica desktop.

A primeira implementação priorizou funcionalidade e clareza de interação,
mantendo o refinamento visual para futuras iterações.

---

## 🧩 User Story

**US-020 — Primeiro vertical slice jogável com JavaFX**

A User Story entregou a primeira experiência gráfica funcional do Sudoku.

O fluxo implementado foi:

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

A interface não possui, nesta etapa, todas as funcionalidades disponíveis
no Console.

Essa limitação foi intencional e está de acordo com a estratégia definida
para a Sprint: validar primeiro uma fatia vertical completa do produto e
evoluir a partir dela.

---

## 🔎 Resultado da Sprint

Ao final da Sprint passou a existir uma primeira versão gráfica executável
e jogável do Sudoku.

O usuário consegue realizar uma operação real de uma partida através da
interface JavaFX.

A Sprint demonstrou que:

* o projeto pode ser construído utilizando Maven;
* JavaFX pode ser executado corretamente no projeto;
* a arquitetura preparada na Sprint 19 suporta uma segunda interface;
* o tabuleiro existente pode ser apresentado graficamente;
* uma jogada pode ser realizada através da GUI;
* o resultado pode ser visualizado;
* as regras existentes continuam centralizadas na aplicação;
* o Console permanece funcional.

---

## 🧪 Validações realizadas

Foi validado o fluxo vertical definido para a Sprint:

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

Também foi validada a integração da interface gráfica com o fluxo existente
da aplicação, sem necessidade de duplicar as regras do Sudoku na camada
JavaFX.

O funcionamento da interface Console foi preservado após a introdução da
nova interface.

---

## 📝 Code Review

O Code Review foi realizado sobre a implementação da Sprint, considerando
principalmente:

* aderência à arquitetura definida na US-019;
* integração do Maven;
* organização da aplicação JavaFX;
* ausência de duplicação das regras do Sudoku;
* separação de responsabilidades;
* preservação do Console;
* clareza da implementação;
* necessidade real de novas abstrações.

A implementação permaneceu alinhada à direção arquitetural estabelecida
anteriormente.

Não foram identificados problemas que justificassem a reabertura das
decisões arquiteturais já estabelecidas.

---

## 🏛️ ADRs relacionados

* ADR-011 — Separação entre interface e orquestração da aplicação

A implementação da Sprint 20 confirmou, na prática, a decisão registrada
no ADR-011.

Não foi identificada durante a Sprint nenhuma nova decisão arquitetural
relevante que justificasse a criação de outro ADR.

As decisões relacionadas à adoção do Maven e do JavaFX permanecem
registradas nos artefatos de evolução e planejamento do projeto, não sendo
necessário transformá-las em novos ADRs neste momento.

---

## 🔄 Estratégia de Evolução

A Sprint 20 não representa a conclusão da interface gráfica.

Ela estabeleceu a primeira base jogável sobre a qual futuras User Stories
poderão adicionar progressivamente novas capacidades.

A evolução poderá seguir, conforme priorização do Product Backlog:

```text
Vertical Slice
      ↓
Refinamento da interface
      ↓
Candidatos
      ↓
Menus
      ↓
Persistência
      ↓
Continuação de partida
      ↓
Estatísticas
      ↓
Experiência visual
      ↓
Distribuição
```

Cada evolução deverá ser avaliada individualmente, evitando antecipar
complexidade que ainda não seja necessária.

---

## 📌 Resultado e Ponto de Retomada

A Sprint 20 concluiu a primeira etapa prática da transição do Sudoku de
uma aplicação essencialmente orientada ao Console para um produto desktop
com interface gráfica.

O projeto passou de:

```text
US-019
Arquitetura desacoplada
        ↓
```

para:

```text
US-020
Maven + JavaFX
        ↓
Vertical Slice jogável
        ↓
Evolução incremental da GUI
```

A primeira interface JavaFX demonstrou que a arquitetura preparada na
Sprint 19 é capaz de suportar uma segunda tecnologia de interface sem
duplicação das regras do Sudoku.

A conclusão da US-020 **não representa a conclusão da interface gráfica**.
A GUI ainda deverá evoluir progressivamente até alcançar maior cobertura
funcional e uma experiência de produto mais completa.

A Sprint 20 estabelece, portanto, uma nova base técnica para as próximas
evoluções do projeto:

```text
Console
   │
   ├──────────────┐
   │              │
   ▼              ▼
Arquitetura    JavaFX
desacoplada      │
   │              ▼
   └───────→ Vertical Slice
                    │
                    ▼
             Próximas evoluções
```
