public class FactoryFuturista extends AbstractFactory{
    
    private static FactoryFuturista instance;

    private FactoryFuturista() {
    }

    public static FactoryFuturista getInstance() {
      if (instance == null) {
       instance = new FactoryFuturista();
      }
      return instance;
    }

    
    public Personagem criarPersonagem(int x, int y, String nome) {
        return new Robo(x, y, nome);        
    }
    
    @Override
    public Arma criarArma() {
        return new RaioParalisante();        
    }

    @Override
    public Defesa criarDefesa() {
        return new CampoMagnetico();
    }    
}
