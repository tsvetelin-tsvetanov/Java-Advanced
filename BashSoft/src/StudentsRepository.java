import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentsRepository {
    private static boolean isDataInitialized = false;
    private static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(){
        if(isDataInitialized){
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<String, HashMap<String, ArrayList<Integer>>>();
        readData();
    }

    private static void readData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("")){
            String[] tokens = input.split("\\s+");
            String course = tokens[0];
            String student = tokens[1];
            Integer mark = Integer.parseInt(tokens[2]);

            if(!studentsByCourse.containsKey(course)){
                studentsByCourse.put(course, new HashMap<>());
            }

            if(!studentsByCourse.get(course).containsKey(student)){
                studentsByCourse.get(course).put(student, new ArrayList<>());
            }

            studentsByCourse.get(course).get(student).add(mark);
            input = scanner.nextLine();
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read complete.");
    }

    private static boolean isQueryForCoursePossible(String courseName){
        if(!isDataInitialized){
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if(!studentsByCourse.containsKey(courseName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
            return false;
        }

        return true;
    }

    private static boolean isQueryForStudentsPossible(String courseName, String studentName){
        if(!isQueryForCoursePossible(courseName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTENT_COURSE);
            return false;
        }

        if(studentsByCourse.get(courseName).containsKey(studentName)){
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

    private static void getStudentMarksInCourse(String course, String student){
        if(!isQueryForStudentsPossible(course, student)){
            return;
        }

        ArrayList<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student, marks);
    }

    public static void getStudentsByCourse(String course){
        if(!isQueryForCoursePossible(course)){
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for(Map.Entry<String, ArrayList<Integer>> student : studentsByCourse.get(course).entrySet()){
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }

}
