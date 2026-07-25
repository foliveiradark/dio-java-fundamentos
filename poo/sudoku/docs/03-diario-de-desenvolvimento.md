# 📅 Diário de Desenvolvimento

---

### 📅 17/07/2026

## 🔄 Sprint 0

Nesta etapa foi definida a arquitetura inicial do projeto.

Foi decidido desenvolver o Sudoku de forma incremental, priorizando a qualidade do código e a documentação antes da implementação completa.

Aprendizados:

- importância da modelagem antes da programação;
- definição de responsabilidades entre classes;
- organização da documentação.

---

## 🔄 Sprint 1

A implementação começou pela classe `Casa`.

Durante o desenvolvimento surgiram decisões importantes sobre encapsulamento, validações e responsabilidade das classes.

Também foi implementada a estrutura inicial do `Tabuleiro`, responsável por criar automaticamente suas 81 casas.

Aprendizados:

- validações pertencem ao objeto que protege seu próprio estado;
- métodos privados melhoram a legibilidade;
- desenvolvimento incremental reduz erros.
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

Aprendizados:
- separar responsabilidades entre Model e UI;
- criar uma camada de apresentação (`ConsolePrinter`);
- utilizar encapsulamento através do método `getCasa()`;
- desenvolver de forma incremental;
- revisar pequenas entregas através de Pull Requests simuladas;
- pensar primeiro no algoritmo e depois na implementação.

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

- Diferença entre regra de domínio e experiência do usuário.
- Importância de validar funcionalidades por meio de testes.
- Refatoração pode eliminar bugs sem adicionar código de tratamento.
- Objetos devem nascer em um estado consistente.
- Cada método deve possuir uma única responsabilidade.

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