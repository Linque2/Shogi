import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Componentes.*;

public class ShogiGUI {
    private static final int ROWS = 9;
    private static final int COLS = 9;
    private static final int BANK_SIZE = 10;
    private static final int NUM_PLAYERS = 2;
    private static final Color LIGHT_COLOR = new Color(222, 184, 135); // Bege
    private static final Color BORDER_COLOR = Color.BLACK;

    private JFrame frame;
    private JPanel boardPanel;
    private JPanel[][] cellPanels;
    private JPanel[] painelBancoJogador;
    private JScrollPane[] painelBancoJogadorScroll;

    private int selectedRow = -1;
    private int selectedCol = -1;

    public ShogiGUI() {
        frame = new JFrame("Shogi Game");
        boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        cellPanels = new JPanel[ROWS][COLS];
        Tabuleiro tabuleiro = new Tabuleiro(null, null);
        tabuleiro.setGrid(new Peça[ROWS][COLS]);

        initializeBoard(tabuleiro);
        initializePainelBancoJogador(tabuleiro);

        frame.setLayout(new BorderLayout());
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(painelBancoJogadorScroll[0], BorderLayout.EAST);
        frame.add(painelBancoJogadorScroll[1], BorderLayout.WEST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeBoard(Tabuleiro tabuleiro) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.setBackground(LIGHT_COLOR);//Adicionar cor ao tabuleiro
                cellPanel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR)); // Adiciona contorno preto
                cellPanel.addMouseListener(new CellClickListener(row, col, tabuleiro));
                cellPanels[row][col] = cellPanel;
                boardPanel.add(cellPanel);
            }
        }

        // Como as peças devem ser adicionadas:
        tabuleiro.getGrid()[0][0] = new Lanceiro(0,0, null, null, null, null, null, false);
        tabuleiro.getGrid()[0][1] = new Cavalo(0, 1, null, null, Simbolo.CAVALO_N.getSimbolo(), null,10 , false);
        tabuleiro.getGrid()[0][2] = new Prata(0, 2, null, null, Simbolo.PRATA_N.getSimbolo(), null, COLS, false);
        tabuleiro.getGrid()[0][3] = new Ouro(0, 3, null, null, Simbolo.OURO.getSimbolo(), null, COLS, false);
        tabuleiro.getGrid()[0][4] = new Rei(0,4, null, null, Simbolo.REI.getSimbolo(), null, 8, false);
        tabuleiro.getGrid()[0][5] = new Ouro(0, 5, null, null, Simbolo.OURO.getSimbolo(), null, COLS, false);
        tabuleiro.getGrid()[0][6] = new Prata(0, 6, null, null, Simbolo.PRATA_N.getSimbolo(), null, COLS, false);
        tabuleiro.getGrid()[0][7] = new Cavalo(0, 7, null, null, Simbolo.CAVALO_N.getSimbolo(), null, COLS, false);
        tabuleiro.getGrid()[0][8] = new Bispo(0,8, null, null, 'C', null, 4, false);
        tabuleiro.getGrid()[1][1] = new Bispo(1,1, null, null, Simbolo.BISPO_N.getSimbolo(), null, 4, false);
        tabuleiro.getGrid()[1][7] = new Torre(1,7, null, null, Simbolo.TORRE_N.getSimbolo(), null, COLS, false);
        for (int coluna=0; coluna<9; coluna++){
            tabuleiro.getGrid()[2][coluna] = new Peão(2, coluna, null, Simbolo.PEAO_N.getSimbolo(), coluna, false);
        }
            

        updateBoardUI(tabuleiro);
    }

    private void initializePainelBancoJogador(Tabuleiro tabuleiro) {
        painelBancoJogador = new JPanel[NUM_PLAYERS];
        painelBancoJogadorScroll = new JScrollPane[NUM_PLAYERS];

       for (int player = 0; player < NUM_PLAYERS; player++) {
            JPanel bankPanel = new JPanel(new GridLayout(BANK_SIZE, 1));
            JScrollPane bankScrollPane = new JScrollPane(bankPanel);
            bankScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            bankScrollPane.setPreferredSize(new Dimension(200, frame.getHeight()));
            //Adicionando título
            TitledBorder titledBorder = BorderFactory.createTitledBorder("Jogador " + (player + 1));
            titledBorder.setTitleJustification(TitledBorder.CENTER);
            bankScrollPane.setBorder(titledBorder);

            painelBancoJogador[player] = bankPanel;
            painelBancoJogadorScroll[player] = bankScrollPane;
        }
        //exemplo de uma peça no banco
        for (int player = 0; player < NUM_PLAYERS; player++) {
            JPanel bankPanel = painelBancoJogador[player];
            Cavalo cavalo = new Cavalo(-1, -1, null, null, Simbolo.CAVALO_N.getSimbolo(), null, 0, false);
            JLabel pieceLabel = new JLabel(cavalo.getListImageIcon().get(0));
            bankPanel.add(pieceLabel);
        }
    }

    private void updateBoardUI(Tabuleiro tabuleiro) {
    
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cellPanel = cellPanels[row][col];
                cellPanel.removeAll();

                Peça peça = tabuleiro.getGrid()[row][col];
                if (peça != null) {
                    //Seta a imagem da peça
                    JLabel pieceLabel = new JLabel(peça.getListImageIcon().get(0));
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
        private Tabuleiro tabuleiro;

        public CellClickListener(int row, int col, Tabuleiro tabuleiro) {
            this.row = row;
            this.col = col;
            this.tabuleiro = tabuleiro;
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            if (selectedRow == -1 && selectedCol == -1) {
                // Se nenhuma célula estiver selecionada, seleciona a célula atual
                if (tabuleiro.getGrid()[row][col] != null) {
                    selectedRow = row;
                    selectedCol = col;
                    cellPanels[row][col].setBackground(Color.YELLOW);
                }
            } else {
                // Se uma célula já estiver selecionada, move a peça para a nova célula se for uma jogada válida
                if (isValidMove(selectedRow, selectedCol, row, col)) {
                    tabuleiro.getGrid()[row][col] = tabuleiro.getGrid()[selectedRow][selectedCol];
                    tabuleiro.getGrid()[selectedRow][selectedCol] = null;
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

    public static void main(String[] args) {
    //chama a interface
    SwingUtilities.invokeLater(ShogiGUI::new);
}

}
