# 🎬 Sistema de Ingressos de Cinema

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

Projeto desenvolvido durante os estudos de **Programação Orientada a Objetos em Java**, com foco na aplicação prática dos principais conceitos de orientação a objetos através da construção de uma hierarquia de classes para representar diferentes tipos de ingressos comercializados por um cinema.

O objetivo principal foi praticar **abstração, herança, encapsulamento e polimorfismo**, criando uma estrutura flexível e preparada para receber novos tipos de ingressos futuramente.

---

# 📚 Sobre o Projeto

O sistema representa diferentes modalidades de ingressos:

- 🎟️ Ingresso comum (classe abstrata base)
- 🎓 Meia entrada
- 👨‍👩‍👧 Ingresso família

Cada tipo de ingresso possui uma regra própria para cálculo do valor final, demonstrando como o polimorfismo permite que diferentes objetos respondam ao mesmo comportamento de maneiras distintas.

---

# 🧠 Conceitos de Programação Orientada a Objetos Aplicados

## 🔹 Abstração

A classe `Ingresso` foi definida como uma classe abstrata, pois representa um conceito genérico.

Ela contém informações comuns a todos os ingressos:

- Valor base
- Nome do filme
- Tipo de áudio

Além disso, define o comportamento:

```java
public abstract double calcularValor();
```
que deverá ser implementado pelas classes filhas.

## 🔹 Encapsulamento

Os atributos das classes foram protegidos utilizando:

```java
private final;
```

garantindo que os dados sejam controlados pela própria classe.

O acesso às informações ocorre através de métodos **getters**.

Exemplo:

```java
public double getValorBase() {
    return valorBase;
}
```

---

## 🔹 Herança

As classes específicas de ingresso reutilizam características da classe principal:

```text
                 Ingresso
              <<abstract>>
                    ▲
                    |
        ┌───────────┴───────────┐
        |                       |
  MeiaEntrada          IngressoFamilia
```

Implementação:

```java
public class MeiaEntrada extends Ingresso

public class IngressoFamilia extends Ingresso
```

---

## 🔹 Polimorfismo

O sistema utiliza uma lista do tipo:

```java
List<Ingresso> ingressos;
```

permitindo armazenar diferentes tipos de objetos:

```java
new MeiaEntrada(...)

new IngressoFamilia(...)
```

Durante a execução, cada objeto executa sua própria implementação do método:

```java
calcularValor();
```

Exemplo:

```java
for (Ingresso ingresso : ingressos) {
    ingresso.calcularValor();
}
```

A JVM identifica automaticamente qual implementação deve executar.

---

# 🏗️ Estrutura do Projeto

```text
src
│
├── Main.java
│
└── ingresso
    │
    ├── Ingresso.java
    ├── MeiaEntrada.java
    ├── IngressoFamilia.java
    └── TipoAudio.java
```

---

# 📌 Diagrama de Classes

```text
                         Ingresso
                      <<abstract>>

        -------------------------------------
        - valorBase : double
        - nomeFilme : String
        - tipoAudio : TipoAudio
        -------------------------------------
        + calcularValor() : double
        + getNomeFilme()
        + getTipoAudio()
        + getValorBase()


                    ▲
                    |
        ┌───────────┴───────────┐

        MeiaEntrada        IngressoFamilia

        calcularValor()    - quantidadePessoas : int

        valorBase / 2      calcularValor()

                           valorBase * pessoas
                           desconto 5% (>3 pessoas)
```

---

# 🎟️ Regras de Negócio

## 🎓 Meia Entrada

O valor do ingresso corresponde a **50% do valor original**.

Exemplo:

```text
Valor original: R$ 40,00

Meia entrada:
R$ 20,00
```

---

## 👨‍👩‍👧 Ingresso Família

O valor é calculado considerando:

```text
valorBase × quantidadePessoas
```

Quando existem mais de 3 pessoas:

```text
Aplicar desconto de 5%
```

Exemplo:

```text
Valor individual: R$ 40,00

Quantidade:
5 pessoas

Total:
40 × 5 = 200

Desconto:
5%

Valor final:
R$ 190,00
```

---

# 🔐 Validações Implementadas

O sistema impede a criação de ingressos família inválidos.

Exemplo:

```java
if (quantidadePessoas < 1) {
    throw new IllegalArgumentException();
}
```

Não é permitido criar um ingresso com:

* ❌ 0 pessoas
* ❌ Quantidade negativa

---

# 🚀 Exemplo de Execução

```text
=================================
Tipo: Meia Entrada
Filme: Superman
Áudio: DUBLADO
Valor: R$ 20.00
=================================

=================================
Tipo: Família
Filme: Jurassic World
Áudio: LEGENDADO
Pessoas: 5
Valor: R$ 190.00
=================================
```

---

# 🛠️ Tecnologias Utilizadas

| Tecnologia       | Utilização                   |
| ---------------- | ---------------------------- |
| ☕ Java 21        | Desenvolvimento da aplicação |
| 🧠 IntelliJ IDEA | Ambiente de desenvolvimento  |
| 🔧 Git           | Controle de versão           |
| ☁️ GitHub        | Hospedagem do projeto        |

---

# 📈 Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

* ✅ Criação de classes e objetos
* ✅ Construtores
* ✅ Modificadores de acesso
* ✅ Classes abstratas
* ✅ Herança
* ✅ Sobrescrita de métodos
* ✅ Polimorfismo
* ✅ Enumeração (`enum`)
* ✅ Validação de regras de negócio
* ✅ Organização de código Java

---

# 🔮 Próximas Evoluções

Possíveis melhorias futuras:

* Implementar testes unitários com **JUnit**
* Substituir `double` por `BigDecimal`
* Criar uma camada de serviço para gerenciamento dos ingressos
* Implementar persistência de dados
* Criar uma API REST utilizando **Spring Boot**
* Aplicar princípios **SOLID**
* Utilizar Collections avançadas e Streams

---

# 👨‍💻 Autor

## Flávio Oliveira

Estudos e projetos desenvolvidos durante a jornada de aprendizado em Java, com foco em **Programação Orientada a Objetos, Engenharia de Software e desenvolvimento backend**.

⭐ Projeto desenvolvido como parte da formação **Java e Spring Boot**.
