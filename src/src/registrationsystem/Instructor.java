/*
Student Name: Yuriko Uchida
Student Number: #200448500
*/

//This class belongs to the following package.
package src.registrationsystem;

//Include libraries
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instructor {
	
	//Declare private variables
	private String firstName, lastName, streetAddress, city, postalCode;
	private int instructorNumber;
	private LocalDate registrationDate, dateOfBirth;
	protected Course course;
	ArrayList<String> listOfSubjects = new ArrayList<>();
	
	//[Test 9] [Test 19] Constructor with eight parameters with exception about a instructor's age and registration year
	public Instructor(String firstName,String lastName, int instructorNumber, String streetAddress, String city, String postalCode, 
					LocalDate registrationDate, LocalDate dateOfBirth)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.instructorNumber = instructorNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.registrationDate = registrationDate;
		this.dateOfBirth = dateOfBirth;
		
		if (80 <= noOfYearsAtCollege())
		{
			throw new IllegalArgumentException(getRegistrationDate() + " as a hire date would mean " + getFirstName() 
											+ " started working over 80 years ago");
		}
		
		if (100 <= getAgeInYears())
		{
			throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old\"");
		}
		
	}

	//Getter variables for private variables
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public int getInstructorNumber() {return instructorNumber;}	
	public LocalDate getRegistrationDate() {return registrationDate;}	
	public LocalDate getInstructorBirthday() {return dateOfBirth;}

	//Setter methods for private variables
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setInstructorNumber(int instructorNumber) {this.instructorNumber = instructorNumber;}	
	
	
	
	/*
	[Test 9]  method to return the instructor's full name as text
	@param -
	@return the following text
	 */
	public String toString() {return getFirstName() + " " + getLastName();}
	
	
	/*
	[Test 10] method to return the instructor's age
	@param -
	@return ageInYears
	 */
	public int getAgeInYears() 
	{
		int ageInYears = Period.between(getInstructorBirthday(), LocalDate.now()).getYears();					
		if (LocalDate.now().getMonth() == getInstructorBirthday().getMonth())
		{
			if (LocalDate.now().getDayOfMonth() < getInstructorBirthday().getDayOfMonth()) 
			{
				ageInYears--;
			}
		}
		return ageInYears;
	}	
	
	
	/*
	[Test 11] method to return the years instructor has been at the college
	[Test 20] validate the method if to return the years instructor has been at the college
	@param -
	@return yearsAtCollege
	 */
	public int noOfYearsAtCollege() 
	{
		int yearsAtCollege = Period.between(getRegistrationDate(), LocalDate.now()).getYears();					
		if (LocalDate.now().getMonth() == getRegistrationDate().getMonth())
		{
			if (LocalDate.now().getDayOfMonth() < getRegistrationDate().getDayOfMonth()) 
			{
				yearsAtCollege--;
			}
		}
		return yearsAtCollege;
	}	
	
	
	/*
	[Test 12] method to return an instructor's address
	@param -
	@return the instructor's full address
	 */
	public String getInstructorAddress() {return this.streetAddress + ", " + this.city + ", " + this.postalCode;}

	
	/*
	[Test 13] method to update an instructor's address
	@param  streetAddress, city, postalCode
	@return -
	*/
	public void changeAddress(String newStreetAddress, String newCity, String newPostalCode) 
	{
		this.streetAddress = newStreetAddress;
		this.city = newCity;
		this.postalCode = newPostalCode;
	}
	
	
	/*
	[Test 14] method to return the subjects list an instructor can teach
	@param  -
	@return the subjects list with string type
	*/
	public String listOfSubjectsCertifiedToTeach() 
	{
		if (this.listOfSubjects.isEmpty() == true) 
		{
			return "not qualified to teach courses yet.";
		} else {
			return this.listOfSubjects.toString();			
		}
	}
	
	
	
	/*
	[Test 15] [Test 18] [Test 34] method to add a course to the above subject list 
	@param  courseCode
	@return -
	*/
	public void addCourseToInstructorAbilities(String courseCode)
	{
		if (this.listOfSubjects == null)
		{
			this.listOfSubjects.add(courseCode);
		} else {
			if (this.listOfSubjects.indexOf(courseCode) != -1)
			{
				return;
			} else {
				this.listOfSubjects.add(courseCode);
			}
		}
	}

	
	/*
	[Test 16] [Test 17] method to return if a instructor can teach a specific course 
	@param  courseToCheck
	@return true, false
	*/
	public Boolean instructorCanTeach(String courseToCheck) {
		if (this.listOfSubjects == null)
		{
			return false;
		} else {
			if (this.listOfSubjects.indexOf(courseToCheck) == -1)
			{
				return false;
			} else {
				return true;
			}
		}
	}

	
}
