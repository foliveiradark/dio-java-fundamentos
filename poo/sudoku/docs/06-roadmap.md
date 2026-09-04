# 🗺️ Roadmap do Projeto

> Planejamento estratégico da evolução do projeto Sudoku.

---

# 🎯 Objetivo

Desenvolver um jogo de Sudoku em Java aplicando Programação Orientada a Objetos
e boas práticas de Engenharia de Software, evoluindo progressivamente de um
projeto acadêmico para um jogo desktop real, jogável e distribuível.

---

# 📍 Fase 1 — Fundação

Status: ✅ Concluída

### Entregas:

* arquitetura inicial;
* modelagem do domínio;
* carregamento do tabuleiro;
* estrutura do projeto.

---

# 📍 Fase 2 — Interação com o Jogador

Status: ✅ Concluída

### Entregas:

* menu principal;
* entrada de coordenadas;
* inserção e remoção de números;
* validações de entrada;
* interface em modo texto.

---

# 📍 Fase 3 — Regras do Sudoku

Status: ✅ Concluída

### Entregas:

* validação de jogadas;
* verificação de linhas;
* colunas;
* blocos;
* status da partida.

---

# 📍 Fase 4 — Finalização

Status: ✅ Concluída

### Entregas:

* limpeza do tabuleiro;
* encerramento automático;
* fluxo completo da partida.

---

# 📍 Fase 5 — Consolidação do MVP

Status: ✅ Concluída

### Entregas:

* documentação completa;
* backlog organizado;
* ADRs;
* diário de desenvolvimento;
* refinamento visual da interface;
* Marco 1 atingido.

---

# 📍 Fase 6 — Evolução do Produto

Status: 🟢 Concluída

### Objetivo:

Adicionar funcionalidades ao jogo preservando a arquitetura construída
e validando sua capacidade de evolução.

### Entregas:

* [x] Sistema de rascunhos (US-017);
* [x] Continuar partida (US-018);
* [x] Persistência das partidas.

---

# 📍 Fase 7 — Preparação e Interface Gráfica

Status: 🟡 Em andamento

### Objetivo:

Evoluir a aplicação de console para um jogo desktop com interface gráfica,
preservando o domínio, as regras do jogo e a persistência existentes.

A fase foi iniciada com a preparação arquitetural para múltiplas interfaces
e avançou para a implementação do primeiro vertical slice jogável em JavaFX.

A primeira versão gráfica deverá ser ampliada progressivamente, sem exigir
paridade funcional imediata com a interface Console.

### Entregas concluídas:

* [x] Preparar arquitetura para múltiplas interfaces (US-019);
* [x] Avaliar e definir o sistema de build — Maven;
* [x] Avaliar e definir a tecnologia da interface gráfica — JavaFX;
* [x] Implementar o primeiro vertical slice jogável com JavaFX (US-020).
* [x] Permitir remoção de jogadas pela interface gráfica;

### Próximas evoluções da fase:

* [ ] Ampliar as funcionalidades básicas de interação da GUI;
* [ ] Incorporar o sistema de candidatos à interface gráfica;
* [ ] Incorporar operações de limpeza e finalização da partida;
* [ ] Integrar progressivamente a persistência à interface gráfica;
* [ ] Evoluir a experiência de interação da GUI;
* [ ] Refinar a apresentação visual;
* [ ] Preparar a aplicação para distribuição;
* [ ] Avaliar empacotamento e execução fora do ambiente de desenvolvimento.

A sequência dessas evoluções será definida e priorizada no Product Backlog
conforme a evolução do produto e o resultado das Sprints.

### Direção tecnológica

A Fase 7 segue as decisões estabelecidas durante a US-019:

* **Sistema de build:** Maven;
* **Tecnologia da interface gráfica:** JavaFX;
* **Arquitetura:** interface desacoplada da orquestração da aplicação;
* **Orquestração:** `JogoSudoku`;
* **Persistência:** independente da interface;
* **Domínio:** independente da tecnologia de interação.

### Relação com o Product Backlog

As próximas evoluções da Fase 7 serão representadas por User Stories
específicas no Product Backlog, evitando concentrar toda a evolução da
interface gráfica em uma única User Story.

A priorização atual contempla, progressivamente:

* **US-021** — Remover número pela interface JavaFX;
* **US-022** — Utilizar candidatos pela interface JavaFX;
* **US-023** — Limpar jogadas pela interface JavaFX;
* **US-024** — Finalizar partida pela interface JavaFX;
* **US-025** — Salvar partida pela interface JavaFX;
* **US-026** — Continuar partida pela interface JavaFX;
* **US-027** — Refinar experiência de interação da GUI;
* **US-028** — Preparar distribuição da aplicação desktop.

---

# 📍 Fase 8 — Evolução da Experiência do Produto

Status: ⬜ Planejada

### Objetivo:

Adicionar funcionalidades que ampliem a experiência do jogador após a
consolidação da primeira versão gráfica e da infraestrutura necessária
para sua evolução.

### Possíveis evoluções:

* níveis de dificuldade;
* progressão;
* gerador automático de Sudoku;
* histórico de partidas;
* estatísticas;
* exportação;
* outras funcionalidades de experiência do jogador.

---

# 📍 Visão Futura

Status: 💡 Em consideração

### Possibilidades:

* interação com IA durante as partidas;
* recursos inteligentes de auxílio ao jogador;
* novas formas de interação;
* evolução da experiência do jogo.

Essas possibilidades não fazem parte do escopo atual e serão avaliadas
conforme a evolução técnica do projeto.

---

# 🚀 Resultado Esperado

Ao final do projeto, o repositório deverá demonstrar conhecimentos em:

* Java;
* Programação Orientada a Objetos;
* Testes automatizados (JUnit);
* Arquitetura de Software;
* Engenharia de Software;
* Git;
* Documentação Técnica;
* Organização de Projetos;
* Desenvolvimento Incremental;
* Documentação Arquitetural;
* Registro de Decisões (ADR);
* Desenvolvimento de aplicações desktop;
* Persistência de dados;
* Preparação de aplicações para distribuição.

Além do valor técnico para o portfólio, o projeto deverá resultar em uma
versão jogável do Sudoku que possa ser utilizada por um usuário final.
