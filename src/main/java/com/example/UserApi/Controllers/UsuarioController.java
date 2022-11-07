package com.example.UserApi.Controllers;

import com.example.UserApi.Services.UsuarioServices;
import com.example.UserApi.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioModel> findById(@PathVariable Integer id) {
        UsuarioModel obj = this.usuarioServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> findAll(){
        List<UsuarioModel> list = this.usuarioServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable Integer id, @RequestBody @Valid UsuarioModel obj){
        UsuarioModel newObj = usuarioServices.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> create(@RequestBody @Valid UsuarioModel obj){
        UsuarioModel newObj = usuarioServices.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        usuarioServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
