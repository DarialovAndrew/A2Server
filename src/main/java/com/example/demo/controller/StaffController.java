package com.example.demo.controller;

import com.example.demo.entities.Cleaner;
import com.example.demo.entities.DTO.CleanerDTO;
import com.example.demo.entities.DTO.ManagerDTO;
import com.example.demo.entities.DTO.TrainerDTO;
import com.example.demo.entities.Manager;
import com.example.demo.entities.Trainer;
import com.example.demo.services.StaffService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trainer")
    public ResponseEntity<Void> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        staffService.addStaff(new Trainer(trainerDTO.getName(), trainerDTO.getStatus()));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cleaner")
    public ResponseEntity<Void> addCleaner(@RequestBody CleanerDTO cleanerDTO) {
        staffService.addStaff(new Cleaner(cleanerDTO.getName(), cleanerDTO.getSalary()));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/manager")
    public ResponseEntity<Void> addManager(@RequestBody ManagerDTO managerDTO) {
        staffService.addStaff(new Manager(managerDTO.getName(), managerDTO.getSalary()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/trainer/{id}")
    public ResponseEntity<Void> deleteTrainerById(@PathVariable UUID id) throws NotFoundException {
        staffService.deleteTrainer(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cleaner/{id}")
    public ResponseEntity<Void> deleteCleanerById(@PathVariable UUID id) throws NotFoundException {
        staffService.deleteCleaner(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/manager/{id}")
    public ResponseEntity<Void> deleteManagerById(@PathVariable UUID id) throws NotFoundException {
        staffService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Manager>> getManagers() {
        return ResponseEntity.ok(staffService.getManagers().findAll());
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getTrainers() {
        return ResponseEntity.ok(staffService.getTrainers().findAll());
    }

    @GetMapping("/cleaners")
    public ResponseEntity<List<Cleaner>> getCleaner() {
        return ResponseEntity.ok(staffService.getCleaners().findAll());
    }


}
