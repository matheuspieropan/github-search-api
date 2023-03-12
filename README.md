# github-search-api

## Acesso o projeto
<a href="https://pieropan.vercel.app/">Clique aqui</a>
<hr>

## Como Funciona
Github-Search tem como finalidade consumir recursos da API do GitHub. O sistema foi elaborado para consumir dois endpoints
- Serviço para obter as informações do user name (data da criação no github, url do seu avatar, bio etc.) recebido como parâmetro
```https://pieropan.up.railway.app/api/search/user/{username}``` <br><br>
- Serviço para obter os repositórios do user name recebido como parâmetro
```https://pieropan.up.railway.app/api/search/repositorie/{username}```

## Tecnologias utilizadas
- Java 
- Spring Boot
<hr>

### Recursos utilizados
Sistema desenvolvido segue boas práticas de uma API REST. Projeto em camadas: controladores e services. Data Transfer Object (dto) como retono
para o frontend. Implementação da classe GlobalExceptionHandler. Que através de anotações como <b>@ControllerAdvice @ExceptionHandler</b> conseguimos tratar as exceções
do projeto, informando a mensagem do erro ocorrido e o status HTTP.
