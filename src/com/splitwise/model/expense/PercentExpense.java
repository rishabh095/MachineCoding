package com.splitwise.model.expense;

import com.splitwise.exception.InvalidPercentForSplit;
import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.split.PercentSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(amount, paidBy, splits, expenseMetaData);
    }

    @Override
    public boolean validate() throws InvalidSplitType, InvalidPercentForSplit {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit))
                throw new InvalidSplitType("Invalid Split Type in Split List");
        }
        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            sumSplitPercent += percentSplit.getPercent();
        }
        if (totalPercent != sumSplitPercent)
            throw new InvalidPercentForSplit("invalid sum of percent to be split");
        return true;
    }
}
