package kodlamaio.northwind.api.controlles;

import kodlamaio.northwind.businness.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
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
}
