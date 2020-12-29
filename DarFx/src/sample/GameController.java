package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {
    PreparedStatement pst = null;
    private Connection connection;
    private ObservableList<View> Listviews;
    private  DatabaseHandler dbHandler;
    private ObservableList<Viewbooks> Bookview;

    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane ap;

    @FXML
    private Tab Chitateli;

    @FXML
    private TableView<View> db_Chitateli;


    @FXML
    private TableColumn<View, String> nameView;

    @FXML
    private TableColumn<View, String> surnameView;

    @FXML
    private TableColumn<View, String> telefonView;

    @FXML
    private TableColumn<View, String> bookView;

    @FXML
    private TableColumn<View, String> crokiView;

    @FXML
    private Button addChitateliOkno;

    @FXML
    private Button deleteChitateli;

    @FXML
    private Button RefrechChitateli;

    @FXML
    private Tab dbbook;

    @FXML
    private TableView<Viewbooks> db_book;

    @FXML
    private TableColumn<Viewbooks, String> nameBookView;

    @FXML
    private TableColumn<Viewbooks, String> AvtorView;

    @FXML
    private TableColumn<Viewbooks, String> GotView;

    @FXML
    private TableColumn<Viewbooks, String> eczemplyarView;

    @FXML
    private TableColumn<Viewbooks, String> tematikaView;

    @FXML
    private TableColumn<Viewbooks, String> stranictaView;

    @FXML
    private Button addBookOkno;

    @FXML
    private Button DeleteBook;

    @FXML
    private Button RefreshBook;

    @FXML
    private MenuItem close;
    @FXML

    void Close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
    @FXML
    void DeleteChet(ActionEvent event) throws Exception {
        connection = dbHandler.getDbconnection();
        String sql = "delete from library.book where Имя = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nameView.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    @FXML
    void DeleteChitateli(MouseEvent event) {

    }

    @FXML
    void RefreshChitateli(MouseEvent event) {

    }



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {


        dbHandler = new DatabaseHandler();
        ViewChit();
        ViewBook();


        addChitateliOkno.setOnAction(event -> {
            OkAddChitateli("/sample/fxml/addChit.fxml");
        });

        addBookOkno.setOnAction(event -> {
            OkBook("/sample/fxml/addbooks.fxml");
        });


    }

    private void DeleteChit() throws Exception {

//    connection = dbHandler.getDbconnection();
//    String delete = "DELETE FROM library.chitateli WHERE idchitateli = ?";
//    try {
//            pst = connection.prepareStatement(delete);
//            pst.setString(1,nameView.getText());
//            pst.execute();
//        JOptionPane.showMessageDialog(null, "Delete");
//
//    }catch (Exception e){
//        JOptionPane.showMessageDialog(null, e);
//    }
    }
    public void ViewsCh() {
        try {
            ArrayList<View> viewch = new ArrayList<>();
            connection = dbHandler.getDbconnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    private void ViewBook() throws SQLException,ClassNotFoundException{
        try {
            Bookview = FXCollections.observableArrayList();

            String query = "SELECT * FROM library.book ";/*Подключеник к бд book*/

            connection = dbHandler.getDbconnection();
            ResultSet set = connection.createStatement().executeQuery(query);

            while (set.next()){
                Viewbooks vb =new Viewbooks();
                /*Какие поля выводить из бд в tabliview*/
                vb.setNameBookView(set.getString("Название_книги"));
                vb.setAvtorView(set.getString("Автор_книги"));
                vb.setGotView(set.getString("Год_издания"));
                vb.setEczemplyarView(set.getString("Количество_экземпляров"));
                vb.setTematikaView(set.getString("Тематика_книги"));
                vb.setStranictaView(set.getString("Количество_страниц"));
                Bookview.add(vb);
            }
            /*Заполняем столбцы */
            nameBookView.setCellValueFactory(new PropertyValueFactory<>("nameBookView"));
            AvtorView.setCellValueFactory(new PropertyValueFactory<>("AvtorView"));
            GotView.setCellValueFactory(new PropertyValueFactory<>("GotView"));
            eczemplyarView.setCellValueFactory(new PropertyValueFactory<>("eczemplyarView"));
            tematikaView.setCellValueFactory(new PropertyValueFactory<>("tematikaView"));
            stranictaView.setCellValueFactory(new PropertyValueFactory<>("stranictaView"));

            db_book.setItems(Bookview);
        }catch (SQLException e){
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    private void ViewChit() throws SQLException, ClassNotFoundException {
        try {
            Listviews = FXCollections.observableArrayList();

            String query = "SELECT * FROM library.chitateli ";/*Подключеник к бд chitateli*/

            connection =dbHandler.getDbconnection();
            ResultSet set = connection.createStatement().executeQuery(query);

            while (set.next()){
                View view = new View();
                /*Какие поля выводить из бд в tabliview */
                view.setNameView(set.getString("Имя"));
                view.setSurnameView(set.getString("Фамилия"));
                view.setTelefonView(set.getString("Телефон"));
                view.setBookView(set.getString("Книга"));
                view.setCrokiView(set.getString("Сроки"));
                Listviews.add(view);

            }
            /*Заполняем столбцы */
            nameView.setCellValueFactory(new PropertyValueFactory<>("nameView"));
            surnameView.setCellValueFactory(new PropertyValueFactory<>("surnameView"));
            telefonView.setCellValueFactory(new PropertyValueFactory<>("telefonView"));
            bookView.setCellValueFactory(new PropertyValueFactory<>("bookView"));
            crokiView.setCellValueFactory(new PropertyValueFactory<>("crokiView"));

//            Callback<TableColumn<View, String>,TableCell<View, String>> cellFactory =

            db_Chitateli.setItems(Listviews);


        }catch (SQLException e){
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void OkAddChitateli (String chil){
        addChitateliOkno.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(chil));/* отображние окна*/

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

    public void OkBook (String book){
        addBookOkno.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(book));/* отображние окна*/

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

    public void DeleteChitateli(javafx.scene.input.MouseEvent mouseEvent) {

//        try {
//
//            String query ="DELETE FROM chitateli WHERE Имя =" +nameView.getText();
//
//            pst= connection.prepareStatement(query);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Update");
//            ViewChit();
//
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public void RefreshChitateli(javafx.scene.input.MouseEvent mouseEvent) {

//        try {
//            connection = dbHandler.getDbconnection();
//            String name = nameView.getText();
//            String surname = surnameView.getText();
//            String tel = telefonView.getText();
//            String book = bookView.getText();
//            String sr = crokiView.getText();
//            String query = "UPDATE `chitateli` SET `Имя`='"+name+"',`Фамилия`='"+surname+"',`Телефон`='"+tel+"',`Книга`="+book+" WHERE `Сроки` = "+sr;
//
//            pst= connection.prepareStatement(query);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Update");
//            ViewChit();
//
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public void CliclDeleteBook(javafx.scene.input.MouseEvent mouseEvent) {
    }

    public void RefrehrBook(ContextMenuEvent contextMenuEvent) {
    }

    public void DeleteChet(javafx.event.ActionEvent actionEvent) {
    }

    public void Close(javafx.event.ActionEvent actionEvent) {
    }
}
