import java.util.ArrayList;

public class Principal {
  public static void main(String[] args) throws InterruptedException {

    Personagem personagemP = new Personagem(500, 500, "Principal", new ComportamentoPrincipal());

    ArrayList<Personagem> inimigos = new ArrayList<Personagem>();
    inimigos.add(new Personagem(400, 700, "bot1", new ComportamentoInimigo()));
    inimigos.add(new Personagem(700, 400, "bot2", new ComportamentoInimigo()));
    inimigos.add(new Personagem(300, 500, "bot3", new ComportamentoInimigo()));
    inimigos.add(new Personagem(500, 300, "bot4", new ComportamentoInimigo()));

    personagemP.setInimigos(inimigos);

    Game game = new Game(personagemP, inimigos);
    game.Jogar(game);
  }
}
