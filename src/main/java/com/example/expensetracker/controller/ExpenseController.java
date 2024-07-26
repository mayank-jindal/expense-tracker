package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.User;
import com.example.expensetracker.service.ExpenseService;
import com.example.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Expense> getExpenses(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return expenseService.getExpensesForUser(user);
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        expense.setUser(user);
        return expenseService.addExpense(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id);
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
