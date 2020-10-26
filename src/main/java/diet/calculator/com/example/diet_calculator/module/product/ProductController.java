package diet.calculator.com.example.diet_calculator.module.product;


 import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add")
    public String getProductForm(Model model){
        model.addAttribute("new Product", new ProductEntity());
        return "product_form";
    }

    @GetMapping("list")
    public String list(Model model){
        List<ProductEntity> productEntityList = productService.findAllProduct();
        model.addAttribute("products",productEntityList);
        return "redirect:/product_list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "productId") Long productId){
        productService.delete(productId);
        return "redirect:product_list";
    }

}
