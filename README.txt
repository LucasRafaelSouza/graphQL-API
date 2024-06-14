A  aplicação está configurada para rodar na porta 8080 na seguinte rota: http://localhost:8080/graphiql
Esta rota também possui uma interface amigável para auxiliar nos testes.

Instruções para rodar a aplicação:

    cd graphQL-API (caso não esteja no diretório raiz do projeto)

    docker-compose build

    docker-compose up

Obsservações: o Dockerfile está configurado para, além de executar a aplicação,  automaticamente rodar os testes por meio de uma imagem do Maven.
Assim, o resultado dos testes ficará disponível no Logs de Build do container.

Contudo, caso deseje rodar a aplicação ou os testes separadamente, isso pode ser feito ao rodar os seguintes comandos no diretório inicial
do projeto, caso o Maven esteja instalado na sua máquina (também é possivel rodar por uma IDE Própria, como o IntelliJ):

     mvn spring-boot:run

     mvn test

LÓGICA DE IMPLEMENTAÇÃO:

    O funcionamento da aplicação está divido em três camadas (diretórios) principais: Controllers, Services e Models. Dentro de models, a classe
CombinationsResult, que possui a propriedade combinations, representando o número de combinações possíveis,  está sendo definida. Dentro de Services,
temos a camada que irá lidar com a implementação do algoritmo que irá determinar o número de combinações. Nela, temos a ScoreServiceInterface, que define
os métodos que devem ser implementados pelas classes que derivam da interface, e na classe ScoreService, temos a implementação destes métodos. Na classe ScoreService,
o método CountCombinations é o principal responsável pela lógica do algoritmo. Em resumo, ele usa uma abordagem recursiva para percorrer todas as possíves pontuações
que um time pode ter, para isso, ele usa o array de PossiblePoints, onde 3 representa os pontos de um field goal, 6 representa um Touchdown, 7 um Touchdown com um Extra
Touchdown de 1, e 7 um Touchdown mais um ExtraTochdown de 2. Dessa maneira, é possível evitar que a ordem das pontuações interfira na contagem das combinações.
Por fim, na camada de Controllers, ScoreController, junto com sua respectiva interface, fica responsável por mapear e lidar com as requisições vindas do usuário.

