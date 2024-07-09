package gestion_des_conges;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import base_de_données.BdConfigurations;

import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Label;

public class StatisticsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BdConfigurations bdc;


	public StatisticsFrame() {
		statisticsPanel();
	}
	public JPanel statisticsPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 898, 694);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 128, 64), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 64, 128));
		titlePanel.setBounds(0, 114, 898, 41);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Tableaux de bord");
		titleLabel.setBounds(10, 0, 878, 35);
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 128, 64));
		titleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JLabel fsteLogo = new JLabel("");
		fsteLogo.setHorizontalAlignment(SwingConstants.CENTER);
		fsteLogo.setIcon(new ImageIcon(homeFrame.class.getResource("/res/fstee (1).png")));
		fsteLogo.setBounds(0, 20, 898, 77);
		contentPane.add(fsteLogo);
		
		JPanel containerPanel = new JPanel();
		containerPanel.setBackground(new Color(244, 244, 244));
		containerPanel.setForeground(new Color(255, 128, 64));
		containerPanel.setBounds(10, 165, 878, 519);
		contentPane.add(containerPanel);
		
		
        containerPanel.setLayout(null);
        
        Panel nbreEmployePanel = new Panel();
        nbreEmployePanel.setBackground(new Color(0, 64, 128));
        nbreEmployePanel.setBounds(10, 10, 406, 148);
        containerPanel.add(nbreEmployePanel);
        nbreEmployePanel.setLayout(null);
        
        JLabel nbreEmployesLabel = new JLabel("Nombre des Employes ");
        nbreEmployesLabel.setBounds(93, 10, 303, 63);
        nbreEmployePanel.add(nbreEmployesLabel);
        nbreEmployesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nbreEmployesLabel.setForeground(new Color(244, 244, 244));
        nbreEmployesLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
        
        JLabel employesLabel = new JLabel();
        employesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        employesLabel.setForeground(new Color(244, 244, 244));
        employesLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        employesLabel.setBounds(93, 63, 293, 63);
        try {
			employesLabel.setText(numberTotalDesEmploye()+" Employes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        nbreEmployePanel.add(employesLabel);
        
        JLabel nbreEmployesLogo = new JLabel("");
        nbreEmployesLogo.setIcon(new ImageIcon(StatisticsFrame.class.getResource("/res/outline_account_circle_white_48dp.png")));
        nbreEmployesLogo.setBounds(10, 10, 96, 130);
        nbreEmployePanel.add(nbreEmployesLogo);
        
        /*JFreeChart lineChart = ChartFactory.createLineChart(
                "yahya",
                "Years","Number of Schools",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        chartPanel.setVisible(true);*/

        
        JPanel chartPanel1 = new JPanel();
        chartPanel1.setLayout(null);
        chartPanel1.setBackground(new Color(0, 64, 128));
        chartPanel1.setBounds(10, 184, 858, 325);
        containerPanel.add(chartPanel1);
        
        Panel nbreEmployePanel_1 = new Panel();
        nbreEmployePanel_1.setLayout(null);
        nbreEmployePanel_1.setBackground(new Color(0, 64, 128));
        nbreEmployePanel_1.setBounds(462, 10, 406, 148);
        containerPanel.add(nbreEmployePanel_1);
        
        JLabel nbreCongesLabel = new JLabel("Nombre des Congés");
        nbreCongesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nbreCongesLabel.setForeground(new Color(244, 244, 244));
        nbreCongesLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
        nbreCongesLabel.setBounds(77, 10, 303, 63);
        nbreEmployePanel_1.add(nbreCongesLabel);
        
        JLabel congesLabel = new JLabel();
        congesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        congesLabel.setForeground(new Color(244, 244, 244));
        congesLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        congesLabel.setBounds(87, 63, 293, 63);
        try {
			congesLabel.setText(numberTotalDesConges()+" Congés");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        nbreEmployePanel_1.add(congesLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(StatisticsFrame.class.getResource("/res/baseline_manage_history_white_36dp.png")));
        lblNewLabel_1.setBounds(10, 10, 96, 130);
        nbreEmployePanel_1.add(lblNewLabel_1);
        return contentPane;
	}
	 /*  private DefaultCategoryDataset createDataset( ) {
		      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		      dataset.addValue( 15 , "schools" , "1970" );
		      dataset.addValue( 30 , "schools" , "1980" );
		      dataset.addValue( 60 , "schools" ,  "1990" );
		      dataset.addValue( 120 , "schools" , "2000" );
		      dataset.addValue( 240 , "schools" , "2010" );
		      dataset.addValue( 300 , "schools" , "2014" );
		      return dataset;
		   }*/
	
	public int numberTotalDesEmploye() throws Exception {
		Statement stm = null;
    	bdc = new BdConfigurations();
		 stm = bdc.getConnexion().createStatement();

		 String requete = "SELECT COUNT(*) FROM employes";
		 ResultSet res = stm.executeQuery(requete);
		if(res.next()) {
			return Integer.parseInt(res.getString(1));
		}
		return 0;
	}
	public int numberTotalDesConges() throws SQLException, Exception {
		Statement stm = null;
		 bdc = new BdConfigurations();
		 stm = bdc.getConnexion().createStatement();
		 String requete = "SELECT COUNT(*) FROM conges";
		 ResultSet res = stm.executeQuery(requete);
		if(res.next()) {
			return Integer.parseInt(res.getString(1));
		}
		return 0;
	}
}
