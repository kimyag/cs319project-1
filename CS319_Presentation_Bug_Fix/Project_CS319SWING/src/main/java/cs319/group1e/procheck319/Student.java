package cs319.group1e.procheck319;

//import cs319.group1e.repositories.StudentRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.util.ArrayList;
import java.util.List;

@Document("Students")
public class Student implements User {

    //Properties
    private String userName;
    private String userSurname;
    private String password;
    @Id
    private int userId;
    private String email;
    private String type;

    private int groupId;
    private List<PeerReview> peerReviews;
    private boolean isGroupMember;
    private boolean isRegisteredInClass;
    private List<Invitation> invitations;

    private int classId;

    //Default Constructor
    public Student() {
        String userName = "";
        String userSurname = "";
        String password = "";
        int userId = -5;
        String email = "";
        String type = "student";

        int groupId = -1;
        List<PeerReview> peerReviews = new ArrayList<>();
        boolean isGroupMember = false;
        boolean isRegisteredInClass = false;
        List<Invitation> invitations = new ArrayList<>();
    }

    //Constructor
    public Student(String userName, String userSurname, String password, int userId, String email, String type, int groupId, List<PeerReview> peerReviews, boolean isGroupMember, boolean isRegisteredInClass, Group studentGroup, List<Invitation> invitations, int classId) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.groupId = groupId;
        this.classId = classId;
        this.invitations = invitations;
        this.peerReviews = peerReviews;
        this.isGroupMember = isGroupMember;
        this.isRegisteredInClass = isRegisteredInClass;
        this.classId = classId;
        //this.studentGroup = studentGroup;
    }

    //Constructor for Seeder
    public Student(String userName, String userSurname, String password, int userId, String email, String type) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.invitations = new ArrayList<>();
        this.peerReviews = new ArrayList<>();
        this.groupId = -1;
        this.classId = -1;
        this.isGroupMember = false;
        this.isRegisteredInClass = false;
    }

    //Getters
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

    public int getGroupId() {
        return groupId;
    }

    public int getClassId() {
        return classId;
    }

    public List<PeerReview> getPeerReviews() {
        return peerReviews;
    }

    public boolean isGroupMember() {
        return isGroupMember;
    }

    public boolean isRegisteredInClass() {
        return isRegisteredInClass;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    //Setters
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

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }
    public void setPeerReviews(List<PeerReview> peerReviews) {
        this.peerReviews = peerReviews;
    }

    public void setGroupMember(boolean groupMember) {
        isGroupMember = groupMember;
    }

    public void setRegisteredInClass(boolean registeredInClass) {
        isRegisteredInClass = registeredInClass;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    /*
        OPERATIONS OF STUDENT
     */

    /**
      Student forms a group on his/her own
     */
    public Group formAGroup(int id, int maxGroupSize){
        Group group = new Group(id, maxGroupSize);
        group.addGroupMember(this);
        return group;
    }

    /**
     * Student adds a submission to an assignment on behalf of group
     */
    public void addSubmission(Submission submission, Assignment assignment, Group studentGroup){
            submission.setGroupId( this.groupId );
            studentGroup.getGroupSubmissionList().add(submission);
            assignment.getSubmissionList().add(submission);
            studentGroup.getGroupAssignmentList().get(assignment.getAssignmentNo()-1).setSubmissionList(assignment.getSubmissionList());
    }

    /**
     Student reviews a peer
     */
    public void reviewPeer(Student s, int point1, int point2, int point3, int point4, int point5, String response1, String response2 ){
        if(this.groupId == s.getGroupId()){
            List<Integer> arrPoint = new ArrayList<Integer>();
            arrPoint.add(point1);
            arrPoint.add(point2);
            arrPoint.add(point3);
            arrPoint.add(point4);
            arrPoint.add(point5);
            List<String> arrText = new ArrayList<String>();
            arrText.add(response1);
            arrText.add(response2);
            PeerReview pr = new PeerReview(arrPoint, arrText);
            s.getPeerReviews().add(pr);
        }
    }

    public Submission getRandomArtifact(List<Assignment> assignmentList, Group studentGroup){
        int index = -1;

        for( int i = 0; i < assignmentList.size() ; i++ ){
            if(assignmentList.get(i).isDeadlineOver() ){
                index = i;
            }
        }
        if( index == -1){
        }
        else {
            return studentGroup.getRandomGroupArtifact( assignmentList.get(index) );
        }
        return null;
    }

    public ArtifactReview reviewArtifact(Submission sub, String context){
        ArtifactReview artifactReview = new ArtifactReview( context );
        //sub.getArtifactReviews().add(artifactReview);
        return artifactReview;
    }


    /**
      Student sends a request to a group
     */
    public Request sendRequest(Group group){ //TODO: BURAYA BAK Bİ HELEEEEEEEEEEEEEEE
        Request request = new Request(group.getGroupId(),this.userId);
        group.getRequests().add(request);
        return request;
    }

    /**
      Student views specific submission's feedback
     */
    public void viewFeedback(String instructorFeedback){
        System.out.println(instructorFeedback);
    }

    /**
      Student views an artifact review
     */
    public void viewArtifactReview(ArtifactReview artifactReview){
        System.out.println(artifactReview);
    }

    /**
      Student views the invitation
     */
    public void viewInvitation(int index){
        System.out.println(this.getInvitations().get(index));
    }

    /**
        TODO
     */
    public boolean isDeadlineClose(Group studentGroup, int index){
        return true;
    }

    /**
      Student edits his/her belonging group---- ARTIK YOK----(SILEBILIRIZ)
     */
    /*public void editGroupCalendar(Group studentGroup){
        studentGroup.editCalendar(studentGroup.getCalendar());
    }*/

    public void acceptRequest(Request req , Group receiverGroup, Student senderStudent){
        if(!receiverGroup.isFull()){
            receiverGroup.addGroupMember(senderStudent); //kabul edileni gruba kaydet
            receiverGroup.getRequests().remove(req);
        }
    }
    /**
     Student sends an invitation to a student on behalf of the group
     Student will get the studentId of the student that will be invited to this student's group
     */
    public Invitation sendInvitation(Student receiverStudent, Group senderGroup){ //TODO:Test case için değiştirildi, tekrar değişti
        if(!senderGroup.isFull()){
            Invitation invitation = new Invitation(receiverStudent.getUserId(),senderGroup.getGroupId());
            receiverStudent.addInvitation(invitation);
            //studentGroup.getInvitations().add(invitation);
            return invitation;
        }
        return null;
    }

    /**
      Adding invitation to the student
     */
    public void addInvitation(Invitation invitation){
        invitations.add(invitation);
    }

    public boolean equals(Student s) {
        if(this.getUserId() == s.getUserId() ){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.userName;
    }
    /**
     Accept incoming invitation---- ARTIK YOK----(SILEBILIRIZ)
     */
    /*public void acceptInvitation(Invitation inv, Group senderGroup){
        if(!senderGroup.isFull()){
            senderGroup.addGroupMember(this);
            //inv.getSender().getInvitations().remove(inv);
            this.getInvitations().remove(inv);
        }else {
            this.getInvitations().remove(inv);
            //senderGroup.getInvitations().remove(inv);
        }
    }*/

    /**
     Reject incoming invitation---- ARTIK YOK----(SILEBILIRIZ)
     */
    /*public void rejectInvitation(Invitation inv) {
        this.getInvitations().remove(inv);
    }*/

}
