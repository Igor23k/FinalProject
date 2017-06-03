package by.hotel.service.impl;

import by.hotel.bean.Role;
import by.hotel.builder.RoleBuilder;
import by.hotel.dao.IRoleDao;
import by.hotel.dao.impl.RoleDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorRole;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * RoleDaoImpl.java
 * Class implements methods from interface ICrudServiceExtended and extends from AbstractService class.
 * getRoleHeaders - method to get role headers.
 * getRoles - method to get role.
 * updateRole - method to update role.
 * addRole - method to add role.
 * removeRole - method to remove role.
 * getLastInsertedRole - method to get last inserted role.
 * buildRole - method to build role.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoleServiceImpl extends AbstractService implements ICrudServiceExtended<Role> {
    /**
     * Field - roleDao
     */
    private IRoleDao roleDao = new RoleDaoImpl();

    /**
     * Get role headers.
     * @return the list of role headers.
     * @throws ServiceException  if get role headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        try{
            return roleDao.getRoleHeaders();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Get roles.
     * @return the list of roles.
     * @throws ServiceException if get roles is failed
     */
    public List<Role> getAllEntities() throws ServiceException {
        try {
            return roleDao.getRoles();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Add role.
     * @param role the operand to have as a role.
     * @throws ServiceException if add role is failed
     */
    public List<Role> addEntity(Role role) throws ServiceException {
        List<Role> roles;
        try {
            roleDao.addRole(role);
            roles = roleDao.getRoles();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return roles;
    }

    /**
     * Remove role.
     * @param role the operand to have as a role.
     * @throws ServiceException if remove role is failed
     */
    public void removeEntity(Role role) throws ServiceException {
        try {
            roleDao.removeRole(role);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Update role.
     * @param role the operand to have as a role.
     * @throws ServiceException if update role is failed
     */
    public void updateEntity(Role role) throws ServiceException {
        try {
            roleDao.updateRole(role);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build role.
     * @return a role.
     * @throws ServiceException if build role is failed
     */
    public Role buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRole validatorRole = new ValidatorRole();
        try {
            if (validatorRole.validate(params)) {
                return new RoleBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .nameRole(params.get("nameRole")[0])
                        .update(Byte.parseByte(params.get("update")[0]))
                        .delete(Byte.parseByte(params.get("delete")[0]))
                        .insert(Byte.parseByte(params.get("insert")[0]))
                        .create(Byte.parseByte(params.get("create")[0]))
                        .select(Byte.parseByte(params.get("select")[0]))
                        .drop(Byte.parseByte(params.get("drop")[0]))
                        .grant(Byte.parseByte(params.get("grant")[0]))
                        .build();
            }
        }catch (IncorrectNameRoleException | IncorrectRightRoleException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted discount.
     * @throws ServiceException if get last inserted role is failed
     */
    public Role getLastInsertedEntity() throws ServiceException {
        try {
            return roleDao.getLastInsertedRole();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }


}