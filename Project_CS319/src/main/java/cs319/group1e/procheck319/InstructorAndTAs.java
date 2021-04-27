package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import java.util.List;
import java.util.Random;
import java.nio.charset.Charset;

public class InstructorAndTAs implements User {

    //Properties
    private String userName;
    private String userSurname;
    private String password;
    @Id
    private int userId;
    private String email;
    private String type;

    private Calendar calendar;
    private Project project;
    private Class aClass;
    private String classKey;

    //Default Constructor
    public InstructorAndTAs() {
    }

    //Constructor
    public InstructorAndTAs(String userName, String userSurname, String password, int userId, String email, String type, Calendar calendar, Project project, Class aClass, String classKey) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.calendar = calendar;
        this.project = project;
        this.aClass = aClass;
        this.classKey = classKey;
    }

    //Getters
    public Calendar getCalendar() {
        return calendar;
    }

    public Project getProject() {
        return project;
    }

    public Class getaClass() {
        return aClass;
    }

    public String getClassKey() {
        return classKey;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    //Setters
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
        OPERATIONS OF INSTRUCTORANDTAS
    */

    /**
      Instructor gets group's specific submission
     */
    public Submission getSubmission(Group group, int subNo){
        return group.getGroupSubmissionList().get(subNo-1);
    }

    /**
      Instructor gives feedback
     */
    public InstructorFeedback giveFeedback(String context){
        InstructorFeedback instructorFeedback = new InstructorFeedback(context);
        return instructorFeedback;
    }

    /**
      Instructor grades a submission
    */
    public boolean gradeSubmission(Group group, int subNo, double grade){
        if(group.getGroupSubmissionList().get(subNo-1) == null){
            return false;
        }
        group.getGroupSubmissionList().get(subNo-1).setGrade(grade);
        return true;
    }

    /**
      Instructor views the submission list of a specific group
    */
    public List<Submission> viewSubmission(List<Group> groups, int index){
        return groups.get(index-1).getGroupSubmissionList();
    }

    /**
      Instructor views the peer review list of a specified group's specified student
     */
    public List<PeerReview> viewPeerReviews(List<Group> groups, int groupId, int studentId){
        return groups.get(groupId-1).getStudentList().get(studentId-1).getPeerReviews();
    }

    /**
      Instructor views the artifact reviews of a group's submission
     */
    public List<ArtifactReview> viewArtifactReviews(List<Group> groups, int groupId, int subNo){
        return groups.get(groupId-1).getGroupSubmissionList().get(subNo-1).getArtifactReviews();
    }

    /**
      Instructor views a specific group
     */
    public Group viewGroup(List<Group> groups, int groupId){
        return groups.get(groupId-1);
    }

    /**
      Instructor creates an announcement
     */
    public Announcement announce(String context, String title){
        return new Announcement(context,title);
    }

    /**
      Instructor creates a class
     */
    public Class createClass(String classKey, String className){
        Class aClass1 = new Class(createClassKey(), className);
        return aClass1;
    }

    /**
      Creating a random class key
     */
    public String createClassKey(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}