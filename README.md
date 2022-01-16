# FastTravel

Sistema de portagens electrónicas de monitorização de portagens e automatização de pagamentos.

## Sobre o Projeto 

O sistema tem como objetivo gerir os pórticos em autoestradas e outras vias, para tal, tem que monitorar os automóveis que transitam na via destinada ao Fast Travel. Conferir também, se os mesmos têm o identificador, o trajeto percorrido e o custo da viagem, retirar o correspondente montante da conta bancária associada ao cliente, e assim, agilizar o processo de viagem com pagamentos instantâneos.

## Backlog
Para monitorizar as tarefas e acompanhar o desenvolvimento do projeto, usamos:

* **[GitHub Projects](https://github.com/eva-pomposo/IES_Project/projects)**
* **Jira**

##  Constituição do projeto

* **[reports](https://github.com/eva-pomposo/IES_Project/tree/main/Reports)**
* **[prototype](https://github.com/eva-pomposo/IES_Project/tree/main/projFastTravel)**

## Correr FastTravel

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
    sudo docker-compose build
    ```

### Executar o docker 

1. Para correr o docker basta correr o seguinte comando no diretório raiz do projeto:
    ```
    sudo docker-compose down -v
    ```
    ```
    sudo docker-compose up
    ```

2. Para eliminar a base de dados:
    ```
    sudo docker-compose down -v
    ```

3. Para eliminar docker:
    docker rm -f $(docker ps -aq)

4. Observar os resultados Website
    http://localhost:6868/

### Compilar a geração de dados e rabbit 
1. Entrar no diretorio dataGeneratorBroker
2. Ver o Readme do diretorio
3. Ver a interface do rabbitMQ 
    http://localhost:15672

### Observar a base de dados
1. Colocar o docker a correr como explicado anteriormente
2. Executar na linha de comandos:
    > docker exec -it  ies_project_dataBase_1 bash
    > mysql --user admin --password fastTravelDB
3. Irá ser pedido a password, que é:
    ```
    admin
    ```

### Correr o Projeto na VM:
1. fazer ping par o nome da VM
2. copiar o endereço que aparece nesse ping
3. no browser perquisar po (endereco):6868/

### Remover docker images
> docker volume rm $(docker volume ls | awk '{print $2}')
> docker rmi -f $(docker images -aq)

## Papéis 

* **Team Manager**: [Eva Bartolomeu](https://github.com/eva-pomposo), nº 98513
* **Product Owner**: [Marta Fradique](https://github.com/MartaFradique), nº 98629
* **Architect**: [André Freixo](https://github.com/andre180701), nº 98495
* **DevOps Master**: [Luís Martins](https://github.com/luisccmartins), nº 98521