package dao;

import java.util.ArrayList;

public interface Dao < T, K > {
    public T get(K id);
    public void add(T p);
    public void update(T p);
    public void remove(T p);
    public ArrayList < T > getAll();
}
