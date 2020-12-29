package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Registr;

    @FXML
    private Button Come;

    @FXML
    private TextField Login_field;

    @FXML
    private PasswordField Password_field;

    @FXML
    void initialize() {

        Come.setOnAction(event -> {
            String login = Login_field.getText().trim();
            String password = Password_field.getText().trim();

            if (!login.equals("") && !password.equals("")){
                loginUSer(login,password);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error ");
                alert.setHeaderText("Login and password is empty ");
                alert.showAndWait();
            }
        });

        Registr.setOnAction(event -> {
                openScene("/sample/fxml/registr.fxml");
        });

    }

    private void loginUSer(String login, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(login);
        user.setPassword(password);
         ResultSet result = dbHandler.getUser(user);

         int counter = 0;

         try {
             while (result.next()){
                 counter++;
             }
         }catch (SQLException e){
             e.printStackTrace();
         }

         if (counter >=1){
             openScene("/sample/fxml/main_game.fxml");
         }
    }

    public void openScene (String window){
        Registr.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(window));/* отображние окна*/
//        loader.setLocation(getClass().getResource(window));

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
    }


