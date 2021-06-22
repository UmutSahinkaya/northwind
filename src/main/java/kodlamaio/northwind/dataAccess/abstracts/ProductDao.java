package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
Product getByProductName(String productName);

Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

//select*from products where product_name=productname and categoryId=1
List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);

List<Product> getByCategory_CategoryIdIn(List<Integer> categories);//select* from products where category_id in(1,2,3,4)

List<Product> getByProductNameContains(String productName);//Contains (İçeren)

List<Product> getByProductNameStartsWith(String productName);//ürün isimleri şununla başlayan veya bununla biten
//Aşağıdaki query yazarken veritablosunu unutun Entityler(Product) yazıyormuş gibi  yazılıyor.

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);

    //DTO KISIM KODLARI
    //Select p.product_id,p.product_name,c.category_name from Category c inner join Product p on c.CategoryId=p.categoryId
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto" +
            "(p.id,p.productName,c.categoryName)" +
            " From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
