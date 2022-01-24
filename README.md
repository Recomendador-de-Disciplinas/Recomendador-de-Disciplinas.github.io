# Recomendador de Disciplinas

- [Sobre](#sobre)
- [Atualização dos dados](#atualização-dos-dados)
- [Executando](#executando)
- [Esboço](#esboço)
- [Tecnologias](#tecnologias)
- [Arquitetura do projeto](#arquitetura-do-projeto)
- [Arquitetura do crawler](#arquitetura-do-crawler)
- [Estratégia de busca](#estratégia-de-busca)

## Sobre

Projeto da disciplina MAC0413 - Tópicos Avançados de Programação Orientada a Objetos.

## Atualização dos dados

Os dados da USP que utilizamos são coletados através de um [crawler](https://github.com/T-Guerrero/usp-disciplines-crawler). Este _crawler_ coleta dados fornecidos pelo [jupiterweb](https://uspdigital.usp.br/jupiterweb/) e armazena os mesmos em um arquivo JSON, que é utilizado por esta aplicação. Como o custo computacional da coleta desses dados é alto, decidimos manter a taxa de atualização de uma vez por ano, ou seja, todo ano atualizaremos os dados com base no que é fornecido pela USP.

Para mais detalhes da estrutura desses dados, veja [aqui](#arquitetura-do-crawler).

## Executando

### Frontend

É necessário configurar dentro do diretório `/frontend` um arquivo `.env` com as variáveis de ambiente necessárias para executar o `frontend`.
As variáveis necessárias estão disponíveis no arquivo `.env.sample`.

:warning: Embora o arquivo `.env` seja obrigatório, o valor da variável `BACKEND_URL` é opcional. Caso não seja fornecido, a url `localhost:8080` será usada no lugar em toda a aplicação.

:warning: Limpe os cookies para uma experiência de usuário correta.

Com Docker e Docker Compose instalados, execute dentro do diretório `/frontend`:

```bash
$> docker-compose build
$> docker-compose run --rm frontend yarn install
$> docker-compose up
```

O frontend estará em `localhost:3000`

### Backend

É necessário configurar dentro do diretório `/backend` um arquivo `.env` com as variáveis de ambiente necessárias para executar o `backend` e o `db`.
As variáveis necessárias estão disponíveis no arquivo `.env.sample`. Algumas variáveis padrões já estão definidas.

Com Docker e Docker Compose instalados, execute dentro do mesmo diretório:

:warning: Ao iniciar pela primeira vez, ocorrerá o fetch dos dados. Este processo pode demorar um pouco.

```bash
$> docker-compose up --build
```

O backend estará em `localhost:8080`

## Esboço

Durante todo o projeto, aprimoramos um esboço no figma da interface do usuário. Este esboço pode ser acessado neste [link](https://www.figma.com/file/IN8LL77pqYjyt3lOFh9Qla).

## Tecnologias

As principais tecnologias usadas foram:
* Vue
  * Vuetify
* LocalStorage
* Jest
* Spring Boot
  * Spring Data JPA
* Junit
* PostgreSQL
* Docker
* Fuzzy Search

## Arquitetura do projeto

O diagrama abaixo mostra de forma geral a arquitetura de todo o projeto:

![architecture](https://github.com/Recomendador-de-Disciplinas/Recomendador-de-Disciplinas.github.io/blob/main/docs/architecture.png)

## Arquitetura do Crawler

Os dados armazenados no banco de dados são gerados através do tratamento do conteúdo fornecido pelo [crawler](https://github.com/T-Guerrero/usp-disciplines-crawler). Este _crawler_ coleta dados fornecidos pelo [jupiterweb](https://uspdigital.usp.br/jupiterweb/) e armazena os mesmos em um arquivo JSON. Portanto, a definição das entidades do backend está fortemente acoplada com a estrutura desses dados neste arquivo. A figura abaixo mostra esta estrutura.

![crawler_structure](https://github.com/Recomendador-de-Disciplinas/Recomendador-de-Disciplinas.github.io/blob/main/docs/crawler.jpg)

## Estratégia de busca

A busca por disciplinas que correspondam com os tópicos de interesse digitados é feita seguindo a seguinte estratégia:

- para tópicos de interesse com menos de 3 palavras, implementamos um sistema de [fuzzy search](https://en.wikipedia.org/wiki/Approximate_string_matching) que compara cada palavra-chave com o título de cada disciplina das unidades indicadas. Se o algoritmo reconhecer 80% de similaridade entre as palavras, colocamos a discplina na lista de recomendadas.
- para tópicos de interesse com 3 ou mais palavras, verificamos se a disciplina contém uma substring que dá match com o tópico de interesse. Esta verificação é feita ignorando caracteres especiais (como acentos) e letras maiúsculas e minúsculas. Por exemplo, se um tópico de interesse for 'Orientado à objetos', o algoritmo dará match para disciplinas que tenham a string 'orientado a objetos', mas não dará match para disciplinas que tenham a string 'orientada a objeto'. Fizemos essa outra alternativa pois a biblioteca escolhida que implementa a _fuzzy search_ não lida bem com strings com 3 ou mais palavras.
