# Especificações

A aplicação em questão, foi desenvolvida e utiliza as seguintes tecnologias:
1 - Java 17
2 - Spring boot 3
3 - Flyway
4 - Mapper
5 - Banco de dados in memory H2
6 - Swagger
7 - Lombok

Os testes unitários foram desenvolvidos utilizando:
1 - Junit 5
2 - Mockito

# Rodando a aplicação

A aplicação foi construída para ser executada de forma simples, basta seguir as etapas abaixo:

1 - Build -> Para executar o build, basta ter o maven instalado e executar o comando 'mvn install'
2 - Execução -> Após executado o build, a pasta 'target' será criada e o JAR da aplicação aparecerá na mesma. Para executá-lo basta executar 'java -jar .\challenge-0.0.1-SNAPSHOT.jar'.

# Imagem docker para executar a aplicação

Foi criado uma imagem docker para executar a aplicação de forma mais simples. Após gerar o build da aplicaçaõ, é possível executa-la.

A imagem foi feita em cima do SO alpine para ficar mais leve.

# Acessando os serviços da aplicação

Para facilitar a utilização da mesma, foi utlizado documentação de api (Swagger), para acessá-lo basta acess-la, basta rodar a aplicação e acessar o link:

http://localhost:8080/swagger-ui.html

