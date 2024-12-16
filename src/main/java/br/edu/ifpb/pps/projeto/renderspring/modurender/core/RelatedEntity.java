package br.edu.ifpb.pps.projeto.renderspring.modurender.core;


public class RelatedEntity {

    private Class<?> entityClass;
    private Long entityId;

    public RelatedEntity(Class<?> entityClass, Long entityId) {
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Long getEntityId() {
        return entityId;
    }
}
