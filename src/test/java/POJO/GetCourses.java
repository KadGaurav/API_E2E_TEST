package POJO;

public class GetCourses {

    private String instructor;
    private Courses courses;
    public  String url;
    public  String services;
    public  String expertise;
    public  String linkedIn;

    //create getters and setters
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public Courses getCourses() {
        return courses;
    }
    public void setCourses(Courses courses) {
        this.courses = courses;
    }
    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }
    public String getExpertise() {
        return expertise;
    }
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public String getLinkedIn() {
        return linkedIn;
    }
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
