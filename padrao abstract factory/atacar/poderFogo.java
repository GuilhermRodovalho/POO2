package atacar;

public class poderFogo extends strategyAtacarDecorator {

  public poderFogo(strategyAtacar strategy) {
    super(strategy);
  }

  public int atacar() {
    return super.atacar() + 7;
  }

}
