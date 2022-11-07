package com.example.UserApi.Repositories;

import com.example.UserApi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepostoryInterface extends JpaRepository<UsuarioModel, Integer> {

}

