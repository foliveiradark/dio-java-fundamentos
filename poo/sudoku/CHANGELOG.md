# CHANGELOG

## [Não publicado]

Última atualização: 14/10/2026

### Adicionado

#### Estrutura inicial

- Estrutura inicial do projeto.
- Modelo da classe `Casa`.
- Modelo da classe `Tabuleiro`.
- Classe `util.Tabuleiros`.
- Primeiro tabuleiro oficial.
- Carregamento automático do tabuleiro.

#### Interface Console

- Camada de interface (`ui`).
- Classe `ConsolePrinter`.
- Classe `ConsoleInput`.
- Exibição do menu principal.
- Impressão do tabuleiro.
- Separação visual dos blocos 3×3.
- Identificação das linhas (A–I).
- Identificação das colunas (1–9).
- Refinamento visual da impressão do tabuleiro.
- Utilização de caracteres Unicode para delimitação dos blocos 3×3.
- Identificação das colunas também no rodapé do tabuleiro.
- Identificação das linhas no lado direito do tabuleiro.
- Revisão do espaçamento e alinhamento da interface em modo texto.

#### Fluxo da aplicação

- Classe `JogoSudoku`.
- Fluxo principal da aplicação.
- Leitura das opções do usuário.
- Encerramento da aplicação pelo menu.

#### Jogabilidade

- Inserção de números.
- Remoção de números.
- Confirmação antes da remoção.
- Tratamento de jogadas inválidas.
- Exibição de mensagens de erro.
- Atualização automática do tabuleiro após jogadas.

#### Verificação da partida

- Enum `StatusPartida`.
- Verificação de casas vazias.
- Verificação de erros nas linhas.
- Verificação de erros nas colunas.
- Verificação de erros nos blocos 3×3.
- Consulta do status da partida.
- Exibição do status ao jogador.

#### Limpeza das jogadas

- Limpeza de todas as jogadas realizadas pelo jogador.
- Preservação das casas fixas durante a limpeza.
- Reutilização do método `Casa.removerNumero()`.
- Solicitação para limpar todas as jogadas.
- Confirmação antes da limpeza.
- Reimpressão automática do tabuleiro após a limpeza.
- Mensagem de confirmação após a remoção das jogadas.

#### Validação de entradas

- Tratamento de entradas vazias.
- Tratamento de entradas não numéricas.
- Validação centralizada na classe `ConsoleInput`.
- Solicitação automática de nova entrada até que um valor válido seja informado.
- Mensagens amigáveis para entradas inválidas.
- Validação das opções do Menu Principal.
- Aceitação apenas das opções disponíveis.
- Tratamento de opções inexistentes.
- Solicitação automática de nova opção até que uma opção válida seja informada.
- Refatoração do fluxo do Menu Principal utilizando `switch`.

#### Entrada de coordenadas

- Leitura de coordenadas no formato A1–I9.
- Conversão automática das coordenadas para índices internos do domínio.
- Aceitação de letras maiúsculas e minúsculas.
- Normalização automática das entradas (`trim()` e `toUpperCase()`).
- Validação do formato das coordenadas.
- Solicitação automática de nova coordenada quando a entrada for inválida.
- Refatoração do fluxo da partida para utilizar uma única entrada de coordenada.

#### Validação de confirmações

- Validação das respostas de confirmação (`S/N`).
- Aceitação de letras maiúsculas e minúsculas (`S`, `s`, `N`, `n`).
- Normalização automática das respostas (`trim()` e `toUpperCase()`).
- Tratamento de respostas vazias.
- Exibição de mensagens amigáveis para confirmações inválidas.
- Solicitação automática de nova resposta até que uma confirmação válida seja informada.
- Centralização da validação na classe `ConsoleInput`.

#### Sistema de rascunhos

- Sistema de rascunhos para casas editáveis.
- Possibilidade de registrar múltiplos candidatos em uma mesma casa.
- Operação de toggle para adicionar e remover candidatos.
- Representação dos candidatos utilizando `Set<Integer>` no domínio.
- Novo tipo de jogada para diferenciar números definitivos e candidatos.
- Apresentação visual dos candidatos em uma grade interna 3×3.
- Feedback ao jogador para inclusão e remoção de candidatos.
- Integração do sistema de rascunhos ao fluxo da aplicação.
- Validação das regras de consistência entre candidatos e números definitivos.

#### Persistência e continuidade da partida

- Persistência do estado da partida.
- Restauração de uma partida previamente salva.
- Continuação da partida a partir do estado persistido.
- Integração da persistência ao fluxo da aplicação.
- Preservação do estado do tabuleiro durante o salvamento e carregamento.

#### Interface gráfica JavaFX

**Estrutura e integração arquitetural**

- Configuração do Maven como sistema de build do projeto.
- Configuração das dependências JavaFX.
- Criação da aplicação JavaFX.
- Primeira interface gráfica desktop do Sudoku.
- Apresentação gráfica do tabuleiro.
- Seleção de casas através da interface gráfica.
- Integração da interface JavaFX com a orquestração existente em `JogoSudoku`.
- Primeiro vertical slice jogável da aplicação.
- Preservação das regras do Sudoku fora da camada de interface.
- Preservação da interface Console após a introdução da interface gráfica.

**Inserção e remoção de jogadas — US-020 e US-021**

- Inserção de números através da interface JavaFX.
- Atualização visual do tabuleiro após uma jogada.
- Remoção de jogadas específicas realizadas pelo jogador através da interface JavaFX.
- Botão `Remover` integrado à interface gráfica.
- Encaminhamento da operação de remoção através do `JavaFXController` e `JogoSudoku`.
- Atualização visual do tabuleiro após a remoção de uma jogada.
- Tratamento de tentativas de remoção de casas fixas.
- Tratamento de tentativas de remoção de casas sem jogada do jogador.

**Sistema de candidatos — US-022**

- Modo de candidatos integrado à interface JavaFX.
- Inclusão e remoção de candidatos através da interface gráfica.
- Representação visual dos candidatos em grade 3×3.
- Atualização visual dos candidatos a partir do estado atual do domínio.
- Tratamento de tentativas de utilização de candidatos em casas fixas ou preenchidas.
- Tratamento de candidatos inválidos pela interface JavaFX.
- Tratamento de operações de candidato sem casa selecionada.
- Preservação da funcionalidade de candidatos na interface Console.

**Limpeza das jogadas — US-023**

- Limpeza de jogadas integrada à interface JavaFX.
- Botão `Limpar Jogadas` adicionado à interface gráfica.
- Confirmação antes da limpeza das jogadas.
- Mensagem informativa quando não existem jogadas definitivas para limpar.
- Remoção das jogadas realizadas pelo jogador através da interface JavaFX.
- Preservação dos números fixos durante a limpeza.
- Preservação dos candidatos durante a limpeza.
- Atualização visual do tabuleiro após a limpeza.
- Preservação do funcionamento da interface Console.

**Finalização da partida — US-024**

- Consulta manual do status da partida pela interface JavaFX.
- Verificação automática do status após uma jogada definitiva.
- Apresentação de mensagens para partidas incompletas e completas com erros.
- Exibição de diálogo de conclusão quando o Sudoku é resolvido corretamente.
- Opção para encerrar a aplicação pelo diálogo de conclusão.
- Opção `Nova partida` apresentada, mas desabilitada; a criação de uma nova partida permanece fora do escopo.
- Reutilização da consulta de `StatusPartida` disponibilizada por `JogoSudoku`.
- Preservação da separação entre apresentação JavaFX, orquestração da aplicação e regras do domínio.

### Corrigido

- Correção do método `obterTabuleiroInicial()`, que retornava `null`.
- Correção da apresentação indevida da mensagem `Jogada removida` no Console após tentativas inválidas de remoção.
- Correção do fluxo de verificação automática do status da partida na interface JavaFX, evitando a consulta após uma jogada definitiva rejeitada.
