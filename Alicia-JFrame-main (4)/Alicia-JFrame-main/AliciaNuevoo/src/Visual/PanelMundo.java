package Visual;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import Logica.Mundo;
import Logica.Personaje;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelMundo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Mundo mundo;
	private JLabel textoMundo;
	private JLabel textoLindos;
	private JLabel textoMaravilla;
	private JLabel textoNormales;
	private JLabel textoLoco;
	private JLabel cartelLindos;
	private JLabel cartelNormales;
	private JList listaLindos;
	private JList listaNormales;
	private JButton botonMostrarInfo;

	/**
	 * Create the panel.
	 */
	public PanelMundo(Mundo mundo) 
	{
		this.mundo=mundo;
	
		setBounds(100, 100, 800, 400);
		SpringLayout springLayout = new SpringLayout();
		SpringLayout springLayout_1 = new SpringLayout();
		setLayout(springLayout_1);
		
		textoMundo = new JLabel("Mundo");
		springLayout_1.putConstraint(SpringLayout.NORTH, textoMundo, 20, SpringLayout.NORTH, this);
		springLayout_1.putConstraint(SpringLayout.WEST, textoMundo, 351, SpringLayout.WEST, this);
		textoMundo.setFont(new Font("Tahoma", Font.BOLD, 27));
		add(textoMundo);
		
		textoLindos = new JLabel("Lindos:");
		springLayout_1.putConstraint(SpringLayout.WEST, textoLindos, 52, SpringLayout.WEST, this);
		textoLindos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textoLindos);
		
		textoMaravilla = new JLabel("En Maravilla:");
		springLayout_1.putConstraint(SpringLayout.NORTH, textoLindos, 0, SpringLayout.NORTH, textoMaravilla);
		springLayout_1.putConstraint(SpringLayout.NORTH, textoMaravilla, 90, SpringLayout.NORTH, this);
		springLayout_1.putConstraint(SpringLayout.WEST, textoMaravilla, 184, SpringLayout.WEST, this);
		textoMaravilla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textoMaravilla);
		
		textoNormales = new JLabel("Hay Normales:");
		springLayout_1.putConstraint(SpringLayout.NORTH, textoNormales, 0, SpringLayout.NORTH, textoLindos);
		springLayout_1.putConstraint(SpringLayout.WEST, textoNormales, 0, SpringLayout.WEST, textoMundo);
		textoNormales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textoNormales);
		
		textoLoco = new JLabel("Mas Loco:");
		springLayout_1.putConstraint(SpringLayout.NORTH, textoLoco, 0, SpringLayout.NORTH, textoLindos);
		springLayout_1.putConstraint(SpringLayout.EAST, textoLoco, -168, SpringLayout.EAST, this);
		textoLoco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textoLoco);
		
		cartelLindos = new JLabel("Lindos:");
		springLayout_1.putConstraint(SpringLayout.NORTH, cartelLindos, 33, SpringLayout.SOUTH, textoLindos);
		springLayout_1.putConstraint(SpringLayout.WEST, cartelLindos, 0, SpringLayout.WEST, textoLindos);
		cartelLindos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(cartelLindos);
		
		cartelNormales = new JLabel("Normales:");
		springLayout_1.putConstraint(SpringLayout.NORTH, cartelNormales, 0, SpringLayout.NORTH, cartelLindos);
		springLayout_1.putConstraint(SpringLayout.WEST, cartelNormales, 165, SpringLayout.EAST, cartelLindos);
		cartelNormales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(cartelNormales);
		
		listaLindos = new JList();
		springLayout_1.putConstraint(SpringLayout.NORTH, listaLindos, 25, SpringLayout.SOUTH, cartelLindos);
		springLayout_1.putConstraint(SpringLayout.WEST, listaLindos, 0, SpringLayout.WEST, textoLindos);
		springLayout_1.putConstraint(SpringLayout.SOUTH, listaLindos, -25, SpringLayout.SOUTH, this);
		springLayout_1.putConstraint(SpringLayout.EAST, listaLindos, -32, SpringLayout.EAST, textoMaravilla);
		add(listaLindos);
		
		listaNormales = new JList();
		springLayout_1.putConstraint(SpringLayout.NORTH, listaNormales, 25, SpringLayout.SOUTH, cartelNormales);
		springLayout_1.putConstraint(SpringLayout.WEST, listaNormales, 41, SpringLayout.EAST, listaLindos);
		springLayout_1.putConstraint(SpringLayout.SOUTH, listaNormales, -25, SpringLayout.SOUTH, this);
		add(listaNormales);
		
		botonMostrarInfo = new JButton("Mostrar Info");
		springLayout_1.putConstraint(SpringLayout.EAST, listaNormales, -126, SpringLayout.WEST, botonMostrarInfo);
		springLayout_1.putConstraint(SpringLayout.SOUTH, botonMostrarInfo, -111, SpringLayout.SOUTH, this);
		springLayout_1.putConstraint(SpringLayout.EAST, botonMostrarInfo, -60, SpringLayout.EAST, this);
		botonMostrarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mostrarInformacion();
			}
		});
		botonMostrarInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(botonMostrarInfo);

	
		

	}
	public void mostrarInformacion()
	{
		textoLindos.setText("Lindos: " + mundo.cuantosPersonajesLindos());
		textoMaravilla.setText("En Maravilla: "+ mundo.personajesEnMaravilla());
		if(mundo.hayPersonajesNormales())
		{
			textoNormales.setText("Hay Normales: SI");
		}
		else
		{
			textoNormales.setText("Hay Normales: NO");
		}
		
		textoLoco.setText("Mas Loco: " + mundo.personajeMasLoco().getNombre());
		
		DefaultListModel<String> lindos = new DefaultListModel<>();
		for(Personaje p : mundo.personajesLindos())
		{
			lindos.addElement(p.getNombre());
		}
		listaLindos.setModel(lindos);
		
		DefaultListModel<String> normales = new DefaultListModel<>();
		for(Personaje p : mundo.personajesNormales())
		{
			lindos.addElement(p.getNombre());
		}
		listaNormales.setModel(normales);
		
	
	}
	
}
