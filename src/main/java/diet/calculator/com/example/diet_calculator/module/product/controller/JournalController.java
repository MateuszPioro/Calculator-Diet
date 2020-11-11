package diet.calculator.com.example.diet_calculator.module.product.controller;


import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;


    @GetMapping("/list")
    public String list(Model model){
        List<ProductDto> list = journalService.findAllListProducts();
        model.addAttribute("journalList",list);
        return "journal_list";
    }

    //dto,entity,repo,-> journal, journalEntry
    //1step formulrzad oddanie danego wpisu\ do dziennika(dodanie prod.)

}
