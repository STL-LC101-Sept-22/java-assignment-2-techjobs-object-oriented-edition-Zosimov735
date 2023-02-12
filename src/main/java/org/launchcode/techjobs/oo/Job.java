package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public Job(){
        id=nextId;
        nextId++;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        String errorMessage = "Data not available";
        int jobId = this.getId();
        String jobName = this.getName();
        String jobEmployer = this.getEmployer().getValue();
        String jobLocation = this.getLocation().getValue();
        String jobCoreComp = this.getCoreCompetency().getValue();
        String jobPositionType = this.getPositionType().getValue();


        if (jobName == null || jobName == ""){
            this.setName(errorMessage);
        }
        if (jobEmployer == null || jobEmployer == ""){
            this.setEmployer(new Employer(errorMessage));
        }
        if (jobLocation == null || jobLocation == ""){
            this.setLocation(new Location(errorMessage));
        }
        if (jobCoreComp == null || jobCoreComp == ""){
            this.setCoreCompetency(new CoreCompetency(errorMessage));
        }
        if (jobPositionType == null || jobPositionType == ""){
            this.setPositionType(new PositionType(errorMessage));
        }
        if (jobName == null && jobEmployer == null && jobCoreComp == null && jobPositionType == null && jobId > 0){
            return "OOPS! This job does not seem to exist.";
        }
        String output = "\n" + "ID: " + this.getId() + "\n" + "Name: " + this.getName() + "\n" + "Employer: " + this.getEmployer().getValue() + "\n" + "Location: " + this.getLocation().getValue() + "\n" + "Position Type: " + this.getPositionType().getValue() +"\n" +"Core Competency: " + this.getCoreCompetency().getValue() + "\n";
        return output;
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

}

