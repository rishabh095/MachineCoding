package com.splitwise.model.expense;

import com.splitwise.exception.InvalidAmountForSplit;
import com.splitwise.exception.InvalidSplitType;
import com.splitwise.model.User;
import com.splitwise.model.split.ExactSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(amount, paidBy, splits, expenseMetaData);
    }

    @Override
    public boolean validate() throws InvalidSplitType, InvalidAmountForSplit {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit))
                throw new InvalidSplitType("Invalid Split Type in Split List");
        }
        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }
        if (totalAmount != sumSplitAmount)
            throw new InvalidAmountForSplit("Amount is not same as sum of Amount to be split");
        return true;
    }
}
