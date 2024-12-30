# Votação

## Objetivo

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. Imagine que você deve criar uma solução para dispositivos móveis para gerenciar e participar dessas sessões de votação.
Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

- Cadastrar uma nova pauta
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por
  um tempo determinado na chamada de abertura ou 1 minuto por default)
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado
  é identificado por um id único e pode votar apenas uma vez por pauta)
- Contabilizar os votos e dar o resultado da votação na pauta

Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A solução deve ser construída em java, usando Spring-boot, mas os frameworks e bibliotecas são de livre escolha (desde que não infrinja direitos de uso).

É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

O foco dessa avaliação é a comunicação entre o backend e o aplicativo mobile. Essa comunicação é feita através de mensagens no formato JSON, onde essas mensagens serão interpretadas pelo cliente para montar as telas onde o usuário vai interagir com o sistema. A aplicação cliente não faz parte da avaliação, apenas os componentes do servidor. O formato padrão dessas mensagens será detalhado no anexo 1.

## Como proceder

Por favor, realize o FORK desse repositório e implemente sua solução no FORK em seu repositório GItHub, ao final, notifique da conclusão para que possamos analisar o código implementado.

Lembre de deixar todas as orientações necessárias para executar o seu código.

### Tarefas bônus

- Tarefa Bônus 1 - Integração com sistemas externos
  - Criar uma Facade/Client Fake que retorna aleátoriamente se um CPF recebido é válido ou não.
  - Caso o CPF seja inválido, a API retornará o HTTP Status 404 (Not found). Você pode usar geradores de CPF para gerar CPFs válidos
  - Caso o CPF seja válido, a API retornará se o usuário pode (ABLE_TO_VOTE) ou não pode (UNABLE_TO_VOTE) executar a operação. Essa operação retorna resultados aleatórios, portanto um mesmo CPF pode funcionar em um teste e não funcionar no outro.

```
// CPF Ok para votar
{
    "status": "ABLE_TO_VOTE
}
// CPF Nao Ok para votar - retornar 404 no client tb
{
    "status": "UNABLE_TO_VOTE
}
```

Exemplos de retorno do serviço

### Tarefa Bônus 2 - Performance

- Imagine que sua aplicação possa ser usada em cenários que existam centenas de
  milhares de votos. Ela deve se comportar de maneira performática nesses
  cenários
- Testes de performance são uma boa maneira de garantir e observar como sua
  aplicação se comporta

### Tarefa Bônus 3 - Versionamento da API

○ Como você versionaria a API da sua aplicação? Que estratégia usar?

## O que será analisado

- Simplicidade no design da solução (evitar over engineering)
- Organização do código
- Arquitetura do projeto
- Boas práticas de programação (manutenibilidade, legibilidade etc)
- Possíveis bugs
- Tratamento de erros e exceções
- Explicação breve do porquê das escolhas tomadas durante o desenvolvimento da solução
- Uso de testes automatizados e ferramentas de qualidade
- Limpeza do código
- Documentação do código e da API
- Logs da aplicação
- Mensagens e organização dos commits

## Dicas

- Teste bem sua solução, evite bugs
- Deixe o domínio das URLs de callback passiveis de alteração via configuração, para facilitar
  o teste tanto no emulador, quanto em dispositivos fisicos.
  Observações importantes
- Não inicie o teste sem sanar todas as dúvidas
- Iremos executar a aplicação para testá-la, cuide com qualquer dependência externa e
  deixe claro caso haja instruções especiais para execução do mesmo
  Classificação da informação: Uso Interno

## Anexo 1

### Introdução

A seguir serão detalhados os tipos de tela que o cliente mobile suporta, assim como os tipos de campos disponíveis para a interação do usuário.

### Tipo de tela – FORMULARIO

A tela do tipo FORMULARIO exibe uma coleção de campos (itens) e possui um ou dois botões de ação na parte inferior.

O aplicativo envia uma requisição POST para a url informada e com o body definido pelo objeto dentro de cada botão quando o mesmo é acionado. Nos casos onde temos campos de entrada
de dados na tela, os valores informados pelo usuário são adicionados ao corpo da requisição. Abaixo o exemplo da requisição que o aplicativo vai fazer quando o botão “Ação 1” for acionado:

```
POST http://seudominio.com/ACAO1
{
    “campo1”: “valor1”,
    “campo2”: 123,
    “idCampoTexto”: “Texto”,
    “idCampoNumerico: 999
    “idCampoData”: “01/01/2000”
}
```

Obs: o formato da url acima é meramente ilustrativo e não define qualquer padrão de formato.

### Tipo de tela – SELECAO

A tela do tipo SELECAO exibe uma lista de opções para que o usuário.

O aplicativo envia uma requisição POST para a url informada e com o body definido pelo objeto dentro de cada item da lista de seleção, quando o mesmo é acionado, semelhando ao funcionamento dos botões da tela FORMULARIO.

# desafio-votacao

# regras para rodar o teste
# INSTRUÇÕES DA API DE VOTAÇÃO
# 1° passo
OBS: Para rodar a API localmente, faça um clone do projeto, instale o MySQL na sua maquina ou crie um 
container Docker das duas formas funciona adicione as regras de usuário senha e as siga as intruções de
instalação do MySQL na sua máquina que vc pode ver em qualquer tutorial no youtube ou na documentação da
Oracle.

# 2° passo MySQL
Criar a base de dados no MySQL. VERSÃO DO MySQL:8.0.39

# 3° passo rodar o projeto na sua máquina.
Feito isso é só subir o projeto na tua máquina, usando o STS, Eclipse ou Intellij qualquer uma dessas 
interfaces vai funcionar ou IDE de sua preferência.

# 4° passo framework do projeto
O Spring Boot 3.4.0 é a versão que eu uso no momento para gerar o projeto e vai gerar as tabelas e 
adcionar os dados já existentes se tiverem ou criar novos dados.

# 5° passo fazer o build do projeto
RODAR O COMANDO build: Clique com botão direito do mouse na raiz do projeto, vá até a opção Maven e ai
clique em (RELOAD PROJECT) para que o Maven atualize as dependêcias do projeto.

# 6° passo url usadas para teste
POST http://localhost:8080/clientes GET http://localhost:8080/clientes
POST http://localhost:8080/sessoes  GET http://localhost:8080/sessoes

# 7° passo comando para rodar o docker
docker-compose -f mysql-docker-compose.yml up -d OBS: rodei na porta:3307, porque na minha máquina,
eu tenho o MySQL instalado e ele usa a porta 3306 se vc não tiver o MySQL instalado na sua máquina vc
pode rodar o container na porta 3306. E a porta para rodar o container é: http://localhost:8000/ 
Usuário: root Senha:12345

# 7°.1 passo configurando o properties
Fazer a configuração no properties para que a aplicação se conecte com o container e vc possa estar 
usando o banco de dados em container, não vou colocar o passo a passo porque essas configurações são 
basicas então acredito que vcs consigam fazer sem as instruços. Pode ser usado a interface: PhpAdmin, 
DBeaver, Workbenck, HeidSQL e etc...

# 7°.2 passo Criando a imagem docker da api
Comando para gerar o build da imagem dokcerfile: docker image build -t votacao-projeto-reserva . Comando
para subir a imagem e manter a imagem no ar: docker container run -p 8080:8080 votacao-projeto-reserva 
Comando para subir a imagem e encerrar: docker container run --rm -p 8080:8080 votacao-projeto-reserva

# 7°.3 passos para subir os containers na network
Comando para fazer o build da imagem da API:
docker image build -t votacao .

Comando para fazer a imagem subir:
docker container run --rm -p 8080:8080 votacao

Comando para subir o container do MySQL para dentro da rede:
docker  container run -d -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=12345 --network votacao-network  --name votacao-mysql  mysql:8.0

Comando para subir a aplicação back-end:
docker container run -d -p 8080:8080 -e DB_HOST=votacao-projeto-reserva-mysql --network votacao-network votacao




 