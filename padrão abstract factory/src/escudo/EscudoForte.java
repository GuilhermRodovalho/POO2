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
      double aux = dano * 0.8;
      aux = dano - aux;

      if (this.getVidaEscudo() >= aux) {
        this.setVidaEscudo((int) (this.getVidaEscudo() - aux));
        return 0;
      } else {
        aux = aux - this.getVidaEscudo();
        this.setVidaEscudo(0);

        if (this.getProximoEscudo() != null) {
          return this.getProximoEscudo().sofrerDano(aux);
        } else {
          return aux;
        }
      }

    } else {

      if (this.getProximoEscudo() != null) {
        return this.getProximoEscudo().sofrerDano(dano);
      } else {
        return dano;
      }
    }
  }

}
