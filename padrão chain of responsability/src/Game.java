import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Essa classe cria e administra o jogo até o fim, com os personagens passados
 * pra ela.
 */
public class Game extends JPanel {
  private Personagem personagemP;
  private ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
  private boolean fimdejogo = false;

  private JFrame frame;

  /**
   * Cria um jogo.
   * 
   * @param personagemP Personagem principal do jogo
   * @param inimigos    Inimigos que tentarão atacar o personagem principal
   */
  public Game(Personagem personagemP, ArrayList<Inimigo> inimigos) {
    this.personagemP = personagemP;
    this.inimigos = inimigos;

    KeyListener listener = new MyKeyListener();
    addKeyListener(listener);
    setFocusable(true);
  }

  public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Controla as ações do jogador
    @Override
    public void keyPressed(KeyEvent e) {

      if (fimdejogo || personagemP.getLife() <= 0) {
        return;
      } else {

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
          personagemP.correr("X", false);

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
          personagemP.correr("X", true);

        if (e.getKeyCode() == KeyEvent.VK_UP)
          personagemP.correr("Y", false);

        if (e.getKeyCode() == KeyEvent.VK_DOWN)
          personagemP.correr("Y", true);

        // Decidi que meu personagem vai poder atacar inimigos à distância.
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          for (Inimigo personagem : inimigos) {
            if (Math.abs(personagem.getX() - personagemP.getX()) < 10
                && Math.abs(personagem.getY() - personagemP.getY()) < 10) {

              personagemP.atacar(personagem);

              if (personagem.getLife() <= 0) {
                inimigos.remove(personagem);

                personagemP.ganharRecompensa(20);
              }

              break;
            }
          }

        }
      }

    }

    @Override
    public void keyReleased(KeyEvent e) {
      // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
    }
  }

  /**
   * Tem a responsibilidade de pintar o jogo na tela, os inimigos e informações
   * necessárias para o jogador
   * 
   * @param g
   */
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (personagemP.getLife() <= 0) {
      fimdejogo = true;

      g2d.setFont(new Font("Arial", Font.BOLD, 18));
      g2d.setColor(Color.BLACK);
      g2d.drawString("Você morreu", frame.getWidth() / 2 - 50, frame.getHeight() / 2);

    } else {
      g2d.setColor(Color.BLACK);
      g2d.fillOval(personagemP.getX(), personagemP.getY(), 20, 20);
    }

    g2d.setFont(new Font("Arial", Font.BOLD, 18));
    g2d.setColor(Color.BLACK);
    g2d.drawString("Inimigos vivos: " + this.inimigos.size(), 300, 25);
    g2d.setColor(Color.RED);
    g2d.drawString("Vida: " + this.personagemP.getLife(), 70, 20);
    g2d.setColor(Color.RED);
    g2d.drawString("Escudo: " + this.personagemP.getLifeEscudos(), 70, 40);

    if (inimigos.size() == 0) {
      g2d.setColor(Color.RED);
      g2d.drawString("Você venceu!", frame.getWidth() / 2 - 50, frame.getHeight() / 2);
    }

    for (Inimigo p : inimigos) {

      if (p.getLife() > 0) {

        if (p instanceof InimigoA) {
          g2d.setColor(Color.BLUE);
          g2d.fillOval(p.getX(), p.getY(), 20, 20);
        }

        else if (p instanceof InimigoB) {
          g2d.setColor(Color.GREEN);
          g2d.fillOval(p.getX(), p.getY(), 20, 20);
        }

        else {
          g2d.setColor(Color.RED);
          g2d.fillOval(p.getX(), p.getY(), 20, 20);
        }

      }
    }

  }

  /**
   * Inicia o jogo a ser jogado.
   * 
   * @param game Jogo a ser jogado
   * @throws InterruptedException Exceção que acontece ao fechar a janela
   */
  public void Jogar(Game game) throws InterruptedException {
    frame = new JFrame("Briga");
    frame.add(game);
    frame.setSize(700, 700);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true && !this.fimdejogo) {
      personagemP.notificarInimigos();
      game.repaint();
      Thread.sleep(70);
    }

  }

}
