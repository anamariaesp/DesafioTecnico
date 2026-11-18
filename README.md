# DesafioTecnico

## Tecnologias utilizadas

Java 17, Spring Boot, H2, Maven


## Como subir a aplicação

1. Clone o repositório:
```bash
git clone https://github.com/anamariaesp/DesafioTecnico.git
```
2. Abra o projeto na sua IDE de preferência.
3. Execute o arquivo ConferenciaPedidosApplication.java.


## O que falta

Faltou a consulta de conferência, fechamento do pedido e os testes


## Cenário de exemplo

Não foi possível realizar o teste, pois a rota não foi implementada, mas o resultado esperado (não executado) seria:

    Pedido 50231

    SSD-1TB-KG    qtd_esperada 2    qtd_lida 2    OK
    MEM-16-DDR5   qtd_esperada 2    qtd_lida 1    FALTANDO 1
    FNT-650W      qtd_esperada 1    qtd_lida 2    SOBRANDO 2
    GAB-AIR-01    qtd_esperada 1    qtd_lida 0    FALTANDO 1

    SKUs estranhos: BRD-ADESIVO  qtd 1
                    CBL-HDMI-2M  qtd 1
