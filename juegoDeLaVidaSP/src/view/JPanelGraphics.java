package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.Play;

public class JPanelGraphics extends JPanel {

	private static final long serialVersionUID = 1L;
	private Timer timeGrap;

	public JPanelGraphics(Play play) {
		init(play);
	}

	private void init(Play play) {
		setBackground(Color.decode("#C8F7F1"));
		setBounds(10, 130, 1070, 530);
		setVisible(true);
		pie(play);
	}

	@SuppressWarnings("deprecation")
	private void pie(Play play) {
		DefaultPieDataset datasetPie = new DefaultPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("NUMERO DE MUERTES", datasetPie, true, true, false);
		chart.setBackgroundPaint(Color.decode("#55F5EA"));
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setBackgroundPaint(Color.decode("#A0F7F1"));
		plot.setNoDataMessage("No hay data");

		XYSeries men = new XYSeries("Hombres");
		XYSeries women = new XYSeries("Mujeres");
		XYSeriesCollection datasetLineal = new XYSeriesCollection();
		JFreeChart linealChart = ChartFactory.createXYLineChart("NACIMIENTOS HOMBRES VS MUJERES", "Años", "Poblacion", datasetLineal,
				PlotOrientation.VERTICAL, true, true, false);
		linealChart.setBackgroundPaint(Color.decode("#55F5EA"));
		datasetLineal.addSeries(men);
		datasetLineal.addSeries(women);

		XYPlot plotLineal = linealChart.getXYPlot();
		plotLineal.setBackgroundPaint(Color.BLACK);
		plotLineal.setRangeTickBandPaint(Color.BLACK);

		XYLineAndShapeRenderer Linealrenderer = new XYLineAndShapeRenderer();
		Linealrenderer.setSeriesPaint(0, Color.decode("#55F5EA"));
		Linealrenderer.setSeriesStroke(0, new BasicStroke(1));
		Linealrenderer.setSeriesPaint(1, Color.WHITE);
		Linealrenderer.setSeriesStroke(1, new BasicStroke(1));
		plotLineal.setRenderer(Linealrenderer);

		DefaultCategoryDataset datasetBar = new DefaultCategoryDataset();
		JFreeChart chartBar = ChartFactory.createBarChart("POBLACION POR PERSONA", "AÑOS", "CUERPOS", datasetBar,
				PlotOrientation.HORIZONTAL, false, true, false);
		chartBar.setBackgroundPaint(Color.decode("#55F5EA"));
		CategoryPlot pb = chartBar.getCategoryPlot();
		pb.setRangeGridlinePaint(Color.decode("#55F5EA"));
		pb.setBackgroundPaint(Color.BLACK);
		
		BarRenderer render = (BarRenderer)pb.getRenderer();
		render.setSeriesPaint(0,Color.decode("#55F5EA"));
		

		DefaultCategoryDataset datasetBarType = new DefaultCategoryDataset();
		JFreeChart chartBarType = ChartFactory.createBarChart("TIPOS DE ETAPAS", "AÑOS", "CUERPOS", datasetBarType,
				PlotOrientation.VERTICAL, false, true, false);
		chartBarType.setBackgroundPaint(Color.decode("#55F5EA"));
		CategoryPlot p = chartBarType.getCategoryPlot();
		p.setRangeGridlinePaint(Color.decode("#55F5EA"));
		p.setBackgroundPaint(Color.BLACK);
		
		BarRenderer rendered = (BarRenderer)p.getRenderer();
		rendered.setSeriesPaint(0, Color.decode("#55F5EA"));

		XYSeries scarlett1 = new XYSeries("Niñez");
		XYSeries scarlett2 = new XYSeries("Adolecentes");
		XYSeries scarlett3 = new XYSeries("Jovenes");
		XYSeries scarlett4 = new XYSeries("Adultos");
		XYSeries scarlett5 = new XYSeries("Ancianos");
		XYSeriesCollection datasetScatter = new XYSeriesCollection();
		JFreeChart scatterPlot = ChartFactory.createScatterPlot("TIPOS DE ETAPAS", "EDAD", "CANTIDAD", datasetScatter);
		scatterPlot.setBackgroundPaint(Color.decode("#55F5EA"));
		datasetScatter.addSeries(scarlett1);
		datasetScatter.addSeries(scarlett2);
		datasetScatter.addSeries(scarlett3);
		datasetScatter.addSeries(scarlett4);
		datasetScatter.addSeries(scarlett5);

		XYPlot plotScatter = scatterPlot.getXYPlot();
		plotScatter.setBackgroundPaint(Color.BLACK);
		plotScatter.setRangeTickBandPaint(Color.BLACK);

		timeGrap = new Timer(1, (ActionEvent e) -> {
			plot.setSectionPaint(0, Color.BLACK);
			plot.setSectionPaint(1, Color.decode("#55F5EA"));
			datasetPie.setValue("HOMBRES ", play.quantityKillMen());
			datasetPie.setValue("MUJERES", play.quantityKillWomen());

			women.add(play.getQuantityYears(), play.quantityWomenBorn());
			men.add(play.getQuantityYears(), play.quantityMenBorn());

			datasetBar.setValue(play.quantityMan(), "Años", "Hombres");
			datasetBar.setValue(play.quantityWoman(), "Años", "Mujeres");

			datasetBarType.setValue(play.clasifyTypeChildren(), "Cantidad", "Niños");
			datasetBarType.setValue(play.clasifyTypeTeenage(), "Cantidad", "Adolecentes");
			datasetBarType.setValue(play.clasifyTypeYoung(), "Cantidad", "Jovenes");
			datasetBarType.setValue(play.clasifyTypeAdult(), "Cantidad", "Adultos");
			datasetBarType.setValue(play.clasifyTypeSeniors(), "Cantidad", "Ancianos");
		});
		timeGrap.start();

		ChartPanel panelLine = new ChartPanel(linealChart);
		panelLine.setPreferredSize(new Dimension(350, 250));
		add(panelLine);

		ChartPanel panelPie = new ChartPanel(chart);
		panelPie.setPreferredSize(new Dimension(350, 250));
		panelPie.setBounds(50, 500, 500, 500);
		add(panelPie);

		ChartPanel panelBarType = new ChartPanel(chartBarType);
		panelBarType.setPreferredSize(new Dimension(350, 250));
		add(panelBarType);

		ChartPanel panelBar2 = new ChartPanel(chartBar);
		panelBar2.setPreferredSize(new Dimension(1060, 265));
		add(panelBar2);

	}

}
