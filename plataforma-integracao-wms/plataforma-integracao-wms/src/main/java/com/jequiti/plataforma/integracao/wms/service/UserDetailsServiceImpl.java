package com.jequiti.plataforma.integracao.wms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jequiti.plataforma.integracao.wms.ebs.entity.Perfil;
import com.jequiti.plataforma.integracao.wms.ebs.entity.Usuario;
import com.jequiti.plataforma.integracao.wms.ebs.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	private Set<GrantedAuthority> mapRolesToAuthorities(Perfil perfil)
	{
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		 grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getTipo()));
		 
		 return grantedAuthorities;
    }

	@Override
	public UserDetails loadUserByUsername(String fantasia) throws UsernameNotFoundException 
	{
		Optional<Usuario> usuario = userRepository.findByFantasia(fantasia);
		
		if (usuario.isPresent())
		{
			return new org.springframework.security.core.userdetails.User(usuario.get().getNome(),
																		  usuario.get().getSenha(),
																		  mapRolesToAuthorities(usuario.get().getPerfil()));
		}
		
		throw new UsernameNotFoundException(fantasia);
	}
	

}
