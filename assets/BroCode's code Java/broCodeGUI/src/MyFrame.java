import javax.swing.*;
import java.awt.*;

public class MyFrame  extends JFrame { // have to extend JFrame
    //JFrame = GUI windows to add componenets too

    MyFrame(){ // Have to create your constructor i=f using classes
        this.setTitle("JFrame title goes here"); // sets title for a frame
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// When x button is clicked it ignores it and still runs the app.
        //this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Acts as it is closed but still runs in the background
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);// prevents frame from being resized
        this.setSize(420,420); // sets the x-dimension and y-dimension of the frame
        this.setVisible(true);//make frame visible

        ImageIcon image =  new ImageIcon("Iron Man.png");// Creates an image icon
        this.setIconImage(image.getImage());// change icon of frame
        //this.getContentPane().setBackground(Color.green); // change color of background
        //this.getContentPane().setBackground(new Color(0,0,0)); // change color of background to black
        //this.getContentPane().setBackground(new Color(255,255,255)); // change color of background to white
        //this.getContentPane().setBackground(new Color(255,0,0)); // change color of background to red
        //this.getContentPane().setBackground(new Color(0,255,0)); // change color of background to green
        //this.getContentPane().setBackground(new Color(0,0,255)); // change color of background to blue
        this.getContentPane().setBackground(new Color(123,50,250)); // change color of background to twitch purple


    }

  }
