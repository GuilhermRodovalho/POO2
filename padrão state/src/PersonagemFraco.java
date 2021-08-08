import atacar.atacarFraco;
import correr.correrDevagar;

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
    } else if (life <= 0) {
      personagem.changeState(new PersonagemMorto(personagem));
    }

    personagem.verificaEstado();
  }

}
