package Visual;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PanelCrearPersonaje extends JPanel {

	private static final long serialVersionUID = 1L;
	

	private Mundo mundo;
	private JSpinner ingresarSecretos;
	private JSpinner ingresarUbicacion;
	private JSpinner ingresarLocura;
	private JTextField ingresarNombre;
	private JLabel textoConfirmacion;
	/**
	 * Create the panel.
	 */
	public PanelCrearPersonaje(Mundo mundo) 
	{
		this.mundo=mundo;
		
		setBounds(100, 100, 800, 400);
		setLayout(null);
		
		JLabel cartelPersonaje = new JLabel("Crear Personaje");
		cartelPersonaje.setFont(new Font("Tahoma", Font.BOLD, 19));
		cartelPersonaje.setBounds(249, 24, 207, 23);
		add(cartelPersonaje);
		
		JLabel textoUbicacion = new JLabel("Ubicacion:");
		textoUbicacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		textoUbicacion.setBounds(130, 154, 78, 19);
		add(textoUbicacion);
		
		JLabel textoSecretos = new JLabel("Secretos:");
		textoSecretos.setFont(new Font("Tahoma", Font.BOLD, 15));
		textoSecretos.setBounds(133, 115, 71, 19);
		add(textoSecretos);
		
		JLabel textoLocura = new JLabel("Locura");
		textoLocura.setFont(new Font("Tahoma", Font.BOLD, 15));
		textoLocura.setBounds(133, 194, 51, 19);
		add(textoLocura);
		
		ingresarSecretos = new JSpinner();
		ingresarSecretos.setBounds(266, 113, 95, 20);
		add(ingresarSecretos);
		ingresarSecretos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		
		JLabel textoNombre = new JLabel("Nombre:");
		textoNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		textoNombre.setBounds(132, 75, 64, 19);
		add(textoNombre);
		
		ingresarUbicacion = new JSpinner();
		ingresarUbicacion.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(1)));
		ingresarUbicacion.setBounds(266, 155, 95, 20);
		add(ingresarUbicacion);
		
		ingresarLocura = new JSpinner();
		ingresarLocura.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		ingresarLocura.setBounds(266, 195, 95, 19);
		add(ingresarLocura);
		
	    ingresarNombre = new JTextField();
		ingresarNombre.setColumns(10);
		ingresarNombre.setBounds(266, 76, 86, 20);
		add(ingresarNombre);
		
		textoConfirmacion = new JLabel("SE CREO CON EXITO");
		textoConfirmacion.setFont(new Font("Tahoma", Font.BOLD, 25));
		textoConfirmacion.setBounds(207, 258, 272, 19);
		add(textoConfirmacion);
		textoConfirmacion.setVisible(false);
		
		JButton botonCrear = new JButton("CREAR");
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nombre = (String) ingresarNombre.getText();
				int secreto = (int) ingresarSecretos.getValue();
				int ubicacion = (int) ingresarUbicacion.getValue();
				int locura = (int) ingresarLocura.getValue();
				
			
				Personaje p = new Personaje( nombre, secreto,ubicacion,locura);
				mundo.agregarPersonajes(p);
				System.out.println("se creo");
				textoConfirmacion.setVisible(true);
				ingresarNombre.setText("");
				ingresarUbicacion.setValue(0);
				ingresarLocura.setValue(0);
				ingresarSecretos.setValue(0);
				textoConfirmacion.setVisible(false);
				
		
			
			}
		});
		botonCrear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botonCrear.setBounds(277, 301, 130, 23);
		add(botonCrear);
		
	
		

	}
	

	
}
