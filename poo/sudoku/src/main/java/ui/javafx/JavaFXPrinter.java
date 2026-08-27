package ui.javafx;

import enums.StatusPartida;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.Casa;
import model.Tabuleiro;
import ui.InterfaceApresentacao;
import java.util.function.BiConsumer;

public class JavaFXPrinter implements InterfaceApresentacao {

    private static final int TAMANHO = 9;

    private final GridPane board;

    private int linhaSelecionada = -1;
    private int colunaSelecionada = -1;
    private BiConsumer<Integer, Integer> acaoClique;

    public JavaFXPrinter(GridPane board) {
        this.board = board;
    }

    @Override
    public void exibirTabuleiro(Tabuleiro tabuleiro) {

        board.getChildren().clear();

        for (int linha = 0; linha < TAMANHO; linha++) {

            for (int coluna = 0; coluna < TAMANHO; coluna++) {

                Casa casa = tabuleiro.getCasa(linha, coluna);

                StackPane cell = criarCasa(casa, linha, coluna);

                board.add(cell, coluna, linha);
            }
        }
        configurarEventosClique();
    }

    public void configurarClique(
            BiConsumer<Integer, Integer> acao) {

        this.acaoClique = acao;

        configurarEventosClique();
    }

    private void configurarEventosClique() {

        if (acaoClique == null) {

            return;
        }

        for (var node: board.getChildren()) {

            int coluna = GridPane.getColumnIndex(node);
            int linha = GridPane.getRowIndex(node);

            node.setOnMouseClicked(event -> {

                selecionarVisualmente(linha, coluna);

                acaoClique.accept(linha, coluna);
            });
        }
    }

    private StackPane criarCasa(Casa casa,
                                int linha,
                                int coluna) {

        StackPane cell = new StackPane();

        cell.setPrefSize(60, 60);
        cell.setPickOnBounds(true);

        aplicarEstiloCelula(
                cell,
                linha,
                coluna,
                linha == linhaSelecionada && coluna == colunaSelecionada
        );

        if (!casa.estaVazia()) {

            adicionarNumero(cell,casa);
        } else {

            adicionarCandidatos(cell, casa);
        }

        return cell;
    }

    private void aplicarEstiloCelula(
            StackPane cell,
            int linha,
            int coluna,
            boolean selecionada) {

        double top = 1;
        double right = 1;
        double bottom = 1;
        double left = 1;

        String topColor = "#cccccc";
        String rightColor = "#cccccc";
        String bottomColor = "#cccccc";
        String leftColor = "#cccccc";

        if (coluna == 2 || coluna == 5) {
            right = 3;
            rightColor = "#555555";

        }

        if (linha == 2 || linha == 5) {
            bottom = 3;
            bottomColor = "#555555";
        }

        String backgroundColor = selecionada
                ? "#d9eaff":"#ffffff";

        cell.setStyle(
                "-fx-background-color: " +
                        backgroundColor + ";" +
                        "-fx-border-color: " +
                        topColor + " " +
                        rightColor + " " +
                        bottomColor + " " +
                        leftColor + ";" +
                        "-fx-border-width: " +
                        top + "px " +
                        right + "px " +
                        bottom + "px " +
                        left + "px;"
        );
    }

    private void selecionarVisualmente(int linha, int coluna) {

        linhaSelecionada = linha;
        colunaSelecionada = coluna;

        for (var node : board.getChildren()) {

            int nodeColuna = GridPane.getColumnIndex(node);
            int nodeLinha = GridPane.getRowIndex(node);

            aplicarEstiloCelula(
                    (StackPane) node,
                    nodeLinha,
                    nodeColuna,
                    nodeLinha == linhaSelecionada
                    && nodeColuna == colunaSelecionada
            );
        }
    }

    private void adicionarNumero(StackPane cell,
                                 Casa casa) {

        Label numberLabel = new Label(
                String.valueOf(casa.getNumero())
        );

        numberLabel.setStyle(
                "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );

        cell.getChildren().add(numberLabel);
    }

    private void adicionarCandidatos(StackPane cell,
                                     Casa casa) {

        GridPane candidateGrid = new GridPane();

        candidateGrid.setAlignment(Pos.CENTER);

        for (int candidato = 1; candidato <= 9; candidato++) {

            Label candidateLabel = new Label();

            if (casa.possuiCandidato(candidato)) {

                candidateLabel.setText(
                        String.valueOf(candidato)
                );

                candidateLabel.setStyle(
                        "-fx-font-size: 12px;" +
                                "-fx-text-fill: #555555;"
                );
            }

            candidateLabel.setPrefSize(16, 16);
            candidateLabel.setAlignment(Pos.CENTER);

            int indice = candidato - 1;

            int candidateRow = indice / 3;
            int candidateColumn = indice % 3;

            candidateGrid.add(
                    candidateLabel,
                    candidateColumn,
                    candidateRow
            );
        }

        cell.getChildren().add(candidateGrid);
    }

    @Override
    public void exibirStatusPartida(StatusPartida status) {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirErro(String mensagem) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }

    @Override
    public void exibirEncerramento() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirSolicitacaoRemocao() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirSolicitacaoCoordenada() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirSolicitacaoNumero() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirSolicitacaoLimparJogadas() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirSolicitacaoSobrescrita() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirJogadaRemovida() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirJogadasRemovidas() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirPartidaSalva() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirConfirmacaoLimparJogadas() {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirCandidatoAdicionado(int candidato) {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }

    @Override
    public void exibirCandidatoRemovido(int candidato) {
        throw new UnsupportedOperationException(
                "Ainda não implementado na interface JavaFX."
        );
    }
}
