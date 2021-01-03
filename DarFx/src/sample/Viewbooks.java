package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Viewbooks {
    private final StringProperty nameBookView = new SimpleStringProperty();
    private final StringProperty AvtorView = new SimpleStringProperty();
    private final StringProperty GotView = new SimpleStringProperty();
    private final StringProperty eczemplyarView = new SimpleStringProperty();
    private final StringProperty tematikaView = new SimpleStringProperty();
    private final StringProperty stranictaView = new SimpleStringProperty();

    public Viewbooks() {
    }

    public String getNameBookView() {
        return nameBookView.get();
    }

    public StringProperty nameBookViewProperty() {
        return nameBookView;
    }

    public void setNameBookView(String nameBookView) {
        this.nameBookView.set(nameBookView);
    }

    public String getAvtorView() {
        return AvtorView.get();
    }

    public StringProperty avtorViewProperty() {
        return AvtorView;
    }

    public void setAvtorView(String avtorView) {
        this.AvtorView.set(avtorView);
    }

    public String getGotView() {
        return GotView.get();
    }

    public StringProperty gotViewProperty() {
        return GotView;
    }

    public void setGotView(String gotView) {
        this.GotView.set(gotView);
    }

    public String getEczemplyarView() {
        return eczemplyarView.get();
    }

    public StringProperty eczemplyarViewProperty() {
        return eczemplyarView;
    }

    public void setEczemplyarView(String eczemplyarView) {
        this.eczemplyarView.set(eczemplyarView);
    }

    public String getTematikaView() {
        return tematikaView.get();
    }

    public StringProperty tematikaViewProperty() {
        return tematikaView;
    }

    public void setTematikaView(String tematikaView) {
        this.tematikaView.set(tematikaView);
    }

    public String getStranictaView() {
        return stranictaView.get();
    }

    public StringProperty stranictaViewProperty() {
        return stranictaView;
    }

    public void setStranictaView(String stranictaView) {
        this.stranictaView.set(stranictaView);
    }
}
