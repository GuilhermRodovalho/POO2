import atacar.atacarForte;
import correr.correrRapido;

public class PersonagemForte extends EstadoPersonagem {

  public PersonagemForte(Personagem personagem) {
    super(personagem);
    personagem.setHabilidaCorrer(new correrRapido());
    personagem.setHabilidadeAtacar(new atacarForte());
  }

  @Override
  public void verificaEstado() {
    double life = this.personagem.getLife();

    if (life < 70) {
      personagem.changeState(new PersonagemNormal(personagem));
      personagem.verificaEstado();
    }
  }

}
