package shop.services.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.AllArgsConstructor;
import shop.services.staticControl.EntityControl;
import shop.services.staticControl.Jdbc;
import shop.services.staticControl.util;

@AllArgsConstructor
public abstract class AbstractDAO<K, E> {

    private final String select;
    private final String insert;
    private final String udpate;
    private final String delete;
    protected final Map<K, E> map = new HashMap<>();

    protected abstract Object[] toArray(E entity, EntityControl.TYPE_ARR type);

    protected abstract E getEntity(ResultSet rs) throws SQLException;

    protected K getKey(E entity) {
        return ((EntityControl<K>) entity).getKey();
    }

    public E getById(K id) {
        return this.map.get(id);
    }

    /**
     * first get data form database and return map next times
     *
     * @return map data
     */
    public Map<K, E> getMap() {
        if (this.map.isEmpty()) try {
            this.pullList(); // pull data from database
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.map;
    }

    /**
     * @param entity to put in map and insert into database
     * @return E entity insert
     * @throws SQLException
     */
    public E insert(E entity) throws SQLException {
        if (entity == null) {
            return null;
        }
        K key = this.getKey(entity);

        if (this.map.get(key) == null) {
            Object[] objs = this.toArray(entity, EntityControl.TYPE_ARR.INSERT);
            if (Jdbc.execute(insert, objs) > 0) {
                this.map.put(key, entity);
                return entity;
            }
            return null;
        }
        throw this.createException(key, "insert", "already exist !!!");
    }

    /**
     * @param entity to update in map and database
     * @return E entity updated
     * @throws SQLException
     */
    public E update(E entity) throws SQLException {
        if (entity == null) {
            return null;
        }
        K key = this.getKey(entity);

        if (this.map.get(key) != null) {
            Object[] objs = this.toArray(entity, EntityControl.TYPE_ARR.UPDATE);
            if (Jdbc.execute(udpate, objs) > 0) {
                this.map.replace(key, entity);
                return entity;
            }
            return null;
        }
        throw createException(key, "update", "doesn't exist !!!");
    }

    /**
     * @param key for delete data in map and database
     * @return number of result execute
     * @throws SQLException
     */
    public int delete(K key) throws SQLException {
        if (key == null) {
            return 0;
        }
        try {
            int remove = Jdbc.execute(delete, key);
            if (this.map.get(key) != null && remove > 0) {
                this.map.remove(key);
            }
            return remove;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * get all data from database
     *
     * @throws SQLException
     */
    protected void pullList() throws SQLException {
        ResultSet rs = Jdbc.resutlSet(select);
        while (rs.next()) {
            E e = this.getEntity(rs);
            K k = this.getKey(e);
            if (k != null) {
                this.map.put(k, e);
            }
        }
    }

    protected SQLException createException(K key, String type, String... serials) {
        StringBuilder error = new StringBuilder("Cannot ");
        error.append(type).append(" because ");
        error.append('"').append(key).append('"');
        for (String serial : serials) {
            error.append(' ').append(serial);
        }
        return new SQLException(error.toString());
    }

    /**
     * @param base objects data to append value
     * @param value for append data
     * @param last append data to to start or end.
     * @return new Object append base and value
     */
    protected static Object[] agrs(Object[] base, Object value, boolean last) {
        return util.addArr(last, base, value);
    }
}
