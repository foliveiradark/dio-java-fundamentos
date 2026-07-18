# 💰 Sistema de Cálculo de Tributos

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

Projeto desenvolvido durante os estudos de **Interfaces, Herança, Classes Abstratas e Polimorfismo em Java**.

---

# 🎯 Objetivo

Simular o cálculo de tributos para diferentes categorias de produtos.

Cada categoria possui uma alíquota específica.

| Categoria | Tributo |
|-----------|---------|
| Alimentação | 1% |
| Saúde e Bem Estar | 1,5% |
| Vestuário | 2,5% |
| Cultura | 4% |

---

## 💡 Decisões de Projeto

# 💡 Decisões de Projeto

Foi utilizada uma interface (`CalcularTributo`) para definir o contrato de cálculo de impostos e uma classe abstrata (`Produto`) para centralizar atributos e comportamentos comuns, como nome e preço.

Essa abordagem reduz duplicação de código e permite que cada categoria implemente apenas sua regra específica de tributação.

---

# 🧠 Conceitos praticados

- Interfaces
- Classes Abstratas
- Herança
- Polimorfismo
- Encapsulamento
- Coleções (`List`)
- Validação de dados
- Tratamento de exceções
- Sobrescrita de métodos

---

# 📂 Estrutura do Projeto

```text
src
├── Main.java
├── CalcularTributo.java
├── Produto.java
├── Alimentacao.java
├── SaudeBemEstar.java
├── Vestuario.java
└── Cultura.java
```

---

# ▶️ Exemplo de saída

```text
=================================
Produto: Arroz
Categoria: Alimentacao
Preço: R$25,15
Tributo: R$0,25

=================================
Produto: Plano de Saúde
Categoria: SaudeBemEstar
Preço: R$520,00
Tributo: R$7,80
```

---

# 🚀 Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Programação Orientada a Objetos (POO)

---

# 📚 Aprendizados

Este projeto permitiu aprofundar o uso de interfaces juntamente com classes abstratas, mostrando quando a herança realmente agrega valor ao compartilhamento de atributos e comportamentos entre diferentes objetos.

Também foram aplicadas boas práticas de encapsulamento, validação de dados e tratamento de exceções.

---

# 👨‍💻 Autor

**Flávio Oliveira**

Projeto desenvolvido como parte da trilha:

**DIO - Globant Java & Spring Boot AI Developer**