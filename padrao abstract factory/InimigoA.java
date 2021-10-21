/**
 * Um inimigo com alta velocidade porém com baixo dano
 * 
 * @see Inimigo
 */
public class InimigoA extends Inimigo {

  public InimigoA(int x, int y, String nome) {
    super(x, y, nome);

    this.setHabilidaCorrer(4);
    this.setHabilidadeAtacar(5);
  }
}
