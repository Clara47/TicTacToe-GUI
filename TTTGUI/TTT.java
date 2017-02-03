import java.util.*; 

class TTT {
//class TTT { 
   final int ROWS = 3;
   final int COLS = 3; 
   String symbol; //currentPlayerSymbol
   String [][] board = new String[ROWS][COLS]; 
   
   public TTT(){
      symbol = "O"; 
      board = initializeBoard();
   }
   
   int getRows(){
      return(ROWS);}
   int getCols(){
      return(COLS);}
   String getSymbol(){
      return(symbol);}
   String getGameName(){
      return("TTT");}
   
   String instructions(){
      String instrctns = "TTT, place your mark on the board to connect three. X goes first";
      return(instrctns);  
     // instructions 
   }
   

   void takeTurn(int position){
      int row = position/COLS;
      int col = position%COLS; 
      board[row][col] = symbol;
      if(!(isWinner() || isFull()));
      
       togglePlayer();  
   } 
   
  // boolean validateInput(String input){
   //   return(input.equals(symbol));}
 
   boolean gameOverStatus(){
      return (isFull() || isWinner()); 
   }
    
   private String[][] initializeBoard(){
      String [][]b = {{" "," "," "},{" "," "," "},{" "," "," "}}; 
   //      String [][] b = {{" ","X"," "},{" ","O"," "},{" "," ","X"}}; 
   //      symbol ="O";
   //      String [][] b = {{" ","X","O"},{"O","O","X"},{"X","O","X"}}; 
      return(b); 
   }

   String [][] getBoard(){
      return (board);} 
   
   String get(int r, int c){
      return(board[r][c]);} 
   
  private void togglePlayer(){
      if(symbol.equals("O"))
         symbol = "X";
      else
         symbol = "O"; 
   }// toggle 
   
   boolean isFull(){
   for(int r = 0;r<ROWS;r++)
         for(int c = 0; c<COLS;c++)
            if(board[r][c].equals(" "))
               return(false);
      return(true);  

   }
    
   boolean isWinner(){
      // win by row: 
      for(int r=0;r<ROWS;r++)
         if(!board[r][0].equals(" ") && board[r][0].equals(board[r][1]) && board[r][0].equals(board[r][2]))
            return(true);
      
            // win by column
      for (int c =0;c<COLS;c++)
         if(!board[0][c].equals(" ") && board[0][c].equals(board[1][c]) && board[0][c].equals(board[2][c]))
            return(true);  
       
      if (!board[1][1].equals(" ")){ // try diagonal      
         if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
            return(true);
         
         else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
            return (true);
      } 
      return (false); 
      
   }// iswinner
  
   
}// class
