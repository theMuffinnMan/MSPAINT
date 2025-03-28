import ecs100.*;
import java.awt.Color;
/**
 * Create a ms paint clone in the gui
 *
 * @Fleur
 * @24/3
 */
public class MsPaint
{
    // instance variables - replace the example below with your own
    private double startX, startY; // feilds to remember Mouse input
    private double brushSize = 5;  //initialising the original size of the brush
    
    
    /**
     * Constructor for objects of class MsPaint
     */
    public MsPaint()
    {
        // initialise 
        UI.initialise();
        UI.addButton("Quit", UI::quit); //quick quit button to exit gui
        UI.addSlider("Size", 1, 20,this::getSize); //A slider to change the size of the brush
        UI.setMouseListener(this::doMouse);
    }

    /**
     * Drawing lines by checking my mouse action
     * @para x,y
     */
    public void doMouse(String action, double x, double y)
    {
        if (action.equals("pressed"))
        {
            this.startX = x;
            this.startY = y;
        }
        else if(action.equals("released"))
        {
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }
    
    /**
     * A slider to get the brush size
     * @para duble size
     */
    public void getSize(double size)
    {
        this.brushSize = size;
        UI.setLineWidth(brushSize);
    }
    
    private void changeColor(){
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }
    
    /**
     * main routine
     */
    public static void main(String[] args)
    {
        MsPaint obj = new MsPaint();
        UI.addButton("Change Color", obj::changeColor);
        UI.setMouseListener(obj::doMouse);
    }
}