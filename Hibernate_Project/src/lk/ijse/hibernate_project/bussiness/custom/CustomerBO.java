package lk.ijse.hibernate_project.bussiness.custom;

import lk.ijse.hibernate_project.bussiness.SuperBO;
import lk.ijse.hibernate_project.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public CustomerDTO getCustomer(String id)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
}
