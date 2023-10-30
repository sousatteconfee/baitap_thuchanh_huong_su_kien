package shop.services.sql;

import shop.services.staticControl.Query;

public interface ActiveDAO<K> {

    /**
     * @param table for update
     * @param key to set condition
     * @param size to create parameters
     * @return the query update set access
     */
    static String createActiveQuery(String table, String key, int size) {
        StringBuilder temps = new StringBuilder("(");
        for (int i = 0; i < size; i++) {
            temps.append("?,");
        }
        int start = temps.lastIndexOf(",");
        temps.replace(start, ++start, ")");

        return Query.concat(
                "UPDATE", table, "SET active=? WHERE",
                key, "IN", temps.toString()
        );
    }

    boolean setActive(int active, K... prids);
}
