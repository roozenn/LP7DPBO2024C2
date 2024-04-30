import java.awt.*;

// Class representing a pipe in the game
public class Pipe {
    private int posX; // X position of the pipe
    private int posY; // Y position of the pipe
    private int width; // Width of the pipe
    private int height; // Height of the pipe
    private Image image; // Image of the pipe
    private int velocityX; // Horizontal velocity of the pipe
    boolean passed = false; // Flag indicating if the player has passed through the pipe

    // Constructor
    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityX = -3; // Set default horizontal velocity
        this.passed = false; // Initially, the pipe has not been passed through
    }

    // Getter and setter methods for posX, posY, width, height, image, velocityX, and passed
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
