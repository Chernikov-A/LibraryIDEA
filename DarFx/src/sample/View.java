package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableColumn;

public class View {
    private final IntegerProperty idChitateli = new SimpleIntegerProperty();
    private final StringProperty nameView = new SimpleStringProperty();
    private final StringProperty surnameView = new SimpleStringProperty();
    private final StringProperty telefonView = new SimpleStringProperty();
    private final StringProperty bookView = new SimpleStringProperty();
    private final StringProperty crokiView = new SimpleStringProperty();


    public View() {
    }

    public View(int id, TableColumn<View, String> nameView, TableColumn<View, String> surnameView, TableColumn<View, String> telefonView, TableColumn<View, String> bookView, TableColumn<View, String> crokiView) {

    }

    public String getNameView() {
        return nameView.get();
    }

    public StringProperty nameViewProperty() {
        return nameView;
    }

    public void setNameView(String nameView) {
        this.nameView.set(nameView);
    }

    public String getSurnameView() {
        return surnameView.get();
    }

    public StringProperty surnameViewProperty() {
        return surnameView;
    }

    public void setSurnameView(String surnameView) {
        this.surnameView.set(surnameView);
    }

    public String getTelefonView() {
        return telefonView.get();
    }

    public StringProperty telefonViewProperty() {
        return telefonView;
    }

    public void setTelefonView(String telefonView) {
        this.telefonView.set(telefonView);
    }

    public String getBookView() {
        return bookView.get();
    }

    public StringProperty bookViewProperty() {
        return bookView;
    }

    public void setBookView(String bookView) {
        this.bookView.set(bookView);
    }

    public String getCrokiView() {
        return crokiView.get();
    }

    public StringProperty crokiViewProperty() {
        return crokiView;
    }

    public void setCrokiView(String crokiView) {
        this.crokiView.set(crokiView);
    }
}
