public abstract class EstadoPersonagem {

  Personagem personagem;

  public EstadoPersonagem(Personagem personagem) {
    this.personagem = personagem;
  }

  public void levarDano(double dano) {

    System.out.printf("O personagem sofre %.0f de dano\n", dano);

    personagem.setLife(personagem.getLife() - dano);
    this.verificaEstado();
  }

  public void recuperarVida(double vida) {

    System.out.printf("O personagem recuperou %.0f de vida\n", vida);

    personagem.setLife(personagem.getLife() + vida);
    this.verificaEstado();
  }

  public abstract void verificaEstado();
}
