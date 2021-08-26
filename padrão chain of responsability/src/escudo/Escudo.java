package escudo;

/**
 * como meu escudo vai funcionar: O usuário pode pegar vários escudos: O escudo
 * medio mitiga 60% do dano, o resto será passado metade para a vida do escudo,
 * e metade para o próximo escudo na cadeia. O escudo forte mitiga 80% do dano.
 * E o escudo fraco mitiga 40% do dano.
 * 
 * O sistema funcionará da seguinte forma: Quando o personagem passar por cima
 * de um escudo, o mesmo irá para o final da cadeia de escudos.
 */
public abstract class Escudo {

  private double vidaEscudo;
  private Escudo proximoEscudo;

  public Escudo() {
    vidaEscudo = 30;
    proximoEscudo = null;
  }

  /**
   * Ele retornará um número que representa a quantidade de dano que não foi
   * possível tankar pela cadeia de escudos. SÓ DEVE RETORNAR UM INTEIRO QUANDO
   * FOR O ÚLTIMO ESCUDO DA CADEIA
   * 
   * @param dano
   * @return dano que não foi possível ser mitigado e vai ser passado para a vida
   *         do personagem
   */
  public abstract double sofrerDano(double dano);

  public double getVidaEscudo() {
    return vidaEscudo;
  }

  public void setVidaEscudo(double vidaEscudo) {
    this.vidaEscudo = vidaEscudo;
  }

  public Escudo getProximoEscudo() {
    return proximoEscudo;
  }

  public void setProximoEscudo(Escudo proximoEscudo) {
    this.proximoEscudo = proximoEscudo;
  }

}
