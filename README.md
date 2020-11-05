# IBM - PROBLEMA DO MIOJO
Projeto desenvolvido com o framework Spring com a solução do problema proposto pela IBM.

## Enunciado
João é um fanático por miojos; ele os adora, e, como era de se esperar, ele levou vários pacotes quando foi acampar com seus colegas. Como João só gosta de miojos feitos com o tempo exato, ele se desesperou ao perceber que havia esquecido seu relógio em casa.Por sorte, ele conseguiu, no caminho, comprar duas ampulhetas de durações diferentes.

Por exemplo, se o miojo precisa de 3 minutos para ficar pronto, e João tiver uma ampulheta de 5 minutos e outra de 7, uma possível forma de cozinhar o miojo é:João começa virando as duas ampulhetas ao mesmo tempo.Quando a areia da ampulheta de 5 minutos se esgotar, João torna a virá-la.João começa a preparar o miojo quando a areia da ampulheta de 7 minutos acabar.João tira o miojo do fogo quando a ampulheta de 5 minutos acabar novamente.
Dessa forma, o miojo ficará 3 minutos no fogo (do minuto 7 ao minuto 10).Assim, apesar do miojo levar apenas três minutos para ser cozido, ele precisa de 10 minutos para ficar pronto.

Faça um programa que, dado o tempo de preparo do miojo, e os tempos das duas ampulhetas (ambos maiores que o tempo do miojo), determina o tempo mínimo necessário para o miojo ficar pronto ou se não é possível cozinhar o miojo no tempo exato com as ampulhetas disponíveis.

## Detalhes
Path utilizado: localhost:8080/api/v1/preparoMiojo<br>
Parâmetros de entrada:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tempoPreparo  -> Referente ao tempo de preparo do miojo.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ampulheta1    -> Referente ao tempo de uma das ampulhetas.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ampulheta2    -> Referente ao tempo da outra ampulheta.<br><br>

Parâmetro retornado:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tempoMinimo<br>

## Sobre<br>
Tecnologia: Spring Boot.<br>
Desenvolvido na IDE: IntelliJ IDEA<br>
Testes manuais realizados com a ferramenta: Insomnia<br>
Testes automatizados.<br>
