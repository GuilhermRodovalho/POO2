/**
 * Essa interface descreve o comportamento do personagem ao receber o update.
 * Criei, pra determinar o comportamento dos bots.
 * 
 * @author Guilherme R. Rodovalho
 */

public interface IonUpdate {
  void executar(Personagem observer, Personagem observable);
}
