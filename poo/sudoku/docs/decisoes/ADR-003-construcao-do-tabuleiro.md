# 📚 ADR-003

## Título

### Construção do Tabuleiro.

---
## 🧠 Decisão

>O `Tabuleiro` será responsável por criar suas 81 `Casas`.

>O carregamento dos números iniciais será feito em um método específico, e não no construtor.

>Durante o carregamento do tabuleiro inicial, apenas casas com valores não nulos serão preenchidas. Casas vazias permanecem no estado criado pelo construtor, evitando operações redundantes.