import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;

    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes;

    Timer gameLoop;
    Timer pipesCooldown;
    int gravity = 1;
    int skor = 0;
    private App app;

    // Constructor
    public FlappyBird(App app) {
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);
        this.app = app;

        // Load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        // Initialize player and pipes
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        // Set up timers
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

        pipesCooldown.start();
    }

    // Paint the component
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draw method
    public void draw(Graphics g) {
        // Draw background
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);

        // Draw player
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        // Draw pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }
    }

    // Move method
    public void move() {
        int stop = 0;
        int hitPipe = 10;

        // Update player position
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        // Check collision with pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

            // Check collision with pipes or boundaries
            if ((player.getPosX() < pipe.getPosX() + pipe.getWidth() - hitPipe &&
                    player.getPosX() + player.getWidth() > pipe.getPosX() + hitPipe &&
                    player.getPosY() < pipe.getPosY() + pipe.getHeight() - hitPipe &&
                    player.getPosY() + player.getHeight() > pipe.getPosY() + hitPipe) ||
                    (player.getPosY() < 0 || player.getPosY() + player.getHeight() > frameHeight + 50)) {
                stop = 1;
                gameLoop.stop();
                pipesCooldown.stop();
            }

            // Increment score if passed through pipe
            if (player.getPosX() > pipe.getPosX() && player.getPosX() < pipe.getPosX() + pipe.getWidth()) {
                if (!pipe.isPassed()) {
                    skor++;
                    app.setSkor(skor);
                    pipe.setPassed(true);
                }
            }
        }

        // Game over condition
        if (stop == 1) {
            JOptionPane.showMessageDialog(null, "Game Over!");
        }
    }

    // Restart game method
    public void RestartGame() {
        player.setPosX(playerStartPosX);
        player.setPosY(playerStartPosY);
        player.setVelocityY(0);
        pipes.clear();
        skor = 0;
        app.setSkor(skor);

        gameLoop.start();
        pipesCooldown.start();
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    // KeyListener implementation
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            RestartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    // Place pipes method
    public void placePipes() {
        int randomPipePosY = (int) (pipeStartPosY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = frameHeight / 4;

        // Create upper pipe
        Pipe upperPipe = new Pipe(pipeStartPosX, randomPipePosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        // Create lower pipe
        Pipe lowerPipe = new Pipe(pipeStartPosX, randomPipePosY + pipeHeight + openingSpace, pipeWidth, pipeHeight, lowerPipeImage);
        lowerPipe.setPassed(true);
        pipes.add(lowerPipe);
    }
}