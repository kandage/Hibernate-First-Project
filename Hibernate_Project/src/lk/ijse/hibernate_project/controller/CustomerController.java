package lk.ijse.hibernate_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate_project.bussiness.BOFactory;
import lk.ijse.hibernate_project.bussiness.BOType;
import lk.ijse.hibernate_project.bussiness.SuperBO;
import lk.ijse.hibernate_project.bussiness.custom.CustomerBO;
import lk.ijse.hibernate_project.bussiness.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate_project.dto.CustomerDTO;
import lk.ijse.hibernate_project.view.tm.CustomerTM;

import java.util.List;
import java.util.Optional;

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
    CustomerBO bo;

    public void initialize() throws Exception {
        bo = BOFactory.getInstance().getBO(BOType.CUSTOMER);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        coloperator.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllCustomer();

        tblcustomer.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(CustomerTM tm) {
        txtid.setText(tm.getId());
        txtname.setText(tm.getName());
        txtaddress.setText(tm.getAddress());
    }

    ObservableList<CustomerTM> tmList = FXCollections.observableArrayList();

    private void loadAllCustomer() throws Exception {
        tmList.clear();
        List<CustomerDTO> allCustomers = bo.getAllCustomers();
        for (CustomerDTO customer : allCustomers
        ) {
            Button btn = new Button("Delete");
            CustomerTM tm = new CustomerTM(
                    customer.getId(), customer.getName(), customer.getAddress(), btn
            );
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteCustomer(tm.getId())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllCustomer();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblcustomer.setItems(tmList);
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address);
        try {
            boolean added = bo.addCustomer(customer);
            if (added) {
                new Alert(Alert.AlertType.CONFIRMATION, "ok").showAndWait();
            }
            txtid.clear();
            txtname.clear();
            txtaddress.clear();
            txtid.requestFocus();
            loadAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        try {
            if (bo.updateCustomer(new CustomerDTO(
                    id,
                    name,
                    address
            ))) {
                loadAllCustomer();
                txtid.clear();
                txtname.clear();
                txtaddress.clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }

    public void getDataOnAction(ActionEvent actionEvent) {
    }
}
