package ui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.JogoSudoku;


public class SudokuApplication extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #0b0e17;");

        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        
        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);

        Label title = new Label("Sudoku");
        title.setStyle("-fx-font-size: 32px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #c0c0c0;");

        TextField numberInput = new TextField();

        numberInput.setPromptText("Digite um número");
        numberInput.setMaxWidth(150);

        StackPane boardContainer = new StackPane();
        boardContainer.setPadding(new Insets(10));
        boardContainer.setStyle(
                "-fx-background-color: #222222;" +
                        "-fx-background-radius: 8px;"
        );
        boardContainer.getChildren().add(board);

        root.setCenter(content);

        JavaFXPrinter printer = new JavaFXPrinter(board);

        JogoSudoku jogo = new JogoSudoku(
                null,
                printer
        );

        printer.exibirTabuleiro(jogo.getTabuleiro());

        JavaFXController controller = new JavaFXController(jogo);

        printer.configurarClique(controller::selecionarCasa);

        numberInput.setOnAction(event -> {

            String valor = numberInput.getText();

            int numero = Integer.parseInt(valor);

            controller.informarNumero(numero);

            numberInput.clear();
        });

        Button removeButton = new Button("Remover");

        removeButton.setOnAction(event -> {
            controller.removerJogada();
        });

        content.getChildren().addAll(
                title,
                boardContainer,
                numberInput,
                removeButton
        );

        Scene scene = new Scene(root, 600, 700);

        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
