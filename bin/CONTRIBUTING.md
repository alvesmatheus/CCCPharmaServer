# Guia do desenvolvedor

## Tabela de conteúdos
- [Commits](#guidelines-para-commits)
- [Pull requests](#guidelines-para-pull-requests)
- [Branchs](#guidelines-para-criação-e-uso-das-branchs)
- [Issues](#guidelines-para-issues)
- [Estrutura de pacotes](#estrutura-de-pacotes)
- [Banco de dados](#guidelines-para-a-criação-de-tabelas-no-banco-de-dados)
- [API](#guidelines-para-criação-de-endpoints-na-API)


##  Guidelines para commits
![](https://img.icons8.com/dusk/100/000000/commit-git.png)

Um bom commit, geralmente, é composto por 3 coisas: 

###   1. Shotlog ou assunto:

- Máximo de 50 caracteres.
- Manter a linha desse tamanho garante que o shortlog explica a mudança de forma concisa, se houver mais de 50 caracteres, o github vai truncar, porque ele não vai conseguir mostrar tudo, o que vai prejudicar a legibilidade.
-  Deve iniciar com letra maiúscula.
- Não deve terminar com um ponto final.
- Deve descrever a mudança/ação feita no modo imperativo, o motivo pra isso é que o Github sempre usa o modo imperativo quando cria um commit nosso por default, além disso você deve responder a seguinte pergunta quando faz um commit,  
> "Se for aplicado, este commit irá (?) *assunto do commit*."

Alguns exemplos: 
  > Se aplicado, esse commit irá **refactor subsystem X for readability**.
  
  > Se aplicado, esse commit irá **update getting started documentation**.
  
  > Se aplicado, esse commit irá **remove deprecated methods**.
  
  > Se aplicado, esse commit irá **release version 1.0.0**.
  
  > Se aplicado, esse commit irá **merge pull request #123 from user/branch**.

No commit, colocamos o que está em negrito.

###   2. Body ou corpo:
- Maximo de 72 caracteres.
- Não é obrigatório, mas ajuda a explicar suas alterações.
- Deve descrever seu raciocínio. Isso é especialmente importante em casos em que mudanças complexas são feitas. Também é o local correto para escrever sobre bugs relacionados.
- Não deve ser escrito em primeira pessoa.

###     3. Referência a uma issue ou pull request:
- Deve usar algumas das keys definidas na tabela abaixo.
- Deve usar a a numeração da issue ou task.
- Deve haver um único espaço entre a key e a numeração.

| keys         | Descrição                                                                                               |
| -------------|---------------------------------------------------------------------------------------------------------|
| **feat**     | Uma nova feature.                                                                                       |
| **fix**      | Uma correção de um bug.                                                                                 |
| **style**    | Mudanças que não afetam o significado do código (espaços em branco, formatação, pontos-e-virgulas, etc).|
| **refactor** | Uma mudança no código que corrige um bug ou adiciona um novo recurso.                                   |
| **test**     | Adição de testes                                                                                        |

Para separar cada parte dessa, deixe uma linha em branco. Vale ressaltar que não necessariamente todas, estarão em um commit, muitas vezes, é necessário apenas o assunto, porque não precisamos dar muitas informações sobre como foi feito, e não temos uma issue ou pull request para referênciar sobre isso.

O comando `git commit -m` não vai deixar você fazer isso, o `git commit` vai abrir um editor no terminal e você estará habilitado a editar do modo que quiser.

#### Exemplo de um commit nesse formato:

```
Migrate CI images to tagged Ubuntu release

Update the CI image process to build from a tagged ubuntu release. All
images now make use of a shared setup script to install the appropriate
binaries.

Closes gh-15158
```

## Guidelines para pull requests
![](https://img.icons8.com/dusk/100/000000/compare-git.png)

Cada código upado, é revisado por uma pessoa, ele não é upado, sem antes passar por uma avaliação e pelos testes. Cada revisador usa como base os padrões e bad smells vistos na disciplina de projeto de software na UFCG, como reforço para os estilos das linguagens, usaremos as convenções mais aceitas pela comunidade da linguagem/biblioteca em questão, por exemplo, para javascript, é o do `airbnb`, nesse caso, faremos uso dele. 
Se julgar necessário, descreva decisões que tomou, que você acha que nem todos integrantes irão entender o motivo.


<span style="color:red">ATENÇÃO: Depois que seu pull request for merjado, apague a branch, pra não ficar poluindo as que existem e confundindo as pessoas.</span>

## Guidelines para criação e uso das branchs
![](https://img.icons8.com/dusk/100/000000/code-fork.png)

1. Padronização nos nomes das branchs: `num_issue-descricao-da-issue`
2. Branchs seguras: Basicamente, temos duas branchs principais, a `master` onde todo código de deploy fica hospedado, só entra código na master que já foi testado e já está pronto pra ser exibido no site, e a `developing`, a partir dessa criamos as outras branchs para desenvolvimento de features, fix bugs e etc..., e vamos trabalhando nessas coisas, quando o código delas estiver pronto, pedimos merge para `master` e logo em seguida fazemos deploy no `heroku`. 
É mais pra evitar que a gente suba um código pro site, que ainda não está 100%.

## Guidelines para issues
![](https://img.icons8.com/dusk/100/000000/answers.png)

Quando você criar uma issue, vincule ao [project](https://github.com/SpinnelSun/CCCPharma/projects)(que no caso é nossa User Story) e a Sprint adequada, use tags para categorizar e nos ajudar a filtrar as issues, tente não deixar a descrição da issue muito grande, pode ser dificil de acompanhar, como nossas issues vão estar relacionadas as tasks, se ficar muito grande, quebre em várias, lembre-se é sempre melhor resolver um problema complexo, em pequenos passos.

## Estrutura de pacotes
![](https://img.icons8.com/dusk/100/000000/folder-tree.png)

Organize seus arquivos por features / pages / components, não por domínios, é considerado boa prática em spring, veja na [documentação](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html). 

```
com
 +- example
     +- myapplication
         +- Application.java
         |
         +- customer
         |   +- Customer.java
         |   +- CustomerController.java
         |   +- CustomerService.java
         |   +- CustomerRepository.java
         |
         +- order
             +- Order.java
             +- OrderController.java
             +- OrderService.java
             +- OrderRepository.java
```
## Guidelines para a criação de tabelas no banco de dados
![](https://img.icons8.com/dusk/100/000000/data-configuration.png)

Antes de implementar uma funcionalidade do banco de dados, veja este [guia](https://github.com/RootSoft/Database-Naming-Convention), para que você não introduza padrões que não utilizamos, e seja necessário modificar quando fizer o pedido de pull request.

## Guidelines para criação de endpoints na API
![](https://img.icons8.com/dusk/100/000000/api-settings.png)

Antes de implementar uma funcionalidade do banco de dados, veja este [guia](https://restfulapi.net/resource-naming/)
para que você não introduza padrões que não utilizamos, e seja necessário modificar quando fizer o pedido de pull request.