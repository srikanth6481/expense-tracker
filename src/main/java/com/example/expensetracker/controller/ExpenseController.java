package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "index";
    }

    @PostMapping("/addExpense")
    public String addExpense(Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/";
    }
}
