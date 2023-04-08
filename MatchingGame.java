
/**
 * @author swimk
 *
 */
import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {
//Congratulations message private final static 
  String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
// Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
// Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!"; 
// 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES = new float[][] {{170, 170}, {324, 170},
    {478, 170}, {632, 170}, {170, 324}, {324, 324}, {478, 324}, {632, 324}, {170, 478}, 
    {324, 478}, {478, 478}, {632, 478}}; 
// Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png", 
      "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};
  private static PApplet processing; // PApplet object that represents 
  // the graphic display window 
  private static Card[] cards; // one dimensional array of cards 
  private static PImage[] images; // array of images of the different cards
  private static Random randGen; // generator of random numbers 
  private static Card selectedCard1; // First selected card 
  private static Card selectedCard2; // Second selected card 
  private static boolean winner; // boolean evaluated true if the game is won, 
  // and false otherwise 
  private static int matchedCardsCount; // number of cards matched so far 
  // in one session of the game 
  private static String message; // Displayed message to the display window
  /**
   * @param args
   */
  
  /** * Defines the initial environment properties of this game as the program starts */ 
  //The setup() method receives an argument of type PApplet that is passed to it from the Utility
  //class. It’s used to deﬁne initial environment properties such as screen size and to load
  //background images and fonts as the program starts. There can only be one setup() method 
  //in the whole program and it is run once when the program starts.
  public static void setup(PApplet processing)
  {
 // Set the color used for the background of the Processing window 
    processing.background(245, 255, 250); // Mint cream color
    images = new PImage[6];
  //load apple.png image file as PImage object and store its reference into images[0]
    images[0] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[0]);
    images[1] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[1]);
    images[2] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[2]);
    images[3] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[3]);
    images[4] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[4]);
    images[5] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[5]);
    initGame();

  }
  
  /** * Initializes the Game */ 
  //Make sure to initialize the following static ﬁelds in your initGame() method with respect to 
  //the default values provided in the table below.
  //static ﬁeld | initial and restart value 
  //randGen- new Random(Utility.getSeed())
  //selectedCard1, selectedCard2 - null 
  //matchedCardsCount - 0 
  //winner - false 
  //message - empty String
  public static void initGame()
  {
    Random randGen = new Random(Utility.getSeed()); //initializes fields
    Card selectedCard1 = null;
    Card selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";
    Float arrX[] = new Float [12];
    Float arrY[] = new Float [12];
    cards = new Card[CARD_IMAGES_NAMES.length*2]; //Create cards array 
    double a = 0; 
    boolean contains = true;
    for (int i = 0; i <12; i ++)
    {
      while (contains != false)
      {
        int b = (int) a;
        cards[i] = new Card(images[b], CARDS_COORDINATES[randGen.nextInt(12)][randGen.nextInt(1)],
        CARDS_COORDINATES[randGen.nextInt(12)][randGen.nextInt(1)]);
    
          for (int j = 0; j <12; j ++)
            {
              if (cards[i].getX() == arrX[j] && cards[i].getY() == arrY[j])
                {
                  contains = true;
                }
              else
                { 
                  contains = false;
                }
      
              }
        }
      a = a + 0.500;
      arrX[i] = cards[i].getX();
      arrY[i] = cards[i].getY();
      cards[i].setVisible(true); 
      cards[i].draw(); //Draw one card to the display window
    }
    
  }
  /** * Callback method called each time the user presses a key */ 
  public static void keyPressed()
  {
    processing.key
  }
  /** * Callback method draws continuously this application window display */ 
  public static void draw()
  {
    
  }
  /** * Displays a given message to the display window * @param message to be 
   * displayed to the display window */ 
  public static void displayMessage(String message) 
  { 
    processing.fill(0); 
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12); 
  }
  
  /** * Checks whether the mouse is over a given Card *
   *  @return true if the mouse is over the storage
   */
  /** * Checks whether the mouse is over a given Card * @return true if the mouse is over
   *  the storage list, false otherwise */ 
  public static boolean isMouseOver(Card card)
  {
    
  }
  public static void mousePressed()
  {
    
  }
  
  

  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Utility.runApplication(); //starts the application
   
    
  }
