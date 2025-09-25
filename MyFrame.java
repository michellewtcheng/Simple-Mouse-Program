import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener, MouseMotionListener{

    int clickCounterNum, mouseLocX, mouseLocY;
    JLabel clickCounter, mousePresent, mouseLoc;
    ImageIcon cheeseImage, mouseImage;
    String cheeseText;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        this.clickCounterNum = 0;
        this.mouseLocX= 0;
        this.mouseLocY = 0;
        this.cheeseText = "<html>Weird how there's a<br>block of cheese just sitting here...</html>";

        // load images
        this.cheeseImage = new ImageIcon("images/cheese_small.png");
        this.mouseImage = new ImageIcon("images/rat_small.png");

        // Click counter
        this.clickCounter = new JLabel(String.format("Number of clicks: %d", clickCounterNum));
        clickCounter.setHorizontalAlignment(SwingConstants.CENTER);
        clickCounter.setBounds(0, 0, 500, 50);
        clickCounter.setBackground(Color.LIGHT_GRAY);
        clickCounter.setOpaque(true);

        // Mouse presence text
        this.mousePresent = new JLabel(cheeseText, cheeseImage, JLabel.CENTER);
        mousePresent.setBounds(0, 200, 500, 300);
        mousePresent.setBackground(Color.orange);
        mousePresent.setOpaque(true);

        // Mouse location text
        this.mouseLoc = new JLabel("("+mouseLocX+", "+mouseLocY+")");
        mouseLoc.setBounds(0, 50, 500, 150);
        mouseLoc.setHorizontalAlignment(JLabel.CENTER);
        mouseLoc.setBackground(Color.pink);
        mouseLoc.setOpaque(true);

        // add components
        this.add(clickCounter);
        this.add(mousePresent);
        this.add(mouseLoc);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
    }

    private void updateMouseLocation(MouseEvent e){
        mouseLoc.setText("("+e.getX()+", "+e.getY()+")");
    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouse clicked!");
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
        mousePresent.setText("Squeak squeak! 🐭");
        mousePresent.setBackground(Color.lightGray);
        mousePresent.setIcon(mouseImage);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mousePresent.setBackground(Color.orange);
        mousePresent.setText(cheeseText);
        mousePresent.setIcon(cheeseImage);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMouseLocation(e);
    }
}
