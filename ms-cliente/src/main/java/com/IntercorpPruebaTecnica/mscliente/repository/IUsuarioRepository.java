package com.IntercorpPruebaTecnica.mscliente.repository;

import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {


}
