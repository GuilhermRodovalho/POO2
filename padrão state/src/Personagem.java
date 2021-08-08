import atacar.strategyAtacar;
import correr.strategyCorrer;
import pular.strategyPular;

public class Personagem {

  private EstadoPersonagem state;

  private strategyPular habilidadePular;
  private strategyAtacar habilidadeAtacar;
  private strategyCorrer habilidaCorrer;

  private double life;

  public double getLife() {
    return life;
  }

  public void setLife(double life) {
    this.life = life;
  }

  public Personagem() {
    state = new PersonagemNormal(this);

    this.life = 70;
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

  public void correr() {
    habilidaCorrer.correr();
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