package br.edu.ifpb.pps.projeto.renderspring.modurender.core;

public class DataTypeHandler {

    public static String convertToSQLType(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Integer || value instanceof Double || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof java.time.LocalDate) {
            return "'" + value.toString() + "'";
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + value.getClass());
        }
    }
}
