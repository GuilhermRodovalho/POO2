/**
 * Um inimigo com média velocidade e com médio dano
 * 
 * @see Inimigo
 */
public class InimigoC extends Inimigo {

  public InimigoC(int x, int y, String nome) {
    super(x, y, nome);

    this.setHabilidaCorrer(2);
    this.setHabilidadeAtacar(10);
  }
}
