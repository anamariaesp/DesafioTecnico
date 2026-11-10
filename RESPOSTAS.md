## PARTE 1

**1.1 Qual foi o sistema ou projeto mais complexo em que você trabalhou (profissional, faculdade ou pessoal)? Qual era a sua parte, especificamente? Conte uma decisão técnica que você tomou nele e o que faria diferente hoje.**

O projeto mais complexo que eu trabalhei foi o de Controle de Estoque, a complexidade do projeto está no registro das vendas, calcular os preços, descontos, valor de parcelas, etc..
Foi um projeto pessoal que fiz sozinha, então toda a parte de backend e frontend foram feitas por mim. Como era um projeto pequeno, atendeu bem os requisitos, porém o que eu faria diferente seria um sistema de login com possibilidade de registrar lojas diferentes e também adicionar relatórios e dashboards

**1.2 Conte um bug difícil que você investigou. Como você chegou à causa (logs, debugger, hipóteses descartadas)? Como confirmou que estava resolvido?**

O bug mais difícil que eu resolvi foi na emissão de uma NFCom, estava ocorrendo problema de data na emissão da nota, foi verificado log do emissor de nota, log do próprio aplicativo porém parecia tudo correto, mas na análise do log do Windos verifiquei que a data da máquina estava em padrão americano MM/DD/AAAA
Sugeri para o setor de desenvolvimento a criação de um novo parâmetro no emissor para aceitar esse modelo de data

**1.3 Na sua opinião, o que um sistema de gestão de empresas (ERP) deveria ter? Pense em funcionalidades, em quem usa o sistema no dia a dia e no que separa um sistema bom de um sistema que as pessoas só toleram.**

Um ERP deveria ter cadastro de funcionários, clientes e produtos, uma aba para gerenciamento de vendas/contratos, uma aba para impressão dos documentos (NF, boletos e recibos) e uma aba de dashboards e relatórios (com foco em relatórios financeiros).
Além das funcionalidades um sistema ERP deveria ter uma interface simples de aprender e entender, em que as tarefas mais comuns possam ser completas com o mínimo de abas e botões possível, sempre focando na user experience para se tornar agradável de utilizar.


## PARTE 4
**a) Liste os problemas que você encontrou em ordem de gravidade (o que causaria mais prejuízo para a empresa primeiro). Para cada um, diga em uma ou duas frases qual seria o efeito real em produção.**

Localizei problemas de segurança na utilização as querys sem tratamento, isso possibilita que seja feita uma SQL injection, onde hackers poderiam, por exemplo, deletar alguma tabela do banco de dados;
A função só ignora e segue operando quando não tem estoque o suficiente sem trazer nenhum erro para o usuário, isso pode causar problemas de falta de itens dos pedidos no estoque e também inconsistência no pedido, onde só alguns itens são realmente processados;
O tratamento de erro também está incorreto, deixa toda a função rodar sem apresentar erros onde deveria e caso mostre o erro, não vai deixar claro ao usuário o que ocorreu com a devida descrição e cancelar a operação atual.


**b) Reescreva a função (na linguagem que preferir, pode ser pseudocódigo) corrigindo os problemas que você considera bloqueantes para o merge.**
