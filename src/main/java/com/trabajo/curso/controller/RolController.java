package com.trabajo.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.curso.model.Rol;
import com.trabajo.curso.service.RolService;


@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {

	private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) throws Exception {
        return ResponseEntity.ok(rolService.agrergarRol(rol));
    }

    @PutMapping("/")
    public ResponseEntity<Rol> actualizarRol(@RequestBody Rol rol) throws Exception {
        return ResponseEntity.ok(rolService.actualizarRol(rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRol(@PathVariable("id") Long id) {
        ResponseEntity<String> responseEntity = null;
        try {
            rolService.eliminarRol(id);
            responseEntity = ResponseEntity.ok("Rol eliminado correctamente");
        } catch (Exception e) {
            responseEntity = ResponseEntity.ok("Error al eliminar el rol");
        } catch (Throwable throwable) {
            responseEntity = ResponseEntity.ok("Error al eliminar el rol");
        }
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rolService.obtenerRolPorId(id));
    }

   @PreAuthorize("hasAuthority('ADMIN')") // ->> Esto es lo que hay que agregar para que funcione el rol
    @GetMapping("/listar/")
    public ResponseEntity<?> obtenerRoles() {

        return ResponseEntity.ok(rolService.obtenerRoless());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Rol> obtenerRolPorNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(rolService.obtenerRolPorNombre(nombre));
    }

}
