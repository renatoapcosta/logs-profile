package br.com.ractecnologia.logsprofile;

import org.springframework.stereotype.Service;

@Service
//@Profile({"default"}) - nao usar
public class ProfileDefaultService implements ProfileService {

	@Override
	public String profileAtivo() {
		return "default ativo";
	}

}
