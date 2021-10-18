import atacar.atacarForte;
import correr.correrRapido;

/**
 * Estado do personagem forte, onte ele corre rápido e ataca forte. O personagem
 * está nesse estado quando está acima de 70 de vida
 * 
 * @see EstadoPersonagem
 */
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
