package diet.calculator.com.example.diet_calculator.module;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/add")
    public String getProductForm(Model model){
        model.addAttribute("new Product", new Product());
        return "product_form";
    }
}
