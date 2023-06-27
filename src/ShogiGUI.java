import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
        JogadorOushou jogador = new JogadorOushou("Pedro", 21, true);
        JogadorGyokushou jogador2 = new JogadorGyokushou("Rafael", 21, false);
        Tabuleiro tabuleiro = new Tabuleiro(jogador, jogador2);
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
        // Como as peças devem ser adicionadas:s
        tabuleiro.getGrid()[8][0] = new Lanceiro(8,0, tabuleiro.getOushou(), null, Simbolo.LANCEIRO_N.getSimbolo(), null, 3, false, tabuleiro);
        tabuleiro.getGrid()[8][1] = new Cavalo(8, 1, tabuleiro.getOushou(), null, Simbolo.CAVALO_N.getSimbolo(), null,10 , false, tabuleiro);
        tabuleiro.getGrid()[8][2] = new Prata(8, 2, tabuleiro.getOushou(), null, Simbolo.PRATA_N.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[8][3] = new Ouro(8, 3, tabuleiro.getOushou(), null, Simbolo.OURO.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[8][4] = new Rei(8,4, tabuleiro.getOushou(), null, Simbolo.REI.getSimbolo(), null, 8, false, tabuleiro);
        tabuleiro.getGrid()[4][4] = new Ouro(4, 4, tabuleiro.getOushou(), null, Simbolo.OURO.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[8][6] = new Prata(8, 6, tabuleiro.getOushou(), null, Simbolo.PRATA_N.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[8][7] = new Cavalo(8, 7, tabuleiro.getOushou(), null, Simbolo.CAVALO_N.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[8][8] = new Lanceiro(8,8, tabuleiro.getOushou(), null, Simbolo.LANCEIRO_N.getSimbolo(), null, 4, false, tabuleiro);
        tabuleiro.getGrid()[7][1] = new Bispo(7,1, tabuleiro.getOushou(), null, Simbolo.BISPO_N.getSimbolo(), null, 4, false, tabuleiro);
        tabuleiro.getGrid()[7][7] = new Torre(7,7, tabuleiro.getOushou(), null, Simbolo.TORRE_N.getSimbolo(), null, COLS, false, tabuleiro);
        for (int coluna=0; coluna<8; coluna++){
            tabuleiro.getGrid()[6][coluna] = new Peão(6, coluna, tabuleiro.getOushou(), Simbolo.PEAO_N.getSimbolo(), coluna, false, tabuleiro); 
        }

        // ! TESTE
        tabuleiro.getGrid()[4][4] = new Torre(4,4, tabuleiro.getOushou(), null, Simbolo.TORRE_P.getSimbolo(), null, 4, false, tabuleiro);            
        tabuleiro.getGrid()[4][5] = new Peão(4, 5, tabuleiro.getOushou(), Simbolo.PEAO_N.getSimbolo(), 10, false, tabuleiro);
        tabuleiro.getGrid()[4][5].promoverPeça();
        tabuleiro.getGrid()[2][7] = new Prata(2, 7, tabuleiro.getGyokushou(), null, Simbolo.OURO.getSimbolo(), null, COLS, false, tabuleiro);
        tabuleiro.getGrid()[2][7].promoverPeça();
        
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
            Cavalo cavalo = new Cavalo(0, 0, tabuleiro.getGyokushou(), null, Simbolo.CAVALO_N.getSimbolo(), null, 0, false, tabuleiro);
            JLabel pieceLabel = new JLabel(cavalo.getListImageIcon().get(0));
            bankPanel.add(pieceLabel);
        }
    }

    private void updateBoardUI(Tabuleiro tabuleiro) {
    
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cellPanel = cellPanels[row][col];
                JLabel pieceLabel;
                cellPanel.removeAll();

                Peça peça = tabuleiro.getGrid()[row][col];
                if (peça != null) {
                    //Seta a imagem da peça
                    if (peça.getPromovida() == false) { // !fiz auterações na exibição dos ícones
                        pieceLabel = new JLabel(peça.getListImageIcon().get(0)); 
                    } else {
                        pieceLabel = new JLabel(peça.getListImageIcon().get(1));
                    }
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

             public void mouseClicked(MouseEvent event) {
            //if (selectedRow == -1 && selectedCol == -1) {
                // Se nenhuma célula estiver selecionada, seleciona a célula atual
                if ((selectedRow == -1 && selectedCol == -1) || (tabuleiro.getGrid()[row][col] != null) && tabuleiro.getGrid()[selectedRow][selectedCol].getJogador().equals(tabuleiro.getGrid()[row][col].getJogador())) {
                    selectedRow = row;
                    selectedCol = col;
                    cellPanels[row][col].setBackground(Color.YELLOW);

                    // Obtém as coordenadas onde a movimentação é válida para a peça selecionada
                ArrayList<Coordenada> validMoves = tabuleiro.getGrid()[row][col].podeAndar();
                highlightValidMoves(validMoves);
                }
             else {
                Coordenada coordenada_final = new Coordenada(row, col);

                // Se uma célula já estiver selecionada, move a peça para a nova célula se for uma jogada válida
                if (tabuleiro.getGrid()[selectedRow][selectedCol].andarPara(coordenada_final, tabuleiro)) {
    
                    if (tabuleiro.getGrid()[row][col] != null && !(tabuleiro.getGrid()[row][col].getJogador().equals((tabuleiro.getGrid()[selectedRow][selectedCol]).getJogador()))) {
                        Peça captura = tabuleiro.getGrid()[selectedRow][selectedCol].capturar(coordenada_final, tabuleiro);

                        /* if (captura.getJogador() instanceof JogadorOushou) {
                            JPanel bankPanel = painelBancoJogador[0];
                            JLabel pieceLabel = new JLabel(captura.getListImageIcon().get(0));
                            bankPanel.add(pieceLabel);
                        }

                        if (captura.getJogador() instanceof JogadorGyokushou) {
                            JPanel bankPanel = painelBancoJogador[1];
                            JLabel pieceLabel = new JLabel(captura.getListImageIcon().get(0));
                            bankPanel.add(pieceLabel);
                        } */
                        
                        System.out.print(captura);
                        tabuleiro.getGrid()[captura.getCoordenada().getC_x()][captura.getCoordenada().getC_y()] = null;
                    }
                    tabuleiro.getGrid()[row][col] = tabuleiro.getGrid()[selectedRow][selectedCol];
                    tabuleiro.getGrid()[selectedRow][selectedCol] = null;
                    cellPanels[selectedRow][selectedCol].setBackground(LIGHT_COLOR);
                    cellPanels[row][col].setBackground(LIGHT_COLOR);
                    updateBoardUI(tabuleiro);
                    clearHighlights();
                }

                else {
                    JOptionPane.showMessageDialog(frame, "Jogada inválida!");
                }
                selectedRow = -1;
                selectedCol = -1;
            }
        }
    }

    private void highlightValidMoves(ArrayList<Coordenada> validMoves) {
        // Remove o destaque de todos os quadrados
        clearHighlights();

        // Adiciona o destaque nos quadrados válidos
        for (Coordenada move : validMoves) {
            cellPanels[move.getC_x()][move.getC_y()].setBackground(Color.GREEN);
        }
    }

    private void clearHighlights() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cellPanels[row][col].setBackground(LIGHT_COLOR);
            }
        }
    }

    public static void main(String[] args) {
    //chama a interface
    SwingUtilities.invokeLater(ShogiGUI::new);
}

}
