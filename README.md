# ENTERPRISE CONNECTION BRQ

Tecnologias utilizadas:
- Java 8
- Spring Boot
- Maven
- H2 Database 

Instruções de uso:

1) Importar o projeto na sua IDE de preferencia (IntelliJ / Eclipse) como maven project
2) Executar a classe main: BrqApplication e aguardar o projeto subir, no console podemos observar que sobe na porta 8080
3) Como o banco de dados utlizado H2 roda em memória e não guarda dados enquanto a aplicação não está de pé, foi criado um script(data.sql) em src/main/resources que automaticamente popula o banco com alguns registros no momento em que o projeto sobe

Para acessar o banco, após o projeto estar de pé, acessar a url: http://localhost:8080/h2-console
Preencher os campos com os seguintes dados de acordo com a imagem abaixo: 

![image](https://user-images.githubusercontent.com/62717114/166119308-c9342405-7b2c-447e-9d9c-b6395f1b43ae.png)

Para trabalhar com a API, basta utilizar o Swagger, acessando a url: http://localhost:8080/swagger-ui/index.html

É possível trabalhar com todos os endpoints, desde buscas pelas palavras-chave e o de cadastro.

Atenção para o endpoint que é o diferencial da entrega: 

Nele é feita uma busca pela skill por query param, onde:
  * Caso a skill informada exista no banco de dados, trará os registros dos candidatos que possuem essa skill e pela ordem de ranking (quais possuem a skill mas também possuem a certificaç!ao referente aquela skill)
  * Caso não seja informada nenhuma skill, trará todos os registros inseridos no banco de dados com paginação configurada de 10 registros para cada página
  * Caso a skill não seja encontrada, retornará uma lista vazia

Os demais endpoints que buscam por palavras-chave, trazem o registro caso encontrado e caso não encontrado, retorna um 404 Not found.

O endpoint de criação caso consiga criar com sucesso, retorn um 201 Created.
