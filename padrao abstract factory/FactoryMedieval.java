public class FactoryMedieval extends AbstractFactory{
    
    private static FactoryMedieval instance;

    private FactoryMedieval() {
    }

    public static FactoryMedieval getInstance() {
      if (instance == null) {
        instance = new FactoryMedieval();
      }
      return instance;
    }

    public Personagem criarPersonagem(int x, int y, String nome) {
        return new Arqueiro(y, y, nome);
    }

    @Override
    public Arma criarArma() {
        return new ArcoEFlecha();
    }

    @Override
    public Defesa criarDefesa() {
        return new Escudo();
    }
        
}
