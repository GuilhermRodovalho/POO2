import java.util.ArrayList;

import atacar.strategyAtacar;
import correr.strategyCorrer;
import pular.strategyPular;

/**
 * Fiz o código com o IonUpdate, para que o jogo funcionasse com qualquer
 * personagem podendo ser inimigo, e não precisasse de um personagem principal.
 * Assim qualquer personagem pode ser inimigo de qualquer outro personagem. O
 * problema, é que ao instanciar o personagem principal, deve-se passar uma
 * strategie do tipo IonUpdate, que não faça nada. Todo personagem, portanto, é
 * um potencial observador.
 * 
 * @author Guilherme R. Rodovalho
 */

public class Personagem implements IObservador {

  private EstadoPersonagem state;
  private String nome;

  private strategyPular habilidadePular;
  private strategyAtacar habilidadeAtacar;
  private strategyCorrer habilidaCorrer;

  private IonUpdate onUpdate;

  private ArrayList<Personagem> inimigos = new ArrayList<Personagem>();

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

  public Personagem(int x, int y, String nome, IonUpdate comportamento) {
    state = new PersonagemNormal(this);

    this.setX(x);
    this.setY(y);

    this.setLife(70);

    this.onUpdate = comportamento;
    this.nome = nome;
  }

  public void notificarInimigos() {
    for (Personagem p : inimigos) {
      p.update(this);
    }
  }

  public ArrayList<Personagem> getInimigos() {
    return inimigos;
  }

  public void setInimigos(ArrayList<Personagem> inimigos) {
    this.inimigos = inimigos;
  }

  public void setInimigos(Personagem inimigo) {
    this.inimigos.add(inimigo);
  }

  public double getLife() {
    return life;
  }

  public void setLife(double life) {
    this.life = life;
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

  public void atacar() {
    habilidadeAtacar.atacar();
  }

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

  @Override
  public void update(Personagem p) {
    this.onUpdate.executar(this, p);
  }

}