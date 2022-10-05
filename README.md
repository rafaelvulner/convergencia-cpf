# CPF API
Este projeto é destinado a cadastro e verificação de status CPF


## Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 17: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven 3++: Necessário para realizar o build do projeto Java](https://maven.apache.org/download.cgi)
- [Docker: Caso queira subir uma imagem](https://www.docker.com/)
- [Git: Necessário para clonar o projeto](https://git-scm.com/)


## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto [convergencia-cpf](https://github.com/rafaelvulner/convergencia-cpf.git) do GitHUb em um diretório de sua preferência:

- `convergencia-cpf`: git clone https://github.com/rafaelvulner/convergencia-cpf.git


## Construção (Build)

Para construir o projeto com o Maven, executar os comando abaixo:

- `mvn clean install` executar esse comando para baixar as dependências
- `mvn clean install -P dev` para rodar em ambiente DEV

O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.


## Commits

Faça comite nas sua branch de desenvolvimento, faça um `merge-request` e solicite ao seu DEV-LEAD ou um dev com mais experiência para revisar seu código e aprovar o merge.


## Tecnologias utilizadas

- [Spring-boot](https://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html)
- [H2](https://www.h2database.com/html/main.html)
- [Maven](https://maven.apache.org/index.html)
- [Java 17](https://www.oracle.com/java/technologies/javase-jdk8-doc-downloads.html)
- [Lombok](https://projectlombok.org/)


## DB's

A aplicação necessita de bancos de dados relacionais (MySQL, ou H2 em caso de uma execução local/desenvolvimento):

 - [H2](https://www.h2database.com/html/main.html)
 - [MySQL](https://www.mysql.com/downloads/)

## Boas práticas
- Sempre se certifique de não ter quebrado nenhum outro código.

- Faça build do projeto e execute-o antes de fazer commit das suas alterações.

- Utilizar o Retryable para a retentativa no código, conforme as exceções mapeadas dentro dos clients/services;

## Melhorias a serem feitas
- Testes funcionais e integrados
- Detalhar mais a documentação via OpenApi



## Rodando os testes 

Para rodar os testes, realize o seguinte comando

```bash
# Rodar todos os testes 
$ mvn test

# Rodar penas uma classe
$ mvn -Dtest=TestApp1 test
```


## Rodando local

Clonar o projeto no diretorio de sua preferencia

```bash
  git clone https://github.com/rafaelvulner/convergencia-cpf.git
```

Ir para o diretorio do projeto

```bash
  cd convergencia-cpf
```

Instalar dependencias

```bash
  mvn clean install
```

Setar o profile conforme ambiente

```bash
  -Dspring.profiles.active=dev
```

Subir o docker compose (Caso haja)

```bash
  docker-compose up
```

Rodar a aplicação

```bash
  mvn spring-boot:run
```


