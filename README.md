<!-- ABOUT THE PROJECT -->
## Introdução

Este teste é parte do processo seletivo aqui no Asaas para posições na Engenharia. Você deve levar entre 4 e 8 horas para concluí-lo dependendo de seu nível de experiência.

O que você precisa fazer neste teste, é clonar o repositório, fazer o projeto rodar seguindo as instruções aqui contidas, e implementar as mudanças propostas. Uma vez que tenha concluído, abra um PR apontando para a branch master deste repositório.

A aplicação é construída em [Grails](https://grails.org/), um framework web baseado em Groovy, construído a partir do Spring Boot. Este framework é bastante amigável e simples de configurar, portanto você não deve enfrentar nenhuma dificuldade ao colocar o projeto para rodar.

## O que vamos avaliar

Nossa intenção com este teste, é avaliar sua capacidade de modificar e adicionar funcionalidades a um projeto existente, mantendo os padrões existentes e aplicando as melhores práticas de desenvolvimento.

Ao revisar seu código vamos avaliar os seguintes pontos:
* Organização do código.
* Respeito as regras de negócio e modificações propostas.
* Código bem escrito, limpo e coeso.
* Uso correto do versionamento do git.

## O que já está pronto

Neste projeto, já há um cadastro funcional de clientes e cobranças, além de algumas regras de negócio implementadas. A partir do que já existe, você deve modificar ou adicionar funcionalidades conforme o solicitado.


## Rodando o projeto

São necessárias 3 coisas para que este projeto rode: MySQL, JDK 8 (ou superior) e Grails 4.0.5.

Para instalar o Java e o Grails siga as [instruções contidas aqui](https://docs.grails.org/4.0.5/guide/single.html#requirements). Já para o MySQL, basta baixar a última versão [aqui](https://dev.mysql.com/downloads/mysql/).

**Importante**: atenção ao username e password do MySQL, caso contrário a aplicação não conseguirá conectar no banco. O username e password já configurados neste projeto são, respectivamente, `root` e `asaas`. Caso seja necessário utilizar username ou password diferentes, basta alterar os valores no arquivo `Datasource.groovy`.

Seguidas estas instruções, você já deve conseguir subir a aplicação acessando a pasta do projeto e executando o comando `grails run-app`, e acessar a interface através de `http://localhost:8080`
