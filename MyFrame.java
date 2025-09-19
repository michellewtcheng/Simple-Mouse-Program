import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener{

    int clickCounterNum, mouseLocX, mouseLocY;
    boolean isMousePresent;
    JLabel clickCounter, mousePresent;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addMouseListener(this);

        this.clickCounter = new JLabel(String.format("Number of clicks: %d", clickCounterNum));
        clickCounter.setBounds(0, 0, 250, 100);
        clickCounter.setBackground(Color.LIGHT_GRAY);
        clickCounter.setOpaque(true);

        this.mousePresent = new JLabel();
        mousePresent.setBounds(0, 100, 400, 100);
        mousePresent.setBackground(Color.orange);
        mousePresent.setOpaque(true);

        this.add(clickCounter);
        this.add(mousePresent);
        this.setVisible(true);

        this.clickCounterNum = 0;
        this.mouseLocX= 0;
        this.mouseLocY = 0;
        this.isMousePresent = false;
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
        mousePresent.setText("Squeak squeak!");
        mousePresent.setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isMousePresent = false;
        mousePresent.setBackground(Color.orange);
        mousePresent.setText("Weird how there's a block of cheese just sitting here...");
    }
}
