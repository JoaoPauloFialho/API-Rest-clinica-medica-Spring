# API Rest Spring Boot

Nesse repositório contém uma API Rest criada utilizando o framework Spring Boot, ela ainda está incompleta por ser um projeto voltado para estudos, irei implementar nela aos poucos conhecimentos adquiridos com o tempo. Atualmente ela possui suporte para os diversos tipos de requisições, um histórico de migraçoes sql ppara controlar as modificações no banco de dados e validações utilizando a biblioteca Bean Validation

# Utilizando a API

Configure as dependências no pom.xml de acordo com o banco de dados de sua preferência (O default da aplicação é o Mysql),  configure o acesso ao banco de dados no recourses/application.properties e depois baixe alguma ferramenta para simular requisições como o PostMan ou o Imsomnia. Pronto, agora é só fazer o build do projeto, iniciar a aplicação dando run no ApiApplication.java e testar a API com o Postman ou o Imsomnia
