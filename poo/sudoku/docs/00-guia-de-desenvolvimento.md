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

## 📐 Padrões de Desenvolvimento

### Desenvolvimento incremental

- Implementar pequenas entregas.
- Compilar frequentemente.
- Revisar antes de prosseguir.

### Origem de dados

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
|-----------|----------|
| Guia | Processo de desenvolvimento |
| Roadmap | Evolução macro do produto |
| Backlog | Lista priorizada das funcionalidades |
| Sprint | Planejamento da Sprint |
| User Story | Especificação da funcionalidade |
| ADR | Registro de decisões arquiteturais |
| Diário | Evolução do desenvolvimento |
| Changelog | Histórico das entregas |

# 📁 Fluxo dos Documentos
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

## Antes da implementação (Sprint Planning)

- Consultar o Backlog
- Planejar a Sprint
- Criar User Story
- Criar ADR (quando necessário)

## Durante a implementação

- Atualizar a User Story (alterando o status, quando aplicável)q

## Encerramento da Sprint

- Atualizar a User Story
- Atualizar Sprint
- Atualizar o Diário de Desenvolvimento
- Atualizar o Changelog
- Atualizar Backlog (quando houver mudança de status)
- Revisar Roadmap (quando aplicável)

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

---

## Testes

- [ ] Testes manuais realizados.
- [ ] Funcionalidade validada conforme os critérios de aceitação.
- [ ] Não foram identificados erros de execução.

---

## Documentação

- [ ] User Story atualizada.
- [ ] Sprint atualizada.
- [ ] ADR criada ou atualizada (quando necessário).
- [ ] Diário de Desenvolvimento atualizado.
- [ ] Changelog atualizado.

---

## Revisão Técnica

- [ ] Code Review realizado.
- [ ] Arquitetura revisada.
- [ ] Estrutura do projeto revisada.
- [ ] Nenhuma pendência técnica identificada.

---

## Versionamento

- [ ] Arquivos revisados (`git status`).
- [ ] Alterações analisadas (`git diff`, quando necessário).
- [ ] Commit realizado utilizando Conventional Commits.
- [ ] Push enviado ao repositório remoto.

---

## ✔ Critério Final

Uma tarefa, User Story ou Sprint somente poderá ser marcada como **Concluída** quando **todos os itens acima estiverem atendidos**.

O objetivo do DoD é garantir qualidade, rastreabilidade e consistência durante todo o desenvolvimento do projeto.

---

# 🌳 Organização do Projeto

```text
src/
├── model
├── ui
├── service
├── util
├── enums
└── exception

docs/
```

Cada pacote deve possuir uma responsabilidade clara.

---

# 📝 Convenções de Commit

Os commits seguem o padrão Conventional Commits.

Exemplos:

- feat
- fix
- docs
- refactor
- test
- chore

---

# 👨‍💻 Implementação Incremental

Toda funcionalidade será implementada em pequenas etapas.
Nunca implementar grandes blocos de código sem validações intermediárias.
Cada pequena entrega deve compilar antes da próxima implementação.

Exemplo:

1. Criar a classe.
2. Compilar.
3. Criar um método.
4. Compilar.
5. Implementar o método.
6. Testar.
7. Prosseguir.

---

# 🎓 Papéis Simulados

Durante o desenvolvimento serão simulados os papéis de:

- Product Owner
- Tech Lead
- Desenvolvedor Sênior
- QA
- Arquiteto
- Professor

Cada decisão será tomada considerando o papel mais adequado ao momento.

---
# 📖 Fontes Oficiais

Sempre que possível, o projeto utilizará como referência:

- documentação oficial da linguagem;
- enunciado oficial da DIO;
- especificações do desafio;
- documentação oficial das bibliotecas utilizadas.

Fontes externas deverão ser identificadas e registradas na documentação do projeto.  
Quando uma fonte externa for utilizada, sua origem deverá ser registrada na documentação 
correspondente (ADR, User Story ou Diário de Desenvolvimento).
---

# 🚀 Objetivo Final

Mais do que concluir um jogo de Sudoku, o objetivo deste projeto é desenvolver competências em:

- Java
- Programação Orientada a Objetos
- Arquitetura de Software
- Engenharia de Software
- Git
- Documentação Técnica
- Organização de Projetos