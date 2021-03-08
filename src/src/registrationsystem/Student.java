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


public class Student {
	
	//Declare private variables
	private String firstName, lastName, streetAddress, city, postalCode, courseCode;
	private int studentNumber;
	private LocalDate registrationDate, dateOfBirth;
	private boolean goodStanding = true;
	private boolean reinstateStatus = true;
	private ArrayList<String> listOfCourseCompleted = new ArrayList<>();
	private Course course;
	
	//[Test 1] [Test 7] Constructor with nine parameters with exception about a student's age
	public Student(String firstName,String lastName,String streetAddress,
					String city, String postalCode, String courseCode, 
					int studentNumber, LocalDate registrationDate, LocalDate dateOfBirth)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.courseCode = courseCode;
		this.studentNumber = studentNumber;
		this.registrationDate = registrationDate;
		this.dateOfBirth = dateOfBirth;
		
		if (100 <= getStudentAge())
		{
			throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
		}
	}

	//Getter variables for private variables
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getStudentAddress() {return this.streetAddress + " " + this.city + " " + this.postalCode;}
	public String getCourseCode() {return courseCode;}
	public int getStudentNumber() {return studentNumber;}	
	public LocalDate getStudentBirthday() {return dateOfBirth;}
	public boolean getGoodStanding() {return goodStanding;}
	public boolean getReinstateStatus() {return reinstateStatus;}
	
	
	//Setter methods for private variables
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
	public void setStudentNumber(int studentNumber) {this.studentNumber = studentNumber;}	
	
	
	/*
	[Test 1] method to return the basic student information as text
	@param -
	@return the following text
	 */
	public String toString() {return getFirstName() + " " + getLastName() + ", student number: " + getStudentNumber();}
	
	
	/*
	[Test 2] [Test 3] method to return a correct student's age
	@param -
	@return studentAge
	 */	
	public int getStudentAge() 
	{
		int studentAge = Period.between(getStudentBirthday(), LocalDate.now()).getYears();					
		if (LocalDate.now().getMonth() == getStudentBirthday().getMonth())
		{
			if (LocalDate.now().getDayOfMonth() < getStudentBirthday().getDayOfMonth()) 
			{
				studentAge--;
			}
		}
		return studentAge;
	}
	
	
	/*
	[Test 4] method to update a student address
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
	[Test 5] method to return if the student is in good standing
	@param  -
	@return goodStanding
	*/
	public boolean studentInGoodStanding(){return goodStanding;}


	/*
	[Test 6] method to change the goodStanding status from true to false for suspended students
	@param  -
	@return -
	*/
	public void suspendStudent(){this.goodStanding = false;}
	
	
	/*
	[Test 7] method to set a student's birthday with validation of if a student's age is over 100 years old
	@param  dateOfBirth
	@return -
	 */	
	public void setBirthday(LocalDate dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;			
	}
	

	/*
	[Test 8] method to return the year when a student enrolled in 
	@param  -
	@return year when a student enrolled in 
	*/
	public int getYearEnrolled() {return this.registrationDate.getYear();}

	
	
	/*
	[Test 25] method to change the reinstate status for returning student
	@param  -
	@return -
	 */	
	public void reinstateStudent(){this.reinstateStatus = true;}


	
	
	/*
	[Test 40] method to return the list completed so far
	@param  -
	@return listOfCourseCompleted
	 */		
	public ArrayList<String> getCoursesCompleted() {return listOfCourseCompleted;}
	
	
	
	/*
	[Test 45] [Test 47] [Test 48] method to add course if it is passed and the grade is between 0-100
	@param  courseCode, grade
	@return passed course info
	 */		
	public void addCompletedCourse(Course course, int grade) {
		if ((grade < 0) || (100 < grade))
		{
			throw new IllegalArgumentException("grade must be 0-100 inclusive");
		} else if (grade <= 50)
		{
			return;
		} else {
			this.listOfCourseCompleted.add(course.toString() + " grade=" + grade);
		}
	}

	
	
	/*
	[Test 46] method to return if a student passed a course
	@param  courseCode
	@return false,true
	 */		
	public boolean hasCompleted(String courseCode)
	{
		if (this.listOfCourseCompleted.indexOf(courseCode) == -1)
		{
			return false;
		} else {
			return true;
		}
	}
	
	
	
	
	
	
	
	
}
