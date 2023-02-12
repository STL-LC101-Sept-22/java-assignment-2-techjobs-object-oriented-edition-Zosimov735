package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Application programmer", new Employer("Anacomp"), new Location("Maryland Heights"), new PositionType("Full Stack Developer"), new CoreCompetency("EVERYTHING"));
        Job job2 = new Job("Application programmer", new Employer("Anacomp"), new Location("Maryland Heights"), new PositionType("Full Stack Developer"), new CoreCompetency("EVERYTHING"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Application programmer", new Employer("Anacomp"), new Location("Maryland Heights"), new PositionType("Full Stack Developer"), new CoreCompetency("EVERYTHING"));
        Job job2 = new Job();
        job2.setEmployer(new Employer(""));
        assertEquals('\n', job1.toString().charAt(0));
        assertEquals('\n', job1.toString().charAt(job1.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Application programmer", new Employer("Anacomp"), new Location("Maryland Heights"), new PositionType("Full Stack Developer"), new CoreCompetency("EVERYTHING"));

        assertEquals("\n" + "ID: " + job1.getId() + "\n" + "Name: " + job1.getName() + "\n" + "Employer: " + job1.getEmployer().getValue() + "\n" + "Location: " + job1.getLocation().getValue() + "\n" + "Position Type: " + job1.getPositionType().getValue() +"\n" +"Core Competency: " + job1.getCoreCompetency().getValue() + "\n" ,job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("null", new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));
        String errorMessage = "Data not available";
        assertEquals("\n" + "ID: " + job1.getId() + "\n" + "Name: " + "null" + "\n" + "Employer: " + errorMessage + "\n" + "Location: " + errorMessage + "\n" + "Position Type: " + errorMessage +"\n" +"Core Competency: " + errorMessage + "\n", job1.toString());
    }

}
