package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BackEnd {
    public Label text;
    public Button blue;
    public Button yellow;
    public Button green;
    public Button red;
    public Button start;
    private int timeLeft;
    private int level;
    private String currentPattern;
    private String currentPatternCopy;
    private String playerInput;
    private boolean gameStatus;

    public void pressedBlue(javafx.event.ActionEvent actionEvent)
    {
        blue.setMouseTransparent(true);
        blue.setStyle("-fx-background-color:rgb(0,0,200); -fx-padding:10 20 10 10;");
        timeLeft = 500;
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(timeLeft > 0)
                {
                    timeLeft -= 20;
                }
                else
                {
                    blue.setStyle("-fx-background-color:rgb(0,0,82); -fx-padding:10 20 10 10;");
                    blue.setMouseTransparent(false);
                    stop();
                }
            }
        };
        a.start();
        playerInput += "B";
    }
    public void pressedYellow(ActionEvent actionEvent)
    {
        yellow.setMouseTransparent(true);
        yellow.setStyle("-fx-background-color:rgb(247,255,3); -fx-padding:10 20 10 10;");
        timeLeft = 500;
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(timeLeft > 0)
                {
                    timeLeft -= 20;
                }
                else
                {
                    yellow.setStyle("-fx-background-color:rgb(184,189,49); -fx-padding:10 20 10 10;");
                    yellow.setMouseTransparent(false);
                    stop();
                }
            }
        };
        a.start();
        playerInput += "Y";
        levelClearCheck();
    }
    public void pressedGreen(ActionEvent actionEvent)
    {
        green.setMouseTransparent(true);
        green.setStyle("-fx-background-color:rgb(0,255,102); -fx-padding:10 20 10 10;");
        timeLeft = 500;
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(timeLeft > 0)
                {
                    timeLeft -= 20;
                }
                else
                {
                    green.setStyle("-fx-background-color:rgb(0,82,0); -fx-padding:10 20 10 10;");
                    green.setMouseTransparent(false);
                    stop();
                }
            }
        };
        a.start();
        playerInput += "G";
        levelClearCheck();
    }
    public void pressedRed(ActionEvent actionEvent)
    {
        red.setMouseTransparent(true);
        red.setStyle("-fx-background-color:rgb(255,0,4); -fx-padding:10 20 10 10;");
        timeLeft = 500;
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(timeLeft > 0)
                {
                    timeLeft -= 20;
                }
                else
                {
                    red.setStyle("-fx-background-color:rgb(82,0,0); -fx-padding:10 20 10 10;");
                    red.setMouseTransparent(false);
                    stop();
                }
            }
        };
        a.start();
        playerInput += "R";
        levelClearCheck();
    }

    public void startGame(ActionEvent actionEvent) {
        level = 1;
        playerInput = "";
        currentPattern = "";
        currentPatternCopy = "";
        gameStatus = true;
        blue.setVisible(true);
        yellow.setVisible(true);
        green.setVisible(true);
        red.setVisible(true);
        start.setVisible(false);
        timeLeft = 10000;
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(timeLeft > 0)
                {
                    timeLeft -= 20;
                }
                else
                {
                    stop();
                }
            }
        };
        a.start();
        newPattern(level);
        currentPatternCopy = currentPattern;
        showPattern();
    }
    public void levelClearCheck()
    {
        if(playerInput.length() == currentPattern.length()) {
            showPattern();
            if (checkPattern()) {
                timeLeft = 1000;
                AnimationTimer a = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if(timeLeft > 0)
                        {
                            timeLeft -= 20;
                        }
                        else
                        {
                            stop();
                        }
                    }
                };
                a.start();
                level++;
                newPattern(level);
                currentPatternCopy = currentPattern;
                playerInput = "";
            } else {
                gameStatus = false;
                text.setText("You Lose :C. Your score was " + level + ".");
                blue.setVisible(false);
                yellow.setVisible(false);
                green.setVisible(false);
                red.setVisible(false);
                start.setVisible(true);
            }
        }
    }
    public void newPattern(int patternLength)
    {
        for(int i = 0; i < patternLength; i++) {
            int rnd = (int) Math.floor(Math.random() * (4 - 1 + 1)) + 1;
            if(rnd == 1)
            {
                currentPattern += "B";
            }
            if(rnd == 2)
            {
                currentPattern += "Y";
            }
            if(rnd == 3)
            {
                currentPattern += "G";
            }
            if(rnd == 4)
            {
                currentPattern += "R";
            }
        }
    }
    public void showPattern()
    {
        blue.setMouseTransparent(true);
        yellow.setMouseTransparent(true);
        green.setMouseTransparent(true);
        red.setMouseTransparent(true);
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                while(currentPatternCopy.length() > 0)
                {
                    if(currentPatternCopy.substring(0,1).equals("B"))
                    {
                        blue.setStyle("-fx-background-color:rgb(0,0,200); -fx-padding:10 20 10 10;");
                        timeLeft = 500;
                        AnimationTimer b = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if(timeLeft > 0)
                                {
                                    timeLeft -= 20;
                                }
                                else
                                {
                                    blue.setStyle("-fx-background-color:rgb(0,0,82); -fx-padding:10 20 10 10;");
                                    stop();
                                }
                            }
                        };
                        b.start();
                    }
                    if(currentPatternCopy.substring(0,1).equals("Y"))
                    {
                        yellow.setStyle("-fx-background-color:rgb(247,255,3); -fx-padding:10 20 10 10;");
                        timeLeft = 500;
                        AnimationTimer b = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if(timeLeft > 0)
                                {
                                    timeLeft -= 20;
                                }
                                else
                                {
                                    yellow.setStyle("-fx-background-color:rgb(184,189,49); -fx-padding:10 20 10 10;");
                                    stop();
                                }
                            }
                        };
                        b.start();
                    }
                    if(currentPatternCopy.substring(0,1).equals("G"))
                    {
                        green.setStyle("-fx-background-color:rgb(0,255,102); -fx-padding:10 20 10 10;");
                        timeLeft = 500;
                        AnimationTimer b = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if(timeLeft > 0)
                                {
                                    timeLeft -= 20;
                                }
                                else
                                {
                                    green.setStyle("-fx-background-color:rgb(0,82,0); -fx-padding:10 20 10 10;");
                                    stop();
                                }
                            }
                        };
                        b.start();
                    }
                    if(currentPatternCopy.substring(0,1).equals("R"))
                    {
                        red.setStyle("-fx-background-color:rgb(255,0,4); -fx-padding:10 20 10 10;");
                        timeLeft = 500;
                        AnimationTimer b = new AnimationTimer() {
                            @Override
                            public void handle(long now) {
                                if(timeLeft > 0)
                                {
                                    timeLeft -= 20;
                                }
                                else
                                {
                                    red.setStyle("-fx-background-color:rgb(82,0,0); -fx-padding:10 20 10 10;");
                                    stop();
                                }
                            }
                        };
                        b.start();
                    }
                    currentPatternCopy = currentPatternCopy.substring(1);
                }
                stop();
            }
        };
        a.start();
        blue.setMouseTransparent(false);
        yellow.setMouseTransparent(false);
        green.setMouseTransparent(false);
        red.setMouseTransparent(false);
    }
    public boolean checkPattern()
    {
        return playerInput.equals(currentPattern);
    }
}
