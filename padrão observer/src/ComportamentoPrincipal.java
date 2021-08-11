public class ComportamentoPrincipal implements IonUpdate {

  @Override
  public void executar(Personagem observer, Personagem observable) {
    System.out.println("O personagem principal não deveria ser observer");
    System.out.println("Algo de errado não está certo");
  }
}
