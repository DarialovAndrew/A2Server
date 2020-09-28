package com.example.demo.controller;

import com.example.demo.entities.CleanerTime;
import com.example.demo.entities.DTO.CleanerTimeDTO;
import com.example.demo.entities.DTO.GroupMeetDTO;
import com.example.demo.entities.DTO.TrainerMeetDTO;
import com.example.demo.entities.GroupMeet;
import com.example.demo.entities.TrainerMeet;
import com.example.demo.services.SheduleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shedule")
public class SheduleController {
    private final SheduleService sheduleService;

    @Autowired
    public SheduleController(SheduleService sheduleService) {
        this.sheduleService = sheduleService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trainermeet")
    public ResponseEntity<Void> addTrainerMeet(@RequestBody TrainerMeetDTO trainerMeetDTO) {
        sheduleService.add(new TrainerMeet(trainerMeetDTO.getTrainer(), trainerMeetDTO.getClient(), trainerMeetDTO.getDate()));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groupmeet")
    public ResponseEntity<Void> addGroupMeet(@RequestBody GroupMeetDTO groupMeetDTO) {
        sheduleService.add(new GroupMeet(groupMeetDTO.getTrainer(), groupMeetDTO.getDate(), groupMeetDTO.getMaxClients()));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cleanertime")
    public ResponseEntity<Void> addCleanerTime(@RequestBody CleanerTimeDTO cleanerTimeDTO) {
        sheduleService.add(new CleanerTime(cleanerTimeDTO.getCleaner(), cleanerTimeDTO.getDate()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/trainermeet/{id}")
    public ResponseEntity<Void> deleteTrainerMeetById(@PathVariable UUID id) throws NotFoundException {
        sheduleService.deleteTrainerMeet(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/groupmeet/{id}")
    public ResponseEntity<Void> deleteGroupMeetById(@PathVariable UUID id) throws NotFoundException {
        sheduleService.deleteGroupMeet(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cleanertime/{id}")
    public ResponseEntity<Void> deleteCleanerTimeById(@PathVariable UUID id) throws NotFoundException {
        sheduleService.deleteCleanerTime(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/trainermeet")
    public ResponseEntity<List<TrainerMeet>> getTrainerMeet() {
        return ResponseEntity.ok(sheduleService.getTrainerMeets().findAll());
    }

    @GetMapping("/cleanertime")
    public ResponseEntity<List<CleanerTime>> getCleanerTime() {
        return ResponseEntity.ok(sheduleService.getCleanerTimes().findAll());
    }

    @GetMapping("/groupmeet")
    public ResponseEntity<List<GroupMeet>> getGroupMeet() {
        return ResponseEntity.ok(sheduleService.getGroupMeets().findAll());
    }

}
