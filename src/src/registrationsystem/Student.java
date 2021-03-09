/*
Student Name: Yuriko Uchida
Student Number: #200448500
 */

//This class belongs to the following package
package src.registrationsystem;

//Include libraries
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Student {
	
	//Declare variables
	private String firstName, lastName, streetAddress, city, postalCode, courseCode;
	private int studentNumber, grade;
	private LocalDate registrationDate, dateOfBirth;
	private boolean goodStanding, reinstateStatus;
	
	//Create an ArrayList object, called "listOfCourseCompleted"
	private List<String> listOfCourseCompleted = new ArrayList<>();
	
	
	
	//[Test 1] [Test 7] Constructor with exception about a student's age
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
		this.goodStanding = true;
		this.reinstateStatus = true;
		
		
		//Validate if a student is over 100 years old
		if (100 <= getStudentAge())
		{
			throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
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
	Getter method to return student's full address as text
	@param -
	@return student's full address
	 */
	public String getStudentAddress() {return this.streetAddress + " " + this.city + " " + this.postalCode;}

	/*
	Getter method to return courseCode
	@param -
	@return courseCode
	 */
	public String getCourseCode() {return courseCode;}
	
	/*
	Getter method to return a student number
	@param -
	@return studentNumber
	 */
	public int getStudentNumber() {return studentNumber;}	
	
	/*
	Getter method to return a student's birthday
	@param -
	@return dateOfBirth
	 */
	public LocalDate getStudentBirthday() {return dateOfBirth;}
	
	/*
	Getter method to return if a student is in good standing
	@param -
	@return goodStanding, which is a variable to store true or false depends on a student's good standing status
	 */
	public boolean getGoodStanding() {return goodStanding;}

	/*
	Getter method to return if a student is a returning student
	@param -
	@return reinstateStatus, which is a variable to store true or false depends on a student is a returning student
	 */
	public boolean getReinstateStatus() {return reinstateStatus;}
	
	/*
	Getter method to return a grade
	@param -
	@return grade
	 */
	public int getGrade() {return grade;}
	
	
	

	//Setter methods for private variables
	
	/*
	Setter method to set an instructor's first name
	@param firstName
	@return -
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}

	/*
	Setter method to set a student's last name
	@param lastName
	@return -
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}

	/*
	Setter method to set a course code
	@param courseCode
	@return -
	 */
	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
	
	/*
	Setter method to set a student number
	@param studentNumber
	@return -
	 */
	public void setStudentNumber(int studentNumber) {this.studentNumber = studentNumber;}	

	/*
	Setter method to set a student's birthday
	@param dateOfBirth
	@return -
	 */
	public void setBirthday(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

	/*
	Setter method to set a grade
	@param grade
	@return -
	 */
	public void setGrade(int grade) {this.grade = grade;}

	
	
	/*
	[Test 1] method to return the basic student information as text
	@param -
	@return the following basic student info
	 */
	public String toString() {return getFirstName() + " " + getLastName() + ", student number: " + getStudentNumber();}
	
	
	/*
	[Test 2] [Test 3] method to return a student's age
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
	[Test 5] method to return if the student is in good standing
	@param  -
	@return goodStanding, which is a variable to store true or false depends on the student's standing status
	*/
	public boolean studentInGoodStanding(){return goodStanding;}


	/*
	[Test 6] method to change the goodStanding status from true to false for suspended students
	@param  -
	@return -
	*/
	public void suspendStudent(){this.goodStanding = false;}
	
	

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
	public String getCoursesCompleted() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < this.listOfCourseCompleted.size(); i++)
		{
			if (0 < i)
			{
				sb.append(", ");
			}
			sb.append(this.listOfCourseCompleted.get(i));
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	/*
	[Test 45] [Test 47] [Test 48] method to add course if it is passed and the grade is between 0-100
	-If a grade is not between 0-100, the error will be printed
	-If a student did not pass the course, nothing happens
	-Otherwise, the grade and the course name will be added to the list
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
			this.listOfCourseCompleted.add(new String(course.toString() + " grade=" + grade));
		}
	}

	
	
	/*
	[Test 46] method to return if a student passed a course
	-If a student has completed the course, return true
	-Otherwise, return false
	@param  courseCode
	@return false,true
	 */		
	public boolean hasCompleted(String courseCode)
	{
		for (String course: this.listOfCourseCompleted)
		{
			if (course.contains(courseCode))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
}//The end of Student class
