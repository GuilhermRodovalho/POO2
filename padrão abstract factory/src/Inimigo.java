/**
 * Classe que define o inimigo. Extremamente semelhante à classe personagem,
 * inclusive semelhante até demais. Talvez eu refatore para os inimigos serem
 * personagens e porém precisarei implementar outras estratégias para os
 * inimigos, porque tava muito difícil jogar com o bot tendo as mesmas
 * habilidades que o personagem principal.
 * 
 * @see IObservador.java
 */
public class Inimigo implements IObservador {

  private String nome;

  private int habilidadePular;
  private int habilidadeAtacar;
  private int habilidaCorrer;

  private double life;
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Inimigo(int x, int y, String nome) {
    this.setX(x);
    this.setY(y);

    this.setLife(70);

    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public double getLife() {
    return life;
  }

  public void setLife(double life) {
    this.life = life;
  }

  public void sofreAtaque(double dano) {
    System.out.println("O inimigo recebeu " + dano + " de dano");
    this.life = this.life - dano;
  }

  public void ganharRecompensa(double recompensa) {
    this.life = this.life + recompensa;
  }

  public void atacar(Personagem alvo) {

    System.out.println("O personagem " + this.nome + " atacou o " + alvo.getNome());

    alvo.sofreAtaque(this.habilidadeAtacar);
  }

  public void correr(String eixo, boolean positivo) {
    int distancia = habilidaCorrer;

    if (!positivo)
      distancia = distancia * -1;

    if (eixo.toUpperCase() == "X") {
      setX(getX() + distancia);
    } else {
      setY(getY() + distancia);
    }

  }

  public int getHabilidadePular() {
    return habilidadePular;
  }

  public void setHabilidadePular(int habilidadePular) {
    this.habilidadePular = habilidadePular;
  }

  public int getHabilidadeAtacar() {
    return habilidadeAtacar;
  }

  public void setHabilidadeAtacar(int habilidadeAtacar) {
    this.habilidadeAtacar = habilidadeAtacar;
  }

  public int getHabilidaCorrer() {
    return habilidaCorrer;
  }

  public void setHabilidaCorrer(int habilidaCorrer) {
    this.habilidaCorrer = habilidaCorrer;
  }

  public void update(Personagem destino) {
    if (Math.abs(this.getX() - destino.getX()) <= 3 && Math.abs(this.getY() - destino.getY()) <= 3) {
      this.atacar(destino);
    } else {
      if (this.getX() > destino.getX()) {
        this.correr("X", false); // x, negativo
      } else {
        this.correr("X", true); // x positivo
      }

      if (this.getY() > destino.getY()) {
        this.correr("Y", false); // y negativo
      } else {
        this.correr("Y", true); // y positivo
      }
    }
  }

}
