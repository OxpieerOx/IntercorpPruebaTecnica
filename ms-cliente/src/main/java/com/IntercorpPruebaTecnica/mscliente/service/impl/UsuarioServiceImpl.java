package com.IntercorpPruebaTecnica.mscliente.service.impl;

import com.IntercorpPruebaTecnica.mscliente.converter.ClienteGetRespConverter;
import com.IntercorpPruebaTecnica.mscliente.converter.UsuarioConverter;
import com.IntercorpPruebaTecnica.mscliente.dto.ClienteProbMuerteDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.UsuarioDTO;
import com.IntercorpPruebaTecnica.mscliente.dto.kpideclientesDTO;
import com.IntercorpPruebaTecnica.mscliente.entity.Usuario;
import com.IntercorpPruebaTecnica.mscliente.repository.IUsuarioRepository;
import com.IntercorpPruebaTecnica.mscliente.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.averagingDouble;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    public Usuario registrarUsuario(UsuarioDTO usuarioDto) {
        UsuarioConverter userCon = new UsuarioConverter();
        Usuario user = null;
        if(usuarioDto.getNombre().isEmpty() || usuarioDto.getApellidos().isEmpty() ){
            return null;
        }
        user = userCon.toEntity(usuarioDto);
        user.setEdad(calcularEdadPorFecha(user.getFechaNacimiento()));

        return usuarioRepository.save(user);
    }

    @Override
    public kpideclientesDTO PromedioYDesviacion() {
        kpideclientesDTO rsp = new kpideclientesDTO();
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.size()>0){
                rsp.setPromedioEdad(calcularPromedioEdades(usuarios));
                rsp.setDesviacionEstandar(calcularDesviacionEstandar(usuarios));
        }
        else{
            rsp.setPromedioEdad(0.0);
            rsp.setDesviacionEstandar(0.0);
        }

        return rsp;
    }

    @Override
    public List<ClienteProbMuerteDTO> listall() {
        ClienteGetRespConverter userCon = new ClienteGetRespConverter();
        List<ClienteProbMuerteDTO> ListaClientes = new ArrayList<>();
        ClienteProbMuerteDTO  cliente= null;
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.size()>0){
            for( Usuario usuario:usuarios){
                cliente = userCon.toDTO(usuario);
                cliente.setFechaProbMuerte(calcularFechaDeMuerte(usuario.getFechaNacimiento()));
                ListaClientes.add(cliente);
            }
        }
        return ListaClientes;
    }


    private int calcularEdadPorFecha(Date fechaNacimiento){
        SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = simpledate.format(fechaNacimiento);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaaNacimiento = LocalDate.parse(fecha,date);
        LocalDate FechaActual = LocalDate.now();
        Period periodo = Period.between(fechaaNacimiento,FechaActual);
        return periodo.getYears();
    }


    private Date calcularFechaDeMuerte(Date fechaNacimiento){
        SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = simpledate.format(fechaNacimiento);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaaNacimiento = LocalDate.parse(fecha,date);
        LocalDate FechaProbMuerte = fechaaNacimiento.plusYears(76).plusMonths(5);
        Date fechaProbMuerte = Date.from(FechaProbMuerte.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return fechaProbMuerte;
    }

    private Double calcularPromedioEdades(List<Usuario> usuarios){

        return usuarios.stream().collect(averagingDouble(x->x.getEdad()));
    }

    private Double calcularDesviacionEstandar(List<Usuario> usuarios){
        if(usuarios.size()<2){
            return 0.0;
        }
        //CALCULAR LA MEDIA
        double nrClientes=0;
        double media=0;
        double suma=0;
        for(Usuario i:usuarios){
           suma += i.getEdad() ;
        }
        nrClientes = usuarios.stream().count();
        media= suma/nrClientes;

        //CALCULAR LA VARIANZA
        double varianza=0;
        double sumatoria=0;
        for(Usuario i:usuarios){
            sumatoria= Math.pow(i.getEdad() - media,2);
            varianza = varianza+sumatoria;
        }
        varianza = varianza/ (nrClientes-1);
        //CALCULAR LA DESVIACION
        double desviacion;
        desviacion= Math.sqrt(varianza);

        return desviacion;
    }


}
