import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShogiGUI {
    private static final int ROWS = 9;
    private static final int COLS = 9;
    private static final Color LIGHT_COLOR = new Color(222, 184, 135); // Bege
    private static final Color BORDER_COLOR = Color.BLACK;

    private JFrame frame;
    private JPanel boardPanel;
    private JPanel[][] cellPanels;
    private Piece[][] board;

    private int selectedRow = -1;
    private int selectedCol = -1;

    public ShogiGUI() {
        frame = new JFrame("Shogi Game");
        boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        cellPanels = new JPanel[ROWS][COLS];
        board = new Piece[ROWS][COLS];

        initializeBoard();

        frame.add(boardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.setBackground(LIGHT_COLOR);//Adicionar cor ao tabuleiro
                cellPanel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR)); // Adiciona contorno preto
                cellPanel.addMouseListener(new CellClickListener(row, col));
                cellPanels[row][col] = cellPanel;
                boardPanel.add(cellPanel);
            }
        }

        // Como as peças devem ser adicionadas:
        /*board[0][0] = new Lanceiro(null, null, null, null, null, null, false);
        board[0][1] = new Cavalo(null, null, null, 0, null, COLS, false);
        board[0][4] = new Rei(null, null, null, 0, null, COLS, false);
        board[0][7] = new Cavalo(null, null, null, 0, null, COLS, false);
        board[0][8] = new Lanceiro(null, null, null, null, null, null, false);
        board[1][1] = new Torre(null, null, null, 0, null, COLS, false);
        board[1][7] = new Torre(null, null, null, 0, null, COLS, false);
        for (int coluna=0; coluna<9; coluna++){
            board[2][coluna] = new Peão(null, null, 0, coluna, false);
        }*/
       
        // Exemplo visual
        board[2][4] = new Piece("Images/lanca.png");
        

        updateBoardUI();
    }

    private void updateBoardUI() {
    
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cellPanel = cellPanels[row][col];
                cellPanel.removeAll();

                Piece piece = board[row][col];
                if (piece != null) {
                    //Seta a imagem da peça
                    JLabel pieceLabel = new JLabel(piece.getImageIcon());
                    pieceLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    cellPanel.add(pieceLabel, BorderLayout.CENTER);
                }

                if (row == 0 && col != 8) {
                    //Realiza a numeração do tabuleiro
                    JLabel label = new JLabel(String.valueOf(COLS - col));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    cellPanel.add(label, BorderLayout.NORTH);
                }

                if (row != 0 && col == 8) {
                    //Realiza a numeração do tabuleiro
                    JLabel label = new JLabel(String.valueOf(row + 1));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    cellPanel.add(label, BorderLayout.NORTH);
                }

                
                cellPanel.revalidate();
                cellPanel.repaint();
            }
        }
        JPanel cellPanel = cellPanels[0][8];
        JLabel jLabel = new JLabel(String.valueOf(1));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cellPanel.add(jLabel, BorderLayout.NORTH);
        cellPanel.revalidate();
        cellPanel.repaint();

    }

    private class CellClickListener extends MouseAdapter {
        //Classe para definir a lógica quando o usuário clica nas peças e tenta realizar uma ação
        private int row;
        private int col;

        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (selectedRow == -1 && selectedCol == -1) {
                // Se nenhuma célula estiver selecionada, seleciona a célula atual
                if (board[row][col] != null) {
                    selectedRow = row;
                    selectedCol = col;
                    cellPanels[row][col].setBackground(Color.YELLOW);
                }
            } else {
                // Se uma célula já estiver selecionada, move a peça para a nova célula se for uma jogada válida
                if (isValidMove(selectedRow, selectedCol, row, col)) {
                    board[row][col] = board[selectedRow][selectedCol];
                    board[selectedRow][selectedCol] = null;
                    cellPanels[selectedRow][selectedCol].setBackground(LIGHT_COLOR);
                    cellPanels[row][col].setBackground(LIGHT_COLOR);

                    selectedRow = -1;
                    selectedCol = -1;
                } else {
                    JOptionPane.showMessageDialog(frame, "Jogada inválida!");
                }
            }
        }

        private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
            // Lógica para verificar se a jogada é válida 
            return true; // Temporariamente, retorna true para permitir qualquer movimento
        }
    }

    private class Piece {
        // Classe exemplo
        private ImageIcon imageIcon;

        public Piece(String imagePath) {
            this.imageIcon = new ImageIcon(imagePath);
        }
        public ImageIcon getImageIcon() {
            return imageIcon;
        }
     
    }

    public static void main(String[] args) {
    //chama a interface
    SwingUtilities.invokeLater(ShogiGUI::new);
}

}
