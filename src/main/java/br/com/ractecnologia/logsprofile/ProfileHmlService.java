package br.com.ractecnologia.logsprofile;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"hml"})
public class ProfileHmlService implements ProfileService {

	@Override
	public String profileAtivo() {
		return "hml ativo ";
	}

}
