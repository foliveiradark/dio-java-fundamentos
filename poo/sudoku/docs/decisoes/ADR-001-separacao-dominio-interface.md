# 📚 ADR-001

---
## Título

### Separação entre domínio e interface.

---
## 🌐 Contexto

O sistema será desenvolvido inicialmente para o terminal.
No futuro poderá existir uma interface gráfica.

---
## 🧠 Decisão

As regras do Sudoku ficarão nas classes de domínio.
A interação com o usuário ficará concentrada na classe Menu.

---
## 🟢 Consequências

Será possível trocar o terminal por uma interface gráfica sem alterar a lógica do jogo.
