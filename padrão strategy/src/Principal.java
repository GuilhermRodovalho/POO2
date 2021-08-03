import atacar.atacarForte;
import atacar.atacarMedio;
import correr.correrMedio;
import correr.correrRapido;
import pular.pularAlto;
import pular.pularBaixo;
import pular.pularMedio;

public class Principal {
  public static void main(String[] args) {

    Personagem personagem1 = new Personagem(new pularMedio(), new atacarForte(), new correrMedio());
    Personagem personagem2 = new Personagem(new pularAlto(), new atacarMedio(), new correrRapido());
    Personagem personagem3 = new Personagem(new pularBaixo(), new atacarForte(), new correrRapido());

    personagem1.pular();
    personagem1.correr();
    personagem1.atacar();

    System.out.println();

    personagem2.pular();
    personagem2.atacar();
    personagem2.correr();

    System.out.println();

    personagem3.correr();
    personagem3.pular();
    personagem3.atacar();
  }
}
