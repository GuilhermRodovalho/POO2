public class PersonagemMorto extends EstadoPersonagem {

  public PersonagemMorto(Personagem personagem) {
    super(personagem);
  }

  @Override
  public void verificaEstado() {
    System.out.println("Fim de jogo!");
  }

  @Override
  public void recuperarVida(double vida) {
    System.out.println("Impossível recuperar vida, o personagem está morto");
    System.out.println("RIP");

    this.verificaEstado();
  }
}
