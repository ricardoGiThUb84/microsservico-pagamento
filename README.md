## Projeto

Uma api de pedidos de restaurante (Alurafood) treinamento elaborado pela equipe alura. 


### [Service Discovery com Eureka e Spring Cloud](https://docs.spring.io/spring-cloud-netflix/)

Eureka é um serviço de descoberta de serviços da Netflix, integrado ao Spring Cloud, que facilita a localização e registro de serviços em arquiteturas de microserviços. Ele atua como um "registro de serviço" onde cada microserviço se registra ao iniciar, fornecendo informações como nome e endereço. Isso permite que outros serviços encontrem e se comuniquem com ele dinamicamente.

#### Principais Funcionalidades

- **Registro de Serviços**: Serviços se registram automaticamente ao iniciar.
- **Descoberta de Serviços**: Serviços clientes consultam o registro para encontrar serviços disponíveis.
- **Escalabilidade e Alta Disponibilidade**: Suporte para múltiplos servidores Eureka para garantir resiliência.

#### Benefícios

- **Descentralização**: Reduz dependências de configuração estática de URLs.
- **Flexibilidade**: Permite adicionar e remover serviços sem necessidade de reconfiguração manual.<br><br>


