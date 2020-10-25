package diet.calculator.com.example.diet_calculator.module;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/add")
    public String getProductForm(Model model){
        model.addAttribute("new Product", new Product());
        return "product_form";
    }


}
