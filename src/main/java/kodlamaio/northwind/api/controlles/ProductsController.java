package kodlamaio.northwind.api.controlles;

import kodlamaio.northwind.businness.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Sen bir controller sın.
@RequestMapping("/api/products")//dış dünyadan bir istek gelirse bu controller cevap verecek.
public class ProductsController {//Android/İos/web dış dünyanın sistemle iletişim kurdugu yer Controller

    private ProductService productService;
    @Autowired //Bana productService lazım.benim yerime new leyip oraya bunu yerleştirecek!
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/getall")//kodlama.io da /kodlama.io/api/getall diye istek yaparsa bu çalışacak.
    public DataResult<List<Product>> getAll(){

        return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("getByProductName")//@RequestParam->yapılan isteğin parametrelerine bak productname diye birşey olacak
    // oradan onu oku ve productname i bana gönder
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
    return this.productService.getByProductNameAndCategoryId
            (productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
   public DataResult<List<Product>>
   getByProductNameContains(@RequestParam String productName)//Contains (İçeren)
    {
    return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
      return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails()  {
        return this.productService.getProductWithCategoryDetails();
    }

}
