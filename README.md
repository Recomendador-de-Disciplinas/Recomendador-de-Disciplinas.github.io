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

Com Docker e Docker Compose instalado, execute:

```bash
$> docker-compose up --build
```

O frontend estará em `localhost:3000` e o backend estará em `localhost:8080`

## Fase 1

Esboço:
https://www.figma.com/file/IN8LL77pqYjyt3lOFh9Qla/Main-Screen?node-id=0%3A1

Para a primeira fase, focamos somente no front-end, utilizando as seguintes ferramentas:
- Vue
- Vuetify
- LocalStorage
- Jest

Decidimos usar o Vue por conta da experiencia com esse framework por grande parte do grupo. Além disso, a ferramente apresenta um bom ecossistema que possibilita uma maior produtividade no desenvolvimento de telas e funcionalidades necessárias para parte do cliente. O Vuetify é uma dessas ferramentas do ecossistema do Vue, ela disponibiliza vários componentes para agilizar partes comuns do desenvolvimento de aplicativos.

O LocalStorage foi utilizado com a finalidade de salvar o estado dos inputs do usuário, sem necessidade de implementar uma sessão, o que possibilitou uma maior agiliadde no processo de desenvolvimento.

Por fim, utilizamos o Jest para fazer testes de unidade na aplicação. Por conta do estágio prematuro do front-end, não foram necessários muitos testes.

Para o projeto do front-end, decidimos adotar a arquitetura MVVM (Model View View-Model), similar ao MVC. A  arquitetura possibilitou uma maior separação das responsabilidades por meio da componentização das views.


Requisito 1) Por meio da página de formulário, conseguimos cadastrar e editar um usuário que possui nome, disciplinas já realizadas e departamentos de interesse na USP. Ao preencher o formulário, os dados coletados são salvos no LocalStorage, o que permite recuperarmos os mesmos em uma página de perfil, para o usuário visualizar essas informações. Nessa primeira fase, o usuário pode inserir as disciplinas somente de forma manual, descrevendo os códigos das matérias. Em uma próxima fase, esses dados poderão selecionados a partir das disciplinas disponíveis na USP. Para este fim, já está em progresso o desenvolvimento de um *Crawler* para adquirir estes dados.

Requisito 2) Por meio do mesmo formulário, o usuário acompanha os dados que estão sendo inseridos, podendo visualizar as matérias em um quadro, à direita da página. Da mesma forma, o quadro permite a remoção das disciplinas, dando liberdade para edição dessa lista, tudo de uma forma muito agradável e fluida. O mesmo vale para os departamentos desejados, onde temos um esquema de tags que ficam registradas no próprio input, também podendo ser removidas posteriormente.

## Fase 2

_Em progresso..._

## Fase 3

_Em progresso..._

## Fase 4

_Em progresso..._
