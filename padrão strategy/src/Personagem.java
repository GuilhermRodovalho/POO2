import atacar.strategyAtacar;
import correr.strategyCorrer;
import pular.strategyPular;

public class Personagem {

  private strategyPular habilidadePular;
  private strategyAtacar habilidadeAtacar;
  private strategyCorrer habilidaCorrer;

  public Personagem(strategyPular habilidadePular, strategyAtacar habilidadeAtacar, strategyCorrer habilidaCorrer) {
    this.habilidadePular = habilidadePular;
    this.habilidadeAtacar = habilidadeAtacar;
    this.habilidaCorrer = habilidaCorrer;
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