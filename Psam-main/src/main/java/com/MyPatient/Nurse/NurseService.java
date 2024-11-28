package com.MyPatient.Nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan({ "com.MyPatient.*" })
public class NurseService {
     NurseRepository nurseRepository;

    @Autowired  // Wstrzykiwanie przez konstruktor
    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }
    public List<Nurse> hi(){
        List<Nurse> nurses = nurseRepository.findAll();
        System.out.println("Nurses: " + nurses); // Loguj dane
        return nurses;
    }
    public Optional<Nurse> getFirstNurse() {
        List<Nurse> nurses = nurseRepository.findAll();
        if (!nurses.isEmpty()) {
            return Optional.of(nurses.get(0));  // Zwracamy pierwszą pielęgniarkę
        }
        return Optional.empty();
    }
}
