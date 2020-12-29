package sample;

import java.sql.*;

public class DatabaseHandler extends  Configs {
    public   Connection dbconnection;

    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
        String connectString = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + dbName+"?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbconnection = DriverManager.getConnection(connectString, dbUser, dbPass);

        return dbconnection;
    }
    public ResultSet ViewCh (View view){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.CHITATELI_TABLE + " WHERE " + Const.CHILTATELI_ID + "," + Const.CHILTATELI_NAME + "," + Const.CHILTATELI_SURNAME
                + "," + Const.CHILTATELI_TELEFON + "," + Const.CHILTATELI_KNIGA + " AND " + Const.CHILTATELI_SROKI + " VALUE(?,?,?,?,?,) ";

        try {
            PreparedStatement preparedStatement = getDbconnection().prepareStatement(select);
            preparedStatement.setString(1,view.getNameView());
            preparedStatement.setString(2,view.getSurnameView());
            preparedStatement.setString(3,view.getTelefonView());
            preparedStatement.setString(4,view.getBookView());
            preparedStatement.setString(5,view.getCrokiView());

            resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void singUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME +
                "," + Const.USER_USERNAME + "," + Const.USER_PASSWORD + ")" + "VALUE(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbconnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFerstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void singUpBook (String Название_книги,String Автор_книги,String Год_издания,String Количество_экземпляров,
                            String Тематика_книг,String Количество_страниц){
            String insert = "INSERT INTO " + Const.BOOK_TABLE + "(" + Const.BOOK_NAME + "," + Const.BOOK_AVTOR + "," +
                    Const.BOOK_GOT + "," + Const.BOOK_KOLICH + "," + Const.BOOK_TEMATICA + "," + Const.BOOK_STRANITSA + ")" + "VALUES(?,?,?,?,?,?)";

            try {
                PreparedStatement prSt = getDbconnection().prepareStatement(insert);
                prSt.setString(1, Название_книги);
                prSt.setString(2, Автор_книги);
                prSt.setString(3, Год_издания);
                prSt.setString(4, Количество_экземпляров);
                prSt.setString(5, Тематика_книг);
                prSt.setString(6, Количество_страниц);


                prSt.executeUpdate();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    public void singUpChitatel(String Имя,String Фамилия, String Телефон,String Книга,String Сроки){
            String insert = "INSERT INTO " + Const.CHITATELI_TABLE + "(" + Const.CHILTATELI_NAME + "," + Const.CHILTATELI_SURNAME +
                    "," + Const.CHILTATELI_TELEFON + "," + Const.CHILTATELI_KNIGA + "," + Const.CHILTATELI_SROKI + ")"
                    + "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbconnection().prepareStatement(insert);
            prSt.setString(1, Имя);
            prSt.setString(2, Фамилия);
            prSt.setString(3, Телефон);
            prSt.setString(4, Книга);
            prSt.setString(5, Сроки);

            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUser (User user){
        ResultSet resultSet = null;

        String select = " SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " =? AND " + Const.USER_PASSWORD + " =? ";
        try {
            PreparedStatement preparedStatement = getDbconnection().prepareStatement(select);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void singUpChitatel(View view) {
    }
}
