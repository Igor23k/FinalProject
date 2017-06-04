package by.hotel.bean;

import by.hotel.builder.RoleBuilder;

/**
 * Role.java
 * The class store objects with properties
 * @author Igor Kozlov
 * @version 1.0
 */
public class Role {
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

    /**
     * Create new empty object
     */
    public Role() {
    }

    /** Create new object
     @param roleBuilder - builder role
     */
    public Role(RoleBuilder roleBuilder){
        this.id = roleBuilder.getId();
        this.nameRole = roleBuilder.getNameRole();
        this.update = roleBuilder.getUpdate();
        this.delete = roleBuilder.getDelete();
        this.insert = roleBuilder.getInsert();
        this.create = roleBuilder.getCreate();
        this.select = roleBuilder.getSelect();
        this.drop = roleBuilder.getDrop();
        this.grant = roleBuilder.getGrant();
    }

    /**
     * Function for get value {@link Role#id}
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Function for set value of id {@link Role#id}
     * @param id - the id to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function for get value {@link Role#nameRole}
     * @return value of nameRole
     */
    public String getNameRole() {
        return nameRole;
    }

    /**
     * Function for set value of room {@link Role#nameRole}
     * @param nameRole - the nameRole to be set.
     */
    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    /**
     * Function for get value {@link Role#update}
     * @return value of update
     */
    public byte getUpdate() {
        return update;
    }

    /**
     * Function for set value of room {@link Role#update}
     * @param update - the update to be set.
     */
    public void setUpdate(byte update) {
        this.update = update;
    }

    /**
     * Function for get value {@link Role#delete}
     * @return value of delete
     */
    public byte getDelete() {
        return delete;
    }

    /**
     * Function for set value of delete {@link Role#delete}
     * @param delete - the delete to be set.
     */
    public void setDelete(byte delete) {
        this.delete = delete;
    }

    /**
     * Function for get value {@link Role#insert}
     * @return value of insert
     */
    public byte getInsert() {
        return insert;
    }
    /**
     * Function for set value of insert {@link Role#insert}
     * @param insert - the insert to be set.
     */
    public void setInsert(byte insert) {
        this.insert = insert;
    }

    /**
     * Function for get value {@link Role#create}
     * @return value of create
     */
    public byte getCreate() {
        return create;
    }

    /**
     * Function for set value of create {@link Role#create}
     * @param create - the create to be set.
     */
    public void setCreate(byte create) {
        this.create = create;
    }

    /**
     * Function for get value {@link Role#select}
     * @return value of select
     */
    public byte getSelect() {
        return select;
    }

    /**
     * Function for set value of select {@link Role#select}
     * @param select - the select to be set.
     */
    public void setSelect(byte select) {
        this.select = select;
    }

    /**
     * Function for get value {@link Role#drop}
     * @return value of drop
     */
    public byte getDrop() {
        return drop;
    }

    /**
     * Function for set value of drop {@link Role#drop}
     * @param drop - the drop to be set.
     */
    public void setDrop(byte drop) {
        this.drop = drop;
    }

    /**
     * Function for get value {@link Role#grant}
     * @return value of grant
     */
    public byte getGrant() {
        return grant;
    }

    /**
     * Function for set value of grant {@link Role#grant}
     * @param grant - the grant to be set.
     */
    public void setGrant(byte grant) {
        this.grant = grant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        if (update != role.update) return false;
        if (delete != role.delete) return false;
        if (insert != role.insert) return false;
        if (create != role.create) return false;
        if (select != role.select) return false;
        if (drop != role.drop) return false;
        if (grant != role.grant) return false;
        return nameRole.equals(role.nameRole);
    }

    @Override
    public int hashCode() {
        int result = nameRole.hashCode();
        result = 31 * result + (int) update;
        result = 31 * result + (int) delete;
        result = 31 * result + (int) insert;
        result = 31 * result + (int) create;
        result = 31 * result + (int) select;
        result = 31 * result + (int) drop;
        result = 31 * result + (int) grant;
        return result;
    }
}
