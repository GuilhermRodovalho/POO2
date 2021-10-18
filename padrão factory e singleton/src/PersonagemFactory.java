import java.lang.Math;

import atacar.atacarForte;
import correr.correrRapido;

public class PersonagemFactory extends Factory {

  private static PersonagemFactory instance = new PersonagemFactory();

  private PersonagemFactory() {
  }

  public static PersonagemFactory getInstance() {
    if (instance == null) {
      instance = new PersonagemFactory();
    }
    return instance;
  }

  /**
   * tipo 1: personagem forte. tipo 2: persnoagem medio. tipo 3: personagem fraco.
   * tipo 4: personagem forte e rapido. tipo 5: personagem fraco e ataque forte.
   */
  public Personagem criaPersonagem() {

    double tipo = Math.random();
    Personagem personagem = new Personagem(200, 500, "Player 1");

    if (tipo <= 0.2)
      personagem.changeState(new PersonagemForte(personagem));
    else if (tipo > 0.2 && tipo <= 0.4)
      personagem.changeState(new PersonagemNormal(personagem));
    else if (tipo > 0.4 && tipo <= 0.6)
      personagem.changeState(new PersonagemFraco(personagem));
    else if (tipo > 0.6 && tipo <= 0.8) {
      personagem.changeState(new PersonagemForte(personagem));
      personagem.setHabilidaCorrer(new correrRapido());
    } else {
      personagem.changeState(new PersonagemFraco(personagem));
      personagem.setHabilidadeAtacar(new atacarForte());
    }

    return personagem;
  }

}