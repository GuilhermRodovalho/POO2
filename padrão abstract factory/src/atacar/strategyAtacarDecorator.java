package atacar;

/**
 * Decorator que define qual o modificador do ataque: podendo ser, poderFogo,
 * poderRaio, e poderMaldicao. Cada um com um aumento de dano diferente. Com
 * esse padrão, eu posso ter um personagem mago que ataca com fogo e raio ao
 * mesmo tempo e ele use um ataque fraco. Assim como posso ter um personagem que
 * ataca forte e usa maldicao
 */
public class strategyAtacarDecorator implements strategyAtacar {

  private strategyAtacar strategy;

  public strategyAtacarDecorator(strategyAtacar strategy) {
    this.strategy = strategy;
  }

  @Override
  public int atacar() {
    return strategy.atacar();
  }

}
