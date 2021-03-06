# FastTravel

Sistema de portagens electrónicas de monitorização de portagens e automatização de pagamentos.

## Sobre o Projeto 

O sistema tem como objetivo gerir os pórticos em autoestradas e outras vias, para tal, tem que monitorar os automóveis que transitam na via destinada ao Fast Travel. Conferir também, se os mesmos têm o identificador, o trajeto percorrido e o custo da viagem, retirar o correspondente montante da conta bancária associada ao cliente, e assim, agilizar o processo de viagem com pagamentos instantâneos.

## Backlog
Para monitorizar as tarefas e acompanhar o desenvolvimento do projeto, usamos:

* **[GitHub Projects](https://github.com/eva-pomposo/IES_Project/projects)**
* **Jira**

##  Constituição do projeto

* **[reports](https://github.com/eva-pomposo/IES_Project/tree/main/reports)**
* **[FastTravelService](https://github.com/eva-pomposo/IES_Project/tree/main/FastTravelService)**
* **[dataGeneratorBroker](https://github.com/eva-pomposo/IES_Project/tree/main/dataGeneratorBroker)**

## Correr FastTravel

### Correr FasTravel na VM
1. Executar o comando, colocando o user da sua conta da UA 
    ```
    ssh user@deti-engsoft-12
    ```
2. De seguida ira ser pedido a password da conta da UA, inserir a password da conta da UA
3. Navegar para o diretório ./home/evabartolomeu/IES_Project
4. Depois é só correr o docker:
    ```
    sudo docker-compose down -v
    ```
    ```
    sudo docker-compose build
    ```
    ```
    sudo docker-compose up
    ```
5. No browser se navegar no link: 192.168.160.221:6868/ irá conseguir ver o site a correr.

### Correr FasTravel em localhost
### Compilar FastTravelService

1. Ao compilar o FastTravelService, irá eliminar a pasta target caso exista, e gera-lo de novo com base no código do FastTravelService, contendo este um ficheiro jar. 
2. Para isto basta correr o seguinte comando no diretório ./FastTravelService:
    ```
    mvn clean package -DskipTests
    ```

### Compilar o docker

1. Antes de compilar o docker é necessario ter o ficheiro jar do FastTravelService pretendido (para obte-lo basta executar os passos vistos anteriormmente)
2. Para compilar o docker basta correr o seguinte comando no diretório raiz do projeto:
    ```
    docker-compose build
    ```

### Executar o docker 

1. Para correr o docker basta correr o seguinte comando no diretório raiz do projeto:
    ```
    docker-compose down -v
    ```
    ```
    docker-compose up
    ```

2. Para eliminar a base de dados:
    ```
    docker-compose down -v
    ```

3. Para eliminar docker:
    docker rm -f $(docker ps -aq)

4. Observar os resultados Website
    http://localhost:6868/

## Iteracao 3
1. Userstory do Login;
2. Userstory que permite a visualização das "passages in scuts" por parte do admin;
3. Userstory que permite a vizualização das "scuts" por parte do admin;
4. Userstory que permite o client visualizar os seus "Vehicles and Identifiers";
5. Userstory que permite que o client faça um "Request Identifier", que, será adicionado ao "Vehicles and Identifiers";
6. Userstory que permite que o cliente vizualize e, também, pesquise através de filtros os "Movements";
7. Implementação da Rest API;
8. Deployment do IES_Project na VM.


## Credentials to access as Client

| Username           | Password   |
| ------------------ | ---------- |
| pedrofigs@ua.pt    | pedroFigs! |

## Credentials to access as Admin

| Username               | Password     |
| ---------------------- | ------------ |
| andrefreixo18@ua.pt    | andrefreixo! |


## Papéis 

* **Team Manager**: [Eva Bartolomeu](https://github.com/eva-pomposo), nº 98513
* **Product Owner**: [Marta Fradique](https://github.com/MartaFradique), nº 98629
* **Architect**: [André Freixo](https://github.com/andre180701), nº 98495
* **DevOps Master**: [Luís Martins](https://github.com/luisccmartins), nº 98521