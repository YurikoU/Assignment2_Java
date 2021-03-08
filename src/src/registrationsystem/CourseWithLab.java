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


public class CourseWithLab extends Course {

	//Declare private variables
	private String labRoom;
	private DayOfWeek dayLabIsScheduled;
	private LocalTime timeLabIsScheduled;
	private Instructor instructor, labTechnician;
	
	//[Test 34] Constructor with parameters
	public CourseWithLab(Instructor instructor, String courseCode, String courseTitle, String classRoom,
						DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, 
						Instructor labTechnician, String labRoom, DayOfWeek dayLabIsScheduled, LocalTime timeLabIsScheduled)
	{
		 //Call the constructor from the superclass, "Course"
		super(instructor, courseCode, courseTitle, classRoom, dayCourseIsScheduled, timeCourseIsScheduled, credit);
		this.labTechnician = labTechnician;
		this.labRoom = labRoom;
		this.dayLabIsScheduled = dayLabIsScheduled;
		this.timeLabIsScheduled = timeLabIsScheduled;
	}

	
	//[Test 43] Another constructor including prerequisite
	public CourseWithLab(Instructor instructor, String courseCode, String courseTitle, String classRoom,
						DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, String prerequisite, 
						Instructor labTechnician, String labRoom, DayOfWeek dayLabIsScheduled, LocalTime timeLabIsScheduled)
	{
		 //Call the constructor from the superclass, "Course"
		super(instructor, courseCode, courseTitle, classRoom, dayCourseIsScheduled, timeCourseIsScheduled, credit, prerequisite);
		this.labTechnician = labTechnician;
		this.labRoom = labRoom;
		this.dayLabIsScheduled = dayLabIsScheduled;
		this.timeLabIsScheduled = timeLabIsScheduled;
	}

	
	
	
	
	
	
	//Getter and setter variables for private variables
	public String getLabRoom() {return labRoom;}
	public void setLabRoom(String labRoom) {this.labRoom = labRoom;}

	
	/*
	[Test 34] method to return the text that the course is with Lab
	@param -
	@return the following text
	 */
	public String toString() 
	{
		return super.getCourseCode() + "-" + super.getCourseTitle() + " with lab" ;
	}
	
	/*
	[Test 36] method to return the text that the course is with Lab
	@param -
	@return the following text
	 */
	public void addCourseToInstructorAbilities(String courseCode)
	{
		instructor.addCourseToInstructorAbilities(courseCode);
	}
	
	
	/*
	[Test 37] method to set the time Lab is scheduled
	@param  timeLabIsScheduled
	@return -
	 */		
	public void setTimeCourseIsScheduled(LocalTime timeLabIsScheduled)
	{
		LocalTime labCanStart = LocalTime.of(8,00);
		LocalTime labCanEndBy = LocalTime.of(18,00);
		
		if (this.timeLabIsScheduled.isBefore(labCanStart) || this.timeLabIsScheduled.isAfter(labCanEndBy))
		{
			throw new java.lang.IllegalArgumentException("Lab start time must be between 08:00-18:00");
		} else {
			this.timeLabIsScheduled = timeLabIsScheduled;
		}
	}
	
	
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
	[Test 39] method to return instructors including both a class lecturer and a lab technician
	@param  -
	@return the instructors' full name
	 */	
	public String getLabTech() {return this.labTechnician.getFirstName() + " " + this.labTechnician.getLastName();}
//	public String getLabTech() {return instructor.getFirstName() + " " + instructor.getLastName();}
	
	
	/*
	[Test 43] method to return prerequisite
	@param  -
	@return prerequisite
	 */		
	public String checkPrerequisite() {
		return super.checkPrerequisite();
	}
	
	
	/*
	[Test 44] method to add a student info who takes the course to a list up to the maximum number of students
	@param  student
	@return -
	 */		
	public void addStudent(Student student)
	{
		super.addStudent(student);
	}
	
	
	
	
	
	
	
	
}
