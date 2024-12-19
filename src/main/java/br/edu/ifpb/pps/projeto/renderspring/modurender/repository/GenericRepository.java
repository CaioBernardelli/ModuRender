package br.edu.ifpb.pps.projeto.renderspring.modurender.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GenericRepository<T extends BaseEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    // Construtor com tipo da entidade
    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Salva ou atualiza a entidade no banco.
     */
    public T save(T entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        return entity;
    }

    /**
     * Busca uma entidade pelo ID.
     */
    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    /**
     * Remove uma entidade pelo ID.
     */
    public void delete(Long id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    /**
     * Lista todas as entidades.
     */
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        query.select(query.from(entityClass));
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Busca com filtros dinâmicos.
     * @param filters Lista de filtros (ex.: "nome = John").
     */
    public List<T> findWithFilters(List<Predicate> filters) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);

        // Aplica os filtros dinamicamente
        if (!filters.isEmpty()) {
            query.where(builder.and(filters.toArray(new Predicate[0])));
        }

        return entityManager.createQuery(query).getResultList();
    }
}
