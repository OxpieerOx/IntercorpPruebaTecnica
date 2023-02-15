package com.IntercorpPruebaTecnica.mscliente.converter;

import com.IntercorpPruebaTecnica.mscliente.dto.ClienteProbMuerteDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.UsuarioDTO;
import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;

public class ClienteGetRespConverter extends AbstractConverter<Usuario, ClienteProbMuerteDTO>{


    @Override
    public Usuario toEntity(ClienteProbMuerteDTO dto) {
        Usuario user = new Usuario();
        user.setNombre(dto.getNombre());
        user.setApellidos(dto.getApellidos());
        user.setFechaNacimiento(dto.getFechaNacimiento());
        return user;
    }

    @Override
    public ClienteProbMuerteDTO toDTO(Usuario entity) {
        ClienteProbMuerteDTO user = new ClienteProbMuerteDTO();
        user.setNombre(entity.getNombre());
        user.setApellidos(entity.getApellidos());
        user.setFechaNacimiento(entity.getFechaNacimiento());
        user.setEdad(entity.getEdad());
        return user;
    }

}
