## [Não publicado]

Última atualização: 01/08/2026

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

#### Entrada de coordenadas

- Leitura de coordenadas no formato A1–I9.
- Conversão automática das coordenadas para índices internos do domínio.
- Aceitação de letras maiúsculas e minúsculas.
- Normalização automática das entradas (`trim()` e `toUpperCase()`).
- Validação do formato das coordenadas.
- Solicitação automática de nova coordenada quando a entrada for inválida.
- Refatoração do fluxo da partida para utilizar uma única entrada de coordenada.

### Corrigido

- Correção do método `obterTabuleiroInicial()`, que retornava `null`.