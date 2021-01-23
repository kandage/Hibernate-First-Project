package lk.ijse.hibernate_project.bussiness.custom.impl;

import lk.ijse.hibernate_project.bussiness.custom.CustomerBO;
import lk.ijse.hibernate_project.dao.DAOFactory;
import lk.ijse.hibernate_project.dao.DAOType;
import lk.ijse.hibernate_project.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate_project.dto.CustomerDTO;
import lk.ijse.hibernate_project.entity.Customer;

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
}
