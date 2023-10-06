# hackaton-fiap
Hackaton HackForChange FIAP + Alura + Passos Mágicos

Projeto desenvolvido para o Hackaton #HackForChange organizado pela FIAP + Alura, em parceria com a ONG Passos Mágicos!

A ideia central dessa API é servir como uma Plataforma de Mentoria.


Este projeto usa Quarkus, o Supersonic Subatomic Java Framework.

Se você quiser saber mais sobre o Quarkus, visite seu site: https://quarkus.io/.

## Primeiramente é preciso subir o banco de dados
Você pode subir o banco de dados PostgreSQL usando o comando:
```shell script
docker-compose up
```

## Executando o aplicativo em modo dev

Você pode executar seu aplicativo no modo de desenvolvimento que permite codificação ao vivo usando:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTA:_** O Quarkus agora vem com uma Dev UI, que está disponível no dev mode apenas em http://localhost:8080/q/dev/.

## Empacotando e executando o aplicativo

O aplicativo pode ser empacotado usando:
```shell script
./mvnw package
```
Ele produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.
Esteja ciente de que não é um _über-jar_ pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

O aplicativo agora pode ser executado usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se você deseja construir um _über-jar_, execute o seguinte comando:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

O aplicativo, empacotado como um _über-jar_, agora pode ser executado usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando:
```shell script
./mvnw package -Dnative
```

OOu, se você não tiver o GraalVM instalado, você pode executar a compilação executável nativa em um contêiner usando:
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/hackaton-fiap-1.0.0-SNAPSHOT-runner`

Se você quiser saber mais sobre como construir executáveis nativos, consulte https://quarkus.io/guides/maven-tooling.

## Arquivos e Diretórios

Neste projeto utilizamos a estratégia de _package by feature_.
Além disso ele foi inspirado nos conceitos da [Tomato Architecture](https://www.sivalabs.in/tomato-architecture-pragmatic-approach-to-software-design/)

```
.
├── Quarkus
├── src
│   └── main
│       └── java
│           ├── org.hackforchange.mentoria
│           ├── org.hackforchange.mentoria.aplicacao
│           ├── org.hackforchange.mentoria.aplicacao.dtos
│           ├── org.hackforchange.mentoria.aplicacao.mappers
│           ├── org.hackforchange.mentoria.dominio
│           └── org.hackforchange.mentoria.infra
├── src
│   └── main
│       └── resources
│           ├── META-INF.resources
│           │   └── index.html 
│           ├── application.properties
│           └── import.sql
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── target
│   └──hackaton-fiap-1.0.0-SNAPSHOT.jar
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## pacotes

- `aplicacao` —  camada de aplicação;
- `dominio` —  camada de domínio;
- `infra` —  camada de infraestrutura;
- `resources/application.properties` - arquivo de configuração
- `test/` - testes unitários e de integração
- `pom.xml` - dependências do projeto


## Guias relacionados

- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Valide propriedades de objetos (campo, getter) e parâmetros de método para seus beans (REST, CDI, Jakarta Persistence)
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): documente suas APIs REST com OpenAPI - vem com Swagger UI
- RESTEasy Reactive ([guia](https://quarkus.io/guides/resteasy-reactive)): Uma implementação REST de Jacarta utilizando processamento de tempo de construção e Vert.x. Esta extensão não é compatível com a extensão quarkus-resteasy ou com qualquer uma das extensões que dela dependem.
- Cliente PostgreSQL reativo ([guide](https://quarkus.io/guides/reactive-sql-clients)): Conecte-se ao banco de dados PostgreSQL usando o padrão reativo

## Código fornecido

### RESTEasy reativo

Inicie facilmente seus serviços Web RESTful reativos

[Seção do guia relacionado...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)