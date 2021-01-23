package lk.ijse.hibernate_project.dao;

import lk.ijse.hibernate_project.dao.custom.impl.CustomerDAO;
import lk.ijse.hibernate_project.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate_project.entity.Customer;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;

    }

    public <T extends SuperDAO> T getDAO(DAOType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            default:
                return null;
        }
    }
}
