
package com.example.issue_tracker;

import com.example.issue_tracker.entity.Inquiry;
import com.example.issue_tracker.service.InquiryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final InquiryService inquiryService;

    public HomeController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inquiries", inquiryService.findAll());
        return "index";
    }

    @GetMapping("/inquiries/new")
    public String newInquiry(Model model) {
        model.addAttribute("inquiry", new Inquiry());
        return "inquiry-form";
    }

    @PostMapping("/inquiries")
    public String createInquiry(
            @Valid Inquiry inquiry,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "inquiry-form";
        }

        inquiryService.save(inquiry);
        return "redirect:/";
    }
}
