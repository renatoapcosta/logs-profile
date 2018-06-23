package br.com.ractecnologia.logsprofile;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileDefaultServiceTest {
	
	@Autowired
	private ProfileService profileService;

	@Test
	public void testProfileAtivo() {
		 String output = profileService.profileAtivo();
	     assertThat(output).contains("default ativo");
	}

}
