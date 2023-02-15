package com.IntercorpPruebaTecnica.mscliente.service;

import com.IntercorpPruebaTecnica.mscliente.dto.ClienteProbMuerteDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.UsuarioDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.kpideclientesDTO;
import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registrarUsuario(UsuarioDTO usuarioDto);

    kpideclientesDTO PromedioYDesviacion();

    List<ClienteProbMuerteDTO> listall();




}
