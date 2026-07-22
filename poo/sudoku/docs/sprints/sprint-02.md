# 🔄 Sprint 2 — Carregamento do Tabuleiro Inicial

## 🎯 Objetivo

Implementar o carregamento automático de um tabuleiro inicial e validar sua exibição no terminal.

---

## ⚙️ Funcionalidades implementadas

### 🧩 Tabuleiro Inicial

* criação da classe `util.Tabuleiros`
* definição do primeiro tabuleiro oficial
* disponibilização do tabuleiro através de método estático

### 🧬 Classe Tabuleiro

* implementação do método `carregarTabuleiroInicial()`
* leitura da matriz de dados
* preenchimento das casas utilizando encapsulamento
* carregamento automático durante a construção do tabuleiro

### 🖥️ Interface

* exibição do tabuleiro inicial
* validação da impressão dos números fixos
* manutenção dos separadores dos blocos 3×3

---

## 🧪 Testes realizados

* carregamento automático do tabuleiro
* validação dos números fixos
* validação das casas vazias
* teste de integração entre `Tabuleiros`, `Tabuleiro`, `Casa` e `ConsolePrinter`

---

## 🏗️ Build

Todos os builds executados com sucesso.

---

## 📚 Aprendizados

* separação entre fonte de dados e domínio
* carregamento incremental do estado do objeto
* reutilização de métodos (`getCasa()`)
* importância do encapsulamento durante integrações
* depuração de erros utilizando stack trace

---

## 🔮 Próximas atividades

* implementar a classe `JogoSudoku`
* iniciar o menu de interação do jogador
* preparar a lógica das ações do jogo

---

## Status

✅ Sprint concluída.

