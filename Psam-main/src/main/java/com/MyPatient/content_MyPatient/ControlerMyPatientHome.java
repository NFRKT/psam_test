package com.MyPatient.content_MyPatient;
import com.MyPatient.Nurse.NurseController;
import com.MyPatient.Nurse.Nurse;
import com.MyPatient.Nurse.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
@Controller

@ComponentScan({ "com.MyPatient.*" })
public class ControlerMyPatientHome {

    @Autowired
    private NurseController controller;

    @GetMapping("/home")
    public String home(Model model) {


        model.addAttribute("nurse", controller.getFirstNurse());
        model.addAttribute("message", "MyPatient");
        model.addAttribute("Username", "Asia");
        return "home"; // Zwraca nazwę szablonu (home.html)
    }
    @GetMapping("/AddPatient")
    public String AddPatient(Model model) {
        model.addAttribute("message", "Dodawanie Pacjenta");
        model.addAttribute("Username", "Asia");
        return "AddPatient"; // Zwraca nazwę szablonu (home.html)
    }
    @GetMapping("/EditProfile")
    public String EditProfile(Model model) {
        model.addAttribute("nurseEmail", controller.getFirstNurseEmail());
        model.addAttribute("nursePnumber", controller.getFirstNursePnumber());
        model.addAttribute("nurseSname", controller.getFirstNurseSname());
        model.addAttribute("nurseFname", controller.getFirstNurseFname());
        model.addAttribute("nurseBdate", controller.getFirstNurseBdate());
        model.addAttribute("nursePesel", controller.getFirstNursePesel());
        model.addAttribute("nurseLogin", controller.getFirstNurseLogin());
        model.addAttribute("nursePassword", controller.getFirstNursePassword());
        model.addAttribute("message", "Edycja profilu");
        model.addAttribute("Username", "Asia");
        return "EditProfile"; // Zwraca nazwę szablonu (home.html)
    }
    @GetMapping("/MyPatients")
    public String MyPatients(Model model) {
        model.addAttribute("message", "Moi pacjenci");
        model.addAttribute("Username", "Asia");
        return "MyPatients"; // Zwraca nazwę szablonu (home.html)
    }
    @GetMapping("/Login")
    public String Login(Model model) {
        model.addAttribute("message", "Logowanie");
        model.addAttribute("Username", "Asia");
        return "Login"; // Zwraca nazwę szablonu (home.html)
    }


}
