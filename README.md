# 📚 Anki Copy API

API REST desenvolvida com **Spring Boot** para gerenciamento de
**Decks** e **Cards**, inspirada no funcionamento do Anki.

------------------------------------------------------------------------

## 🚀 Tecnologias

-   Java
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   Lombok
-   Banco de dados PostgreSQL

------------------------------------------------------------------------

# 📦 Funcionalidades

## 🗂 Decks

-   Criar deck
-   Listar decks
-   Atualizar nome do deck
-   Deletar deck

## 🃏 Cards

-   Criar card
-   Listar cards
-   Filtrar cards por deck
-   Sortear card de um deck
-   Deletar card

------------------------------------------------------------------------

# 🔗 Endpoints

## 📁 Decks

### ➕ Criar deck

`POST /decks`

``` json
{
  "nome": "English"
}
```

------------------------------------------------------------------------

### 📋 Listar decks

`GET /decks`

------------------------------------------------------------------------

### ✏️ Atualizar nome do deck

`PUT /decks/{id}/name`

``` json
{
  "name": "English Advanced"
}
```

------------------------------------------------------------------------

### ❌ Deletar deck

`DELETE /decks/{id}`

------------------------------------------------------------------------

## 🃏 Cards

### ➕ Criar card

`POST /cards`

``` json
{
  "front": "Hello",
  "back": "Olá",
  "level": 1,
  "deckId": 1
}
```

------------------------------------------------------------------------

### 📋 Listar cards

`GET /cards`

### 📋 Listar cards por deck

`GET /cards?deckId=1`

------------------------------------------------------------------------

### 🎲 Sortear card de um deck

`GET /cards/run?deckName=English`

Retorna um card aleatório do deck informado.

------------------------------------------------------------------------

### ❌ Deletar card

`DELETE /cards/{id}`


------------------------------------------------------------------------

# 📌 Estrutura do Projeto

    controller
    service
    model
    dto
    repository

-   **controller** → Camada REST
-   **service** → Regras de negócio
-   **repository** → Acesso ao banco
-   **dto** → Objetos de transferência
-   **model** → Entidades JPA

------------------------------------------------------------------------

# 🧠 Objetivo do Projeto

Projeto desenvolvido para praticar:

-   Arquitetura em camadas
-   DTO Pattern
-   Boas práticas com Spring Boot
-   Organização de API REST
-   Criar um anki com meu bot WPP
