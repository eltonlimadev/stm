package br.com.trendcode.stm.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.trendcode.stm.model.Usuario;
import br.com.trendcode.stm.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário Não Encontrado. " + cpf);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
