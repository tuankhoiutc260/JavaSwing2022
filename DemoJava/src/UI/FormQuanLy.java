/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Model.DiaDiemTiem;
import Model.Quan;
import Model.ThanhPho;
import Model.Vaccine;
import dao.DiaDiemTiemDao;
import dao.QuanHuyenDao;
import dao.ThanhPhoDao;
import dao.VacineDao;
import helper.MessageDialogHelper;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 84976
 */
public class FormQuanLy extends javax.swing.JFrame {

    private DefaultTableModel tblModelCity, tblModelDistrict, tblModelVaccine, tblModelDDTiem;
    /**
     * Creates new form FormQuanLy
     */
    String CityCode;
    public FormQuanLy() {
        
        initComponents();
        loadDataToComboboxCity();
        loadDataToComboboxCityDDTiem();
        loadDataToComboboxQuan();
        loadDataToComboboxVaccine();
        
        txtCityName.setEnabled(false);
        txtCityCode.setEnabled(false);
        btnAddCity.setEnabled(false);
        btnDeleteCity.setEnabled(false);
        btnUpdateCity.setEnabled(false);
        
        txtDistrictCode.setEnabled(false);
        txtDistrictName.setEnabled(false);
        btnSaveDistrict.setEnabled(false);
        btnUpdateDistrict.setEnabled(false);
        btnDeleteDistrict.setEnabled(false);
        
        txtVaccineName.setEnabled(false);
        txtVaccineCode.setEnabled(false);
        btnAddVaccine.setEnabled(false);
        btnUpdateVaccine.setEnabled(false);
        btnDeleteVaccine.setEnabled(false);
        
        txtDDTiemCode.setEnabled(false);
        txtDDTiemName.setEnabled(false);
        btnSaveDDTiem.setEnabled(false);
        btnUpdateDDTiem.setEnabled(false);
        btnDeleteDDTiem.setEnabled(false);
        
        // set center form
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        initTableCity();
        initTableDistrict();
        initTableVaccine();
        initTableDDTiem();
        loadDataCityToTable();
        loadDataDistrictToTable();
        loadDataToTableVaccine();
        loadDataToTableDDTiem();
    }
    
    private void initTableCity(){
        tblModelCity = new DefaultTableModel();
        tblModelCity.setColumnIdentifiers(new String[] {"Mã TP", "Tên TP"});
        tblCity.setModel(tblModelCity);   
    }
    
    private void initTableDistrict(){
        tblModelDistrict = new DefaultTableModel();
        tblModelDistrict.setColumnIdentifiers(new String[] {"Mã Quận", "Tên Quận", "Tên TP"});
        tblDistrict.setModel(tblModelDistrict);   
    }
    
    private void initTableVaccine(){
        tblModelVaccine = new DefaultTableModel();
        tblModelVaccine.setColumnIdentifiers(new String[] {"Mã Vaccine", "Tên Vaccine"});
        tblVaccine.setModel(tblModelVaccine);
    }
    private void initTableDDTiem(){
        tblModelDDTiem = new DefaultTableModel();
        tblModelDDTiem.setColumnIdentifiers(new String[] {"Mã địa điểm", "Tên địa điểm", "Tên Vaccine", "Tên Quận", "Tên TP"});
        tblDDTiem.setModel(tblModelDDTiem);
    }
    
    private void loadDataCityToTable(){
        try{
            ThanhPhoDao dao = new ThanhPhoDao();
            List<ThanhPho> list = dao.findAll();
            tblModelCity.setRowCount(0);
            for(ThanhPho tp : list){      // duyệt qua các đối tượng trong list
                tblModelCity.addRow(new Object[]{tp.getMaTP(), tp.getTenTP()});
            }
            tblModelCity.fireTableDataChanged();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void loadDataDistrictToTable(){
        try{
            QuanHuyenDao dao = new QuanHuyenDao();
            List<Quan> list = dao.findAll();
            tblModelDistrict.setRowCount(0);
            for(Quan q : list){      // duyệt qua các đối tượng trong list
                tblModelDistrict.addRow(new Object[]{q.getMaQuan(), q.getTenQuan(), q.getTenTP()});
            }
            tblModelDistrict.fireTableDataChanged();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }   
    
    private void loadDataToTableVaccine(){
        try{
            VacineDao dao = new VacineDao();
            List<Vaccine> list = dao.findAll();
            tblModelVaccine.setRowCount(0);
            for(Vaccine tp : list){      // duyệt qua các đối tượng trong list
                tblModelVaccine.addRow(new Object[]{tp.getMaVaccine(), tp.getTenVaccine()});
            }
            tblModelVaccine.fireTableDataChanged();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void loadDataToTableDDTiem(){
        try{
            DiaDiemTiemDao dao = new DiaDiemTiemDao();
            List<DiaDiemTiem> list = dao.findAll();
            tblModelDDTiem.setRowCount(0);
            for(DiaDiemTiem ddt : list){      // duyệt qua các đối tượng trong list
                tblModelDDTiem.addRow(new Object[]{ddt.getMaDD(), ddt.getTenDD(), ddt.getTenVaccine(), ddt.getTenQuan(), ddt.getTenTP()});
            }
            tblModelDDTiem.fireTableDataChanged();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        }
    }
       private void loadDataToComboboxCity(){
        try{
            ThanhPhoDao dao = new ThanhPhoDao();
            List<ThanhPho> list = dao.findAll();
            cmbTinhTP.removeAllItems();
            
            for(ThanhPho tp : list){      // duyệt qua các đối tượng trong list
               // cmbTinhTP.setSelectedItem(tp.getMaTP());
                cmbTinhTP.addItem(tp.getTenTP());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
       
              private void loadDataToComboboxCityDDTiem(){
        try{
            ThanhPhoDao dao = new ThanhPhoDao();
            List<ThanhPho> list = dao.findAll();
            cmbCityDDTiem.removeAllItems();
            
            for(ThanhPho tp : list){      // duyệt qua các đối tượng trong list
               // cmbTinhTP.setSelectedItem(tp.getMaTP());
                cmbCityDDTiem.addItem(tp.getTenTP());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
       
      private void loadDataToComboboxQuan(){   
        String code = lblCity_DDTiemCode.getText();
        try{
            QuanHuyenDao dao = new QuanHuyenDao();
            List<Quan> list = dao.findByCityCode(code);
            cmbQuanDDTiem.removeAllItems();
            
            for(Quan q : list){      // duyệt qua các đối tượng trong list
                cmbQuanDDTiem.addItem(q.getTenQuan());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
      
      private void loadDataToComboboxQuanDDT(){   
        String code = lblCity_DDTiemCode.getText();
        try{
            QuanHuyenDao dao = new QuanHuyenDao();
            List<Quan> list = dao.findByCityCode(code);
            cmbQuanDDTiem.removeAllItems();
            
            for(Quan q : list){      // duyệt qua các đối tượng trong list
                cmbQuanDDTiem.addItem(q.getTenQuan());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
       
       private void loadDataToComboboxVaccine(){
        try{
            VacineDao dao = new VacineDao();
            List<Vaccine> list = dao.findAll();
            cmbVaccine.removeAllItems();
            
            for(Vaccine vc : list){      // duyệt qua các đối tượng trong list
               // cmbTinhTP.setSelectedItem(tp.getMaTP());
                cmbVaccine.addItem(vc.getTenVaccine());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCityName = new javax.swing.JTextField();
        btnAddCity = new javax.swing.JButton();
        btnUpdateCity = new javax.swing.JButton();
        btnDeleteCity = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCity = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDistrictCode = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDistrict = new javax.swing.JTable();
        btnAddNewDistrict = new javax.swing.JButton();
        btnUpdateDistrict = new javax.swing.JButton();
        btnDeleteDistrict = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDDTiem = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDDTiemName = new javax.swing.JTextField();
        btnAddNewDDTiem = new javax.swing.JButton();
        btnUpdateDDTiem = new javax.swing.JButton();
        btnDeleteDDTiem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cmbVaccine = new javax.swing.JComboBox<>();
        txtCityCode = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cmbTinhTP = new javax.swing.JComboBox<>();
        txtDistrictName = new javax.swing.JTextField();
        btnSaveDistrict = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblCityCode = new javax.swing.JLabel();
        btnAddNewVC = new javax.swing.JButton();
        btnAddVaccine = new javax.swing.JButton();
        btnUpdateVaccine = new javax.swing.JButton();
        btnDeleteVaccine = new javax.swing.JButton();
        txtVaccineCode = new javax.swing.JTextField();
        txtVaccineName = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVaccine = new javax.swing.JTable();
        btnSaveDDTiem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDDTiemCode = new javax.swing.JTextField();
        lblQuan_DDTiemCode = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbQuanDDTiem = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmbCityDDTiem = new javax.swing.JComboBox<>();
        lblCity_DDTiemCode = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblVaccineCodeDDTiem = new javax.swing.JLabel();
        btnDongFormQuanLy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ứng dụng quản lý tiêm chủng");
        setBackground(new java.awt.Color(204, 204, 0));

        panel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo1.png"))); // NOI18N
        jLabel1.setText("Quản lý thông tin");

        panel2.setBackground(new java.awt.Color(254, 254, 238));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Tỉnh/Thành phố:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã Tỉnh/Thành phố:");
        jLabel3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tên Tỉnh/Thành phố:");
        jLabel5.setToolTipText("");

        btnAddCity.setBackground(new java.awt.Color(0, 51, 153));
        btnAddCity.setForeground(new java.awt.Color(255, 255, 204));
        btnAddCity.setText("Lưu");
        btnAddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCityActionPerformed(evt);
            }
        });

        btnUpdateCity.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdateCity.setForeground(new java.awt.Color(255, 255, 204));
        btnUpdateCity.setText("Sửa");
        btnUpdateCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCityActionPerformed(evt);
            }
        });

        btnDeleteCity.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteCity.setForeground(new java.awt.Color(255, 255, 204));
        btnDeleteCity.setText("Xóa");
        btnDeleteCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCityActionPerformed(evt);
            }
        });

        tblCity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCityMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCity);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Quận/Huyện:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã Quận/Huyện:");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tên Quận/Huyện:");
        jLabel8.setToolTipText("");

        tblDistrict.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDistrict.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDistrictMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDistrict);

        btnAddNewDistrict.setBackground(new java.awt.Color(0, 51, 153));
        btnAddNewDistrict.setForeground(new java.awt.Color(255, 255, 204));
        btnAddNewDistrict.setText("Thêm");
        btnAddNewDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewDistrictActionPerformed(evt);
            }
        });

        btnUpdateDistrict.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdateDistrict.setForeground(new java.awt.Color(255, 255, 204));
        btnUpdateDistrict.setText("Sửa");
        btnUpdateDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDistrictActionPerformed(evt);
            }
        });

        btnDeleteDistrict.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteDistrict.setForeground(new java.awt.Color(255, 255, 204));
        btnDeleteDistrict.setText("Xóa");
        btnDeleteDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDistrictActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Vaccine:");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mã Vaccine:");
        jLabel11.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tên Vaccine:");
        jLabel13.setToolTipText("");

        tblDDTiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDDTiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDDTiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDDTiem);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Địa điểm tiêm:");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Mã địa điểm:");
        jLabel15.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Tên địa điểm:");
        jLabel16.setToolTipText("");

        btnAddNewDDTiem.setBackground(new java.awt.Color(0, 51, 153));
        btnAddNewDDTiem.setForeground(new java.awt.Color(255, 255, 204));
        btnAddNewDDTiem.setText("Thêm");
        btnAddNewDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewDDTiemActionPerformed(evt);
            }
        });

        btnUpdateDDTiem.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdateDDTiem.setForeground(new java.awt.Color(255, 255, 204));
        btnUpdateDDTiem.setText("Sửa");
        btnUpdateDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDDTiemActionPerformed(evt);
            }
        });

        btnDeleteDDTiem.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteDDTiem.setForeground(new java.awt.Color(255, 255, 204));
        btnDeleteDDTiem.setText("Xóa");
        btnDeleteDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDDTiemActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Vaccine:");
        jLabel18.setToolTipText("");

        cmbVaccine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVaccineActionPerformed(evt);
            }
        });

        btnAddNew.setBackground(new java.awt.Color(0, 51, 153));
        btnAddNew.setForeground(new java.awt.Color(255, 255, 204));
        btnAddNew.setText("Thêm");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Tỉnh/Thành phố:");
        jLabel19.setToolTipText("");

        cmbTinhTP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTinhTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTinhTPActionPerformed(evt);
            }
        });

        btnSaveDistrict.setBackground(new java.awt.Color(0, 51, 153));
        btnSaveDistrict.setForeground(new java.awt.Color(255, 255, 204));
        btnSaveDistrict.setText("Lưu");
        btnSaveDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDistrictActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã Thành phố: ");
        jLabel9.setToolTipText("");

        lblCityCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCityCode.setText("Mã Quận/Huyện:");
        lblCityCode.setToolTipText("");

        btnAddNewVC.setBackground(new java.awt.Color(0, 51, 153));
        btnAddNewVC.setForeground(new java.awt.Color(255, 255, 204));
        btnAddNewVC.setText("Thêm");
        btnAddNewVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewVCActionPerformed(evt);
            }
        });

        btnAddVaccine.setBackground(new java.awt.Color(0, 51, 153));
        btnAddVaccine.setForeground(new java.awt.Color(255, 255, 204));
        btnAddVaccine.setText("Lưu");
        btnAddVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVaccineActionPerformed(evt);
            }
        });

        btnUpdateVaccine.setBackground(new java.awt.Color(0, 51, 153));
        btnUpdateVaccine.setForeground(new java.awt.Color(255, 255, 204));
        btnUpdateVaccine.setText("Sửa");
        btnUpdateVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVaccineActionPerformed(evt);
            }
        });

        btnDeleteVaccine.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteVaccine.setForeground(new java.awt.Color(255, 255, 204));
        btnDeleteVaccine.setText("Xóa");
        btnDeleteVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVaccineActionPerformed(evt);
            }
        });

        tblVaccine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVaccine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVaccineMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblVaccine);

        btnSaveDDTiem.setBackground(new java.awt.Color(0, 51, 153));
        btnSaveDDTiem.setForeground(new java.awt.Color(255, 255, 204));
        btnSaveDDTiem.setText("Lưu");
        btnSaveDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDDTiemActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mã Quận/Huyện:");
        jLabel12.setToolTipText("");

        txtDDTiemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDDTiemCodeActionPerformed(evt);
            }
        });

        lblQuan_DDTiemCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQuan_DDTiemCode.setText("Mã Quận/Huyện:");
        lblQuan_DDTiemCode.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Quận/Huyện:");
        jLabel17.setToolTipText("");

        cmbQuanDDTiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbQuanDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQuanDDTiemActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tỉnh/Thành phố:");
        jLabel20.setToolTipText("");

        cmbCityDDTiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCityDDTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCityDDTiemActionPerformed(evt);
            }
        });

        lblCity_DDTiemCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCity_DDTiemCode.setText("Mã Quận/Huyện:");
        lblCity_DDTiemCode.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Tỉnh/Thành phố:");
        jLabel22.setToolTipText("");

        lblVaccineCodeDDTiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVaccineCodeDDTiem.setText("Mã Quận/Huyện:");
        lblVaccineCodeDDTiem.setToolTipText("");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(btnAddNewDistrict)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveDistrict)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateDistrict)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteDistrict)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(btnAddNewVC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddVaccine)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUpdateVaccine)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDeleteVaccine)
                                        .addGap(25, 25, 25))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel11)))
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtVaccineCode, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane4))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel15)))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(lblVaccineCodeDDTiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel18)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDDTiemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtDDTiemName))
                                        .addGap(17, 17, 17))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(btnAddNewDDTiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSaveDDTiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnUpdateDDTiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDeleteDDTiem))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel22))
                                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panel2Layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cmbCityDDTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cmbQuanDDTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panel2Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblCity_DDTiemCode)
                                                            .addComponent(lblQuan_DDTiemCode))))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCityCode, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAddNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdateCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteCity)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(12, 12, 12))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDistrictCode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCityCode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTinhTP, javax.swing.GroupLayout.Alignment.LEADING, 0, 172, Short.MAX_VALUE)
                                    .addComponent(txtDistrictName)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCityCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddCity)
                            .addComponent(btnUpdateCity)
                            .addComponent(btnDeleteCity)
                            .addComponent(btnAddNew)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblCityCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cmbTinhTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDistrictCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDistrictName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddNewDistrict)
                            .addComponent(btnSaveDistrict)
                            .addComponent(btnUpdateDistrict)
                            .addComponent(btnDeleteDistrict)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddNewVC)
                                    .addComponent(btnUpdateVaccine)
                                    .addComponent(btnDeleteVaccine)
                                    .addComponent(btnAddVaccine)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(txtVaccineCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblQuan_DDTiemCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity_DDTiemCode)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmbCityDDTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmbQuanDDTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDDTiemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtDDTiemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cmbVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineCodeDDTiem))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddNewDDTiem)
                            .addComponent(btnUpdateDDTiem)
                            .addComponent(btnDeleteDDTiem)
                            .addComponent(btnSaveDDTiem)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnDongFormQuanLy.setBackground(new java.awt.Color(255, 0, 51));
        btnDongFormQuanLy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDongFormQuanLy.setForeground(new java.awt.Color(255, 255, 204));
        btnDongFormQuanLy.setText("Ðóng");
        btnDongFormQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongFormQuanLyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDongFormQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnDongFormQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCityActionPerformed
        StringBuilder sb = new StringBuilder();
        btnAddCity.setEnabled(false);
        if(txtCityCode.getText().equals("")){
            sb.append("Mã thành phố không được để trống\n");
            btnAddCity.setEnabled(true);
        }

        if(txtCityName.getText().equals("")){
            sb.append("Tên thành phố không được để trống");
            btnAddCity.setEnabled(true);
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        try{
            ThanhPho TP = new ThanhPho();
            TP.setMaTP(txtCityCode.getText());
            TP.setTenTP(txtCityName.getText());

            ThanhPhoDao dao = new ThanhPhoDao();
            dao.insertInfCity(TP);
            JOptionPane.showMessageDialog(this, "Done");
            loadDataToComboboxCity();
            loadDataToComboboxCityDDTiem();
            txtCityName.setEnabled(false);
            txtCityCode.setEnabled(false);
            loadDataCityToTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddCityActionPerformed

    private void btnUpdateCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCityActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtCityCode.getText().equals("")){
            sb.append("Mã thành phố không được để trống\n");
        }

        if(txtCityName.getText().equals("")){
            sb.append("Tên thành phố không được để trống");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            btnUpdateCity.setEnabled(true);
            return;
        }

        try{
            ThanhPho TP = new ThanhPho();
            TP.setMaTP(txtCityCode.getText());
            TP.setTenTP(txtCityName.getText());

            ThanhPhoDao dao = new ThanhPhoDao();
            dao.updateInfCity(TP);
            JOptionPane.showMessageDialog(this, "Done");
            loadDataToComboboxCity();
            btnDeleteCity.setEnabled(false);
            btnUpdateCity.setEnabled(false);
            txtCityName.setEnabled(false);
            txtCityCode.setEnabled(false);
            loadDataCityToTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateCityActionPerformed

    private void btnDeleteCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCityActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtCityCode.getText().equals("")){
            sb.append("Mã thành phố không được để trống\n");
        }

        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }

        if(MessageDialogHelper.showConfirmDialog(this,
            "Bạn có muốn xóa thành phố không?", "Hỏi") == JOptionPane.NO_OPTION){
        return;
        }
        try{
            ThanhPhoDao dao = new ThanhPhoDao();
            if(dao.DeleteInfCity(txtCityCode.getText())){
                MessageDialogHelper.showMessageDialog(this, "Done", "Thông báo");
                loadDataToComboboxCity();
                btnDeleteCity.setEnabled(false);
                btnUpdateCity.setEnabled(false);
                txtCityName.setText("");
                txtCityCode.setText("");
                loadDataCityToTable();
            }
            else{
                MessageDialogHelper.showConfirmDialog(this, "Error", "Thông báo");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");

        }
    }//GEN-LAST:event_btnDeleteCityActionPerformed

    private void tblCityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCityMouseClicked
        btnUpdateCity.setEnabled(true);
        try{
            int row = tblCity.getSelectedRow();
            if(row >=0){
                txtCityName.setEnabled(true);
                btnDeleteCity.setEnabled(true);
                btnAddCity.setEnabled(false);
                String id = (String)tblCity.getValueAt(row, 0);
                ThanhPhoDao dao = new ThanhPhoDao();
                ThanhPho tp = dao.findByID(id);

                if(tp != null){
                    txtCityCode.setText(tp.getMaTP());
                    txtCityName.setText(tp.getTenTP());
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();}
    }//GEN-LAST:event_tblCityMouseClicked

    private void tblDistrictMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDistrictMouseClicked
        btnUpdateDistrict.setEnabled(true);
        try{
            int row = tblDistrict.getSelectedRow();
            if(row >=0){
                txtDistrictName.setEnabled(true);
                btnDeleteDistrict.setEnabled(true);
                btnSaveDistrict.setEnabled(false);
                String id = (String)tblDistrict.getValueAt(row, 0);
                QuanHuyenDao dao = new QuanHuyenDao();
                Quan q = dao.findByID(id);

                if(q != null){
                    txtDistrictCode.setText(q.getMaQuan());
                    txtDistrictName.setText(q.getTenQuan());

                    String comboSub = (String)tblDistrict.getValueAt(row, 2);
                    for (int i = 0; i < cmbTinhTP.getItemCount(); i ++){
                        if(cmbTinhTP.getItemAt(i).equalsIgnoreCase(comboSub)){
                            cmbTinhTP.setSelectedIndex(i);
                        }
                    }
                }

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        try{
            int row = tblDistrict.getSelectedRow();
            if(row >=0){
                txtCityName.setEnabled(true);
                btnDeleteCity.setEnabled(true);
                btnAddCity.setEnabled(false);
                String name = (String)tblDistrict.getValueAt(row, 2);
                ThanhPhoDao dao = new ThanhPhoDao();
                ThanhPho tp = dao.findByName(name);

                if(tp != null){
                    lblCityCode.setText(tp.getMaTP());
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();}
    }//GEN-LAST:event_tblDistrictMouseClicked

    private void btnAddNewDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewDistrictActionPerformed
        txtDistrictCode.setEnabled(true);
        txtDistrictName.setEnabled(true);
        btnAddNewDistrict.setEnabled(true);
        btnSaveDistrict.setEnabled(true);
        btnDeleteDistrict.setEnabled(false);
        txtDistrictCode.setText("");
        txtDistrictName.setText("");
    }//GEN-LAST:event_btnAddNewDistrictActionPerformed

    private void btnUpdateDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDistrictActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtDistrictCode.getText().equals("")){
            sb.append("Mã quận không được để trống\n");
        }

        if(txtDistrictName.getText().equals("")){
            sb.append("Tên quận không được để trống");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            btnUpdateDistrict.setEnabled(true);
            return;
        }

        try{
            Quan Q = new Quan();
            Q.setMaQuan(txtDistrictCode.getText());
            Q.setTenQuan(txtDistrictName.getText());

            QuanHuyenDao dao = new QuanHuyenDao();
            dao.updateInfDictrict(Q);
            JOptionPane.showMessageDialog(this, "Done");
            loadDataToComboboxCity();
            btnDeleteDistrict.setEnabled(false);
            btnUpdateDistrict.setEnabled(false);
            txtDistrictName.setEnabled(false);
            txtDistrictCode.setEnabled(false);
            loadDataDistrictToTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();}
    }//GEN-LAST:event_btnUpdateDistrictActionPerformed

    private void btnDeleteDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDistrictActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtDistrictCode.getText().equals("")){
            sb.append("Mã  quận không được để trống\n");
        }

        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }

        if(MessageDialogHelper.showConfirmDialog(this,
            "Bạn có muốn xóa quận không?", "Hỏi") == JOptionPane.NO_OPTION){
        return;
        }
        try{
            QuanHuyenDao dao = new QuanHuyenDao();
            if(dao.DeleteInfDictrict(txtDistrictCode.getText())){
                MessageDialogHelper.showMessageDialog(this, "Done", "Thông báo");
                loadDataToComboboxCity();
                btnDeleteDistrict.setEnabled(false);
                btnUpdateDistrict.setEnabled(false);
                txtDistrictName.setText("");
                txtDistrictCode.setText("");
                loadDataDistrictToTable();
            }
            else{
                MessageDialogHelper.showConfirmDialog(this, "Error", "Thông báo");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnDeleteDistrictActionPerformed

    private void btnAddNewDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewDDTiemActionPerformed
        txtDDTiemName.setEnabled(true);
        txtDDTiemCode.setEnabled(true);
        btnSaveDDTiem.setEnabled(true);
        btnUpdateDDTiem.setEnabled(false);
        btnDeleteDDTiem.setEnabled(false);
        txtDDTiemCode.setText("");
        txtDDTiemName.setText("");
    }//GEN-LAST:event_btnAddNewDDTiemActionPerformed

    private void btnUpdateDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDDTiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateDDTiemActionPerformed

    private void btnDeleteDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDDTiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteDDTiemActionPerformed

    private void cmbVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineActionPerformed
        try{
            String name = (String) cmbVaccine.getSelectedItem();
            VacineDao dao = new VacineDao();
            Vaccine vc = dao.findByName(name);

            if(vc != null){
                lblVaccineCodeDDTiem.setText(vc.getMaVaccine());

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbVaccineActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        txtCityName.setEnabled(true);
        txtCityCode.setEnabled(true);
        btnAddCity.setEnabled(true);
        btnUpdateCity.setEnabled(false);
        btnDeleteCity.setEnabled(false);
        txtCityCode.setText("");
        txtCityName.setText("");
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void cmbTinhTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTinhTPActionPerformed
        try{
            String name = (String) cmbTinhTP.getSelectedItem();
            ThanhPhoDao dao = new ThanhPhoDao();
            ThanhPho tp = dao.findByName(name);

            if(tp != null){
                lblCityCode.setText(tp.getMaTP());

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbTinhTPActionPerformed

    private void btnSaveDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDistrictActionPerformed
        StringBuilder sb = new StringBuilder();
        loadDataDistrictToTable();

        btnSaveDistrict.setEnabled(false);
        if(txtDistrictCode.getText().equals("")){
            sb.append("Mã quận không được để trống\n");
            btnSaveDistrict.setEnabled(true);
        }

        if(txtDistrictName.getText().equals("")){
            sb.append("Tên quận không được để trống");
            btnSaveDistrict.setEnabled(true);
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            //String test = cmbTinhTP.getSelectedObjects();
            Quan Q = new Quan();
            int a = index;
            // Q.setMaTP(cmbTinhTP.getSelectedItem().toString());
            //String CityCode = 
            
            Q.setMaTP(lblCityCode.getText());
            //
            try{
                ThanhPhoDao dao = new ThanhPhoDao();
                List<ThanhPho> list = dao.findAll();
                cmbTinhTP.removeAllItems();
                for(ThanhPho tp : list){      // duyệt qua các đối tượng trong list
                    cmbTinhTP.addItem(tp.getMaTP());
                }
            }
            catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
            //

            Q.setMaQuan(txtDistrictCode.getText());
            Q.setTenQuan(txtDistrictName.getText());

            QuanHuyenDao dao2 = new QuanHuyenDao();
            dao2.insertInfDistrict(Q);
            JOptionPane.showMessageDialog(this, "Done");
            loadDataToComboboxCity();
            loadDataToComboboxQuan();
            txtDistrictName.setEnabled(false);
            txtDistrictCode.setEnabled(false);

            loadDataDistrictToTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveDistrictActionPerformed

    private void btnAddNewVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewVCActionPerformed
        txtVaccineName.setEnabled(true);
        txtVaccineCode.setEnabled(true);
        btnAddVaccine.setEnabled(true);
        btnUpdateVaccine.setEnabled(false);
        btnDeleteVaccine.setEnabled(false);
        txtVaccineCode.setText("");
        txtVaccineName.setText("");         // TODO add your handling code here:
    }//GEN-LAST:event_btnAddNewVCActionPerformed

    private void btnAddVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVaccineActionPerformed
        StringBuilder sb = new StringBuilder();

        if(txtVaccineCode.getText().equals("")){
            sb.append("Mã Vaccine không được để trống\n");
        }

        if(txtVaccineName.getText().equals("")){
            sb.append("Tên Vaccine không được để trống");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        try{
            Vaccine VC = new Vaccine();
            VC.setMaVaccine(txtVaccineCode.getText());
            VC.setTenVaccine(txtVaccineName.getText());

            VacineDao dao = new VacineDao();
            dao.insertInfVaccine(VC);
            JOptionPane.showMessageDialog(this, "Done");
            initTableVaccine();
            loadDataToTableVaccine();
            txtVaccineCode.setEnabled(false);
            txtVaccineName.setEnabled(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddVaccineActionPerformed

    private void btnUpdateVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVaccineActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(txtVaccineCode.getText().equals("")){
            sb.append("Mã Vaccine không được để trống\n");
        }

        if(txtVaccineName.getText().equals("")){
            sb.append("Tên Vaccine không được để trống");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        try{
            Vaccine VC = new Vaccine();
            VC.setMaVaccine(txtVaccineCode.getText());
            VC.setTenVaccine(txtVaccineName.getText());

            VacineDao dao = new VacineDao();
            dao.updateInfVaccine(VC);
            JOptionPane.showMessageDialog(this, "Done");
            initTableVaccine();
            loadDataToTableVaccine();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateVaccineActionPerformed

    private void btnDeleteVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVaccineActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(txtVaccineCode.getText().equals("")){
            sb.append("Mã Vaccine không được để trống\n");
        }

        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(this, sb.toString(), "Lỗi");
            return;
        }

        if(MessageDialogHelper.showConfirmDialog(this,
            "Bạn có muốn xóa Vaccine không?", "Hỏi") == JOptionPane.NO_OPTION){
        return;
        }
        try{
            VacineDao dao = new VacineDao();
            if(dao.DeleteInfVaccine(txtVaccineCode.getText())){
                MessageDialogHelper.showMessageDialog(this, "Done", "Thông báo");
                initTableVaccine();
                txtVaccineCode.setText("");
                txtVaccineName.setText("");
                loadDataToTableVaccine();
            }
            else{
                MessageDialogHelper.showConfirmDialog(this, "Error", "Thông báo");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");

        }
    }//GEN-LAST:event_btnDeleteVaccineActionPerformed

    private void tblVaccineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVaccineMouseClicked
        // TODO add your handling code here:
        btnUpdateVaccine.setEnabled(true);
        try{
            int row = tblVaccine.getSelectedRow();
            if(row >=0){
                txtVaccineCode.setEnabled(false);
                txtVaccineName.setEnabled(true);
                btnDeleteVaccine.setEnabled(true);
                btnAddVaccine.setEnabled(false);
                String id = (String)tblVaccine.getValueAt(row, 0);
                VacineDao dao = new VacineDao();
                Vaccine vc = dao.findByID(id);

                if(vc != null){
                    txtVaccineCode.setText(vc.getMaVaccine());
                    txtVaccineName.setText(vc.getTenVaccine());
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();}
    }//GEN-LAST:event_tblVaccineMouseClicked

    private void btnSaveDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDDTiemActionPerformed
        StringBuilder sb = new StringBuilder();

        if(txtDDTiemCode.getText().equals("")){
            sb.append("Mã địa điểm không được để trống\n");
        }

        if(txtDDTiemName.getText().equals("")){
            sb.append("Tên địa điểm không được để trống");
        }

        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        try{
            DiaDiemTiem DD = new DiaDiemTiem();
            DD.setMaVaccine(lblVaccineCodeDDTiem.getText());
            DD.setMaQuan(lblQuan_DDTiemCode.getText());
            DD.setMaTP(lblCity_DDTiemCode.getText());
            DD.setMaDD(txtDDTiemCode.getText());
            DD.setTenDD(txtDDTiemName.getText());

            DiaDiemTiemDao dao = new DiaDiemTiemDao();
            dao.insertInfDDTiem(DD);
            JOptionPane.showMessageDialog(this, "Done");
            initTableDDTiem();
            loadDataToTableDDTiem();
            txtDDTiemCode.setEnabled(false);
            txtDDTiemName.setEnabled(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btnSaveDDTiemActionPerformed

    private void cmbQuanDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQuanDDTiemActionPerformed
        lblQuan_DDTiemCode.setText("");
        try{
            String name = (String) cmbQuanDDTiem.getSelectedItem();
            QuanHuyenDao dao = new QuanHuyenDao();
            Quan q = dao.findByName(name);

            if(q != null){
                lblQuan_DDTiemCode.setText(q.getMaQuan());
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }

  
    }//GEN-LAST:event_cmbQuanDDTiemActionPerformed

    private void cmbCityDDTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCityDDTiemActionPerformed
        lblCity_DDTiemCode.setText("");
        cmbQuanDDTiem.removeAllItems();

        try{
            String name = (String) cmbCityDDTiem.getSelectedItem();
            ThanhPhoDao dao = new ThanhPhoDao();
            ThanhPho tp = dao.findByName(name);

            if(tp != null){
                lblCity_DDTiemCode.setText(tp.getMaTP());
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
            
        }
        loadDataToComboboxQuan();
    }//GEN-LAST:event_cmbCityDDTiemActionPerformed

    private void btnDongFormQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongFormQuanLyActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FormTrangChu formTrangChu = new FormTrangChu();
        formTrangChu.show();
    }//GEN-LAST:event_btnDongFormQuanLyActionPerformed

    private void txtDDTiemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDDTiemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDDTiemCodeActionPerformed

    private void tblDDTiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDDTiemMouseClicked
        btnUpdateDDTiem.setEnabled(true);
        try{
            int row = tblDDTiem.getSelectedRow();
            if(row >=0){
                txtDistrictName.setEnabled(true);
                btnDeleteDDTiem.setEnabled(true);
                btnSaveDDTiem.setEnabled(false);
                String id = (String)tblDDTiem.getValueAt(row, 0);
                DiaDiemTiemDao dao = new DiaDiemTiemDao();
                DiaDiemTiem ddt = dao.findByID(id);

                if(ddt!= null){
                    txtDDTiemCode.setText(ddt.getMaDD());
                    txtDDTiemName.setText(ddt.getTenDD());

                    String comboSub1 = (String)tblDDTiem.getValueAt(row, 4);
                    for (int i = 0; i < cmbCityDDTiem.getItemCount(); i ++){
                        if(cmbCityDDTiem.getItemAt(i).equalsIgnoreCase(comboSub1)){
                            cmbCityDDTiem.setSelectedIndex(i);
                        }
                    }
                    String comboSub2 = (String)tblDDTiem.getValueAt(row, 3);
                    for (int i = 0; i < cmbQuanDDTiem.getItemCount(); i ++){
                        if(cmbQuanDDTiem.getItemAt(i).equalsIgnoreCase(comboSub2)){
                            cmbQuanDDTiem.setSelectedIndex(i);
                        }
                    }
                }

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        try{
            int row = tblDistrict.getSelectedRow();
            if(row >=0){
                txtCityName.setEnabled(true);
                btnDeleteCity.setEnabled(true);
                btnAddCity.setEnabled(false);
                String name = (String)tblDistrict.getValueAt(row, 2);
                ThanhPhoDao dao = new ThanhPhoDao();
                ThanhPho tp = dao.findByName(name);

                if(tp != null){
                    lblCityCode.setText(tp.getMaTP());
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();}
    }//GEN-LAST:event_tblDDTiemMouseClicked
int index;
    private void loadDataToComboboxDistrict(){   
        String code = lblCityCode.getText();
        try{
            QuanHuyenDao dao = new QuanHuyenDao();
            List<Quan> list = dao.findByCityCode(code);
            cmbQuanDDTiem.removeAllItems();
            
            for(Quan q : list){      // duyệt qua các đối tượng trong list
                cmbQuanDDTiem.addItem(q.getTenQuan());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCity;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnAddNewDDTiem;
    private javax.swing.JButton btnAddNewDistrict;
    private javax.swing.JButton btnAddNewVC;
    private javax.swing.JButton btnAddVaccine;
    private javax.swing.JButton btnDeleteCity;
    private javax.swing.JButton btnDeleteDDTiem;
    private javax.swing.JButton btnDeleteDistrict;
    private javax.swing.JButton btnDeleteVaccine;
    private javax.swing.JButton btnDongFormQuanLy;
    private javax.swing.JButton btnSaveDDTiem;
    private javax.swing.JButton btnSaveDistrict;
    private javax.swing.JButton btnUpdateCity;
    private javax.swing.JButton btnUpdateDDTiem;
    private javax.swing.JButton btnUpdateDistrict;
    private javax.swing.JButton btnUpdateVaccine;
    private javax.swing.JComboBox<String> cmbCityDDTiem;
    private javax.swing.JComboBox<String> cmbQuanDDTiem;
    private javax.swing.JComboBox<String> cmbTinhTP;
    private javax.swing.JComboBox<String> cmbVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCityCode;
    private javax.swing.JLabel lblCity_DDTiemCode;
    private javax.swing.JLabel lblQuan_DDTiemCode;
    private javax.swing.JLabel lblVaccineCodeDDTiem;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTable tblCity;
    private javax.swing.JTable tblDDTiem;
    private javax.swing.JTable tblDistrict;
    private javax.swing.JTable tblVaccine;
    private javax.swing.JTextField txtCityCode;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtDDTiemCode;
    private javax.swing.JTextField txtDDTiemName;
    private javax.swing.JTextField txtDistrictCode;
    private javax.swing.JTextField txtDistrictName;
    private javax.swing.JTextField txtVaccineCode;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
