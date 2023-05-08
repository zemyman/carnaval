package CarnavalFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends JFrame {
    public static int wins; // number of wins for the game, initially set to 0

    // ActionListener for each button on the game board
    private class ButtonListener implements ActionListener {
        private int row;
        private int col;

        // constructor to set the row and column for the button
        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // actionPerformed method to handle button click
        public void actionPerformed(ActionEvent e) {
            if (board[row][col] == 0) { // check if the cell is empty
                board[row][col] = turn; // assign the current player's turn to the cell
                if (turn == 1) { // if it's player 1's turn
                    buttons[row][col].setText("X"); // set the button text to "X"
                    turn = 2; // set the turn to player 2
                    statusLabel.setText("Player 2's turn"); // update the status label
                } else { // if it's player 2's turn
                    buttons[row][col].setText("O"); // set the button text to "O"
                    turn = 1; // set the turn to player 1
                    statusLabel.setText("Player 1's turn"); // update the status label
                }
                checkWin(); // check if the current player has won
            }
        }
    }

    // main method (not used in this code)
    public static void main(String[] args) {
      //  new TicTacToe();
    }

    private JPanel panel; // game board panel
    private JButton[][] buttons; // array of buttons for the game board
    private int[][] board; // array to keep track of the state of the game board

    private int turn; // current player's turn
    public static int score; // player's score (not used in this code)
    private JLabel statusLabel; // label to show the current player's turn

    // constructor to initialize the game board
    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(3, 3)); // create the game board panel with 3x3 grid layout
        add(panel, BorderLayout.CENTER);

        buttons = new JButton[3][3]; // create the array of buttons for the game board
        board = new int[3][3]; // create the array to keep track of the state of the game board
        turn = 1; // set the turn to player 1

        // loop through each row and column to create a button for each cell in the game board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton(); // create a new button
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60)); // set the font size for the button text
                buttons[row][col].addActionListener(new ButtonListener(row, col)); // add the ActionListener to the button
                panel.add(buttons[row][col]); // add the button to the game board panel
            }
        }

        setVisible(true); // set the game

        statusLabel = new JLabel("Player 1's turn");
        add(statusLabel, BorderLayout.SOUTH);

    }

    private void checkWin() {
        // Check rows
        for (int row = 0; row < 3; row++) { // loop through each row
            // If the first cell in a row is not empty and all the cells in the row are the same, a player has won
            if (board[row][0] != 0 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                endGame(board[row][0]); // Call the endGame function with the player who won
                return; // Exit the function
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) { // loop through each column
            // If the first cell in a column is not empty and all the cells in the column are the same, a player has won
            if (board[0][col] != 0 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                endGame(board[0][col]); // Call the endGame function with the player who won
                return; // Exit the function
            }
        }

        // Check diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            endGame(board[0][0]); // Call the endGame function with the player who won
            return; // Exit the function
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            endGame(board[0][2]); // Call the endGame function with the player who won
            return; // Exit the function
        }

        // Check for tie
        boolean tie = true;
        for (int row = 0; row < 3; row++) { // loop through each row
            for (int col = 0; col < 3; col++) { // loop through each column in the row
                // If there is an empty cell, the game is not a tie
                if (board[row][col] == 0) {
                    tie = false;
                    break; // Exit the inner loop
                }
            }
            // Exit the outer loop if a non-empty cell is found
            if (!tie)
                break;
        }

        // If it's a tie, call the endGame function with 0 as the argument
        if (tie) {
            endGame(0);
        }
    }

    private void endGame(int winner) {
        String message;
        
        // determine the winner or tie
        if (winner == 0) {
            message = "It's a tie!";
        } else {
            message = "Player " + winner + " wins!";
        }
        
        // update score based on winner
        if (winner == 1) {
            wins++;
        }
        if (winner == 2) {
            wins--;
        }
    
        // show message dialog with winner/tie message
        JOptionPane.showMessageDialog(this, message);
       
        // create new instance of carnaval and pass in updated wins
       new Carnival(wins);
        //Carnaval.setScore(wins); // BUG: for some reson it only sets the score after second game (5-04(8:51pm))
        
        // reset the board for a new game
        resetBoard();
        
        // close the current game window
        dispose();
    }
    
    private void resetBoard() {
        // reset all buttons and board values
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                board[row][col] = 0;
            }
        }
       
        // reset turn and status label
        turn = 1;
        statusLabel.setText("Player 1's turn");
    }
    
    // A separate class for obtaining the value of wins from another project
    public class OtherProject {
        public static int getIntValue() {
            int intValue = wins; // Or any other value
            return intValue;
        }
    }
}