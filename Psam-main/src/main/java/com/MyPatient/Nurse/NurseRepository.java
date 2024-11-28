package com.MyPatient.Nurse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Można to pominąć, ale warto dla czytelności
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
