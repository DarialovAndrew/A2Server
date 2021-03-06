package com.example.demo.controller;


import com.example.demo.entities.Apparatus;
import com.example.demo.entities.DTO.ApparatusDTO;
import com.example.demo.entities.DTO.LockerDTO;
import com.example.demo.entities.DTO.ShowerDTO;
import com.example.demo.entities.Locker;
import com.example.demo.entities.Shower;
import com.example.demo.services.GoodsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/apparatus")
    public ResponseEntity<Void> addApparatus(@RequestBody ApparatusDTO apparatusDTO) {
        goodsService.add(new Apparatus(apparatusDTO.getName(), apparatusDTO.getAge()));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shower")
    public ResponseEntity<Void> addShower(@RequestBody ShowerDTO showerDTO) {
        goodsService.add(new Shower(showerDTO.getNumber(), true));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locker")
    public ResponseEntity<Void> addLocker(@RequestBody LockerDTO lockerDTO) {
        goodsService.add(new Locker(lockerDTO.getNumber()));
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/apparatus/{id}")
    public ResponseEntity<Void> deleteApparatusById(@PathVariable UUID id) throws NotFoundException {
        goodsService.deleteApparatus(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/shower/{id}")
    public ResponseEntity<Void> deleteShowerById(@PathVariable UUID id) throws NotFoundException {
        goodsService.deleteShower(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/locker/{id}")
    public ResponseEntity<Void> deleteLockerById(@PathVariable UUID id) throws NotFoundException {
        goodsService.deleteLocker(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/apparatuses")
    public ResponseEntity<List<Apparatus>> getApparatus() {
        return ResponseEntity.ok(goodsService.getApparatuses().findAll());
    }

    @GetMapping("/shower")
    public ResponseEntity<List<Shower>> getShower() {
        return ResponseEntity.ok(goodsService.getShowers().findAll());
    }

    @GetMapping("/locker")
    public ResponseEntity<List<Locker>> getLocker() {
        return ResponseEntity.ok(goodsService.getLockers().findAll());
    }


}
