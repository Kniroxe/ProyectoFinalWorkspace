package com.kirbys.clientes.servicies;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kirbys.clientes.dto.ClienteDTO;
import com.kirbys.clientes.mappers.ClienteMapper;
import com.kirbys.clientes.models.repositories.ClienteRepository;
import com.kirbys.commons.models.entities.Cliente;
import com.kirbys.commons.servicies.CommonServiceImpl;


@Service
public class ClientesServiceImpl extends
        CommonServiceImpl<ClienteDTO, Cliente, ClienteMapper, ClienteRepository>
        implements ClienteService	{

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> listar() {
        List<ClienteDTO> lista = new ArrayList<>();
        repository.findAll().forEach(Cliente ->{
            lista.add(mapper.entityToDTO(Cliente));
        });
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> obtenerPorId(Long id) {
        Optional<Cliente> opt = repository.findById(id);
        if(opt.isPresent()) {
            return Optional.of(mapper.entityToDTO(opt.get()));
        }
        return Optional.empty();
    }


    @Override
    @Transactional
    public ClienteDTO insertar(ClienteDTO dto) {
        Cliente cliente = mapper.dtoToEntity(dto);
        repository.save(cliente);
        dto.setId(cliente.getId());
        return dto;
    }

    @Override
    @Transactional
    public ClienteDTO editar(ClienteDTO entity, Long id) {
        Optional<Cliente> opt = repository.findById(id);
        if(opt.isPresent()) {
            Cliente cliente = opt.get();
            cliente.setNombre(entity.getNombre());
            cliente.setApellido(entity.getApellido());
            cliente.setEmail(entity.getEmail());
            cliente.setEmail(entity.getEmail());
            cliente.setTelefono(entity.getTelefono());
            cliente.setDireccion(entity.getDireccion());
            repository.save(cliente);
            return mapper.entityToDTO(cliente);
        }
        return null;
    }



    @Override
    @Transactional
    public ClienteDTO eliminar(Long id) {
        Optional<Cliente> opt = repository.findById(id);
        if(opt.isPresent()) {
            ClienteDTO dto = mapper.entityToDTO(opt.get());
            repository.deleteById(id);
            return dto;
        }
        return null;
    }



}