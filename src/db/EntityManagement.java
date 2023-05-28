package db;

import java.util.List;

/**
 * Interface for managing entities.
 *
 * @param <T> The type of the entity.
 */
public interface EntityManagement<T> {
    /**
     * Adds an entity to the collection.
     *
     * @param entityId The ID of the entity.
     * @param entity   The entity to add.
     */
    void add(String entityId, T entity);

    /**
     * Removes an entity from the collection.
     *
     * @param entityId The ID of the entity to remove.
     */
    void remove(String entityId);

    /**
     * Retrieves an entity from the collection.
     *
     * @param entityId The ID of the entity to retrieve.
     * @return The retrieved entity, or null if not found.
     */
    T get(String entityId);

    /**
     * Retrieves all entities from the collection.
     *
     * @return A list containing all entities.
     */
    List<T> getAll();
}
