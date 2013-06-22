Extra APIs SDK para Java
==============

[desenvolvedores.extra.com.br](http://desenvolvedores.extra.com.br/)

## Visão Geral


Com o intuito de facilitar a integração com suas APIs abertas, o EXTRA disponibiliza esta SDK para integração a partir de aplicações JAVA.

JavaDoc do SDK pode ser encontrado em `/docs`.

Toda a documentação está codificada em UTF-8.

## Pré-requisitos
Para utilizar a API do Extra, é necessário seguir os passos descritos em [Portal - Primeiros Passos](http://desenvolvedores.extra.com.br/api-portal/docs/apilojistav1/main/getting-started.html) para adquirir os tokens de acesso.

## Guia de Instalação

### Instalação por Download de Pacotes

1. Realizar o download dos seguintes arquivos jar:
  * Jersey-Client 1.8
  * Jackson 1.8.5
  * Joda-Time 2.2
  * Commons-Lang 3.0

2. Adicionar os arquivos jar ao projeto.
3. Baixe o arquivo `extra-apis-sdk-1.0.jar` que está na pasta `/target` e o adicione ao seu projeto.

### Instalação por Dependências do Maven

Há duas formas de instalar através do Maven:.
1. Importando e compilando o projeto para seu computador:.
1.1. Baixe o projeto e execute na sua raiz o seguinte comando para criar o jar

  ```bash
      $ mvn install
  ```

1.2. Adicionar a dependência da SDK em seu projeto

```bash
<dependency>
  <groupId>br.com.extra.api</groupId>
  <artifactId>ExtraAPI-SDK</artifactId>
  <version>1.0</version>
</dependency>
```
2. Instalando o jar da SDK no seu repositório maven local:.
2.1. Faça download do arquivo jar `extra-apis-sdk-1.0.jar` que se encontra na pasta `/target` para seu projeto.
2.2. Execute o seguinte comando para adicionar o projeto ao maven local:

```bash
mvn install:install-file -Dfile=<DIRETORIO>\extra-apis-sdk-1.0.jar
-DgroupId=br.com.extra.api
-DartifactId=ExtraAPI-SDK
-Dversion=1.0  
-Dpackaging=jar
```

