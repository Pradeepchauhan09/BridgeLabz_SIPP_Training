import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    public abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "candidateName='" + candidateName + '\'' +
                ", jobRole=" + jobRole.getRoleName() +
                '}';
    }
}

public class ResumeScreening {

    public static void screenResumes(List<? extends JobRole> jobRoles) {
        System.out.println("Screening resumes for the following job roles:");
        for (JobRole role : jobRoles) {
            System.out.println("- " + role.getRoleName());
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(resume1.getJobRole());
        jobRoles.add(resume2.getJobRole());
        jobRoles.add(resume3.getJobRole());

        screenResumes(jobRoles);

        System.out.println("\nResumes:");
        System.out.println(resume1);
        System.out.println(resume2);
        System.out.println(resume3);
    }
}
