## Projeto do Grupo 4 da turma de Análise e desenvolvimento de sistemas: Calculadora de IMC

### Requisitos para execução

Docker
Docker Compose
ou
Mysql 5.7
Java 17
e
Node 12.22.12

### Como executar

O usuário entrar no diretório calculadoraimc-api e executar a seguinte sequência de comandos:

***Levantar o banco de dados através do Docker:***

```bash
docker-compose up -d mysql
```

Após isso é necessário aguardar o container ficar health e em seguinda executar:

***Levantar a aplicação de backend através do Docker***

```bash
docker-compose up -d api
```

*O usuário também poderá fazer o uso do Mysql de forma standalone instalado na máquina*

Outra forma de levantar o backend é fazendo uso do maven para rodar a aplicação:
```bash
./mvnw spring-boot:run
```

Após a execução do banco de dados e da aplicação de backend é possível executar a aplicação de frontend com o seguinte comando:

```bash
npm run start
```
