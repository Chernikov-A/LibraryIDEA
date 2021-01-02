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

public class RegistController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button back;

    @FXML
    private Button OkRegistr;

    @FXML
    private TextField Login_registr;

    @FXML
    private TextField Password_registr;

    @FXML
    private TextField Surname_registr;

    @FXML
    private TextField Name_registr;

    @FXML
    void initialize() {
        OkRegistr.setOnAction(event -> {

            String firstName = Surname_registr.getText().trim();
            String lastname = Name_registr.getText().trim();
            String login = Login_registr.getText().trim();
            String password = Password_registr.getText().trim();

            if(!firstName.equals("") && !lastname.equals("") && !login.equals("") && !password.equals("")){
                singUpNewUser();
                registrMain("/sample/fxml/sample.fxml");

            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error ");
                alert.setHeaderText("Заполните пустые поля");
                alert.showAndWait();

            }
        });
        back.setOnAction(event -> {
            Back("/sample/fxml/sample.fxml");
        });

    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = Surname_registr.getText();
        String lastname = Name_registr.getText();
        String login = Login_registr.getText();
        String password = Password_registr.getText();

        User user = new User(login,password,firstName,lastname);
        dbHandler.singUpUser(user);
    }
    private void registrMain(String window){
        OkRegistr.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();/* отображние окна*/
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    };

    private void Back(String bk){
        back.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(bk));

         try {
             loader.load();
         }catch (IOException e){
             e.printStackTrace();
         }
         Parent root = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(root));
         stage.show();
    }

}
