import atacar.atacarFraco;
import correr.correrDevagar;

/**
 * Estado do personagem fraco, onte ele corre devagar e ataca fraco. O
 * personagem está nesse estado quando está entre 0 e 30 de vida.
 * 
 * @see EstadoPersonagem
 */
public class PersonagemFraco extends EstadoPersonagem {
  public PersonagemFraco(Personagem personagem) {
    super(personagem);
    personagem.setHabilidaCorrer(new correrDevagar());
    personagem.setHabilidadeAtacar(new atacarFraco());
  }

  @Override
  public void verificaEstado() {
    double life = personagem.getLife();

    if (life > 30) {
      personagem.changeState(new PersonagemNormal(personagem));
      personagem.verificaEstado();
    } else if (life <= 0) {
      personagem.changeState(new PersonagemMorto(personagem));
      personagem.verificaEstado();
    }

  }

}
