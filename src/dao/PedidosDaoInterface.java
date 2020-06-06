package dao;

import java.util.List;

public interface PedidosDaoInterface < T, K > {
    public T get(K id);
    public void add(T p);
    public void remove(T p);
    public List < T > getAll();
}
