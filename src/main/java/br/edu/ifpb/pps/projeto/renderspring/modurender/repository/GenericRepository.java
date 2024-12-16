package br.edu.ifpb.pps.projeto.renderspring.modurender.repository;


import br.edu.ifpb.pps.projeto.renderspring.modurender.core.DatabaseManager;
import br.edu.ifpb.pps.projeto.renderspring.modurender.core.RelatedEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class GenericRepository<T extends BaseEntity> {

    private final DatabaseManager databaseManager;

    public GenericRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void save(T entity) {
        try (Connection connection = databaseManager.getConnection()) {
            String sql = "INSERT INTO " + entity.getTableName() + " VALUES (?)"; // Exemplo simplificado
            PreparedStatement statement = connection.prepareStatement(sql);
            // Configurar parâmetros dinamicamente...
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T findById(Long id, Class<T> clazz) {
        try (Connection connection = databaseManager.getConnection()) {
            String sql = "SELECT * FROM " + clazz.getSimpleName() + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                T entity = clazz.getDeclaredConstructor().newInstance();
                entity.setId(resultSet.getLong("id"));
                // Mapear outros campos...
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Long id, String tableName) {
        try (Connection connection = databaseManager.getConnection()) {
            String sql = "DELETE FROM " + tableName + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
