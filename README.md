# Projeto: API Pix com Cadastro de Conta Bancária

## Visão Geral
Este projeto implementa uma API RESTful para realizar transferências via Pix e gerenciar contas bancárias. Ele foi desenvolvido com **Java**, utilizando **Spring Boot**, **H2 Database** para persistência, e segue boas práticas de design como a separação de responsabilidades em camadas (Controller, Service e Repository).

## Funcionalidades
- **Gerenciamento de Contas Bancárias**:
  - Cadastro de novas contas bancárias.
  - Consulta de contas por chave Pix.
- **Transferências via Pix**:
  - Realizar transferências de valores entre contas utilizando chaves Pix.

## Tecnologias Utilizadas
- **Java 11**
- **Spring Boot 2.5.6**
- **H2 Database**
- **Lombok**
- **Maven**
- **Swagger/OpenAPI**

## Estrutura do Projeto
O projeto segue a estrutura de pacotes padrão para projetos Spring Boot:

```
src/
├── main/
│   ├── java/org/example/apipix/
│   │   ├── controller/      # Controllers (camada de entrada)
│   │   ├── model/           # Modelos e entidades JPA
│   │   ├── service/         # Interfaces e implementações de serviços
│   │   ├── repository/      # Repositórios JPA
│   │   └── dto/             # Data Transfer Objects (DTOs)
│   └── resources/
│       ├── application.properties # Configurações da aplicação
│       └── data.sql         # Dados iniciais para o banco de dados H2
└── test/
    └── java/               # Testes unitários e de integração
```

## Endpoints da API
### Contas Bancárias
#### Criar Conta
- **POST** `/api/contas`
- **Descrição**: Cadastra uma nova conta bancária.
- **Request Body**:
  ```json
  {
    "titular": "João da Silva",
    "chavePix": "123456a",
    "tipoConta": "CORRENTE",
    "saldo": 500.00
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "titular": "João da Silva",
    "chavePix": "123456a",
    "tipoConta": "CORRENTE",
    "saldo": 500.00
  }
  ```
### Transferências via Pix
#### Realizar Transferência
- **POST** `/api/pix/transferir`
- **Descrição**: Realiza uma transferência de valores entre contas.
- **Request Body**:
  ```json
  {
    "chavePixOrigem": "123456a",
    "chavePixDestino": "654321b",
    "valor": 100.00,
    "descricao": "Pagamento de serviço"
  }
  ```
- **Response**:
  ```json
  {
    "status": "Sucesso",
    "mensagem": "Transferencia realizada com Sucesso",
    "dataTransacao": "2025-01-14T17:13:22.8577866"
  }
  ```

## Configuração e Execução
### Pré-requisitos
- **JDK 11+**
- **Maven**

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-pix.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd api-pix
   ```
3. Compile o projeto e baixe as dependências:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse o Swagger para explorar os endpoints:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Banco de Dados H2
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `victor`
- Password: 123
---

