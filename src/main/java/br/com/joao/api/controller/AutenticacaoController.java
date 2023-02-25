package br.com.joao.api.controller;

import br.com.joao.api.domain.usuario.DadosAutenticacao;
import br.com.joao.api.domain.usuario.Usuario;
import br.com.joao.api.infra.security.DadosTokenJWT;
import br.com.joao.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuaLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication autentication = this.manager.authenticate(authenticationToken);
        String tokenJWT = this.tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok().body(new DadosTokenJWT(tokenJWT));
    }

}
