# Aplicação API para JMETER Test cases
>O projeto consiste em um web service desenvolvido com java e com persistencia de dados em MySql. Este web service recebe e envia dados em formato json podendo ser consumido por APPs de diversas plataformas e é um pequeno exemplo que apenas grava e retorna dados de clintes, mas que pode ser expendido e ganhar novas funcionalidades.</p>

#### Tecnologis/libs utilizadas:
* Java
* Jersey
* JSON
* XML
* Maven 
* MySql 5.5.27.3
* SQL
* Tomcat 8.5.43
* GIT


# setup do projeto
## banco de dados
#### 1 - entrar no console do MySQL.
> mysql -u 'usuario mysql aqui' -p'senha mysql aqui'
```shell
#exemplo
mysql -uroot -p123456
```
#### 2 - criar database como nome ```cliente```
```sql
#mysql>
CREATE DATABASE cliente;
```
### 3 - criar tabela cliente, com id, nome, endereço e cpf.
>copie e cole os comandos no console no mysql e de enter.
```sql
#mysql>
use cliente;
CREATE TABLE `cliente` (`nome` varchar(255) NOT NULL, `cpf` varchar(14) NOT NULL, `endereco` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `cliente` ADD PRIMARY KEY (`id`);
ALTER TABLE `cliente` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
```
>pronto nesse ponto o banco de dados já esta pronto para a aplicação.
## importar projeto e rodar no Eclipse.
#### 1- abra o eclipse, vá até "Existing maven projects"

>com o projeto importado no eclipse, clique com o botão direito sobre o mesmo e selecione.

 Run as> Run on server> Tomcat v8.5

>depois 

'Download and install'>

>selecione o diretorio onde sera instalado o Servidor Tomcat.

### 2- rode o projeto
>clique com o botao direito do mouse sobre o projeto e vá até,

Run as> Run on server>

>selecione o servidor Toncat criado no passo 1, e clique em 'Finish', depois abra o navegador em http://localhost:8080/clientes/

### 3 - criar, listar, atualizar e deletar clientes
>recomendo usar o [Postman](https://www.getpostman.com "postman") para testar essa api.
### 4 - Abra os arquivo .postman encontrados no diretorio: src/test/postaman/

#### CRUD

>#### CRIAR
#method -  uri

POST - http://localhost:8080/clientes
```json
#headers 
{ "Content-type": "application/json" } }

#body
{
"nome":"",
"endereco":"",
"cpf":""
}
```
>#### ATUALIZAR 
method -  uri


PUT -  http://localhost:8080/clientes/{id}
```json
#headers 
{ "Content-type": "application/json" }

#body
{
"nome":"",
"endereco":"",
"cpf":""
}
```

>#### LISTAR COLLECTION 
method -  uri

GET - http://localhost:8080/clientes

>#### LISTAR PORID 
method -  uri

GET - http://localhost:8080/clientes/{id}

>#### DELETAR
method -  uri

DELETE - http://localhost:8080/clientes/{id}

# Setup do Jmeter test cases
## Test Cases
#### 1 - Download da aplicação Jmeter em: [JMETER](https://jmeter.apache.org/download_jmeter.cgi "JMETER")
#### 2 - Abra os arquivos .jmx encontrados no diretorio: src/test/jmeter/