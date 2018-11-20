package oliveiraluz.com.br.sienge;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class GeradorObservacao {

	// Textos pré-definidos
	private static final String TEXTO_NOTA = "Fatura da nota fiscal de simples remessa: ";
	private static final String TEXTO_NOTAS = "Fatura das notas fiscais de simples remessa: ";

	// Gera observações com texto pre-definido, incluindo os números das notas fiscais, recebidos no parâmetro
	public String geraObservacao(List lista) {
		String retorno = "";
		if (lista != null && !lista.isEmpty()) {
			retorno = retornaCodigos(lista);
//			retorno = geraMensagemNota(lista);
		}
		return retorno;
	}

	// Cria observação
	private String geraMensagemNota(List lista) {
		StringBuilder retorno = new StringBuilder();
		
		if (lista.size() == 1) {
			retorno.append(TEXTO_NOTA);
		} else {
			retorno.append(TEXTO_NOTAS);
		}

		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			retorno.append(iterator.next());

			if (iterator.hasNext()) {
				retorno.append(", ");
			} else {
				retorno.append(" e ");
			}
		}

		return retorno.toString();
	}
	
	// Cria observação
	private String retornaCodigos(List lista) {
		String texto = "";
		if (lista.size() >= 2) {
			texto = "Fatura das notas fiscais de simples remessa: ";
		} else {
			texto = TEXTO_NOTA;
		}

		// Acha separador
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if (cod.toString() == null || cod.toString().length() <= 0)
				s = "";
			else if (iterator.hasNext())
				s = ", ";
			else
				s = " e ";

			cod.append(s + c);
		}

		return texto + cod;
	}
}