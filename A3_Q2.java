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
        Scanner input = new Scanner(System.in); //open scanner
        System.out.println("Welcome to the Simple Electronic Voting System (SEVS)" +
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "\nPlease enter a String collection of electoral candidates below: ");
        String candidatesData = input.nextLine().toUpperCase(); //take in user input and capitalize all letter
        String[] firstSplit = candidatesData.trim().split(";"); //take user input and split string at ";" and trim spaces before and after the input. After that store inside an array.
        String[][] tableName = new String[firstSplit.length][];
        for (int i = 0; i < firstSplit.length; i++) {
            String[] val = firstSplit[i].trim().split(",");
            tableName[i] = val;
        }
        int[][] voteCount = new int[tableName.length][2];
        for (int j = 0; j < tableName.length; j++) {
            voteCount[j][0] = Integer.parseInt(tableName[j][0]);
        }
        int choice = 1;

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

        while (choice != 0) {
            System.out.print("Enter a code, from the aforementioned, that corresponds to your task: ");
            choice = input.nextInt();
            switch (choice) {
                case (0):
                    System.out.println("\nThank you for using our Simple Electronic Voting System (SEVS).");
                    break;
                case (1): // Display Candidate
                    System.out.printf("========================================\n");
                    System.out.printf("| %-4s | %-2s  %25s |\n", "ID", ">>", "Candidate's Name");
                    System.out.printf("========================================\n");
                    for (int i = 0; i < tableName.length; i++) {
                        System.out.printf("| %-4s | %-2s  %25s |\n", tableName[i][0], ">>", tableName[i][1]);
                        System.out.printf("----------------------------------------\n");
                    }
                    break;

                case (2):
                    System.out.print("Please enter the ID of the candidate you wish to vote for: ");
                    int vote = input.nextInt();
                    for (int i = 0; i < voteCount.length; i++) {
                        if (voteCount[i][0] == vote) {
                            voteCount[i][1] += 1;
                        }
                    }
                    break;
                case (3):
                    System.out.println("Please enter a String collection of the NEW electoral candidates below: ");
                    input.nextLine();
                    String newCandidatesData = input.nextLine().toUpperCase();
                    String[] newFirstSplit = newCandidatesData.trim().split(";");
                    String[][] newTableName = new String[newFirstSplit.length][];
                    for (int i = 0; i < newFirstSplit.length; i++) {
                        String[] newVal = newFirstSplit[i].trim().split(",");
                        newTableName[i] = newVal;
                    }
                    String[][] newResult = new String[tableName.length + newTableName.length][];
                    System.arraycopy(tableName, 0, newResult, 0, tableName.length);
                    System.arraycopy(newTableName, 0, newResult, tableName.length, newTableName.length);
                    tableName = newResult;

                    int[][] newVoteCount = new int[tableName.length][2];
                    for (int j = 0; j < tableName.length; j++) {
                        if (voteCount[j][1] != 0)
                            newVoteCount[j][1] = voteCount[j][1];
                        newVoteCount[j][0] = Integer.parseInt(tableName[j][0]);
                        voteCount = newVoteCount;
                    }

                    break;
                case (4): 
                    System.out.printf("=======================================================\n");
                    System.out.printf("| %-8s | %-12s | %-3s | %18s |\n", "Position", "Votes/Ballots", "ID", "Name");
                    System.out.printf("=======================================================\n");
                    for (int i = 0; i < voteCount.length; i++) {
                        for (int j = 0; j < voteCount.length; j++) {
                            int[] temp = new int[2];
                            if (voteCount[i][1] > voteCount[j][1]) {
                                temp = voteCount[i];
                                voteCount[i] = voteCount[j];
                                voteCount[j] = temp;
                            }

                        }
                    }
                    for (int i = 0; i < voteCount.length; i++) {
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
                    System.out.println("Please Try Again"); // Case for user enter input out of case range.
                    break;

            }

        }
        input.close();
    }
}
