# Projeto AluraFlix
Esta é a documentação da API do projeto AluraFlix. Abaixo, você encontrará informações sobre os recursos disponíveis, os endpoints e os parâmetros necessários para interagir com a API.

# Visão Geral
A API do AluraFlix é desenvolvida usando a linguagem de programação Java e o framework Spring Boot. Ela utiliza o padrão de arquitetura REST para fornecer acesso aos recursos relacionados aos vídeos.

# Configuração
Antes de utilizar a API, você precisa configurar o ambiente de desenvolvimento local seguindo as etapas abaixo:

1. Certifique-se de ter o Java JDK (versão 8 ou superior) instalado em sua máquina.
2. Clone o repositório do projeto AluraFlix para sua máquina local.
3. Navegue até o diretório raiz do projeto e execute o seguinte comando para compilar e executar a API:
   ˋ$ mvn spring-boot:runˋ

   Endpoints
A seguir, estão listados os principais endpoints da API do AluraFlix:

Recurso de Vídeos
Listar todos os vídeos

bash
Copy code
GET /api/v1/videos
Este endpoint retorna todos os vídeos cadastrados no AluraFlix.

Obter um vídeo específico

bash
Copy code
GET /api/v1/videos/{id}
Este endpoint retorna as informações de um vídeo específico com base no ID fornecido.

Cadastrar um novo vídeo

bash
Copy code
POST /api/v1/videos
Content-Type: application/json

{
  "id": <integer>,
  "titulo": <string>,
  "descricao": <string>,
  "url": <string>
}
Este endpoint permite cadastrar um novo vídeo. É necessário fornecer os seguintes parâmetros no corpo da solicitação:

id (obrigatório): o ID do vídeo.
titulo (obrigatório): o título do vídeo.
descricao (obrigatório): a descrição do vídeo.
url (obrigatório): a URL do vídeo.
Atualizar um vídeo existente

bash
Copy code
PUT /api/v1/videos/{id}
Content-Type: application/json

{
  "id": <integer>,
  "titulo": <string>,
  "descricao": <string>,
  "url": <string>
}
Este endpoint permite atualizar as informações de um vídeo existente. É necessário fornecer os seguintes parâmetros no corpo da solicitação:

id (obrigatório): o ID do vídeo.
titulo (obrigatório): o novo título do vídeo.
descricao (obrigatório): a nova descrição do vídeo.
url (obrigatório): a nova URL do vídeo.
Excluir um vídeo

bash
Copy code
DELETE /api/v1/videos/{id}
Este endpoint permite excluir um vídeo específico com base no ID fornecido.

Exemplos de Uso
Aqui estão alguns exemplos de uso da API do AluraFlix:

Listar todos os vídeos:
bash
Copy code
GET /api/v1/videos
Obter um vídeo específico:
bash
Copy code
GET /api/v1/videos/{id}
Cadastrar um novo vídeo:
bash
Copy code
POST /api/v1/videos
Content-Type: application/json

{
  "id": 1,
  "titulo": "Meu Vídeo",
  "descricao": "Descrição do meu vídeo",
  "url": "https://www.youtube.com/watch?v=abc123"
}
Atualizar um vídeo existente:
bash
Copy code
PUT /api/v1/videos/{id}
Content-Type: application/json

{
  "id": 1,
  "titulo": "Meu Vídeo Atualizado",
  "descricao": "Descrição atualizada do meu vídeo",
  "url": "https://www.youtube.com/watch?v=def456"
}
Excluir um vídeo:
bash
Copy code
DELETE /api/v1/videos/{id}

