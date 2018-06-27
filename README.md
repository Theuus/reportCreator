## Problema

Você deve criar um sistema de análise de dados onde o sistema deve poder importar lotes de arquivos, ler e analisar os dados e produzir um relatório. Existem 3 tipos de dados dentro desses arquivos. Para cada tipo de dados há um layout diferente.

## Tipos de Dados
Cada tipo de dados tem o seu identificador, que é a primeira posição do separador "ç". Com isso temos que os vendedores tem o identificador 001, os clientes 002 e as vendas 003.

Exemplos:
Vendedor: 001çCPFçNameçSalary

Client: 002çCNPJçNameçBusiness Area

Vendas 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name


### Arquivo de exemplo
O seguinte é um exemplo dos dados que o sistema deve ser capaz de ler.

001ç1234567891234çDiegoç50000

001ç3245678865434çRenatoç40000.99

002ç2345675434544345çJose da SilvaçRural

002ç2345675433444345çEduardo PereiraçRural

003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego

003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato

### Análise de dados

Seu sistema deve ler dados do diretório padrão, localizado em% HOMEPATH% /
data / in. O sistema só deve ler arquivos .dat.

Depois de processar todos os arquivos dentro do diretório padrão de entrada, o sistema deve criar um arquivo dentro do diretório de saída padrão, localizado em% HOMEPATH%/data/out. O nome do arquivo deve siga este padrão, {flat_file_name}.done.dat.

O conteúdo do arquivo de saída deve resumir os seguintes dados:

- Quantidade de clientes no arquivo de entrada
- Quantidade de vendedor no arquivo de entrada
- ID da venda mais cara
- O pior vendedor

Este sistema deve estar sempre trabalhando. Todos os arquivos novos quando estiver disponível, deve ser processado.

### Implementação
 Utilizei o framework Camel Bindy para facilitar o gerenciamento dos arquivos já processados, também para leitura e slipt do arquivo, assim como sua escrita no arquivo de saída.

Pode-se executar a aplicação pelo método main ou utilizando docker.

No arquivo properties é possível definir os diretórios utilizados durante o processamento:

```
input.dir = ${HOME}/data/in
output.dir = ${HOME}/data/out
```

### Makefile
O Makefile visa facilitar a execução da aplicação, e tem os seguintes targets disponíveis:

```
build:
    # build do projeto, bem como das imagens docker

run:
    # inicia a aplicação (todos via docker) e cria o volume para adicionar arquivos para o processamento. 
    input: $HOME/data/in
    output: $HOME/data/out
```


Segue exemplo de relatório gerado:

```
Report
Salesman Count: 2
Client Count: 2
Most expensive sale ID: 10
Worst Salesman: Renato

