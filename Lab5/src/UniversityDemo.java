import java.io.*;
public class UniversityDemo {
    public static void main(String[] args) {
        // Create a UniversityCatalog
        UniversityCatalog universityCatalog = new UniversityCatalog();

        UniversityCatalog.Subject subject1 = new UniversityCatalog.Subject("ZPO23", "Zaawansowane Programowanie Obiektowe", 2, 60, 4, UniversityCatalog.FormOfPassing.EGZAMIN);
        UniversityCatalog.Subject subject2 = new UniversityCatalog.Subject("CPS23", "Cyfrowe przetwarzanie sygnałów", 4, 60, 3, UniversityCatalog.FormOfPassing.EGZAMIN);

        universityCatalog.addSubject("ZPO23", subject1);
        universityCatalog.addSubject("CPS23", subject2);

        System.out.println("Subject Information:");
        printSubjectInfo(universityCatalog, "CS101");

        System.out.println("\nAll Subjects Information:");
        printAllSubjectsInfo(universityCatalog);

        UniversityCatalog.Subject updatedSubject = new UniversityCatalog.Subject("ZPO23", "Zaawansowane Projektowanie Okien 24/7", 12, 160, 4, UniversityCatalog.FormOfPassing.ZALICZENIE);
        universityCatalog.addSubject("ZPO24/7", updatedSubject);

        System.out.println("\nAll Subjects Information After Update:");
        printAllSubjectsInfo(universityCatalog);

        universityCatalog.deleteSubject("CPS23");

        System.out.println("\nAll Subjects Information After Deletion:");
        printAllSubjectsInfo(universityCatalog);

        UniversityCatalog catalog2 = new UniversityCatalog();
        catalog2.addSubject("CS101", new UniversityCatalog.Subject("ZPO24", "Zaawansowane Parkowanie Opla 24", 3, 45, 5, UniversityCatalog.FormOfPassing.EGZAMIN));
        catalog2.addSubject("ENG201", new UniversityCatalog.Subject("CPS24", "Cyfrowe Poławianie Stawu 24", 2, 30, 3, UniversityCatalog.FormOfPassing.ZALICZENIE));

        // Export the catalog to JSON

        try {
            catalog2.exportToJson("catalog2.json");
            System.out.println("Catalog exported to JSON successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting catalog to JSON: " + e.getMessage());
        }

        // Import the catalog from JSON
        try {
            catalog2.importFromJson("catalog2.json");
            System.out.println("Catalog imported from JSON successfully.");
        } catch (IOException e) {
            System.err.println("Error importing catalog from JSON: " + e.getMessage());
        }

        // Display information about all subjects in the catalog
        System.out.println("Subject information after import:\n" + catalog2.getAllSubjectsInfo());
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