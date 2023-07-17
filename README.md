# News App

Este é um projeto de aplicativo de notícias com uma REST API desenvolvida usando Spring Boot no backend e uma interface de usuário usando Vue.js no frontend.

## Backend

O backend é desenvolvido usando o framework Spring Boot e Java. Ele fornece uma API REST para gerenciar notícias, permitindo a criação, leitura, atualização e exclusão de notícias.

### Tecnologias utilizadas

- Spring Boot
- Java
- Spring Data JPA
- H2 Database (em memória)

### Configuração

1. Certifique-se de ter o Java JDK instalado no seu sistema.
2. Clone este repositório.
3. Navegue até o diretório `backend` e execute o seguinte comando para iniciar o servidor Spring Boot:
 ./mvnw spring-boot:run


   
4. O servidor estará em execução em `http://localhost:8080/api`.

## Frontend

O frontend é desenvolvido usando o framework Vue.js e permite visualizar e interagir com as notícias fornecidas pela API REST do backend.

### Tecnologias utilizadas

- Vue.js
- Vue Router
- Axios

### Configuração

1. Certifique-se de ter o Node.js instalado no seu sistema.
2. Navegue até o diretório `frontend` e execute o seguinte comando para instalar as dependências:
   
```bash
npm install
```
4. Após a conclusão da instalação, execute o seguinte comando para iniciar o servidor de desenvolvimento:
   
```bash
npm run serve
```
5. O servidor de desenvolvimento estará em execução em `http://localhost:8081`.

## Como usar

1. Acesse a interface de usuário em `http://localhost:8081` no seu navegador.
2. Na página inicial, você verá a lista de notícias disponíveis.
3. Clique em uma notícia para ver os detalhes.
4. Na página de detalhes, você pode editar ou excluir a notícia.
5. Para adicionar uma nova notícia, clique no botão "Adicionar Notícia" na página inicial.


## Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).






