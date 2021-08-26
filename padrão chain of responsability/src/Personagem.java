import java.util.ArrayList;

import atacar.strategyAtacar;
import correr.strategyCorrer;
import pular.strategyPular;

/**
 * Classe personagem atualmente controla o personagem principal, seus diversos
 * estados e suas strategies. No momento só tem um personagem principal
 */
public class Personagem {

  private String nome;
  private EstadoPersonagem state;

  private strategyPular habilidadePular;
  private strategyAtacar habilidadeAtacar;
  private strategyCorrer habilidaCorrer;

  private ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();

  private double life;
  private int x;
  private int y;

  /**
   * É passado para o construtor a posição inicial do personagem como as variáveis
   * x e y, e o nome.
   * 
   * @param x    Coordenada x
   * @param y    Coordenada y
   * @param nome Nome do personagem a ser criado
   */
  public Personagem(int x, int y, String nome) {
    state = new PersonagemNormal(this);

    this.setX(x);
    this.setY(y);

    this.setLife(70);

    this.nome = nome;
  }

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

  public String getNome() {
    return this.nome;
  }

  // Parte do padrão observer, serve para que os inimigos saibam o que acontece
  // com o personagem
  public void notificarInimigos() {
    for (Inimigo p : inimigos) {
      p.update(this);
    }
  }

  public ArrayList<Inimigo> getInimigos() {
    return inimigos;
  }

  public void setInimigos(ArrayList<Inimigo> inimigos) {
    this.inimigos = inimigos;
  }

  public void setInimigos(Inimigo inimigo) {
    this.inimigos.add(inimigo);
  }

  public double getLife() {
    return life;
  }

  public void setLife(double life) {
    this.life = life;

    this.state.verificaEstado();
  }

  public void sofreAtaque(double dano) {
    this.state.levarDano(dano);
  }

  public void ganharRecompensa(double recompensa) {
    this.state.recuperarVida(recompensa);
  }

  public void changeState(EstadoPersonagem state) {
    this.state = state;
  }

  public void verificaEstado() {
    this.state.verificaEstado();
  }

  /**
   * Ataca o inimigo passado usando a strategie habilidadeAtacar. Haverá mudanças,
   * caso eu refatore inimigo para personagem comum.
   * 
   * @param alvo Alvo que está sendo atacado
   */
  public void atacar(Inimigo alvo) {

    System.out.println("O personagem " + this.nome + " atacou o " + alvo.getNome());

    alvo.sofreAtaque(this.habilidadeAtacar.atacar());
  }

  /**
   * Corre em apenas em um eixo por vez. Posso tentar fazer algum cálculo
   * trigonométrico para o personagem correr na diagonal. Só não sei como ainda.
   * 
   * @param eixo     Eixo de coordenadas que está sendo movido
   * @param positivo Se o personagem deve correr no valor positivo ou negativo
   */
  public void correr(String eixo, boolean positivo) {
    int distancia = habilidaCorrer.correr();

    if (!positivo)
      distancia = distancia * -1;

    if (eixo.toUpperCase() == "X") {
      setX(getX() + distancia);
    } else {
      setY(getY() + distancia);
    }

  }

  public void pular() {
    habilidadePular.pular();
  }

  public strategyPular getHabilidadePular() {
    return habilidadePular;
  }

  public void setHabilidadePular(strategyPular habilidadePular) {
    this.habilidadePular = habilidadePular;
  }

  public strategyAtacar getHabilidadeAtacar() {
    return habilidadeAtacar;
  }

  public void setHabilidadeAtacar(strategyAtacar habilidadeAtacar) {
    this.habilidadeAtacar = habilidadeAtacar;
  }

  public strategyCorrer getHabilidaCorrer() {
    return habilidaCorrer;
  }

  public void setHabilidaCorrer(strategyCorrer habilidaCorrer) {
    this.habilidaCorrer = habilidaCorrer;
  }

}