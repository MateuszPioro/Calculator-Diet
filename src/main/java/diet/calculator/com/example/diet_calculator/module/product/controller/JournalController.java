package diet.calculator.com.example.diet_calculator.module.product.controller;


import diet.calculator.com.example.diet_calculator.module.product.model.dto.JournalForm;
import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("journal_form",new JournalForm());
        model.addAttribute("availableProducts",list);
        return "journal_list";
    }

    //zrobić wpis do dziennkia, journalService(addproduct to journal)
    @PostMapping("/add")
    public String addNewJournalEntry(JournalForm journalForm){
        System.out.println(journalForm);
        return "redirect:/journal/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "productId") Long productId) {
        journalService.delete(productId);
        return "journal_list";
    }




}
