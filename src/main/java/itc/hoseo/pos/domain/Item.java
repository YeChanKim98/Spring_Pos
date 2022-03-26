package itc.hoseo.pos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private String name;
    private int price;
    private int stockQuantity;

    public void addStock(int stock){
        System.out.println(name+" 입고 : "+stock);
        this.stockQuantity+=stock;
    }

    public void removeStock(int stock){
        System.out.println(name+" 출고 : "+stock);
        this.stockQuantity-=stock;
    }
}
