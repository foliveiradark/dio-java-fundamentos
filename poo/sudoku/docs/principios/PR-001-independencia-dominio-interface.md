# PR-001 — Independência do domínio em relação à interface

## 📌 Princípio

As regras e representações do domínio devem ser independentes da tecnologia e da forma de interação utilizada pela interface.

A interface deve ser responsável pelos detalhes de interação com o usuário, enquanto o domínio deve representar e processar os conceitos do sistema sem depender da interface utilizada.

---

## 🎯 Motivação

O projeto atualmente utiliza uma interface de console, mas o roadmap prevê uma futura evolução para uma interface gráfica utilizando Swing.

As decisões tomadas durante o desenvolvimento da interface atual não devem criar dependências desnecessárias no domínio que dificultem essa evolução.

Por isso, conceitos pertencentes ao domínio devem ser representados de forma independente da maneira como o jogador interage com o sistema.

---

## 🔎 Origem

**Projeto:** Sudoku em Java

**Contexto:** US-017 — Sistema de rascunhos

Durante a análise da funcionalidade de rascunhos, foi definida a utilização do prefixo `*` na interface de console para identificar uma operação de rascunho.

Exemplo:

`5`

Representa a inclusão de um número definitivo.

`*5`

Representa a inclusão do número `5` como rascunho.

Durante essa análise foi identificado que a sintaxe `*5` é uma decisão específica da interface de console e, portanto, não deve fazer parte da representação do domínio.

---

## 🏗️ Aplicação no projeto

A interpretação da sintaxe deve permanecer na camada responsável pela interação com o usuário.

O domínio deve receber a operação correspondente, sem precisar conhecer a forma como ela foi representada na interface.

```text
Interface de Console
        │
        │ "*5"
        ▼
Interpretação da entrada
        │
        ▼
Operação de rascunho
        │
        ▼
     Domínio
        │
        ▼
      Casa
        │
        └── candidato: 5
```

Uma futura interface gráfica poderá utilizar outra forma de interação para executar a mesma operação:

```text
Interface Swing
        │
        │ interação do usuário
        ▼
Operação de rascunho
        │
        ▼
     Domínio
        │
        ▼
      Casa
        │
        └── candidato: 5
```

A forma de interação pode mudar sem que o conceito de domínio precise ser alterado.

---

## 📐 Regra derivada

> Uma decisão específica de interação de uma interface não deve determinar como um conceito do domínio é representado ou processado.

---

## 🚫 O que este princípio não significa

Este princípio não determina que a arquitetura futura do Swing deva ser construída antecipadamente.

Também não implica a criação de abstrações ou camadas exclusivamente para atender funcionalidades futuras.

A aplicação do princípio consiste em evitar que regras e conceitos do domínio dependam de detalhes específicos da interface atual.

---

## 📚 Evidência

Este princípio foi identificado durante a análise da:

- **US-017 — Sistema de rascunhos**
- Evolução prevista para a **Fase 7 — Interface Gráfica**
- Decisão sobre a sintaxe `*5` na interface de console.

---

## 🔗 Relações

### Roadmap

**Fase 6 — Evolução do Produto**

A funcionalidade de rascunhos é uma das próximas funcionalidades previstas para evolução do produto.

**Fase 7 — Interface Gráfica**

A futura interface gráfica reforça a necessidade de manter o domínio independente da interface de console.

### ADRs relacionados

- **ADR-001 — Separação entre domínio e interface**
- **ADR-005 — Organização da interface de console**

### User Story relacionada

- **US-017 — Sistema de rascunhos**

---

## 📊 Status

🟢 **Identificado**

Este princípio foi identificado a partir da experiência prática durante o desenvolvimento do projeto e deverá ser considerado nas próximas decisões arquiteturais e implementações.
