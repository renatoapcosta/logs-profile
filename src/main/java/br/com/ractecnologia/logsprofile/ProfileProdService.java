package br.com.ractecnologia.logsprofile;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"prod"})
public class ProfileProdService implements ProfileService {

	@Override
	public String profileAtivo() {
		return "prod ativo";
	}

}
