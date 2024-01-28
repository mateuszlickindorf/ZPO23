import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UniversityCatalog {
    private Map<String, Subject> subjects;

    public UniversityCatalog() {
        subjects = new HashMap<>();
    }

    /**
     * Adds a subject to the catalog.
     *
     * @param subjectId    The ID of the subject.
     * @param subject      The Subject object containing information about the subject.
     * @throws IllegalArgumentException If the subject ID is already in use.
     */
    public void addSubject(String subjectId, Subject subject) {
        if (!subjects.containsKey(subjectId)) {
            subjects.put(subjectId, subject);
        } else {
            throw new IllegalArgumentException("Subject ID already exists.");
        }
    }

    /**
     * Deletes a subject from the catalog.
     *
     * @param subjectId The ID of the subject to delete.
     * @throws IllegalArgumentException If the subject ID is not found.
     */
    public void deleteSubject(String subjectId) {
        if (subjects.containsKey(subjectId)) {
            subjects.remove(subjectId);
        } else {
            throw new IllegalArgumentException("Subject ID not found.");
        }
    }

    /**
     * Lists information about a specific subject.
     *
     * @param subjectId The ID of the subject to retrieve information about.
     * @return Information about the specified subject.
     * @throws IllegalArgumentException If the subject ID is not found.
     */
    public String getSubjectInfo(String subjectId) {
        if (subjects.containsKey(subjectId)) {
            Subject subject = subjects.get(subjectId);
            return subject.toString();
        } else {
            throw new IllegalArgumentException("Subject ID not found.");
        }
    }

    /**
     * Lists information about all subjects in the catalog.
     *
     * @return Information about all subjects.
     */
    public String getAllSubjectsInfo() {
        StringBuilder result = new StringBuilder("Subjects in the catalog:\n");
        for (Subject subject : subjects.values()) {
            result.append(subject.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Represents a subject at the University.
     */
    public static class Subject {
        private String courseId;
        private String courseName;
        private int ectsCredits;
        private int hoursInSemester;
        private int hoursInWeek;
        private FormOfPassing formOfPassing;

        public Subject(String courseId, String courseName, int ectsCredits,
                       int hoursInSemester, int hoursInWeek, FormOfPassing formOfPassing) {
            this.courseId = courseId;
            this.courseName = courseName;
            this.ectsCredits = ectsCredits;
            this.hoursInSemester = hoursInSemester;
            this.hoursInWeek = hoursInWeek;
            this.formOfPassing = formOfPassing;
        }
        /**
         * Gets the ID of the course.
         *
         * @return The course ID.
         */
        public String getCourseId() {
            return courseId;
        }

        /**
         * Gets the name of the course.
         *
         * @return The course name.
         */
        public String getCourseName() {
            return courseName;
        }

        /**
         * Gets the number of ECTS credits for the course.
         *
         * @return The number of ECTS credits.
         */
        public int getEctsCredits() {
            return ectsCredits;
        }

        /**
         * Gets the amount of hours in a semester for the course.
         *
         * @return The amount of hours in a semester.
         */
        public int getHoursInSemester() {
            return hoursInSemester;
        }

        /**
         * Gets the amount of hours in a week for the course.
         *
         * @return The amount of hours in a week.
         */
        public int getHoursInWeek() {
            return hoursInWeek;
        }

        /**
         * Gets the form of passing the course.
         *
         * @return The form of passing (Exam or Completion).
         */
        public FormOfPassing getFormOfPassing() {
            return formOfPassing;
        }

        /**
         * Converts the subject information to a string representation.
         *
         * @return The string representation of the subject.
         */
        @Override
    public String toString() {
        return "Subject{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", ectsCredits=" + ectsCredits +
                ", hoursInSemester=" + hoursInSemester +
                ", hoursInWeek=" + hoursInWeek +
                ", formOfPassing=" + formOfPassing +
                '}';
        }
    }

    /**
     * Enum class representing the form of passing a course.
     */
    public enum FormOfPassing {
        EGZAMIN, ZALICZENIE
    }

    /**
     * Exports the catalog to a JSON format file.
     *
     * @param fileName The name of the JSON file.
     * @throws IOException If an I/O error occurs.
     */
    public void exportToJson(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name must be specified.");
        }

        try (Writer writer = new FileWriter(fileName)) {
            writer.write("[\n");

            boolean firstSubject = true;
            for (Subject subject : subjects.values()) {
                if (!firstSubject) {
                    writer.write(",\n");
                } else {
                    firstSubject = false;
                }
                writeSubjectToJson(writer, subject);
            }

            writer.write("\n]\n");
        } catch (IOException e) {
            throw new IOException("Error exporting to JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Imports the catalog from a JSON format file.
     *
     * @param fileName The name of the JSON file.
     * @throws IOException If an I/O error occurs.
     */
    public void importFromJson(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name must be specified.");
        }

        try {
            if (Files.exists(Paths.get(fileName))) {
                String jsonContent = new String(Files.readAllBytes(Paths.get(fileName)));
                subjects.clear();
                parseJsonSubjects(jsonContent);
            } else {
                throw new FileNotFoundException("File not found: " + fileName);
            }
        } catch (IOException e) {
            throw new IOException("Error importing from JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Writes a subject to the given writer in JSON format.
     *
     * @param writer  The writer to write JSON content to.
     * @param subject The subject to be written.
     * @throws IOException If an I/O error occurs.
     */
    private void writeSubjectToJson(Writer writer, Subject subject) throws IOException {
        writer.write("{\n");
        writer.write("\"courseId\": \"" + subject.getCourseId() + "\",\n");
        writer.write("\"courseName\": \"" + subject.getCourseName() + "\",\n");
        writer.write("\"ectsCredits\": " + subject.getEctsCredits() + ",\n");
        writer.write("\"type\": \"" + subject.getFormOfPassing() + "\",\n");
        writer.write("\"hoursInWeek\": " + subject.getHoursInWeek() + ",\n");
        writer.write("\"hoursInSemester\": " + subject.getHoursInSemester() + ",\n");
        writer.write("}");
    }

    /**
     * Parses JSON content and populates the subjects in the catalog.
     *
     * @param jsonContent The JSON content to be parsed.
     */
    private void parseJsonSubjects(String jsonContent) {
        // Assuming each subject is enclosed in curly braces
        String[] subjectJsonArray = jsonContent.split("\\},\\s*\\{");

        for (String subjectJson : subjectJsonArray) {
            // Remove leading and trailing braces if present
            subjectJson = subjectJson.replaceAll("^\\{\\s*|\\s*}$", "");

            String[] properties = subjectJson.split(",\\s*");

            String courseId = extractValue(properties[0]);
            String courseName = extractValue(properties[1]);
            int ectsCredits = Integer.parseInt(extractValue(properties[2]));
            String formOfPassing = extractValue(properties[3]);
            int hoursInWeek = Integer.parseInt(extractValue(properties[4]));
            int hoursInSemester = Integer.parseInt(extractValue(properties[5])); // Add parsing logic

            Subject subject = new Subject(courseId, courseName, ectsCredits, hoursInSemester, hoursInWeek,
                    FormOfPassing.valueOf(formOfPassing)); // Adjust constructor arguments
            addSubject(courseId, subject);
        }
    }

    /**
     * Extracts the value from a property in the JSON string.
     *
     * @param property The property in the JSON string.
     * @return The extracted value.
     */
    private String extractValue(String property) {
        String[] keyValue = property.split(":\\s*");
        return keyValue[1].replaceAll("^\"|\"$", "").trim();
    }
}


