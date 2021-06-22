package kodlamaio.northwind.businness.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);

    //select*from products where product_name=productname and categoryId=1
    DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);//select* from products where category_id in(1,2,3,4)

    DataResult<List<Product>> getByProductNameContains(String productName);//Contains (İçeren)

    DataResult<List<Product>> getByProductNameStartsWith(String productName);//ürün isimleri şununla başlayan veya bununla biten

    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
