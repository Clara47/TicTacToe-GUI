import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTTGUI extends JFrame implements ActionListener{
   private final int WINDOW_WIDTH=800;
   private final int WINDOW_HEIGHT=400;
   private String filler = "    ";
   private JLabel result;
   private JButton [] cells;
   private TTT ttt;
   int rows = 3;
   int cols = 3;
   int size=rows*cols;
   boolean gameOver = false;
   public String xD; 

   public TTTGUI (){
      setTitle("Tic Tack Toe");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      setLayout(new BorderLayout ());
      JLabel banner = new JLabel ("Tic Tack Toe! Take turns placing X's or O's on a board- first one to three in a one wins!");
      add(banner, BorderLayout.NORTH);
      add (new JLabel (filler), BorderLayout.EAST);
      add (new JLabel(filler), BorderLayout.WEST);
      result= new JLabel (filler);
      add(result, BorderLayout.SOUTH);
   
      ttt = new TTT();
   
      rows= ttt.getRows();
      cols= ttt.getCols();
      size = rows*cols;
      cells=new JButton[size];
   
      Panel pTTT = new Panel ();
      pTTT.setLayout(new GridLayout(rows,cols));
   
      for (int i=0; i<size; i++){
         cells[i] = new JButton(" " ); 
         cells[i].addActionListener(this); 
         pTTT.add(cells[i]);
      }//for
   
      add(pTTT, BorderLayout.CENTER);
      setVisible(true);
   
   }//TTT

   int getRows ()
   {
      return (rows);}

   int getCols ()
   {
      return (cols);}

   public void actionPerformed(ActionEvent ae){
      result.setText(" ");
      JButton source = (JButton) ae.getSource();
   
        // find out which button was pushed 
      int i=0;
      while (source != cells [i]){
         i++;
      
         if(cells[i].getText().toString().equals("O") || cells[i].getText().toString().equals("X")){
            result.setText("That space is already taken!");
          }
          
         ttt.takeTurn(i);
      
         //cells[i].setText(ttt.getSymbol());
      
         if (ttt.isWinner()){
            cells[i].removeActionListener(this);
            if(cells[i].getText().toString().equals("O"))
               result.setText("Congrats, O won!");
            else if(cells[i].getText().toString().equals("X"))
               result.setText("Congrats, X won!");
         }//if ttt.isWinner
         else if (ttt.isFull()){
            cells[i].removeActionListener(this);
            result.setText("Tie!");
         }//elif
   
        else if(ttt.getSymbol().equals("X"))
         {
            //cells[i].setText("O");
            //cells[i].setText("O");
            result.setText("Okay X it's your turn!!");
         }//if 
         else
         {
           // cells[i].setText("X");
          // cells[i].setText("X");
            result.setText("Okay O it's your turn!!"); 
         
         }
      }
   
   
        //here's where I'm trying to toggle in the main GUI since the toggling in the TTT would not function
   }//AcPerf
}//TTTGUI