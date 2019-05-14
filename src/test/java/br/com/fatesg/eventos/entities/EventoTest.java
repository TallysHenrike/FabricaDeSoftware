package br.com.fatesg.eventos.entities;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class EventoTest {

	public static void main(String[] args) {

		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Evento Teste", "", "Corpo de teste da categoria Evento", 50, "google.com/maps");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Evento>> constraintViolations = validator.validate(evento);

		for (ConstraintViolation error : constraintViolations) {
			String msgError = error.getMessage();
			System.out.println(msgError);
		}
	}
}