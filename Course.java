/*
Student Name: Yuriko Uchida
Student Number: #200448500
 */

//This class belongs to the following package.
package src.registrationsystem;

//Include libraries
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Course {

	//Declare variables
	private String courseCode, courseTitle, classRoom, prerequisite, addedStudent;
	private DayOfWeek dayCourseIsScheduled;
	private LocalTime timeCourseIsScheduled, courseCanStart, courseCanEndBy;
	private int credit, classSize;

	//Create an ArrayList object, called "listOfStudents"
	private List<Student> listOfStudents = new ArrayList<>();

	//Create an Instructor class's object, and a Student class's object
	private Instructor instructor;
	private Student student;
	
	
	//[Test 21] [Test 33] [Test 29] [Test 30] 
	//Constructor with exception about if a professor can teach a course, and if the schedule is acceptable
	public Course(Instructor instructor, String courseCode, String courseTitle, String classRoom, 
					DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit)
	{
		this.instructor = instructor;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.classRoom = classRoom;
		this.dayCourseIsScheduled = dayCourseIsScheduled;
		this.timeCourseIsScheduled = timeCourseIsScheduled;
		this.credit = credit;
		this.classSize = 2;
		this.courseCanStart = LocalTime.of(8,00);
		this.courseCanEndBy = LocalTime.of(18,00);
		
		//Validate if a professor can teach a course
		if (!instructor.instructorCanTeach(courseCode))
		{
			throw new IllegalArgumentException("Professor " + instructor.getFirstName() + " " + instructor.getLastName()
												+ " is not qualified to teach " + courseCode);
		} 
		
		//Validate if the schedule is valid	
		if (this.timeCourseIsScheduled.isBefore(courseCanStart) || this.timeCourseIsScheduled.isAfter(courseCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("Course start time must be between 08:00-18:00");
		}
	}//The end of the constructor

	
	
	//[Test 41] Another constructor including both validation and prerequisite
	public Course(Instructor instructor, String courseCode, String courseTitle, String classRoom, 
			DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, String prerequisite)
	{

		//Call the first constructor
		this(instructor, courseCode, courseTitle, classRoom, dayCourseIsScheduled, timeCourseIsScheduled, credit);
		this.prerequisite = prerequisite;
		this.classSize = 40;
		this.courseCanStart = LocalTime.of(8,00);
		this.courseCanEndBy = LocalTime.of(18,00);

		//Validate if a professor can teach a course
		if (!instructor.instructorCanTeach(courseCode))
		{
			throw new IllegalArgumentException("Professor " + instructor.getFirstName() + " " + instructor.getLastName()
												+ " is not qualified to teach " + courseCode);
		} 
		
		//Validate if the schedule is valid	
		if (this.timeCourseIsScheduled.isBefore(courseCanStart) || this.timeCourseIsScheduled.isAfter(courseCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("Course start time must be between 08:00-18:00");
		}
	}//The end of the constructor
	
	
	
	
	//Getter methods for private variables
	
	/*
	Getter method to return a course code
	@param -
	@return courseCode
	 */
	public String getCourseCode() {return courseCode;}

	/*
	Getter method to return a course title
	@param -
	@return courseTitle
	 */	
	public String getCourseTitle() {return courseTitle;}

	/*
	Getter method to return a course's credit
	@param -
	@return credit
	 */
	public int getCredit() {return credit;}	


	//Setter methods for private variables
	
	/*
	Setter method to set a course code
	@param courseCode
	@return -
	 */
	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
	
	/*
	Setter method to set a course title
	@param courseTitle
	@return -
	 */
	public void setCourseTitle(String courseTitle) {this.courseTitle = courseTitle;}
	
	/*
	Setter method to set a class room
	@param classRoom
	@return -
	 */
	public void setClassRoom(String classRoom) {this.classRoom = classRoom;}
	
	/*
	Setter method to set the date when the class is scheduled
	@param dayCourseIsScheduled
	@return -
	 */
	public void setDayCourseIsScheduled(DayOfWeek dayCourseIsScheduled) {this.dayCourseIsScheduled = dayCourseIsScheduled;}	
	
	/*
	Setter method to set a course credit
	@param credit
	@return -
	 */
	public void setCredit(int credit) {this.credit = credit;}		

	/*
	Setter method to set a course's prerequisite
	@param prerequisite
	@return -
	 */
	public void setPrerequisite(String prerequisite) {this.prerequisite = prerequisite;}		

	
	/*
	[Test 21] method to return the course code and course title as text
	@param -
	@return the course code and title
	 */
	public String toString() {return getCourseCode() + "-" + getCourseTitle();}
	
	
	/*
	[Test 22] method to return the class room
	@param  -
	@return classRoom
	 */
	public String getClassRoom() {return classRoom;}
	
	
	/*
	[Test 23] method to return the time when the course is scheduled
	@param  -
	@return the course date and time
	 */	
	public String getCourseDayAndTime() {return this.dayCourseIsScheduled + "'s, starting at " + this.timeCourseIsScheduled;}
	
	
	/*
	[Test 24] method to return the instructor's full name
	@param  -
	@return the instructor's full name
	 */	
	public Instructor getInstructorToTeach() {return instructor;}

	
	
	/*
	[Test 25] [Test 26] [Test 27] [Test 42] [Test 44] method to add a student info who takes the course up to the maximum number of students
	-If a student is not in good standing, he/she will fail to register the course
	-If the course is full, the error will be printed
	-If a student did not pass prerequisite, he/she will fail to register the course
	@param  a student object
	@return the proper message depends on the adding condition
	 */	
	public String addStudent(Student student) {
	
		if (checkPrerequisite() != null) 
		{
			if (student.getCoursesCompleted().contains(checkPrerequisite()) == false)
			{
				return "Student has not completed the prerequisite course: " + checkPrerequisite();			
			} 			
		} else if (student.getGoodStanding() == false) 
		{
			return "The Student is not in good standing and cannot join the course.";
		} else if (getClassSize() <= this.listOfStudents.size())
		{
			return "Student was not added because the course is full";
		} 
		this.listOfStudents.add(student);
		return "";
	}

	
	
	/*
	[Test 25] method to return a students list who takes the course
	@param  -
	@return Student's toString()
	 */	
	public String displayTheClassList()
	{
		if (this.listOfStudents.isEmpty())
		{
			return "";
		} 
		return this.listOfStudents.get(this.listOfStudents.size() - 1).toString();
	}
	
	

	/*
	[Test 28] method to set the maximum number of students per class
	@param  classSize
	@return the message that says the max number of students
	 */	
	public String setClassSize(int classSize)
	{
		if (40 < classSize)
		{
			this.classSize = 40;
			return "Max class size = 40, it has been set to 40";
		} 
		this.classSize = classSize;
		return "";
	}
	
	

	/*
	[Test 28] method to return the maximum number of students per class
	@param  -
	@return classSize
	 */	
	public int getClassSize() {return classSize;}
	
	

	/*
	[Test 31] [Test 32] method to return if the class is a mature class
	@param  -
	@return true, false
	 */		
	public boolean matureClass() 
	{
		boolean mature;
		int sumOfAge = 0;
		int aveOfAge = 0;

		//Adding all students' age and calculate the average age of the class
		for(int i = 0; i < this.listOfStudents.size(); i++)
		{
			sumOfAge += this.listOfStudents.get(i).getStudentAge();
		}
		aveOfAge = sumOfAge / this.listOfStudents.size();

		//If the average age is over 25, it's a mature class, then return true. Otherwise, return false.
		if (25 < aveOfAge)
		{
			mature = true;
		} else {
			mature = false;
		}
		return mature;
	}

	
	/*
	[Test 41] method to return prerequisite
	@param  -
	@return prerequisite
	 */		
	public String checkPrerequisite() {return prerequisite;}


	
	
}//The end of Course class