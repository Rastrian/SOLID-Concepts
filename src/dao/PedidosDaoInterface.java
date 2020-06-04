package dao;

import java.util.List;

public interface PedidosDaoInterface < T, K > {
    public T get(K id);
    public boolean add(T p);
    public void remove(T p);
    public List < T > getAll();
}
