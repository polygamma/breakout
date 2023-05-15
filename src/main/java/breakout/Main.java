package breakout;

import breakout.levels.Level1;
import breakout.levels.Level2;
import breakout.levels.Level3;
import breakout.visuals.Canvas;
import breakout.visuals.MainMenu;

/**
 * The main class of the whole game. Used as controller for the canvas on which everything gets drawn.
 * <p>
 * Controller: Main.java and visuals.MainMenu.java
 * The Main.java contains a private field {@code stateOfProgram} which can be accessed through public setter and getter
 * and gets mainly accessed by the visuals.MainMenu.java in which buttons with MouseListeners are getting sent to the view
 * of our program which prints them on the canvas which you can find inside the visuals.Canvas.java.
 * The buttons change the {@code stateOfProgram} to specified values which let the Main.java do certain things
 * like opening levels or closing the whole program.
 * <p>
 * View: visuals.Canvas.java and conversion.Converter.java
 * The conversion.Converter.java is the interface between our Model and the View, but closer to the View, since
 * it offers a method to convert our own geometric objects, which don't use anything of the acm lib, to equal
 * acm objects which then can be plotted on the canvas. The method for plotting acm objects on the canvas
 * is inside the visuals.Canvas.java.
 * <p>
 * Model: Sounds lame - but every other class. Nevertheless we only talk about the most important ones
 * in this comment, which are geometry.Object.java, levels.Level.java, geometry.Line.java and geometry.Collision.java.
 * The Object.java is an abstract class which is meant to stand for all kinds of geometric objects we need.
 * Rectangles, Lines, Ovals (, Labels). It only defines two abstract methods we want to have for all kinds
 * of geometric objects, which are the bounds of the objects as a rectangle and a method which returns a boolean
 * to indicate if the geometric objects are really the objects meant to be. E.g. if a line is really a line and
 * not just a point which could happen if you define a lines' start- and endpoint through the same point.
 * All of the geometric objects extend this class and certainly implement this (and of course) more methods.
 * <p>
 * The Line.class is a bit special since this class offers the main method for our collision prediction.
 * It's a static method which takes two Lines as parameters and returns the intersection point of those
 * lines if there is exactly one intersection point. This is used inside the Collision.java which offers
 * another static method which takes two of our geometric objects, where one of them is meant
 * to be moving, as arguments and also the speed and the direction of the moving object.
 * It then returns the time until collision of those objects if they collide. We use this knowledge
 * to always move the ball to the next collision without the possibility to miss one collision since we
 * really know when the collisions happen, if they do. The moving of the ball is part of the Level.java
 * which contains the whole logic of the game. Inside the Level.java is just a single public method (beside setters
 * and getters of private fields) which is getting called once and then calculates and observes the playing of the level.
 * It also sends the state of the game to the view, so we can actually see what happens on the canvas.
 * But it is just the case that the Model sends the game state to the View, not vice versa.
 * The Model is working without anything visible on the canvas.
 * (It only uses the mouse position on the canvas which is absolutely
 * necessary for the calculations since the Model needs to know where the paddle is, but this does not require
 * anything visible on the canvas)
 * The calculation inside the Level.java happens with our own geometric objects and not with the acm objects, hence it
 * is able to work with our Model without the acm lib.
 * <p>
 * Packages: We've created a main package {@code breakout} which contains everything.
 * Directly inside this package is this Main.java which gets executed to start the program.
 * Everything else is assigned to packages which make clear to which part of the program the content belongs.
 * For example breakout.pictures which contain pictures which are used by the view for our paddle, ball, bricks etc.
 * The breakout.bricks contains the different bricks, breakout.levels the levels etc.
 * <p>
 * Classes: We've got two abstract classes which are geometry.Object.java and levels.Level.java.
 * The Object.java has already been discussed hence we talk only about the Level.java at this point.
 * The Level.java is abstract since it is meant to be a template for levels and not an own level.
 * It contains the whole game logic, private fields with public getters and setters and a few protected methods.
 * The levels itself extend this Level.java and (sometimes) override the protected methods to implement some more
 * level specific things like new winning conditions.
 * <p>
 * Most of our other classes extend other classes.
 * E.g. Rectangle extends Object and Paddle extends Rectangle for obvious reasons.
 * <p>
 * Classes which don't extend any other classes are for example conversion.Converter.java and geometry.Collision.java
 * since they are only meant to offer static methods for calculation or conversion, respectively.
 * <p>
 * Visibility: All fields of classes are private (private fields for real!) and if they should be accessible
 * by other classes there are public getters and setters for that. For the other methods it's nearly the same:
 * If they should be accessible by other classes we've made them public, otherwise they are private with one exception:
 * If we have methods inside a class which is a superclass for another class and they should be overwritable by this subclass,
 * we've made this methods protected since subclasses are always in the same package as the superclass inside of our program.
 * Mainly we've just followed: "As private as possible".
 * <p>
 * Class or local variables: If the variables have to be accessed by more than one method (irrelevant if the other method
 * is inside the same class or not) the variables are class variables. If the variables are only used inside one method, they
 * are just local.
 */
public class Main {

    /**
     * This field is used to tell the controller (this class) what to do. e.g. which level has to be opened.
     */
    private static volatile int stateOfProgram = -2;

    /**
     * the used Canvas.
     */
    private static Canvas canvas;

    /**
     * no construction allowed.
     */
    private Main() {

    }

    /**
     * main method. used to control the whole game.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        /*
        creates and opens the canvas
         */
        canvas = new Canvas();
        canvas.start(args);

        /*
        at first the main menu of the game has to be opened.
         */
        setStateOfProgram(0);

        /*
        infinite loop waiting for changes of the state of the program.
         */
        while (getStateOfProgram() != -1) {

            /*
            opens the main menu of the game
             */
            if (getStateOfProgram() == 0) {

                MainMenu.open();

            } else if (getStateOfProgram() == 1) {
                new Level1().play();

            } else if (getStateOfProgram() == 2) {
                new Level2().play();

            } else if (getStateOfProgram() == 3) {
                new Level3().play();
            }

            /*
            idle state
             */
            setStateOfProgram(-2);

            /*
            sleeping for not using 100 percent of the cpu.
             */
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Awakened prematurely.");
            }

        }

        canvas.exit();

    }

    /**
     * returns the used Canvas.
     *
     * @return the used Canvas.
     */
    public static Canvas getCanvas() {
        return canvas;
    }

    /**
     * returns the state of the program.
     *
     * @return the state of the program. {@code -1} signalizes the exit, {@code -2} signalizes idle, {@code 0} is the main menu and numbers greater than 0 are level declarations.
     */
    public static int getStateOfProgram() {
        return stateOfProgram;
    }

    /**
     * sets the state of the program.
     *
     * @param stateOfProgram the state of the program. {@code -1} signalizes the exit, {@code -2} signalizes idle, {@code 0} is the main menu and numbers greater than 0 are level declarations.
     */
    public static void setStateOfProgram(int stateOfProgram) {
        Main.stateOfProgram = stateOfProgram;
    }
}
