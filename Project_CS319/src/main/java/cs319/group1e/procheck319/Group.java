package cs319.group1e.procheck319;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Document(collection = "allGroups")
public class Group{
    /*
        ATTRIBUTES OF GROUP
    */
    @Id
    private int groupId;
    private List<Integer> studentIdList;
    private List<Submission> groupSubmissionList;
    private List<Assignment> groupAssignmentList;
    private List<Announcement> announcementList;
    public int maxGroupSize;
    private Calendar calendar;
    private double progress;
    private List<Request> requests;
    //private List<Invitation> invitations;

    //Default Constructor
    public Group() {
        studentIdList = new ArrayList<>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        announcementList = new ArrayList<>();
    }

    public Group( int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
        studentIdList = new ArrayList<>();
        groupSubmissionList = new ArrayList<Submission>();
        requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        announcementList = new ArrayList<>();
    }

    public Group( int groupId, int maxGroupSize) {
        this.groupId = groupId;
        this.maxGroupSize = maxGroupSize;
        this.studentIdList = new ArrayList<>();
        this.groupSubmissionList = new ArrayList<Submission>();
        this.requests = new ArrayList<Request>();
        //invitations = new ArrayList<Invitation>();
        this.announcementList = new ArrayList<>();
    }

    //Constructor
    public Group(List<Student> studentList, List<Submission> groupSubmissionList, List<Assignment> groupAssignmentList, List<Announcement> announcementList, int maxGroupSize, Calendar calendar, double progress, List<Request> requests, List<Invitation> invitations) {
        //this.groupId = groupId;
        this.studentIdList = studentIdList;
        this.groupSubmissionList = groupSubmissionList;
        this.groupAssignmentList = groupAssignmentList;
        this.maxGroupSize = maxGroupSize;
        this.calendar = calendar;
        this.progress = progress;
        this.requests = requests;
        //this.invitations = invitations;
        this.announcementList = announcementList;
    }

    //SETTERS
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStudentList(List<Integer> studentList) {
        this.studentIdList = studentIdList;
    }

    public void setGroupSubmissionList(List<Submission> groupSubmissionList) {
        this.groupSubmissionList = groupSubmissionList;
    }

    public void setGroupAssignmentList(List<Assignment> groupAssignmentList) {
        this.groupAssignmentList = groupAssignmentList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    //public void setInvitations(List<Invitation> invitations) {
    //    this.invitations = invitations;
    //}

    //GETTERS
    public int getGroupId() {
        return groupId;
    }

    public List<Integer> getStudentIdList() {
        return studentIdList;
    }

    public List<Submission> getGroupSubmissionList() {
        return groupSubmissionList;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public List<Assignment> getGroupAssignmentList() {
        return groupAssignmentList;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public double getProgress() {
        return progress;
    }

    public List<Request> getRequests() {
        return requests;
    }

    //public List<Invitation> getInvitations() {
    //    return invitations;
    //}

    /*
        OPERATIONS OF GROUP
    */

    /**
    To check if the group is full or not
      Returns true if the group's studentList is full
      Returns false if the group's studentList is not full
     */
    public boolean isFull(){
        if(studentIdList.size() <= maxGroupSize){
                return false;
        }
        return true;
    }


    /**
      Calculating the progress of a group according to their submissions and assignments
     */
    public void calculateProgress(){ //yüzdelik hesaplayak
        double progressOfGroup;
        progressOfGroup = ((double)(groupSubmissionList.size()) / (double)(groupAssignmentList.size()))*100;
        this.progress = progressOfGroup;
    }

    /**
      Adding a student to a group if group is not full
     */
    public boolean addGroupMember(Student student){
        if(isFull()){
            return false;
        }else{
            this.studentIdList.add(student.getUserId());
            student.setGroupMember(true);
            student.setGroupId(groupId);
            return true;
        }
    }
    /**
     Adding a student to a group whether the group reached the max size or not
     Will be used in some exceptional cases
     */
    public boolean addGroupMemberException(Student student){
        studentIdList.add(student.getUserId());
        student.setGroupMember(true);
        student.setGroupId(groupId);
        return true;
    }


    /**
      Removing a group member if group
     */
    public boolean removeGroupMember(Student student){
        if(studentIdList.size() == 0) {
            return false;
        }
        else {
            student.setGroupId(-1);
            student.setGroupMember(false);
            studentIdList.remove(student.getUserId());
            return true;
        }
    }

    /**
      Group calendar is edited TODO?
     */
    public void editCalendar(Calendar calendar){

    }

    public void addAnnouncement( Announcement announcement ){
        announcementList.add(announcement);
    }

    //To get a random artifact submission
    public Submission getRandomGroupArtifact(Assignment assignment , ArtifactReview ar){
        Random rand = new Random();

        int randomIndex;
        boolean flag;

        if(assignment.getSubmissionList().size() == 0){
            return null;
        }
        else{
            do { //Check for if submission belongs to the group
                flag = true;
                System.out.println(assignment.getTitle());
                System.out.println(assignment.getSubmissionList().size());
                randomIndex = rand.nextInt(assignment.getSubmissionList().size()); //Assignment no eklenecek
                if( groupId == assignment.getSubmissionList().get(randomIndex).getGroupId() ){
                    flag = false;
                }
            }while( flag == false );

            assignment.getSubmissionList().get(randomIndex).getArtifactReviews().add(ar);
            return assignment.getSubmissionList().get(randomIndex);
        }
    }

    //TODO To display artifact reviews submitted for an assignment submitted by the group PS: parametre int subNo'ydu sub yaptım
    public List<ArtifactReview> showArtifactReviewsDoneByOthers( Submission sub ){
        return sub.getArtifactReviews();
    }


    public String toString(){
        String groupP ="GROUP " +String.valueOf(this.getGroupId())+":\t";
        for(int i = 0;i<this.getStudentIdList().size();i++){
            groupP = groupP + " " + this.getStudentIdList().get(i)+"\t";
        }
        return groupP;
    }


    //To upload peer review for students

    /*
    public boolean uploadPeerReview(PeerReview peerReview){

    }
    */
}
