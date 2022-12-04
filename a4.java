import java.util.Scanner;

// ---------------------------------------------------------
// Assignment 4
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// ---------------------------------------------------------

// Program is a household budget program where it can contains the total amount of money of each household while also split into different type (loonies, toonies...)
// Users are able to view all Household fund and expenses, view individual household information, compare funds between household, compare expenses, remove expenses and update the date of an existing expenses
public class A4 {

    public static class Fund {
        private static final int LOONIES = 1; // declare static variable for loonies toonies...
        private static final int TOONIES = 2;
        private static final int FIVE = 5;
        private static final int TEN = 10;
        private static final int TWENTY = 20;
        private int looniesTotal;
        private int tooniesTotal;
        private int fiveTotal;
        private int tenTotal;
        private int twentyTotal;

        public Fund(int looniesTotal, int tooniesTotal, int fiveTotal, int tenTotal, int twentyTotal) { //constructor to declare value for total amount of fund
            this.looniesTotal = LOONIES * (looniesTotal);
            this.tooniesTotal = TOONIES * (tooniesTotal);
            this.fiveTotal = FIVE * (fiveTotal);
            this.tenTotal = TEN * (tenTotal);
            this.twentyTotal = TWENTY * (twentyTotal);
        }

        public void addFund(int looniesTotal, int tooniesTotal, int fiveTotal, int tenTotal, int twentyTotal) { //addFund to take old amount and add new amount
            this.looniesTotal += LOONIES * (looniesTotal);
            this.tooniesTotal += TOONIES * (tooniesTotal);
            this.fiveTotal += FIVE * (fiveTotal);
            this.tenTotal += TEN * (tenTotal);
            this.twentyTotal += TWENTY * (twentyTotal);
        }

        public int fundTotal() { // return the total amount of fund a household have
            return looniesTotal + tooniesTotal + fiveTotal + tenTotal + twentyTotal;
        }

        public String toString() { // return the string showing the number of each type of fund by taking the total
                                   // of each fund and divide with each fund value.
            return (looniesTotal / LOONIES + " ~ $1 Bill \n" + tooniesTotal / TOONIES + " ~ $2 Bill \n"
                    + fiveTotal / FIVE + " ~ $5 Bill \n" + tenTotal / TEN + " ~ $10 Bill \n" + twentyTotal / TWENTY
                    + " ~ $20 Bill\n");
        }

        public boolean equals(Fund object2) { // return true if all type of fund is equal
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

        public Expense(double amount, String nameBusiness, int dueMonth, int dueDay, String type) { //constructor to declare value of amount, the name of business, the dates and the types of expenses.
            this.amount = amount;
            this.nameBusiness = nameBusiness;
            this.dueMonth = dueMonth;
            this.dueDay = dueDay;
            this.type = type;
        }

        public void addExpense(double amount, String nameBusiness, int dueMonth, int dueDay, String type) { //copy constructor but with dates condition where month can't be over 12 and dates cant be over 31
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

        public void updateDate(int dueDate, int dueMonth) { //method to update the date with the same conditions above, if out of range = 0
            if (dueDay < 1 || dueDay > 31)
                this.dueDay = 0;
            else
                this.dueDay = dueDate;
            if (dueMonth < 1 || dueMonth > 12)
                this.dueMonth = 0;
            else
                this.dueMonth = dueMonth;
        }

        public String toString() { //return string for expenses 
            return (type + " - " + "$" + amount + " - " + nameBusiness + " - " + String.format("%02d", dueDay) + "/"
                    + String.format("%02d", dueMonth));
        }

        public boolean equals(Object object2) { //return true if both expenses is equal
            if (this == object2)
                return true;
            else
                return false;

        }

    }

    public static class HouseholdBudget { 

        private Fund fund;
        private Expense[] expense;

        public void setVal(Expense[] expense, Fund fund) { //constructor to set value for fund and epxense
            this.expense = expense;
            this.fund = fund;
        }

        public double returnFundTotal() { //return the total amount of fund by calling a method from the Fund method
            return fund.fundTotal();
        }

        public int returnNumberExpense() { // return the number of expense, if a value in array is null dont consider so number of expense only consider arrays with value
            int x = 0;
            for (int i = 0; i < expense.length; i++) {
                if (expense[i] == null)
                    ;
                else
                    x++;
            }
            return x;
        }

        public static void displayCompareNumberExpense(HouseholdBudget[] allHH) { //print pair of household where the number of expense is the same by using the above method.
            for (int i = 0; i < allHH.length; i++) {
                for (int j = 0; j < allHH.length; j++) {
                    if (allHH[i].returnNumberExpense() == allHH[j].returnNumberExpense() && i < j) {
                        System.out.println("HouseholdBudgets " + i + " and " + j);
                    }
                }
            }
        }

        public boolean fundEqualHHB(HouseholdBudget obj) { //return true if both pair of fund amount is equal
            return fund.fundTotal() == obj.returnFundTotal();

        }

        public void addNewExpense(Expense[][] allEx, int choice, double amount, String nameBusiness, int dueMonth, //method to add new expense including the conditions for the date.
                int dueDay, String type) {
            for (int i = 0; i < allEx[choice].length; i++) {
                if (allEx[choice][i] == null) {
                    if (dueDay < 1 || dueDay > 31)
                        dueDay = 0;
                    if (dueMonth < 1 || dueMonth > 12)
                        dueMonth = 0;
                    allEx[choice][i] = new Expense(amount, nameBusiness, dueMonth, dueDay, type);
                    break;

                }
            }
        }

        public void printExpense() { //method to print the expense information by calling to above method in Expense, if null print no expense/
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

        public static void displayEqualFund(Fund[] allvar) { //method to print pairs of household budget where to total amount of fund is equal.
            for (int i = 0; i < allvar.length; i++) {
                {
                    for (int j = 0; j < allvar.length; j++) {
                        if (allvar[i].fundTotal()==allvar[j].fundTotal()  && i < j) {
                            System.out.println(
                                    "HouseholdBudget " + i + " and " + j + " both have $" + allvar[i].fundTotal());
                        }
                    }
                }
            }
        }


        public static void removeExpense(int choiceHHRremove, int extoRemove, Expense[][] allEx) { //method to remove expense by declaring it as null
            allEx[choiceHHRremove][extoRemove] = null;
        }

        public static void updateDate(int newDueDay, int newDueMonth, Expense[][] allEx, int choiceUpdateExpense, //method to update the date of an existing expense.
                int choiceExpenseNum) {
            allEx[choiceUpdateExpense][choiceExpenseNum].updateDate(newDueDay, newDueMonth);
        }
    }

    public class BudgetDemo {
        public static void main(String[] args) {
            Fund houseHold0 = new Fund(0, 1, 0, 2, 1); // hard code to declare all of the values of fund of 5 household inheritance
            Fund houseHold1 = new Fund(0, 1, 0, 2, 1);
            Fund houseHold2 = new Fund(10, 1, 0, 1, 1);
            Fund houseHold3 = new Fund(1, 2, 3, 4, 5);
            Fund houseHold4 = new Fund(1, 2, 3, 4, 5);
            Expense[] exHouseHold0 = new Expense[10]; //declare array for each household where each household can have 10 expense 
            Expense[] exHouseHold1 = new Expense[10];
            Expense[] exHouseHold2 = new Expense[10];
            Expense[] exHouseHold3 = new Expense[10];
            Expense[] exHouseHold4 = new Expense[10];
            exHouseHold0[0] = new Expense(23, "IGA", 12, 6, "Purchase"); //hard code to declare value inheritance of the amount, name of business, dates and types of each expenses.
            exHouseHold1[0] = new Expense(80, "Walmart", 11, 11, "Purchase");
            exHouseHold2[0] = new Expense(123, "RBC", 6, 27, "Bill");
            exHouseHold2[1] = new Expense(90, "Hydro-QC", 2, 15, "Bill");
            exHouseHold2[2] = new Expense(2, "Walmart", 8, 9, "Purchase");
            HouseholdBudget houseHold0budget = new HouseholdBudget(); //create 5 households
            HouseholdBudget houseHold1budget = new HouseholdBudget();
            HouseholdBudget houseHold2budget = new HouseholdBudget();
            HouseholdBudget houseHold3budget = new HouseholdBudget();
            HouseholdBudget houseHold4budget = new HouseholdBudget();
            houseHold0budget.setVal(exHouseHold0, houseHold0);
            houseHold1budget.setVal(exHouseHold1, houseHold1); //set value for each household containing both information from Fund and Expense
            houseHold2budget.setVal(exHouseHold2, houseHold2);
            houseHold3budget.setVal(exHouseHold3, houseHold3);
            houseHold4budget.setVal(exHouseHold4, houseHold4);
            boolean isValid = true; //boolean used for while loop so program would run again and again and won't quit after each choice
            Scanner input = new Scanner(System.in); //open scanner
            while (isValid) {
                int choice;
                System.out.println("\nWhat would you like to do?\n" + //print choices available
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
                
                System.out.print("Please enter your choice and press <Enter>: ");
                choice = input.nextInt();
                Expense[][] allEx = { exHouseHold0, exHouseHold1, exHouseHold2, exHouseHold3, exHouseHold4 }; //create 3 arrays to be used while allEx is a 2D array
                Fund[] allVar = { houseHold0, houseHold1, houseHold2, houseHold3, houseHold4 };
                HouseholdBudget[] allHH = { houseHold0budget, houseHold1budget, houseHold2budget,
                        houseHold3budget,
                        houseHold4budget };
                switch (choice) { //switch case for each user's choice
                    case (0): {
                        isValid = false; //if user chose 0 exit loop and print thank you
                        System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application");
                        break;
                    }
                    case (1): { //case to print all household fund information and expenses by using for loop to go through array and using method from above.
                        System.out.println("Content of each HouseholdBudget:");
                        System.out.println("--------------------------------");
                        for (int i = 0; i < allVar.length; i++) {
                            System.out.println("\nHouseholdBudget #" + i);
                            System.out.println(allVar[i].toString());
                            allHH[i].printExpense();
                        }
                        break;

                    }
                    case (2): { //case to see information of only one household
                        int choiceTwo;
                        System.out.print(
                                "Which HouseholdBudget you want to see the possessions of? (Enter number 0 to 4): ");
                        choiceTwo = input.nextInt();
                        if (choiceTwo < 0 || choiceTwo > 4) {
                            do {
                                System.out.println("Sorry but there is no HouseholdBudget number " + choiceTwo); //if user enter choice out of range let user enter again
                                System.out.print("Please try again (Enter number 0 to 4): ");
                                choiceTwo = input.nextInt();
                            } while (choiceTwo >= 5 || choiceTwo < 0);
                        }
                        for (int i = 0; i < allVar.length; i++) { //print household information of that particular chice
                            if (i == choiceTwo) {
                                System.out.println(allVar[i].toString());
                                allHH[i].printExpense();
                            }
                        }
                        break;
                    }
                    case (3): {
                        HouseholdBudget.displayEqualFund(allVar); //display fund of pairs of household budget that have the same amount of fund
                        break;
                    }
                    case (4): { //display fund of bairs pf household budget have the same fund distribution
                        for (int i = 0; i < allVar.length; i++){
                            for (int j = 0; j<allVar.length; j++){
                                if(allVar[i].equals(allVar[j]) && i < j){
                                    System.out.println("HouseholdBudgets " + i + " and " + j + " both have\n" +allVar[i].toString());
                                }
                            }
                        }
                        break;
                    }
                    
                    case (5): { //display pairs of household where the number of expense is the same
                        HouseholdBudget.displayCompareNumberExpense(allHH);
                        break;
                    }
                    case (6): { //case to add new expense
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
                                dueMonth, dueDay, type); //method to add the expense
                        System.out.println(allHH[choiceNumOfExpense].returnNumberExpense()); //print out the number of new expense
                        break;
                    }
                    case (7): { //case to remove expense
                        System.out.print(
                                "Which HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): ");
                        int choiceHHRremove = input.nextInt();
                        System.out.print(
                                "(Enter number 0 to " + (allHH[choiceHHRremove].returnNumberExpense() - 1) + "): "); //show how many expenses available
                        int extoRemove = input.nextInt();
                        HouseholdBudget.removeExpense(choiceHHRremove, extoRemove, allEx); //method to remove expense
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
                                || choiceExpenseNum > (allHH[choiceUpdateExpense].returnNumberExpense() - 1)) { //show how many expenses available
                            do {
                                System.out.println("Sorry but there is no expense number " + choiceExpenseNum); //if user input outside of range by using do while loop
                                System.out.print("--> Try again (Enter number 0 to "
                                        + (allHH[choiceUpdateExpense].returnNumberExpense() - 1) + "): ");
                                choiceExpenseNum = input.nextInt();
                            } while (choiceExpenseNum < 0
                                    || choiceExpenseNum > (allHH[choiceUpdateExpense].returnNumberExpense() - 1));
                        }
                        System.out.print("--> Enter new payment due day number and month (seperate by a space): ");
                        int newDueDay = input.nextInt();
                        int newDueMonth = input.nextInt();
                        HouseholdBudget.updateDate(newDueDay, newDueMonth, allEx, choiceUpdateExpense, //update the date
                                choiceExpenseNum);
                        break;
                    }
                    case (9): {
                        System.out.print("Which HouseHoldBudget do you want to add Fund to? (Enter number 0 to 4): "); //add new fund
                        int newHBBFund = input.nextInt();
                        System.out.println("How many loonies, toonies, $5, $10 and $20 bill do you want to add?");
                        System.out.print("Enter 5 numbers seperated by a space): ");
                        int loonies = input.nextInt();
                        int toonies = input.nextInt();
                        int five = input.nextInt();
                        int ten = input.nextInt();
                        int twenty = input.nextInt();
                        allVar[newHBBFund].addFund(loonies, toonies, five, ten, twenty); //add fund by type into parameter
                        System.out.println("You now have $" + allVar[newHBBFund].fundTotal()); //print the total fund
                    }
                    default: { //default choice when user input outside of choice range
                        System.out.println("Sorry that is not a valid choice. Try Again");
                    }
                }

            }
            input.close();
        }
    }

}
