package com.splitwise.model.expense;

import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.split.EqualSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(amount, paidBy, splits, expenseMetaData);
    }

    @Override
    public boolean validate() throws InvalidSplitType {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit))
                throw new InvalidSplitType("Invalid Split Type in Split List");
        }
        return true;
    }
}
