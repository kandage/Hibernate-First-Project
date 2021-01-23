package lk.ijse.hibernate_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.hibernate_project.bussiness.BOFactory;
import lk.ijse.hibernate_project.bussiness.BOType;
import lk.ijse.hibernate_project.bussiness.SuperBO;
import lk.ijse.hibernate_project.bussiness.custom.CustomerBO;
import lk.ijse.hibernate_project.bussiness.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate_project.dto.CustomerDTO;
import lk.ijse.hibernate_project.view.tm.CustomerTM;

public class CustomerController {
    public JFXTextField txtid;
    public JFXTextField txtname;
    public JFXTextField txtaddress;
    public JFXButton btnsave;
    public JFXButton btnupdate;
    public TableView<CustomerTM> tblcustomer;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn coladdress;
    public TableColumn coloperator;
    private CustomerBO bo;

    public void initialize() throws Exception {

    }

    CustomerBOImpl customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);

    public void saveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address);
        try {
            boolean added = customerBO.addCustomer(customer);
            if (added) {
                new Alert(Alert.AlertType.CONFIRMATION, "ok").showAndWait();
            }
            txtname.clear();
            txtaddress.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void getDataOnAction(ActionEvent actionEvent) {
    }
}
