import atacar.*;

public class advancedFactory extends Factory {

  private static advancedFactory instance;

  private advancedFactory() {
  }

  public static advancedFactory getInstance() {
    if (instance == null) {
      instance = new advancedFactory();
    }
    return instance;
  }

  public Personagem criaPersonagem() {

    double tipo = Math.random();
    Personagem personagem = new Personagem(200, 500, "Player 1");

    if (tipo <= 0.2)
      personagem.setHabilidadeAtacar(new poderFogo(new atacarForte()));
    else if (tipo > 0.2 && tipo <= 0.4)
      personagem.setHabilidadeAtacar(new poderMaldicao(new atacarMedio()));
    else if (tipo > 0.4 && tipo <= 0.6)
      personagem.setHabilidadeAtacar(new poderRaio(new atacarMedio()));
    else if (tipo > 0.6 && tipo <= 0.8) {
      personagem.setHabilidadeAtacar(new poderFogo(new poderRaio(new atacarFraco())));
    } else {
      personagem.setHabilidadeAtacar(new poderMaldicao(new poderRaio(new atacarMedio())));
    }

    return personagem;
  }

}
