package br.udesc.gui;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import br.udesc.files.FileManager;
import br.udesc.searchstrats.FactorySearch;
import br.udesc.searchstrats.WordLocation;

/**
 *
 * @author Guilherme Utiama
 * @author Peter Brendel
 */
public class main extends javax.swing.JFrame {
    
    FileManager fileManager;
    FactorySearch factory;
    
    public main() {
        initComponents();
        fileManager = new FileManager();
        factory = new FactorySearch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seletor_arquivos = new javax.swing.JFileChooser();
        toFind = new javax.swing.JTextField();
        dropdown = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        carregar = new javax.swing.JButton();
        painelTexto = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Naive Search", "Rabin Karp", "KMP", "Boyer Moore", "Aho Corasick", "Radix Tree" }));
        dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        carregar.setText("Carregar arquivos");
        carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarActionPerformed(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        painelTexto.setViewportView(areaTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTexto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(toFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carregar)
                    .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(toFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarActionPerformed
        
        seletor_arquivos.setMultiSelectionEnabled(true);
        int returnV = seletor_arquivos.showOpenDialog(carregar);
        
        if(returnV == JFileChooser.APPROVE_OPTION){
            fileManager.readFiles(seletor_arquivos.getSelectedFiles());
        }
        
    }//GEN-LAST:event_carregarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
        Object o = dropdown.getSelectedItem();
        areaTexto.setText("");
        ArrayList<WordLocation> temp = null;
        String toSearch = toFind.getText();
        
        if(toSearch != null){
            
            if(o.toString().equals("Naive Search")){
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.naive(f, toSearch).search(false);
                }
                
            }else if(o.toString().equals("Rabin Karp")) {
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.rabinkarp(f, toSearch).search(false);
                }
                    
            } else if(o.toString().equals("KMP")) {
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.morrispratt(f, toSearch).search(false);
                }
            } else if(o.toString().equals("Boyer Moore")) {
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.boyermoore(f, toSearch).search(false);
                }
            } else if(o.toString().equals("Aho Corasick")) {
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.ahocorasick(f, toSearch).search(false);
                }
            } else if(o.toString().equals("Radix Tree")) {
                for(File f : fileManager.getFiles()){
                    areaTexto.append(f.getName() + "\n");
                    temp = factory.radixtree(f, toSearch).search(false);
                }
            }
            
            for(WordLocation w : temp){
                areaTexto.append(w.toString() + "\n");
            }
        }   
    }//GEN-LAST:event_buscarActionPerformed

    private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropdownActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton buscar;
    private javax.swing.JButton carregar;
    private javax.swing.JComboBox<String> dropdown;
    private javax.swing.JScrollPane painelTexto;
    private javax.swing.JFileChooser seletor_arquivos;
    private javax.swing.JTextField toFind;
    // End of variables declaration//GEN-END:variables

}