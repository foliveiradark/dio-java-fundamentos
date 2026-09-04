# 📅 Diário de Desenvolvimento

---

### 📅 17/07/2026

## 🔄 Sprint 0

Nesta etapa foi definida a arquitetura inicial do projeto.

Foi decidido desenvolver o Sudoku de forma incremental, priorizando a qualidade do código e a documentação antes da implementação completa.

### Aprendizados:

* importância da modelagem antes da programação;
* definição de responsabilidades entre classes; 
* organização da documentação.

---

## 🔄 Sprint 1

A implementação começou pela classe `Casa`.

Durante o desenvolvimento surgiram decisões importantes sobre encapsulamento, validações e responsabilidade das classes.

Também foi implementada a estrutura inicial do `Tabuleiro`, responsável por criar automaticamente suas 81 casas.

### Aprendizados:

* validações pertencem ao objeto que protege seu próprio estado; 
* métodos privados melhoram a legibilidade; 
* desenvolvimento incremental reduz erros.

---

### 📅 20/07/2026

## 🔄 Conclusão da Sprint 1

### Entrega: US-001 – Visualizar o Tabuleiro

### O que foi entregue  
- ✅ Arquitetura da camada ui  
  ✅ Classe ConsolePrinter  
  ✅ Impressão de tabuleiro 9×9  
  ✅ Separadores dos blocos 3×3  
  ✅ Primeira integração entre `Main`, `ConsolePrinter`, `Tabuleiro` e `Casa`

### Aprendizados:
* separar responsabilidades entre Model e UI; 
* criar uma camada de apresentação (`ConsolePrinter`); 
* utilizar encapsulamento através do método `getCasa()`; 
* desenvolver de forma incremental; 
* revisar pequenas entregas através de Pull Requests simuladas; 
* pensar primeiro no algoritmo e depois na implementação.

Também foi realizado o primeiro teste de integração do projeto, comprovando que as classes `Casa`, `Tabuleiro`, `ConsolePrinter` e `Main` trabalham corretamente em conjunto.

---

### 📅 21/07/2026

## 🔄 Encerramento da Sprint 2

Foi concluída a implementação do carregamento automático do tabuleiro inicial.

O sistema passou a criar um tabuleiro completo utilizando uma matriz de dados e preencher automaticamente cada objeto `Casa`.

Também foi validada a integração entre as camadas `util`, `model` e `ui`, permitindo a exibição correta do Sudoku no terminal.

### Aprendizados:

* separar a origem dos dados do domínio da aplicação;
* utilizar métodos de acesso para preservar o encapsulamento;
* construir funcionalidades de forma incremental facilita a identificação de erros;
* interpretar o stack trace do Java acelera a depuração.

---

### 📅 22/07/2026

## 🔄 Encerramento da Sprint 3

Foi implementado o primeiro fluxo de execução da aplicação.

A partir desta Sprint o jogador consegue iniciar o sistema, visualizar o menu principal, informar uma opção e permanecer na aplicação até solicitar seu encerramento.

Também foi criada a estrutura inicial responsável pela interação com o usuário através das classes `Menu`, `ConsoleInput` e `ConsolePrinter`.

### Aprendizados

* coordenação do fluxo da aplicação;
* utilização de laços de repetição;
* separação entre entrada, saída e lógica do sistema;
* evolução da arquitetura sem criar abstrações prematuras;
* importância da responsabilidade única para cada classe.

---
### 📅 23/07/2026

## Encerramento da Sprint 04

### Testes da US-004

Durante os testes manuais da funcionalidade de inserção de números foi identificado um ponto de melhoria na experiência do usuário.

### Aprendizados

* Diferença entre regra de domínio e experiência do usuário.
* Importância de validar funcionalidades por meio de testes. 
* Refatoração pode eliminar bugs sem adicionar código de tratamento. 
* Objetos devem nascer em um estado consistente. 
* Cada método deve possuir uma única responsabilidade.

### Observação

O tabuleiro é exibido sem identificação visual das linhas e colunas, tornando mais difícil localizar a posição desejada para inserir um número.

### Decisão

A melhoria não será implementada nesta Sprint para manter o foco no escopo da US-004.

Será avaliada futuramente para inclusão no Product Backlog.

### Desafios encontrados

- Identificação de inconsistência na criação das casas fixas.
- Refatoração da inicialização do tabuleiro para preservar a imutabilidade do domínio.

---

### 📅 24/07/2026

🔄 Encerramento da Sprint 5

### Aprendizados

- Tratamento de exceções melhora a experiência do usuário sem alterar as regras de negócio.
- Exceções devem ser tratadas na camada capaz de decidir como reagir ao erro.
- Separar domínio, serviço e interface torna o código mais flexível e fácil de evoluir.
- Uma boa arquitetura reduz a necessidade de alterações em diferentes partes do sistema.
- Testes manuais ajudam a identificar oportunidades de melhoria além do escopo inicial.

---

### 📅 25/07/2026

## 🔄 Encerramento da Sprint 6

Foi concluída a melhoria da identificação visual das coordenadas do tabuleiro.

A interface passou a exibir as colunas numeradas de **1 a 9** e as linhas identificadas pelas letras **A a I**, 
facilitando a localização das casas durante a partida sem alterar o modelo interno da aplicação.

### Aprendizados

- pequenas melhorias de interface podem aumentar significativamente a usabilidade;
- separar a representação visual do modelo de domínio facilita a evolução do sistema;
- reutilizar métodos existentes reduz duplicação de código e simplifica a manutenção;
- testes manuais ajudam a identificar oportunidades de melhoria além dos requisitos inicialmente planejados.

---

### Observação

Durante os testes manuais foram identificadas duas oportunidades de evolução para a interface do usuário que ficaram fora do escopo desta Sprint.

#### Melhorias Futuras

**01 — Refinamento visual do tabuleiro**

Melhorar a aparência visual do tabuleiro utilizando caracteres Unicode para destacar os blocos 3×3, padronizar o espaçamento e tornar a interface mais agradável.

```text
    1 2 3   4 5 6   7 8 9
  ╔═══════╦═══════╦═══════╗
A ║ 5 3 ∙ ║ ∙ 7 ∙ ║ ∙ ∙ ∙ ║
B ║ 6 ∙ ∙ ║ 1 9 5 ║ ∙ ∙ ∙ ║
C ║ ∙ 9 8 ║ ∙ ∙ ∙ ║ ∙ 6 ∙ ║
  ╠═══════╬═══════╬═══════╣
D ║ 8 ∙ ∙ ║ ∙ 6 ∙ ║ ∙ ∙ 3 ║
E ║ 4 ∙ ∙ ║ 8 ∙ 3 ║ ∙ ∙ 1 ║
F ║ 7 ∙ ∙ ║ ∙ 2 ∙ ║ ∙ ∙ 6 ║
  ╠═══════╬═══════╬═══════╣
G ║ ∙ 6 ∙ ║ ∙ ∙ ∙ ║ 2 8 ∙ ║
H ║ ∙ ∙ ∙ ║ 4 1 9 ║ ∙ ∙ 5 ║
I ║ ∙ ∙ ∙ ║ ∙ 8 ∙ ║ ∙ 7 9 ║
  ╚═══════╩═══════╩═══════╝
  
> ***02-Coordenadas orientadas ao jogador***
>
> Permitir que o jogador informe as coordenadas utilizando letras (A–I) para as linhas e
> números (1–9) para as colunas, convertendo automaticamente esses valores para os índices internos
> utilizados pelo domínio.
```
---

### 📅 26/07/2026

🔄 Encerramento da Sprint 7

### Aprendizados

Durante a implementação da funcionalidade de remoção de jogadas foi possível
reforçar conceitos importantes relacionados à separação de responsabilidades
entre as classes da aplicação.

O fluxo da partida passou a decidir entre inserir ou remover um número,
enquanto os métodos `executarJogada()` e `removerJogada()` permaneceram
responsáveis apenas por suas respectivas operações.

Também foi identificado um comportamento do `Scanner` ao combinar
`nextInt()` com `nextLine()`. A solução adotada consistiu em padronizar a
leitura das entradas utilizando `nextLine()` juntamente com
`Integer.parseInt()`, tornando a classe `ConsoleInput` mais consistente e
facilitando futuras evoluções.

### Observação

A implementação foi concluída sem a necessidade de alterações adicionais no
Product Backlog.

---

### 📅 30/07/2026

## 🔄 Encerramento da Sprint 8

Foi implementado o mecanismo de verificação do estado da partida.

A aplicação passou a identificar automaticamente quando o Sudoku permanece incompleto, quando foi concluído corretamente e quando apresenta inconsistências nas regras do jogo.

A solução reutilizou os mecanismos de validação já existentes para linhas, colunas e blocos, evitando duplicação de lógica e preservando a arquitetura construída nas Sprints anteriores.

### Aprendizados

- reutilizar funcionalidades existentes reduz complexidade;
- um enum facilita a representação de estados do domínio;
- separar a determinação do estado da sua apresentação melhora a organização da aplicação;
- testes controlados podem utilizar massas de dados temporárias sem necessidade de alterar a arquitetura do sistema.

### Observação

Para validar os estados `COMPLETA_VALIDA` e `COMPLETA_INVALIDA` foi utilizada temporariamente uma solução do tabuleiro obtida por meio do resolvedor Playoku. Após a conclusão dos testes, o tabuleiro original foi restaurado.

---

### 📅 30/07/2026

## 🔄 Encerramento da Sprint 9

Foi implementada a funcionalidade de limpeza do tabuleiro.

A aplicação passou a permitir que o jogador remova todas as jogadas realizadas durante a partida, preservando automaticamente todas as casas fixas do tabuleiro inicial.

A operação foi concentrada na classe `Tabuleiro`, mantendo a responsabilidade de manipulação do estado do jogo no domínio da aplicação. A camada de serviço (`JogoSudoku`) permaneceu responsável apenas por coordenar o fluxo da interação com o usuário.

Também foi adicionada uma confirmação antes da limpeza para evitar a remoção acidental das jogadas realizadas.

### Aprendizados

- responsabilidades do domínio devem permanecer concentradas na classe que representa o estado da aplicação;
- reutilizar o método `removerNumero()` evitou duplicação de lógica e preservou o encapsulamento da classe `Casa`;
- confirmações para operações destrutivas melhoram a experiência do usuário sem aumentar a complexidade da arquitetura;
- manter a coordenação da operação em `JogoSudoku` e a execução em `Tabuleiro` reduz o acoplamento entre as camadas.

### Observação

A funcionalidade foi validada através de testes manuais contemplando diferentes cenários, incluindo:

- limpeza após múltiplas jogadas;
- cancelamento da confirmação de limpeza;
- preservação das casas fixas;
- restauração apenas das casas editáveis;
- atualização imediata da interface após a limpeza.

Foi adicionada uma confirmação antes da limpeza completa do tabuleiro para evitar que o jogador perca acidentalmente todas as jogadas realizadas.

#### Decisão de UX

Antes de executar a limpeza, o sistema solicita uma confirmação ao jogador.

Essa decisão não altera as regras de negócio do Sudoku, mas melhora a experiência de uso da aplicação ao evitar operações destrutivas executadas por engano.

---

### 📅 31/07/2026

## 🔄 Encerramento da Sprint 10

Foi implementado o encerramento automático da partida.

A aplicação passou a identificar quando o Sudoku é concluído corretamente e, nesse momento, exibe uma mensagem de conclusão, encerra o fluxo da partida e retorna automaticamente ao Menu Principal.

A decisão reutilizou o mecanismo de verificação de status implementado na Sprint anterior, evitando duplicação de regras de negócio.

### Aprendizados

- reutilizar o resultado de `verificarStatusPartida()` simplifica o fluxo da aplicação;
- o encerramento da partida deve ocorrer apenas quando o domínio indicar um estado válido;
- o laço principal pode ser finalizado de forma simples utilizando a variável de controle da partida;
- separar a lógica de domínio da navegação da aplicação facilita futuras evoluções.

### Observação

Durante os testes foi identificada uma oportunidade de melhoria relacionada ao tratamento de entradas vazias e inválidas informadas pelo usuário.

Essa funcionalidade não fazia parte do escopo da Sprint e foi registrada no Product Backlog como melhoria futura.

---

### 📅 31/07/2026

## 🔄 Encerramento da Sprint 11

Foi implementado o tratamento de entradas vazias e inválidas realizadas pelo usuário.

A aplicação passou a validar todas as entradas numéricas diretamente na classe ConsoleInput, impedindo que valores vazios ou não numéricos provoquem o encerramento inesperado da aplicação.

Sempre que uma entrada inválida é informada, o sistema exibe uma mensagem amigável e solicita novamente o valor, preservando o fluxo da partida sem alterar as regras de negócio.

### Aprendizados

- concentrar a validação das entradas em um único ponto reduz duplicação de código;
- laços de repetição são uma solução simples e eficiente para garantir entradas válidas;
- separar a validação da entrada da lógica de negócio mantém a arquitetura mais organizada;
- tratar exceções na camada de interface evita que erros de interação afetem o domínio da aplicação.

### Observação

Durante o Sprint Planning foi decidido que toda a validação das entradas permaneceria 
concentrada na classe `ConsoleInput`, preservando a separação de responsabilidades da arquitetura.

Os testes manuais contemplaram os seguintes cenários:

- entrada vazia;
- entrada contendo apenas espaços;
- entrada não numérica;
- entrada decimal;
- entrada numérica válida.

A funcionalidade foi validada sem necessidade de alterações nas regras de negócio existentes.

---

### 📅 01/08/2026

## 🔄 Encerramento da Sprint 12

Foi implementada a entrada de coordenadas utilizando o formato **A1–I9**.

A aplicação passou a permitir que o jogador informe diretamente a posição desejada utilizando letras para identificar as linhas (**A–I**) e números para identificar as colunas (**1–9**), tornando a interação mais intuitiva e alinhada à forma como jogadores de Sudoku normalmente identificam as posições do tabuleiro.

Internamente, as coordenadas continuam sendo convertidas para índices numéricos antes da execução das regras de negócio, preservando a arquitetura construída desde as primeiras Sprints.

### Aprendizados

* adaptar a interface ao modelo mental do usuário melhora significativamente a experiência de uso;
* manter o domínio independente da forma como os dados são informados facilita futuras evoluções;
* centralizar a validação das coordenadas na classe `ConsoleInput` mantém a separação de responsabilidades da aplicação;
* pequenas refatorações no fluxo podem simplificar a interação sem alterar as regras de negócio.

### Observação

Durante a implementação foi identificado que o método `converterCoordenada()` retorna um vetor (`int[]`) contendo os índices de linha e coluna.

Para o contexto atual do projeto, essa abordagem foi considerada suficiente por manter a implementação simples e compatível com o objetivo de aprendizado. Como evolução arquitetural futura, poderá ser criada uma classe de valor (`Coordenada`) para representar explicitamente uma posição do tabuleiro, tornando a API do domínio mais expressiva.

Também foi identificado, durante os testes manuais, que o método `lerConfirmacao()` ainda aceita qualquer entrada diferente de `S` como resposta negativa. Essa melhoria foi registrada para evolução futura, visando padronizar o comportamento de validação de todas as entradas da aplicação.

Os testes manuais contemplaram os seguintes cenários:

* coordenadas válidas utilizando letras maiúsculas;
* coordenadas válidas utilizando letras minúsculas;
* entradas com espaços antes e depois da coordenada;
* coordenadas fora do intervalo permitido;
* formatos inválidos;
* entradas vazias;
* repetição da solicitação até que uma coordenada válida fosse informada.

A funcionalidade foi validada sem necessidade de alterações nas regras de negócio existentes.

---

### 📅 02/08/2026

## 🔄 Encerramento da Sprint 13

Foi implementada a validação das respostas de confirmação (`S/N`) utilizadas pela aplicação.

A partir desta Sprint, todas as solicitações de confirmação passaram a aceitar apenas as respostas `S` e `N`, independentemente de letras maiúsculas ou minúsculas, ignorando espaços antes e depois da entrada.

Quando uma resposta inválida é informada, o sistema exibe uma mensagem amigável e solicita novamente a confirmação, preservando o fluxo da aplicação e evitando interpretações incorretas durante a interação com o jogador.

### Aprendizados

* reutilizar o padrão de validação implementado em `lerInteiro()` e `lerCoordenada()` aumenta a consistência da interface;
* concentrar toda a validação de entradas na classe `ConsoleInput` reduz duplicação de código e preserva a separação de responsabilidades;
* normalizar a entrada utilizando `trim()` e `toUpperCase()` simplifica a lógica de validação;
* testes manuais ajudam a identificar melhorias de usabilidade além do escopo originalmente planejado.

### Observação

Durante os testes foi identificada uma oportunidade de melhoria no **Menu Principal**.

Atualmente, quando o jogador informa uma opção inexistente, a aplicação apenas redesenha o menu, sem informar que a opção é inválida.

Essa funcionalidade foi considerada fora do escopo desta Sprint e registrada no Product Backlog para implementação futura, mantendo a evolução incremental da aplicação.

---

### 📅 03/08/2026

## 🔄 Encerramento da Sprint 14

Foi implementada a validação das opções do Menu Principal.

A aplicação passou a aceitar apenas as opções disponíveis (`0`, `1` e `2`), tratando entradas vazias, não numéricas e opções inexistentes de forma amigável, mantendo a aplicação em execução até que uma opção válida seja informada.

Também foi realizada uma pequena refatoração no fluxo do Menu Principal, substituindo a 
estrutura baseada em `if/else` por `switch`, tornando o código mais legível e preparado para a evolução das funcionalidades futuras.

### Aprendizados
- o `switch` representa melhor fluxos baseados em seleção de opções;
- centralizar a validação na camada de entrada simplifica a lógica do domínio;
- pequenas refatorações contínuas aumentam a legibilidade sem alterar o comportamento da aplicação;
- validar a interação do usuário é tão importante quanto validar as regras de negócio.

### Observação

A validação do Menu Principal manteve o mesmo padrão arquitetural adotado nas User Stories 
anteriores, concentrando toda a responsabilidade pela leitura e validação das entradas na 
classe 'ConsoleInput'.

Os testes manuais contemplaram:

* entradas vazias;
* entradas contendo apenas espaços;
* letras;
* símbolos;
* números decimais;
* números negativos;
* opções inexistentes;
* opções válidas (`0`, `1` e `2`).

Todos os cenários previstos foram validados com sucesso.

---

### 📅 03/08/2026

## 🔄 Encerramento da Sprint 15

Foi concluído o refinamento visual da interface do tabuleiro.

A impressão do Sudoku passou a utilizar caracteres Unicode para destacar a divisão entre os blocos 3×3, tornando a leitura mais organizada e agradável. Também foram adicionadas as identificações das colunas no cabeçalho e no rodapé, além das identificações das linhas nos lados esquerdo e direito do tabuleiro, facilitando a localização das coordenadas durante a partida.

Toda a implementação permaneceu concentrada na classe `ConsolePrinter`, preservando a separação entre apresentação e regras de negócio.

### Aprendizados

- melhorias de usabilidade também agregam valor ao software, mesmo sem alterar regras de negócio;
- pequenas alterações visuais podem reduzir o esforço cognitivo do usuário durante a interação;
- concentrar toda a responsabilidade de impressão na camada de interface facilita futuras evoluções da aplicação;
- manter a arquitetura consistente torna as refatorações mais simples e seguras.

### Observação

Durante a Sprint foi avaliada a possibilidade de diferenciar visualmente os números fixos das jogadas realizadas pelo jogador.

Embora essa abordagem pudesse ser implementada na interface em modo texto, optou-se por não adicioná-la neste momento para evitar poluição visual e preservar a simplicidade da experiência do usuário.

Essa diferenciação poderá ser implementada de forma mais elegante em uma futura interface gráfica (Swing), utilizando recursos como cores, estilos de fonte e bloqueio visual das casas fixas.

Os testes manuais contemplaram:

* impressão do tabuleiro inicial;
* impressão após inserção de números;
* impressão após remoção de jogadas;
* alinhamento das linhas e colunas;
* separação visual dos blocos 3×3;
* identificação das coordenadas nos quatro lados do tabuleiro.

Todos os cenários previstos foram validados com sucesso.

---

### 📅 03/08/2026

## 🏁 Encerramento do Marco 1 — MVP Console

Após a conclusão da Sprint 15, o projeto atingiu o primeiro marco planejado: a entrega de um Produto Mínimo Viável funcional em modo texto.

Ao longo das quinze Sprints foram implementadas todas as funcionalidades previstas para o MVP, mantendo a arquitetura estável e evoluindo incrementalmente a aplicação.

Além da implementação das funcionalidades, o projeto consolidou uma documentação técnica composta por requisitos, modelagem, arquitetura, backlog, roadmap, diário de desenvolvimento, ADRs e revisões de Sprint, garantindo rastreabilidade das decisões tomadas durante o desenvolvimento.

### Aprendizados

* desenvolvimento incremental reduz riscos e facilita refatorações;
* registrar decisões arquiteturais evita retrabalho e preserva a consistência do projeto;
* documentação contínua acompanha a evolução do software e não apenas sua entrega;
* pequenas melhorias de arquitetura e usabilidade, realizadas ao longo das Sprints, contribuíram para manter o código organizado sem comprometer a lógica de negócio.

### Próxima etapa

Com o MVP consolidado, o projeto inicia um novo ciclo de evolução voltado para funcionalidades complementares, persistência, testes automatizados e futuras interfaces gráficas, preservando a arquitetura construída durante o primeiro marco.

---

---

### 📅 04/08/2026

## 🔄 Sprint 16 — Reorganização do Roadmap

Após a conclusão do MVP Console, a Sprint 16 foi inicialmente planejada para iniciar a evolução da aplicação em direção à interface gráfica utilizando Swing.

Durante a análise do Product Backlog, porém, foi identificado que a implementação da interface gráfica representaria uma mudança significativa de escopo e de natureza técnica em relação ao ciclo anterior.

Como estratégia de evolução incremental, decidiu-se remanejar a **US-016 — Interface gráfica (Swing)** para uma etapa posterior, permitindo que funcionalidades complementares ao Sudoku em modo console fossem desenvolvidas antes da mudança de interface.

A US-017 — Sistema de rascunhos, originalmente posicionada como melhoria futura, foi antecipada para a Sprint 17.

### Aprendizados

- nem toda funcionalidade planejada precisa ser implementada imediatamente após entrar no roadmap;
- o Product Backlog deve permanecer adaptável conforme novas informações surgem durante o desenvolvimento;
- mudanças significativas de arquitetura ou tecnologia devem ser planejadas antes da implementação;
- priorizar funcionalidades menores permite continuar evoluindo o produto sem interromper o ciclo de aprendizado;
- uma interface gráfica pode reutilizar grande parte das regras de negócio existentes quando a separação entre domínio e interface é preservada.

### Decisão

A **US-016 — Interface gráfica (Swing)** permanece no Product Backlog, mas foi remanejada para uma etapa posterior.

A **US-017 — Sistema de rascunhos** foi priorizada para a Sprint 17 por representar uma evolução funcional do Sudoku que pode ser implementada sobre a arquitetura atual.

Essa decisão mantém o desenvolvimento incremental e permite validar novas funcionalidades antes da introdução de uma nova tecnologia de interface.

---

### 📅 13/08/2026

## 🔄 Encerramento da Sprint 17

### Entrega: US-017 — Sistema de rascunhos

Foi implementado o sistema de rascunhos do Sudoku, permitindo que o jogador registre múltiplos números candidatos nas casas editáveis durante a resolução da partida.

A funcionalidade foi integrada ao fluxo existente da aplicação sem alterar as regras fundamentais do Sudoku.

No domínio, a classe `Casa` passou a manter os candidatos utilizando `Set<Integer>` e disponibilizou uma operação de toggle para adicionar ou remover individualmente um candidato.

Também foram implementadas as regras para impedir candidatos em casas preenchidas e para remover automaticamente os candidatos quando um número definitivo é atribuído.

Na interface de console, a sintaxe `*1` até `*9` foi adotada para representar uma jogada de candidato. Essa sintaxe permanece restrita à camada de entrada, sendo convertida para a intenção da operação por meio de `TipoJogada`.

A apresentação dos candidatos também foi incorporada ao tabuleiro utilizando uma grade interna 3×3, permitindo visualizar múltiplos candidatos simultaneamente sem alterar a representação utilizada pelo domínio.

### Aprendizados

- um `Set<Integer>` é adequado para representar uma coleção de candidatos sem permitir duplicidades;
- a operação de toggle simplifica a adição e remoção individual de candidatos;
- regras relacionadas ao estado da entidade devem permanecer protegidas pelo próprio domínio;
- a sintaxe utilizada para interação com o console não deve contaminar as regras de negócio;
- representar a intenção da operação por meio de um tipo específico torna o fluxo mais preparado para futuras interfaces;
- a camada de apresentação pode evoluir visualmente sem alterar a estrutura interna do domínio;
- funcionalidades podem ser integradas incrementalmente sem necessidade de grandes alterações na arquitetura existente;
- validações manuais integradas ao fluxo real da aplicação ajudam a identificar problemas que testes isolados podem não revelar.

### Validações realizadas

Foram validados os principais cenários da funcionalidade:

- inclusão de um candidato;
- inclusão de múltiplos candidatos;
- remoção individual de candidato;
- tentativa de candidato em casa fixa;
- tentativa de candidato em casa preenchida;
- entrada inválida de candidato;
- preenchimento definitivo de uma casa que possuía candidatos;
- atualização da representação visual do tabuleiro;
- integração da funcionalidade ao fluxo normal da partida.

Todos os cenários previstos foram validados com sucesso.

### Observação

A implementação da US-017 também reforçou uma decisão arquitetural importante para a evolução futura do projeto: a interface deve informar **a intenção da operação**, enquanto o domínio permanece responsável por executar e validar essa operação.

Essa separação permitirá que uma futura interface gráfica utilize as mesmas regras de negócio sem depender da sintaxe `*1`–`*9` adotada atualmente pelo console.

### Próxima etapa

Com a US-017 concluída, a próxima Sprint deverá ser definida a partir do estado atual do Product Backlog e das prioridades de evolução do projeto.

---

### 📅 21/08/2026

## 🔄 Encerramento da Sprint 18

### Entrega: US-018 — Continuar partida

A Sprint 18 marcou a introdução da persistência de dados no projeto, ampliando o Sudoku Console para permitir que o progresso de uma partida seja salvo e posteriormente restaurado.

Foi desenvolvida a modelagem necessária para separar a configuração permanente do Sudoku do estado produzido durante uma partida.

A estrutura de persistência foi implementada no PostgreSQL e integrada à aplicação Java utilizando JDBC e o padrão Repository.

A aplicação passou a permitir:

* salvar uma partida em andamento;
* restaurar uma partida anteriormente salva;
* preservar jogadas definitivas;
* preservar candidatos;
* sobrescrever uma partida existente;
* solicitar confirmação antes da sobrescrita;
* cancelar uma sobrescrita mantendo o último estado salvo.

Também foi validado o comportamento de uma partida sem dados persistidos, garantindo que a aplicação informe a ausência de uma partida salva e retorne ao fluxo apropriado.

### Aprendizados

* persistência exige separar claramente a configuração permanente do sistema do estado produzido durante sua execução;
* a modelagem relacional deve representar as relações do domínio sem simplesmente reproduzir a estrutura das classes Java;
* `PRIMARY KEY`, `FOREIGN KEY`, `UNIQUE`, `CHECK` e referências compostas podem ser utilizadas pelo banco para proteger a integridade dos dados;
* JDBC estabelece a comunicação entre Java e PostgreSQL, enquanto o Repository concentra as operações relacionadas à persistência;
* transações, `SAVEPOINT` e `ROLLBACK` são recursos importantes para validar operações de banco de forma controlada;
* separar a configuração do tabuleiro do progresso da partida permite reutilizar um mesmo desafio sem duplicar sua configuração;
* operações de Save/Load precisam considerar diferentes estados, incluindo ausência de dados, salvamento inicial, sobrescrita e cancelamento;
* a persistência pode ser introduzida incrementalmente sem transferir responsabilidades de banco de dados para o domínio;
* novas tecnologias podem ser incorporadas ao projeto preservando a arquitetura existente quando as responsabilidades entre as camadas permanecem bem definidas.

### Decisões importantes

A Sprint consolidou a separação entre:

```text
Configuração permanente

TABULEIRO
    ↓
CASA
```

e:

```text
Progresso da partida

PARTIDA
    ↓
ESTADO_CASA
    ↓
CANDIDATO
```

Essa separação permite que a configuração original do Sudoku permaneça independente das alterações realizadas pelo jogador durante uma partida.

Também foi consolidada uma regra de domínio identificada durante os testes: uma jogada definitiva existente não pode ser substituída diretamente.

O jogador deve primeiro remover a jogada existente para então realizar uma nova inserção.

Essa decisão mantém coerência com a operação explícita de remoção já disponível na interface e preserva no domínio a responsabilidade de proteger o estado da `Casa`.

### Validações realizadas

Foram validados os principais fluxos da US-018:

* criação e persistência da configuração do tabuleiro;
* criação de uma partida;
* persistência de jogadas definitivas;
* persistência de candidatos;
* carregamento de uma partida;
* reconstrução do estado do tabuleiro;
* salvamento inicial;
* sobrescrita de uma partida existente;
* confirmação da sobrescrita;
* cancelamento da sobrescrita;
* preservação do último estado salvo;
* descarte de alterações não salvas;
* carregamento sem existência de partida salva;
* proteção contra substituição direta de jogadas definitivas;
* remoção da jogada antes de uma nova inserção;
* rejeição de candidatos em casas preenchidas;
* remoção de candidatos ao realizar uma jogada definitiva.

Todos os cenários previstos para a funcionalidade foram validados com sucesso.

### Resultado

Com a conclusão da Sprint 18, o projeto passou a possuir seu primeiro mecanismo de persistência de dados.

A arquitetura evoluiu de:

```text
Java
  ↓
Memória
  ↓
Tabuleiro
```

para:

```text
Java
  ↓
JDBC
  ↓
PostgreSQL
  ↓
TABULEIRO → CASA
```

e:

```text
Java
  ↓
JDBC
  ↓
PostgreSQL
  ↓
PARTIDA
  ↓
ESTADO_CASA
  ↓
CANDIDATO
```

A Sprint também representou uma evolução importante no aprendizado técnico, pois o desenvolvimento passou a envolver, além da programação orientada a objetos, conceitos de modelagem relacional, SQL, integridade de dados, JDBC, Repository e persistência de estado.

### Próxima etapa

Com a Sprint 18 encerrada e seus artefatos preparados para versionamento, a próxima etapa deverá ser definida a partir do estado atualizado do Product Backlog e das prioridades de evolução do projeto.

---

### 📅 24/08/2026

## 🔄 Encerramento da Sprint 19

### Entrega: US-019 — Preparar arquitetura para múltiplas interfaces

A Sprint 19 foi dedicada à preparação arquitetural da aplicação para
permitir a evolução da interface de console para uma futura interface
gráfica, sem duplicação das regras do Sudoku ou dependência da camada de
persistência.

Durante a Sprint foi realizada uma análise das responsabilidades
existentes no `JogoSudoku`, identificando o acoplamento entre a
orquestração da aplicação e os componentes específicos da interface de
console.

A partir dessa análise foram definidos contratos para separar a
interação com o usuário da execução do fluxo da aplicação.

Foram introduzidas as interfaces:

* `InterfaceUsuario`;
* `InterfaceApresentacao`.

A implementação existente foi adaptada para utilizar esses contratos:

* `ConsoleInput` implementa `InterfaceUsuario`;
* `ConsolePrinter` implementa `InterfaceApresentacao`.

O `JogoSudoku` passou a utilizar as abstrações de interface em vez de
depender diretamente das implementações específicas do Console.

Essa alteração permitiu preservar a implementação atual de console
enquanto prepara a aplicação para receber uma segunda interface.

### Aprendizados

* abstrações devem ser introduzidas a partir de necessidades
  arquiteturais reais, evitando complexidade prematura;
* separar contratos de interação das implementações concretas reduz o
  acoplamento entre aplicação e interface;
* a interface deve ser responsável pela interação e apresentação,
  enquanto a aplicação coordena os casos de uso;
* o domínio e a persistência devem permanecer independentes da
  tecnologia utilizada para interação com o usuário;
* refatorações arquiteturais podem ser realizadas incrementalmente sem
  alterar o comportamento funcional existente;
* validar o fluxo completo após uma refatoração é fundamental para
  identificar regressões;
* decisões tecnológicas da próxima fase devem considerar não apenas a
  tecnologia gráfica, mas também build, dependências, testes, execução e
  distribuição.

### Decisões arquiteturais

Foi consolidada a separação entre interface, aplicação, domínio e
persistência.

A direção arquitetural adotada passou a ser:

```text
Interface
    ↓
Aplicação
    ↓
Domínio / Persistência
```

O `JogoSudoku` permanece responsável pela orquestração do fluxo da
aplicação, enquanto as implementações de interface ficam responsáveis
pela interação específica com o usuário.

Não foram identificados novos pontos de acoplamento relevantes que
justificassem a criação de abstrações adicionais nesta etapa.

Essa decisão foi registrada no:

**ADR-011 — Separação entre interface e aplicação**

### Avaliação tecnológica

Como parte da preparação para a próxima fase, foram avaliadas as
alternativas de sistema de build e tecnologia gráfica.

Para o sistema de build, foram consideradas Maven e Gradle. Foi definido
que **Maven** é a opção recomendada para a próxima fase, principalmente
pela simplicidade, convenção e adequação ao estágio atual do projeto.

A migração ainda não foi implementada durante a Sprint 19.

Também foram avaliadas as alternativas **Swing e JavaFX** para a futura
interface gráfica.

Considerando a evolução prevista do produto, a capacidade de evolução
visual e o objetivo de construção de um projeto desktop moderno em Java,
foi definida a utilização de **JavaFX** na próxima fase.

A decisão não altera a arquitetura da US-019. A futura interface JavaFX
deverá utilizar os contratos da aplicação existentes e não deverá
reimplementar regras do Sudoku.

### Validações realizadas

Após a refatoração arquitetural, foi executado manualmente o fluxo
completo da aplicação através da interface Console.

Foram validados:

* criação de nova partida;
* exibição do tabuleiro;
* inserção de número;
* inserção de candidato;
* remoção de candidato;
* remoção de jogada;
* limpeza das jogadas;
* consulta do status;
* salvamento da partida;
* retorno ao menu principal;
* continuação da partida salva;
* recuperação do estado persistido;
* retorno ao menu principal;
* encerramento da aplicação.

Também foi verificado que regras existentes da aplicação continuaram
funcionando após o desacoplamento da interface.

A partida persistida foi carregada posteriormente através da opção
`Continuar`, confirmando a preservação da integração entre a aplicação
refatorada e a camada de persistência.

### Build

Foi realizada a verificação da compilação do projeto após as alterações
arquiteturais.

O build atual continua sendo realizado através da configuração existente
do projeto e do ambiente de desenvolvimento.

A necessidade de substituir esse processo por um sistema de build
independente da IDE foi registrada como parte da próxima fase, com
**Maven** definido como opção recomendada.

### Resultado

A Sprint 19 concluiu a preparação arquitetural necessária para que o
projeto possa evoluir para uma segunda interface sem duplicação das
regras de negócio.

A arquitetura passou a possuir uma separação mais clara entre:

```text
Console / Futura GUI
        ↓
Interface
        ↓
JogoSudoku
        ↓
Domínio / Persistência
```

O comportamento funcional existente foi preservado e validado através
do fluxo completo da aplicação.

A Sprint também estabeleceu as principais direções tecnológicas da
próxima fase:

* **Interface gráfica:** JavaFX;
* **Sistema de build:** Maven.

Essas tecnologias ainda não foram implementadas nesta Sprint.

### Próxima etapa

Com a US-019 concluída, a próxima evolução do projeto será a
preparação técnica para a implementação da interface gráfica JavaFX,
incluindo a adoção do Maven e a definição da estrutura necessária para
execução, testes e futura distribuição da aplicação.

---

### 📅 27/08/2026

## 🔄 Encerramento da Sprint 20

### Entrega: US-020 — Primeiro vertical slice jogável com JavaFX

A Sprint 20 marcou o início efetivo da transição do Sudoku de uma aplicação orientada ao Console para um jogo desktop com interface gráfica.

O objetivo foi validar essa transição através de um **vertical slice jogável**, utilizando Maven e JavaFX e reaproveitando a arquitetura preparada na Sprint 19.

Durante a Sprint, o projeto passou a utilizar **Maven** como sistema de build e **JavaFX** como tecnologia da interface gráfica.

A primeira aplicação JavaFX foi implementada e integrada ao fluxo real do Sudoku. O usuário passou a conseguir iniciar uma partida, visualizar o tabuleiro, selecionar uma casa, inserir um número e visualizar o resultado da operação através da nova interface.

A implementação reutilizou as regras e a lógica existentes da aplicação, sem reproduzi-las na camada gráfica.

### O que foi realizado

* configuração do Maven como sistema de build;
* configuração das dependências JavaFX;
* criação e execução da aplicação JavaFX;
* implementação da primeira interface gráfica;
* apresentação gráfica do tabuleiro;
* seleção de casas;
* inserção de números;
* atualização visual após uma jogada;
* integração com o fluxo existente da aplicação;
* preservação das regras existentes;
* preservação da interface Console.

O resultado foi uma primeira versão gráfica efetivamente jogável, deliberadamente limitada ao escopo definido para o vertical slice.

### Aprendizados e constatações

A Sprint demonstrou, na prática, que a estratégia de **vertical slice** é adequada para a evolução do projeto. Foi possível validar uma cadeia funcional completa sem antecipar a implementação de todas as funcionalidades já existentes no Console.

A introdução do JavaFX também confirmou o valor da separação estabelecida na Sprint 19. A nova interface pôde ser integrada ao projeto sem exigir reconstrução do domínio ou duplicação das regras do Sudoku.

Outro ponto importante foi a validação da tecnologia através de uma funcionalidade real. Mais do que confirmar que Maven e JavaFX estavam configurados corretamente, a Sprint demonstrou que ambos poderiam sustentar uma experiência efetivamente jogável.

A preservação do Console também se mostrou importante durante a transição, mantendo a implementação existente funcional enquanto uma segunda interface era introduzida.

### Validações realizadas

O vertical slice definido para a Sprint foi executado com sucesso:

```text
Abrir aplicação
↓
Iniciar nova partida
↓
Visualizar tabuleiro
↓
Selecionar casa
↓
Inserir número
↓
Visualizar resultado
```

Também foi confirmado que a operação gráfica utiliza as regras existentes da aplicação e que a interface Console permanece funcional após a introdução do JavaFX.

### Code Review

O Code Review foi realizado após a implementação.

A revisão confirmou a aderência da solução à direção arquitetural estabelecida na US-019, especialmente quanto à separação entre interface e aplicação.

Não foram identificados problemas concretos que justificassem a reabertura das decisões arquiteturais anteriormente estabelecidas.

### Decisões arquiteturais

A implementação confirmou, na prática, a decisão registrada no **ADR-011 — Separação entre interface e orquestração da aplicação**.

Não foi identificada durante a Sprint nenhuma nova decisão arquitetural relevante que justificasse a criação de outro ADR.

### Resultado

A Sprint 20 atingiu seu objetivo principal: o Sudoku passou a possuir uma primeira interface JavaFX funcional e capaz de executar uma operação real de jogo.

A evolução pode ser representada por:

```text
Aplicação Console
        ↓
Arquitetura preparada para múltiplas interfaces
        ↓
Console + JavaFX
        ↓
Primeiro vertical slice jogável
```

A GUI ainda não possui paridade funcional com o Console, conforme deliberadamente definido no escopo da Sprint. Essa limitação representa o ponto de partida para sua evolução incremental, e não uma pendência da Sprint.

### Estado do projeto

Com a conclusão da US-020, o projeto possui uma primeira experiência gráfica funcional e uma base tecnológica validada para a continuidade da evolução do jogo como aplicação desktop.

As próximas funcionalidades deverão ser avaliadas a partir do estado atual do produto e do Product Backlog, mantendo a estratégia de evolução incremental e evitando antecipar complexidade que ainda não seja necessária.

---

### 📅 04/09/2026

## 🔄 Encerramento da Sprint 21

### Entrega: US-021 — Remover número pela interface JavaFX

A Sprint 21 representou a primeira evolução funcional da interface gráfica após a implementação do primeiro vertical slice da Sprint 20.

O objetivo foi permitir que o jogador removesse, através da interface JavaFX, uma jogada definitiva realizada anteriormente.

A implementação foi realizada de forma incremental, utilizando a arquitetura estabelecida na Sprint 19 e validada durante a Sprint 20.

A operação de remoção foi disponibilizada através da aplicação, mantendo a regra de domínio em `Casa.removerNumero()` e evitando que a interface gráfica passasse a conhecer ou reproduzir regras do Sudoku.

### O que foi realizado

* disponibilização da operação de remoção em `JogoSudoku`;
* integração da operação ao `JavaFXController`;
* criação do botão **Remover** na interface JavaFX;
* utilização da casa atualmente selecionada para solicitar a remoção;
* remoção de jogadas realizadas pelo jogador;
* atualização visual após remoção;
* tratamento de tentativa de remoção de casa fixa;
* tratamento de tentativa de remoção de casa sem jogada do jogador;
* preservação da interação com o tabuleiro após operações válidas e inválidas;
* preservação da interface Console;
* correção incidental da apresentação indevida de `Jogada removida` no Console após operações inválidas.

O resultado foi uma nova funcionalidade efetivamente integrada ao fluxo gráfico do Sudoku, sem alteração desnecessária da arquitetura existente.

### Aprendizados e constatações

A Sprint reforçou a estratégia de evolução incremental adotada para a interface gráfica.

A funcionalidade de remoção pôde ser adicionada utilizando a arquitetura já preparada nas Sprints anteriores, sem necessidade de duplicar regras na camada JavaFX.

A separação entre interface, aplicação e domínio mostrou novamente seu valor. A interface gráfica ficou responsável pela interação, `JogoSudoku` pela coordenação da operação e `Casa` pela regra de remoção.

Outro ponto importante foi a identificação de uma inconsistência preexistente na apresentação do Console. A correção pôde ser realizada de forma pequena e diretamente relacionada à funcionalidade em desenvolvimento, sem transformar a Sprint em uma refatoração mais ampla.

### Validações realizadas

A funcionalidade foi validada através dos principais cenários definidos para a User Story:

```text
Selecionar casa
↓
Solicitar remoção
↓
Remover jogada
↓
Atualizar representação visual
↓
Continuar interação
```

Também foram validados cenários inválidos:

```text
Selecionar casa fixa
↓
Solicitar remoção
↓
Operação recusada
↓
Estado preservado
```

e:

```text
Selecionar casa sem jogada
↓
Solicitar remoção
↓
Operação recusada
↓
Estado preservado
```

A interface Console também foi utilizada para confirmar a preservação da funcionalidade existente.

### Code Review

O Code Review foi realizado após a implementação.

A revisão confirmou que a alteração permaneceu restrita ao objetivo da US-021 e respeitou a separação arquitetural estabelecida anteriormente.

Não foram identificadas duplicações de regras do Sudoku na interface JavaFX, novas abstrações desnecessárias ou refatorações fora do escopo da Sprint.

### Decisões arquiteturais

A Sprint não exigiu uma nova decisão arquitetural.

A implementação confirmou novamente, na prática, a decisão registrada no **ADR-011 — Separação entre interface e orquestração da aplicação**.

A interface JavaFX utiliza o ponto de entrada da aplicação para solicitar a operação, enquanto a regra de remoção permanece no domínio.

Não foi criado novo ADR.

### Resultado

A Sprint 21 atingiu seu objetivo principal: a interface JavaFX passou a permitir a remoção de jogadas realizadas pelo jogador.

A evolução pode ser representada por:

```text
Primeiro vertical slice JavaFX
        ↓
Inserção de jogadas
        ↓
Remoção de jogadas
        ↓
Evolução incremental da experiência gráfica
```

A funcionalidade foi implementada sem buscar paridade funcional completa com o Console, mantendo a estratégia definida para a evolução da GUI.

### Estado do projeto

Com a conclusão da US-021, o Sudoku possui uma nova operação funcional disponível pela interface JavaFX, mantendo a arquitetura preparada para a continuidade da evolução da aplicação desktop.

A próxima evolução deverá ser definida a partir do Product Backlog, mantendo a abordagem incremental e evitando antecipar funcionalidades ou complexidade que ainda não sejam necessárias.
