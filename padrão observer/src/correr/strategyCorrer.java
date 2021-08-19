package correr;

/**
 * Strategy que o usuário usa pra correr. Pode ser que no futuro eu mude para a
 * ação de correr de fato aconteça no strategy e ela não retorne somente um
 * inteiro.
 */
public interface strategyCorrer {
  int correr();
}
