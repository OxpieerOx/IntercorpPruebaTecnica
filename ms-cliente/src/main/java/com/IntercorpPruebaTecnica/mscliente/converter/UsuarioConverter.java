package com.IntercorpPruebaTecnica.mscliente.converter;

import com.IntercorpPruebaTecnica.mscliente.dto.UsuarioDTO;
import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;

public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDTO> {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        Usuario user = new Usuario();
        user.setNombre(dto.getNombre());
        user.setApellidos(dto.getApellidos());
        user.setFechaNacimiento(dto.getFechaNacimiento());
        return user;
    }

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        return null;
    }
}
