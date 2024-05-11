# tokio_marine_challenge

Esse é o repositório do back-end do desafio proposto pela tokio marine.

# Como subir o back-end

Para subir o back-end será necessário fazer o clone do repositório e ter o java instaladdo

Após clonar o repositório pode -se ir diretamente na pasta runnable que lá se encontra o arquivo .jar.

Ele pode ser ececutado via cmd como o exemplo abaixo ou executando o .jar diretamente.
 
```cmd

    cd C:\Repositorios\tokio_marine_challenge\project\runnable

    java -jar springboot-backend-0.0.1-SNAPSHOT

```

# Técnologias usadas

    Java 11;
    H2Databse;
    Lombok;
    Maven;
    springdoc-openapi-starter-webmvc-ui
    SpringInitializer

# Decisões de arquitetura

Para a Arquitetura do back-end utilizei um padrão de 3 camadas (Controler, Service e Repository), para deixar o projeto mais simples e ao mesmo tempo mais desacoplado, utilizando principalmente a injeção de dependencia e segregando a responsabilidade de cada camada. 
Há também uma camada própria visando a criação de Testes Unitário

# Observações

O projeto tem margem para a implementação de muitas outras funcionalidades e principalmente, melhorias de arquitetura visando melhorar ainda mais o desacoplamento entre as camadas

