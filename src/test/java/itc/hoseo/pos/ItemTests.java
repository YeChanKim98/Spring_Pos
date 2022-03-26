package itc.hoseo.pos;

import itc.hoseo.pos.domain.Item;
import itc.hoseo.pos.repository.ItemRepository;
import itc.hoseo.pos.repository.impl.H2ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;

@SpringBootTest
@Transactional
class ItemTests {

	@Autowired
	ItemRepository h2Repository = new H2ItemRepository();

	@Test
	@DisplayName("저장 테스트")
	void saveItem() throws SQLException {
		Item item = new Item(001,"Book",15000,10);
		boolean addRes = h2Repository.addItem(item);
		System.out.println(item.getId()+" 저장 결과 : "+addRes);
	}

	@Test
	@DisplayName("검색 테스트")
	void findItem() {
		Item getRes = null;
		getRes = h2Repository.findItem("Book");
		System.out.println("[검색 결과] ID : "+getRes.getId()+" / "+getRes.getName()+" / "+getRes.getPrice()+" / "+getRes.getStockQuantity());
	}

	@Test
	@DisplayName("갱신 테스트")
	void updateItem() {
		Item item = h2Repository.findItem("Book");
		item.addStock(10);
		item.removeStock(5);
		h2Repository.updateStock(item);
		item = h2Repository.findItem("Book");
		System.out.println("결과 : "+item.getStockQuantity());
	}

	@Test
	@DisplayName("삭제 테스트")
	void deleteItem() {
		boolean removeRes = h2Repository.deleteItem(001);
		System.out.println("001 삭제 결과 : "+removeRes);
	}

}
