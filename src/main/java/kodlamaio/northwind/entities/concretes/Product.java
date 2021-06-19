package kodlamaio.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    //@ ile yaptıklarımız anatasyon!
    @Id //id colonu oldugunu belirttik
    @GeneratedValue(strategy =GenerationType.IDENTITY) //id nasıl artsın
    @Column(name="product_id")
    private int id;

    //@Column(name="category_id")
    //private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
