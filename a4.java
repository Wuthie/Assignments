import java.util.Scanner;

// ---------------------------------------------------------
// Assignment 4
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// ---------------------------------------------------------

// Program is a household budget program where it can contains the total amount of money of each household while also split into different type (loonies, toonies...)
public class A4 {

    public static class Fund {
        private static final int LOONIES = 1;
        private static final int TOONIES = 2;
        private static final int FIVE = 5;
        private static final int TEN = 10;
        private static final int TWENTY = 20;
        private int looniesTotal;
        private int tooniesTotal;
        private int fiveTotal;
        private int tenTotal;
        private int twentyTotal;

        public Fund(int looniesTotal, int tooniesTotal, int fiveTotal, int tenTotal, int twentyTotal) {
            this.looniesTotal = LOONIES * (looniesTotal);
            this.tooniesTotal = TOONIES * (tooniesTotal);
            this.fiveTotal = FIVE * (fiveTotal);
            this.tenTotal = TEN * (tenTotal);
            this.twentyTotal = TWENTY * (twentyTotal);
        }

        public void addFund(int looniesTotal, int tooniesTotal, int fiveTotal, int tenTotal, int twentyTotal) {
            this.looniesTotal += LOONIES * (looniesTotal);
            this.tooniesTotal += TOONIES * (tooniesTotal);
            this.fiveTotal += FIVE * (fiveTotal);
            this.tenTotal += TEN * (tenTotal);
            this.twentyTotal += TWENTY * (twentyTotal);
        }

        public int fundTotal() {
            return looniesTotal + tooniesTotal + fiveTotal + tenTotal + twentyTotal;
        }

        public String toString() {
            return (looniesTotal / LOONIES + " ~ $1 Bill \n" + tooniesTotal / TOONIES + " ~ $2 Bill \n"
                    + fiveTotal / FIVE + " ~ $5 Bill \n" + tenTotal / TEN + " ~ $10 Bill \n" + twentyTotal / TWENTY
                    + " ~ $20 Bill\n");
        }

        public boolean equals(Fund object2) {
            return (this.looniesTotal == object2.looniesTotal && this.tooniesTotal == object2.tooniesTotal
                    && this.fiveTotal == object2.fiveTotal && this.tenTotal == object2.tenTotal
                    && this.twentyTotal == object2.twentyTotal);
        }
    }

    public static class Expense {
        private double amount;
        private String nameBusiness;
        private int dueMonth;
        private int dueDay;
        private String type;

        public Expense(double amount, String nameBusiness, int dueMonth, int dueDay, String type) {
            this.amount = amount;
            this.nameBusiness = nameBusiness;
            this.dueMonth = dueMonth;
            this.dueDay = dueDay;
            this.type = type;
        }

        public void addExpense(double amount, String nameBusiness, int dueMonth, int dueDay, String type) {
            this.amount = amount;
            this.nameBusiness = nameBusiness;
            if (dueDay < 1 || dueDay > 31)
                this.dueDay = 0;
            else
                this.dueDay = dueDay;
            if (dueMonth < 1 || dueMonth > 12)
                this.dueMonth = 0;
            else
                this.dueMonth = dueMonth;
            this.type = type;
        }

        public void updateDate(int dueDate, int dueMonth) {
            if (dueDay < 1 || dueDay > 31)
                this.dueDay = 0;
            else
                this.dueDay = dueDate;
            if (dueMonth < 1 || dueMonth > 12)
                this.dueMonth = 0;
            else
                this.dueMonth = dueMonth;
        }

        public String toString() {
            return (type + " - " + "$" + amount + " - " + nameBusiness + " - " + String.format("%02d", dueDay) + "/"
                    + String.format("%02d", dueMonth));
        }

        public boolean equals(Object object2) {
            if (this == object2)
                return true;
            else
                return false;

        }

    }

    public static class HouseholdBudget {

        private Fund fund;
        private Expense[] expense;

        public void setVal(Expense[] expense, Fund fund) {
            this.expense = expense;
            this.fund = fund;
        }

        public double returnFundTotal() {
            return fund.fundTotal();
        }

        public int returnNumberExpense() {
            int x = 0;
            for (int i = 0; i < expense.length; i++) {
                if (expense[i] == null)
                    ;
                else
                    x++;
            }
            return x;
        }

        public static void displayCompareNumberExpense(HouseholdBudget[] allHH) {
            for (int i = 0; i < allHH.length; i++) {
                for (int j = 0; j < allHH.length; j++) {
                    if (allHH[i].returnNumberExpense() == allHH[j].returnNumberExpense() && i < j) {
                        System.out.println("HouseholdBudgets " + i + " and " + j);
                    }
                }
            }
        }

        public boolean fundEqualHHB(HouseholdBudget obj) {
            return fund.fundTotal() == obj.returnFundTotal();

        }

        public void addNewExpense(Expense[][] allEx, int choice, double amount, String nameBusiness, int dueMonth,
                int dueDay, String type) {
            for (int i = 0; i < allEx[choice].length; i++) {
                if (allEx[choice][i] == null) {
                    allEx[choice][i] = new Expense(amount, nameBusiness, dueMonth, dueDay, type);
                    break;

                }
            }
        }

        public void printExpense() {
            int x = 0;
            for (int i = 0; i < expense.length; i++) {
                if (expense[i] == null) {
                    x++;
                    if (x == 10)
                        System.out.println("No Expense\n");
                } else {
                    System.out.println(expense[i].toString());
                }
            }
        }

        public static void displayEqualFund(Fund[] allvar) {
            for (int i = 0; i < allvar.length; i++) {
                {
                    for (int j = 0; j < allvar.length; j++) {
                        if (allvar[i].equals(allvar[j]) == true && i < j) {
                            System.out.println(
                                    "HouseholdBudget " + i + " and " + j + " both have\n" + allvar[i].toString());
                        }
                    }
                }
            }
        }

        public static void removeExpense(int choiceHHRremove, int extoRemove, Expense[][] allEx) {
            allEx[choiceHHRremove][extoRemove] = null;
        }

        public static void updateDate(int newDueDay, int newDueMonth, Expense[][] allEx, int choiceUpdateExpense,
                int choiceExpenseNum) {
            allEx[choiceUpdateExpense][choiceExpenseNum].updateDate(newDueDay, newDueMonth);
        }
    }

    public class BudgetDemo {
        public static void main(String[] args) {
            Fund houseHold0 = new Fund(0, 1, 0, 2, 1);
            Fund houseHold1 = new Fund(0, 1, 0, 2, 1);
            Fund houseHold2 = new Fund(10, 1, 0, 1, 1);
            Fund houseHold3 = new Fund(1, 2, 3, 4, 5);
            Fund houseHold4 = new Fund(1, 2, 3, 4, 5);
            Expense[] exHouseHold0 = new Expense[10];
            Expense[] exHouseHold1 = new Expense[10];
            Expense[] exHouseHold2 = new Expense[10];
            Expense[] exHouseHold3 = new Expense[10];
            Expense[] exHouseHold4 = new Expense[10];
            exHouseHold0[0] = new Expense(23, "IGA", 12, 6, "Purchase");
            exHouseHold1[0] = new Expense(80, "Walmart", 11, 11, "Purchase");
            exHouseHold2[0] = new Expense(123, "RBC", 6, 27, "Bill");
            exHouseHold2[1] = new Expense(90, "Hydro-QC", 2, 15, "Bill");
            exHouseHold2[2] = new Expense(2, "Walmart", 8, 9, "Purchase");
            HouseholdBudget houseHold0budget = new HouseholdBudget();
            HouseholdBudget houseHold1budget = new HouseholdBudget();
            HouseholdBudget houseHold2budget = new HouseholdBudget();
            HouseholdBudget houseHold3budget = new HouseholdBudget();
            HouseholdBudget houseHold4budget = new HouseholdBudget();
            houseHold0budget.setVal(exHouseHold0, houseHold0);
            houseHold1budget.setVal(exHouseHold1, houseHold1);
            houseHold2budget.setVal(exHouseHold2, houseHold2);
            houseHold3budget.setVal(exHouseHold3, houseHold3);
            houseHold4budget.setVal(exHouseHold4, houseHold4);
            boolean isValid = true;
            while (isValid) {
                int choice;
                System.out.println("\nWhat would you like to do?\n" +
                        " 1. See the possessions of all householdBudgets\n" +
                        " 2. See the possessions of one householdBudget\n" +
                        " 3. List householdBudgets with same total amount of fund\n" +
                        " 4. List householdBudgets with same fund denomination(s)\n" +
                        " 5. List householdBudgets with same total amount of fund and same number of expenses\n"
                        +
                        " 6. Add an expense to an existing householdBudget\n" +
                        " 7. Remove an existing expense from a householdBudget\n" +
                        " 8. Update the payment due date of an existing expense\n" +
                        " 9. Add fund to a householdBudget\n" +
                        " 0. To quit");
                Scanner input = new Scanner(System.in);
                System.out.print("Please enter your choice and press <Enter>: ");
                choice = input.nextInt();
                Expense[][] allEx = { exHouseHold0, exHouseHold1, exHouseHold2, exHouseHold3, exHouseHold4 };
                Fund[] allVar = { houseHold0, houseHold1, houseHold2, houseHold3, houseHold4 };
                HouseholdBudget[] allHH = { houseHold0budget, houseHold1budget, houseHold2budget,
                        houseHold3budget,
                        houseHold4budget };
                switch (choice) {
                    case (0): {
                        isValid = false;
                        break;
                    }
                    case (1): {
                        System.out.println("Content of each HouseholdBudget:");
                        System.out.println("--------------------------------");
                        for (int i = 0; i < allVar.length; i++) {
                            System.out.println("\nHouseholdBudget #" + i);
                            System.out.println(allVar[i].toString());
                            allHH[i].printExpense();
                        }
                        break;

                    }
                    case (2): {
                        int choiceTwo;
                        System.out.print(
                                "Which HouseholdBudget you want to see the possessions of? (Enter number 0 to 4): ");
                        choiceTwo = input.nextInt();
                        if (choiceTwo < 0 || choiceTwo > 4) {
                            do {
                                System.out.println("Sorry but there is no HouseholdBudget number " + choiceTwo);
                                System.out.print("Please try again (Enter number 0 to 4): ");
                                choiceTwo = input.nextInt();
                            } while (choiceTwo >= 5 || choiceTwo < 0);
                        }
                        for (int i = 0; i < allVar.length; i++) {
                            if (i == choiceTwo) {
                                System.out.println(allVar[i].toString());
                                allHH[i].printExpense();
                            }
                        }
                        break;
                    }
                    case (3): {
                        System.out.println(houseHold0budget.fundEqualHHB(houseHold1budget));
                        break;
                    }
                    case (4): {
                        HouseholdBudget.displayEqualFund(allVar);
                        break;
                    }
                    case (5): {
                        HouseholdBudget.displayCompareNumberExpense(allHH);
                        break;
                    }
                    case (6): {
                        System.out.print(
                                "Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to 4): ");
                        int choiceNumOfExpense = input.nextInt();
                        System.out.println(
                                "Please enter the following information so that we may complete the expense-");
                        System.out.print("--> Type of expense (Bill, Purchase, etc...): ");
                        String type = input.next();
                        System.out.print("--> Amount of expense: ");
                        double amount = input.nextDouble();
                        System.out.print("--> Name of the business: ");
                        String nameBusiness = input.next();
                        System.out.print("--> Payment due day number and month (seperate by a space): ");
                        int dueDay = input.nextInt();
                        int dueMonth = input.nextInt();
                        allHH[choiceNumOfExpense].addNewExpense(allEx, choiceNumOfExpense, amount, nameBusiness,
                                dueMonth, dueDay, type);
                        System.out.println(allHH[choiceNumOfExpense].returnNumberExpense());
                        break;
                    }
                    case (7): {
                        System.out.print(
                                "Which HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): ");
                        int choiceHHRremove = input.nextInt();
                        System.out.print(
                                "(Enter number 0 to " + (allHH[choiceHHRremove].returnNumberExpense() - 1) + "): ");
                        int extoRemove = input.nextInt();
                        HouseholdBudget.removeExpense(choiceHHRremove, extoRemove, allEx);
                        break;
                    }
                    case (8): {
                        System.out.print(
                                "Which HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): ");
                        int choiceUpdateExpense = input.nextInt();
                        System.out.print("Which expense do you want to update? (Enter number 0 to "
                                + (allHH[choiceUpdateExpense].returnNumberExpense() - 1) + "): ");
                        int choiceExpenseNum = input.nextInt();
                        if (choiceExpenseNum < 0
                                || choiceExpenseNum > (allHH[choiceUpdateExpense].returnNumberExpense() - 1)) {
                            do {
                                System.out.println("Sorry but there is no expense number " + choiceExpenseNum);
                                System.out.print("--> Try again (Enter number 0 to "
                                        + (allHH[choiceUpdateExpense].returnNumberExpense() - 1) + "): ");
                                choiceExpenseNum = input.nextInt();
                            } while (choiceExpenseNum < 0
                                    || choiceExpenseNum > (allHH[choiceUpdateExpense].returnNumberExpense() - 1));
                        }
                        System.out.print("--> Enter new payment due day number and month (seperate by a space): ");
                        int newDueDay = input.nextInt();
                        int newDueMonth = input.nextInt();
                        HouseholdBudget.updateDate(newDueDay, newDueMonth, allEx, choiceUpdateExpense, choiceExpenseNum);
                        break;
                    }
                    case (9):{
                        System.out.print("Which HouseHoldBudget do you want to add Fund to? (Enter number 0 to 4): ");
                        int newHBBFund = input.nextInt();
                        System.out.println("How many loonies, toonies, $5, $10 and $20 bill do you want to add?");
                        System.out.print("Enter 5 numbers seperated by a space): ");
                        int loonies = input.nextInt();
                        int toonies = input.nextInt();
                        int five = input.nextInt();
                        int ten = input.nextInt();
                        int twenty = input.nextInt();
                        allVar[newHBBFund].addFund(loonies, toonies, five, ten, twenty);
                        System.out.println("You now have $" + allVar[newHBBFund].fundTotal());
                    }
                    default: {
                        System.out.println("Sorry that is not a valid choice. Try Again");
                    }
                }

            }

        }
    }

}
