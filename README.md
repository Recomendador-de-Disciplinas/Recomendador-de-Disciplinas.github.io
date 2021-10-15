# Recomendador de Disciplinas

Projeto da disciplina MAC0413 - Tópicos Avançados de Programação Orientada a Objetos.

- [Fase 1](#fase-1)
- [Fase 2](#fase-2)
- [Fase 3](#fase-4)
- [Fase 4](#fase-4)

## Integrantes

**Daniel Oliveira Sanches Leal, NUSP: 11321180**

**Erick Rodrigues de Santana, NUSP:11222008**

**Francisco Eugênio Wernke, NUSP: 11221870**

**Thiago Guerrero Balera, NUSP: 11275297**

**Vinicius Pereira Ximenes Frota, NUSP: 11221967**

## Contribuições

Todos os commits realizados no Gitlab são espelhados para um repositório no Github. Desta forma, conseguimos obter estatísticas a respeito das contribuições de cada membro mesmo quando realizamos `pair/mob programming`. Portanto, para verificar as contribuições acesse este [link](https://github.com/Franwernke/Recomendador-de-Disciplinas/pulse/monthly).

## Executando

Com Docker e Docker Compose instalados, execute:

```bash
$> docker-compose up --build
```

O frontend estará em `localhost:3000` e o backend estará em `localhost:8080`

## Fase 1

Esboço:
https://www.figma.com/file/IN8LL77pqYjyt3lOFh9Qla

Para a primeira fase, focamos somente no front-end, utilizando as seguintes ferramentas:
- Vue
- Vuetify
- LocalStorage
- Jest

Decidimos usar o Vue por conta da experiência com este _framework_ por grande parte do grupo. Além disso, a ferramenta apresenta um bom ecossistema que possibilita uma maior produtividade no desenvolvimento de telas e funcionalidades necessárias para a parte da visualização do projeto. O Vuetify é uma dessas ferramentas do ecossistema do Vue, ele disponibiliza vários componentes já estilizados além de uma interface simples para estilização de todo o código, ajudando a agilizar o desenvolvimento.

O LocalStorage foi utilizado com a finalidade de salvar o estado dos dados do usuário em _cache_, sem a necessidade de implementar uma sessão. Esta decisão foi tomada visando evitar uma complexidade adicional para a aplicação como um todo.

Por fim, utilizamos o Jest para fazer testes de unidade na aplicação. Por conta do estágio prematuro do front-end, não foram necessários muitos testes.

Requisito 1) Por meio da página do formulário, conseguimos cadastrar e editar um usuário que possui, por enquanto, nome, disciplinas já cursadas e departamentos de interesse na USP. Ao preencher o formulário, os dados coletados são salvos no LocalStorage, o que permite recuperarmos os mesmos para a visualização destas informações. Nesta primeira fase, o usuário pode inserir as disciplinas e os departamentos de interesse somente de forma manual, descrevendo os códigos das matérias/departamentos. Em uma próxima fase, esses dados serão selecionados a partir das informações disponibilizadas pelo [jupiterweb](https://uspdigital.usp.br/jupiterweb/). Para este fim, já está em progresso o desenvolvimento de um _crawler_ para adquirir estes dados.

Requisito 2) Por meio do mesmo formulário, o usuário pode visualizar, remover e editar as suas informações, tudo de uma forma muito agradável e fluida.

| ![contribuicao_fase_1](https://gitlab.com/TGuerrero_/recomendador-de-disciplinas/docs/fase_1.png) |
|:--:|
| **Contribuições no período 14/09 - 14/10**|

## Fase 2

_Em progresso..._

## Fase 3

_Em progresso..._

## Fase 4

_Em progresso..._
