package lk.ijse.hibernate_project.bussiness.custom;

import lk.ijse.hibernate_project.bussiness.SuperBO;
import lk.ijse.hibernate_project.dto.CustomerDTO;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
}
