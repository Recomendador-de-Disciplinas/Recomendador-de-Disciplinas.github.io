# Recomendador de Disciplinas

Projeto da disciplina MAC0413 - Tópicos Avançados de Programação Orientada a Objetos.

- [Esboço](#esboço)
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

### Frontend

Com Docker e Docker Compose instalados, execute dentro do diretório `/frontend`:

```bash
$> docker-compose up --build
```

O frontend estará em `localhost:3000`

### Backend

É necessário configurar dentro do diretório `/backend` um arquivo `.env` com as variáveis de ambiente necessárias para executar o `backend` e o `db`.
As variáveis necessárias estão disponíveis no arquivo `.env.sample`. Algumas variáveis padrões já estão definidas.

Com Docker e Docker Compose instalados, execute dentro do mesmo diretório:

```bash
$> docker-compose up --build
```

O backend estará em `localhost:8080`

## Esboço

Durante todas as fases do projeto estamos aprimorando um esboço no figma da inteface do usuário. Este esboço pode ser acessado neste [link](https://www.figma.com/file/IN8LL77pqYjyt3lOFh9Qla).

## Fase 1

Para a primeira fase, focamos somente no frontend, utilizando as seguintes ferramentas:

- Vue
- Vuetify
- LocalStorage
- Jest

Decidimos usar o Vue por conta da experiência com este _framework_ por grande parte do grupo. Além disso, a ferramenta apresenta um bom ecossistema que possibilita uma maior produtividade no desenvolvimento de telas e funcionalidades necessárias para a parte da visualização do projeto. O Vuetify é uma dessas ferramentas do ecossistema do Vue, ele disponibiliza vários componentes já estilizados além de uma interface simples para estilização de todo o código, ajudando a agilizar o desenvolvimento.

O LocalStorage foi utilizado com a finalidade de salvar o estado dos dados do usuário em _cache_, sem a necessidade de implementar uma sessão. Esta decisão foi tomada visando evitar uma complexidade adicional para a aplicação como um todo.

Por fim, utilizamos o Jest para fazer testes de unidade na aplicação. Por conta do estágio prematuro do front-end, não foram necessários muitos testes.

Requisito 1) Por meio da página do formulário, conseguimos cadastrar e editar um usuário que possui, por enquanto, nome, disciplinas já cursadas e departamentos de interesse na USP. Ao preencher o formulário, os dados coletados são salvos no LocalStorage, o que permite recuperarmos os mesmos para a visualização destas informações. Nesta primeira fase, o usuário pode inserir as disciplinas e os departamentos de interesse somente de forma manual, descrevendo os códigos das matérias/departamentos. Em uma próxima fase, esses dados serão selecionados a partir das informações disponibilizadas pelo [jupiterweb](https://uspdigital.usp.br/jupiterweb/). Para este fim, já está em progresso o desenvolvimento de um _crawler_ para adquirir estes dados.

Requisito 2) Por meio do mesmo formulário, o usuário pode visualizar, remover e editar as suas informações, tudo de uma forma muito agradável e fluida.

| ![contribuicao_fase_1](https://gitlab.com/TGuerrero_/recomendador-de-disciplinas/-/raw/main/docs/fase_1.png) |
| :----------------------------------------------------------------------------------------------------------: |
|                                  **Contribuições no período 14/09 - 14/10**                                  |
|          Da esquerda para a direita: Thiago: 24, Francisco: 15, Erick: 14, Vinicius: 14 e Daniel: 9          |

## Fase 2

Para a segunda fase, trabalhamos principalmente em começar o backend. As ferramentas mais importantes utilizadas foram:

- Spring Boot
- Spring Data JPA
- JUnit
- postgreSQL

Decidimos utilizar o Spring Boot por conta do seu grande suporte no desenvolvimento de bons sistemas orientados à objetos, seu suporte no desenvolvimento de aplicações RESTful e também pelo seu grande ecossistema. Com isso, temos um _framework_ que nos auxilia muito na implementação das camadas de Model e Controller da arquitetura MVC. Uma dessas ferramentas do ecossistema do spring é o Spring Data JPA, ele fornece uma interface simples para implementar a camada de acesso aos dados no banco de dados. A arquitetura da aplicação está explícita na figura abaixo.

![architecture](https://gitlab.com/TGuerrero_/recomendador-de-disciplinas/-/raw/main/docs/architecture.png)

Os dados armazenados no banco de dados são gerados através do tratamento do conteúdo fornecido pelo [crawler](https://github.com/T-Guerrero/usp-disciplines-crawler) implementado como presente para a comunidade por um dos integrantes do grupo. Este _crawler_ coleta dados fornecidos pelo [jupiterweb](https://uspdigital.usp.br/jupiterweb/) e armazena os mesmos em um arquivo JSON. Portanto, a definição das entidades do backend está fortemente acoplada com a estrutura desses dados neste arquivo. A figura abaixo mostra esta estrutura.

![crawler_structure](https://gitlab.com/TGuerrero_/recomendador-de-disciplinas/-/raw/main/docs/crawler.jpg)

Para manter a consistência entre essas entidades e também para utilizar o Spring Data JPA, escolhemos utilizar um banco de dados relacional. O postgreSQL foi escolhido por conta da familiaridade do grupo com o mesmo.

Por fim, utilizamos o JUnit para fazer alguns testes em cima das funcionalidades implementadas no backend.

Requisito 1) Como comentamos na etapa anterior, agora não é mais necessário inserir as disciplinas e os departamentos de interesse de forma manual. Para isso, utilizamos rotas do backend para mostrar todas as opções possíveis através dos dados do _jupiterweb_.

Requisito 3)

Requisito 4) Para este fim, implementamos uma rota `POST` no backend que recebe quais são os departamentos de interesse e as palavras-chave digitadas e retorna uma lista de disciplinas recomendadas. Para fazer a comparação das disciplinas com as palavras-chave, implementamos um sistema de [fuzzy search](https://en.wikipedia.org/wiki/Approximate_string_matching) que compara cada palavra-chave com o título de cada disciplina das unidades indicadas. Se o algoritmo reconhecer 70% de similaridade entre as palavras, colocamos a discplina na lista de recomendadas.

| ![contribuicao_fase_2](https://gitlab.com/TGuerrero_/recomendador-de-disciplinas/-/raw/main/docs/fase_2.png) |
| :----------------------------------------------------------------------------------------------------------: |
|                                  **Contribuições no período 05/10 - 05/11**                                  |
|          Da esquerda para a direita: Erick: 34, Thiago: 31, Francisco: 17, Daniel: 16, Vinicius: 13          |

## Fase 3

_Em progresso..._

## Fase 4

_Em progresso..._
