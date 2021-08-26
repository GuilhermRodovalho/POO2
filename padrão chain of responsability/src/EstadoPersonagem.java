/**
 * Classe abstrata que define os estados do personagem e suas ações. Os métodos
 * de levarDano e recuperarVida já estão implementados, sendo neceśsario apenas
 * definir o comportamento do estado através da função verificaEstado. Embora
 * possa se fazer override de qualquer método que precisar
 */
public abstract class EstadoPersonagem {

  Personagem personagem;

  public EstadoPersonagem(Personagem personagem) {
    this.personagem = personagem;
  }

  /**
   * Classe que muda a vida do personagem quando o mesmo sofre dano, ela não
   * verifica o estado porque isso acontece na função setLife do personagem. Mas
   * talvez seja um ponto a se mudar.
   * 
   * @param dano
   * @see Personagem#setLife(double)
   */
  public void levarDano(double dano) {

    System.out.printf("O personagem " + this.personagem.getNome() + " sofre %.0f de dano\n", dano);

    personagem.setLife(personagem.getLife() - dano);
  }

  /**
   * Classe que muda a vida do personagem quando o mesmo ganha alguma recompensa,
   * ela não verifica o estado porque isso acontece na função setLife do
   * personagem. Mas talvez seja um ponto a se mudar.
   * 
   * @param vida
   * @see Personagem#setLife(double)
   */
  public void recuperarVida(double vida) {

    System.out.printf("O personagem" + this.personagem.getNome() + "recuperou %.0f de vida\n", vida);

    personagem.setLife(personagem.getLife() + vida);
    this.verificaEstado();
  }

  public abstract void verificaEstado();
}
