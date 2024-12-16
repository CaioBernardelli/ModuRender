package br.edu.ifpb.pps.projeto.renderspring.modurender.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class RelationshipValidator {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Verifica se uma entidade relacionada existe no banco.
     *
     * @param entityClass Classe da entidade.
     * @param id ID da entidade relacionada.
     * @return true se a entidade existe, false caso contrário.
     */
    public boolean entityExists(Class<?> entityClass, Long id) {
        return id != null && entityManager.find(entityClass, id) != null;
    }

    /**
     * Valida a existência de uma entidade relacionada.
     *
     * @param entityClass Classe da entidade.
     * @param id ID da entidade relacionada.
     * @throws IllegalArgumentException se a entidade não existir.
     */
    public void validateRelationship(Class<?> entityClass, Long id) {
        if (!entityExists(entityClass, id)) {
            throw new IllegalArgumentException("Entidade relacionada não existe: " + entityClass.getSimpleName());
        }
    }
}
