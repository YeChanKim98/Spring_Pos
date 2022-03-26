package itc.hoseo.pos.repository;

import itc.hoseo.pos.domain.Item;

import java.sql.SQLException;

public interface ItemRepository {
    boolean addItem(Item item) throws SQLException;
    boolean deleteItem(int id);
    Item findItem(String name);
    void updateStock(Item item);

}
