-- Parte 3: SQL


-- a) 
select extract (month from p.DATA_EMISSAO) "MÊS", count(*) as qtde, sum(i.QTD * i.VALOR_UNIT) as valor 
from PEDIDOS p 
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.DATA_EMISSAO between '01.01.2026' and '31.12.2026' and p.SITUACAO = 'Faturado' 
group by 1 order by 1


--b)
select c.NOME, count(p.ID) QUANTIDADE, avg(i.QTD*i.VALOR_UNIT) TICKET_MEDIO
from CLIENTES c
join PEDIDOS p on (p.ID_CLIENTE = c.ID)
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.SITUACAO = 'Faturado' and p.DATA_EMISSAO between '01.01.2026' and '31.12.2026' and (i.QTD*i.VALOR_UNIT) > 1500
group by c.NOME
having count(p.ID) > 3


--c)
select c.NOME, max(p.ID) PEDIDO,
(select p2.DATA_EMISSAO DATA_PEDIDO from PEDIDOS p2 where p2.ID = max(p.ID)),
(select (i2.QTD * i2.VALOR_UNIT) VALOR from ITENS_PEDIDO i2 where i2.ID_PEDIDO = max(p.ID))
from CLIENTES c
join PEDIDOS p on (p.ID_CLIENTE = c.ID)
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.SITUACAO = 'Faturado'
group by 1 order by 1

--d) Eu criaria indíces nas chaves primárias e estrangeiras pois são frequentemente usadas em JOINs e também nas colunas que mais são usadas em WHEREs
--   PEDIDOS: ID, ID_CLIENTE, DATA_EMISSAO
--   ITENS_PEDIDO: ID, ID_PEDIDO, SKU