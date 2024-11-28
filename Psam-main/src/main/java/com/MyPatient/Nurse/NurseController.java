package com.MyPatient.Nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController

@ComponentScan({ "com.MyPatient.*" })

public class NurseController {

    private final NurseService nurseService;
    @Autowired(required = false)
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    public List<Nurse> hi(){
        return nurseService.hi();

    }
    public String getFirstNurse(){
        return nurseService.getFirstNurse()
                .map(Nurse::getF_name)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
    public String getFirstNurseEmail(){
        return nurseService.getFirstNurse()
                .map(Nurse::getEmail)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
    public String getFirstNurseFname(){
        return nurseService.getFirstNurse()
                .map(Nurse::getF_name)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
    public String getFirstNurseSname(){
        return nurseService.getFirstNurse()
                .map(Nurse::getS_name)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
    public String getFirstNurseLogin(){
        return nurseService.getFirstNurse()
                .map(Nurse::getLogin)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
    public LocalDate getFirstNurseBdate(){
        return nurseService.getFirstNurse()
                .map(Nurse::getB_date)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse(null);

    }
    public Integer getFirstNursePesel(){
        return nurseService.getFirstNurse()
                .map(Nurse::getPesel)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse(0);

    }
    public Integer getFirstNursePnumber(){
        return nurseService.getFirstNurse()
                .map(Nurse::getPhone_number)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse(0);

    }
    public String getFirstNursePassword(){
        return nurseService.getFirstNurse()
                .map(Nurse::getPassword)  // Jeśli pielęgniarka istnieje, zwracamy jej imię
                .orElse("No nurses found");

    }
}
