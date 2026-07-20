# 📚 ADR-002

---
## Título

### Separação de responsabilidades entre JogoSudoku e Tabuleiro.

---
## 🧠 Decisão

A classe `JogoSudoku` será responsável pelo ciclo de vida da partida (iniciar, finalizar e controlar o fluxo do jogo).

A classe `Tabuleiro` será responsável por conhecer o estado do tabuleiro, validar conflitos, informar se está completo e gerenciar suas casas.

---
## 🚀 Motivação

Cada classe deve ser responsável apenas pelas informações que conhece, reduzindo acoplamento e facilitando a manutenção do sistema.