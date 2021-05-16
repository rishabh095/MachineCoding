package com.splitwise;

import com.splitwise.exception.InvalidAmountForSplit;
import com.splitwise.exception.InvalidPercentForSplit;
import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.expense.ExpenseType;
import com.splitwise.model.split.EqualSplit;
import com.splitwise.model.split.ExactSplit;
import com.splitwise.model.split.PercentSplit;
import com.splitwise.model.split.Split;
import com.splitwise.service.ExpenseManager;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws InvalidSplitType, InvalidAmountForSplit, InvalidPercentForSplit {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser(new User(1, "Rishabh", "rishabh@gmail.com", "8445805434"));
        expenseManager.addUser(new User(2, "Shivam", "shivam@gmail.com", "9897652727"));
        expenseManager.addUser(new User(3, "Anubhav", "anubhav@gmail.com", "8534986611"));
        expenseManager.addUser(new User(4, "Ashish", "ashish@gmail.com", "9897340724"));

        List<Split> splits = new ArrayList<>();
        int noOfUser = 4;
       /* // Invalid Split Type exception
        for (int i = 1; i <= noOfUser; i++) {
            splits.add(new ExactSplit(expenseManager.userMap.get(i)));
        }
        expenseManager.addExpense(ExpenseType.EQUAL, 1000, expenseManager.userMap.get(1), splits, null);
*/

        // Equal Expense

        for (int i = 1; i <= noOfUser; i++) {
            splits.add(new EqualSplit(expenseManager.userMap.get(i)));
        }
        expenseManager.addExpense(ExpenseType.EQUAL, 1000, expenseManager.userMap.get(1), splits, null);

        expenseManager.showBalance(1);
        System.out.println();
        splits.clear();
        // Equal Expense end

        // Exact Expense
        ExactSplit exactSplit1 = new ExactSplit(expenseManager.userMap.get(2));
        exactSplit1.setAmount(370);
        ExactSplit exactSplit2 = new ExactSplit(expenseManager.userMap.get(3));
        exactSplit2.setAmount(880);
        splits.add(exactSplit1);
        splits.add(exactSplit2);
        expenseManager.addExpense(ExpenseType.EXACT, 1250, expenseManager.userMap.get(1), splits, null);
        expenseManager.showBalance(1);
        System.out.println("user 2 balance");
        expenseManager.showBalance(2);
        System.out.println();
        splits.clear();
        // Exact Expense end

        // Percent Expense
        PercentSplit percentSplit1 = new PercentSplit(expenseManager.userMap.get(1));
        percentSplit1.setPercent(40);
        PercentSplit percentSplit2 = new PercentSplit(expenseManager.userMap.get(2));
        percentSplit2.setPercent(20);
        PercentSplit percentSplit3 = new PercentSplit(expenseManager.userMap.get(3));
        percentSplit3.setPercent(20);
        PercentSplit percentSplit4 = new PercentSplit(expenseManager.userMap.get(4));
        percentSplit4.setPercent(20);
        splits.add(percentSplit1);
        splits.add(percentSplit2);
        splits.add(percentSplit3);
        splits.add(percentSplit4);
        expenseManager.addExpense(ExpenseType.PERCENT, 1200, expenseManager.userMap.get(4), splits, null);
        expenseManager.showBalances();
        System.out.println();
        splits.clear();
        // Percent Expense
    }
}
