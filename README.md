JL_Bank -
JL_Bank é um sistema bancário desenvolvido em Java, projetado para gerenciar contas bancárias, realizar transações e validar informações cadastrais.

Funcionalidades -
Cadastro de contas com validação de CPF, nome, saldo inicial e tipo de conta.
Realização de PIX entre contas.
Consulta de contas por ID e CPF.
Validação de dados durante o cadastro.

Endpoints - 
Criar Conta
POST /conta
{
  "id": 1,
  "numero": "00012345",
  "agencia": "1234",
  "nomeTitular": "Julia Brito",
  "cpfTitular": "12345678900",
  "dataAbertura": "2025-03-17",
  "saldoInicial": 500.0,
  "ativa": true,
  "tipoConta": "Corrente"
}
O tipoConta deve ser um dos seguintes valores: Poupanca, Corrente, Salario.


Desenvolvido por Julia Brito e Leonardo Iafrate
