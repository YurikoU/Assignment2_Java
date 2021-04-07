/*
Student Name: Yuriko Uchida
Student Number: #200448500

Due Date: April 16, 2021
Assignment 3
*/


package src.registrationsystem;


//Import libraries
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import org.junit.jupiter.api.Test;

class UnitTesters {

	
    /** JUnit 1**/  
	/** JUnit 9**/  
	/** JUnit 21**/  
	/** JUnit 34*/	
	/** JUnit 43*/	
	@Test
	void testToString() {
		assertAll("Test toString() method",
			() -> {Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));		
				   assertEquals("Colin Allcars, student number: 223", st1.toString());
			},
			
			() -> {Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));		
				   assertEquals("Karen Vader", karenV.toString());
			},
			
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				   frank.addCourseToInstructorAbilities("COMP1008");
				   Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);	
				   assertEquals("COMP1008-Intro to OOP", comp1008.toString());
			},
			
			() -> {Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));
				   Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				   labGuy.addCourseToInstructorAbilities("COMP2004-LAB"); 
				   karenV.addCourseToInstructorAbilities("COMP2004");	
				   CourseWithLab comp2004 = new CourseWithLab(karenV, "COMP2004", "FX GUIs", "E208", DayOfWeek.MONDAY, LocalTime.parse("08:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
				   assertEquals("COMP2004-FX GUIs with lab", comp2004.toString());
			},
			
			
			() -> {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
				   Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));
				   alec.addCourseToInstructorAbilities("COMP2018");
				   labGuy.addCourseToInstructorAbilities("COMP2018-LAB");
				   CourseWithLab comp2018 = new CourseWithLab(alec, "COMP2018", "Nifty Stuff", "E208", DayOfWeek.FRIDAY, LocalTime.parse("15:00"), 3, "COMP1008", labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("09:00"));
				   assertEquals("COMP2018-Nifty Stuff with lab", comp2018.toString());
			}
			
			
			
			
		);
	}

	
    /** JUnit 2**/  
	/** JUnit 3**/  
	@Test
	void testGetStudentAge() {
		assertAll("Test student's birthday and age",
			() -> {Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));		
				   assertEquals(LocalDate.of(1974, Month.APRIL, 12), st1.getStudentBirthday());
				   assertEquals(46, st1.getStudentAge());
			},
			
			() -> {Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
				   assertEquals(21, st2.getStudentAge());
			}	
		);
	}


	/** JUnit 4**/  
	@Test
	void testGetStudentAddress() {
        Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));	
        st1.changeAddress("49 Granite Court", "Bedrock", "R2D 2B3");        
		assertEquals("49 Granite Court Bedrock R2D 2B3", st1.getStudentAddress());
	}


	/** JUnit 5**/  
	/** JUnit 6**/  
	@Test
	void testStudentInGoodStanding() {
        Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));	
        assertAll("Test if student is in good standing",
        	() -> assertTrue(st1.studentInGoodStanding()),
        	() -> st1.suspendStudent(),
    		() -> assertFalse(st1.studentInGoodStanding())
        );
	}


	/** JUnit 7**/  
	@Test
	void testStudent() {
		try {
			Student st3 = new Student("Barney", "Rubble", "18 Cobblestone Way", "Bedrock", "L0L 6T6", "COPA", 224, LocalDate.of(2016, Month.FEBRUARY, 1), LocalDate.of(1872, Month.APRIL, 12));
		} catch (IllegalArgumentException e) {
			assertEquals("Please check the year entered, student cannot be over 100 years old", e.getMessage());
		}
	}

	
	/** JUnit 8**/  
	@Test
	void testGetYearEnrolled() {		
        Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));	    
		assertEquals(2000, st1.getYearEnrolled());
	}

	
	/** JUnit 10**/  
	@Test
	void testGetAgeInYears() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		assertEquals(58, karenV.getAgeInYears());
	}

	
	/** JUnit 11**/  
	@Test
	void testNoOfYearsAtCollege() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		assertEquals(7, karenV.noOfYearsAtCollege());
	}

	
	/** JUnit 12**/  
	/** JUnit 13**/  
	@Test
	void testGetInstructorAddress() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		assertAll("Test adress change",
			() -> assertEquals("10 Hightop Lane, Barrie, L2S 1A6", karenV.getInstructorAddress()),
			() -> {karenV.changeAddress("101 First Floor Ave.", "Utopia", "L3S 2A2");
				   assertEquals("101 First Floor Ave., Utopia, L3S 2A2", karenV.getInstructorAddress());
			}
		);
	}

	
	/** JUnit 14**/  
	/** JUnit 15**/
	/** JUnit 18**/
	@Test
	void testListOfSubjectsCertifiedToTeach() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));

		assertAll("Test what subject the teacher can teach",
			() -> assertEquals("not qualified to teach courses yet.", karenV.listOfSubjectsCertifiedToTeach()),
			() -> {karenV.addCourseToInstructorAbilities("COMP1008");
				   karenV.addCourseToInstructorAbilities("COMP2003");
				   assertEquals("[COMP1008, COMP2003]", karenV.listOfSubjectsCertifiedToTeach());
			},
			() -> {karenV.addCourseToInstructorAbilities("COMP1008");
				   karenV.addCourseToInstructorAbilities("COMP2003");
				   karenV.addCourseToInstructorAbilities("COMP2003");
				   assertEquals("[COMP1008, COMP2003]", karenV.listOfSubjectsCertifiedToTeach());
			}
		);
	}


	
	/** JUnit 16**/  
	/** JUnit 17**/  
	@Test
	void testInstructorCanTeach() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
	    assertAll(
	    	() -> assertFalse(karenV.instructorCanTeach("COMP3002")),
	    	() -> {karenV.addCourseToInstructorAbilities("COMP1008");
			   	   karenV.addCourseToInstructorAbilities("COMP2003");
			   	   assertTrue(karenV.instructorCanTeach("COMP1008"));
	    	}
	    );
	}


	/** JUnit 19**/  
	/** JUnit 20**/
	@Test
	void testInstructor() {
		assertAll(
			() -> {try {Instructor oldMan = new Instructor("Al", "Dente", 1000013, "16 Ancient Ave", "Innisfil", "W32S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1901, Month.DECEMBER, 21));
					} catch (IllegalArgumentException e) {
						assertEquals("Please check the year entered, instructor cannot be over 100 years old", e.getMessage());
					}
			},
			
			() -> {try {Instructor hiredLongAgo = new Instructor("Anita", "Knapp", 1000014, "16 Ancient Ave", "Innisfil", "W32S 1A6", LocalDate.of(1910, Month.AUGUST, 22), LocalDate.of(1981, Month.DECEMBER, 21));
					} catch (IllegalArgumentException e) {
						assertEquals("1910-08-22 as a hire date would mean Anita started working over 80 years ago", e.getMessage());
					}
			}
		);
	}


	/** JUnit 22**/
	@Test
	void testGetClassRoom() {
		Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		frank.addCourseToInstructorAbilities("COMP1008");
		Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
	    assertEquals("E202", comp1008.getClassRoom());
	}


	/** JUnit 23**/
	@Test
	void testGetCourseDayAndTime() {
		Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		frank.addCourseToInstructorAbilities("COMP1008");
		Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
	    assertEquals("TUESDAY's, starting at 11:00", comp1008.getCourseDayAndTime());
	}


	/** JUnit 24**/
	/** JUnit 39*/
	@Test
	void testGetInstructorToTeach() {
		assertAll(
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				   frank.addCourseToInstructorAbilities("COMP1008");
				   Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
			       assertEquals(frank, comp1008.getInstructorToTeach());
			},
			
			() -> {Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		    	   Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
		    	   karenV.addCourseToInstructorAbilities("COMP2004");
		    	   labGuy.addCourseToInstructorAbilities("COMP2004");
		    	   CourseWithLab comp2004 = new CourseWithLab(karenV, "COMP2004", "FX GUIs", "E208", DayOfWeek.MONDAY, LocalTime.parse("08:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
		    	   assertEquals(karenV, comp2004.getInstructorToTeach());				
			}
		);
		
		
	}


	/** JUnit 25**/
	/** JUnit 42**/
	@Test
	void testDisplayTheClassList() {
		assertAll(
			() -> {Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
		           st1.reinstateStudent();
  		           Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		           frank.addCourseToInstructorAbilities("COMP1008");
		           Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		           comp1008.addStudent(st1);
				
				   assertEquals("Colin Allcars, student number: 223", comp1008.displayTheClassList());
			},
				
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				   frank.addCourseToInstructorAbilities("COMP1008");
				   frank.addCourseToInstructorAbilities("COMP2020");
				   Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
				   Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
				   Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
				   st1.addCompletedCourse(comp1008, 88);
				   comp2020.addStudent(st1);
				   assertEquals("Colin Allcars, student number: 223", comp2020.displayTheClassList());        
			}
		);
	}

	

	/** JUnit 26**/
	/** JUnit 27**/
	/** JUnit 44**/
	@Test
	void testAddStudent() {
		assertAll(
			() -> {Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
		           Student st3 = new Student("Howie", "Doohan", "12 Greeter Ln", "Thornhill", "H9T A3S", "COPR", 10002, LocalDate.of(2011, Month.AUGUST, 21), LocalDate.of(1997, Month.APRIL, 16));
		           Student st4 = new Student("Jerry", "Atrick", "39 Elder Ave", "Newmarket", "A6T D3S", "COPR", 10003, LocalDate.of(2008, Month.AUGUST, 22), LocalDate.of(1943, Month.MARCH, 23));
		           Student st5 = new Student("Leigh", "King", "182 Drip Drive", "Etobicoke", "Q6X D3S", "COPA", 10004, LocalDate.of(2010, Month.AUGUST, 21), LocalDate.of(2000, Month.FEBRUARY, 14));        
		           Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		           frank.addCourseToInstructorAbilities("COMP1008");
		           Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		           comp1008.addStudent(st1);
		           comp1008.addStudent(st3);
		           comp1008.addStudent(st4);
   				   assertEquals("Student was not added because the course is full", comp1008.addStudent(st5));
			},
			
			() -> {Student st4 = new Student("Jerry", "Atrick", "39 Elder Ave", "Newmarket", "A6T D3S", "COPR", 10003, LocalDate.of(2008, Month.AUGUST, 22), LocalDate.of(1943, Month.MARCH, 23));
		           Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		           frank.addCourseToInstructorAbilities("COMP1008");
		           Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		           st4.suspendStudent();
				   assertEquals("The Student is not in good standing and cannot join the course.", comp1008.addStudent(st4));
			},
			
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
	           	   frank.addCourseToInstructorAbilities("COMP1008");
	           	   frank.addCourseToInstructorAbilities("COMP2020");
	           	   Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
	           	   Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
	           	   Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
	           	   assertEquals("Student has not completed the prerequisite course: COMP1008", comp2020.addStudent(st2));
			}
		);
	}

	

	/** JUnit 28*/
	@Test
	void testClassSize() {
        Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
        frank.addCourseToInstructorAbilities("COMP1008");
        Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);

        assertEquals("Max class size = 40, it has been set to 40", comp1008.setClassSize(80));
		assertEquals(40, comp1008.getClassSize());
	}


	

	/** JUnit 29*/
	/** JUnit 30*/
	/** JUnit 33*/	
	@Test
	void testCourse() {
		assertAll(
			() -> {try {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
			   			frank.addCourseToInstructorAbilities("COMP2003");
			   			Course comp2003 = new Course(frank, "COMP2003", "Intro to DB", "E204", DayOfWeek.THURSDAY, LocalTime.parse("06:00"), 20);
					} catch (IllegalArgumentException e) {
						assertEquals("Course start time must be between 08:00-18:00", e.getMessage());
					}
			},	
				
			() -> {try {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
   						frank.addCourseToInstructorAbilities("COMP2003");
   						Course comp2003 = new Course(frank, "COMP2003", "Intro to DB", "E204", DayOfWeek.THURSDAY, LocalTime.parse("18:01"), 20);
					} catch (IllegalArgumentException e) {
						assertEquals("Course start time must be between 08:00-18:00", e.getMessage());
					}
			},
			
			() -> {try {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
						frank.addCourseToInstructorAbilities("COMP2003");
						Course comp9999 = new Course(frank, "COMP9999", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20);
					} catch (IllegalArgumentException e) {
						assertEquals("Professor Frank Enstein is not qualified to teach COMP9999", e.getMessage());
					}
			}			
		);
	}

	
	

	/** JUnit 31*/
	/** JUnit 32*/
	@Test
	void testMatureClass() {
		assertAll(
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		           frank.addCourseToInstructorAbilities("COMP1008");
		           Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		           Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
		           Student st3 = new Student("Howie", "Doohan", "12 Greeter Ln", "Thornhill", "H9T A3S", "COPR", 10002, LocalDate.of(2011, Month.AUGUST, 21), LocalDate.of(1997, Month.APRIL, 16));
		           comp1008.addStudent(st1);
		           comp1008.addStudent(st3);
		        
				   assertTrue(comp1008.matureClass());
			},
				
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		           frank.addCourseToInstructorAbilities("COMP1008");
		           Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		           Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
		           Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
		           Student st3 = new Student("Howie", "Doohan", "12 Greeter Ln", "Thornhill", "H9T A3S", "COPR", 10002, LocalDate.of(2011, Month.AUGUST, 21), LocalDate.of(1997, Month.APRIL, 16));
		           Student st4 = new Student("Jerry", "Atrick", "39 Elder Ave", "Newmarket", "A6T D3S", "COPR", 10003, LocalDate.of(2008, Month.AUGUST, 22), LocalDate.of(1943, Month.MARCH, 23));
		           st1.setBirthday(LocalDate.of(2000, Month.DECEMBER, 31));
		           st2.setBirthday(LocalDate.of(2000, Month.FEBRUARY, 16));
		           st3.setBirthday(LocalDate.of(2000, Month.MARCH, 23));
		           st4.setBirthday(LocalDate.of(2000, Month.MARCH, 29));
		           comp1008.addStudent(st1);
		           comp1008.addStudent(st2);
		           comp1008.addStudent(st3);
		           comp1008.addStudent(st4);
		        
				   assertFalse(comp1008.matureClass());
			}
		);
	}
	
	
	
	/** JUnit 35*/	
	/** JUnit 36*/	
	/** JUnit 37*/
	@Test
	void testCourseWithLab() {
		assertAll(
			() -> {try {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
						Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
						CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
					} catch (IllegalArgumentException e) {
						assertEquals("The Lab Tech is not qualified to host the lab", e.getMessage());
					}
			},
				
			() -> {try {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
						Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
						alec.addCourseToInstructorAbilities("COMP2008");
						CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
					} catch (IllegalArgumentException e) {
						assertEquals("The Lab Tech is not qualified to host the lab", e.getMessage());
					}
			},
			
			() -> {try {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
			   			Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
			   			alec.addCourseToInstructorAbilities("COMP2008");
			   			labGuy.addCourseToInstructorAbilities("COMP2008");
			   			CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("19:00"));
					} catch (IllegalArgumentException e) {
						assertEquals("The lab start time must be between 08:00-18:00", e.getMessage());
					}
			}			
		);
	}


	

	/** JUnit 38*/
	@Test
	void testLabClassAndTime() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
	    Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
		karenV.addCourseToInstructorAbilities("COMP2004");
		labGuy.addCourseToInstructorAbilities("COMP2004");
        CourseWithLab comp2004 = new CourseWithLab(karenV, "COMP2004", "FX GUIs", "E208", DayOfWeek.MONDAY, LocalTime.parse("08:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));

        assertEquals("room: E204, WEDNESDAY starting at 15:00", comp2004.getLabClassAndTime());
	}

	

	/** JUnit 39*/
	@Test
	void testGetLabTech() {
		Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
	    Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));	   
		karenV.addCourseToInstructorAbilities("COMP2004");
		labGuy.addCourseToInstructorAbilities("COMP2004");
		CourseWithLab comp2004 = new CourseWithLab(karenV, "COMP2004", "FX GUIs", "E208", DayOfWeek.MONDAY, LocalTime.parse("08:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
        assertEquals(labGuy, comp2004.getLabTech());        
	}



	/** JUnit 40*/
	@Test
	void testGetCoursesCompleted() {
		Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way", "Barrie", "L0L 6T6", "COPA", 223, LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));
		Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		frank.addCourseToInstructorAbilities("COMP1008");
		Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		st1.addCompletedCourse(comp1008, 88);
		assertEquals("[COMP1008-Intro to OOP grade=88]", st1.getCoursesCompleted());        
	}


	/** JUnit 41*/
	/** JUnit 43*/
	@Test
	void testCheckPrerequisite() {
		assertAll(
			() -> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				   frank.addCourseToInstructorAbilities("COMP2020");
				   Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
				   assertEquals("COMP1008", comp2020.checkPrerequisite());        
			},
			
			() -> {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
				   Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));
				   alec.addCourseToInstructorAbilities("COMP2018");
				   labGuy.addCourseToInstructorAbilities("COMP2018-LAB");
				   CourseWithLab comp2018 = new CourseWithLab(alec, "COMP2018", "Nifty Stuff", "E208", DayOfWeek.FRIDAY, LocalTime.parse("15:00"), 3, "COMP1008", labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("09:00"));
				   assertEquals("COMP1008", comp2018.checkPrerequisite());
			}
		);
	}



	/** JUnit 45*/
	/** JUnit 46*/	
	@Test
	void testHasCompleted() {
		assertAll(
			()-> {Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
				  Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
				  alec.addCourseToInstructorAbilities("COMP1008");
				  frank.addCourseToInstructorAbilities("COMP1008");
				  Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
				  Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
				  st2.addCompletedCourse(comp1008, 47);
				  assertFalse(st2.hasCompleted("COMP1008"));        
			},
				
			()-> {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
			  	  frank.addCourseToInstructorAbilities("COMP1008");
			  	  Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
			  	  Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
			  	  st2.addCompletedCourse(comp1008, 88);
			  	  assertTrue(st2.hasCompleted("COMP1008"));       
			}
		);
	}


	/** JUnit 47*/
	/** JUnit 48*/
	@Test
	void testAddCompletedCourse() {
		assertAll (
			() -> {try {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		  	  	   		frank.addCourseToInstructorAbilities("COMP1008");
		  	  	   		frank.addCourseToInstructorAbilities("COMP2020");
		  	  	   		Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
		  	  	   		Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
		  	  	   		Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
		  	  	   		st2.addCompletedCourse(comp2020, -10);
					} catch (IllegalArgumentException e) {
						assertEquals("grade must be 0-100 inclusive", e.getMessage());
					}
			},
				
			() -> {try {Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
	  	   				frank.addCourseToInstructorAbilities("COMP1008");
	  	   				frank.addCourseToInstructorAbilities("COMP2020");
	  	   				Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
	  	   				Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
	  	   				Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001, LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
	  	   				st2.addCompletedCourse(comp2020, 101);
					} catch (IllegalArgumentException e) {
						assertEquals("grade must be 0-100 inclusive", e.getMessage());
					}
			}
		);
	}
	

	
	
	
	
	
	
	
	

}//End of UnitTesters class
