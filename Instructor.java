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
	
	//Declare variables
	private String firstName, lastName, streetAddress, city, postalCode;
	private int instructorNumber;
	private LocalDate registrationDate, dateOfBirth;

	//Create an ArrayList object, called "listOfSubjects"
	private List<String> listOfSubjects = new ArrayList<>();
	
	
	
	//[Test 9] [Test 19] [Test 20] Constructor with exception about a instructor's age and registration year
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
		
		//Validate if a instructor has been at the school over 80 years
		if (80 <= noOfYearsAtCollege())
		{
			throw new IllegalArgumentException(getRegistrationDate() + " as a hire date would mean " + getFirstName() 
											+ " started working over 80 years ago");
		}
		
		//Validate if a instructor is over 100 years old
		if (100 <= getAgeInYears())
		{
			throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
		}
		
	}//The end of the constructor
		
	

	//Getter methods for private variables
	
	/*
	Getter method to return a first name
	@param -
	@return firstname
	 */
	public String getFirstName() {return firstName;}

	/*
	Getter method to return a last name
	@param -
	@return lastname
	 */
	public String getLastName() {return lastName;}

	/*
	Getter method to return an instructor number
	@param -
	@return instructorNumber
	 */	
	public int getInstructorNumber() {return instructorNumber;}	
	
	/*
	Getter method to return the date when an instructor was registered
	@param -
	@return registrationDate
	 */	
	public LocalDate getRegistrationDate() {return registrationDate;}	
	
	/*
	Getter method to return an instructor's birthday
	@param -
	@return dateOfBirth
	 */	
	public LocalDate getInstructorBirthday() {return dateOfBirth;}

	
	//Setter methods for private variables

	/*
	Setter method to set an instructor's first name
	@param firstName
	@return -
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	/*
	Setter method to set a instructor's last name
	@param lastName
	@return -
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}

	/*
	Setter method to set an instructor number
	@param instructorNumber
	@return -
	 */
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
			if (getInstructorBirthday().getDayOfMonth() < LocalDate.now().getDayOfMonth()) 
			{
				ageInYears--;
			}
		}
		return ageInYears;
	}	
	
	
	/*
	[Test 11] method to return the years instructor has been at the college
	@param -
	@return yearsAtCollege
	 */
	public int noOfYearsAtCollege() 
	{
		int yearsAtCollege = Period.between(getRegistrationDate(), LocalDate.now()).getYears();					
		if (LocalDate.now().getMonth() == getRegistrationDate().getMonth())
		{
			if (getRegistrationDate().getDayOfMonth() < LocalDate.now().getDayOfMonth()) 
			{
				yearsAtCollege--;
			}
		}
		return yearsAtCollege;
	}	
	
	
	/*
	[Test 12] method to return an instructor's address as text
	@param -
	@return the instructor's full address
	 */
	public String getInstructorAddress() {return this.streetAddress + ", " + this.city + ", " + this.postalCode;}

	
	/*
	[Test 13] method to update an instructor's address
	@param  newStreetAddress, newCity, newPostalCode
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
		if (this.listOfSubjects.isEmpty()) 
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
		if (!instructorCanTeach(courseCode))
		{
			this.listOfSubjects.add(courseCode);
		}
	}

	
	/*
	[Test 16] [Test 17] method to return if a instructor can teach a specific course 
	@param  courseToCheck
	@return true, false
	*/
	public boolean instructorCanTeach(String courseToCheck) 
	{
		for(int i = 0; i < this.listOfSubjects.size(); i++)
		{
			if (this.listOfSubjects.get(i).equals(courseToCheck))
			{
				return true;
			}
		}
		return false;
	}

	
}//The end of Instructor class