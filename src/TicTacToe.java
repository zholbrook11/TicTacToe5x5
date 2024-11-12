import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private String currentPlayer = "X";  // start with X

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("TicTacToe");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;");

        // create the main game grid
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Button[][] buttons = new Button[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(100, 100);
                buttons[i][j].setStyle("-fx-font-size: 24px;");
                buttons[i][j].setOnAction(e -> handleClick((Button) e.getSource()));
                grid.add(buttons[i][j], j, i);
            }
        }

        Button clearButton = new Button("Clear Board");
        clearButton.setStyle("-fx-font-size: 18px;");
        clearButton.setOnAction(e -> clearBoard(buttons));

        grid.add(clearButton, 0, 5, 5, 1);

        VBox layout = new VBox(20, titleLabel, grid);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 600, 700);
        primaryStage.setTitle("5x5 Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // handle a player move
    private void handleClick(Button button) {
        if (button.getText().isEmpty()) {
            button.setText(currentPlayer);

            if (currentPlayer.equals("X")) {
                button.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");
                currentPlayer = "O";
            } else {
                button.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
                currentPlayer = "X";
            }
        }
    }

    private void clearBoard(Button[][] buttons) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setStyle("-fx-font-size: 24px;");
            }
        }
        currentPlayer = "X";
    }

    public static void main(String[] args) {
        launch(args);
    }
}