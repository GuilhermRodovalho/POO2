public abstract class Factory {

  abstract public Personagem criaPersonagem();

  public Personagem criar() {
    return criaPersonagem();
  }
}
