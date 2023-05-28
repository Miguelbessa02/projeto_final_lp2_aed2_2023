package db;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.List;

/**

 Implementação genérica de EntityManagement utilizando RedBlackBST como a estrutura de dados subjacente.

 @param <T> O tipo da entidade.
 */
public class GenericBST<T> implements EntityManagement<T> {
    private RedBlackBST<String, T> symbolTable;

    /**

     Constrói um novo objeto GenericBST.
     */
    public GenericBST() {
        symbolTable = new RedBlackBST<>();
    }
    /**

     Adiciona uma entidade à tabela de símbolos.
     @param entityId A ID da entidade.
     @param entity A entidade a ser adicionada.
     */
    @Override
    public void add(String entityId, T entity) {
        symbolTable.put(entityId, entity);
    }
    /**

     Remove uma entidade da tabela de símbolos.
     @param entityId A ID da entidade a ser removida.
     */
    @Override
    public void remove(String entityId) {
        symbolTable.delete(entityId);
    }
    /**

     Recupera uma entidade da tabela de símbolos.
     @param entityId A ID da entidade a ser recuperada.
     @return A entidade recuperada ou null se não encontrada.
     */
    @Override
    public T get(String entityId) {
        return symbolTable.get(entityId);
    }
    /**

     Recupera todas as entidades da tabela de símbolos.

     @return Uma lista contendo todas as entidades.
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