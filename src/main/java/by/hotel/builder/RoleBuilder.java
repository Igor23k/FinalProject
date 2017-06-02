package by.hotel.builder;

import by.hotel.bean.Role;

/**
 * RoleBuilder.java
 * The class store objects with properties and methods.
 * This class is a template Builder.
 * <b> id </ b>, <b> update </ b>, <b> delete </ b>, <b> nameRole </ b>,
 * <b> insert </ b>, <b> create </ b>, <b> select </ b>, <b> drop </ b>,
 * and <b> grant </ b>.
 * @autor Igor Kozlov
 * @version 1.0
 */
public class RoleBuilder {
    /**
     * Property - id
     */
    private int id;
    /**
     * Property - nameRole
     */
    private String nameRole;
    /**
     * Property - update
     */
    private byte update;
    /**
     * Property - delete
     */
    private byte delete;
    /**
     * Property - insert
     */
    private byte insert;
    /**
     * Property - create
     */
    private byte create;
    /**
     * Property - select
     */
    private byte select;
    /**
     * Property - drop
     */
    private byte drop;
    /**
     * Property - grant
     */
    private byte grant;

    /**  Function for set value {@link ReservationBuilder#id}
     *@param id - the id to be set.
     *@return object of class ReservationBuilder
     */
    public RoleBuilder id(int id) {
        this.id = id;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#nameRole}
     *@param nameRole - the nameRole to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder nameRole(String nameRole) {
        this.nameRole = nameRole;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#update}
     *@param update - the id to be update.
     *@return object of class RoleBuilder
     */
    public RoleBuilder update(byte update) {
        this.update = update;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#delete}
     *@param delete - the delete to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder delete(byte delete) {
        this.delete = delete;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#insert}
     *@param insert - the id to be insert.
     *@return object of class RoleBuilder
     */
    public RoleBuilder insert(byte insert) {
        this.insert = insert;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#create}
     *@param create - the create to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder create(byte create) {
        this.create = create;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#select}
     *@param select - the select to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder select(byte select) {
        this.select = select;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#drop}
     *@param drop - the drop to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder drop(byte drop) {
        this.drop = drop;
        return this;
    }

    /**  Function for set value {@link RoleBuilder#grant}
     *@param grant - the grant to be set.
     *@return object of class RoleBuilder
     */
    public RoleBuilder grant(byte grant) {
        this.grant = grant;
        return this;
    }

    /**
     * Function for get value {@link RoleBuilder#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for get value {@link RoleBuilder#nameRole}
     * @return value of nameRole
     */
    public String getNameRole() {
        return nameRole;
    }

    /**
     * Function for get value {@link RoleBuilder#update}
     * @return value of update
     */
    public byte getUpdate() {
        return update;
    }

    /**
     * Function for get value {@link RoleBuilder#delete}
     * @return value of delete
     */
    public byte getDelete() {
        return delete;
    }

    /**
     * Function for get value {@link RoleBuilder#insert}
     * @return value of insert
     */
    public byte getInsert() {
        return insert;
    }
    /**
     * Function for get value {@link RoleBuilder#create}
     * @return value of create
     */
    public byte getCreate() {
        return create;
    }

    /**
     * Function for get value {@link RoleBuilder#select}
     * @return value of select
     */
    public byte getSelect() {
        return select;
    }

    /**
     * Function for get value {@link RoleBuilder#drop}
     * @return value of drop
     */
    public byte getDrop() {
        return drop;
    }

    /**
     * Function for get value {@link RoleBuilder#grant}
     * @return value of grant
     */
    public byte getGrant() {
        return grant;
    }

    /**  Function for build role
     *@return object of class Role
     */
    public Role build() {
        return new Role(this);
    }
}
