import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        patients.add(patient);
        System.out.println(name + " consulted " + patient.name);
    }
}

class Hospital {
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
}
