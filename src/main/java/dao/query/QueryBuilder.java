package dao.query;

import java.util.Arrays;

public class QueryBuilder {
    private StringBuilder stringBuilder = new StringBuilder();

    public QueryBuilder() {
    }

    public QueryBuilder select() {
        stringBuilder.append("SELECT");
        return this;
    }

    public QueryBuilder insert() {
        stringBuilder.append("INSERT");
        return this;
    }

    public QueryBuilder delete() {
        stringBuilder.append("DELETE");
        return this;
    }

    public QueryBuilder selectAll() {
        stringBuilder.append("SELECT *");
        return this;
    }

    public QueryBuilder from(String table) {
        stringBuilder.append("FROM ")
                .append(table);
        return this;
    }

    public QueryBuilder where(String... condition) {
        stringBuilder.append("WHERE ");
        Arrays.stream(condition)
                .forEach(elem -> stringBuilder.append(elem));
        return this;
    }

    public String toQuery() {
        return stringBuilder.toString();
    }


}
