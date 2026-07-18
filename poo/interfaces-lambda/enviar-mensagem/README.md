# 📨 Sistema de Envio de Mensagens

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

Projeto desenvolvido durante os estudos de **Interfaces e Polimorfismo em Java**.

O sistema demonstra como diferentes serviços de comunicação podem implementar o mesmo contrato para envio de mensagens.

---

# 🎯 Objetivo

Simular o envio de uma mensagem para diferentes plataformas utilizando uma interface comum.

Os serviços implementados são:

- SMS
- E-mail
- WhatsApp
- Redes Sociais

---

# 🧠 Conceitos praticados

- Interfaces
- Polimorfismo
- Sobrescrita de métodos (`@Override`)
- Encapsulamento
- Programação orientada a interfaces
- Baixo acoplamento
- Princípio Open/Closed (OCP)

---

# 📂 Estrutura do Projeto

```text
src
├── Main.java
├── EnviarMensagem.java
├── SMS.java
├── Email.java
├── WhatsApp.java
└── RedeSocial.java
```

---

# ▶️ Exemplo de saída

```text
SMS enviado:
E-mail enviado:
WhatsApp enviado:
Mensagem publicada na rede social:
```

---

# 🚀 Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Programação Orientada a Objetos (POO)

---

# 📚 Aprendizados

Durante este exercício foram praticados conceitos fundamentais sobre interfaces em Java, permitindo que diferentes classes compartilhassem o mesmo contrato sem depender de implementações específicas.

Essa abordagem facilita a manutenção do código e permite adicionar novos serviços de envio de mensagens sem modificar as classes existentes.

---

# 👨‍💻 Autor

**Flávio Oliveira**

Projeto desenvolvido como parte da trilha:

**DIO - Globant Java & Spring Boot AI Developer**