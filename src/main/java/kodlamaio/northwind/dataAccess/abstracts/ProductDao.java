package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
Product getByProductName(String productName);

Product getByProductNameAndCategoryId(String productName,int categoryId);

//select*from products where product_name=productname and categoryId=1
List<Product> getByProductNameOrCategoryId(String productName,int categoryId);

List<Product> getByCategoryIdIn(List<Integer> categories);//select* from products where category_id in(1,2,3,4)

List<Product> getByProductNameContains(String productName);//Contains (İçeren)

List<Product> getByProductNameStartsWith(String productName);//ürün isimleri şununla başlayan veya bununla biten
//Aşağıdaki query yazarken veritablosunu unutun Entityler(Product) yazıyormuş gibi  yazılıyor.
    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);
}
