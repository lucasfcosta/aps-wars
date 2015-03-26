# Aps-Wars

*APS 15/1 - UFSC*
*Lucas Fernandes da Costa & Henrique Prandi*

## Conceito Geral

Duas tribos estão em guerra e precisam derrotar seus inimigos para poderem se expandir.
Cada jogador controla uma das tribos podendo coletar recursos, gerar tropas, fortalecer sua muralha ou atacar.
A tribo que aniquilar seu oponente primeiro é vencedora.

## Regras do Jogo

O objetivo do jogo é reduzir os pontos de vida da tribo adversária para 0.

A cada turno o jogador pode escolher realizar uma dentre as seguintes ações:
* Coletar Recursos
* Fortalecer Muralha
* Gerar Tropas
* Atacar (caso possua tropas)

Existem dois tipos de recursos *comida* e *madeira*, que podem ser obtidos através da *coleta de recursos*. A coleta de recursos irá gerar uma distribuição aleatória de quantidade de comida e madeira, assim, cabe ao jogador tomar as melhores decisões baseado em sua atual situação de recursos.

A *muralha* serve como uma espécie de escudo, ela também possui pontos de vida. Enquanto os pontos de vida da muralha forem superiores à 0, ela irá tomar todo o dano proveniente de ataques. A única maneira de incrementar a quantidade de pontos de vida da muralha é realizando a ação de fortalecê-la. Após a muralha ser totalmente destruída, o jogador precisa esperar alguns poucos turnos para poder reconstruí-la.

Para *gerar tropas* serão consumidas unidades do recurso comida, já para fortalecer a muralha serão consumidas unidades do recurso madeira.

Para poder atacar o jogador precisa possuir tropas, essas tropas serão enviadas ao combate para lutar até a morte e causar uma quantidade de dano na muralha ou na vila (caso a muralha esteja destruída) que varia de acordo com a força e a quantidade dos soldados, além, é claro, de um pouco do fator sorte.

## Recomendações Organização do Repositório

Talvez eu esteja "chovendo no molhado", mas é bom deixarmos bem claro como vamos organizar o repositório.

* Toda a parte de modelagem, especificação de requisitos, diagramas de classe e coisas desse tipo irão ficar na pasta "aps-docs"
* Todo o código fica na pasta "aps-code"
* Evitar commitar arquivos binários (arquivos pós-compilação, com extensão .class etc...)
* Procurar deixar mensagens de commit claras pra caso a gente precise voltar atrás
* Usar o [issue tracker do projeto](https://github.com/lucasfcosta/aps-wars/issues) para organizar o que precisa ser implementado, reportar bugs, melhorias e todo outro tipo de discussão