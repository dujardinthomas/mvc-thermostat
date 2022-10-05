package fr.univlille.iutinfo.r3_04.q3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import fr.univlille.iutinfo.r3_04.modelQ2.Echelle;
import fr.univlille.iutinfo.r3_04.modelQ2.Temperature;
import fr.univlille.iutinfo.r3_04.viewQ1.ITemperatureView;
import fr.univlille.iutinfo.r3_04.viewQ3.TextView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class TestQ3_1 {
	public static final double DELTA = 0.005;  // rounding to 1/100

	/* JFXPanel is a component that initializes JavaFX without needing a javafx.application.Application
	 * We need it to be able to create a view but we don't need the attribute after that
	 */
	@SuppressWarnings("unused")
	private JFXPanel fxPanel = new JFXPanel();

	protected Temperature model;
	protected ITemperatureView view;

	/* Note: cannot use the @BeforeEach annotation because there is an argument (echelle)
	 */
	public void setUp(Echelle echelle) {
		model = new Temperature(echelle);
		model.setTemperature(18.0);

		view = null;
		/* runLater is needed to let JavaFX initialize the view in its own thread
		 */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				view = new TextView(model);
			}
		});

		/* Because of runLater, we must wait until the window is actually created
		 */
		while (view == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				fail("Exception while setting up test");
			}
		}
	}

	@Test
	public void test_setting_model_value_should_set_displayed_value() {
		setUp(Echelle.CELSIUS);
		assertEquals("Celsius", ((TextView)view).getTitle());
		assertEquals(18.0, view.getDisplayedValue(), DELTA);
	}

	@Test
	public void test_increment_model_value_should_increment_displayed_value() {
		setUp(Echelle.FAHRENHEIT);
		assertEquals("Fahrenheit", ((TextView)view).getTitle());
		model.incrementTemperature();
		assertEquals(19.0, model.getTemperature(), DELTA);
	}

	@Test
	public void test_decrement_modele_value_should_decrement_displayed_value() {
		setUp(Echelle.NEWTON);
		assertEquals("Newton", ((TextView)view).getTitle());
		model.decrementTemperature();
		assertEquals(17.0, model.getTemperature(), DELTA);
	}

	@Test
	public void test_view_increment_value_should_increment_model_value() {
		setUp(Echelle.KELVIN);
		assertEquals("Kelvin", ((TextView)view).getTitle());
		view.incrementAction();
		assertEquals(19.0, model.getTemperature(), DELTA);
	}

	@Test
	public void test_view_decrement_value_should_decrement_model_value() {
		setUp(Echelle.RANKINE);
		assertEquals("Rankine", ((TextView)view).getTitle());
		view.decrementAction();
		assertEquals(17.0, model.getTemperature(), DELTA);
	}

}
