/*
 *  Program Author: Nicholas S. Blits
 *  Project Version: 1.1.2
 *  Current File: Program.java
 * 
 *  Description: This file initializes a Console Application that allows a user to create and enter students into a database. 
 * 
 *  Note: This database is only accessible during the program's execution. Terminating the program makes the database empty again.
 */

 // Start of Program.java

 // Importing the Scanner and ArrayList Objects into the file
 // The database is stored using an ArrayList, and each item in the ArrayList is given all required data through the use of the Scanner Object
import java.util.Scanner;
import java.util.ArrayList;

// The class that contains all the functionalities for the project
public class Program 
{
    // Initializing a Scanner Object in order to process a user's inputs
    private Scanner sc = new Scanner(System.in);

    // Creating an ArrayList of type Student to use as the database of the project.
    private ArrayList<Student> students = new ArrayList<>();

    // A constructor for objects of type Program
    // This constructor initializes the rest of the processes present in this file
    public Program()
    {
        // Calling the loadProgram() method
        // This function uses no parameters, as its sole purpose is to start the interface-related side of the program.
        loadProgram();
    }

    // The main functioning aspect of this program
    // This method calls for the creation of the text prompts the user gives responses to. (Ex. asking the user for an option on what to do next)
    private void loadProgram()
    {
        // Call the method that introduces the user to the database program.
        welcomeUser(); 

        // A while loop that runs until the program is manually exited, either through the option the user is informed of or terminating the program through closing a software/terminal. (ex. Visual Studio Code)
            while (true)
            {
                printOptions(); // Print out all of the user's available actions to their screen
                int userSelection = getOption(); // Store the user's selected option (returned by getOption()) in a variable to then use to switch between different actions in the program.

                    switch (userSelection) // A switch statement used to differentiate different options as selected by the user
                    {
                        case 1:
                            addStudent(); // Calling the addStudent() method if the user enters in a 1.
                            break;

                        case 2:
                            editStudent(); // Calling the editStudent() method if the user enters in a 2.
                            break;

                        case 3:
                            deleteStudent(); // Calling the deleteStudent() method if the user enters in a 3.
                            break;

                        case 4:
                            displayStudentInformation(); // Calling the displayStudentInformation() method if the user enters in a 4.
                            break;

                        case 5:
                            listAll(); // Calling the listAll() method if the user enters in a 5.
                            break;

                        default: // If the user does not enter a valid input (such as a 7), end the program's execution
                            // Informing the user that they have chosen to exit the program
                            System.out.print("Goodbye, user! Have a wonderful day!");
                            System.exit(0); // Terminate program
                            // No break statement is required for the default section of this switch statement as the program ends execution when System.exit() is called
                    }
            }

    }

    // The next 3 methods in this file all print out information to the user

    // A method that outputs a small welcome message and some basic information to the user
    private void welcomeUser()
    {
        System.out.println("Hello user! Welcome to my program!"); // Welcoming the user
        System.out.println(); // Create a space between the information and the information about the program
        System.out.println("Information: "); // Creating a header for the information about the program the user is shown
        System.out.println("Program Created by: Nicholas S. Blits"); // Printing out the program's author's name to the user's screen
        System.out.println(); // Creating a space between the above welcome message and program information
    }

    // A method that displays the options used in this program to the user
    // This method uses System.out.println() methods to accomplish this
    private void printOptions()
    {
        // Creating a buffer between any previously printed information and the list of user options
        System.out.println("-------------------------------");

        System.out.println("Options: "); // Creating a header separating the options from other pieces of printed information.
        System.out.println(); // Creating a space between the header and the actual options the user can select from.

        // Printing out all the possible options the user can select
        // The options include adding a student to the database, editing a student's information, deleting a student's record, listing out a student's information, listing out the information of every student , and exiting/terminating the program
        // All of the options are accessed by having the user entered the number associated with it
        System.out.println("1. Create New Student"); 
        System.out.println("2. Edit Student Information");
        System.out.println("3. Delete Student Information");
        System.out.println("4. List Student Information");
        System.out.println("5. List All Registered Students' Information");
        System.out.println("6. Exit Program");
    }

    // A method that obtains and returns the number that relates to the option they wished to select
    private int getOption()
    {
        System.out.println(); // Creating a space between all previously printed information and the prompt telling the user to make a selection
        System.out.print("Please make a selection from the options provided using its corresponding number: "); // Prompting the user to make a selection from the previously printed input options using the listed number
        
        int answer = sc.nextInt(); // Storing the user input in a variable called answer
        // Return the user's selected number
        return answer;
    }

    // The remaining methods in this file add the functionalities listed in the printOptions() method to the program.

    // This method creates a new Student object and adds them to the students ArrayList made earlier in this file.
    // All information for the Student object is retrieved through prompts to and responses from the user.
    private void addStudent()
    {
        // Asking the user for the first name of the student and storing it in the studentFirstName variable
        System.out.print("Please enter the student's first name: ");
        String studentFirstName = sc.next();

        // Asking the user for the last name of the student and storing it in the studentLastName variable
        System.out.print("Please enter the student's last name: ");
        String studentLastName = sc.next();

        // Creating a singular String for the student's full name
        // This is done through adding the studentFirstName and studentLastName variables to the same String, separated by a space
        String studentName = studentFirstName + " " + studentLastName;

        // Asking the user for the ID Number of the student and storing it in the studentID variable.
        System.out.print("Please enter the student's ID Number: ");
        int studentID = sc.nextInt();

        // Iterating through the students ArrayList to confirm if the value of studentID has been previously entered into the database.
        for (int i = 0; i < students.size(); i++) // A standard for-loop, using the size of the students ArrayList as the limit of iterations
        {
            // Creating a variable to store the current student being looked at
            // This is done to simplify the if statement comparing the user-entered data and the ID currently being compared to that data.
            Student enrolledStudent = students.get(i); 

            if (enrolledStudent.getID() == studentID) // Checking if the student ID is unique
            {
                // If true, inform the user that they cannot reuse that ID value
                System.out.println("A student with the ID Number " + studentID + " has already been entered into the database."); // Warning the user that a student with the ID entered already exists.

                // Prompting the user to enter in a new value for the student's ID Number and reassigning studentID so that it updates as appropriate.
                System.out.print("Enter a new student ID number: "); 
                studentID = sc.nextInt();
            }
        }

        // Removing an extra character stored by the sc.nextLine() method by calling that method again
        sc.nextLine();

        // Asking the user for the stduent's major and storing the user's input in the studentMajor variable.
        System.out.print("Please enter the student's major: ");
        String studentMajor = sc.nextLine();


        System.out.print("Please enter the student's currently accumulated credit hours: ");
        int studentCreditHours = sc.nextInt();

        // Creating a Student Object with the data gathered from the above prompts
        Student student = new Student(studentName, studentID, studentMajor, studentCreditHours);
        // Adding the newly created Student object to the students ArrayList
        students.add(student);

        // Tell the user that the student was added to the ArrayList
        System.out.println("The newly created student was successfully added to the database.");
    }

    // A method that allows a user to edit the information of a single student without comprising the data in the entire database
    // The students are located by using their full name as a "key" of sorts
    // This method does not account for 2 students that have the same name, and this method would default to editing the information of the FIRST student created with some name
    private void editStudent()
    {
        if (students.size() > 0) // Check that there is at least 1 student entered into the database
        {
            sc.nextLine(); // Removing an extra input stored from the Integer input used to access this method

            // Prompt the user to enter the full name of the student whose information they wish to edit
            // Store the user's input in the studentToEdit variable
            System.out.print("Please enter the full name of the student whose data you wish to edit: ");
            String studentToEdit = sc.nextLine();

            // Creating a boolean used to indicate that the desired student was found in the database.
            // It is initially false as the database has not been checked at this point in this method's execution
            boolean found = false;

            // Using a for-each loop to iterate through the ArrayList called students
            for (Student newStudent : students)
            {
                if (newStudent.getName().equals(studentToEdit)) // Checking if the current student's name matches the name the user was looking for
                {
                    // When the student is found, set the boolean variable found equal to true
                    found = true;

                    // Ask the user what information about the student they wish to edit
                    // This printed message also tells the user what their options are. These options match the switch statement found after this prompt.
                    // Store the user's input in the dataToEdit variable.
                    System.out.print("What information do you wish to edit? (Full Name, ID Number, Major, or Credit Hours are your options): ");
                    String dataToEdit = sc.nextLine();

                    // A switch statement to cause different prompts to appear on the user's screen based on what they enter
                    // The inout stored in the dataToEdit variable is set to be completely lowercase, to avoid as much user error as possible
                    switch (dataToEdit.toLowerCase()) 
                    {
                        case "full name": // The case where the user wishes to edit the student's full name

                            // Ask the user for the new name of student and store it in the newName variable
                            System.out.print("Please enter the name to change the student's name to: ");
                            String newName = sc.nextLine();

                            // Call the setName method on the current student, passing in the new name the user entered for the new value of the student's name
                            newStudent.setName(newName);

                            // Inform the user that the name of the student was succesfully changed in the database.
                            System.out.println("The student's full name was edited successfully.");
                            
                            break;

                        case "id number": // The case where the user wants to edit the student's ID Number

                            // Ask the user what they wish to change the student's ID to and store their input in the newIDNumber variable.
                            System.out.print("Please enter the new ID Number for the student: ");
                            int newIDNumber = sc.nextInt();

                            // Call the setID method on the student, passing in the newIDNumber variable as the parameter to chahge the student's ID Number to
                            newStudent.setID(newIDNumber);

                            // Inform the user that the ID Number of the desired student was properly changed.
                            System.out.println("The student's ID number was changed successfully.");

                            // Remove any extra characters left over from previous inputs of this case
                            sc.nextLine();
                            break;

                        case "major": // The case that the user wishes to change the student's major

                            // Ask the user for the new major of the current student and store the new major in the newMajor variable.
                            System.out.print("Please enter in the student's major: ");
                            String newMajor = sc.nextLine();

                            // Change the student's major through the setMajor method, using the newMajor variable's value for the method's parameter.
                            newStudent.setMajor(newMajor);

                            // Inform the user that they have updated the student's major successfully.
                            System.out.println("The student's major was edited successfully.");
                            break;

                        case "credit hours": // The case that the user wishes to change the number of credit hours recorded for the student.

                            // Ask the user for a new number of credit hours to store with the rest of the student's information.
                            System.out.print("Please enter a number to replace the student's credit hours with: ");
                            int newCreditHours = sc.nextInt(); // Store the input gathered by the user in the newCreditHours variable.

                            // Change the number of credit hours on record using the setCreditHours method, passing in the newCreditHours variable to be used for the method' parameter.
                            newStudent.setCreditHours(newCreditHours);

                            // Tell the user that the student's credit hours have been properly updated inside of the database.
                            System.out.println("The student's credit hours have been changed successfully.");

                            // Remove any extra keystrokes recorded by the Scanner object (sc)
                            sc.nextLine();
                            break;
                        default: // A case for when the user enters an invalid String (ex. "Courses")

                            // Inform the user that the String they entered is not a field in the database.
                            System.out.println("Invalid data type entered. Please enter all appropriate information again.");

                            // Call the editStudent() method again and restart the process of finding the student's name in the students ArrayList.
                            editStudent();
                            break;
                    }
                }
            }

            if (!found) // Code to execute if the user enters a name that is not currently registered in the database.
            {
                // Inform the user that the name they were looking for could not be found within the database.
                System.out.println("A student with the name " + studentToEdit + " was not found in the database.");
            }
        }
        else // The user has not entered any students into the database (or removed all previously entered students).
        {
            // Inform the user that they cannot edit data for a student that does not exist.
            System.out.println("A student must be added to the database before any information may be edited.");
        }
    }

    // A method for deleting students from the database
    // Students are located by searching for their full name in the database
    // There is currently no way of handling the instance where the user enters the same name twice implemented in this method
    private void deleteStudent()
    {
        if (students.size() > 0) // Check that at least 1 student has been entered into the database.
        {
            // Remove any remaining characters from a previous user input through sc.nextLine()
            sc.nextLine();

            // Ask the user for the full name of the student they wish to delete and store the value in the studentToDelete variable. 
            System.out.print("What is the full name of the student you wish to delete from the database?: ");
            String studentToDelete = sc.nextLine();

            // Creating a boolean variable to track whether or not the student the user wishes to delete was entered into the database.
            // This boolean variable (studentFound) is initialially set equal to false, as no entries in the database have been checked at this point in this method's execution.
            boolean studentFound = false;

            for (int i = 0; i < students.size(); i++) // A for-loop used to iterate through and search for the desired student's name
            {
                Student comparisonStudent = students.get(i); // Creating a new Student object to simplify the following if statement
                if (comparisonStudent.getName().equals(studentToDelete)) // Check if the name of the current Student is equal to the name the user entered previously in this method
                {
                    // If the names match, set the studentFound variable's value to true.
                    studentFound = true;

                    // Prompt the user asking if they are certain they wish to remove the user that was found
                    // Uses an integer for the user's input to simplify user input
                    System.out.print("Are you sure you want to delete this student's information? (1 for Yes, 2 for No): ");
                    int input = sc.nextInt();

                    if (input == 1) // Check if the user entered a 1
                    {
                        // When true, remove the student from the students ArrayList 
                        students.remove(comparisonStudent);

                        // Inform the user that the student was successfully removed from the database.
                        System.out.println("The student was removed from the database succesfully.");
                        break;
                    }
                    else
                    {
                        // Inform the user that they chose to keep the student in the student database.
                        System.out.println("You have chosen NOT to remove the student from the database.");
                    }
                }
            }

            if (!studentFound) // Check if the studentFound variable is still equal to false.
            {
                // Tell the user that there was no student registered in the database with the name they entered.
                System.out.println("A student with the name " + studentToDelete + " was not found in the database.");
            }
        }
        else // Code for when the user wishes to delete a student without having previously entered in the information for at least1.
        {
            // Print out an error message to the user saying that no students have been registered in the database currently, so none can be deleted.
            System.out.println("A student must be added to the database before a student can be deleted.");
        }
    }

    // A method to display the information of a singular student
    // This method finds the student to print out the information of through searching for their full name
    // This method assumes that all names in the ArrayList of Student objects are unique
    private void displayStudentInformation()
    {
        if (students.size() > 0) // Check that there is 1 or more students registered into the database.
        {
            sc.nextLine(); // Remove any leftover inputs from another instance of user input.

            // Ask the user for the full name of the student whose information they wish to view and store their response in the studentToView variable.
            System.out.print("Please enter the full name of student you wish to display the information of: ");
            String studentToView = sc.nextLine();

            // Track if the student with the name entered by the user has been found in the database.
            // This is done through a boolean variable called studentExists. It is intially false because no students have been compared to the desired name at this point in this method.
            boolean studentExists = false;

            // A for-each loop used to check the name of every student in the students ArrayList
            for (Student student : students)
            {
                if (student.getName().equals(studentToView)) // Check if the name of the current student matches the name the user is looking for
                {
                    // When the student's name is found in the database, set the studentExists variable's value to true
                    studentExists = true;

                    // Print out all the information of the student
                    // The information is printed out on individual lines using formatted sentences
                    System.out.println("The student's name is " + student.getName() + ".");
                    System.out.println("The student is registered with the ID number " + student.getID() + ".");
                    System.out.println("The student is pursuing a degree in " + student.getMajor() + ".");
                    System.out.println("The student has " + student.getCreditHours() + " credit hours on record.");
                }
            }

            if (!studentExists) // Check if the name entered by the user was never found in the students ArrayList
            {
                // Tell the user that no student with the name they entered was found in the database.
                System.out.println("No student with the name " + studentToView + " exists inside the database.");
            }
        }
        else // Reaching this code indicates that a user tried to view a student's information before any students have been added to the database.
        {
            // Tell the user that they must add a student to the database before their data could be viewed.
            System.out.println("No students have been entered into the database.");
        }
    }

    // A method for printing out the information of every student currently registered in the student database.
    private void listAll()
    {
        if (students.size() > 0) // Check that there is at least 1 student registered to the database.
        {
            // Print a message indicating the information is being printed to the console/terminal
            System.out.println("Printing out all students' information...");

            // Print column headers for the student information
            // Uses a specific formatting based on sample data used in the debugging of this project.
            System.out.printf("%-20s %-20s %-16s %-23s %n", "Full Name:", "ID Number:", "Major:", "Credit Hours:");
            System.out.printf("%-20s %-20s %-16s %-23s %n", "----------", "----------", "------", "-------------");

            // Loop through the ArrayList of Student objects
            for (int i = 0; i < students.size(); i++)
            {
                // Create a variable for the current student to simplify the print statements that deal with student data
                Student newStudent = students.get(i);

                // Create a float variable that takes in the student's current credit hours
                // Credit hours are saved as an integer
                // The value from newStudent.getCreditHours() is then cast as a float
                float newStudentCredits = (float)newStudent.getCreditHours();
                
                // Print out the student's information, only moving to a new line after ALL of the student's information has been printed to the screen
                System.out.printf("%-25s", newStudent.getName());
                System.out.printf("%-18d", newStudent.getID());
                System.out.printf("%-18s", newStudent.getMajor());
                System.out.printf("%-12.2f %n", newStudentCredits);
            }
        }
        else // Code reached when no students were added to the database
        {
            // A prompt informing the user that the ArrayList students has yet to have been populated with any Student objects.
            System.out.println("No students have been entered into the database.");
        }
    }
}
// End of Program.java