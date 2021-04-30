package cs319.group1e.procheck319;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class Procheck319Application {

    public static void main(String[] args) {
        SpringApplication.run(Procheck319Application.class, args);

        //-----------------------------Adding student and instructor-----------------------------
        Student s1 = new Student("ayşe","fe","3243",432,"fdl","student");
        Student s2 = new Student("fatma","fe","3243",432,"fdl","student");
        Student s3 = new Student("hayriye","fe","3243",432,"fdl","student");
        Student s4 = new Student("figen","fe","3243",432,"fdl","student");
        Student s5 = new Student("lale","fe","3243",432,"fdl","student");
        Student s6 = new Student("doga","fe","3243",432,"fdl","student");
        Student s7 = new Student("aslı","fe","3243",432,"fdl","student");
        Student s8 = new Student("ömer","fe","3243",432,"fdl","student");
        Student s9 = new Student("fadik","fe","3243",432,"fdl","student");
        Student s10 = new Student("leman","fe","3243",432,"fdl","student");
        Student s11 = new Student("furkan","fe","3243",432,"fdl","student");
        Student s12 = new Student("mali","fe","3243",432,"fdl","student");
        Student s13 = new Student("leonard","fe","3243",432,"fdl","student");
        Student s14 = new Student("lara","fe","3243",432,"fdl","student");
        Student s15 = new Student("mehmet","se","3242",432,"fal","student");
        InstructorAndTAs tuzun = new InstructorAndTAs("eray","tuzun","4590",345,"lkfgb","instructor");
        InstructorAndTAs jabrayilzade = new InstructorAndTAs("elgun","jabrayilzade","8886",315,"hehe","instructor");

        //-----------------------------creating class-----------------------------
        Class c = tuzun.createClass("CS319");
        String classKey = c.getClassKey();

        c.addInstructorAndTAs(tuzun);
        c.addInstructorAndTAs(jabrayilzade);

        //-----------------------------creating project-----------------------------
        Project p = c.getProject();
        p.setMaxGroupSize(5);

        //-----------------------------assignments-----------------------------

        Assignment assignment1 = new Assignment();
        assignment1.setAssignmentNo(1);
        assignment1.setTitle("README Document");
        assignment1.setVisibility(true);
        assignment1.setWeight(5);
        assignment1.setDeadline(2021, 1, 3);
        p.createAssignment(assignment1);

        Assignment assignment2 = new Assignment();
        assignment2.setAssignmentNo(2);
        assignment2.setTitle("Analysis Report Iteration 1");
        assignment2.setVisibility(true);
        assignment2.setWeight(0);
        assignment2.setDeadline(2022, 1, 6);
        p.createAssignment(assignment2);

        Assignment assignment3 = new Assignment();
        assignment3.setAssignmentNo(3);
        assignment3.setTitle("Design Report Iteration 1");
        assignment3.setVisibility(true);
        assignment3.setDeadline(2021, 4, 6);
        assignment3.setWeight(0);
        p.createAssignment(assignment3);

        Assignment assignment4 = new Assignment();
        assignment4.setAssignmentNo(4);
        assignment4.setTitle("Analysis Report Iteration 2");
        assignment4.setVisibility(true);
        assignment4.setWeight(25);
        assignment4.setDeadline(2021, 5, 3);
        p.createAssignment(assignment4);

        Assignment assignment5 = new Assignment();
        assignment5.setAssignmentNo(5);
        assignment5.setTitle("Design Report Iteration 2");
        assignment5.setVisibility(true);
        assignment5.setDeadline(2021, 11, 26);
        assignment5.setWeight(35);
        p.createAssignment(assignment5);

        Assignment assignment6 = new Assignment();
        assignment6.setAssignmentNo(6);
        assignment6.setTitle("Presentation");
        assignment6.setVisibility(true);
        assignment6.setDeadline(2021, 12, 29);
        assignment6.setWeight(10);
        p.createAssignment(assignment6);

        //-----------------------------classkey dogru girilirse eger-----------------------------
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);
        c.addStudent(s5);
        c.addStudent(s6);
        c.addStudent(s7);
        c.addStudent(s8);
        c.addStudent(s9);
        c.addStudent(s10);
        c.addStudent(s11);
        c.addStudent(s12);
        c.addStudent(s13);
        c.addStudent(s14);
        c.addStudent(s15);

        //-----------------------------group formation begins-----------------------------
        Group g1 = s1.formAGroup(p.getMaxGroupSize());
        c.addGroup(g1);
        //g1.addGroupMember(s5);

        //--------------------REQUEST-----------------------
        s5.sendRequest(g1);
        System.out.println("--------------------BEFORE SENDING A REQUEST-----------------------");
        System.out.println(c.getGroupOfAStudent(s1).getRequests());;
        s1.acceptRequest(c.getGroupOfAStudent(s1).getRequests().get(0), c.getGroupOfAStudent(s1));
        System.out.println("--------------------AFTER SENDING AND ACCEPTING A REQUEST-----------------------");
        System.out.println(g1);
        //--------------------REQUEST-----------------------

        //--------------------Invitation-----------------------
        s1.sendInvitation(s15, c.getGroupOfAStudent(s1));
        System.out.println("--------------------AFTER SENDING AN INVITATION-----------------------");
        System.out.println(s15.getInvitations().get(0));
        System.out.println("--------------------AFTER ACCEPTING THE REQUEST-----------------------");
        s5.acceptInvitation(s15.getInvitations().get(0));
        System.out.println(g1);
        //--------------------Invitation-----------------------

        //-----------------------------adding groups-----------------------------
        Group g2 = new Group();
        c.addGroup(g2);
        g2.setMaxGroupSize(p.getMaxGroupSize());
        g2.addGroupMember(s2);
        g2.addGroupMember(s3);
        g2.addGroupMember(s4);

        Group g3 = new Group();
        c.addGroup(g3);
        g3.setMaxGroupSize(p.getMaxGroupSize());
        g3.addGroupMember(s6);
        g3.addGroupMember(s7);
        g3.addGroupMember(s8);

        Group g4 = new Group();
        c.addGroup(g4);
        g4.setMaxGroupSize(p.getMaxGroupSize());
        g4.addGroupMember(s14);


        System.out.println("--------------------BEFORE GROUP FORMATION DEADLINE-----------------------");
        for( int i = 0 ; i < 4 ; i++ ){
            System.out.println( c.getGroups().get(i));
        }
        //---------------------------------------------------------------------
        c.formRandomGroups();
        System.out.println("---------------AFTER GROUP FORMATION DEADLINE------------------");
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println( c.getGroups().get(i));
        }

        System.out.println("---------------ASSIGNMENT and SUBMISSION------------------");
        //Adds the assignment list to all groups
        for(int i = 0; i < c.getGroups().size(); i++){
            c.getGroups().get(i).setGroupAssignmentList(c.getProject().getAssignmentList());
        }

        //-----------------------------adding submissions-----------------------------
        Submission s1SubToAs1 = new Submission( assignment1 );
        Submission s2SubToAs1 = new Submission( assignment1 );
        Submission s6SubToAs1 = new Submission( assignment1 );
        Submission s9SubToAs1 = new Submission( assignment1 );

        s1.addSubmission(s1SubToAs1,assignment1, c.getGroupOfAStudent(s1));
        s2.addSubmission(s2SubToAs1,assignment1,c.getGroupOfAStudent(s2));
        s6.addSubmission(s6SubToAs1,assignment1,c.getGroupOfAStudent(s6));
        s9.addSubmission(s9SubToAs1,assignment1,c.getGroupOfAStudent(s9));
        //////////////////////////////////////////////////////////////

        Submission s1SubToAs2 = new Submission( assignment2 );
        Submission s2SubToAs2 = new Submission( assignment2 );
        Submission s6SubToAs2 = new Submission( assignment2 );
        Submission s9SubToAs2 = new Submission( assignment2 );

        s1.addSubmission(s1SubToAs2,assignment2, c.getGroupOfAStudent(s1));
        s2.addSubmission(s2SubToAs2,assignment2, c.getGroupOfAStudent(s2));
        s6.addSubmission(s6SubToAs2,assignment2, c.getGroupOfAStudent(s6));
        s9.addSubmission(s9SubToAs2,assignment2, c.getGroupOfAStudent(s9));
        ///////////////////////////////////////////////////////////////

        Submission s1SubToAs3 = new Submission( assignment3 );
        Submission s2SubToAs3 = new Submission( assignment3 );
        Submission s6SubToAs3 = new Submission( assignment3 );
        Submission s9SubToAs3 = new Submission( assignment3 );

        s1.addSubmission(s1SubToAs3,assignment3, c.getGroupOfAStudent(s1));
        s2.addSubmission(s2SubToAs3,assignment3, c.getGroupOfAStudent(s2));
        s6.addSubmission(s6SubToAs3,assignment3, c.getGroupOfAStudent(s6));
        s9.addSubmission(s9SubToAs3,assignment3, c.getGroupOfAStudent(s9));
        //////////////////////////////////////////////////////////////

        Submission s1SubToAs4 = new Submission( assignment4 );
        Submission s2SubToAs4 = new Submission( assignment4 );
        Submission s6SubToAs4 = new Submission( assignment4 );
        Submission s9SubToAs4 = new Submission( assignment4 );

        s1.addSubmission(s1SubToAs4,assignment4, c.getGroupOfAStudent(s1));
        //s2.addSubmission(s2SubToAs4,assignment4);
        //s6.addSubmission(s6SubToAs4,assignment4);
        //s9.addSubmission(s9SubToAs4,assignment4);
        //////////////////////////////////////////////////////////////

        Submission s1SubToAs5 = new Submission( assignment5 );
        Submission s2SubToAs5 = new Submission( assignment5 );
        Submission s6SubToAs5 = new Submission( assignment5 );
        Submission s9SubToAs5 = new Submission( assignment5 );

        s1.addSubmission(s1SubToAs5,assignment5, c.getGroupOfAStudent(s1));
        s2.addSubmission(s2SubToAs5,assignment5, c.getGroupOfAStudent(s2));
        s6.addSubmission(s6SubToAs5,assignment5, c.getGroupOfAStudent(s6));
        //s9.addSubmission(s9SubToAs5,assignment5);
        //////////////////////////////////////////////////////////////

        for(int i = 0; i < c.getGroups().get(0).getGroupAssignmentList().size(); i++){
            Assignment assign = c.getProject().getAssignmentList().get(i);
            System.out.println("Deadline şu: " + assign.getDeadline() + " " );
        }

        System.out.println("LARA BURADA " + c.getGroupOfAStudent(s5).getGroupSubmissionList().get(0).getTitle());

        System.out.println("---------------INSTRUCTOR FEEDBACK------------------"); //GRADE VERMİYİ DAHAAAAA
        /*
            assignment1 ---> s1SubToAs1     s2SubToAs1     s3SubToAs1      s4SubToAs1
            assignment2 ---> s1SubToAs2     s2SubToAs2     s3SubToAs2      s4SubToAs2
            assignment3 ---> s1SubToAs3     s2SubToAs3     s3SubToAs3      s4SubToAs3
            assignment4 --->
            assignment5 --->
         */
        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("yaaani daha iyi olabilirdi sizden daha iyisini beklerdim...PU");
        feedbacks.add("aferim len size keretalar");
        feedbacks.add("on numara beş yıldız demek isterdim ama PU");
        feedbacks.add("olay yerindeyim rıza baba ama olay yok gibi..");
        for(int i = 0; i < c.getProject().getAssignmentList().size(); i++){
            for(int j = 0; j < c.getProject().getAssignmentList().get(i).getSubmissionList().size(); j++){
                InstructorFeedback instructorFeedback = tuzun.giveFeedback(feedbacks.get(j));
                c.getProject().getAssignmentList().get(i).getSubmissionList().get(j).setFeedback(instructorFeedback);
            }
        }

        //assignmentların submissionlarına yapılan feedbackleri görmek
        for(int i = 0; i < c.getProject().getAssignmentList().size(); i++){
            System.out.println("\n****"+c.getProject().getAssignmentList().get(i).getTitle()+"****");
            for(int j = 0; j < c.getProject().getAssignmentList().get(i).getSubmissionList().size(); j++){
                System.out.println(c.getProject().getAssignmentList().get(i).getSubmissionList().get(j).getFeedback());
            }
        }
        //gruplara yapılmış instructor feedbackleri görmek
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("\nGroup "+i);
            for(int j = 0; j < c.getGroups().get(i).getGroupSubmissionList().size(); j++){
                System.out.println("\n**"+c.getGroups().get(i).getGroupSubmissionList().get(j).getTitle()+"**");
                System.out.println(c.getGroups().get(i).getGroupSubmissionList().get(j).getFeedback());
            }
        }

        //--------------------PEER REVIEW-----------------------
        System.out.println("--------------------PEER REVIEW-------------------");
        // peer review available ise        s1 s5 s15 s11 --- s2 s3 s4 s12 --- s6 s7 s8 s13 --- s14 s9 s10

        s1.reviewPeer(s15, 1, 3, 1, 2, 4, "I didnt like him", "I would never work with him ever again!");
        s1.reviewPeer(s11, 5, 5, 5, 5, 1, "He was generally good", "But I didnt like his personality");
        s1.reviewPeer(s5, 8, 5,3,5,6, "He was really helpful", "");

        s5.reviewPeer(s1,5,5,5,5,5, "bilemiyorum altan","olur giibi");
        s5.reviewPeer(s15,4,4,5,5, 5, "super birisi", "");
        s5.reviewPeer(s11,3,4,3,5,5,"daha iyi olabilirdi", "tamam");


        s15.reviewPeer(s1, 1, 1,1,1,1, "Idiot", "No");
        s15.reviewPeer(s11, 2, 2,3,1, 2 , "cs bilgisi yok sadece kopya çekerek gelmiş proje proje diye geziyor ama iş yapmıyor", "Çalışmam");
        s15.reviewPeer(s11, 5, 5,5,5, 5 , "süper adam", "kesinlikle tekrar çalışmak isterim");

        s11.reviewPeer(s1,3,2,1,4,3,"bana bisi yazdırmadı hic","no comment");
        s11.reviewPeer(s5,1,1,1,4,5,"venedik pasta ısmarladı","vahim");
        s11.reviewPeer(s15,2,2,5,1,1,"raporları yazdırmadı bana","");


        //SHOWING THE PEER REVIEWS OF GROUP 1
        for(int i = 0; i < c.getGroups().get(0).getStudentList().size(); i++){
            System.out.println("Student " + c.getGroups().get(0).getStudentList().get(i).getUserName() + " has peer reviews as follows...");
            for(int j = 0; j < c.getGroups().get(0).getStudentList().get(i).getPeerReviews().size(); j++){
                System.out.println(c.getGroups().get(0).getStudentList().get(i).getPeerReviews().get(j));
            }
        }


        //--------------------Artifact Review -----------------------

        System.out.println("\n----------------Artifact Review--------------------\n");

        Submission sub = s1.reviewArtifact("bunu beğenmedim canım dostlarım" , c.getGroupOfAStudent(s1));

        System.out.println("ARTIFACT REVIEW: " + sub.getArtifactReviews().get(0));

/*
        //----------------------INTSTRUCTOR MAKES AN ANNOUNCEMENT
        Announcement announcement1 = tuzun.announce("Related to Grading update that we talked about today here is the latest version: Final 30%, Project 40 %, Midterm 15%,  Q1 (1)+GitLab(5)+Design Patterns Lab (7) + Attendance to final presentations (2)","Grading");
        Announcement announcement2 = jabrayilzade.announce("Please share the links for these 2 things in the appropriate column in the Final Demo Schedule (a Google sheet to which you have write access) in the course page.","Project Demo Links");
        c.addAnnouncement(announcement1);
        c.addAnnouncement(announcement2);

        //displaying announcements in the class
        System.out.println("-----------CLASS ANNOUNCEMENTS-----------");
        for(int i = 0; i < c.getAnnouncementList().size(); i++){
            System.out.println(c.getAnnouncementList().get(i));
        }

        //displaying announcements from group class
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("-----------GROUP " + (i+1) + "s ANNOUNCEMENTS-----------");
            for(int j = 0; j < c.getGroups().get(i).getAnnouncementList().size(); j++){
                System.out.println(c.getGroups().get(i).getAnnouncementList().get(j));
            }
        }
*/
        //displaying progress for each group
        System.out.println("-----------PROGRESS FOR EACH GROUP-----------");
        for(int i = 0; i < c.getGroups().size(); i++){
            System.out.println("-----------GROUP " + (i+1) + "s PROGRESS-----------");
            c.getGroups().get(i).calculateProgress();
            System.out.println("%"+c.getGroups().get(i).getProgress());
        }

        System.out.println("\n-----------GRADING-----------");
        tuzun.gradeSubmission(s1SubToAs1, 70);
        tuzun.gradeSubmission(s2SubToAs1, 70);
        tuzun.gradeSubmission(s6SubToAs1, 90);
        tuzun.gradeSubmission(s9SubToAs1, 90);

        tuzun.gradeSubmission(s1SubToAs2, 50);
        tuzun.gradeSubmission(s2SubToAs2, 50);
        tuzun.gradeSubmission(s6SubToAs2, 60);
        tuzun.gradeSubmission(s9SubToAs2, 60);

        //tuzun.gradeSubmission(s1SubToAs3, 20);
        tuzun.gradeSubmission(s2SubToAs3, 40);
        //tuzun.gradeSubmission(s6SubToAs3, 20);
        //tuzun.gradeSubmission(s9SubToAs3, 40);

        tuzun.gradeSubmission(s1SubToAs4, 77);

        tuzun.gradeSubmission(s1SubToAs5, 60);
        tuzun.gradeSubmission(s2SubToAs5, 65);
        tuzun.gradeSubmission(s6SubToAs5, 70);


        System.out.println("Grade: " + s1SubToAs1.getGrade());
        System.out.println("Grade: " + s2SubToAs1.getGrade());


        System.out.println("\n-----------ANNOUNCEMENT-----------\n");
        tuzun.announce("Hey guys. Form your groups until the deadline or the the system will randomly distribute you if you don't have any groups. Take care." , "Welcome to CS 319");
        jabrayilzade.announce("Hey guys i am your TA. You can ask me if you have any questions via chat in ProCheck." , "Hello!");
        tuzun.announce("Related to Grading update that we talked about today here is the latest version: Final 30%, Project 40 %, Midterm 15%,  Q1 (1)+GitLab(5)+Design Patterns Lab (7) + Attendance to final presentations (2)","Grading");
        jabrayilzade.announce("Please share the links for these 2 things in the appropriate column in the Final Demo Schedule (a Google sheet to which you have write access) in the course page.","Project Demo Links");

        tuzun.announceToAGroup(g1, "Guys I can give you feedback at the end of the tomorrows lecture.", "About Submission 1 Feedback");

        System.out.print( "Group 1 Announcements ---------------------------------" );
        for(int i = 0 ; i < g1.getAnnouncementList().size() ; i++){
            System.out.println( "\n" + (i+1) + ")" + g1.getAnnouncementList().get(i).getTitle() );
            System.out.println( g1.getAnnouncementList().get(i).getContext() );
            System.out.println( "written by - " + g1.getAnnouncementList().get(i).getAuthor() );
        }

        System.out.print( "\nGroup 2 Announcements -------------------------------" );
        for(int i = 0 ; i < g2.getAnnouncementList().size() ; i++){
            System.out.println( "\n" + (i+1) + ")" + g2.getAnnouncementList().get(i).getTitle() );
            System.out.println( g2.getAnnouncementList().get(i).getContext() );
            System.out.println( "written by - " + g2.getAnnouncementList().get(i).getAuthor() );
        }

        System.out.println("\n-----------CALCULATE AVERAGE-----------\n");
        c.calculateAllAverages();
        for(int i = 0 ; i < p.getAssignmentList().size() ; i++) {
            System.out.println( "Average of Assignment " + (i+1) + " : " + p.getAssignmentList().get(i).getAverage());
        }
    }


}
