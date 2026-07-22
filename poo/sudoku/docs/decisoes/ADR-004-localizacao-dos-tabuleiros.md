# 📚 ADR-004

## Título

Localização dos Tabuleiros

---

## Status

✅ Aprovado

---

## Contexto

O projeto precisa armazenar um ou mais tabuleiros iniciais de Sudoku.

Foi necessário definir onde esses dados ficariam armazenados para manter a organização da arquitetura.

---

## 🧠 Decisão

Os tabuleiros serão armazenados na classe:

`util.Tabuleiros`

Essa classe será responsável apenas por fornecer configurações de tabuleiros ao restante do sistema.

Inicialmente disponibilizará um único tabuleiro através do método:

`obterTabuleiroInicial()`.

Inicialmente será disponibilizado um único tabuleiro correspondente ao
enunciado oficial do desafio Sudoku da DIO.

Novos tabuleiros poderão ser adicionados futuramente na mesma classe.

---

## 🎯 Motivação

Centralizar os tabuleiros facilita:

- reutilização;
- manutenção;
- testes;
- criação de novos níveis de dificuldade.

Também mantém o projeto alinhado ao desafio oficial proposto pela DIO.

---

## 📖 Origem do tabuleiro inicial

O tabuleiro utilizado nesta implementação foi obtido do enunciado oficial do
desafio Sudoku da DIO.

---

## ✅ Consequências

### Vantagens

- separação entre domínio e dados auxiliares;
- facilidade para adicionar novos tabuleiros;
- reutilização da configuração inicial;
- menor acoplamento com a classe `Tabuleiro`.

---

## Data

21/07/2026