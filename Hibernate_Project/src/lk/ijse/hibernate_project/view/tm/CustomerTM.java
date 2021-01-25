package lk.ijse.hibernate_project.view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String id;
    private String name;
    private String address;
    private Button btn;

    public CustomerTM() {
    }

    public CustomerTM(String id, String name, String address, Button btn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", btn=" + btn +
                '}';
    }
}
