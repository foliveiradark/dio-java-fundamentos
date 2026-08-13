## [Não publicado]

Última atualização: 13/08/2026

### Adicionado

#### Estrutura inicial

- Estrutura inicial do projeto.
- Modelo da classe `Casa`.
- Modelo da classe `Tabuleiro`.
- Classe `util.Tabuleiros`.
- Primeiro tabuleiro oficial.
- Carregamento automático do tabuleiro.

#### Interface

- Camada de interface (`ui`).
- Classe `ConsolePrinter`.
- Classe `ConsoleInput`.
- Exibição do menu principal.
- Impressão do tabuleiro.
- Separação visual dos blocos 3×3.
- Identificação das linhas (A–I).
- Identificação das colunas (1–9).
- Refinamento visual completo da impressão do tabuleiro.
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

#### Finalização da partida

- Encerramento automático da partida quando o Sudoku é concluído corretamente.
- Exibição de mensagem de conclusão ao jogador.
- Retorno automático ao Menu Principal após o encerramento.
- Bloqueio de novas jogadas após o término da partida.
- Reutilização da verificação de `StatusPartida` para determinar o encerramento.

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
- Integração do sistema de rascunhos ao fluxo da partida.
- Validação das regras de consistência entre candidatos e números definitivos.

### Corrigido

- Correção do método `obterTabuleiroInicial()`, que retornava `null`.
