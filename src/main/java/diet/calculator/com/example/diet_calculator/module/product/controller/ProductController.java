package diet.calculator.com.example.diet_calculator.module.product.controller;


import diet.calculator.com.example.diet_calculator.module.product.service.ProductService;
import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add")
    public String getProductForm(Model model) {
        model.addAttribute("new_Product", new ProductDto());
        model.addAttribute("getProducts",productService.getProducts());
        return "product_form";
    }



    @PostMapping("/add")
    public String postListProduct(Model model, ProductDto productDto) {
        log.info("entry in the list: " + productDto);
        productService.saveProductDTO(productDto);
        return "redirect:/product/add";
    }
}
