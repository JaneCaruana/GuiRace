import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


   public class GuiRace{
      
         JFrame frame;
         JProgressBar progressBarKnight = new JProgressBar(0, 100);
         JProgressBar progressBarBatmobile = new JProgressBar(0,100);
   
   public static void main(String[]args){
      EventQueue.invokeLater(new Runnable(){
      public void run(){
         try{
            GuiRace window= new GuiRace();
            window.frame.setVisible(true);
            }
            catch (Exception e){
               e.printStackTrace();
               }
            }
          });
       }
       
       //Creat Application
       
       public GuiRace(){
         initialize();
         }
         
         //Initialize the contents of the frame
         
      private void initialize(){
         frame = new JFrame();
         frame.setBounds(100,100,598,430);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().setLayout(null);
         
         progressBarKnight.setStringPainted(true);
         progressBarKnight.setForeground(Color.RED);
         progressBarKnight.setBounds(16,249,259,14);
         frame.getContentPane().add(progressBarKnight);
         
         progressBarBatmobile.setStringPainted(true);
         progressBarBatmobile.setForeground(Color.BLUE);
         progressBarBatmobile.setBounds(313,249,259,14);
         frame.getContentPane().add(progressBarBatmobile);
         
         JButton btnKnightRider = new JButton("");
         btnKnightRider.setIcon(new ImageIcon(GuiRace.class.getResource("car1.jpg")));
        // btnKnightRider.setIcon(new ImageIcon(Gui.Race.class.getResource("car1.jpg").getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))S);
         btnKnightRider.setBounds(16,11,259,194);
         frame.getContentPane().add(btnKnightRider);
         
         JButton btnBatmobile = new JButton("");
         btnBatmobile.setIcon(new ImageIcon(GuiRace.class.getResource("car2.jpg")));
         btnBatmobile.setBounds(313,11,259,194);
         frame.getContentPane().add(btnBatmobile);
         
         JButton btnStart = new JButton("Start");
         btnStart.setFont(new Font("Tahoma",Font.PLAIN,18));
         btnStart.addActionListener(new StartRace());
         
         btnStart.setBounds(213,287,155,78);
         frame.getContentPane().add(btnStart);
         }
         
         class StartRace implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent args){
            Knight kitt = new Knight();
            kitt.start();
//btnkitt.setIcon(new ImageIcon(GuiRace.class.getResource("car1.gif")));
            
            Bat runBat = new Bat();
            Thread myBat = new Thread(runBat);
            myBat.start();
            
         }
       }
      
      class Bat implements Runnable{
      public void run(){
         for(int i = 0; i<101;i++){
         progressBarBatmobile.setValue(i); //set value
         progressBarBatmobile.repaint(); // resfresh graphics
         progressBarBatmobile.setString(Integer.toString(i) + "%");
         try{
            Thread.sleep(100);
            }
          catch(InterruptedException err){
          err.printStackTrace();
          }
         }
         }
         }
         class Knight extends Thread{
            public void run(){
               for(int i = 0; i<101 ; i++){
          progressBarKnight.setValue(i); //set value
         progressBarKnight.repaint(); // resfresh graphics
         progressBarKnight.setString(Integer.toString(i) + "%");
         try{
            Thread.sleep(50);
            }
          catch(InterruptedException err){
          err.printStackTrace();
          }
         }
         }
         }
         }
