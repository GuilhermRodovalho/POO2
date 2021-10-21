package atacar;

public class poderRaio extends strategyAtacarDecorator {

  public poderRaio(strategyAtacar strategy) {
    super(strategy);
  }

  public int atacar() {
    return super.atacar() + 5;
  }

}
