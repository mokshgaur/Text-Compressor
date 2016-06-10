import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
public class huf extends javax.swing.JFrame {

    public huf() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        no = new javax.swing.JButton();
        yes = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        ano = new javax.swing.JButton();
        decomp = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        comp = new javax.swing.JTextArea();
        text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        no.setText("Exit");
        no.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    noActionPerformed(evt);
                }
            });

        yes.setText("Compress");
        yes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    yesActionPerformed(evt);
                }
            });

        openButton.setText("Choose File To Be Compressed ");
        openButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    openButtonActionPerformed(evt);
                }
            });

        ano.setText("Compress Another File");
        ano.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    anoActionPerformed(evt);
                }
            });

        decomp.setText("Decompress");
        decomp.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    decompActionPerformed(evt);
                }
            });

        label2.setText("Your file has been decompressed, click to go to folder :");

        view.setText("Open Folder");
        view.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    viewActionPerformed(evt);
                }
            });

        comp.setEditable(false);
        comp.setBackground(java.awt.Color.lightGray);
        comp.setColumns(20);
        comp.setRows(5);
        scroll.setViewportView(comp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ano, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text)
                    .addComponent(decomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openButton)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(decomp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(no)
                .addGap(13, 13, 13))
        );

        pack();
    }

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {
        String strperc = "";
        try
        {
            strperc = huff.compress();
            if(! strperc.equals("Type not supported"))
            {
                comp.setText("");
                comp.setVisible(true);
                scroll.setVisible(true);
                decomp.setVisible(true);
                ano.setVisible(true);
                text.setText("");
                comp.append(strperc);
                //huff.s = "";
                //huff.path = "";
            }
            else
            {
                JOptionPane.showMessageDialog(variable, strperc + 
                    " ,please Enter a valid file type",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                text.setText("");
            }
        }
        catch(Exception f)
        {
            if(huff.s == "")
            {
                JOptionPane.showMessageDialog(variable,
                    "Please Select a file",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                text.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(variable,
                    "We're sorry. We couldn't locate your file.Please Try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                text.setText("");
            }
        }
    }

    private void decompActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            huff.decompress();
            label2.setVisible(true);
            view.setVisible(true);
        }
        catch(Exception g)
        {
            System.out.println("Some problem has occured. Try again.");
        }
    }

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {
        comp.setText("");
        huff.s= "";
        huff.path = "";
        huff.r = 0;
        huff.pos = 0;
        huff.ans = "";
        huff.a = 0;
        huff.len = 0;
        huff.f = "";
        huff.de_file = "";
        huff.code= new String[65536];
        comp.setVisible(false);
        scroll.setVisible(false);
        ano.setVisible(false);
        decomp.setVisible(false);
        label2.setVisible(false);
        view.setVisible(false);
    }

    private void noActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(variable,"Thank you for using our application.","A plain message",JOptionPane.PLAIN_MESSAGE);
        variable.dispose();
    }

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {
        comp.setText("");
        huff.s= "";
        huff.path = "";
        huff.r = 0;
        huff.pos = 0;
        huff.ans = "";
        huff.a = 0;
        huff.len = 0;
        huff.f = "";
        huff.de_file = "";
        huff.code= new String[65536];
        comp.setVisible(false);
        scroll.setVisible(false);
        ano.setVisible(false);
        decomp.setVisible(false);
        label2.setVisible(false);
        view.setVisible(false);
        int val = chf.showOpenDialog(huf.this); 
        if (val == JFileChooser.APPROVE_OPTION) 
        {
            File file = chf.getSelectedFile();
            huff.path = file.getPath();
            huff.s = file.getName();
            text.setText("");
            text.setText("Do you wish to compress : " + file.getName() + "?" );
        } 
        else 
        {
            JOptionPane.showMessageDialog(variable,
                "Please Select a  file." + "\n",
                "A plain message",
                JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {

        File nfile = new File("C:\\Users\\pratulramkumar\\Desktop\\textcompression");
		// the path is system specific, won't work on ubuntu, as ubuntu does not recognise the '\' as a valid file seperator, we need to make use of the FileSeperator attribute.
        if(!Desktop.isDesktopSupported())
        {
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        try
        {
            if(nfile.exists()) desktop.open(nfile);
        }
        catch(Exception f)
        {
            System.out.println("Try again");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(huf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(huf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(huf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(huf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    variable = new huf();
                    variable.setVisible(true);
                    variable.decomp.setVisible(false);
                    variable.ano.setVisible(false);
                    variable.comp.setVisible(false);
                    variable.view.setVisible(false);
                    variable.label2.setVisible(false);
                    variable.scroll.setVisible(false);
                }
            });
    }
    public static huf variable;
    
    JFileChooser chf = new JFileChooser();
    private javax.swing.JButton ano;
    private javax.swing.JTextArea comp;
    private javax.swing.JButton decomp;
    private javax.swing.JLabel label2;
    private javax.swing.JButton no;
    private javax.swing.JButton openButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField text;
    private javax.swing.JButton view;
    private javax.swing.JButton yes;

}
