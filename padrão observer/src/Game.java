import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
  private Personagem personagemP;
  private ArrayList<Personagem> inimigos = new ArrayList<Personagem>();

  public Game(Personagem personagemP, ArrayList<Personagem> inimigos) {
    this.personagemP = personagemP;
    this.inimigos = inimigos;
  }

  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(Color.BLACK);
    g2d.fillOval(personagemP.getX(), personagemP.getY(), 20, 20);

    for (Personagem p : inimigos) {
      g2d.setColor(Color.BLUE);
      g2d.fillOval(p.getX(), p.getY(), 20, 20);
    }

  }

  public void Jogar(Game game) throws InterruptedException {
    JFrame frame = new JFrame("Briga");
    frame.add(game);
    frame.setSize(700, 700);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) {
      personagemP.notificarInimigos();
      game.repaint();
      Thread.sleep(100);
    }

  }

}
