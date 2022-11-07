package com.example.UserApi.Services;

import com.example.UserApi.Repositories.UsuarioRepostoryInterface;
import com.example.UserApi.models.UsuarioModel;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepostoryInterface usuarioRepostoryInterface;

    public UsuarioModel findById(Integer id) {
        Optional<UsuarioModel> obj = usuarioRepostoryInterface.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado", UsuarioModel.class.getName()));
    }

    public List<UsuarioModel> findAll() {
        return usuarioRepostoryInterface.findAll();
    }

    public UsuarioModel update(Integer id, UsuarioModel obj) {
        UsuarioModel newObj = this.findById(id);
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        newObj.setCpf(obj.getCpf());
        newObj.setTelefone(obj.getTelefone());
        return usuarioRepostoryInterface.save(newObj);
    }

    public UsuarioModel create(UsuarioModel obj) {
        obj.setId(null);
        return usuarioRepostoryInterface.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        usuarioRepostoryInterface.deleteById(id);
    }
}
