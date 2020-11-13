<!-- ABOUT THE PROJECT -->
## Introdução

Este teste é parte do processo seletivo aqui no Asaas para posições na Engenharia. Você deve levar entre 4 e 8 horas para concluí-lo dependendo de seu nível de experiência.

O que você precisa fazer neste teste, é clonar o repositório, fazer o projeto rodar seguindo as instruções aqui contidas, e implementar as mudanças propostas. Uma vez que tenha concluído, abra um PR apontando para a branch `main` deste repositório.

A aplicação é construída em [Grails](https://grails.org/), um framework web baseado em Groovy, construído a partir do Spring Boot. Este framework é bastante amigável e simples de configurar, portanto você não deve enfrentar nenhuma dificuldade ao colocar o projeto para rodar.

## O que vamos avaliar

Nossa intenção com este teste, é avaliar sua capacidade de modificar e adicionar funcionalidades a um projeto existente, mantendo os padrões existentes e aplicando as melhores práticas de desenvolvimento.

Ao revisar seu código vamos avaliar os seguintes pontos:
* Organização do código.
* Respeito as regras de negócio e modificações propostas.
* Código bem escrito, limpo e coeso.
* Uso correto do versionamento do git.

## Rodando o projeto

São necessárias apenas 2 coisas para que este projeto rode: JDK 8 e Grails 4.0.5. Para instalar o Java e o Grails siga as [instruções contidas aqui](https://docs.grails.org/4.0.5/guide/single.html#requirements).

Esta aplicação vem pré-configurada para rodar utilizando banco em memória, porém recomendamos utilizar o MySQL pois a cada recompilação o banco em memória é limpo. Basta baixar a última versão do MySQL [aqui](https://dev.mysql.com/downloads/mysql/), e configurar o `username` e `password` corretos no arquivo `application.yml`.

Seguidas estas instruções, você já deve conseguir subir a aplicação acessando a pasta do projeto e executando o comando `grails run-app`, e acessar a interface através de `http://localhost:8080`

## O que precisa ser implementado

Neste projeto, já há um cadastro funcional de clientes (`Customer.groovy`) e cobranças (`Bill.groovy`), além de algumas regras de negócio implementadas. A partir do que já existe, você deve modificar ou adicionar funcionalidades conforme descrito a seguir.

#### Mudanças a serem implementadas
1. Incluir CPF/CNPJ no cadastro do cliente e tornar obrigatório. Validar a algoritmo para que não sejam inseridos clientes com CPF/CNPJ inválido.
2. Incluir forma de pagamento no cadastro da cobrança e tornar obrigatório. As formas de pagamentos são: Boleto Bancário, Cartão de Crédito ou Transferência Bancária.
3. Soft Delete: atualmente, ao remover um cliente ou cobrança, o registro é fisicamente removido do banco. Este comportamento deve ser mudado para soft-delete afim de ser possível manter histórico dos registros. Criar um atributo `deleted` nos domínios, e defini-lo como `true` ao remover um registro. Uma vez removido, o registro não deve mais ser exibido em nenhum lugar pela aplicação.
4. Possibilitar definir uma cobrança como paga e armazenar a data de pagamento. Não permitir exclusão de cobranças pagas.
5. Criar um job que rode de segunda sexta, que defina como Vencida todas as cobranças com data de vencimento anterior a hoje e que estejam com situação Pendente.

# Teste-Eduardo-Melo
