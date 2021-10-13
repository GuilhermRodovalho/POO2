package atacar;

public class poderMaldicao extends strategyAtacarDecorator {

  public poderMaldicao(strategyAtacar strategy) {
    super(strategy);
  }

  public int atacar() {
    return super.atacar() + 10;
  }

}
