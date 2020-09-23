/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BlockChain.Block;
import Controller.MsgController;
import Controller.UserController;
import Email.JavaEmail;
import Main.AES;
import Main.DRL;
import Main.Policy;
import Main.RSA;
import Model.LoginModel;
import Model.Msg;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Roshan Withanage
 */
public class Home extends javax.swing.JFrame {

    private String currentDate;
    private String currenTime;

    /**
     * Creates new form Home
     */
    public Home() throws Exception {
        initComponents();
        showDate();
        showTime();
        loadMembers();
        loadHistory();
        loadUsers();
        loggedUser.setText(LoginModel.getInstance().getUser_fullname());
        if (LoginModel.getInstance().getUsertype().equals("User")) {
            TabbedPane.setEnabledAt(2, false);
        }
    }

    void showDate() {

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = s.format(d);
        date.setText(currentDate);
    }

    void showTime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                currenTime = s.format(d);
                time.setText(currenTime);
            }
        }).start();
    }

    void loadMembers() throws Exception {
        //Load table details
        membersTable.setRowHeight(40);
        List<User> details = null;
        try {
            details = UserController.getInstance().SearchAll();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.membersTable.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            User obj = details.get(i);

            if (LoginModel.getInstance().getUser_id() != obj.getUser_id()) {

                v.add(obj.getUser_id());
                v.add(obj.getUser_fullname());
                v.add("ofline");
                but_dt.addRow(v);
            }

        }

    }

    void loadHistory() throws Exception {
        //Load table details
        history.setRowHeight(40);
        List<Msg> details = null;
        try {
            details = MsgController.getInstance().SearchAll();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.history.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Msg obj = details.get(i);

            v.add(obj.getHash());
            v.add(obj.getPreviousHash());
            v.add(obj.getTimeStamp());
            v.add(obj.getSender_id());
            v.add(obj.getRecever_id());
            v.add(obj.getContent());
            but_dt.addRow(v);

        }

    }

    void loadMessage(int id) {

        try {
            List<Msg> list = MsgController.getInstance().Search(id, LoginModel.getInstance().getUser_id());

            jTable1.setRowHeight(15);
            DefaultTableModel jtable = (DefaultTableModel) this.jTable1.getModel();
            jtable.setRowCount(0);

            AES aes = AES.getInstance();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSender_id() == LoginModel.getInstance().getUser_id()) {
                    aes.setKey(list.get(i).getTimeStamp() + "Krowc4");
                    System.out.println(list.get(i).getContent());
                    String data = aes.decrypt(list.get(i).getContent());
                    System.out.println(data);
                    textarea.append("Me : " + data);

                    Vector v = new Vector();
                    v.add(list.get(i).getId());
                    v.add("Me : ");
                    v.add(data);
                    jtable.addRow(v);
                } else {
                    aes.setKey(list.get(i).getTimeStamp() + "Krowc4");
                    String data = aes.decrypt(list.get(i).getContent());
                    textarea.append(username.getText() + " : " + data);
                    Vector v = new Vector();
                    v.add(list.get(i).getId());
                    v.add(username.getText());
                    v.add(data);
                    jtable.addRow(v);

                }
                textarea.append("\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void loadUsers() throws Exception {
        //Load table details
        userTable.setRowHeight(40);
        List<User> details = null;
        try {
            details = UserController.getInstance().SearchAll();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        DefaultTableModel but_dt = (DefaultTableModel) this.userTable.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            User obj = details.get(i);

            v.add(obj.getUser_id());
            v.add(obj.getUser_fullname());
            v.add(obj.getUsertype());
            v.add(obj.getEmail());
            v.add(obj.getUsername());
            v.add(obj.getPassword());
            v.add(obj.getPublic_key());
            v.add(obj.getPrivate_key());
            but_dt.addRow(v);

        }

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
        TabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        send = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        loggedUser = new javax.swing.JLabel();
        user_id = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        message_id = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        admin_full_name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        admin_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        admin_user_id = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        user_type = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Application");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        membersTable.setBackground(new java.awt.Color(255, 255, 255));
        membersTable.setForeground(new java.awt.Color(0, 0, 0));
        membersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Status"
            }
        ));
        membersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(membersTable);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Members");

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        textarea.setBackground(new java.awt.Color(255, 255, 255));
        textarea.setColumns(20);
        textarea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textarea.setForeground(new java.awt.Color(0, 0, 0));
        textarea.setRows(5);
        textarea.setEnabled(false);
        jScrollPane3.setViewportView(textarea);

        send.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setForeground(new java.awt.Color(0, 0, 0));
        date.setText("Datte");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setForeground(new java.awt.Color(0, 0, 0));
        time.setText("Time");

        loggedUser.setBackground(new java.awt.Color(255, 255, 255));
        loggedUser.setForeground(new java.awt.Color(0, 0, 0));
        loggedUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loggedUser.setText("User");

        jLabel3.setText("Current Chat member :");

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sender", "Content"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jButton6.setBackground(new java.awt.Color(255, 102, 102));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        message_id.setForeground(new java.awt.Color(255, 255, 255));
        message_id.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(search)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(date)
                        .addGap(76, 76, 76)
                        .addComponent(time)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loggedUser, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(user_id, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(message_id, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date)
                    .addComponent(time)
                    .addComponent(loggedUser)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(message_id, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(user_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)
                            .addComponent(jButton1))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton6});

        TabbedPane.addTab("Chat", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hash", "Previous Hash", "Timestamp", "Sender", "Reciver", "Message"
            }
        ));
        jScrollPane1.setViewportView(history);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabbedPane.addTab("History", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Full Name", "User Type", "Email", "Username", "Password", "Public Key", "Private Key"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(userTable);

        admin_full_name.setBackground(new java.awt.Color(255, 255, 255));
        admin_full_name.setForeground(new java.awt.Color(0, 0, 0));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setForeground(new java.awt.Color(0, 0, 0));

        admin_username.setBackground(new java.awt.Color(255, 255, 255));
        admin_username.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Full Name");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("User Type");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Username");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Password");

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("User ID");

        admin_user_id.setText("0");
        admin_user_id.setEnabled(false);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        user_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(admin_user_id, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(158, 158, 158)
                                        .addComponent(user_type, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(157, 157, 157)
                                .addComponent(admin_full_name)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel7)
                                .addGap(396, 396, 396))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(344, 344, 344)))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {admin_full_name, admin_user_id, admin_username, email, password});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(admin_user_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(user_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {admin_full_name, admin_user_id, admin_username, email, password});

        TabbedPane.addTab("Admin Panel", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        DefaultTableModel model = (DefaultTableModel) membersTable.getModel();
        String text = search.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        membersTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(text.trim(), 0));
    }//GEN-LAST:event_searchKeyReleased

    private void membersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membersTableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.membersTable.getModel();
        int sr = membersTable.getSelectedRow();
        user_id.setText(dtm.getValueAt(sr, 0).toString());
        username.setText(dtm.getValueAt(sr, 1).toString());

        try {

            loadMessage((int) dtm.getValueAt(sr, 0));

        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_membersTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (send.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter you message to send");
        } else if (user_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select Member to send message");
        } else {

            Policy policy = Policy.getInstance();
            DRL drl = DRL.getInstance();
            if (policy.findViolation(send.getText())) {

                JOptionPane.showMessageDialog(null, "--- Policy Violation!!! ---");
                JavaEmail mail = JavaEmail.getInstance();
//                Email violation
                try {

                    String sendmail[] = {"sankamadushanka78@gmail.com"};
                    String mailData = "Employee ID : " + LoginModel.getInstance().getUser_id() + " Employee Name : " + LoginModel.getInstance().getUser_fullname() + " Violation : " + policy.getViolations();
                    mail.executeEmail(sendmail, "Violation", mailData);
                } catch (MessagingException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (drl.findDrl(send.getText())) {
                JOptionPane.showMessageDialog(null, "--- DRL Violation!!! ---");
                JavaEmail mail = JavaEmail.getInstance();
//                Email violation
                try {

                    String sendmail[] = {"sankamadushanka78@gmail.com"};
                    String mailData = "Employee ID : " + LoginModel.getInstance().getUser_id() + " Employee Name : " + LoginModel.getInstance().getUser_fullname() + " DRL : " + policy.getViolations();
                    mail.executeEmail(sendmail, "Violation", mailData);
                } catch (MessagingException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                AES aes = AES.getInstance();
                aes.setKey(Instant.now().getEpochSecond() + "Krowc4");

                Msg data = null;
                try {

                    Msg msg = MsgController.getInstance().getLast();
                    Block block = new Block(aes.encrypt(send.getText()), msg.getHash(), LoginModel.getInstance().getUser_id(), Integer.parseInt(user_id.getText()));

                    data = new Msg(0, block.getHash(), msg.getHash(), Instant.now().getEpochSecond() + "", LoginModel.getInstance().getUser_id(), Integer.parseInt(user_id.getText()), aes.encrypt(send.getText()));

                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    MsgController.getInstance().Save(data);
                    textarea.append("me : " + send.getText());
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                loadMessage(Integer.parseInt(user_id.getText()));
            }

        }

        try {
            loadHistory();
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        LoginModel lm = LoginModel.getInstance();
        lm.setEmail("");
        lm.setPassword("");
        lm.setPrivate_key("");
        lm.setPublic_key("");
        lm.setUser_fullname("");
        lm.setUser_id(0);
        lm.setUsername("");
        lm.setUsertype("");
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
        int sr = jTable1.getSelectedRow();
        message_id.setText(dtm.getValueAt(sr, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (Integer.parseInt(message_id.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Please Select Message to Delete");
        } else {
            try {
                AES aes = AES.getInstance();
                aes.setKey(MsgController.getInstance().getTimeStamp(Integer.parseInt(message_id.getText())) + "Krowc4");

                MsgController.getInstance().Update(Integer.parseInt(message_id.getText()), aes.encrypt("This message was deleted by : " + LoginModel.getInstance().getUser_fullname()));
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadMessage(Integer.parseInt(user_id.getText()));

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        User user = new User();
        user.setUser_id(Integer.parseInt(admin_user_id.getText()));
        user.setUser_fullname(admin_full_name.getText());
        user.setUsertype(user_type.getSelectedItem().toString());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setEmail(email.getText());

        AES aes = AES.getInstance();
        aes.setKey(Instant.now().getEpochSecond() + "Krowc4");
        
        try {
            user.setPublic_key(aes.encrypt(admin_full_name.getText()));
            user.setPrivate_key(aes.encrypt(admin_full_name.getText()+"Krowc4"));
            
            UserController.getInstance().Save(user);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        User user = new User();
        user.setUser_id(Integer.parseInt(admin_user_id.getText()));
        user.setUser_fullname(admin_full_name.getText());
        user.setUsertype(user_type.getSelectedItem().toString());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setEmail(email.getText());

        AES aes = AES.getInstance();
        aes.setKey(Instant.now().getEpochSecond() + "Krowc4");
        
        try {
            user.setPublic_key(aes.encrypt(admin_full_name.getText()));
            user.setPrivate_key(aes.encrypt(admin_full_name.getText()+"Krowc4"));
            
            UserController.getInstance().Update(user);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        User user = new User();
        user.setUser_id(Integer.parseInt(admin_user_id.getText()));
        
        try {
            
            UserController.getInstance().Delete(user);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.userTable.getModel();
        int sr = userTable.getSelectedRow();
        admin_user_id.setText(dtm.getValueAt(sr, 0).toString());
        admin_full_name.setText(dtm.getValueAt(sr, 1).toString());
        user_type.setSelectedItem(dtm.getValueAt(sr, 2).toString());
        email.setText(dtm.getValueAt(sr, 3).toString());
        admin_username.setText(dtm.getValueAt(sr, 4).toString());
        password.setText(dtm.getValueAt(sr, 5).toString());
    }//GEN-LAST:event_userTableMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JTextField admin_full_name;
    private javax.swing.JTextField admin_user_id;
    private javax.swing.JTextField admin_username;
    private javax.swing.JLabel date;
    private javax.swing.JTextField email;
    private javax.swing.JTable history;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel loggedUser;
    private javax.swing.JTable membersTable;
    private javax.swing.JLabel message_id;
    private javax.swing.JTextField password;
    private javax.swing.JTextField search;
    private javax.swing.JTextField send;
    private javax.swing.JTextArea textarea;
    private javax.swing.JLabel time;
    private javax.swing.JTable userTable;
    private javax.swing.JLabel user_id;
    private javax.swing.JComboBox<String> user_type;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
