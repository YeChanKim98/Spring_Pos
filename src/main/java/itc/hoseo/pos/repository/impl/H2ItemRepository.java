package itc.hoseo.pos.repository.impl;

import itc.hoseo.pos.domain.Item;
import itc.hoseo.pos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;

@Repository
public class H2ItemRepository implements ItemRepository {
//
//    @PersistentContext
//    DataSource ds;
//    public H2ItemRepository(DataSource ds) {
//        this.ds = ds;
//    }



    String insertQuery = "INSERT INTO item (id, name, price, stockquantity) VALUES (?,?,?,?)";
    String deleteQuery = "delete from item where id = ?";
    String findQuery = "select * from item where name = ?";
    String updateQuery = "update item set stockquantity = ? where id = ?";

    PreparedStatement pstmt = null;
    Connection connection = null;
    ResultSet rs = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }catch(Exception e) {
            System.out.println("Exception[Connection] : " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addItem(Item item) throws SQLException {
        System.out.println("add 실행");
            pstmt = getConnection().prepareStatement(insertQuery);
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setInt(3, item.getPrice());
            pstmt.setInt(4, item.getStockQuantity());
            pstmt.executeUpdate();
            System.out.println("Item 입력 성공");
            return true;
    }

    @Override
    public boolean deleteItem(int id) {
        try {
            pstmt = getConnection().prepareStatement(deleteQuery);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Item( id : "+id+" ) 삭제 성공");
            return true;
        }catch (Exception e){
            System.out.println("Item( id : "+id+" ) 삭제 실패 : "+e);
            return false;
        }
    }

    @Override
    public Item findItem(String name) {
        Item item = new Item();
        try {
            pstmt = getConnection().prepareStatement(findQuery);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                System.out.println("Item( name : "+name+" ) 검색 성공");
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                item.setStockQuantity(rs.getInt("stockQuantity"));
                return item;
            }else{
                System.out.println("Item( name : "+name+" ) 검색 결과 없음");
                return null;
            }
        }catch (Exception e) {
            System.out.println("Item( name : " + name + " ) 검색 실패 : "+e);
            return null;
        }
    }

    @Override
    public void updateStock(Item item){
        try {
            pstmt = getConnection().prepareStatement(updateQuery);
            pstmt.setInt(1, item.getStockQuantity());
            pstmt.setInt(2, item.getId());
            pstmt.executeQuery();
            System.out.println("[id : "+item.getId()+" ] 갱신 완료");
        }catch (Exception e){
            System.out.println("[id : "+item.getId()+" ] 갱신 실패");
        }
    }

}
