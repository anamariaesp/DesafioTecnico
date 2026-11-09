-- Parte 3: SQL


-- a) 
select extract (month from p.DATA_EMISSAO) "MÊS", count(*) as qtde, sum(i.QTD * i.VALOR_UNIT) as valor 
from PEDIDOS p 
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.DATA_EMISSAO between '01.01.2026' and '31.12.2026' and p.SITUACAO = 'Faturado' 
group by 1 order by 1


--c)
select c.NOME, max(p.ID) PEDIDO,
(select p2.DATA_EMISSAO DATA_PEDIDO from PEDIDOS p2 where p2.ID = max(p.ID)),
(select (i2.QTD * i2.VALOR_UNIT) VALOR from ITENS_PEDIDO i2 where i2.ID_PEDIDO = max(p.ID))
from CLIENTES c
join PEDIDOS p on (p.ID_CLIENTE = c.ID)
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.SITUACAO = 'Faturado'
group by 1 order by 1