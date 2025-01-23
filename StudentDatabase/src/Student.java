/*
 *  Program Author: Nicholas S. Blits
 *  Project Version: 1.1.2
 *  Current File: Student.java
 * 
 *  Description: This is a file used to create various Students for a database.
 */

// Start of Student.java

// A class for Objects of the Student type, which contains methods for getting and setting the fields typically associated with college students.
public class Student 
{
    // Each student has 4 fields:
    // A Name, which is a String
    // An ID, which is an Integer
    // A declared Major, which is a String
    // and a number of accumulated Credit Hours, which is an Integer

    private String Name;
    private int ID;
    private String Major;
    private int CreditHours;

    // A constructor for Student Objects
    // The constructor has 4 parameters, one for each of a Student's 4 fields.
    public Student(String Name, int ID, String Major, int CreditHours)
    {
        // Setting each field to a specific Student Object to the respective parameter's value.
        // Ex. The Name field (referred to through this.Name) is set to the value of the Name parameter for the method.
        this.Name = Name;
        this.ID = ID;
        this.Major = Major;
        this.CreditHours = CreditHours;
    }

    // Getters and setters for Student Objects
    // In this file, the order of methods goes as follows:
    // All getters are listed first, then the setters

    // Note: There is both a getter and setter for every single field that belongs to a Student Object.

    // Getters

    public String getName()
    {
        return this.Name;
    }

    public int getID()
    {
        return this.ID;
    }

    public String getMajor()
    {
        return this.Major;
    }

    public int getCreditHours()
    {
        return this.CreditHours;
    }

    // Setters

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setMajor(String Major)
    {
        this.Major = Major;
    }

    public void setCreditHours(int CreditHours)
    {
        this.CreditHours = CreditHours;
    }
}
// End of Student.java