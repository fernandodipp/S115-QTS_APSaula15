/*
 * 2. Além disso, crie uma classe chamada CorreioService,
 * que contenha o método “String buscaEndereco(String cep)”.
 * Crie um mock dessa classe, e após realize o teste unitário,
 * simulando o valor abaixo, com o objeto mock.

CAso o usuário inserir o valor “9000000”, retornar “Porto Alegre”

 */


package mockitoTest;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.Assert;
import main.CorreioService;

@SuppressWarnings("deprecation")
public class BuscaEnderecoMockTest {
	
	@Test
	public void testNomeCorrentistaMock() {
		
		CorreioService correioServiceMock = Mockito.mock(CorreioService.class);
		when(correioServiceMock.buscaEndereco("9000000")).thenReturn("Porto Alegre");
		Assert.assertEquals("Porto Alegre", correioServiceMock.buscaEndereco("9000000"));
	}

}
