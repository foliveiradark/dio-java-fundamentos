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

Preparar a arquitetura existente para permitir a evolução da aplicação
de console para uma interface gráfica, preservando o domínio, as regras
do jogo e a persistência.

A nova interface deverá evoluir o projeto de uma aplicação orientada ao
console para um jogo desktop real, com experiência visual agradável,
intuitiva, exclusiva e preparada para distribuição futura.

### Entregas:

* [x] Preparar arquitetura para múltiplas interfaces (US-019);
* [x] Avaliar e definir o sistema de build — Maven;
* [x] Avaliar e definir a tecnologia da interface gráfica — JavaFX;
* [ ] Implementar a interface gráfica JavaFX (US-020);
* [ ] Integrar as funcionalidades existentes à interface gráfica;
* [ ] Preparar a aplicação para distribuição.

### Direção tecnológica definida

A US-019 estabeleceu as seguintes decisões para a próxima fase:

* **Sistema de build:** Maven;
* **Tecnologia gráfica:** JavaFX;
* **Arquitetura:** interface desacoplada da orquestração da aplicação;
* **Orquestração:** `JogoSudoku`;
* **Persistência:** independente da interface;
* **Domínio:** independente da tecnologia de interação.

---

# 📍 Fase 8 — Evolução da Experiência do Produto

Status: ⬜ Planejada

### Objetivo:

Adicionar funcionalidades que ampliem a experiência do jogador após a
primeira versão gráfica jogável estar consolidada.

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

- Java;
- Programação Orientada a Objetos;
- Testes automatizados (JUnit);
- Arquitetura de Software;
- Engenharia de Software;
- Git;
- Documentação Técnica;
- Organização de Projetos;
- Desenvolvimento Incremental;
- Documentação Arquitetural;
- Registro de Decisões (ADR);
- Desenvolvimento de aplicações desktop;
- Persistência de dados;
- Preparação de aplicações para distribuição.

Além do valor técnico para o portfólio, o projeto deverá resultar em uma
versão jogável do Sudoku que possa ser utilizada por um usuário final.