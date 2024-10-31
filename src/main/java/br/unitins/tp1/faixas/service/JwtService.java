package br.unitins.tp1.faixas.service;

import br.unitins.tp1.faixas.dto.UsuarioResponseDTO;

public interface JwtService {

    String generateJwt(UsuarioResponseDTO dto);
    
}
