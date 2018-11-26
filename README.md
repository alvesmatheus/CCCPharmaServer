# CCCPharma
Projeto final da disciplina Projeto de Software.

## Instalação

- Clone o repositório. Use o comando abaixo:

    `git clone https://github.com/SpinnelSun/CCCPharma.git`

- Navegue até o diretório onde o projeto está armazenado. Por exemplo:

    `cd ~/Downloads/CCCPharma/`

- Inicie o spring e brinque como quiser :)

    `mvn spring-boot:run`

## Banco de dados

Para manipular e acessar os dados, é necessário configurar um banco de dados, nós usamos o [postgresql](https://www.postgresql.org/). Se você ainda não tem ele instalado na sua máquina, faça o download. 

- [Tutorial para Ubuntu](https://www.digitalocean.com/community/tutorials/como-instalar-e-utilizar-o-postgresql-no-ubuntu-16-04-pt)
- [Tutorial para Windows](http://www.bosontreinamentos.com.br/postgresql-banco-dados/instalacao-do-postgresql-no-microsoft-windows/)

Feito isso é necessário criar um usuário, senha e um banco e configurá-las para o spring, tipicamente, em aplicações Spring essas informações são armazenadas no arquivo [application.properties](https://github.com/SpinnelSun/CCCPharma/blob/6-add-spring-structure/cccpharma/src/main/resources/application.properties), esse arquivo foi adicionado ao `.gitignore` pois não é seguro deixar a senha do banco visível para outros usuários. Assim, se for necessário alterar, tenha a certeza de que essa alteração será apenas local.

## Autenticação
[WIP]
Veja mais detalhes na [wiki](https://github.com/SpinnelSun/CCCPharma/wiki/Autentica%C3%A7%C3%A3o-com-JsonWebToken(JwtToken))

## Guia do desenvolvedor

O [guia do desenvolvedor](https://github.com/SpinnelSun/CCCPharma/blob/master/CONTRIBUTING.md) CCCPharma recomenda as melhores práticas para que os contribuidores possam escrever códigos que possam ser facilmente mantidos por outros programadores, todos nós sabemos o quanto é mais fácil entender um código se ele está padronizado.

O guia é separado em várias seções de regras relacionadas. Tentamos adicionar a lógica por trás das regras (se estiver omitido, assumimos que é óbvio, mas caso discorde, abra uma issue nos alertando, e assim modificaremos).

