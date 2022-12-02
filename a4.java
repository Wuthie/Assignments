
import java.util.Scanner;
// ---------------------------------------------------------
// Assignment 4
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// ---------------------------------------------------------

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
            this.looniesTotal = LOONIES * (looniesTotal);
            this.tooniesTotal = TOONIES * (tooniesTotal);
            this.fiveTotal = FIVE * (fiveTotal);
            this.tenTotal = TEN * (tenTotal);
            this.twentyTotal = TWENTY * (twentyTotal);
        }

        public int fundTotal() {
            return looniesTotal + tooniesTotal + fiveTotal + tenTotal + twentyTotal;
        }

        public String toString() {
            return (looniesTotal / LOONIES + " ~ $1 Bill \n" + tooniesTotal / TOONIES + " ~ $2 Bill \n"
                    + fiveTotal / FIVE + " ~ $5 Bill \n" + tenTotal / TEN + " ~ $10 Bill \n" + twentyTotal / TWENTY
                    + " ~ $20 Bill\n");
        }

        public boolean equals(Object object2) {
            if (this == object2)
                return true;
            else
                return false;
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

        public static class HouseholdBudget {

            private Object Fund;
            private Expense[] exHouseHold = new Expense[10];

            public boolean fundEqualHHB(Object obj) {
                if (this == obj)
                    return true;
                else
                    return false;
            }

            public boolean typeEqualHHB(Object obj) {
                if (this == obj)
                    return true;
                else
                    return false;
            }

            public double fundTotal(Object obj) {
                return ((A4.Fund) obj).fundTotal();
            }
            // public int numberExpense(Object obj) {
            // for (int i = 0, i < obj.length)
            // }
         
        }
        
    }

            public class BudgetDemo {
        public static void main(String[] args) {
            boolean isValid = true;
            while(isValid){
            int choice;
            System.out.println("What would you like to do?\n" +
            " 1. See the possessions of all householdBudgets\n" +
            " 2. See the possessions of one householdBudget\n" + 
            " 3. List householdBudgets with same total amount of fund\n" +
            " 4. List householdBudgets with same fund denomination(s)\n" + 
            " 5. List householdBudgets with same total amount of fund and same number of expenses\n" +
            " 6. Add an expense to an existing householdBudget\n" +
            " 7. Remove an existing expense from a householdBudget\n" + 
            " 8. Update the payment due date of an existing expense\n" +
            " 9. Add fund to a householdBudget\n" + 
            " 0. To quit");
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter your choice and press <Enter>: ");
            choice = input.nextInt();
            Fund houseHold0 = new Fund(0, 1, 0, 2, 1);
            Fund houseHold1 = new Fund(0,1,0,2,1);
            Fund houseHold2 = new Fund(10,1,0,1,1);
            Fund houseHold3 = new Fund(1,2,3,4,5);
            Fund houseHold4 = new Fund(1,2,3,4,5);
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
            

            

            switch (choice){
                case (0):{
                    isValid = false;
                    break;
                }
                case (1):{
                    System.out.println("Content of each HouseholdBudget:");
                    System.out.println("--------------------------------");
                    System.out.println("HouseholdBudget #0:");
                    System.out.println(houseHold0.toString());
                    int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold0[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense\n");
                                } else{
                                    System.out.println(exHouseHold0[i].toString());
                                }
                                
                            }
                            
                          
                            System.out.println("\n");
                System.out.println("HouseholdBudget #1:");
                    System.out.println(houseHold1.toString());
                    int x1 = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold1[i] == null){
                                    x1++;
                                    if (x1==10) System.out.println("No Expense\n");
                                } else{
                                    System.out.println(exHouseHold1[i].toString());
                                }
                                
                            }
                            System.out.println("\n");
                            System.out.println("HouseholdBudget #2:");
                    System.out.println(houseHold2.toString());
                    int x2 = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold2[i] == null){
                                    x2++;
                                    if (x2==10) System.out.println("No Expense\n");
                                } else{
                                    System.out.println(exHouseHold2[i].toString());
                                }
                                
                            }
                            System.out.println("\n");
                            System.out.println("HouseholdBudget #3:");
                            System.out.println(houseHold3.toString());
                            int x3 = 0;
                                    for (int i = 0; i < 10; i++ ){
                                        if (exHouseHold3[i] == null){
                                            x3++;
                                            if (x3==10) System.out.println("No Expense\n");
                                        } else{
                                            System.out.println(exHouseHold3[i].toString());
                                        }
                                        
                                    }
                                    System.out.println("\n");
                            System.out.println("HouseholdBudget #4:");
                            System.out.println(houseHold4.toString());
                            int x4 = 0;
                                    for (int i = 0; i < 10; i++ ){
                                        if (exHouseHold4[i] == null){
                                            x4++;
                                            if (x4==10) System.out.println("No Expense\n");
                                        } else{
                                            System.out.println(exHouseHold4[i].toString());
                                        }
                                        
                                    }
                            
                            
                        
                        }
                case (2):{
                    int choiceTwo;
                    System.out.print("Which HouseholdBudget you want to see the possessions of? (Enter number 0 to 4): ");
                    choiceTwo = input.nextInt();
                    switch (choiceTwo){
                        case 0:
                        case 1:
                        case 2: 
                        case 3:
                        case 4: break;
                        default:{
                            do{
                                System.out.println("Sorry but there is no HouseholdBudget number " + choiceTwo);
                                System.out.print("Please try again (Enter number 0 to 4): ");
                                choiceTwo = input.nextInt();
                            }
                            while (choiceTwo >= 5 || choiceTwo < 0);
                        }
                
                    }
                    switch(choiceTwo){
                        case 0: {
                            System.out.println(houseHold0.toString());
                            int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold0[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense");
                                } else{
                                    System.out.println(exHouseHold0[i].toString());
                                }
                                
                            }
                            
                            break;
                        }
                        case 1: {
                            System.out.println(houseHold1.toString());
                            int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold1[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense");
                                } else{
                                    System.out.println(exHouseHold1[i].toString());
                                }
                                
                            }
                            
                            break;
                        }
                        case 2: {
                            System.out.println(houseHold2.toString());
                            int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold2[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense");
                                } else{
                                    System.out.println(exHouseHold2[i].toString());
                                }
                                
                            }
                            
                            break;
                        }
                        case 3: {
                            System.out.println(houseHold3.toString());
                            int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold3[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense");
                                } else{
                                    System.out.println(exHouseHold3[i].toString());
                                }
                                
                            }
                            
                            break;
                        }
                        case 4: {
                            System.out.println(houseHold4.toString());
                            int x = 0;
                            for (int i = 0; i < 10; i++ ){
                                if (exHouseHold4[i] == null){
                                    x++;
                                    if (x==10) System.out.println("No Expense");
                                } else{
                                    System.out.println(exHouseHold4[i].toString());
                                }
                                
                            }
                            
                            break;
                        }
                    }
                    
                }
            }

        }}

            }

        }

