package com.IntercorpPruebaTecnica.mscliente.rest;


import com.IntercorpPruebaTecnica.mscliente.dto.ClienteProbMuerteDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.UsuarioDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.kpideclientesDTO;
import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;
import com.IntercorpPruebaTecnica.mscliente.model.WrapperResponse;
import com.IntercorpPruebaTecnica.mscliente.service.UsuarioService;
import com.IntercorpPruebaTecnica.mscliente.util.ConstantesApp;
import com.IntercorpPruebaTecnica.mscliente.util.UtilEnum.ESTADO_OPERACION;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;




    @ApiOperation(value = "Crear cliente", notes = "NOTA1", tags = {"Api Cliente"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK"),
            @ApiResponse(code = 404, message = "Not found ejm"),
            @ApiResponse(code = 500, message = "Server internal error ejem")
    })
    @PostMapping("/crearcliente")
    public ResponseEntity<WrapperResponse<Usuario>> registrarUsuario(@RequestBody UsuarioDTO userDto) {
        logger.info("START  [POST] /registrarUsuario: {}", userDto);
        WrapperResponse<Usuario> rs = new WrapperResponse<>(
                ESTADO_OPERACION.USUARIO_CREANDO.getCodigo(), "");
        try {
            Usuario userGen = usuarioService.registrarUsuario(userDto);
            rs = new WrapperResponse<Usuario>(ESTADO_OPERACION.EXITO.getCodigo(), ConstantesApp.MSG_EXITO, userGen);
            if(userGen==null){
                logger.error("Campos vacios revisar el body");
                rs = new WrapperResponse<Usuario>(ESTADO_OPERACION.EXCEPTION.getCodigo(), ConstantesApp.MSG_FRACASO);
            }
        }catch (Exception ex) {
            logger.error("Exception crear usuario:", ex);
            rs = new WrapperResponse<Usuario>(ESTADO_OPERACION.EXCEPTION.getCodigo(), ConstantesApp.MSG_FRACASO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(rs);
    }

    @ApiOperation(value = "Promedio y desviacion estandar de todos los clientes", notes = "NOTA1", tags = {"Api Cliente"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = kpideclientesDTO.class),
            @ApiResponse(code = 404, message = "Not found ejm"),
            @ApiResponse(code = 500, message = "Server internal error ejem")
    })

    @GetMapping("/kpideclientes")
    public ResponseEntity<WrapperResponse<kpideclientesDTO>> kpideclientes() {
        WrapperResponse<kpideclientesDTO> rs = null;
        try {
            kpideclientesDTO rsp = usuarioService.PromedioYDesviacion();
            rs = new WrapperResponse(ESTADO_OPERACION.EXITO.getCodigo(), ConstantesApp.MSG_EXITO, rsp);
        } catch (Exception ex) {
            logger.error("Exception Listado usuario:", ex);
            rs = new WrapperResponse<kpideclientesDTO>(ESTADO_OPERACION.EXCEPTION.getCodigo(), ConstantesApp.MSG_FRACASO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(rs);
    }



    @ApiOperation(value = "Listar todos los clientes con su fechaProbDeMuerte en cada uno", notes = "NOTA1", tags = {"Api Cliente"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK"),
            @ApiResponse(code = 404, message = "Not found ejm"),
            @ApiResponse(code = 500, message = "Server internal error ejem")
    })
    @GetMapping("/listclientes")
    public ResponseEntity<WrapperResponse<List<ClienteProbMuerteDTO>>> listall() {
        WrapperResponse<List<ClienteProbMuerteDTO>> rs = null;
        try {
            List<ClienteProbMuerteDTO> rsp = usuarioService.listall();
            rs = new WrapperResponse(ESTADO_OPERACION.EXITO.getCodigo(), ConstantesApp.MSG_EXITO, rsp);
            if(rsp.isEmpty() || rsp==null  ){
                logger.error("La lista esta vacia o nula");
                rs = new WrapperResponse<List<ClienteProbMuerteDTO>>(ESTADO_OPERACION.EXCEPTION.getCodigo(), ConstantesApp.MSG_FRACASO);
            }
        } catch (Exception ex) {
            logger.error("Exception Listado usuario:", ex);
            rs = new WrapperResponse<List<ClienteProbMuerteDTO>>(ESTADO_OPERACION.EXCEPTION.getCodigo(), ConstantesApp.MSG_FRACASO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(rs);
    }
}
