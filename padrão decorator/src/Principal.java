import java.util.ArrayList;

/**
 * Classe principal controla como o jogo será jogado, quantos inimigos etc.
 * Planos futuros: Implementar strategies para os inimigos, e talvez voltar eles
 * a serem personagens normais, assim acredito que o jogo fica mais clean.
 * 
 * Aí posso implementar algumas características mais legais. Pode até ser
 * multiplayer, com vários personagens sendo inimigos entre si.
 * 
 * @author Guilherme R. Rodovalho
 */

public class Principal {
  public static void main(String[] args) throws InterruptedException {

    Personagem personagemP = new Personagem(200, 500, "Principal");
    // personagemP.changeState(new PersonagemForte(personagemP));
    personagemP.setLife(80);

    ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
    inimigos.add(new InimigoA(400, 700, "bot1"));
    inimigos.add(new InimigoB(700, 400, "bot2"));
    inimigos.add(new InimigoC(300, 500, "bot3"));
    inimigos.add(new InimigoA(500, 300, "bot4"));

    for (Inimigo personagem : inimigos) {
      // personagem.changeState(new PersonagemFraco(personagem));

      personagem.setLife(50);
    }

    personagemP.setInimigos(inimigos);

    Game game = new Game(personagemP, inimigos);
    game.Jogar(game);
  }
}
