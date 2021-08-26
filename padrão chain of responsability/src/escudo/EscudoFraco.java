package escudo;

public class EscudoFraco extends Escudo {

  public EscudoFraco() {
    super();
    this.setVidaEscudo(30);
  }

  @Override
  public double sofrerDano(double dano) {
    if (this.getVidaEscudo() > 0) {
      double aux = dano * 0.3; // Remove 30% do dano
      aux = (dano - aux) / 2; // Pega metade do restante

      this.setVidaEscudo(this.getVidaEscudo() - aux);

      // Caso tenha mais algum escudo na cadeia, passa o resto pra ele
      // caso não tenha, já retorna o valor pra função principal
      if (this.getProximoEscudo() != null) {
        return this.getProximoEscudo().sofrerDano(aux);
      } else {
        return aux;
      }

    } else {
      return dano;
    }
  }

}
