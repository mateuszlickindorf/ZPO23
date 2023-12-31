import java.util.HashMap;
import java.util.Map;

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
}

