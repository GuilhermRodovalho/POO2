public abstract class EstadoPersonagem {

  Personagem personagem;

  public EstadoPersonagem(Personagem personagem) {
    this.personagem = personagem;
  }

  public void levarDano(double dano) {
    personagem.setLife(personagem.getLife() - dano);
    this.verificaEstado();
  }

  public void recuperarVida(double vida) {
    personagem.setLife(personagem.getLife() + vida);
    this.verificaEstado();
  }

  public abstract void verificaEstado();
}
