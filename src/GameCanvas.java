//package ru.geekbrains.java_two.lesson_a.online.circles;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class GameCanvas extends JPanel {

    MainCircles gameWindow;
    private long lastFrameTime;
    private LocalTime time;


    GameCanvas(MainCircles gameWindow) {
        this.gameWindow = gameWindow;
        setBackgroudColor();
        lastFrameTime = System.nanoTime();
    }

    private void setBackgroudColor() {
        int currentHour = getCurrentTime();
        if (currentHour > 0 && currentHour < 6){
            setBackground(Color.BLUE);
        } else  if (currentHour >= 6 && currentHour < 12) {
            setBackground(Color.RED);
        } else  if (currentHour >= 12 && currentHour < 18) {
            setBackground(Color.GREEN);
        } else {
            setBackground(Color.YELLOW);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gameWindow.onDrawFrame(this, g, delta);
        repaint();
    }
    private int getCurrentTime(){
        time = java.time.LocalTime.now();
        int hour = time.getHour();
        return hour;
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
