package Visual;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import Logica.Mundo;
import Logica.Personaje;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout layoutPrincipal;
	private Mundo mundo = new Mundo();
	private PanelPersonaje panelPersonaje;
	private PanelMundo panelMundo;
	private PanelCrearPersonaje panelCrearPersonaje;
	
	private JButton botonMundo;
	private JButton botonCrearPersonaje;
	private JComboBox comboPersonaje; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		this.setMinimumSize(new Dimension(400,450));
		layoutPrincipal = new CardLayout();
		getContentPane().setLayout(layoutPrincipal);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		botonMundo = new JButton("Mundo");
		menuBar.add(botonMundo);
		
		botonCrearPersonaje = new JButton("CrearPersonaje");
		menuBar.add(botonCrearPersonaje);
		
		
		comboPersonaje = new JComboBox<Personaje>();
		
		menuBar.add(comboPersonaje);

        crearPaneles();
        agregarEventos();
        
        cargarPersonajes();

	}
	
	private void crearPaneles() {
		panelMundo = new PanelMundo(mundo);
		panelPersonaje = new PanelPersonaje(mundo);
		panelCrearPersonaje =  new PanelCrearPersonaje(mundo);
		
		getContentPane().add(panelMundo, "panelMundo");
		getContentPane().add(panelPersonaje, "panelPersonaje");
		getContentPane().add(panelCrearPersonaje, "panelCrearPersonaje");
	}
	
	private void agregarEventos() {
		botonMundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPersonajes();
				layoutPrincipal.show(getContentPane(), "panelMundo");
			}
		});
		
		botonCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPersonajes();
				layoutPrincipal.show(getContentPane(), "panelCrearPersonaje");
				
			}
		});
		comboPersonaje.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				
				if(e.getStateChange()== ItemEvent.SELECTED)
				{
					Object seleccionado = e.getItem();
					if(seleccionado instanceof Personaje)
					{
						Personaje selec = (Personaje) seleccionado;
						panelPersonaje.mostrarPersonaje(selec);
						layoutPrincipal.show(getContentPane(),"panelPersonaje");
						
					}
					
				}
				
			}
		});
		
		
		
		
		
		
	
		
		
	}
	
	private void cargarPersonajes()
	{
		comboPersonaje.removeAllItems();
		for(Personaje p: mundo.getPersonajes())
		{
			comboPersonaje.addItem(p);
			System.out.println("se agrego");
		}
	}

	
	
}
