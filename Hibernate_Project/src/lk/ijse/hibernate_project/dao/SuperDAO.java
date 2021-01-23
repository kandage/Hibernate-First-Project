package lk.ijse.hibernate_project.dao;

import lk.ijse.hibernate_project.entity.Customer;
import lk.ijse.hibernate_project.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable> {
    public boolean add(Entity entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(Entity entity) throws Exception;

    public Entity get(ID id) throws Exception;

    public List<Entity> getall() throws Exception;
}
