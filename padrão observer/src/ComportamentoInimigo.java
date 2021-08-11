
public class ComportamentoInimigo implements IonUpdate {

  @Override

  public void executar(Personagem origem, Personagem destino) {
    if (Math.abs(origem.getX() - destino.getX()) <= 1 && Math.abs(origem.getY() - destino.getY()) <= 1) {
      origem.atacar(); // mudar isso
    } else {
      if (origem.getX() > destino.getX()) {
        origem.correr("X", false); // x, negativo
      } else {
        origem.correr("X", true); // x positivo
      }

      if (origem.getY() > destino.getY()) {
        origem.correr("Y", false); // y negativo
      } else {
        origem.correr("Y", true); // y positivo
      }
    }

  }

}
