/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DlpController;
import Controller.Dlp_policyController;
import Controller.Smart_contractController;
import Controller.Smart_contract_policyController;
import Controller.UserController;
import Model.Dlp;
import Model.Dlp_policy;
import Model.Smart_contract;
import Model.Smart_contract_policy;
import Model.User;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roshan Withanage
 */
public class Admin_home extends javax.swing.JFrame {

    /**
     * Creates new form Admin_home
     */
    public Admin_home() {
        initComponents();
        loadUserTable();
        loadSmartPolicyTable();
        loadDlpPolicyTable();
        loadSmartPolicykeywordTable();
        loaddlpkeywordTable();
        loadPolicyIDs();
        loadDLPPolicyIDs();
    }

    private void loadUserTable() {

        List<User> details = null;
        try {
            details = UserController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.user_table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            User s = details.get(i);

            v.add(s.getUser_id());
            v.add(s.getUser_fullname());
            v.add(s.getUsertype());
            v.add(s.getEmail());
            v.add(s.getUsername());
            v.add(s.getPassword());

            but_dt.addRow(v);

        }
    }

    private void loadSmartPolicyTable() {

        List<Smart_contract_policy> details = null;
        try {
            details = Smart_contract_policyController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.smart_policy_table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Smart_contract_policy s = details.get(i);

            v.add(s.getSmart_contract_policy_id());
            v.add(s.getPolicy());
            v.add(s.getDescription());

            but_dt.addRow(v);

        }
    }

    private void loadSmartPolicykeywordTable() {

        List<Smart_contract> details = null;
        try {
            details = Smart_contractController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.smart_keyword_table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Smart_contract s = details.get(i);

            v.add(s.getSmart_contract_id());
            v.add(s.getPolicy_id());
            v.add(s.getWords());

            but_dt.addRow(v);

        }
    }

    private void loadDlpPolicyTable() {

        List<Dlp_policy> details = null;
        try {
            details = Dlp_policyController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.dlp_policy_table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Dlp_policy s = details.get(i);

            v.add(s.getDlp_policy_id());
            v.add(s.getPolicy());
            v.add(s.getDescription());

            but_dt.addRow(v);

        }
    }

    private void loaddlpkeywordTable() {

        List<Dlp> details = null;
        try {
            details = DlpController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.dlp_keyword_table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Dlp s = details.get(i);

            v.add(s.getDlp_id());
            v.add(s.getPolicy_id());
            v.add(s.getWords());

            but_dt.addRow(v);

        }
    }

    public void loadPolicyIDs() {
        List<Smart_contract_policy> details = null;
        try {
            details = Smart_contract_policyController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < details.size(); i++) {
            smart_policy_id.addItem(details.get(i).getSmart_contract_policy_id() + "");
        }
    }

    public void loadDLPPolicyIDs() {
        List<Dlp_policy> details = null;
        try {
            details = Dlp_policyController.getInstance().SearchAll();

        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < details.size(); i++) {
            dlp_policy_id.addItem(details.get(i).getDlp_policy_id() + "");
        }
    }

    private void resetUserForm() {
        user_id.setText("0");
        full_name.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
    }

    private void resetSmartPolicyForm() {
        smart_id.setText("0");
        smart_policy.setText("");
        smart_description.setText("");
    }

    private void resetSmartPolicyKeywordForm() {
        smart_words_id.setText("0");
        smart_keyword.setText("");
    }

    private void resetDlpPolicyForm() {
        dlp_id.setText("0");
        dlp_policy.setText("");
        dlp_description.setText("");
    }

    private void resetDlpPolicyKeywordForm() {
        dlp_keyword_id.setText("0");
        dlp_keyword.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        user_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        full_name = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        usertype = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        smart_policy_table = new javax.swing.JTable();
        smart_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        smart_policy = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        smart_description = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        smart_keyword_table = new javax.swing.JTable();
        smart_words_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        smart_keyword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        smart_policy_id = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dlp_policy_table = new javax.swing.JTable();
        dlp_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dlp_policy = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dlp_description = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        dlp_keyword_table = new javax.swing.JTable();
        dlp_keyword_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dlp_keyword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dlp_policy_id = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1177, 663));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "User Type", "Email", "Username", "Password"
            }
        ));
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(user_table);

        user_id.setBackground(new java.awt.Color(255, 255, 255));
        user_id.setText("0");
        user_id.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Full Name");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User Type");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Password");

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        full_name.setBackground(new java.awt.Color(255, 255, 255));
        full_name.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        usertype.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(full_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("User Management", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        smart_policy_table.setBackground(new java.awt.Color(255, 255, 255));
        smart_policy_table.setForeground(new java.awt.Color(0, 0, 0));
        smart_policy_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Policy", "Description"
            }
        ));
        smart_policy_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smart_policy_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(smart_policy_table);

        smart_id.setBackground(new java.awt.Color(255, 255, 255));
        smart_id.setText("0");
        smart_id.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Policy");

        smart_policy.setBackground(new java.awt.Color(255, 255, 255));
        smart_policy.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Description");

        smart_description.setBackground(new java.awt.Color(255, 255, 255));
        smart_description.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(smart_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smart_policy, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smart_description, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton5, jButton6, jButton7});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(smart_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(smart_policy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(smart_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5)
                            .addComponent(jButton7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Policy", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        smart_keyword_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Policy ID", "Keyword"
            }
        ));
        smart_keyword_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smart_keyword_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(smart_keyword_table);

        smart_words_id.setBackground(new java.awt.Color(255, 255, 255));
        smart_words_id.setText("0");
        smart_words_id.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Policy");

        smart_keyword.setBackground(new java.awt.Color(255, 255, 255));
        smart_keyword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Keyword");

        smart_policy_id.setBackground(new java.awt.Color(255, 255, 255));
        smart_policy_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(smart_words_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(136, 136, 136)
                        .addComponent(jButton10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(smart_policy_id, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(smart_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton8, jButton9});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(smart_words_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(smart_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(smart_policy_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton9))
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Keywords", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Smart Contract", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        dlp_policy_table.setBackground(new java.awt.Color(255, 255, 255));
        dlp_policy_table.setForeground(new java.awt.Color(0, 0, 0));
        dlp_policy_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Policy", "Description"
            }
        ));
        dlp_policy_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlp_policy_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(dlp_policy_table);

        dlp_id.setBackground(new java.awt.Color(255, 255, 255));
        dlp_id.setText("0");
        dlp_id.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Policy");

        dlp_policy.setBackground(new java.awt.Color(255, 255, 255));
        dlp_policy.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Description");

        dlp_description.setBackground(new java.awt.Color(255, 255, 255));
        dlp_description.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton11.setText("Save");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Update");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(dlp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dlp_policy, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dlp_description, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12)))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton11, jButton12, jButton13});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dlp_policy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(dlp_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton11)
                            .addComponent(jButton13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Policy", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        dlp_keyword_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Policy ID", "Keyword"
            }
        ));
        dlp_keyword_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlp_keyword_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(dlp_keyword_table);

        dlp_keyword_id.setBackground(new java.awt.Color(255, 255, 255));
        dlp_keyword_id.setText("0");
        dlp_keyword_id.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Policy");

        dlp_keyword.setBackground(new java.awt.Color(255, 255, 255));
        dlp_keyword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Keyword");

        dlp_policy_id.setBackground(new java.awt.Color(255, 255, 255));
        dlp_policy_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jButton14.setText("Save");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(dlp_keyword_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15)
                        .addGap(117, 117, 117)
                        .addComponent(jButton16))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dlp_policy_id, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(dlp_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton14, jButton15, jButton16});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlp_keyword_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dlp_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(dlp_policy_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton16)
                        .addComponent(jButton15))
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Keywords", jPanel10);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTextPane1.setText("Prophet is a procedure for forecasting time series data based on an additive model where non-linear trends are fit with yearly, weekly, and daily seasonality, plus holiday effects. It works best with time series that have strong seasonal effects and several seasons of historical data. Prophet is robust to missing data and shifts in the trend, and typically handles outliers well.");
        jScrollPane6.setViewportView(jTextPane1);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo2.png"))); // NOI18N

        jButton17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton17.setText("Generate Prediction Report For Next Week");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton18.setText("Generate Sample Prediction");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        jTabbedPane4.addTab("Predictions", jPanel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("DLP", jPanel4);

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login obj = new Login();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (user_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Delete");

        } else {

            User s = new User();
            s.setUser_id(Integer.parseInt(user_id.getText()));

            try {
                UserController.getInstance().Delete(s);
                user_table.removeAll();
                loadUserTable();
                resetUserForm();
                JOptionPane.showMessageDialog(this, "Suser Deleted");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        char c = evt.getKeyChar();
        if (password.getText().length() >= 6 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        } else if (!(Character.isDigit(c))) {

            evt.consume();
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (user_id.getText().isEmpty() || full_name.getText().isEmpty() || email.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            User s = new User();
            s.setUser_id(Integer.parseInt(user_id.getText()));
            s.setUser_fullname(full_name.getText());
            s.setUsertype(usertype.getSelectedItem().toString());
            s.setEmail(email.getText());
            s.setUsername(username.getText());
            s.setPassword(password.getText());
            s.setPrivate_key("sdf");
            s.setPublic_key("sdf");

            try {
                UserController.getInstance().Save(s);
                user_table.removeAll();
                loadUserTable();
                resetUserForm();
                JOptionPane.showMessageDialog(this, "User Saved");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.user_table.getModel();
        int sr = user_table.getSelectedRow();

        user_id.setText(dtm.getValueAt(sr, 0).toString());
        full_name.setText(dtm.getValueAt(sr, 1).toString());
        usertype.setSelectedItem(dtm.getValueAt(sr, 2).toString());
        email.setText(dtm.getValueAt(sr, 3).toString());
        username.setText(dtm.getValueAt(sr, 4).toString());
        password.setText(dtm.getValueAt(sr, 5).toString());
    }//GEN-LAST:event_user_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (user_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to update");

        } else if (user_id.getText().isEmpty() || full_name.getText().isEmpty() || email.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            User s = new User();
            s.setUser_id(Integer.parseInt(user_id.getText()));
            s.setUser_fullname(full_name.getText());
            s.setUsertype(usertype.getSelectedItem().toString());
            s.setEmail(email.getText());
            s.setUsername(username.getText());
            s.setPassword(password.getText());
            s.setPrivate_key("sdf");
            s.setPublic_key("sdf");

            try {
                UserController.getInstance().Update(s);
                user_table.removeAll();
                loadUserTable();
                resetUserForm();
                JOptionPane.showMessageDialog(this, "User Updated");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (smart_id.getText().isEmpty() || smart_policy.getText().isEmpty() || smart_description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Smart_contract_policy s = new Smart_contract_policy();
            s.setSmart_contract_policy_id(Integer.parseInt(smart_id.getText()));
            s.setPolicy(smart_policy.getText());
            s.setDescription(smart_description.getText());

            try {
                Smart_contract_policyController.getInstance().Save(s);
                smart_policy_table.removeAll();
                loadSmartPolicyTable();
                resetSmartPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Saved");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (smart_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to update");

        } else if (smart_id.getText().isEmpty() || smart_policy.getText().isEmpty() || smart_description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Smart_contract_policy s = new Smart_contract_policy();
            s.setSmart_contract_policy_id(Integer.parseInt(smart_id.getText()));
            s.setPolicy(smart_policy.getText());
            s.setDescription(smart_description.getText());

            try {
                Smart_contract_policyController.getInstance().Update(s);
                smart_policy_table.removeAll();
                loadSmartPolicyTable();
                resetSmartPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Updated");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (smart_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Delete");

        } else {

            Smart_contract_policy s = new Smart_contract_policy();
            s.setSmart_contract_policy_id(Integer.parseInt(smart_id.getText()));
            s.setPolicy(smart_policy.getText());
            s.setDescription(smart_description.getText());

            try {
                Smart_contract_policyController.getInstance().Delete(s);
                smart_policy_table.removeAll();
                loadSmartPolicyTable();
                resetSmartPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Deleted");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void smart_policy_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smart_policy_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.smart_policy_table.getModel();
        int sr = smart_policy_table.getSelectedRow();

        smart_id.setText(dtm.getValueAt(sr, 0).toString());
        smart_policy.setText(dtm.getValueAt(sr, 1).toString());
        smart_description.setText(dtm.getValueAt(sr, 2).toString());
    }//GEN-LAST:event_smart_policy_tableMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (smart_words_id.getText().isEmpty() || smart_keyword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Smart_contract s = new Smart_contract();
            s.setSmart_contract_id(Integer.parseInt(smart_words_id.getText()));
            s.setPolicy_id(Integer.parseInt(smart_policy_id.getSelectedItem().toString()));
            s.setWords(smart_keyword.getText());

            try {
                Smart_contractController.getInstance().Save(s);
                smart_keyword_table.removeAll();
                loadSmartPolicykeywordTable();
                resetSmartPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Saved");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (smart_words_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Update");

        } else if (smart_words_id.getText().isEmpty() || smart_keyword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Smart_contract s = new Smart_contract();
            s.setSmart_contract_id(Integer.parseInt(smart_words_id.getText()));
            s.setPolicy_id(Integer.parseInt(smart_policy_id.getSelectedItem().toString()));
            s.setWords(smart_keyword.getText());

            try {
                Smart_contractController.getInstance().Update(s);
                smart_keyword_table.removeAll();
                loadSmartPolicykeywordTable();
                resetSmartPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Updated");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (smart_words_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Delete");

        } else {

            Smart_contract s = new Smart_contract();
            s.setSmart_contract_id(Integer.parseInt(smart_words_id.getText()));
            s.setPolicy_id(Integer.parseInt(smart_policy_id.getSelectedItem().toString()));
            s.setWords(smart_keyword.getText());

            try {
                Smart_contractController.getInstance().Delete(s);
                smart_keyword_table.removeAll();
                loadSmartPolicykeywordTable();
                resetSmartPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Deleted");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void smart_keyword_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smart_keyword_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.smart_keyword_table.getModel();
        int sr = smart_keyword_table.getSelectedRow();

        smart_words_id.setText(dtm.getValueAt(sr, 0).toString());
        smart_policy_id.setSelectedItem(dtm.getValueAt(sr, 1).toString());
        smart_keyword.setText(dtm.getValueAt(sr, 2).toString());
    }//GEN-LAST:event_smart_keyword_tableMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (dlp_id.getText().isEmpty() || dlp_policy.getText().isEmpty() || dlp_description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Dlp_policy s = new Dlp_policy();
            s.setDlp_policy_id(Integer.parseInt(dlp_id.getText()));
            s.setPolicy(dlp_policy.getText());
            s.setDescription(dlp_description.getText());

            try {
                Dlp_policyController.getInstance().Save(s);
                dlp_policy_table.removeAll();
                loadDlpPolicyTable();
                resetDlpPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Saved");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (dlp_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Update");

        } else if (dlp_id.getText().isEmpty() || dlp_policy.getText().isEmpty() || dlp_description.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Dlp_policy s = new Dlp_policy();
            s.setDlp_policy_id(Integer.parseInt(dlp_id.getText()));
            s.setPolicy(dlp_policy.getText());
            s.setDescription(dlp_description.getText());

            try {
                Dlp_policyController.getInstance().Update(s);
                dlp_policy_table.removeAll();
                loadDlpPolicyTable();
                resetDlpPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Updated");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (dlp_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Delete");

        } else {

            Dlp_policy s = new Dlp_policy();
            s.setDlp_policy_id(Integer.parseInt(dlp_id.getText()));
            s.setPolicy(dlp_policy.getText());
            s.setDescription(dlp_description.getText());

            try {
                Dlp_policyController.getInstance().Update(s);
                dlp_policy_table.removeAll();
                loadDlpPolicyTable();
                resetDlpPolicyForm();
                JOptionPane.showMessageDialog(this, "Policy Deleted");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void dlp_policy_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlp_policy_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.dlp_policy_table.getModel();
        int sr = dlp_policy_table.getSelectedRow();

        dlp_id.setText(dtm.getValueAt(sr, 0).toString());
        dlp_policy.setText(dtm.getValueAt(sr, 1).toString());
        dlp_description.setText(dtm.getValueAt(sr, 2).toString());
    }//GEN-LAST:event_dlp_policy_tableMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (dlp_keyword_id.getText().isEmpty() || dlp_keyword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Dlp s = new Dlp();
            s.setDlp_id(Integer.parseInt(dlp_keyword_id.getText()));
            s.setPolicy_id(Integer.parseInt(dlp_policy_id.getSelectedItem().toString()));
            s.setWords(dlp_keyword.getText());

            try {
                DlpController.getInstance().Save(s);
                dlp_keyword_table.removeAll();
                loaddlpkeywordTable();
                resetDlpPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Saved");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (dlp_keyword_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Update");

        } else if (dlp_keyword_id.getText().isEmpty() || dlp_keyword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill form");
        } else {

            Dlp s = new Dlp();
            s.setDlp_id(Integer.parseInt(dlp_keyword_id.getText()));
            s.setPolicy_id(Integer.parseInt(dlp_policy_id.getSelectedItem().toString()));
            s.setWords(dlp_keyword.getText());

            try {
                DlpController.getInstance().Update(s);
                dlp_keyword_table.removeAll();
                loaddlpkeywordTable();
                resetDlpPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Updated");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (dlp_keyword_id.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Please select row to Delete");

        } else {

            Dlp s = new Dlp();
            s.setDlp_id(Integer.parseInt(dlp_keyword_id.getText()));
            s.setPolicy_id(Integer.parseInt(dlp_policy_id.getSelectedItem().toString()));
            s.setWords(dlp_keyword.getText());

            try {
                DlpController.getInstance().Update(s);
                dlp_keyword_table.removeAll();
                loaddlpkeywordTable();
                resetDlpPolicyKeywordForm();
                JOptionPane.showMessageDialog(this, "Keyword Deleted");
            } catch (Exception ex) {
                Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void dlp_keyword_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlp_keyword_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.dlp_keyword_table.getModel();
        int sr = dlp_keyword_table.getSelectedRow();

        dlp_keyword_id.setText(dtm.getValueAt(sr, 0).toString());
        dlp_policy_id.setSelectedItem(dtm.getValueAt(sr, 1).toString());
        dlp_keyword.setText(dtm.getValueAt(sr, 2).toString());
    }//GEN-LAST:event_dlp_keyword_tableMouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        JOptionPane.showMessageDialog(this, "Not enough data available... Please try later..");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
  
        String dir = System.getProperty("user.dir") + "\\src\\FbProphet\\";
        String command = "python /c start python " + dir + "week.py";
        try {
            Process p = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            Logger.getLogger(Admin_home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(this, "Out put file downloaded to " + dir);
    }//GEN-LAST:event_jButton18ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dlp_description;
    private javax.swing.JTextField dlp_id;
    private javax.swing.JTextField dlp_keyword;
    private javax.swing.JTextField dlp_keyword_id;
    private javax.swing.JTable dlp_keyword_table;
    private javax.swing.JTextField dlp_policy;
    private javax.swing.JComboBox<String> dlp_policy_id;
    private javax.swing.JTable dlp_policy_table;
    private javax.swing.JTextField email;
    private javax.swing.JTextField full_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField smart_description;
    private javax.swing.JTextField smart_id;
    private javax.swing.JTextField smart_keyword;
    private javax.swing.JTable smart_keyword_table;
    private javax.swing.JTextField smart_policy;
    private javax.swing.JComboBox<String> smart_policy_id;
    private javax.swing.JTable smart_policy_table;
    private javax.swing.JTextField smart_words_id;
    private javax.swing.JTextField user_id;
    private javax.swing.JTable user_table;
    private javax.swing.JTextField username;
    private javax.swing.JComboBox<String> usertype;
    // End of variables declaration//GEN-END:variables
}
