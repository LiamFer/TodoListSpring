

# 📝 Todo List API

API RESTful para gerenciamento de listas de tarefas com autenticação de usuários, operações CRUD, paginação e boas práticas de segurança.

🔗 Projeto oficial: [roadmap.sh - Todo List API](https://roadmap.sh/projects/todo-list-api)

## 🚀 Objetivo

Este projeto tem como objetivo construir uma API completa para gerenciamento de tarefas, onde cada usuário pode criar e manter sua própria lista. Diferente de projetos anteriores focados apenas em CRUD, este desafio exige a implementação de **autenticação de usuários** e outras funcionalidades avançadas.

---

## 🧠 Habilidades desenvolvidas

- Autenticação de usuários (login e registro)
- Design de banco de dados e schemas
- Construção de APIs RESTful
- Operações CRUD seguras e escaláveis
- Tratamento de erros
- Boas práticas de segurança
- Paginação e filtragem de dados

---

## ✅ Requisitos do Projeto

### Endpoints:

#### 📌 Registro de usuário


POST /register
{
"name": "John Doe",
"email": "[john@doe.com](mailto:john@doe.com)",
"password": "password"
}


**Resposta (201)**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
````

#### 🔐 Login de usuário

```
POST /login
{
  "email": "john@doe.com",
  "password": "password"
}
```

**Resposta (200)**:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```

#### ➕ Criar tarefa

```
POST /todos
Headers: Authorization: Bearer <token>
{
  "title": "Buy groceries",
  "description": "Buy milk, eggs, and bread"
}
```

**Resposta (201)**:

```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Buy milk, eggs, and bread"
}
```

#### ✏️ Atualizar tarefa

```
PUT /todos/1
Headers: Authorization: Bearer <token>
{
  "title": "Buy groceries",
  "description": "Buy milk, eggs, bread, and cheese"
}
```

**Resposta (200)**:

```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Buy milk, eggs, bread, and cheese"
}
```

#### 🗑️ Deletar tarefa

```
DELETE /todos/1
Headers: Authorization: Bearer <token>
```

**Resposta (204)**

#### 📄 Listar tarefas (com paginação)

```
GET /todos?page=1&limit=10
Headers: Authorization: Bearer <token>
```

**Resposta (200)**:

```json
{
  "data": [
    {
      "id": 1,
      "title": "Buy groceries",
      "description": "Buy milk, eggs, bread"
    },
    {
      "id": 2,
      "title": "Pay bills",
      "description": "Pay electricity and water bills"
    }
  ],
  "page": 1,
  "limit": 10,
  "total": 2
}
```

---

## 🔒 Autenticação

A autenticação é obrigatória para todas as operações com tarefas. Utilize o token retornado no login ou registro com o header:

```
Authorization: Bearer <seu_token>
```

---

## 💡 Recursos Extras (Bonus)

* 🔍 Filtro e ordenação das tarefas
* 🧪 Testes unitários com framework da sua escolha
* 🚦 Rate limiting e throttling
* ♻️ Mecanismo de *refresh token*

---

## 🛠️ Tecnologias sugeridas

* Node.js / Express / Fastify / Django / Spring Boot (à sua escolha)
* JWT para autenticação
* Banco de dados relacional (PostgreSQL, MySQL) ou NoSQL (MongoDB)
* Middleware para validação (ex: Joi, Yup)
* ORM/ODM (ex: Prisma, Sequelize, Mongoose)

---

## 📚 Referência

Este projeto faz parte da plataforma [roadmap.sh](https://roadmap.sh/), uma das maiores comunidades de aprendizado de desenvolvimento web.

👉 Link oficial do projeto:
🔗 **[https://roadmap.sh/projects/todo-list-api](https://roadmap.sh/projects/todo-list-api)**

---
