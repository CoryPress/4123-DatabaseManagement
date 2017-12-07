/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Donor;
import dao.DBConnection;
import dao.DonorDAO;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author legen
 */
public class ReportFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReportFrame
     */
    private DBConnection conn;
   
    
    public ReportFrame(DBConnection myConn) {
        initComponents();
        this.conn = myConn;
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        from_fdate.setText(sdf.format(date));
        to_fdate.setText(sdf.format(date));
        from_cdate.setText(sdf.format(date));
        to_cdate.setText(sdf.format(date));
        envNumComboBox.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cReport_panel = new javax.swing.JPanel();
        cto_label = new javax.swing.JLabel();
        cfrom_label = new javax.swing.JLabel();
        from_cdate = new javax.swing.JTextField();
        to_cdate = new javax.swing.JTextField();
        generate_creport = new javax.swing.JButton();
        min_donation_label = new javax.swing.JLabel();
        min_donation = new javax.swing.JTextField();
        envNumComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        fReport_panel = new javax.swing.JPanel();
        ffrom_label = new javax.swing.JLabel();
        fto_label = new javax.swing.JLabel();
        from_fdate = new javax.swing.JTextField();
        to_fdate = new javax.swing.JTextField();
        generate_freport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1466, 754));

        cReport_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Contributions Report"));

        cto_label.setText("To:");

        cfrom_label.setText("From:");

        generate_creport.setText("Generate Report");
        generate_creport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_creportActionPerformed(evt);
            }
        });
        generate_creport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generate_creportKeyPressed(evt);
            }
        });

        min_donation_label.setText("Min. Donation");

        envNumComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", " " }));
        envNumComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                envNumComboBoxPopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel1.setText("Envelope ID:");

        javax.swing.GroupLayout cReport_panelLayout = new javax.swing.GroupLayout(cReport_panel);
        cReport_panel.setLayout(cReport_panelLayout);
        cReport_panelLayout.setHorizontalGroup(
            cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cReport_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generate_creport)
                    .addGroup(cReport_panelLayout.createSequentialGroup()
                        .addGroup(cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cReport_panelLayout.createSequentialGroup()
                                .addComponent(cfrom_label)
                                .addGap(18, 18, 18)
                                .addComponent(from_cdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cto_label))
                            .addGroup(cReport_panelLayout.createSequentialGroup()
                                .addComponent(min_donation_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(min_donation, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(to_cdate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(envNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        cReport_panelLayout.setVerticalGroup(
            cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cReport_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cfrom_label)
                    .addComponent(cto_label)
                    .addComponent(from_cdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to_cdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min_donation_label)
                    .addComponent(min_donation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(envNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(generate_creport)
                .addContainerGap())
        );

        fReport_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Funds Report"));

        ffrom_label.setText("From:");

        fto_label.setText("To:");

        generate_freport.setText("Generate Report");
        generate_freport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_freportActionPerformed(evt);
            }
        });
        generate_freport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generate_freportKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout fReport_panelLayout = new javax.swing.GroupLayout(fReport_panel);
        fReport_panel.setLayout(fReport_panelLayout);
        fReport_panelLayout.setHorizontalGroup(
            fReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fReport_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fReport_panelLayout.createSequentialGroup()
                        .addComponent(ffrom_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(from_fdate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(fto_label)
                        .addGap(18, 18, 18)
                        .addComponent(to_fdate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(generate_freport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fReport_panelLayout.setVerticalGroup(
            fReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fReport_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fReport_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ffrom_label)
                    .addComponent(fto_label)
                    .addComponent(from_fdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to_fdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(generate_freport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fReport_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cReport_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(fReport_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(cReport_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void generate_freportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_freportActionPerformed
        // TODO add your handling code here:
        String date1 = from_fdate.getText();
        String date2 = to_fdate.getText();
        String range = "From " + date1 + " through " + date2;

        //Open a dialogue box so the user can choose where to save the generated reports
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File(".")); // start at current directory
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = fileChooser.showSaveDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION) {
             File folder = fileChooser.getSelectedFile();
            boolean exists = Files.exists(folder.toPath());

            if(exists)
            {
                //Hashmap holds parameters that will be used to fill the report
                HashMap params = new HashMap();
                params.put("date_range", range);

                String sql_query = "select fund.name as Fund, sum(amt) as Total\n" +
                    "from fund join contribution\n" +
                    "where fund.name = contribution.fund_name\n" + 
                     "and c_date >= '" + date1 + "' and c_date <= '"+ date2 +"'\n" +
                    "group by fund.name order by fund.name asc;";

                //compile, fill and view the produced the jasport report
                String templatePath = "src\\funds_report.jrxml";
                String path = folder.getAbsolutePath();
                path += ("\\FReport.pdf");

                boolean gen;
                gen = generateReport(templatePath, sql_query, params, path);
           }
            else
            {
                JOptionPane.showMessageDialog(null, "The directory selected does not exist!");
            }
        }
    }//GEN-LAST:event_generate_freportActionPerformed

    private void generate_creportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_creportActionPerformed
        // TODO add your handling code here:
        double min_d = 0;
       
        if(!min_donation.getText().isEmpty())
        {           
            String minDonation = min_donation.getText();
            min_d = Double.parseDouble(minDonation);
        }
        
        
            String date1 = from_cdate.getText();
            String date2 = to_cdate.getText();
            String range = "From " + date1 + " through " + date2;
            
            DonorDAO donorDAO = new DonorDAO(conn);
            List<Donor> donorList = null;
            
            try{
               donorList = donorDAO.getAllDonors();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Database Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Open a dialogue box so the user can choose where to save the generated reports
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File(".")); // start at current directory
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int choice = fileChooser.showSaveDialog(this);

            if(choice == JFileChooser.APPROVE_OPTION) {
                File folder = fileChooser.getSelectedFile();
                boolean exists = Files.exists(folder.toPath());   
                
                if(exists)
                {
                    boolean isAll = true;
                    int reportsGenerated = 0;
            
                    //For each donor in the list that has contributed
                    //within the time period, generate a contributions report
                    for(int i = 0; donorList != null && i < donorList.size() && isAll; i++) {   
                        Donor d;
                        int envNum;
                       
                        String selected = envNumComboBox.getSelectedItem().toString();
                        String sql_query;
                        
                        if(selected.equals("All")){
                            d = donorList.get(i);
                            envNum = d.getEnv_num();
                            
                            sql_query = "SELECT env_num as EnvNum, ID, f_name as FirstName, l_name as LastName,\n" +
                            "c_date as Date, c_type as Type, fund_name as Fund, amt as Amt, \n" +
                            "note as Note, street, state, zip, city \n" +
                            "FROM contribution natural join donor\n" +
                            "where env_num = " + envNum + " and c_date >= '" + date1 + "' and c_date <= '" + date2 + "'\n" +
                             "and amt >= " + Double.toString(min_d) + " order by c_date asc;";
                        }
                        else{
                            envNum = Integer.parseInt(selected);
                            
                            boolean f = false;
                            Integer envI = 0;
                            int e;
                            //find the donor with the correct envNum
                            for (int don = 0; don < donorList.size() && !f; don++)
                            {
                                d = donorList.get(don);                           
                                e = d.getEnv_num(); 
                                
                                if(e == envNum)
                                {
                                    f = true;
                                    envI = don;
                                }
                            }
                            
                            d = donorList.get(envI);
                            
                             sql_query = "SELECT env_num as EnvNum, ID, f_name as FirstName, l_name as LastName,\n" +
                            "c_date as Date, c_type as Type, fund_name as Fund, amt as Amt, \n" +
                            "note as Note, street, state, zip, city \n" +
                            "FROM contribution natural join donor\n" +
                            "where env_num = " + envNum + " and c_date >= '" + date1 + "' and c_date <= '" + date2 + "'\n" +
                             "and amt >= " + Double.toString(min_d) + " order by c_date asc;";
                             
                             isAll = false;
                        }
                        
                         String address = d.getF_name() + " " + d.getL_name() + "\n\n"
                                + d.getStreet() + "\n\n" + d.getCity() + ", " + d.getState() +
                                " " + d.getZip();

                        //Hashmap holds parameters that will be used to fill the report
                        HashMap params = new HashMap();
                        params.put("date_range", range);
                        params.put("address", address);
                        
                        String templatePath = "src\\contributions_report.jrxml";
                         String path = folder.getAbsolutePath();
                            path += ("\\CReport" + envNum + ".pdf");
                       
                       //Generate a report
                       boolean gen = generateReport(templatePath, sql_query, params, path);
                       
                       if(gen == true)
                       {
                           reportsGenerated++;
                       }
                    }

                    JOptionPane.showMessageDialog(null, "Contribution reports for " + reportsGenerated + " donor(s) have been generated.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The directory selected does not exist!");
                }
            }
    }//GEN-LAST:event_generate_creportActionPerformed

    private boolean generateReport(String template, String sql_query, HashMap params, String outputPath)
    {
        boolean reportGenerated = false;
        
        try{      
            JasperDesign jd = JRXmlLoader.load(template);
            JRDesignQuery jQuery = new JRDesignQuery();
            jQuery.setText(sql_query);
            jd.setQuery(jQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, this.conn.getConnection());

            //Genrate save the report in a pdf if it is not empty
            if(jp.getPages().size() != 0)
            {   
                JasperExportManager.exportReportToPdfFile(jp, outputPath);
                reportGenerated = true;
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Report Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
           
            return reportGenerated;
    }
    
    private void generate_freportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generate_freportKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)            
        {
            generate_freport.doClick();
        }
    }//GEN-LAST:event_generate_freportKeyPressed

    private void generate_creportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generate_creportKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)            
        {
            generate_creport.doClick();
        }
    }//GEN-LAST:event_generate_creportKeyPressed

    private void envNumComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_envNumComboBoxPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        loadDonorBox();
    }//GEN-LAST:event_envNumComboBoxPopupMenuWillBecomeVisible

    private void loadDonorBox()
    {
        DonorDAO donorDao = new DonorDAO(conn);
        
        try
        {
          List<Integer> donorEnvNumList = donorDao.getAllEnvNums();
          envNumComboBox.removeAllItems();
          envNumComboBox.addItem("All");
    
          //fill Donor env num box list
          for(Integer i: donorEnvNumList)
          {
              envNumComboBox.addItem(Integer.toString(i));
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error 2: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Searches a combo box for the index of a string value and returns it
    private int getIndexInComboBox(String toFind, JComboBox jBox)
    {
        String item;
        boolean found = false;
        int index = -1;
       for(int i = 0; i < jBox.getItemCount() && !found; i++)
       {
           item = jBox.getItemAt(i).toString();
           if(item.equals(toFind))
           {
               index = i;
               found = true;
           }
       }
       
       return index;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cReport_panel;
    private javax.swing.JLabel cfrom_label;
    private javax.swing.JLabel cto_label;
    private javax.swing.JComboBox<String> envNumComboBox;
    private javax.swing.JPanel fReport_panel;
    private javax.swing.JLabel ffrom_label;
    private javax.swing.JTextField from_cdate;
    private javax.swing.JTextField from_fdate;
    private javax.swing.JLabel fto_label;
    private javax.swing.JButton generate_creport;
    private javax.swing.JButton generate_freport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField min_donation;
    private javax.swing.JLabel min_donation_label;
    private javax.swing.JTextField to_cdate;
    private javax.swing.JTextField to_fdate;
    // End of variables declaration//GEN-END:variables
}
