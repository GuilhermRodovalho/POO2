package escudo;

public class EscudoForte extends Escudo {

  public EscudoForte() {
    super();
    this.setVidaEscudo(30);
  }

  // Fiz o escudo forte de forma diferente, porque antes tava muito OP.
  // Se a vida do escudo é maior que o dano com redução, então você pode tirar da
  // vida do escudo. Caso não seja, você zera o escudo e passa pra frente.
  @Override
  public double sofrerDano(double dano) {
    if (this.getVidaEscudo() > 0) {
      double aux = dano * 0.8; // Remove 80% do dano
      aux = dano - aux;

      if (this.getVidaEscudo() - aux > 0) {
        this.setVidaEscudo(this.getVidaEscudo() - aux);
        return 0;
      } else {
        // se o dano for maior que o escudo, você fica sem escudo e o excedente vai pra
        // vida do personagem
        aux = aux - this.getVidaEscudo();
        this.setVidaEscudo(0);

        // Se ainda tiver mais escudos, eles vão lidar com o dano;
        if (this.getProximoEscudo() != null) {
          return this.getProximoEscudo().sofrerDano(aux);
        }

        return aux;
      }

    } else if (this.getProximoEscudo() != null) {
      return this.getProximoEscudo().sofrerDano(dano);
    } else {
      return dano;
    }
  }

}
