# 👥 Hierarquia de Usuários - Herança e Polimorfismo em Java

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## 📖 Sobre o projeto

Projeto desenvolvido durante o Bootcamp **Globant Java & Spring Boot AI Developer** da DIO com o objetivo de praticar os principais conceitos de **Herança**, **Polimorfismo**, **Classes Abstratas** e **Encapsulamento**.

O sistema simula diferentes tipos de usuários de uma aplicação, demonstrando como reutilizar código através da herança e como especializar comportamentos nas classes filhas.

---

## 🎯 Objetivos do projeto

* Modelar uma hierarquia de usuários.
* Aplicar herança para reutilização de código.
* Utilizar classes abstratas.
* Implementar polimorfismo através de sobrescrita de métodos.
* Demonstrar encapsulamento e regras de negócio.
* Utilizar coleções (`List<Usuario>`) para demonstrar polimorfismo.

---

# 🧱 Estrutura do Projeto

```
Usuario (Classe Abstrata)
│
├── Gerente
│   ├── gerarRelatorioFinanceiro()
│   └── consultarVendas()
│
├── Vendedor
│   ├── quantidadeVendas
│   ├── realizarVenda()
│   └── consultarVendas()
│
└── Atendente
    ├── valorCaixa
    ├── receberPagamento()
    └── fecharCaixa()
```

---

# 📂 Estrutura de arquivos

```
src
│
├── Main.java
│
└── usuario
    ├── Usuario.java
    ├── Gerente.java
    ├── Vendedor.java
    └── Atendente.java
```

---

# ⚙️ Funcionalidades

## 👤 Usuário

Todos os usuários possuem:

* Nome
* Email
* Senha

Além dos métodos:

* Realizar Login
* Realizar Logoff
* Alterar Dados
* Alterar Senha

---

## 👨‍💼 Gerente

Funcionalidades específicas:

* Gerar relatório financeiro
* Consultar vendas
* Administrador sempre verdadeiro

---

## 💼 Vendedor

Funcionalidades específicas:

* Registrar vendas
* Consultar quantidade de vendas
* Administrador sempre falso

---

## 💳 Atendente

Funcionalidades específicas:

* Receber pagamentos
* Controlar valor em caixa
* Fechar caixa
* Administrador sempre falso

---

# 🧠 Conceitos praticados

## Programação Orientada a Objetos

* Classes
* Objetos
* Encapsulamento
* Herança
* Polimorfismo
* Classes Abstratas
* Sobrescrita de métodos (`@Override`)
* Reutilização de código
* Uso de `super`

---

## Boas práticas aplicadas

* Organização por responsabilidades
* Encapsulamento de atributos
* Regras de negócio implementadas dentro das classes
* Métodos com nomes semânticos
* Evitando setters desnecessários
* Separação entre comportamento comum e comportamento específico

---

# 🚀 Demonstração do Polimorfismo

O projeto utiliza uma lista de usuários para demonstrar o polimorfismo.

```java
List<Usuario> usuarios = new ArrayList<>();

usuarios.add(gerente);
usuarios.add(vendedor);
usuarios.add(atendente);

for (Usuario usuario : usuarios) {
    System.out.println(usuario.getTipoUsuario());
}
```

Cada objeto responde conforme sua implementação, mesmo sendo tratado como `Usuario`.

---

# ▶️ Exemplo de saída

```
=================================
Nome: Ana
Email: ana@email.com
Cargo: Gerente
Administrador: true
=================================

=================================
Nome: Carlos
Email: carlos@email.com
Cargo: Vendedor
Administrador: false
=================================

=================================
Nome: Mariana
Email: mariana@email.com
Cargo: Atendente
Administrador: false
=================================

=== Demonstração dos métodos específicos ===

[usuario.Vendedor]
Total de vendas: 3

[usuario.Atendente]
Valor em caixa: R$ 150,00

[usuario.Gerente]
===|Relatório Financeiro|===
=================================
```

---

# 🎓 Aprendizados

Durante este projeto foram consolidados conceitos importantes da Programação Orientada a Objetos, como:

* Diferença entre generalização e especialização.
* Reutilização de código através da herança.
* Utilização de classes abstratas para representar comportamentos comuns.
* Aplicação de polimorfismo utilizando coleções.
* Encapsulamento e proteção das regras de negócio.
* Sobrescrita de métodos utilizando `@Override`.

---

# 📚 Tecnologias utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

---

# 👨‍💻 Autor

Desenvolvido por **Flávio Oliveira** durante o Bootcamp **Globant Java & Spring Boot AI Developer** da Digital Innovation One (DIO).

Projeto desenvolvido com foco em aprendizado, boas práticas de Programação Orientada a Objetos e construção de um portfólio sólido em Java.
