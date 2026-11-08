-- Parte 3: SQL


-- a) 
select extract (month from p.DATA_EMISSAO) "MÊS", count(*) as qtde, sum(i.QTD * i.VALOR_UNIT) as valor 
from PEDIDOS p 
join ITENS_PEDIDO i on (i.ID_PEDIDO = p.ID)
where p.DATA_EMISSAO between '01.01.2026' and '31.12.2026' and p.SITUACAO = 'Faturado' 
group by 1 order by 1
