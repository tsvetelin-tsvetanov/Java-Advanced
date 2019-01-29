public class main {
    public static void main(String[] args) {
        //IOManager.traverseDirectory("/home");

        StudentsRepository.initializeData();
        StudentsRepository.getStudentsByCourse("Unity");
    }
}
