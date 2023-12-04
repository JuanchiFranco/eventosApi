package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.DTO.AdminDTO;
import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> verAdmins(Model model) {
        log.info("Estoy en el controlador");
        return adminService.verAdmins();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Admin> findById(@PathVariable Long id) {
        return adminService.findById(id);
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.guardarAdmin(adminDTO);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.actualizarAdmin(id, admin);
    }

    @DeleteMapping("/borrar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Successfully deleted";
    }
}
