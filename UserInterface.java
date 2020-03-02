
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;////
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import java.net.URL;

//import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003) DB edited (2019) PITIOT Pierre-Yves edited (2020)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aButton1;
    private JButton    aButton2;
    private JButton    aButton3;
    private JButton    aButton4;
    private JButton    aButton5;
    private JButton    aButton6;
    private JButton    aButton7;
    
    private JPanel    aButtonPanel;
    private JPanel    aButtonLine1;
    private JPanel    aButtonLine2;
    private JPanel    aButtonLine3;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     */
    public void print(final String pText)
    {
        this.aLog.append(pText);
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength());
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     * inspiré de https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/23366-positionnez-des-boutons
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "SpaceGame" ); // change the title
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        this.aButton1 = new JButton("eat");
        this.aButton2 = new JButton("go north");
        this.aButton3 = new JButton("quit");
        this.aButton4 = new JButton("go west");
        this.aButton5 = new JButton("look");
        this.aButton6 = new JButton("go east");
        this.aButton7 = new JButton("go south");
        
        this.aButtonPanel = new JPanel();
        this.aButtonPanel.setLayout(new GridLayout(3, 3));
        
        this.aButtonPanel.add(this.aButton1);
        this.aButtonPanel.add(this.aButton2);
        this.aButtonPanel.add(this.aButton3);
        this.aButtonPanel.add(this.aButton4);
        this.aButtonPanel.add(this.aButton5);
        this.aButtonPanel.add(this.aButton6);
        this.aButtonPanel.add(this.aButton7);
                                              
        //Palcement sur le borderLayout                                        
        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(this.aButtonPanel, BorderLayout.WEST);
        //vPanel.add(this.aButton2, BorderLayout.EAST);

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );
        this.aButton1.addActionListener( this );
        this.aButton2.addActionListener( this );
        this.aButton3.addActionListener( this );
        this.aButton4.addActionListener( this );
        this.aButton5.addActionListener( this );
        this.aButton6.addActionListener( this );
        this.aButton7.addActionListener( this );
        // to end program when window is closed
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        if(pE.getSource().equals(aButton1))
        {
            this.aEngine.interpretCommand("eat");
        }
        else if (pE.getSource().equals(aButton2))
        {
            this.aEngine.interpretCommand("go north");
        }
        else if (pE.getSource().equals(aButton3))
        {
            this.aEngine.interpretCommand("quit");
        }
        else if (pE.getSource().equals(aButton4))
        {
            this.aEngine.interpretCommand("go west");
        }
        else if (pE.getSource().equals(aButton5))
        {
            this.aEngine.interpretCommand("look");
        }
        else if (pE.getSource().equals(aButton6))
        {
            this.aEngine.interpretCommand("go east");
        }
        else if (pE.getSource().equals(aButton7))
        {
            this.aEngine.interpretCommand("go south");
        }
        else this.processCommand(); // never suppress this line
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
