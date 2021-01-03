package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameBook;

    @FXML
    private TextField nameAuthor;

    @FXML
    private TextField got;

    @FXML
    private TextField Tematika;

    @FXML
    private TextField kolichestvoBook;

    @FXML
    private TextField Str;

    @FXML
    private Button backBook;

    @FXML
    private Button AddBottonBook;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        AddBottonBook.setOnAction(event -> {

            String name = nameBook.getText();
            String Aurot = nameAuthor.getText();
            String Got = got.getText();
            String Tema = Tematika.getText();
            String kol = kolichestvoBook.getText();
            String stra = Str.getText();

            if (!name.equals("") && !Aurot.equals("") && !Got.equals("") && !Tema.equals("") && !kol.equals("") && !stra.equals("") ){

            dbHandler.singUpBook(nameBook.getText(),nameAuthor.getText(),got.getText(),Tematika.getText(),kolichestvoBook.getText(),Str.getText());
            back("/sample/fxml/main_game.fxml");

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error ");
                alert.setHeaderText("Заполните пустые поля");
                alert.showAndWait();
            }
        });

    backBook.setOnAction(event -> {
        back("/sample/fxml/main_game.fxml");

    });
    }
    private void back (String back){
        backBook.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(back));/* отображние окна*/

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
