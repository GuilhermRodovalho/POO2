/**
 * Um inimigo com baixa velocidade porém com alto dano
 * 
 * @see Inimigo
 */
public class InimigoB extends Inimigo {

  public InimigoB(int x, int y, String nome) {
    super(x, y, nome);

    this.setHabilidaCorrer(1);
    this.setHabilidadeAtacar(15);
  }
}
