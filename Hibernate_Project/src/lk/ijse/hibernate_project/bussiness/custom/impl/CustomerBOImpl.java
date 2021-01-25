package lk.ijse.hibernate_project.bussiness.custom.impl;

import lk.ijse.hibernate_project.bussiness.custom.CustomerBO;
import lk.ijse.hibernate_project.dao.DAOFactory;
import lk.ijse.hibernate_project.dao.DAOType;
import lk.ijse.hibernate_project.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate_project.dto.CustomerDTO;
import lk.ijse.hibernate_project.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAOImpl customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.add(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress()
        ));
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> customerList = customerDAO.getall();
        ArrayList<CustomerDTO> dtoList = new ArrayList();
        for (Customer c : customerList) {
            dtoList.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress()));
        }
        return dtoList;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }
}
