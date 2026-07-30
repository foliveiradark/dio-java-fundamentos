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
## 📅 23/07/2026

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

📅 24/07/2026

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

📅 26/07/2026

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
