# ⏰ Sistema de Relógios - Herança e Polimorfismo em Java

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

## 📌 Sobre o projeto

Este projeto foi desenvolvido durante os estudos de **Programação Orientada a Objetos em Java**, com foco nos conceitos de:

- Abstração
- Herança
- Polimorfismo
- Encapsulamento
- Sobrescrita de métodos
- Classes abstratas
- Enumerações
- Tratamento de exceções

O desafio consiste na implementação de diferentes tipos de relógios capazes de alterar seus horários entre formatos distintos:

- 🇧🇷 Relógio brasileiro (formato 24 horas)
- 🇺🇸 Relógio americano (formato 12 horas utilizando AM/PM)

---

# 🎯 Objetivo

Criar uma estrutura orientada a objetos onde diferentes tipos de relógios compartilham comportamentos comuns, mas possuem regras específicas para validação e conversão de horários.

---

## 💡 Decisões de Projeto

Foi criado o método `getHora24()` para centralizar a conversão entre os formatos de relógio brasileiro (24h) e americano (12h com AM/PM), desacoplando a lógica de conversão das subclasses.

---

# 🏗️ Estrutura do projeto

```text
src
├── Main.java
└── relogio
├── Periodo.java
├── Relogio.java
├── RelogioAmericano.java
└── RelogioBrasileiro.java
```

---

# 🧠 Conceitos aplicados

## 🔹 Abstração

A classe `Relogio` foi criada como uma classe abstrata, representando características comuns entre diferentes tipos de relógios.

Responsabilidades:

- Armazenar hora, minuto e segundo
- Controlar validações
- Definir contratos para subclasses

Exemplo:

```java
public abstract class Relogio {

    protected abstract boolean validarHora(int hora);

    public abstract void alterarHorario(Relogio relogio);

    public abstract int getHora24();
}
```
---
## 🔹 Herança

As classes especializadas herdam os comportamentos da classe base:

```text
             Relogio
                |
        -----------------
        |               |
RelogioBrasileiro  RelogioAmericano
```

Cada implementação possui suas próprias regras.

### 🇧🇷 Relógio Brasileiro

Características:

* Aceita horários entre `00` e `23`;
* Utiliza o formato de 24 horas.

Exemplo:

```text
20:45:10
```

---

### 🇺🇸 Relógio Americano

Características:

* Aceita horários entre `01` e `12`;
* Utiliza períodos `AM` e `PM`;
* Realiza conversão para o formato de 24 horas quando necessário.

Exemplo:

```text
08:45:10 PM
```

---

## 🔹 Polimorfismo

O projeto utiliza referências do tipo da classe abstrata:

```java
Relogio brasileiro =
        new RelogioBrasileiro(
                20,
                45,
                10
        );

Relogio americano =
        new RelogioAmericano(
                10,
                30,
                20,
                Periodo.AM
        );
```

O comportamento executado depende da implementação real do objeto.

Exemplo:

```java
americano.alterarHorario(brasileiro);
```

Nesse caso, a conversão será realizada pela implementação do `RelogioAmericano`.

---

## 🔹 Encapsulamento

Os atributos internos do relógio são protegidos através de:

* atributos privados;
* getters;
* setters com validações.

Exemplo:

```java
public void setMinuto(int minuto) {

    if (minuto < 0 || minuto > 59) {
        throw new IllegalArgumentException(
                "Minuto inválido."
        );
    }

    this.minuto = minuto;
}
```

Isso impede que o objeto assuma estados inválidos.

---

# 🔄 Conversão de horários

## Brasil → EUA

Entrada:

```text
20:45:10
```

Conversão:

```text
08:45:10 PM
```

---

## EUA → Brasil

Entrada:

```text
08:45:10 PM
```

Conversão:

```text
20:45:10
```

---

# 🌙 Tratamento de casos especiais

Foram implementados testes para horários críticos.

## Meia-noite

Conversão:

```text
00:00:00
```

para:

```text
12:00:00 AM
```

---

## Meio-dia

Conversão:

```text
12:00:00
```

para:

```text
12:00:00 PM
```

---

# ⚠️ Tratamento de exceções

O sistema impede horários inválidos.

Exemplo:

```java
new RelogioBrasileiro(
        25,
        30,
        10
);
```

Resultado:

```text
Hora inválida.
```

Outro exemplo:

```java
new RelogioAmericano(
        15,
        30,
        10,
        Periodo.PM
);
```

Resultado:

```text
Hora inválida.
```

---

# 🚀 Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

✅ Criação de classes abstratas
✅ Implementação de herança
✅ Uso de métodos abstratos
✅ Aplicação de polimorfismo
✅ Criação de enums
✅ Conversão entre diferentes representações de dados
✅ Validação de regras de negócio
✅ Tratamento de exceções

---

# 📈 Evolução técnica

Este projeto representa uma evolução dos exercícios anteriores de POO:

* `PetMachine` → Classes e responsabilidades;
* `ContaBancaria` → Encapsulamento e regras de negócio;
* `Carro` → Validações e controle de estado;
* `IngressoCinema` → Herança e polimorfismo;
* `SistemaUsuarios` → Hierarquia de classes;
* `Relógio` → Abstração e conversão entre objetos.

---

# 🛠️ Tecnologias utilizadas

* Java 21
* IntelliJ IDEA
* Git
* GitHub

---

# 👨‍💻 Autor

**Flávio Oliveira**

Projeto desenvolvido como parte da trilha:

**DIO - Globant Java & Spring Boot AI Developer**


