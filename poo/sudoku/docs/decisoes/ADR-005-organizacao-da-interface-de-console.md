# 📚 ADR-005

## Título

Organização da Interface de Console

---

## Status

✅ Aprovado

---

## Contexto

O projeto necessita organizar a camada de interface do usuário para aplicações executadas em terminal.

Durante a implementação do fluxo principal da aplicação foi necessário definir como organizar os

componentes responsáveis pela interação com o usuário no terminal.

---
## 🎯 Alternativas consideradas

### Opção A

Centralizar toda a saída em `ConsolePrinter`.

### Vantagens

* menos classes;
* menor quantidade de código.

### Desvantagens

* mistura responsabilidades;
* dificulta evolução para outras interfaces;
* reduz a representação dos conceitos da interface.

---

### Opção B (escolhida)

Criar componentes específicos para a interface.

```text
Menu
ConsolePrinter
ConsoleInput
```
Cada classe representa uma responsabilidade diferente.

---

## 🧠 Decisão

A camada `ui` será composta por componentes especializados.

* `Menu` representa os menus da aplicação;
* `ConsolePrinter` é responsável pela impressão de tabuleiro e mensagens;
* `ConsoleInput` encapsula toda entrada de dados do terminal.

O `JogoSudoku` atua apenas como coordenador do fluxo entre esses componentes, 
evitando dependências diretas entre entrada, saída e lógica de domínio.

---

## ✅ Consequências

### Positivas

* baixo acoplamento;
* responsabilidades claras;
* facilidade para evolução da interface sem impactar o domínio da aplicação;
* facilita futuras interfaces (Swing, JavaFX etc.).


### Negativas

* aumento do número de classes;
* pequena complexidade adicional.

---
## Data

22/07/2026