package com.splitwise.model.expense;

import com.splitwise.exception.InvalidAmountForSplit;
import com.splitwise.exception.InvalidPercentForSplit;
import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.split.Split;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetaData expenseMetaData;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetaData) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.expenseMetaData = expenseMetaData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }

    public abstract boolean validate() throws InvalidSplitType, InvalidAmountForSplit, InvalidPercentForSplit;

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", splits=" + splits +
                ", expenseMetaData=" + expenseMetaData +
                '}';
    }
}
