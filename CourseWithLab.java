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

public class CourseWithLab {

	//Declare variables
	private String courseCode, courseTitle, classRoom, prerequisite, labRoom;
	private DayOfWeek dayCourseIsScheduled, dayLabIsScheduled;
	private LocalTime timeCourseIsScheduled, courseCanStart, courseCanEndBy, timeLabIsScheduled, labCanStart, labCanEndBy;
	private int credit, classSize;

	//Create an Instructor class's object, a Student class's object and a Course class's object
	private Instructor instructor, labTechnician;
	private Student student;
	private Course course;
	
	
	//[Test 34] [Test 37] 
	//Constructor with exception about if a instructor can teach a lab, and if the schedule is acceptable
	public CourseWithLab(Instructor instructor, String courseCode, String courseTitle, String classRoom,
						DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, 
						Instructor labTechnician, String labRoom, DayOfWeek dayLabIsScheduled, LocalTime timeLabIsScheduled)
	{
		this.instructor = instructor;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.classRoom = classRoom;
		this.dayCourseIsScheduled = dayCourseIsScheduled;
		this.timeCourseIsScheduled = timeCourseIsScheduled;
		this.credit = credit;
		this.labTechnician = labTechnician;
		this.labRoom = labRoom;
		this.dayLabIsScheduled = dayLabIsScheduled;
		this.timeLabIsScheduled = timeLabIsScheduled;
		this.labCanStart = LocalTime.of(8,00);
		this.labCanEndBy = LocalTime.of(18,00);
		this.classSize = 40;
				
		//Validate if a instructor can teach a lab
		if (!instructor.instructorCanTeach(courseCode))
		{
			throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
		} 

		//Validate if the schedule is valid	
		if (this.timeLabIsScheduled.isBefore(this.labCanStart) || this.timeLabIsScheduled.isAfter(this.labCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("The lab start time must be between 08:00-18:00");
		}
	}//The end of the constructor

	
	//[Test 37] [Test 43]
	//Another constructor with both prerequisite and exception about if a instructor can teach a lab and if the schedule is acceptable
	public CourseWithLab(Instructor instructor, String courseCode, String courseTitle, String classRoom,
						DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, String prerequisite, 
						Instructor labTechnician, String labRoom, DayOfWeek dayLabIsScheduled, LocalTime timeLabIsScheduled)
	{
		//Call the first constructor
		this(instructor, courseCode, courseTitle, classRoom, dayCourseIsScheduled, timeCourseIsScheduled, credit, 
			labTechnician, labRoom, dayLabIsScheduled, timeLabIsScheduled);
		this.prerequisite = prerequisite;
		this.labCanStart = LocalTime.of(8,00);
		this.labCanEndBy = LocalTime.of(18,00);
		this.classSize = 40;
	
		//Validate if a instructor can teach a lab
		if (!instructor.instructorCanTeach(courseCode))
		{
			throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
		} 
		
		//Validate if the schedule is valid	
		if (this.timeLabIsScheduled.isBefore(this.labCanStart) || this.timeLabIsScheduled.isAfter(this.labCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("The lab start time must be between 08:00-18:00");
		}
	}//The end of the constructor
	

	
	//Getter methods for private variables
	
	/*
	Getter method to return a lab room
	@param -
	@return labRoom
	 */
	public String getLabRoom() {return labRoom;}
	
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

	/*
	Getter method to return the maximum number of students per class
	@param  -
	@return classSize
	 */	
	public int getClassSize() {return classSize;}
	
	
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
	Setter method to set a lab room
	@param labRoom
	@return -
	 */
	public void setLabRoom(String labRoom) {this.labRoom = labRoom;}

	/*
	Setter method to set the time Lab is scheduled
	@param  timeLabIsScheduled
	@return -
	 */		
	public void setTimeCourseIsScheduled(LocalTime timeLabIsScheduled) {this.timeLabIsScheduled = timeLabIsScheduled;}

	/*
	Setter method to set labTechnician object
	@param  labTechnician
	@return -
	 */		
	public void setLabTechnician(Instructor labTechnician) {this.labTechnician = labTechnician;}
	
	/*
	Setter method to set the maximum number of students per class
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
	[Test 34] method to return the text that the course is with Lab
	@param -
	@return the following text
	 */
	public String toString() {return getCourseCode() + "-" + getCourseTitle() + " with lab";}

		
	
	/*
	[Test 38] method to return the Lab schedule
	@param  -
	@return the Lab schedule
	 */	
	public String getLabClassAndTime()
	{
		return "room: " + getLabRoom() + ", " + this.dayLabIsScheduled + " starting at " + this.timeLabIsScheduled;
	}
	
	
	/*
	[Test 39] method to return a lab guy's full name
	@param  -
	@return the lab technicians' full name
	 */	
	public Instructor getLabTech() {return labTechnician;}
	

	
	/*
	method to return a instructor's full name
	@param  -
	@return the instructor's full name
	 */	
	public Instructor getInstructorToTeach() {return instructor;}

	
	
	
	/*
	[Test 43] method to return prerequisite
	@param  -
	@return prerequisite
	 */		
	public String checkPrerequisite() {return prerequisite;}
	
	
	
	
	
	
}//The end of CourseWithLab class
