package com.splitwise.service;

import com.splitwise.exception.InvalidAmountForSplit;
import com.splitwise.exception.InvalidPercentForSplit;
import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.expense.Expense;
import com.splitwise.model.expense.ExpenseMetaData;
import com.splitwise.model.expense.ExpenseType;
import com.splitwise.model.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    public static List<Expense> expenses;
    public static Map<Integer, User> userMap;
    public static Map<Integer, Map<Integer, Double>> balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, double amount, User paidBy,
                           List<Split> splits, ExpenseMetaData expenseMetaData) throws InvalidSplitType, InvalidAmountForSplit, InvalidPercentForSplit {
        Expense expense = ExpenseService.createExpense(expenseType, amount, paidBy, splits, expenseMetaData);
        if (expense.validate()) {
            expenses.add(expense);
            for (Split split : splits) {
                int paidTo = split.getUser().getId();
                Map<Integer, Double> balances = balanceSheet.get(paidBy.getId());
                if (balances == null || !balances.containsKey(paidTo))
                    balances.put(paidTo, 0.0);
                balances.put(paidTo, balances.get(paidTo) + split.getAmount());
                balances = balanceSheet.get(paidTo);
                if (!balances.containsKey(paidBy.getId()))
                    balances.put(paidBy.getId(), 0.0);
                balances.put(paidBy.getId(), balances.get(paidBy.getId()) - split.getAmount());
            }
        }
    }

    public void showBalance(int userId) {
        boolean isEmpty = true;
        for (Map.Entry<Integer, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (isEmpty)
            System.out.println("No Balance to SHow");
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<Integer, Map<Integer, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<Integer, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }
        if (isEmpty)
            System.out.println("No Balance to SHow");
    }

    private void printBalance(int userOne, int userTwo, Double amount) {
        String userOneName = userMap.get(userOne).getName();
        String userTwoName = userMap.get(userTwo).getName();
        if (userOneName != userTwoName) {
            if (amount < 0)
                System.out.println(userOneName + " owes " + userTwoName + " : " + Math.abs(amount));
            else if (amount > 0)
        System.out.println(userTwoName + " owes " + userOneName + " : " + Math.abs(amount));
        }
    }
}
