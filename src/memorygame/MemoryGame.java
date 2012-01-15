package memorygame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MemoryGame extends JComponent implements MouseListener
{

    private boolean flipped1 = false;  //true means face up
    private boolean flipped2 = false;
    private boolean flipped3 = false;
    private Color COLOR_1 = Color.BLUE;
    private Color COLOR_2 = Color.PINK;
    private Color COLOR_3 = Color.GRAY;
    
    private Image cardImage;

    public static void main(String[] args)
    {
        MemoryGame game = new MemoryGame();
        JFrame window = new JFrame("Memory");
        window.add(game);
        window.addMouseListener(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MemoryGame()
    {
        try
        {
            URL cardImageUrl = getClass().getResource("card.jpg");
            cardImage = ImageIO.read(cardImageUrl);
        } catch (IOException ex)
        {
            Logger.getLogger(MemoryGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(525, 550);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        // Row 1
        if (flipped1 == true)
        {
            g.setColor(COLOR_1);
            g.fillRect(25, 20, 100, 150);
        } else
        {
            g.drawImage(cardImage, 25, 20, 100, 150, null);
        }
        
        if (flipped2 == true)
        {
            g.setColor(COLOR_2);
            g.fillRect(150, 20, 100, 150);
        }
        else 
        {
            g.drawImage(cardImage, 150, 20, 100, 150, null);
        }
        
        if (flipped3 == true) 
        {
            g.setColor(COLOR_3);
            g.fillRect(275, 20, 100, 150);
        }
        else
        {
            g.drawImage(cardImage, 275, 20, 100, 150, null);
        }
        g.drawImage(cardImage, 400, 20, 100, 150, null);

        // Row 2
        g.drawImage(cardImage, 25, 200, 100, 150, null);
        g.drawImage(cardImage, 150, 200, 100, 150, null);
        g.drawImage(cardImage, 275, 200, 100, 150, null);
        g.drawImage(cardImage, 400, 200, 100, 150, null);

        // Row 3
        g.drawImage(cardImage, 25, 375, 100, 150, null);
        g.drawImage(cardImage, 150, 375, 100, 150, null);
        g.drawImage(cardImage, 275, 375, 100, 150, null);
        g.drawImage(cardImage, 400, 375, 100, 150, null);

    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        flipped1 = true;
        flipped2 = true;
        flipped3 = true;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }
}
