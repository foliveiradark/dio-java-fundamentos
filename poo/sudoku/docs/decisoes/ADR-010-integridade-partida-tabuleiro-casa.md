# ADR-010 — Garantia de integridade entre partida, tabuleiro e casa

## Status

Aceito

---

## Contexto

Durante a definição do modelo relacional da persistência do Sudoku,
foi identificada uma regra importante de integridade:

Uma `ESTADO_CASA` pertence simultaneamente a uma `PARTIDA` e a uma
`CASA`.

A `PARTIDA` está associada a um determinado `TABULEIRO`, enquanto a
`CASA` também pertence a um `TABULEIRO`.

Portanto, uma associação entre `PARTIDA` e `CASA` somente é válida
quando ambas pertencem ao mesmo `TABULEIRO`.

Exemplo de associação válida:

```text
TABULEIRO 1
├── PARTIDA 10
└── CASA 25

ESTADO_CASA
├── partida = 10
└── casa = 25
```

Exemplo de associação inválida:

```text
TABULEIRO 1
└── PARTIDA 10

TABULEIRO 2
└── CASA 25

ESTADO_CASA
├── partida = 10
└── casa = 25  ← associação inválida
```

Uma chave estrangeira simples entre `ESTADO_CASA.casa_id` e
`CASA.id` não seria suficiente para impedir esse tipo de inconsistência,
pois a casa referenciada poderia existir no banco, mas pertencer a outro
tabuleiro.

Foi então analisado se essa integridade deveria ser responsabilidade
exclusiva da aplicação, do banco de dados ou de ambos.

---

## Decisão

A integridade será garantida por **ambas as camadas**:

* a aplicação Java será responsável por validar as regras do fluxo
  antes da persistência;
* o PostgreSQL será responsável por garantir a integridade dos dados
  persistidos.

A aplicação deverá realizar as validações necessárias para permitir
tratamento adequado dos erros e manter uma experiência de uso coerente.

O banco de dados deverá possuir restrições estruturais capazes de
impedir a persistência de associações inválidas, independentemente do
cliente utilizado para acessar o banco.

A implementação adotada utiliza chaves estrangeiras compostas,
mantendo o `tabuleiro_id` como parte da identidade relacional das
associações.

A estrutura implementada é:

```text
PARTIDA
├── id
└── tabuleiro_id
        │
        │ FK composta
        ▼
ESTADO_CASA
├── partida_id
├── tabuleiro_id
└── casa_id
        │
        │ FK composta
        ▼
CASA
├── id
└── tabuleiro_id
```

Assim, uma `ESTADO_CASA` somente pode referenciar uma `PARTIDA` e uma
`CASA` que pertençam ao mesmo `TABULEIRO`.

Além da integridade referencial, foram utilizadas restrições de
unicidade para evitar duplicidades incompatíveis com o domínio.

Entre elas:

```text
UNIQUE (partida_id, casa_id)
```

garantindo que uma mesma casa não possua mais de um estado dentro da
mesma partida.

As restrições foram efetivamente implementadas no PostgreSQL e
validadas durante a construção da persistência da US-018.

---

## Justificativa

A validação exclusivamente na aplicação faria com que a integridade
dos dados dependesse do correto funcionamento de todos os clientes que
acessam o banco.

Por outro lado, delegar toda a validação ao banco dificultaria o
tratamento adequado das regras no fluxo da aplicação e poderia gerar
uma dependência excessiva da camada de persistência.

A utilização das duas camadas proporciona uma abordagem defensiva:

```text
Aplicação
    │
    │ valida fluxo
    ▼
PostgreSQL
    │
    │ garante integridade estrutural
    ▼
Dados persistidos
```

A utilização de chaves compostas permite que a relação entre as
entidades seja protegida diretamente pelo modelo relacional, evitando
que a integridade dependa exclusivamente de verificações realizadas
pelo código Java.

Essa abordagem também reforça a responsabilidade de cada camada sem
eliminar a proteção oferecida pela outra.

---

## Consequências

### Positivas

* Impede a persistência de estados de casas associados a tabuleiros
  incorretos.
* Mantém a aplicação responsável pelas validações do fluxo.
* Permite que o banco proteja os dados mesmo quando acessado por outro
  cliente.
* Reduz o risco de inconsistências silenciosas.
* Garante a unicidade do estado de uma casa dentro de uma partida.
* Aproxima o projeto de uma arquitetura utilizada em sistemas reais.
* Permite explorar mecanismos de integridade referencial do PostgreSQL
  durante o aprendizado.

### Negativas

* A modelagem relacional é um pouco mais complexa.
* Algumas regras são consideradas tanto pela aplicação quanto pelo
  banco.
* É necessário compreender mecanismos adicionais de chaves
  compostas, foreign keys e constraints.
* Consultas e operações de persistência precisam considerar o
  `tabuleiro_id` nas associações relevantes.

---

## Artefatos afetados

* Modelo lógico
* Modelo relacional
* Banco de dados PostgreSQL
* Camada de persistência da aplicação
* Testes de persistência
* US-018 — Continuar partida

---

## Relação com princípios

Esta decisão reforça o princípio de separação de responsabilidades:

> A aplicação é responsável pela validação do fluxo e pela experiência
> do usuário; o banco de dados é responsável pela integridade dos dados
> persistidos.

Também reforça a ideia de que uma regra importante de integridade não
deve depender exclusivamente de uma única camada do sistema.

A utilização de constraints no banco também estabelece uma segunda
barreira de proteção para os dados, independentemente do cliente que
realize a operação de persistência.

---

## Data

15/08/2026
