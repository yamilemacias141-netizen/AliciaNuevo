package Visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;

public class PanelPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;
    private Personaje personaje;
	private JLabel mostrarSecretos;
    private JLabel mostrarUbicacion;
    private JProgressBar barraLocura;
    private JLabel mostrarEsLindo;
    private JLabel mostrarEsNormal;
    private JLabel mostrarEstaEnMaravilla;
    private Mundo mundo;

	/**
	 * Create the panel.
	 */
	public PanelPersonaje(Mundo mundo) 
	{
		this.mundo=mundo;
		setBounds(100, 100, 800, 400);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel cartelEPersonaje = new JLabel("Personaje");
		springLayout.putConstraint(SpringLayout.NORTH, cartelEPersonaje, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cartelEPersonaje, 314, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, cartelEPersonaje, 56, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, cartelEPersonaje, -329, SpringLayout.EAST, this);
		cartelEPersonaje.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(cartelEPersonaje);
		
	
		
		
		mostrarSecretos = new JLabel("Secretos:");
		springLayout.putConstraint(SpringLayout.WEST, mostrarSecretos, 146, SpringLayout.WEST, this);
		mostrarSecretos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(mostrarSecretos);
		
		mostrarUbicacion = new JLabel("Ubicacion:");
		springLayout.putConstraint(SpringLayout.NORTH, mostrarUbicacion, 21, SpringLayout.SOUTH, mostrarSecretos);
		springLayout.putConstraint(SpringLayout.WEST, mostrarUbicacion, 0, SpringLayout.WEST, mostrarSecretos);
		mostrarUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(mostrarUbicacion);
		
		JLabel textoLocura = new JLabel("Locura:");
		springLayout.putConstraint(SpringLayout.NORTH, textoLocura, 31, SpringLayout.SOUTH, mostrarUbicacion);
		springLayout.putConstraint(SpringLayout.WEST, textoLocura, 0, SpringLayout.WEST, mostrarSecretos);
		textoLocura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(textoLocura);
		
		barraLocura = new JProgressBar();
		springLayout.putConstraint(SpringLayout.WEST, barraLocura, 60, SpringLayout.EAST, textoLocura);
		springLayout.putConstraint(SpringLayout.SOUTH, barraLocura, 0, SpringLayout.SOUTH, textoLocura);
		springLayout.putConstraint(SpringLayout.EAST, barraLocura, -313, SpringLayout.EAST, this);
		add(barraLocura);
		barraLocura.setMaximum(100);
		
		mostrarEsLindo = new JLabel("Es Lindo:");
		springLayout.putConstraint(SpringLayout.WEST, mostrarEsLindo, 146, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, mostrarEsLindo, -303, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, mostrarSecretos, 32, SpringLayout.SOUTH, mostrarEsLindo);
		mostrarEsLindo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(mostrarEsLindo);
		
		mostrarEsNormal = new JLabel("Es Normal:");
		springLayout.putConstraint(SpringLayout.NORTH, barraLocura, 145, SpringLayout.SOUTH, mostrarEsNormal);
		springLayout.putConstraint(SpringLayout.NORTH, mostrarEsNormal, 0, SpringLayout.NORTH, mostrarEsLindo);
		springLayout.putConstraint(SpringLayout.WEST, mostrarEsNormal, 69, SpringLayout.EAST, mostrarEsLindo);
		mostrarEsNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(mostrarEsNormal);
		
		mostrarEstaEnMaravilla = new JLabel("Esta en Maravila");
		springLayout.putConstraint(SpringLayout.NORTH, mostrarEstaEnMaravilla, 0, SpringLayout.NORTH, mostrarEsLindo);
		springLayout.putConstraint(SpringLayout.WEST, mostrarEstaEnMaravilla, 66, SpringLayout.EAST, mostrarEsNormal);
		mostrarEstaEnMaravilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(mostrarEstaEnMaravilla);
		
		
		
		
		

	}
	
	public String verificar (boolean p)
	{
		String res ;
		if(p==true)
		{
			res = "SI";
		}
		else
		{
			res = "NO";
		
		}
		return res;
	}
	public void mostrarPersonaje(Personaje p) {
		mostrarEsLindo.setText("Es Lindo: "+ verificar(p.esLindo()));
		mostrarEsNormal.setText("Es Normal: " + verificar(p.esNormal()));
		mostrarEstaEnMaravilla.setText("Esta En Maravilla: " + verificar(p.estaEnElMundoMaravilla()));
	    mostrarSecretos.setText("Secreto: " + p.getSecreto());
	    mostrarUbicacion.setText("Ubicacion: "+ p.getUbicacion());
	    barraLocura.setValue(p.getNivelLocura());
	}
}
