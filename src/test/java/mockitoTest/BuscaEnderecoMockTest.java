/*
 * 2. Al�m disso, crie uma classe chamada CorreioService,
 * que contenha o m�todo �String buscaEndereco(String cep)�.
 * Crie um mock dessa classe, e ap�s realize o teste unit�rio,
 * simulando o valor abaixo, com o objeto mock.

CAso o usu�rio inserir o valor �9000000�, retornar �Porto Alegre�

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
