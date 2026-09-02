# 📘 Guia de Desenvolvimento

> Documento que define o processo de desenvolvimento do projeto Sudoku.

---

# 🎯 Objetivo

Este projeto tem como objetivo praticar Programação Orientada a Objetos em Java utilizando um fluxo de desenvolvimento semelhante ao utilizado em equipes profissionais.

---

# 🏗️ Filosofia do Projeto

- aprender antes de acelerar;
- código limpo;
- desenvolvimento incremental;
- documentação contínua;
- arquitetura simples;
- decisões registradas.

---

# 🔄 Fluxo de Desenvolvimento

```text
Sprint Planning
        ↓
Documentação inicial
        ↓
Implementação incremental
        ↓
Build
        ↓
Testes
        ↓
Code Review
        ↓
Atualização da documentação
        ↓
Definition of Done
        ↓
Commit
        ↓
Push
```

---

# 🔄 Continuidade de Desenvolvimento

O projeto deve permitir a continuidade do desenvolvimento independentemente da estação de trabalho, do contexto ou do agente responsável pela execução.

A continuidade é organizada em duas dimensões complementares:

```text
                 Continuidade
                       │
          ┌────────────┴────────────┐
          │                         │
    Entre estações            Entre agentes
          │                         │
     Git/GitHub              Handoff/Context Check
          │                         │
   Estado do código          Estado do trabalho
```

Essas dimensões podem ocorrer de forma independente ou simultaneamente.

---

## 🖥️ Continuidade entre estações

Cada estação de trabalho possui uma cópia local independente do repositório.

O GitHub é utilizado como ponto de sincronização entre as estações.

```text
Linux ───────┐
             │
             ▼
           GitHub
             ▲
             │
Windows ─────┘
```

### Início de trabalho em uma estação

Antes de iniciar o desenvolvimento:

```text
git status
     ↓
git pull
     ↓
git status
```

O objetivo é verificar o estado local e garantir que a estação esteja sincronizada com o repositório remoto antes de continuar o desenvolvimento.

### Durante o desenvolvimento

O desenvolvimento ocorre normalmente na estação local.

As alterações devem ser verificadas antes de serem registradas:

```text
git status
     ↓
git diff
```

Quando existir uma unidade lógica de trabalho:

```text
git add
     ↓
git commit
```

### Encerramento do trabalho em uma estação

Quando o trabalho precisar continuar em outra estação, as alterações que deverão ser transportadas devem estar:

- revisadas;
- commitadas;
- publicadas no repositório remoto.

Fluxo:

```text
git status
     ↓
git add
     ↓
git commit
     ↓
git push
     ↓
estado sincronizado no GitHub
```

A estação seguinte deverá executar:

```text
git status
     ↓
git pull
     ↓
git status
```

Somente então o desenvolvimento deve ser continuado.

### Regra de troca de estação

> Antes de continuar o desenvolvimento em outra estação, o trabalho que precisa ser transportado deve estar commitado e publicado no GitHub. A nova estação deve sincronizar o repositório antes de continuar o desenvolvimento.

### Princípio

O projeto não deve depender do caminho físico ou das configurações específicas de uma estação.

Exemplos:

```text
Linux:

~/projetos/dio-java-fundamentos

Windows:

C:\Users\User\Projects\dio-java-fundamentos
```

Os caminhos podem ser diferentes, mas o projeto deve permanecer funcional e versionado pelo mesmo repositório Git.

Configurações específicas da máquina, arquivos temporários, caches e artefatos de build não devem ser utilizados como mecanismo de sincronização do projeto.

---

## 🤝 Continuidade entre agentes de desenvolvimento

O desenvolvimento deve permitir a passagem de trabalho entre diferentes agentes sem depender da identidade, da ferramenta ou da sessão utilizada.

Um agente de desenvolvimento pode ser:

- o próprio desenvolvedor em uma nova sessão;
- outro desenvolvedor;
- uma equipe;
- uma ferramenta de Inteligência Artificial;
- uma colaboração entre desenvolvedor e IA.

A passagem de trabalho deve utilizar o mesmo processo independentemente do agente sucessor.

### Sprint Handoff

O **Sprint Handoff** é o mecanismo utilizado para realizar a passagem de bastão entre agentes de desenvolvimento.

Seu objetivo é registrar o estado operacional necessário para que o próximo agente possa compreender onde o trabalho foi interrompido e continuar a execução com segurança.

O Handoff deve registrar, quando aplicável:

- Sprint atual;
- User Story em andamento;
- TASK atual;
- estado da implementação;
- decisões relevantes;
- arquivos ou componentes envolvidos;
- pendências;
- próximos passos;
- riscos ou pontos de atenção;
- estado da documentação;
- informações necessárias para retomada do trabalho.

O Handoff deve funcionar como um **snapshot operacional**, e não como substituto da documentação permanente do projeto.

### Separação de responsabilidades

Cada mecanismo possui uma responsabilidade específica:

```text
Git/GitHub

→ estado e histórico do código


Documentação

→ conhecimento permanente do projeto


ADR

→ decisões arquiteturais


Sprint Handoff

→ estado operacional para passagem de bastão


Context Check

→ validação da compreensão do contexto recebido
```

### Continuidade entre contextos

Quando houver mudança de contexto durante o desenvolvimento, o Sprint Handoff deve fornecer ao próximo agente as informações operacionais necessárias para a continuidade.

Um novo contexto pode ocorrer, por exemplo, quando:

- o desenvolvedor inicia uma nova sessão;
- outro desenvolvedor assume o trabalho;
- uma equipe assume uma Sprint;
- uma ferramenta de IA passa a colaborar no desenvolvimento;
- ocorre uma combinação dessas situações.

Quando houver transferência de contexto, o agente sucessor deve utilizar o Handoff juntamente com o código e a documentação do projeto.

O procedimento não constitui uma regra específica para ferramentas de IA. Ele representa a aplicação do mesmo processo de passagem de bastão utilizado entre diferentes agentes de desenvolvimento.

### Princípio

> **O processo de desenvolvimento deve ser independente da identidade do agente que executa o trabalho.**

A substituição de um agente por outro não deve exigir a reconstrução manual do contexto a partir de conversas anteriores.

O agente sucessor deve ser capaz de recuperar o trabalho utilizando o estado do código, a documentação do projeto e o Sprint Handoff.

---

## 🔁 Continuidade completa

Quando houver troca simultânea de estação e contexto, o processo deve combinar os dois mecanismos:

```text
              Estação anterior
                     │
                implementação
                     ↓
                 commit + push
                     │
                     ▼
                   GitHub
                     │
                     │
              Sprint Handoff
                     │
                     ▼
              Novo contexto
                     │
               Context Check
                     │
                     ▼
              Nova estação
                     │
                  git pull
                     │
                     ▼
              continuar trabalho
```

Dessa forma, a continuidade do projeto não depende exclusivamente da memória do desenvolvedor, de uma estação específica ou de um contexto específico.

O código, as decisões e o contexto necessário para continuidade devem permanecer registrados nos mecanismos apropriados.

---

# 📐 Padrões de Desenvolvimento

## Desenvolvimento incremental

Toda funcionalidade será implementada em pequenas etapas.

- Implementar pequenas entregas.
- Compilar frequentemente.
- Validar as alterações antes de prosseguir.
- Evitar grandes blocos de implementação sem validações intermediárias.

Exemplo:

```text
Criar a classe
      ↓
Compilar
      ↓
Criar um método
      ↓
Compilar
      ↓
Implementar o método
      ↓
Testar
      ↓
Prosseguir
```

Cada pequena entrega deve ser validada antes da próxima implementação.

## Origem de dados

Sempre que forem utilizados dados externos ao projeto (tabuleiros, arquivos, layouts, exemplos, datasets etc.), deve-se:

1. identificar claramente a origem;
2. validar se a fonte é confiável;
3. registrar a decisão na documentação (ADR ou User Story, quando aplicável);
4. somente depois iniciar a implementação.

---

# 📋 Processo de Decisão

Sempre que possível:

1. Entender o problema.
2. Discutir alternativas.
3. Escolher a arquitetura.
4. Somente então escrever código.

---

# 📚 Documentação

Toda documentação será mantida atualizada durante o projeto.

## 📂 Documentação do Projeto

Cada documento possui uma responsabilidade específica.

| Documento | Objetivo |
|---|---|
| Guia | Processo de desenvolvimento |
| Roadmap | Evolução macro do produto |
| Backlog | Lista priorizada das funcionalidades |
| Sprint | Planejamento da Sprint |
| User Story | Especificação da funcionalidade |
| ADR | Registro de decisões arquiteturais |
| Diário | Evolução do desenvolvimento |
| Changelog | Histórico das entregas |
| Marcos do projeto | Registro dos principais marcos do projeto |

### Responsabilidade da documentação

Os documentos possuem responsabilidades distintas e não devem ser utilizados como substitutos uns dos outros.

O **ADR** possui natureza transversal e deve ser criado ou atualizado sempre que uma decisão arquitetural relevante precisar ser registrada.

---

# 📁 Fluxo dos Documentos

O fluxo principal de planejamento e execução é:

```text
Roadmap
   ↓
Backlog
   ↓
Sprint
   ↓
User Story
   ↓
Implementação
   ↓
Diário
   ↓
Changelog
```

O ADR acompanha o processo de forma transversal sempre que houver decisões arquiteturais relevantes.

## Antes da implementação (Sprint Planning)

- Consultar o Roadmap.
- Consultar o Backlog.
- Planejar a Sprint.
- Criar User Story.
- Criar ADR, quando necessário.

## Durante a implementação

- Atualizar a User Story, alterando o status quando aplicável.
- Registrar decisões relevantes em ADR, quando necessário.
- Registrar a evolução do desenvolvimento no Diário, conforme aplicável.

## Encerramento da Sprint

- Atualizar a User Story.
- Atualizar a Sprint.
- Atualizar o Diário de Desenvolvimento.
- Atualizar o Changelog.
- Atualizar o Backlog quando houver mudança de status.
- Revisar o Roadmap quando aplicável.
- Atualizar ou encerrar ADRs quando necessário.

---

# 🧪 Qualidade

Antes de qualquer commit:

- revisão da implementação;
- build;
- testes;
- revisão técnica;
- revisão da documentação.

---

# ✅ Definition of Done (DoD)

Uma funcionalidade somente será considerada **concluída** quando atender a todos os critérios abaixo.

## Código

- [ ] Implementação concluída.
- [ ] Código segue os princípios de Programação Orientada a Objetos.
- [ ] Responsabilidades das classes respeitadas.
- [ ] Build executado com sucesso.

## Testes

- [ ] Testes manuais realizados.
- [ ] Funcionalidade validada conforme os critérios de aceitação.
- [ ] Não foram identificados erros de execução.

## Documentação

- [ ] User Story atualizada.
- [ ] Sprint atualizada.
- [ ] ADR criada ou atualizada, quando necessário.
- [ ] Diário de Desenvolvimento atualizado.
- [ ] Changelog atualizado.

## Revisão Técnica

- [ ] Code Review realizado.
- [ ] Arquitetura revisada.
- [ ] Estrutura do projeto revisada.
- [ ] Nenhuma pendência técnica identificada.

## Versionamento

- [ ] Arquivos revisados (`git status`).
- [ ] Alterações analisadas (`git diff`, quando necessário).
- [ ] Commit realizado utilizando Conventional Commits.
- [ ] Push enviado ao repositório remoto.

## ✔ Critério Final

Uma tarefa, User Story ou Sprint somente poderá ser marcada como **Concluída** quando **todos os itens acima estiverem atendidos**.

O objetivo do DoD é garantir qualidade, rastreabilidade e consistência durante todo o desenvolvimento do projeto.

---

# 🌳 Organização do Projeto

O projeto utiliza a estrutura padrão do Maven:

```text
src/
├── main/
│   └── java/
│       ├── model/
│       ├── ui/
│       ├── service/
│       ├── util/
│       ├── enums/
│       ├── persistence/
│       └── exception/
│
└── test/
    └── java/

docs/
```

Cada pacote deve possuir uma responsabilidade clara.

A estrutura pode evoluir conforme as necessidades arquiteturais do projeto, desde que novas responsabilidades sejam organizadas de forma coerente.

---

# 📝 Convenções de Commit

Os commits seguem o padrão Conventional Commits.

Exemplos:

- `feat`
- `fix`
- `docs`
- `refactor`
- `test`
- `chore`

---

# 🎓 Papéis Simulados

Durante o desenvolvimento serão simulados os papéis de:

- Product Owner;
- Tech Lead;
- Desenvolvedor Sênior;
- QA;
- Arquiteto;
- Professor.

Cada decisão será tomada considerando o papel mais adequado ao momento.

---

# 📖 Fontes Oficiais

Sempre que possível, o projeto utilizará como referência:

- documentação oficial da linguagem;
- enunciado oficial da DIO;
- especificações do desafio;
- documentação oficial das bibliotecas utilizadas.

Fontes externas deverão ser identificadas e registradas na documentação correspondente.

Quando uma fonte externa for utilizada, sua origem deverá ser registrada na documentação correspondente, como ADR, User Story ou Diário de Desenvolvimento, conforme a natureza da informação.

---

# 🚀 Objetivo Final

Mais do que concluir um jogo de Sudoku, o objetivo deste projeto é desenvolver competências em:

- Java;
- Programação Orientada a Objetos;
- Arquitetura de Software;
- Engenharia de Software;
- Git;
- Documentação Técnica;
- Organização de Projetos.
