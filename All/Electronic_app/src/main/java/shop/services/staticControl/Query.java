package shop.services.staticControl;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Type {

    Integer at;
    final String value;
}

/**
 * cái này chỉ tạo câu truy vấn không có giá trị nên không cho hack nhé =_)
 */
public interface Query {

    public static String concat(String... queries) {
        StringBuilder sql = new StringBuilder();
        for (String query : queries) {
            sql.append(query).append(' ');
        }
        return sql.toString();
    }

    public static String conditions(String condition, String... fields) {
        StringBuilder sql = new StringBuilder().append('(');
        for (String field : fields) {
            sql.append(field.contains(":") ? field.split(":")[0] : field);
            sql.append(" = ?").append(condition);
        }
        int last = sql.lastIndexOf(condition);
        sql.replace(last, last + 3, ")");
        return sql.toString();
    }

    public static String select(String table, String... fields) {
        return Query.select(table, null, fields);
    }

    public static String select(String table, Integer top, String... fields) {
        StringBuilder sql = new StringBuilder("SELECT");
        if (top != null) {
            sql.append(" TOP ").append(top);
        }
        if (fields.length > 0) {
            for (String field : fields) {
                sql.append(' ').append(field.contains(":") ? field.split(":")[0] : field).append(',');
            }
            sql.setCharAt(sql.lastIndexOf(","), ' ');
        } else {
            sql.append(" * ");
        }

        sql.append("FROM ").append(table);
        return sql.toString();
    }

    public static String insert(String table, Integer size, String... fields) {
        List<Type> array = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(table);
        int len = fields.length, last;

        if (len > 0) {
            size = len;
        }
        if (len > 0) {
            sql.append("(");
            for (int i = 0; i < fields.length; i++) {
                String field = fields[i];
                if (field.contains(":")) {
                    String[] types = field.split(":");
                    array.add(new Type(i, types[1]));
                    field = types[0];
                }
                sql.append(field).append(',');
            }
            last = sql.lastIndexOf(",");
            sql.replace(last, ++last, ")");
        }

        sql.append(" VALUES (");
        if (array.isEmpty()) {
            for (int i = 0; i < size; i++) {
                sql.append("?,");
            }
        } else {
            Type type = array.get(0);
            for (int i = 0, j = 0; i < size; i++) {
                if (type.at == i) {
                    sql.append(type.value).append(",");
                    if (++j < array.size()) {
                        type = array.get(j);
                    } else {
                        type.at = -1;
                    }
                } else {
                    sql.append("?,");
                }
            }
        }
        last = sql.lastIndexOf(",");
        sql.replace(last, ++last, ")");
        return sql.toString();
    }

    public static String insert(String table, String... fields) {
        if (fields.length < 1) {
            return null;
        }
        return Query.insert(table, fields.length, fields);
    }

    public static String update(String table, String primary, String... fields) {
        if (fields.length < 1) {
            return null;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(table).append(" SET ");
        for (String field : fields) {
            if (field.contains(":")) {
                sql.append(field.replace(':', '=')).append(',');
            } else {
                sql.append(field).append("=").append("?,");
            }
        }
        int last = sql.lastIndexOf(",");
        sql.replace(last, ++last, " WHERE ");
        sql.append(primary).append("=").append("?");

        return sql.toString();
    }

    public static String delete(String table, String... deleteBy) {
        if (deleteBy.length < 1) {
            return null;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE ").append(table);
        sql.append(" WHERE ").append(conditions(" OR ", deleteBy));
        return sql.toString();
    }
}
