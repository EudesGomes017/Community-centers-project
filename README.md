#  Microservices - Community Centers API

Este projeto é parte de um sistema de microserviços responsável por gerenciar **centros comunitários** durante emergências, como desastres naturais. A API permite o cadastro, gestão de ocupação, troca de recursos entre centros e emissão de relatórios estratégicos.

![Demonstração BackEnd](Animação.gif)

---

##  Visão Geral

A API gerencia centros comunitários e seus recursos (médicos, voluntários, veículos, etc), permitindo:

- Cadastro e edição de centros
- Atualização da ocupação
- Troca de recursos entre centros com validação de regras
- Geração de relatórios em PDF
- Notificações de capacidade excedida

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| Java 21 | Linguagem principal |
| Spring Boot | Framework web |
| MongoDB | Banco de dados NoSQL |
| Docker + Docker Compose | Ambiente de container |
| Swagger / SpringDoc | Documentação interativa da API |
| JUnit 5 + Mockito | Testes unitários |
| Lombok | Redução de boilerplate |
| iText | Geração de PDF |

---

## ⚙️ Funcionalidades

### ✅ CRUD de Centros Comunitários
- Cadastro com recursos iniciais
- Atualização de ocupação (com alerta se exceder limite)
- Consulta por ID e listagem geral
- Remoção de centros

### 🔁 Troca de Recursos
- Troca entre dois centros com validação de pontos
- Regra de exceção para centros com ocupação > 90%
- Histórico de negociações salvo

### 📊 Relatórios
- Centros com ocupação acima de 90%
- Média de recursos por centro
- Histórico de trocas (filtro por centro e data)
- Todos exportáveis em PDF

### 📢 Notificações
- Publicação de evento interno quando ocupação atinge o limite

### 🧪 Testes
- Cobertura de serviços
- Validação de regras de negócio
- Testes de controllers com MockMvc
- Classe de `Factory` para mocks

---

## 🧱 Arquitetura

- Padrões SOLID aplicados
- Separação clara por camadas:
  - `controller`, `service`, `repository`, `dto`, `model`, `exception`
- Regras de negócio isoladas em serviços
- Publisher de notificação desacoplado por interface

---

## 📦 Como Rodar

### Pré-requisitos

- Docker
- Maven 3.9+
- Java 21

### Subir com Docker Compose

```
docker-compose up --build
Rodar Localmente

./mvnw spring-boot:run
MongoDB será automaticamente conectado na URI:

mongodb://localhost:27017/centrosdb
📚 Swagger
Acesse a documentação interativa em:

http://localhost:9098/swagger-ui.html
Ou diretamente:

http://localhost:9098/swagger-ui/index.html
🔄 Regras de Pontuação dos Recursos
Recurso	Pontos
Médico	4
Voluntário	3
Kit Médico	7
Veículo de Transporte	5
Cesta Básica	2

Trocas precisam ter a mesma pontuação — exceto se um dos centros estiver com ocupação > 90%.

🧪 Rodando os Testes
./mvnw test
Testes unitários para serviços

Testes de integração com MockMvc

Validações REST e exceções

👤 Autor
Eudes Gomes
LinkedIn: [[Seu LinkedIn]](https://www.linkedin.com/in/eudes-gomes-1b3b94b5/)
