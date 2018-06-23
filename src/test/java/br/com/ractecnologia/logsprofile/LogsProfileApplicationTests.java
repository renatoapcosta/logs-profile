package br.com.ractecnologia.logsprofile;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class LogsProfileApplicationTests {

	@Rule
    public OutputCapture outputCapture = new OutputCapture();
	
	@Before
    public void before() {
        //System.clearProperty("spring.profiles.active");
    }
	
	@After
    public void after() {
        System.clearProperty("spring.profiles.active");
    }

    @Test
    public void testDefaultProfile() throws Exception {
       	LogsProfileApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("default ativo");
    }
    
    @Test
    public void testHmlProfile() throws Exception {
    	
        System.setProperty("spring.profiles.active", "hml");
        LogsProfileApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("hml ativo");
    }

    @Test
    public void testProdProfile() throws Exception {
    	LogsProfileApplication.main(new String[]{"--spring.profiles.active=prod"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("prod ativo");
    }
    
    @Test
    public void testDevProfile_withDoption() throws Exception {
    	LogsProfileApplication.main(new String[]{"--spring.profiles.active=dev"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("dev ativo");
    }

    

}
