import atacar.atacarMedio;
import correr.correrMedio;
import pular.pularMedio;

/**
 * Estado do personagem Normal, onte ele corre medio, ataca medio e pula medio.
 * O personagem está nesse estado quando é instanciado e quando está entre 30 e
 * 70 de vida
 * 
 * @see EstadoPersonagem
 */
public class PersonagemNormal extends EstadoPersonagem {
  public PersonagemNormal(Personagem personagem) {
    super(personagem);
    personagem.setHabilidaCorrer(new correrMedio());
    personagem.setHabilidadeAtacar(new atacarMedio());
    personagem.setHabilidadePular(new pularMedio());
  }

  @Override
  public void verificaEstado() {
    double vida = personagem.getLife();

    if (vida <= 30) {
      personagem.changeState(new PersonagemFraco(personagem));
      personagem.verificaEstado();

    } else if (vida > 70) {
      personagem.changeState(new PersonagemForte(personagem));
      personagem.verificaEstado();
    }

  }

}
