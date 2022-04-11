# API - Store

API construída para entrega do projeto final do módulo de Banco de dados com Java do projeto
[Santander Coders web](https://app.becas-santander.com/pt/program/bolsas-santander-tecnologia-santander-coders-web-full-stack-2021)
em parceria com a [Let's Code](https://letscode.com.br/).


## Tecnologias utlizadas

- Java (JDK 17);
- Maven (Gerenciador de dependências);
- Spring Boot (Version 2.66);
- Spring Security;
- Spring JPA;
- Lombok (Dependendencia ultilizada para redução e facilitação de código. )
- PostgreSQL (Database Open Source)
- Insomnia (Software utilizado para executar requisições na API)
- IDE utilizada: Itellij IDEA da JetBrains


## Rodando localmente

###Iniciando a API  
Dentro da pasta raiz do projeto Store, execute no seu terminal o comando:
  
    mvn spring-boot:run


##Considerações importantes

- Configurações do banco de dados:

      #Endereço do Banco de Dados:
      spring.datasource.url=jdbc:postgresql://localhost:5432/store
      
      #Usuário e senha do banco:
      spring.datasource.username=postgres
      spring.datasource.password=root
      
      #Configuração de persistência de dados:    
      spring.jpa.hibernate.ddl-auto=create-drop

- Configurações de segurança do Spring Security

      #Usuário de acesso a API para utilizar os endpoints:
      Usuário: root
      Senha: acesso

  ####Observação: Essas configurações podem ser alteradas de acordo com sua necessidade.


## Endpoints para acesso aos dados

- Listar Pedidos: [METHOD: GET] localhost:8080/pedido/listar-pedidos

      -> Retorna a lista de todos os pedidos da tabela Pedidos do banco de dados.


- Adicionar Pedido: [METHOD: POST] localhost:8080/pedido/novopedido**

      Exemplo de envio via POST para adicionar um novo Pedido

      {        
        "cliente": "Pedro",
        "qtdProdutos": 3,
        "valorTotal": 28.55
      }
    
       -> Retorna a mensagem: Pedido Criado Com Sucesso.


- Alterar Pedido: [METHOD: PUT] localhost:8080/pedido/alterar-pedido**

      Exemplo de envio via PUT para alterar um Pedido. Deve-se passar
      o pedido de forma completa da forma como ele existe no banco de dados

      { 
        "id": 1,      
        "cliente": "Pedro",
        "qtdProdutos": 3,
        "valorTotal": 28.55
        "statusPedido": "Pedido Realizado"
      }

      Agora alterando alguma informação: qtdProdutos e valorTotal foram alterados.

      Enviamos essas informações com as novas alterações no corpo da requisição da API.
      { 
        "id": 1,      
        "cliente": "Pedro",
        "qtdProdutos": 5,
        "valorTotal": 48.20
        "statusPedido": "Pedido Realizado"
      }

      -> Retorna a mensagem: Pedido Alterado Com Sucesso.


- Excluir Pedido: [METHOD: DELETE] localhost:8080/pedido/excluir-pedido/{id}**

      Para exemplo: No banco de dados temos o pedido:
      { 
        "id": 1,      
        "cliente": "Pedro",
        "qtdProdutos": 5,
        "valorTotal": 48.20
        "statusPedido": "Pedido Realizado"
      }

      Para excluir o pedido de exemplo acima, passamos o id do pedido
      como mostrado no exemplo abaixo:
    
      localhost:8080/pedido/excluir-pedido/1

      -> Retorna a mensagem: Pedido Exluido Com Sucesso.


