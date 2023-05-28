package db;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;
import java.util.List;

/**
 * SymbolTable implementation of EntityManagement using ST from the algs4 package.
 *
 * @param <T> The type of the entity.
 */
public class SymbolTable<T> implements EntityManagement<T> {
    private ST<String, T> symbolTable;

    /**
     * Constructs a new SymbolTable object.
     */
    public SymbolTable() {
        symbolTable = new ST<>();
    }

    /**
     * Adds an entity to the symbol table.
     *
     * @param entityId The ID of the entity.
     * @param entity   The entity to add.
     */
    @Override
    public void add(String entityId, T entity) {
        symbolTable.put(entityId, entity);
    }

    /**
     * Removes an entity from the symbol table.
     *
     * @param entityId The ID of the entity to remove.
     */
    @Override
    public void remove(String entityId) {
        symbolTable.delete(entityId);
    }

    /**
     * Retrieves an entity from the symbol table.
     *
     * @param entityId The ID of the entity to retrieve.
     * @return The retrieved entity, or null if not found.
     */
    @Override
    public T get(String entityId) {
        return symbolTable.get(entityId);
    }

    /**
     * Retrieves all entities from the symbol table.
     *
     * @return A list containing all entities.
     */
    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();

        for (String key : symbolTable.keys()) {
            result.add(symbolTable.get(key));
        }

        return result;
    }
}
