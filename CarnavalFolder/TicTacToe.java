
package CarnavalFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToe extends JFrame {
    public static int wins;

    private class ButtonListener implements ActionListener {
        private int row;
        private int col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (board[row][col] == 0) {
                board[row][col] = turn;
                if (turn == 1) {
                    buttons[row][col].setText("X");
                    turn = 2;
                    statusLabel.setText("Player 2's turn");
                } else {
                    buttons[row][col].setText("O");
                    turn = 1;
                    statusLabel.setText("Player 1's turn");
                }
                checkWin();
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private JPanel panel;
    private JButton[][] buttons;
    private int[][] board;

    private int turn;
    public static int score;
    private JLabel statusLabel;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(3, 3));
        add(panel, BorderLayout.CENTER);

        buttons = new JButton[3][3];
        board = new int[3][3];
        turn = 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].addActionListener(new ButtonListener(row, col));
                panel.add(buttons[row][col]);
            }
        }
        setVisible(true);

        statusLabel = new JLabel("Player 1's turn");
        add(statusLabel, BorderLayout.SOUTH);

    }

    private void checkWin() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != 0 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                endGame(board[row][0]);
                return;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != 0 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                endGame(board[0][col]);
                return;
            }
        }

        // Check diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            endGame(board[0][0]);
            return;
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            endGame(board[0][2]);
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 0) {
                    tie = false;
                    break;
                }
            }
            if (!tie)
                break;
        }

        if (tie) {
            endGame(0);
        }
    }

    private void endGame(int winner) {
        String message;
        
        if (winner == 0) {
            message = "It's a tie!";
        } else {
            message = "Player " + winner + " wins!" + wins;
        }
        if (winner == 1) {
            wins++;
        }

        JOptionPane.showMessageDialog(this, message);
        resetBoard();
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                board[row][col] = 0;
            }
        }
        turn = 1;
        statusLabel.setText("Player 1's turn");
    }
    public class OtherProject {
    public static int getIntValue() {
        int intValue = wins; // Or any other value
        return intValue;
    }
}


}

