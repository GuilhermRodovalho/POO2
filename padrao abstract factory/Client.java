/** 
 * @author Luanna Nogueira de Oliveira Rabelo
 */

public abstract class Client{
  public static void main(String[] args){
      AbstractFactory factory = obterFactory(args[0]);
      AbstractPersonagem personagem = factory.criarPersonagem();
      personagem.criarPersonagem();
      Arma arma = factory.criarArma();
      arma.criarArma();
      Defesa defesa = factory.criarDefesa();
      defesa.criarDefesa();
  }
  
  public static AbstractFactory obterFactory(String s){
      if(s.equals("1") ){
          return FactoryFuturista.getInstance();
      }else{
          return FactoryMedieval.getInstance();}
  }
}
