import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener{

    int clickCounterNum, mouseLocX, mouseLocY;
    boolean isMousePresent;
    JLabel clickCounter, mousePresent, mousePresentImage;
    ImageIcon cheeseImage, mouseImage;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        this.clickCounterNum = 0;
        this.mouseLocX= 0;
        this.mouseLocY = 0;
        this.isMousePresent = false;

        // load images
        this.cheeseImage = new ImageIcon("images/cheese_small.png");
        this.mouseImage = new ImageIcon("images/rat_small.png");

//        this.mousePresentImage = new JLabel("Cheese image", cheeseImage, JLabel.CENTER);
//        this.mousePresentImage.setIcon(cheeseImage);
//        this.mousePresentImage.setBounds(250, 250, 200, 200);

        // Click counter
        this.clickCounter = new JLabel(String.format("Number of clicks: %d", clickCounterNum));
        clickCounter.setHorizontalAlignment(SwingConstants.CENTER);
        clickCounter.setBounds(0, 0, 200, 50);
        clickCounter.setBackground(Color.LIGHT_GRAY);
        clickCounter.setOpaque(true);

        // Mouse presence text
        this.mousePresent = new JLabel("Weird how there's a block of cheese just sitting here...",
                cheeseImage, JLabel.CENTER);
        mousePresent.setBounds(0, 250, 500, 250);
        mousePresent.setBackground(Color.orange);
        mousePresent.setOpaque(true);

        // add components
        this.add(clickCounter);
        this.add(mousePresent);
//        this.add(mousePresentImage);

        this.addMouseListener(this);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked!");
        clickCounterNum++;
        clickCounter.setText("Number of clicks: "+clickCounterNum);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isMousePresent = true;
        mousePresent.setText("Squeak squeak! 🐭");
        mousePresent.setBackground(Color.lightGray);
        mousePresent.setIcon(mouseImage);
//        mousePresentImage.setIcon(mouseImage);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isMousePresent = false;
        mousePresent.setBackground(Color.orange);
        mousePresent.setText("Weird how there's a block of cheese just sitting here...");
        mousePresent.setIcon(cheeseImage);
//        mousePresentImage.setIcon(mouseImage);
    }
}
