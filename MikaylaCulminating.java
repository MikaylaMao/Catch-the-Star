// Mikayla (Yanyi) Mao - Culminating Game Assignment - "Catch the Star"
// Input: Prompt user for their usernames
// Processing: Calculate users' scores from catching objects. Calculate individual user's best score and rank the top users.
// Output: Display rules, top users' scores, moving objects and characters, individual user's current score and best score.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MikaylaCulminating
{
    public static void main(String [] args){
        new titleFrame();
    }
}

class titleFrame extends JFrame implements ActionListener{
    static String usernameText;
    int flag = 0;
    JFrame titleFrame;
    JButton startButton;
    JButton ruleButton;
    JButton quitButton;
    Image cloudBackground;
    ImageIcon cloudIcon;
    JTextField usernameBox;
    int check;
    Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
    Font textFont = new Font("Comic Sans MS", Font.PLAIN, 20);
    Font topFont = new Font("Comic Sans MS", Font.PLAIN, 40);
    Font checkFont = new Font("Arial", Font.PLAIN, 17);
    Font titleFont = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 100);
    static String [] nameArray = new String[100];
    static int [] scoreArray = new int[100];
    
    public titleFrame(){
        titleFrame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTitle ("Catch the Star");
        setSize (1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);  
        startButton = new JButton("Start");
        startButton.setBounds(450, 500, 100, 40);
        startButton.setFont(buttonFont);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBorder(BorderFactory.createBevelBorder(0));
        ruleButton = new JButton("Rules");
        ruleButton.setBounds(450, 560, 100, 40);
        ruleButton.setFont(buttonFont);
        ruleButton.setFocusable(false);
        ruleButton.addActionListener(this);
        ruleButton.setBorder(BorderFactory.createBevelBorder(0));
        quitButton = new JButton("Quit");
        quitButton.setBounds(450, 620, 100, 40);
        quitButton.setFont(buttonFont);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        quitButton.setBorder(BorderFactory.createBevelBorder(0));
        usernameBox = new JTextField();
        usernameBox.setBounds(400, 400, 200, 40);
        add(startButton);
        add(ruleButton);
        add(quitButton);
        add(usernameBox);
        try{
            LineNumberReader nameReader = new LineNumberReader(new FileReader("data/nameFile.txt"));
            LineNumberReader scoreReader = new LineNumberReader(new FileReader("data/scoreFile.txt"));
            int index = 0;
            while(true){
                String nameText = nameReader.readLine();
                if(nameText == null){
                    break;
                }
                else{
                    nameArray[index] = nameText;
                    scoreArray[index] = Integer.parseInt(scoreReader.readLine());
                    index++;
                }
            }
            nameReader.close();
            scoreReader.close();
        }
        catch(IOException e){   
        }
        while(true){
            if (flag == 1){
                dispose();
                new gameFrame();
                break;
            }
            System.out.println(flag);                   //  will not work if comment this out
        }
    }
    
    public void paint (Graphics g){
        cloudIcon = new ImageIcon("assets/CloudBackground.jpeg");
        cloudBackground = cloudIcon.getImage();
        g.drawImage(cloudBackground, 0, 0, this);
        g.setFont(titleFont);
        g.setColor(new Color(21, 111, 214));
        g.drawString("Catch the Star", 200, 300);
        g.setFont(textFont);
        g.setColor(Color.BLACK);
        g.drawString("Please enter your username:", 370, 380);
        g.drawString("1. " + nameArray[0], 750, 550);
        g.drawString(String.valueOf(scoreArray[0]), 900, 550);
        g.drawString("2. " + nameArray[1], 750, 600);
        g.drawString(String.valueOf(scoreArray[1]), 900, 600);
        g.drawString("3. " + nameArray[2], 750, 650);
        g.drawString(String.valueOf(scoreArray[2]), 900, 650);
        g.drawString("4. " + nameArray[3], 750, 700);
        g.drawString(String.valueOf(scoreArray[3]), 900, 700);
        g.drawString("5. " + nameArray[4], 750, 750);
        g.drawString(String.valueOf(scoreArray[4]), 900, 750);
        g.setFont(topFont);
        g.setColor(new Color(21, 111, 214));
        g.drawString("Top 5", 780, 480);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(8));
        g2.drawRoundRect(700, 430, 270, 370, 100, 100);
    }
    
    public void update(Graphics g){  
        g.setFont(checkFont);
        g.setColor(Color.red);
        if (check == 1){
            g.drawString("Please enter within 12 characters!", 370, 400);
        }
        else if (check == 2){
            g.drawString("Please enter an username before start!", 360, 420);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Rules")){
            new ruleFrame();
        }
        else if(action.equals("Start")){
            usernameText = usernameBox.getText();
            if (usernameText.length() > 12){
                check = 1;
                update(this.getGraphics());
            }
            else if (usernameText.length() < 1){
                check = 2;
                update(this.getGraphics());
            }
            else{
                flag = 1;
            }
        }
        else if(action.equals("Quit")){
            setVisible(false);
        }
    }

}

class ruleFrame extends JFrame implements ActionListener{
    JFrame ruleFrame;
    JButton closeButton;
    Image ruleBackground;
    Image star;
    Image coin;
    Image bomb;
    Image left;
    Image right;
    Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
    Font titleFont = new Font("Comic Sans MS", Font.BOLD, 70);
    Font ruleFont1 = new Font("Roboto Mono", Font.PLAIN, 20);
    Font ruleFont2 = new Font("Roboto Mono", Font.BOLD, 20);
    
    public ruleFrame(){
        ruleFrame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTitle ("Rules");
        setSize (400, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true); 
        setLayout(null);
        closeButton = new JButton("Close");
        closeButton.setBounds(150, 650, 100, 40);
        closeButton.setFont(buttonFont);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);
        closeButton.setBorder(BorderFactory.createBevelBorder(0));
        add(closeButton);
    }
    
    public void actionPerformed(ActionEvent e){
        dispose();
    }
    
    public void paint(Graphics g){
        ruleBackground = new ImageIcon("assets/ruleBackground.png").getImage();
        left = new ImageIcon("assets/left.png").getImage();
        right = new ImageIcon("assets/right.png").getImage();
        star = new ImageIcon("assets/star.png").getImage();
        coin = new ImageIcon("assets/coin.png").getImage();
        bomb = new ImageIcon("assets/bomb.png").getImage();
        g.drawImage(ruleBackground, 0, 0, this); 
        g.setFont(titleFont);
        g.drawString("Rules", 110, 130);
        g.setFont(ruleFont1);
        g.drawString("Use the arrow keys:", 20, 210);
        g.drawImage(left, 200, 240, this);
        g.drawImage(right, 285, 240, this);
        g.drawString("Catching:", 20, 350);
        g.drawImage(star, 160, 345, this);
        g.drawString("+1", 250, 380);
        g.drawImage(coin, 160, 420, this);
        g.drawString("+2", 250, 450);
        g.drawImage(bomb, 165, 480, this);
        g.drawString("Missing            :", 20, 620);
        g.drawImage(star, 110, 590, this);
        g.setFont(ruleFont2);
        g.drawString("game over", 250, 530);
        g.drawString("game over", 250, 620);
    }
}

class gameFrame extends JFrame implements KeyListener{
    JFrame gameFrame;
    JLabel scoreLabel;
    Image gameBackground;
    Image character;
    String charFile;
    Image star;
    Image coin;
    Image bomb;
    int charX = 400;
    int left = 1;
    int right = 0;
    Font scoreFont = new Font("Comic Sans MS", Font.PLAIN, 40);
    int star1X, star1Y, star2X, star2Y, coin1X, coin1Y, coin2X, coin2Y, coin3X, coin3Y, bomb1X, bomb1Y, bomb2X, bomb2Y;
    static int score;
    int flag = 0;
    
    public gameFrame(){
        gameFrame = new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTitle("Catch the Star");
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true); 
        charFile = "assets/left1.png";
        addKeyListener(this);
        score = 0;
        objects();
        dispose();
        new overFrame();
    }
    
    public void objects(){
        star1X = (int) Math.round(Math.random()*900);
        star1Y = -100;
        coin1X = (int) Math.round(Math.random()*900);
        coin1Y = -300;
        coin2X = (int) Math.round(Math.random()*900);
        coin2Y = -500;
        bomb1X = (int) Math.round(Math.random()*900);
        bomb1Y = -700;
        coin3X = (int) Math.round(Math.random()*900);
        coin3Y = -900;
        star2X = (int) Math.round(Math.random()*900);
        star2Y = -1100;
        bomb2X = (int) Math.round(Math.random()*900);
        bomb2Y = -1300;
        int sleep = 20; 
        while(true){
            repaint();
            if((star1X >= (charX - 20)) && (star1X <= (charX + 110)) && ((star1Y + 50) >= 670) && ((star1Y + 50) <= 770)){
                score += 1;
                star1X = (int) Math.round(Math.random()*900);
                star1Y = -100;
            }
            else if((star1Y + 50) == 800){
                break;
            }
            else{
                star1Y += 1;
            }
            if((star2X >= (charX - 20)) && (star2X <= (charX + 110)) && ((star2Y + 50) >= 670) && ((star2Y + 50) <= 770)){
                score += 1;
                star2X = (int) Math.round(Math.random()*900);
                star2Y = -100;
            }
            else if((star2Y + 50) == 800){
                break;
            }
            else{
                star2Y += 1;
            }            
            if((coin1X >= (charX - 20)) && (coin1X <= (charX + 110)) && ((coin1Y + 50) >= 670) && ((coin1Y + 50) <= 770)){
                score += 2;
                coin1X = (int) Math.round(Math.random()*900);
                coin1Y = -100;
            }
            else if((coin1Y + 50) == 800){
                coin1X = (int) Math.round(Math.random()*900);
                coin1Y = -100;
            }
            else{
                coin1Y += 1;
            }           
            if((coin2X >= (charX - 20)) && (coin2X <= (charX + 110)) && ((coin2Y + 50) >= 670) && ((coin2Y + 50) <= 770)){
                score += 2;
                coin2X = (int) Math.round(Math.random()*900);
                coin2Y = -100;
            }
            else if((coin1Y + 50) == 800){
                coin2X = (int) Math.round(Math.random()*900);
                coin2Y = -100;
            }
            else{
                coin2Y += 1;
            }            
            if((coin3X >= (charX - 20)) && (coin3X <= (charX + 110)) && ((coin3Y + 50) >= 670) && ((coin3Y + 50) <= 770)){
                score += 2;
                coin3X = (int) Math.round(Math.random()*900);
                coin3Y = -100;
            }
            else if((coin3Y + 50) == 800){
                coin3X = (int) Math.round(Math.random()*900);
                coin3Y = -100;
            }
            else{
                coin3Y += 1;
            }            
            if((bomb1X >= (charX - 11)) && (bomb1X <= (charX + 110)) && ((bomb1Y + 70) >= 670) && ((bomb1Y + 70) <= 770)){
                break;
            }
            else if((bomb1Y + 50) == 800){
                bomb1X = (int) Math.round(Math.random()*900);
                bomb1Y = -100;
            }
            else{
                bomb1Y += 1;
            }            
            if((bomb2X >= (charX - 11)) && (bomb2X <= (charX + 110)) && ((bomb2Y + 70) >= 670) && ((bomb2Y + 70) <= 770)){
                break;
            }
            else if((bomb2Y + 50) == 800){
                bomb2X = (int) Math.round(Math.random()*900);
                bomb2Y = -100;
            }
            else{
                bomb2Y += 1;
            }             
            if(score >= 5 && score < 10){
                sleep = 18;
            }
            else if (score >= 10 && score < 15){
                sleep = 15;
            }
            else if(score >= 15 && score < 20){
                sleep = 12;
            }
            else if (score >= 20){
                sleep = 10;
            }            
            try{
                Thread.sleep(sleep);
            }
            catch(Exception e)  {
            }           
        }
    }
     
    public void keyPressed (KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            charX = charX - 10;
            if (charX <= 0){
                charX = 0;
            }
            left = left + 1;
            if(left == 1){
                charFile = "assets/left1.png";
            }
            else if (left == 2){
                charFile = "assets/left2.png";
            }
            else if (left == 3){
                charFile = "assets/left3.png";
            }
            else if (left == 4){
                charFile = "assets/left4.png";
            }
            else if (left == 5){
                charFile = "lassets/eft5.png";
            }
            else if (left == 6){
                charFile = "assets/left6.png";
                left = 0;
            }
        }
        if (key == KeyEvent.VK_RIGHT){
            charX = charX + 10;
            if (charX >= 880){
                charX = 880;
            }
            right = right + 1;
            if(right == 1){
                charFile = "assets/right1.png";
            }
            else if (right == 2){
                charFile = "assets/right2.png";
            }
            else if (right == 3){
                charFile = "assets/right3.png";
            }
            else if (right == 4){
                charFile = "assets/right4.png";
            }
            else if (right == 5){
                charFile = "assets/right5.png";
            }
            else if (right == 6){
                charFile = "assets/right6.png";
                right = 0;
            }
        }
        repaint();
    }
    public void keyTyped (KeyEvent e) {
    }
    public void keyReleased (KeyEvent e) {   
    }

    public void paint(Graphics g){
        gameBackground = new ImageIcon("assets/gameBackground.jpeg").getImage();
        character = new ImageIcon(charFile).getImage();
        star = new ImageIcon("assets/star.png").getImage();
        coin = new ImageIcon("assets/coin.png").getImage();
        bomb = new ImageIcon("assets/bomb.png").getImage();
        g.drawImage(gameBackground, 0, 0, this);
        g.drawImage(character, charX, 650, this);
        g.drawImage(star, star1X, star1Y, this);
        g.drawImage(coin, coin1X, coin1Y, this);
        g.drawImage(star, star2X, star2Y, this);
        g.drawImage(bomb, bomb1X, bomb1Y, this);
        g.drawImage(coin, coin2X, coin2Y, this);
        g.drawImage(coin, coin3X, coin3Y, this);
        g.drawImage(bomb, bomb2X, bomb2Y, this);
        g.setFont(scoreFont);
        g.drawString("user: " + titleFrame.usernameText, 10, 100);
        g.drawString("score:" + Integer.toString(score), 10, 160);
    }
}

class overFrame extends JFrame{
    JFrame overFrame;
    Image resultBackground;
    Font overFont = new Font("Comic Sans MS", Font.BOLD, 100);
    
    public overFrame(){
        overFrame = new JFrame("Catch the star");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTitle ("Catch the Star");
        setSize (1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        try{
            Thread.sleep(1000);
        }
        catch(Exception e)  {
        }
        dispose();
        new resultFrame();
    }
    
    public void paint(Graphics g){
        resultBackground = new ImageIcon("assets/esultBackground.png").getImage();
        g.drawImage(resultBackground, 0, 0, this);
        g.setFont(overFont);
        g.drawString("Game Over", 250, 400);
    }
}

class resultFrame extends JFrame implements ActionListener{
    JFrame resultFrame;
    JButton exitButton, switchButton, playButton;
    Image resultBackground;
    Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
    Font textFont = new Font("Comic Sans MS", Font.PLAIN, 50);
    Font overFont = new Font("Comic Sans MS", Font.BOLD, 100);
    String [] nameArray = new String[100];
    int [] scoreArray = new int[100];
    int flag = 0;
    int highestScore;
    
    public resultFrame(){
        resultFrame = new JFrame("Catch the star");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTitle ("Catch the Star");
        setSize (1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true); 
        exitButton = new JButton("Exit");
        exitButton.setBounds(750, 650, 100, 40);
        exitButton.setFont(buttonFont);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        exitButton.setBorder(BorderFactory.createBevelBorder(0));
        switchButton = new JButton("Switch User");
        switchButton.setBounds(130, 650, 160, 40);
        switchButton.setFont(buttonFont);
        switchButton.setFocusable(false);
        switchButton.addActionListener(this);
        switchButton.setBorder(BorderFactory.createBevelBorder(0));
        playButton = new JButton("Replay");
        playButton.setBounds(450, 650, 100, 40);
        playButton.setFont(buttonFont);
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        playButton.setBorder(BorderFactory.createBevelBorder(0));       
        add(exitButton);
        add(switchButton);
        add(playButton);
        try{
            LineNumberReader nameReader = new LineNumberReader(new FileReader("data/nameFile.txt"));
            LineNumberReader scoreReader = new LineNumberReader(new FileReader("data/scoreFile.txt"));
            int line = 0;
            while(true){
                String nameText = nameReader.readLine();
                if(nameText == null){
                    break;
                }
                else{
                    nameArray[line] = nameText;
                    scoreArray[line] = Integer.parseInt(scoreReader.readLine());
                    line++;
                }
            }
            nameReader.close();
            scoreReader.close();
        }
        catch(IOException e){   
        }
        int count = 0;                                                      // count for user numbers
        for(int i = 0; i < 100; i++){
            if(nameArray[i] != null){
                count++;
            }
            else{
                break;
            }
        }
        int check = 0;
        for(int index = 0; index < 100; index++){                                               // individul's highest score
            if(nameArray[index] != null){
                if(nameArray[index].equals(titleFrame.usernameText)){
                    if(scoreArray[index] >= gameFrame.score){
                        highestScore = scoreArray[index];
                    }
                    else{
                        highestScore = gameFrame.score;
                        scoreArray[index] = gameFrame.score;
                    }
                    break;
                }
                else{
                    check++;
                }
            }
            else{
                if (check == count){
                    nameArray[index] = titleFrame.usernameText;
                    scoreArray[index] = gameFrame.score;
                    highestScore = gameFrame.score;
                    count++;
                }
                break;
            }
        }
        for(int num = 1; num < count; num++){                                   // sort the score / name
            for(int index = 0; index < (count - 1); index++){
                if(scoreArray[index] < scoreArray[index + 1]){
                    String swapName;
                    int swapScore;
                    swapScore = scoreArray[index + 1];
                    scoreArray[index + 1] = scoreArray[index];
                    scoreArray[index] = swapScore;
                    swapName = nameArray[index + 1];
                    nameArray[index + 1] = nameArray[index];
                    nameArray[index] = swapName;
                }
            }
        }
        try{                                                        // write sorted score / name into files
            BufferedWriter nameWriter = new BufferedWriter(new FileWriter("data/nameFile.txt"));
            BufferedWriter scoreWriter = new BufferedWriter(new FileWriter("data/scoreFile.txt"));
            for(int index = 0; index < count; index++){
                nameWriter.write(nameArray[index] + "\n");
                scoreWriter.write(String.valueOf(scoreArray[index] + "\n"));
            }
            nameWriter.close();
            scoreWriter.close();
        }
        catch(IOException e){
        }
        while(true){
            if(flag == 1){
                dispose();
                new gameFrame();
                break;
            }
            else if(flag == 2){
                dispose();
                new titleFrame();
                break;
            }
            System.out.println(flag);                           // will not work if comment this out
        }
    }
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        if (action.equals("Switch User")){
            flag = 2;
        }
        else if(action.equals("Replay")){
            flag = 1;
        }
        else if(action.equals("Exit")){
            dispose();
        }
    }
    
    public void paint(Graphics g){
        resultBackground = new ImageIcon("assets/resultBackground.png").getImage();
        g.drawImage(resultBackground, 0, 0, this);
        g.setFont(overFont);
        g.drawString("Game Over", 250, 130);
        g.setFont(textFont);
        g.drawString("User:", 200, 300);
        g.drawString(titleFrame.usernameText, 600, 300);
        g.drawString("Round Score:", 200, 450);
        g.drawString(String.valueOf(gameFrame.score), 600, 450);
        g.drawString("Best Score:" , 200, 600);
        g.drawString(String.valueOf(highestScore), 600, 600);
    }
}
