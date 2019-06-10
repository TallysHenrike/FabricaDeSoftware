package br.com.fatesg.eventos.entities;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class EventoUnitTest {

	private static Validator validador;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validador = factory.getValidator();
	}

	@Test
	public void idEventoIsNull() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento(null, adm, ctg, "Titulo do Evento", "Descricão evento teste",
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("O id do evento não pode ser null!", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void tituloIsEmpty() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, null, "Descricão evento teste",
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("O campo Título não pode ser vazio!", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void tituloWrongSizeMin() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "T", "Descricão evento teste",
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade minima é de 3 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void tituloWrongSizeMax() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Lorem ipsum dolor sit amet, consectetuer adipiscin.",
				"Descricão evento teste", "Corpo de teste da categoria Evento", 50,
				"google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade máxima é de 50 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void descricaoIsEmpty() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Evento Teste", null,
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("O campo Descrição não pode ser vazio!", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void descricaoWrongSizeMin() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Titulo Evento", "A",
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade minima é de 2 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void descricaoWrongSizeMax() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Titulo Evento", "Lorem ipsum dolor sit amet, " +
				"consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque " +
				"penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, " +
				"pellentesque eu, pretium..",
				"Corpo de teste da categoria Evento", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade máxima é de 250 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void corpoIsEmpty() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Evento Teste", "Descrição evento",
				null, 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("O campo Corpo não pode ser vazio!", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void corpoWrongSizeMin() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Titulo Evento", "Descrição evento",
				"A", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade minima é de 2 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void corpoWrongSizeMax() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Titulo Evento", "Descrição evento",
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
						"Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur " +
						"ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla " +
						"consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu." +
						" In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede " +
						"mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean " +
						"vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, " +
						"enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra " +
						"nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel " +
						"augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, " +
						"tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed " +
						"ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio " +
						"et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante." +
						" Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet " +
						"nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit " +
						"cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum " +
						"purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. " +
						"Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus " +
						"orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam " +
						"pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, " +
						"ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, " +
						"posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc " +
						"nonummy metus. Vestibu", 50, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("A quantidade máxima é de 2000 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void quantidadeDeVagasIsEmpty() {
		Administrador adm = new Administrador();
		adm.setNome("Adm");

		Categoria ctg = new Categoria();
		ctg.setNome("Ctg");

		Evento evento = new Evento((long) 1, adm, ctg, "Evento Teste", "Descrição evento",
				"Corpo do evento", 0, "google.com/maps");

		Set<ConstraintViolation<Evento>> constraintViolations = validador.validate(evento);

		assertEquals(1, constraintViolations.size());
		assertEquals("O campo Quantidade de Vagas não pode ser 0!", constraintViolations.iterator().next().getMessage());
	}

}