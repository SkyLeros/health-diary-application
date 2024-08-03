package Main;


import java.io.EOFException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class graphBMIGUI extends ApplicationFrame {

    public graphBMIGUI(String applicationTitle, String chartTitle) throws Exception {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Date", "BMI",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Record> records = new ArrayList<Record>();
        
        FileInputStream file2 = new FileInputStream("Records.dat");
              ObjectInputStream inputFile2 = new ObjectInputStream(file2);
              
              boolean endOfFile = false;
              
              while (!endOfFile)
              {
                  try
                  {
                        records.add((Record) inputFile2.readObject());
                  }
                  catch (EOFException e)
                  {
                      endOfFile = true;
                  }
                  catch (Exception f)
                  {
                      JOptionPane.showMessageDialog(null, f.getMessage());  
                  }
              }
                    
              inputFile2.close();
        
        Iterator<Record> i = records.iterator();
        while (i.hasNext()) {
            Record e = i.next();
            dataset.addValue(e.getBMI(),"BMI",e.getDate());
        }
        return dataset;
    }
}
