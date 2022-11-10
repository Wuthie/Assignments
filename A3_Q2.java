import java.util.Scanner;
// -------------------------------------------------------
// Assignment A3_Q2
// Written by: Wuthie PANHA 40245548
// For COMP 248 Section P – Fall 2022
// -------------------------------------------------------

// Program take in user input of a collection of candidate and store it. User have choices of whether to display the candidate, vote for a patricular candidate, add new candidate to the collection of candidate and display the result with sorted position after voting.
// Note: default Votes/Ballots will be set to 0 until voted by user.
public class A3_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // open scanner
        System.out.println("Welcome to the Simple Electronic Voting System (SEVS)" +
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\nPlease enter a String collection of electoral candidates below: ");
        String candidatesData = input.nextLine().toUpperCase(); // take in user input and capitalize all letter
        String[] firstSplit = candidatesData.trim().split(";"); // take user input and split string at ";" and trim, spaces before and after the input. After that store store inside an array                                                             
        String[][] tableName = new String[firstSplit.length][];
        for (int i = 0; i < firstSplit.length; i++) {
            String[] val = firstSplit[i].trim().split(","); //split each index of initial array at "," into new array
            tableName[i] = val; //assign new array into table with id and name
        }
        int[][] voteCount = new int[tableName.length][2]; //initialize new table to store id and voteballot of candidates
        for (int j = 0; j < tableName.length; j++) {
            voteCount[j][0] = Integer.parseInt(tableName[j][0]); // parseint first index of every bigger index of tablename as ID of each candidate's was stored as string.
        }

        int choice = 0;
        boolean bwhile = true; //initialize boolean for do while loop 
        System.out.printf("========================================\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "Code", ">>", "Description");
        System.out.printf("========================================\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "1", ">>", "Display candidates");
        System.out.printf("----------------------------------------\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "2", ">>", "Vote a candidate");
        System.out.printf("----------------------------------------\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "3", ">>", "Add new candidate(s)");
        System.out.printf("----------------------------------------\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "4", ">>", "Display results");
        System.out.printf("----------------------------------------\n");
        System.out.printf("| %-4s | %-2s  %25s |\n", "0", ">>", "End Sevs");
        System.out.printf("========================================\n");

        int counter = 0;
        do { //do while loop to catch mismatch error when user enter a string when asked for integer
            try {
                System.out.print("Kindly enter a code, from the aforementioned, that corresponds to your task: ");
                choice = Integer.parseInt(input.next());
                bwhile = false;
            } catch (Exception e) {
                System.out.println("Please input appropriately");
                input.reset();
            }
        }
        while (bwhile);
        while (choice != 0) {
            if (counter == 0) //if else statement whether user have already entered their choice initially. If they did use the initial input.
                counter++;
            else { //for while loop
                System.out.print("Enter a code, from the aforementioned, that corresponds to your task: ");
                choice = input.nextInt();
            }

            switch (choice) {
                case (0): // close program
                    System.out.println("\nThank you for using our Simple Electronic Voting System (SEVS).");
                    break;
                case (1): // Display Candidate
                    System.out.printf("========================================\n");
                    System.out.printf("| %-4s | %-2s  %25s |\n", "ID", ">>", "Candidate's Name");
                    System.out.printf("========================================\n");
                    for (int i = 0; i < tableName.length; i++) {
                        System.out.printf("| %-4s | %-2s  %25s |\n", tableName[i][0], ">>", tableName[i][1]); // go through array and display ID and name accordingly, id is stored first index and name is stored second index
                        System.out.printf("----------------------------------------\n");
                    }
                    break;

                case (2):
                    System.out.print("Please enter the ID of the candidate you wish to vote for: ");
                    int vote = input.nextInt();
                    for (int i = 0; i < voteCount.length; i++) { // take user input and compare if user input is equal to any id in the array and plus one for their vote count (second index), initially vote count is 0 for all candidate.
                        if (voteCount[i][0] == vote) {
                            voteCount[i][1] += 1;
                        }
                    }
                    break;
                case (3): //add candidate
                    System.out.println("Please enter a String collection of the NEW electoral candidates below: ");
                    input.nextLine(); // clear any remaining input line leftover
                    String newCandidatesData = input.nextLine().toUpperCase(); // take in new candidate data 
                    String[] newFirstSplit = newCandidatesData.trim().split(";"); //  split at (";") steps are the same as first input of program
                    String[][] newTableName = new String[newFirstSplit.length][];
                    for (int i = 0; i < newFirstSplit.length; i++) {
                        String[] newVal = newFirstSplit[i].trim().split(",");
                        newTableName[i] = newVal;
                    }
                    String[][] newResult = new String[tableName.length + newTableName.length][]; //create new array to store new data with length is the sum of the length of the new and old data
                    System.arraycopy(tableName, 0, newResult, 0, tableName.length); // copy old array into newest array for the first part
                    System.arraycopy(newTableName, 0, newResult, tableName.length, newTableName.length); // copy new array into the newest array for the second part of the array
                    tableName = newResult; //replace old array with the newest array for ease of coding

                    int[][] newVoteCount = new int[tableName.length][2]; //this step to make sure that the initial vote count is counted toward the final vote count
                    for (int j = 0; j < tableName.length; j++) { //create new votecount where old votecount is brought in and then replaced old array with the new array
                        if (voteCount[j][1] != 0)
                            newVoteCount[j][1] = voteCount[j][1];
                        newVoteCount[j][0] = Integer.parseInt(tableName[j][0]);
                        voteCount = newVoteCount;
                    }

                    break;
                case (4): // show the result 
                    System.out.printf("=======================================================\n");
                    System.out.printf("| %-8s | %-12s | %-3s | %18s |\n", "Position", "Votes/Ballots", "ID", "Name");
                    System.out.printf("=======================================================\n");
                    for (int i = 0; i < voteCount.length; i++) { // for loop goes through outside array
                        for (int j = 0; j < voteCount.length; j++) { // for loop goes through the inside array
                            int[] temp = new int[2]; // temp array to store for sorting
                            if (voteCount[i][1] > voteCount[j][1]) { // if first for loop index is greater than the second for loop index swap position (more votes go in front)
                                temp = voteCount[i];
                                voteCount[i] = voteCount[j];
                                voteCount[j] = temp;
                            }

                        }
                    }
                    for (int i = 0; i < voteCount.length; i++) { // print the result in order of greater to smaller
                        for (int j = 0; j < tableName.length; j++) {
                            if (voteCount[i][0] == Integer.parseInt(tableName[j][0])) {
                                String name = tableName[j][1];
                                System.out.printf("| %-8s | %-12s  | %-3s | %18s |\n", i + 1, voteCount[i][1],
                                        voteCount[i][0], name);
                                System.out.printf("-------------------------------------------------------\n");
                            }

                        }

                    }
                    break;

                default:
                    System.out.println("Please Try Again"); // Case for user enter input out of case
                    break;

            }

        }
        input.close();
    }
}
