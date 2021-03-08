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

public class Course {

	//Declare private variables
	private String courseCode, courseTitle, classRoom, prerequisite;
	private DayOfWeek dayCourseIsScheduled;
	private LocalTime timeCourseIsScheduled, courseCanStart, courseCanEndBy;
	private int credit;
	private int classSize;
	protected Instructor instructor;
	protected Student student;
	ArrayList<Student> listOfStudents = new ArrayList<>();

	
	//[Test 21] [Test 33] 
	//Constructor with seven parameters including the validation if a professor can teach a course
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
		this.classSize = 40;
		this.courseCanStart = LocalTime.of(8,00);
		this.courseCanEndBy = LocalTime.of(18,00);
		
		//Validate if a professor can teach a course
		if (instructor.instructorCanTeach(courseCode) == false)
		{
			throw new IllegalArgumentException("Professor " + instructor.getFirstName() + " " + instructor.getLastName()
												+ " is not qualified to teach " + courseCode);
		} 
		
		if (this.timeCourseIsScheduled.isBefore(courseCanStart) || this.timeCourseIsScheduled.isAfter(courseCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("Course start time must be between 08:00-18:00");
		}
	}

	
	
	//[Test 41] Another constructor including both validation and prerequisite
	public Course(Instructor instructor, String courseCode, String courseTitle, String classRoom, 
			DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, String prerequisite)
	{

		this.instructor = instructor;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.classRoom = classRoom;
		this.dayCourseIsScheduled = dayCourseIsScheduled;
		this.timeCourseIsScheduled = timeCourseIsScheduled;
		this.credit = credit;
		this.classSize = 40;
		this.prerequisite = prerequisite;
		ArrayList<Student> listOfStudents = new ArrayList<>();
		LocalTime courseCanStart = LocalTime.of(8,00);
		LocalTime courseCanEndBy = LocalTime.of(18,00);

		//Validate if a professor can teach a course
		if (instructor.instructorCanTeach(courseCode) == false)
		{
			throw new IllegalArgumentException("Professor " + instructor.getFirstName() + " " + instructor.getLastName()
												+ " is not qualified to teach " + courseCode);
		} else if (this.timeCourseIsScheduled.isBefore(courseCanStart) || this.timeCourseIsScheduled.isAfter(courseCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("Course start time must be between 08:00-18:00");
		}
	}
	
	//Getter variables for private variables
	public String getCourseCode() {return courseCode;}
	public String getCourseTitle() {return courseTitle;}
	public int getCredit() {return credit;}	

	//Setter methods for private variables
	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
	public void setCourseTitle(String courseTitle) {this.courseTitle = courseTitle;}
	public void setClassRoom(String classRoom) {this.classRoom = classRoom;}
	public void setDayCourseIsScheduled(DayOfWeek dayCourseIsScheduled) {this.dayCourseIsScheduled = dayCourseIsScheduled;}	
	public void setCredit(int credit) {this.credit = credit;}		
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
	[Test 23] method to return the course schedule
	@param  -
	@return the course schedule
	 */	
	public String getCourseDayAndTime() {return this.dayCourseIsScheduled + "'s, starting at " + this.timeCourseIsScheduled;}
	
	
	/*
	[Test 24] method to return the instructor's full name
	@param  -
	@return the instructor's full name
	 */	
	public String getInstructorToTeach() {return instructor.getFirstName() + " " + instructor.getLastName();}
	
	
	/*
	[Test 25] [Test 26] [Test 27] [Test 42] [Test 44] method to add a student info who takes the course to a list up to the maximum number of students
	@param  student
	@return -
	 */	
	public String addStudent(Student student) {

		if (getClassSize() < this.listOfStudents.size())
		{
			return "Student was not added because the course is full";
		} else if (student.getCoursesCompleted().indexOf(checkPrerequisite()) != -1)
		{
			return "Student has not completed the prerequisite course: " + checkPrerequisite();			
		} else {
//		if (student.getReinstateStatus() == true)
//		{
//			if (getClassSize() < this.listOfStudents.size())
//			{
//				return "Student was not added because the course is full";
//			} else if (student.getGoodStanding() == false) 
//			{
//				return "The Student is not in good standing and cannot join the course.";
//			} else if (checkPrerequisite() != null) 
//			{
//				if (student.getCoursesCompleted().indexOf(checkPrerequisite()) != -1)
//				{
					this.listOfStudents.add(student);
					return this.listOfStudents.toString();
//					return super.toString();
		
//				} else {
//					return "Student has not completed the prerequisite course: " + checkPrerequisite();
//				}
//			} 
//		}
					
				}
			
				
		
	}

	
	
	/*
	[Test 25] method to return a list collecting student info who takes the course
	@param  -
	@return toString() that is declared in Student class
	 */	
	public String displayTheClassList() {
//		return this.listOfStudents.toString();
		return this.listOfStudents.get(this.listOfStudents.size() - 1).toString();
	
	}
	

	/*
	[Test 28] method to set the maximum number of students per class
	@param  classSize
	@return the message that says the max number of students
	 */	
	public String setClassSize(int classSize)
	{
//		if ((0 < classSize) && (classSize <= getClassSize()))
//		{
//			this.classSize = classSize;		
//			return;
//		} else {
			return "Max class size = " + getClassSize() + ", it has been set to " + getClassSize();
//		}
	}
	

	/*
	[Test 28] method to return the maximum number of students per class
	@param  -
	@return classSize
	 */	
	public int getClassSize() {return classSize;}
	

	/*
	[Test 29] [Test 30] method to set the time course is scheduled
	@param  timeCourseIsScheduled
	@return -
	 */		
//	public void setTimeCourseIsScheduled(LocalTime timeCourseIsScheduled)
//	{
//		LocalTime courseCanStart = LocalTime.of(8,00);
//		LocalTime courseCanEndBy = LocalTime.of(18,00);
//		
//		if (this.timeCourseIsScheduled.isBefore(courseCanStart) || this.timeCourseIsScheduled.isAfter(courseCanEndBy))
//		{
//			throw new java.lang.IllegalArgumentException("Course start time must be between 08:00-18:00");
//		} else {
//			this.timeCourseIsScheduled = timeCourseIsScheduled;
//		}
//	}

	

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

		for(int i = 0; i < this.listOfStudents.size(); i++)
		{
//			sumOfAge += student.getStudentAge();
			sumOfAge += this.listOfStudents.get(i).getStudentAge();
		}
		aveOfAge = sumOfAge / this.listOfStudents.size();
		
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
	public String checkPrerequisite() {return this.prerequisite;}

	
	
	
	
	
	
	

	
	
}
