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

//CourseWithLab class extends its superclass, "Course"
public class CourseWithLab extends Course {

	//Declare variables
	private String labRoom;
	private DayOfWeek dayLabIsScheduled;
	private LocalTime timeLabIsScheduled, labCanStart, labCanEndBy;
	private Instructor instructor, labTechnician;
	
	//[Test 34] [Test 37] 
	//Constructor with exception about if a instructor can teach a lab, and if the schedule is acceptable
	public CourseWithLab(Instructor instructor, String courseCode, String courseTitle, String classRoom,
						DayOfWeek dayCourseIsScheduled, LocalTime timeCourseIsScheduled, int credit, 
						Instructor labTechnician, String labRoom, DayOfWeek dayLabIsScheduled, LocalTime timeLabIsScheduled)
	{
		 //Call the constructor from its superclass, "Course"
		super(instructor, courseCode, courseTitle, classRoom, dayCourseIsScheduled, timeCourseIsScheduled, credit);
		this.labTechnician = labTechnician;
		this.labRoom = labRoom;
		this.dayLabIsScheduled = dayLabIsScheduled;
		this.timeLabIsScheduled = timeLabIsScheduled;
		this.labCanStart = LocalTime.of(8,00);
		this.labCanEndBy = LocalTime.of(18,00);
		
				
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
	}

	
	//[Test 37] [Test 43]
	//Another constructor with both prerequisite and exception about if a instructor can teach a lab and if the schedule is acceptable
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
		this.labCanStart = LocalTime.of(8,00);
		this.labCanEndBy = LocalTime.of(18,00);
		
	
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

	}

	
	
	/*
	Getter method to return a lab room
	@param -
	@return labRoom
	 */
	public String getLabRoom() {return labRoom;}
	
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
	[Test 34] method to return the text that the course is with Lab
	@param -
	@return the following text
	 */
	public String toString() {return super.getCourseCode() + "-" + super.getCourseTitle() + " with lab";}

		
	
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
	[Test 43] method to return prerequisite
	@param  -
	@return prerequisite
	 */		
	public String checkPrerequisite() {return super.checkPrerequisite();}
	
	
	
	
	
	
}//The end of CourseWithLab class
