# Farmácia API

## Objetivo do Projeto
Elaborar um projeto Spring no STS, baseado no projeto Blog Pessoal, aplicando os conceitos estudados em Spring para implementar um sistema de comércio eletrônico (e-commerce) de uma farmácia.

A proposta desta API é gerenciar categorias e produtos de forma estruturada, com persistência em banco de dados relacional, validações de entrada e operações CRUD para suportar o fluxo inicial de um catálogo de farmácia.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Bean Validation (Jakarta Validation)
- MySQL Connector/J
- Hibernate ORM
- Maven Wrapper (mvnw / mvnw.cmd)
- Spring Boot DevTools
- Insomnia (testes de endpoints HTTP)

## Estrutura Funcional Atual
- Entidade Categoria com operações CRUD e consulta por nome
- Entidade Produto com operações CRUD e consulta por nome
- Relacionamento entre Categoria e Produto
- Validações de campos obrigatórios e limites de tamanho
- Persistência em MySQL

## Como Executar o Projeto
### Pre-requisitos
- JDK 17 instalado
- MySQL em execução local
- STS ou VS Code (opcional)

### 1. Clonar e acessar o projeto
```bash
git clone <url-do-repositorio>
cd farmacia
```

### 2. Configurar banco de dados
No arquivo `src/main/resources/application.properties`, configure:
- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

Exemplo de URL já utilizada no projeto:
```properties
spring.datasource.url=jdbc:mysql://localhost/db_farmacia?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false
```

### 3. Executar a aplicação
No Windows:
```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS:
```bash
./mvnw spring-boot:run
```

A API sobe por padrão em:
- `http://localhost:9090`

## Como Testar
### 1. Teste via collection do Insomnia
Use o arquivo:
- `testesHttpInsomnia_farmacia.yaml`

Importe no Insomnia e execute os requests na ordem:
1. `POST /categorias` (criar categorias base)
2. `GET /categorias`
3. `POST /produtos` (criação com referência de categoria)
4. `GET /produtos`, `GET /produtos/{id}` e `GET /produtos/nome/{nome}`
5. `PUT` e `DELETE` conforme necessidade

### 2. Teste de build
```bash
mvnw.cmd clean test
```

### Endpoints atuais
- Categorias:
  - `GET /categorias`
  - `GET /categorias/{id}`
  - `GET /categorias/nome/{nome}`
  - `POST /categorias`
  - `PUT /categorias`
  - `DELETE /categorias/{id}`
- Produtos:
  - `GET /produtos`
  - `GET /produtos/{id}`
  - `GET /produtos/nome/{nome}`
  - `POST /produtos`
  - `PUT /produtos`
  - `DELETE /produtos/{id}`

## Problemas Enfrentados
- Mapeamento JPA incorreto no relacionamento Categoria x Produto:
  - Erro: campo com `@OneToMany` declarado como objeto único em vez de coleção.
  - Solução: ajustar para lista de produtos e alinhar serialização JSON entre as entidades.
- Fluxo de versionamento Git durante reescrita de histórico:
  - Dificuldades com `amend`, `non-fast-forward` e conflitos de rebase.
  - Solução: sincronização com branch remota, resolução de conflitos e push consistente.
- Organização de staging:
  - Necessidade de excluir arquivos específicos do commit sem perder alterações locais.

## Próximas Implementações
- Métodos de Consulta Personalizados
- Autenticação com credenciais (usuário e senha) e token JWT
- Testes Automatizados
- Documentação da API
- Deploy na nuvem

## Observações
Este projeto representa a base de um e-commerce de farmácia e foi estruturado para evolução incremental, com foco inicial em modelagem, relacionamento entre entidades e padronização de endpoints REST.
