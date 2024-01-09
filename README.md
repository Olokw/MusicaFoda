Plugin de músicas (em loop) por regiões (do WorldGuard) no minecraft.

Quando o jogador entra em uma região com música (uma região especificada no regions.yml), a música daquela região começará a tocar.

Caso a música daquela região já esteja tocando (em loop) para o player, ao entrar nessa região, nada acontece.

Caso outra música esteja tocando (em loop) para o player, essa música parará de tocar e seu loop também parará, e a nova música começará a tocar (em loop).

Caso o jogador saia da região com música para uma região sem música, a música não parará de tocar, porém o loop se encerrará assim que a música for concluída. Ou seja, a música irá tocar até acabar, e depois disso não tocará mais para o jogador. 
Entretanto, caso o jogador volte para uma região com música, que tenha aquela música tida como sua música, antes da música atual acabar, o loop não será parado, e a música continuará tocando em loop para o jogador.

Tudo que precisa ser feito é específicar o nome da região, o nome do mundo da região, o nome da música (na textura), o tempo da música (em ticks), o volume do som e o pitch do som.

Versão do plugin: 1.18+. 
Você pode alterar ele (através da source-code) para deixá-lo compatível com outras versões mais antigas, caso queira. 
