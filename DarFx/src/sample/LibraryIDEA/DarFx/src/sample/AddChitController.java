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

public class AddChitController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameChitateli;

    @FXML
    private TextField surnameChitateli;

    @FXML
    private TextField telefon;

    @FXML
    private TextField bookChitateli;

    @FXML
    private TextField Data;

    @FXML
    private Button AddButtonChitateli;

    @FXML
    private Button backChitateli;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        AddButtonChitateli.setOnAction(event -> {
            String name =nameChitateli.getText();
            String surname = surnameChitateli.getText();
            String tel = telefon.getText();
            String bool = backChitateli.getText();
            String dat = Data.getText();

            if (!name.equals("") && !surname.equals("") && !tel.equals("") && !bool.equals("") && !dat.equals("") ) {

                dbHandler.singUpChitatel(nameChitateli.getText(), surnameChitateli.getText(), telefon.getText(), bookChitateli.getText(), Data.getText());
                back("/sample/fxml/main_game.fxml");

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error ");
                alert.setHeaderText("Заполните пустые поля");
                alert.showAndWait();
            }
        });
        backChitateli.setOnAction(event -> {
            back("/sample/fxml/main_game.fxml");
        });
    }
    public void back (String back){
        backChitateli.getScene().getWindow().hide();

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
