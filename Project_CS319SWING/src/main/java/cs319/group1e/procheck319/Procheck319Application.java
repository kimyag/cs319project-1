package cs319.group1e.procheck319;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Thread.sleep;

@SpringBootApplication
@Component
public class Procheck319Application {
    private static StudentRepository studentRepository;
    private static GroupRepository groupRepository;
    private static ClassRepository classRepository;
    private static InstructorAndTAsRepository instructorAndTAsRepository;

    public static NoGroupGUI noGroupDashboard;
    public static LoginRegisterGUI loginRegisterGUIScreen;
    public static InstructorGUI instructorScreen;
    public static GroupGUI groupDashboard;


    public Procheck319Application(StudentRepository studentRepository, GroupRepository groupRepository, ClassRepository classRepository, InstructorAndTAsRepository instructorAndTAsRepository){
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.classRepository = classRepository;
        this.instructorAndTAsRepository = instructorAndTAsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Procheck319Application.class, args);
        System.setProperty("java.awt.headless", "false"); //Disables headless
        //***********************************************************************************************************************************************************************
        System.out.println("\n\n****************SELAMLAR******************\n\n ");

        /*
        classRepository.deleteAll();
        Class erayClass = new Class("A", "CS",0, 319);
        classRepository.save(erayClass);

        User bedo = new Student("Bedirhan", "Sakinoglu" , "bedo123", 21801, "bedisakinoglu@gmail.com","student");
        User gok = new Student("Gokhan", "Tas" , "fener", 21802, "gokhan@gmail.com","student");
        User tutku = new Student("Utku","Sezer", "sebo", 21803, "darnque@gmail.com","student");
        User lara = new Student("Lara", "Fenerci", "yes", 21804, "lara@ug.bilkent.edu.tr","student");
        User kim = new Student("Kimya","Ghasem", "kimya", 21805, "kimya@ug.bilkent.edu.tr","student");

        erayClass.addStudentId(bedo.getUserId());
        erayClass.addStudentId(gok.getUserId());
        erayClass.addStudentId(tutku.getUserId());
        erayClass.addStudentId(lara.getUserId());
        erayClass.addStudentId(kim.getUserId());

        classRepository.save(erayClass);

        this.studentRepository.deleteAll();
        List<Student> users = Arrays.asList((Student) bedo, (Student) gok, (Student) tutku,(Student) lara, (Student) kim);
        List<Student> users2 = Arrays.asList( (Student) kim);
        this.studentRepository.saveAll(users);

        Group newGroup = new Group(5);
        newGroup.addGroupMember((Student) bedo);
        newGroup.addGroupMember((Student) gok);
        newGroup.addGroupMember((Student) lara);

        this.groupRepository.deleteAll();
        this.groupRepository.save(newGroup);
         */

        System.out.println("NASI YA");
        //----------------------------------------------------------------------
        if(instructorAndTAsRepository.findAll().size() < 3) {
            InstructorAndTAs tuzun = new InstructorAndTAs("eray", "tuzun", "4590", 345, "tuzun@gmail.com", "instructor");
            InstructorAndTAs jabrayilzade = new InstructorAndTAs("elgun", "jabrayilzade", "8886", 315, "jabrayilzade@gmail.com", "instructor");
            InstructorAndTAs tuna = new InstructorAndTAs("erdem", "tuna", "8886", 305, "tuna@gmail.com", "instructor");
            Class erayClass = tuzun.createClass("CS319", 319);
            tuzun.setClass(erayClass.getClassId());
            tuna.setClass(erayClass.getClassId());
            jabrayilzade.setClass(erayClass.getClassId());
            Project p =  erayClass.getProject();
            p.setMaxGroupSize(5);
            classRepository.save(erayClass);


            //-----------------------------Adding student and instructor-----------------------------
            Student s1 = new Student("ayşe", "fe", "3243", 400, "ayse@gmail.com", "student");
            Student s2 = new Student("fatma", "fe", "3243", 401, "fatma@gmail.com", "student");
            Student s3 = new Student("hayriye", "fe", "kdkf43", 402, "hayriye@gmail.com", "student");
            Student s4 = new Student("figen", "fe", "flg43", 403, "figen@gmail.com", "student");
            Student s5 = new Student("lale", "fe", "3fdş3", 404, "lale@gmail.com", "student");
            Student s6 = new Student("doga", "fe", "r56kty43", 405, "fkkvmdl", "student");
            Student s7 = new Student("aslı", "fe", "fdkkk", 406, "fdredfl", "student");
            Student s8 = new Student("ömer", "fe", "3dfll3", 407, "flckvdl", "student");
            Student s9 = new Student("fadik", "fe", "fvk3", 408, "fdaal", "student");
            Student s10 = new Student("leman", "fe", "3dfll3", 409, "fdssl", "student");
            Student s11 = new Student("furkan", "fe", "fkgkk43", 410, "fdfgl", "student");
            Student s12 = new Student("mali", "fe", "36793", 411, "fdlfd", "student");
            Student s13 = new Student("leonard", "fe", "3dflll3", 412, "fdlfg", "student");
            Student s14 = new Student("lara", "fe", "3dfll3", 413, "fdltı", "student");
            Student s15 = new Student("mehmet", "se", "dfkk42", 414, "fal", "student");

            erayClass.addStudentId(s1.getUserId());
            erayClass.addStudentId(s2.getUserId());
            erayClass.addStudentId(s3.getUserId());
            erayClass.addStudentId(s4.getUserId());
            erayClass.addStudentId(s5.getUserId());
            erayClass.addStudentId(s6.getUserId());
            erayClass.addStudentId(s7.getUserId());
            erayClass.addStudentId(s8.getUserId());
            erayClass.addStudentId(s9.getUserId());
            erayClass.addStudentId(s10.getUserId());
            erayClass.addStudentId(s11.getUserId());
            erayClass.addStudentId(s12.getUserId());
            erayClass.addStudentId(s13.getUserId());
            erayClass.addStudentId(s14.getUserId());
            erayClass.addStudentId(s15.getUserId());

            erayClass.addInstructorAndTAId(tuzun.getUserId());
            erayClass.addInstructorAndTAId(jabrayilzade.getUserId());
            erayClass.addInstructorAndTAId(tuna.getUserId());

            List<Student> users = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15);

            for(int i = 0; i < users.size() ; i++){
                users.get(i).setClassId(erayClass.getClassId());

            }

            studentRepository.saveAll(users);
            instructorAndTAsRepository.save(tuzun);
            instructorAndTAsRepository.save(jabrayilzade);
            instructorAndTAsRepository.save(tuna);
            classRepository.save(erayClass);
        }

        classRepository.findByClassId(319).setGroupCount( classRepository.findByClassId(319).getGroupIdList().size() );
        classRepository.save(classRepository.findByClassId(319));

        System.out.println("dsasad : " + classRepository.findByClassId(319).getGroupIdList().size());

        /*
        Group g1 = s1.formAGroup(erayClass.assignGroupId(), p.getMaxGroupSize()); // GROUP s1
        erayClass.addGroupId(g1.getGroupId());//

        Request req1 = s5.sendRequest(g1); // s5 GROUP 'a request a
        s1.acceptRequest(req1, g1, s5);
        studentRepository.saveAll(users);
        groupRepository.save(g1);


        Group gg = groupRepository.findByGroupId(s1.getGroupId());
        g1 = gg;
        Invitation invit = s1.sendInvitation(s15, g1); //s1 grubuna s15 i davet etti
        studentRepository.saveAll(users);
        groupRepository.save(g1);


        s15.acceptInvitation(invit, g1); //s15 s1 in gruba davet isteiğini kabul etti

        //Check s15
        System.out.println(s1.getGroupId());
        System.out.println("DbSeeder Checkpoint for g1 student list:" + g1.getStudentIdList());
        System.out.println("DbSeeder Checkpoint for g1 id no:" + g1.getGroupId());
        studentRepository.saveAll(users);
        groupRepository.save(g1);


        //Check s15
        System.out.println("DbSeeder Checkpoint for g1 student list:" + g1.getStudentIdList());

        Group g2 = new Group(erayClass.assignGroupId(), p.getMaxGroupSize());
        erayClass.addGroupId(g2.getGroupId());
        g2.addGroupMember(s2);
        g2.addGroupMember(s3);
        g2.addGroupMember(s4);
        groupRepository.save(g2);

        Group g3 = new Group(erayClass.assignGroupId(), p.getMaxGroupSize());
        erayClass.addGroupId(g3.getGroupId());
        g3.addGroupMember(s6);
        g3.addGroupMember(s7);
        g3.addGroupMember(s8);
        groupRepository.save(g3);

        Group g4 = new Group(erayClass.assignGroupId(), p.getMaxGroupSize());
        erayClass.addGroupId(g4.getGroupId());
        g4.addGroupMember(s14);
        groupRepository.save(g4);
        studentRepository.saveAll(users);

        System.out.println("--------------------BEFORE GROUP FORMATION DEADLINE-----------------------");
        for (int i = 0; i < erayClass.getGroupIdList().size(); i++) {
            System.out.println("Group " + erayClass.getGroupIdList().get(i));
            Group g = groupRepository.findByGroupId(erayClass.getGroupIdList().get(i));
            for (int j = 0; j < g.getStudentIdList().size(); j++) {
                Student s = studentRepository.findByUserId(g.getStudentIdList().get(j));
                System.out.println("    Student " + s.getUserName());
            }
        }

        List<Group> groups = groupRepository.findAll();
        List<Student> students = studentRepository.findAll();
        System.out.println("DENEME FOR INSTRUCTOR**********" + students);
        HashMap<Integer, List<Student>> studentsGroupsMap = new HashMap<>();

        System.out.println("BURASIII" + groups);

        //iterate over groups
        for (int i = 0; i < groups.size(); i++) {
            //create an empty student list to put group students and put that into map
            List<Student> g = new ArrayList<>();
            //iterate over students
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getGroupId() == groups.get(i).getGroupId()) {
                    g.add(students.get(j));
                }
            }
            studentsGroupsMap.put(groups.get(i).getGroupId(), g);
        }
        System.out.println("BURASIII---------" + studentsGroupsMap.get(groups.get(0).getGroupId()));

        erayClass.formRandomGroups(groups, studentsGroupsMap, students);
        groupRepository.saveAll(groups);
        studentRepository.saveAll(students);

        System.out.println("---------------AFTER GROUP FORMATION DEADLINE------------------");
        for (int i = 0; i < erayClass.getGroupIdList().size(); i++) {
            System.out.println("Group " + erayClass.getGroupIdList().get(i));
            Group g = groupRepository.findByGroupId(erayClass.getGroupIdList().get(i));
            for (int j = 0; j < g.getStudentIdList().size(); j++) {
                Student s = studentRepository.findByUserId(g.getStudentIdList().get(j));
                System.out.println("    Student " + s.getUserName());
            }
        }

        classRepository.save(erayClass);

        System.out.println("---------------ASSIGMENT------------------");
        //HashMap<Integer,List<Submissoin>>sSubmissionMap = new HashMap<>()
        //List<Assgnment> Assignments = ?
        //-----------------------------assignments-----------------------------
        //Map<Assignment,>
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

        List<Assignment> assignments = new ArrayList<>();
        assignments.add(assignment1);
        assignments.add(assignment2);
        assignments.add(assignment3);
        assignments.add(assignment4);
        assignments.add(assignment5);

        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).setGroupAssignmentList(assignments);
        }

        classRepository.save(erayClass);
        groupRepository.saveAll(groups);
        studentRepository.saveAll(students);

        s1 = students.get(0);
        s2 = students.get(1);
        s3 = students.get(2);
        s4 = students.get(3);
        s5 = students.get(4);
        s6 = students.get(5);
        s7 = students.get(6);
        s8 = students.get(7);
        s9 = students.get(8);
        s10 = students.get(9);
        s11 = students.get(10);
        s12 = students.get(11);
        s13 = students.get(12);
        s14 = students.get(13);
        s15 = students.get(14);

        System.out.println("Group ID ::::::::::::::::::::  " + s9.getGroupId());

        System.out.println(":) " + groupRepository.findByGroupId(s9.getGroupId()));

        //-----------------------------adding submissions-----------------------------
        Submission s1SubToAs1 = new Submission(assignment1);
        Submission s2SubToAs1 = new Submission(assignment1);
        Submission s6SubToAs1 = new Submission(assignment1);
        Submission s9SubToAs1 = new Submission(assignment1);

        List<Group> newGroups = Arrays.asList(groupRepository.findByGroupId(s1.getGroupId()), groupRepository.findByGroupId(s2.getGroupId()), groupRepository.findByGroupId(s6.getGroupId()), groupRepository.findByGroupId(s9.getGroupId()));

        s1.addSubmission(s1SubToAs1, assignment1, newGroups.get(0));
        s2.addSubmission(s2SubToAs1, assignment1, newGroups.get(1));
        s6.addSubmission(s6SubToAs1, assignment1, newGroups.get(2));
        s9.addSubmission(s9SubToAs1, assignment1, newGroups.get(3));
        ////////////////////////////////////////////////////////2/////3
        Submission s1SubToAs2 = new Submission(assignment2);
        Submission s2SubToAs2 = new Submission(assignment2);
        Submission s6SubToAs2 = new Submission(assignment2);
        Submission s9SubToAs2 = new Submission(assignment2);

        s1.addSubmission(s1SubToAs2, assignment2, newGroups.get(0));
        s2.addSubmission(s2SubToAs2, assignment2, newGroups.get(1));
        s6.addSubmission(s6SubToAs2, assignment2, newGroups.get(2));
        s9.addSubmission(s9SubToAs2, assignment2, newGroups.get(3));
        ///////////////////////////////////////////////////////////////

        Submission s1SubToAs3 = new Submission(assignment3);
        Submission s2SubToAs3 = new Submission(assignment3);
        Submission s6SubToAs3 = new Submission(assignment3);
        Submission s9SubToAs3 = new Submission(assignment3);

        s1.addSubmission(s1SubToAs3, assignment3, newGroups.get(0));
        s2.addSubmission(s2SubToAs3, assignment3, newGroups.get(1));
        //s6.addSubmission(s6SubToAs3,assignment3, newGroups.get(2));
        s9.addSubmission(s9SubToAs3, assignment3, newGroups.get(3));
        //////////////////////////////////////////////////////////////

        Submission s1SubToAs4 = new Submission(assignment4);
        Submission s2SubToAs4 = new Submission(assignment4);
        Submission s6SubToAs4 = new Submission(assignment4);
        Submission s9SubToAs4 = new Submission(assignment4);


        s1.addSubmission(s1SubToAs4, assignment4, newGroups.get(0));
        s2.addSubmission(s2SubToAs4, assignment4, newGroups.get(1));
        s6.addSubmission(s6SubToAs4, assignment4, newGroups.get(2));
        s9.addSubmission(s9SubToAs4, assignment4, newGroups.get(3));
        //////////////////////////////////////////////////////////////

        Submission s1SubToAs5 = new Submission(assignment5);
        Submission s2SubToAs5 = new Submission(assignment5);
        Submission s6SubToAs5 = new Submission(assignment5);
        Submission s9SubToAs5 = new Submission(assignment5);

        s1.addSubmission(s1SubToAs5, assignment5, newGroups.get(0));
        s2.addSubmission(s2SubToAs5, assignment5, newGroups.get(1));
        s6.addSubmission(s6SubToAs5, assignment5, newGroups.get(2));
        s9.addSubmission(s9SubToAs5, assignment5, newGroups.get(3));
        /////////////////////////////////////////////////////////
        users = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15);

        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);

        tuzun.announce("Hey guys. Form your groups until the deadline or the the system will randomly distribute you if you don't have any groups. Take care.", "Welcome to CS 319", erayClass, newGroups);
        jabrayilzade.announce("Hey guys i am your TA. You can ask me if you have any questions via chat in ProCheck.", "Hello!", erayClass, newGroups);
        tuzun.announce("Related to Grading update that we talked about today here is the latest version: Final 30%, Project 40 %, Midterm 15%,  Q1 (1)+GitLab(5)+Design Patterns Lab (7) + Attendance to final presentations (2)", "Grading", erayClass, newGroups);
        jabrayilzade.announce("Please share the links for these 2 things in the appropriate column in the Final Demo Schedule (a Google sheet to which you have write access) in the course page.", "Project Demo Links", erayClass, newGroups);
        tuzun.announceToAGroup(newGroups.get(0), "Guys I can give you feedback after tomorrows lecture.", "About Assignment 2");

        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);

        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("yaaani daha iyi olabilirdi sizden daha iyisini beklerdim...PU");
        feedbacks.add("aferim len size keretalar");
        feedbacks.add("on numara beş yıldız demek isterdim ama PU");
        feedbacks.add("olay yerindeyim rıza baba ama olay yok gibi..");
        for (int i = 0; i < erayClass.getProject().getAssignmentList().size(); i++) {
            for (int j = 0; j < erayClass.getProject().getAssignmentList().get(i).getSubmissionList().size(); j++) {
                InstructorFeedback instructorFeedback = tuzun.giveFeedback(feedbacks.get(j));
                erayClass.getProject().getAssignmentList().get(i).getSubmissionList().get(j).setFeedback(instructorFeedback);
            }
        }

        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);

        //----------------------GRADE PART------------------
        tuzun.gradeSubmission(s1SubToAs1, 70);
        tuzun.gradeSubmission(s2SubToAs1, 70);
        tuzun.gradeSubmission(s6SubToAs1, 95);
        tuzun.gradeSubmission(s9SubToAs1, 70);

        tuzun.gradeSubmission(s1SubToAs2, 50);
        tuzun.gradeSubmission(s2SubToAs2, 50);
        tuzun.gradeSubmission(s6SubToAs2, 60);
        tuzun.gradeSubmission(s9SubToAs2, 60);

        tuzun.gradeSubmission(s1SubToAs3, 20);
        tuzun.gradeSubmission(s2SubToAs3, 40);
        tuzun.gradeSubmission(s6SubToAs3, 20);
        tuzun.gradeSubmission(s9SubToAs3, 40);

        tuzun.gradeSubmission(s1SubToAs4, 77);

        tuzun.gradeSubmission(s1SubToAs5, 60);
        tuzun.gradeSubmission(s2SubToAs5, 65);
        tuzun.gradeSubmission(s6SubToAs5, 70);

        erayClass.calculateAllAverages();

        System.out.println("Average of assignment 1 : " + assignment1.getAverage());
        System.out.println("Average of assignment 2 : " + assignment2.getAverage());
        System.out.println("Average of assignment 3 : " + assignment3.getAverage());
        System.out.println("Average of assignment 4 : " + assignment4.getAverage());
        System.out.println("Average of assignment 5 : " + assignment5.getAverage());

        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);

        users.get(0).reviewPeer(users.get(14), 1, 3, 1, 2, 4, "I didnt like him", "I would never work with him ever again!");
        users.get(0).reviewPeer(users.get(10), 5, 5, 5, 5, 1, "He was generally good", "But I didnt like his personality");
        users.get(0).reviewPeer(users.get(4), 8, 5, 3, 5, 6, "He was really helpful", "");

        users.get(4).reviewPeer(users.get(0), 5, 5, 5, 5, 5, "bilemiyorum altan", "olur giibi");
        users.get(4).reviewPeer(users.get(14), 4, 4, 5, 5, 5, "super birisi", "");
        users.get(4).reviewPeer(users.get(10), 3, 4, 3, 5, 5, "daha iyi olabilirdi", "tamam");

        users.get(14).reviewPeer(users.get(0), 1, 1, 1, 1, 1, "Idiot", "No");
        users.get(14).reviewPeer(users.get(4), 2, 2, 3, 1, 2, "cs bilgisi yok sadece kopya çekerek gelmiş proje proje diye geziyor ama iş yapmıyor", "Çalışmam");
        users.get(14).reviewPeer(users.get(10), 5, 5, 5, 5, 5, "süper adam", "kesinlikle tekrar çalışmak isterim");

        users.get(10).reviewPeer(users.get(0), 3, 2, 1, 4, 3, "bana bisi yazdırmadı hic", "no comment");
        users.get(10).reviewPeer(users.get(4), 1, 1, 1, 4, 5, "venedik pasta ısmarladı", "vahim");
        users.get(10).reviewPeer(users.get(14), 2, 2, 5, 1, 1, "raporları yazdırmadı bana", "");

        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);

        //bu çalışıyor ----------------------------
        /*
        ArtifactReview ar = new ArtifactReview( "güzel olmuş ");
        s1SubToAs2.getArtifactReviews().add(ar);
        */
        //-----------------------------------------

/*
        users.get(0).reviewArtifact(users.get(0).getRandomArtifact(erayClass.getProject().getAssignmentList(), groupRepository.findByGroupId(users.get(0).getGroupId())), "bunu beğenmedim canım dostlarım");

        users.get(1).reviewArtifact(users.get(1).getRandomArtifact(erayClass.getProject().getAssignmentList(), groupRepository.findByGroupId(users.get(1).getGroupId())), "hiç güzel değil");

        users.get(5).reviewArtifact(users.get(5).getRandomArtifact(erayClass.getProject().getAssignmentList(), groupRepository.findByGroupId(users.get(5).getGroupId())), "harika olmuş çok beğendim");

        users.get(8).reviewArtifact(users.get(8).getRandomArtifact(erayClass.getProject().getAssignmentList(), groupRepository.findByGroupId(users.get(8).getGroupId())), "idare edebilir");

*/
        /*   BURASI BOZUK
        System.out.println("Group Id " + randSubmission.getGroupId());
        System.out.println("Artifact Review " + randSubmission.getArtifactReviews().get(0));


        Submission randSubmission = users.get(0).getRandomArtifact( groupRepository.findByGroupId(users.get(0).getGroupId()) );
        System.out.println("asdasdasdasdjhagsdasd" + randSubmission.getFeedback());
        //erayClass.getProject().getAssignmentList().get(randSubmission.getAssignmentNo()).getSubmissionList().get(randSubmission.getAssignmentNo()).getArtifactReviews().add(new ArtifactReview("AMELE MAL"));
        //System.out.println("MERHABA ARKADAŞLAR " + erayClass.getProject().getAssignmentList().get(randSubmission.getAssignmentNo()).getSubmissionList().get(randSubmission.getAssignmentNo()).getArtifactReviews().get(0));
        users.get(0).reviewArtifact( randSubmission,"bunu beğenmedim canım dostlarım");

        System.out.println("ARTİFACT FEEDBACK FALAN FİLAN " + randSubmission.getArtifactReviews().get(0));
*/
     /*
        studentRepository.saveAll(users);
        groupRepository.saveAll(newGroups);
        classRepository.save(erayClass);*/
//*********************************************************************************************************************************************************************************
        noGroupDashboard = new NoGroupGUI( instructorAndTAsRepository, studentRepository, groupRepository, classRepository);
        loginRegisterGUIScreen = new LoginRegisterGUI( studentRepository,  instructorAndTAsRepository,  classRepository);
        instructorScreen = new InstructorGUI(studentRepository, instructorAndTAsRepository, groupRepository, classRepository);
        groupDashboard = new GroupGUI( studentRepository,  groupRepository,  classRepository);

        loginRegisterGUIScreen.setVisible(true);

        //-----------------------------------------------------------
        while(loginRegisterGUIScreen.getGoTo() == null ) {
        }
        boolean flag = true;
        boolean ifSwitch = false;

        //LOGIN
        while(flag == true){
            System.out.println(loginRegisterGUIScreen.getGoTo());
            if (loginRegisterGUIScreen.getGoTo().equals("noGroupDashboard")) {
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                noGroupDashboard.setCurrentUser(studentRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                noGroupDashboard.setVisible(true);
                while(!noGroupDashboard.getCurrentUser().isGroupMember()){}
                ifSwitch = true;
                noGroupDashboard.setVisible(false);
                noGroupDashboard.dispose();
            }

            if (loginRegisterGUIScreen.getGoTo().equals("instructorDashboard")){
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                instructorScreen.setCurrentUser(instructorAndTAsRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                instructorScreen.setVisible(true);
                flag = false;
            }

            if (loginRegisterGUIScreen.getGoTo().equals("studentDashboard") || ifSwitch ) {
                System.out.println("GİRDİM AQ");
                loginRegisterGUIScreen.setVisible(false);
                loginRegisterGUIScreen.dispose();
                groupDashboard.setCurrentUser(studentRepository.findByUserId(loginRegisterGUIScreen.getUserId()));
                groupDashboard.setVisible(true);
                groupDashboard.repaint();
                groupDashboard.validate();
                flag = false;
            }

        }
    }

}
