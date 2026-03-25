# Projeto Spring Boot Kotlin para Raspberry Pi GPIO

Este projeto é uma aplicação Spring Boot desenvolvida em Kotlin para controlar LEDs conectados a um Raspberry Pi através da biblioteca Pi4J.

## Funcionalidades

O projeto oferece uma API REST para controlar sequências de LEDs. Ele implementa diferentes estratégias de iluminação que podem ser ativadas via requisições HTTP.

### Controle de LEDs

O sistema gerencia 6 LEDs conectados aos pinos GPIO do Raspberry Pi. O controle é feito através da classe `LedManager`, que utiliza corrotinas Kotlin para gerenciar o loop de efeitos de forma assíncrona sem bloquear a thread principal.

### Efeitos Disponíveis

Os efeitos são implementados utilizando o padrão Strategy, permitindo fácil adição de novos padrões. Os efeitos atuais são:

1.  **Simples** (`simples`): Acende um LED de cada vez em sequência.
2.  **Cumulativo** (`cumulativo`): Acende os LEDs um por um, mantendo os anteriores acesos.
3.  **Abertura** (`abertura`): Acende os LEDs do centro para as extremidades.
4.  **Fechamento** (`fechamento`): Acende os LEDs das extremidades para o centro.

### API REST

O controlador `LedController` expõe o seguinte endpoint:

*   `GET /led/{type}`: Ativa um efeito de LED.
    *   `{type}`: O nome do efeito desejado (ex: `simples`, `cumulativo`, `abertura`, `fechamento`).
    *   Se o tipo não for reconhecido, o loop de efeitos é pausado e os LEDs são desligados.

## Estrutura do Projeto

*   **`src/main/kotlin/com/raspberry/inicial`**: Código fonte da aplicação.
    *   **`annotation`**: Contém a anotação `@Strategy` usada para identificar as implementações de estratégias.
    *   **`constant`**: Enums, como `SequencialEnum` que mapeia os nomes dos efeitos.
    *   **`controller`**: Controladores REST (Spring MVC).
    *   **`data`**: Classes de dados.
    *   **`factory`**: Funções utilitárias para criação de instâncias `DigitalOutput` do Pi4J.
    *   **`service`**: Lógica de negócio, incluindo o `LedManager`.
    *   **`strategy`**: Interface e implementações dos efeitos de LED.

## Tecnologias Utilizadas

*   **Kotlin**: Linguagem de programação principal.
*   **Spring Boot**: Framework para criação da aplicação web e injeção de dependência.
*   **Pi4J (v3.0.3)**: Biblioteca para I/O no Raspberry Pi.
*   **Maven**: Gerenciador de dependências e build.

## Como Executar

Para executar o projeto, certifique-se de ter o JDK 21 instalado e Maven configurado.

```bash
mvn spring-boot:run
```

Ou empacote o jar:

```bash
mvn clean package
java -jar target/inicial-0.0.1-SNAPSHOT.jar
```

Observação: A execução completa das funcionalidades de GPIO requer que a aplicação esteja rodando em um Raspberry Pi com as devidas permissões e hardware conectado.
