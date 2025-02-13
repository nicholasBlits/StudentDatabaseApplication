# About this Project

## Using this Project

### How to Run the Program
This project was fully tested in Visual Studio Code, but should be compatible with Eclipse IDE as well. One of these two programs is recommended by the developer(s) for the best results on the execution side of things.

### Opening the Files of this Project
You will need to extract the contents of `StudentDatabaseApplication.zip` in order to use them.
To open them, however, they may be opened while still within the .zip folder.

## About the Files

### Main.java
`Main.java` only contains a main method, and just starts the execution of the program. 
It creates an object through the constructor found in `Program.java`, and `Program.java` handles the rest of the functionality of this program.

### Program.java
`Program.java` is the file that contains various methods for user interaction in this program.
The methods that add, edit, remove, and lsit student data are all found within this file.
`Program.java` creates a database through the use of an ArrayList called students, that is of type Student.
Anything created or done within `Progam.java` is erased when the program is ended or interrupted for any reason.

### Student.java
`Student.java` creates an outline of a typical college student.
Each student, which is then saved in the database created in `Program.java` has four main characteristics, or fields.
Those four fields are a name (Ex. Nicholas Blits), an ID number, a declared Major, and a total amount of earned credit hours.
The fields, as seen in `Student.java` have all been privated and given an accessor and mutator (or get and set) method to be used by other files, namely `Program.java`

# Credits

## Copyright Notice and Primary Development
All the code present in this project has been created by Nicholas S. Blits. 
There may be other authors/contributers involved with this project, but as of Version 1.1.2, only the author mentioned in this paragraph directly lead to the creation of this GitHub repository.

## Contact Information
All the contact information for the people associated with this program is listed below.
For any concerns, it is best to contact Nicholas S. Blits, as he is the person behind the innerworkings of this program as a whole, while Damian Marciniak helped fix a handful of errors as they arose.

### Nicholas S. Blits - Head Developer

Email: nicholasblits05@yahoo.com

LinkedIn: https://bit.ly/NBlitsLinkedIn