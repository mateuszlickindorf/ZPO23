public class UniversityDemo {
    public static void main(String[] args) {
        // Create a UniversityCatalog
        UniversityCatalog universityCatalog = new UniversityCatalog();

        UniversityCatalog.Subject subject1 = new UniversityCatalog.Subject("ZPO23",
                "Zaawansowane Programowanie Obiektowe", 2, 60, 4,
                UniversityCatalog.FormOfPassing.EGZAMIN, UniversityCatalog.ClassType.WYKLAD);

        UniversityCatalog.Subject subject2 = new UniversityCatalog.Subject("CPS23",
                "Cyfrowe przetwarzanie sygnałów", 4, 60,
                3, UniversityCatalog.FormOfPassing.EGZAMIN, UniversityCatalog.ClassType.CWICZENIA);

        universityCatalog.addSubject("ZPO23", subject1);
        universityCatalog.addSubject("CPS23", subject2);

        System.out.println("Subject Information:");
        printSubjectInfo(universityCatalog, "CS101");

        System.out.println("\nAll Subjects Information:");
        printAllSubjectsInfo(universityCatalog);

        UniversityCatalog.Subject updatedSubject = new UniversityCatalog.Subject("ZPO23",
                "Zaawansowane Projektowanie Okien 24/7", 12, 160,
                4, UniversityCatalog.FormOfPassing.ZALICZENIE, UniversityCatalog.ClassType.CWICZENIA);
        universityCatalog.addSubject("ZPO24/7", updatedSubject);

        System.out.println("\nAll Subjects Information After Update:");
        printAllSubjectsInfo(universityCatalog);

        universityCatalog.deleteSubject("CPS23");

        System.out.println("\nAll Subjects Information After Deletion:");
        printAllSubjectsInfo(universityCatalog);
    }

    private static void printSubjectInfo(UniversityCatalog catalog, String subjectId) {
        try {
            String subjectInfo = catalog.getSubjectInfo(subjectId);
            System.out.println(subjectInfo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printAllSubjectsInfo(UniversityCatalog catalog) {
        System.out.println(catalog.getAllSubjectsInfo());
    }
}