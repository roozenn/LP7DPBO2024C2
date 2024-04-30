import java.awt.*;

// Class representing the player in the game
public class Player {
    private int posX; // X position of the player
    private int posY; // Y position of the player
    private int width; // Width of the player
    private int height; // Height of the player
    private Image image; // Image of the player
    private int velocityY; // Vertical velocity of the player

    // Constructor
    public Player(int posX, int posY, int width, int height, Image image) {
        this.posX = posX; // Set initial X position
        this.posY = posY; // Set initial Y position
        this.width = width; // Set width
        this.height = height; // Set height
        this.image = image; // Set image

        this.velocityY = -0; // Set initial vertical velocity to 0
    }

    // Getter and setter methods for posX, posY, width, height, image, and velocityY
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

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
}
