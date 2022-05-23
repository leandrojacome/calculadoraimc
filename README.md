Node 12.22.12

### Como executar

O usuário entrar no diretório calculadoraimc-api e executar a seguinte sequência de comandos:

**_Levantar o banco de dados através do Docker:_**

```bash
docker-compose up -d mysql
```

Após isso é necessário aguardar o container ficar health e em seguinda executar:

**_Levantar a aplicação de backend através do Docker_**

```bash
docker-compose up -d api
```

_O usuário também poderá fazer o uso do Mysql de forma standalone instalado na máquina_

Outra forma de levantar o backend é fazendo uso do maven para rodar a aplicação:

```bash
./mvnw spring-boot:run
```

Após a execução do banco de dados e da aplicação de backend é possível executar a aplicação de frontend com o seguinte comando:

```bash
npm run start
```
