
# Imagem filmes
Desafio técnico

1.  Alterar script de criação de banco de dados para incluir tabelas
    de  pedido e pedido_item de acordo com respectivas entidades;

2. Alterar script de carga de dados para incluir dados de pedidos;

3. Implementar os endpoints pendentes

### Requisitos
```Java 18```

### Como rodar
```mvn spring-boot:run```

### Endpoint de exemplo:
http://localhost:8080/pessoas/listar

### Script criacao tabelas:
```schema.sql```

### Scripts carga de dados:
```data.sql```

### Acesso a console banco de dados:
URL: ```http://localhost:8080/h2```  
JDBC URL:: ```jdbc:h2:mem:testdb```  
User Name: ```sa```  
Password: ``
