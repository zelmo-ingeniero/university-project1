
package segundo.GUI;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import segundo.DAO.DAOusuarios;
import segundo.Segundo;
import segundo.modelos.Usuarios;
import segundo.modelos.Util;

/**
 *
 * @author zelmo
 */
public class RegistroUsuarios extends JInternalFrame implements MetodosBasicos {
    Integer id = -1;
    DefaultComboBoxModel<String> dcbmsexo = new DefaultComboBoxModel<String>();
    DefaultTableModel dtmUsuarios = new DefaultTableModel();
    
    public RegistroUsuarios() {
        instanciarTabla();
        initComponents();
        // pasar InterfalFrame a Pane
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        // Quitando el boton
        pane.remove(0);
        // O haciendolo invisible
        pane.getComponent(0).setVisible(false);
    }
    
    public void habilitar(Boolean s){
        this.cbsexo.setEnabled(s);
        this.tdatos.setEnabled(s);
        this.tfcontraseña.setEnabled(s);
        this.tfcorreo.setEnabled(s);
        this.tfnombre.setEnabled(s);
        this.tfedad.setEnabled(s);
    }
    public void tfLimpiar(){
        this.tfnombre.setText("");
        this.tfcorreo.setText("");
        this.tfcontraseña.setText("");
        this.tfedad.setText("");
        this.dcbmsexo.removeAllElements();
        instanciarCombo();
    }
    private void instanciarCombo(){
        dcbmsexo.addElement("Seleccione su sexo.");
        dcbmsexo.addElement("Mujer");
        dcbmsexo.addElement("Hombre");
    }
    private void instanciarTabla(){
        Vector<String> cabecera = new Vector<String>();
        cabecera.add("Id");
        cabecera.add("Nombre");
        cabecera.add("Edad");
        cabecera.add("Sexo");
        cabecera.add("E-mail");        
        Vector<Vector<String>> salida = new Vector<Vector<String>>();
        dtmUsuarios = new DefaultTableModel(salida, cabecera);
        System.out.println("tabla instanciada :9 ");
        for(String c: cabecera){
            System.out.println("c "+c);
        }
    }
    private ArrayList<String> defensa(){
        ArrayList<String> rr=new ArrayList<>();
        String n = this.tfnombre.getText();
        String m = this.tfcorreo.getText();
        String c = this.tfcontraseña.getText();
        String e = this.tfedad.getText();
        String sexo = dcbmsexo.getSelectedItem().toString();
        if(n.isEmpty() || m.isEmpty() || c.isEmpty() || e.isEmpty()){
            rr.add("Algunos campos son obligatorios.");
        }else{
            if(n.trim().length() < 3){
                rr.add("El nombre de usuario es muy corto.");
            }
            if(!(m.contains("@"))){
                rr.add("El correo electronico es invalido.");
            }
            if(c.contains(" ")){
                rr.add("Hay espacios en la contraseña.");
            }
            if(sexo.equals("Seleccione su sexo.")){
                rr.add("Seleccione su sexo.");
            }
            try{
                Integer.parseInt(e);
            }catch(NumberFormatException nfe){
                rr.add("La edad debe ser escrita en numeros.");
            }
        }
        return rr;
    }
    
    private void salida(){  
        ArrayList<Usuarios> listita = new DAOusuarios().buscar();
        while(dtmUsuarios.getRowCount() != 0){
            dtmUsuarios.removeRow(0);
        }        
        for(Usuarios u : listita){
            Vector<String> fila = new Vector<String>();
            fila.add(u.getId() + "");
            fila.add(u.getNombre());
            fila.add(u.getEdad() + "");
            fila.add(u.getSexo());
            fila.add(u.getEmail());            
            dtmUsuarios.addRow(fila);
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
        tfedad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfcontraseña = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfcorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbsexo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        becerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdatos = new javax.swing.JTable();

        setTitle("Registrate");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tfedad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña");

        tfcontraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Sexo");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        tfnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("E-mail");

        tfcorreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Edad");

        cbsexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbsexo.setModel(dcbmsexo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfnombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 170, Short.MAX_VALUE))
                    .addComponent(tfcorreo)
                    .addComponent(tfedad)
                    .addComponent(tfcontraseña)
                    .addComponent(cbsexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        becerrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        becerrar.setText("Finalizar");
        becerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                becerrarActionPerformed(evt);
            }
        });

        tdatos.setModel(dtmUsuarios);
        tdatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tdatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(becerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(becerrar)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void becerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_becerrarActionPerformed
        this.salir();
    }//GEN-LAST:event_becerrarActionPerformed

    private void tdatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdatosMouseClicked
        if(tdatos.isEnabled()){
            Segundo.mdi.hBotones(false,false,true,true,true);
            habilitar(false);
            tdatos.setEnabled(true);
            int f = tdatos.getSelectedRow();
            if(f >= 0){
                Integer i = Integer.parseInt((String)dtmUsuarios.getValueAt(f, 0));
                Usuarios u = new DAOusuarios().obtener(i);
                if(u != null){
                    this.id = u.getId();
                    this.tfnombre.setText(u.getNombre());
                    this.tfcorreo.setText(u.getEmail());
                    this.tfedad.setText(u.getEdad() + "");
                    this.tfcontraseña.setText(u.getContraseña());
                    this.cbsexo.setSelectedItem(u.getSexo());
                }
            }
        }else{
            return;
        }
    }//GEN-LAST:event_tdatosMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        instanciarCombo();                
        habilitar(false);
        tfLimpiar();
        salida();        
        Segundo.mdi.hBotones(true, false, false, false, false);
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton becerrar;
    private javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tdatos;
    private javax.swing.JTextField tfcontraseña;
    private javax.swing.JTextField tfcorreo;
    private javax.swing.JTextField tfedad;
    private javax.swing.JTextField tfnombre;
    // End of variables declaration//GEN-END:variables
      
    
    
    @Override
    public void nuevo() {
        Segundo.mdi.hBotones(false,true,true,false,false);
        habilitar(true); 
        tdatos.setEnabled(false);
    }

    @Override
    public void guardar() {
        habilitar(false);        
        Segundo.mdi.hBotones(true,false,false,false,false);
        ArrayList<String> e = defensa();
        if(e.isEmpty()){
            Integer edad = Integer.parseInt(this.tfedad.getText());
            String sexo = dcbmsexo.getSelectedItem().toString();
            String nombre = this.tfnombre.getText();
            String correo = this.tfcorreo.getText();
            String contra = this.tfcontraseña.getText();
            Usuarios nu = new Usuarios(id,edad,nombre,sexo,correo,contra);
            Boolean gu = new DAOusuarios().guardar(nu);
            if(gu){
                salida();
                tfLimpiar();
                tdatos.setEnabled(true);
            }else{
                JOptionPane.showInternalMessageDialog(Segundo.mdi.destop(), "Algo malo ha ocurrido, puedes reiniciar el dispositivo.","Guardar",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showInternalMessageDialog(Segundo.mdi.destop(), e, "Entrada invalida",JOptionPane.WARNING_MESSAGE);            
        }
    }

    @Override
    public void cancelar() {
        tfLimpiar();
        Segundo.mdi.hBotones(true,false,false,false,false);
        habilitar(false);
        tdatos.setEnabled(false);
    }

    @Override
    public void editar() {
        Segundo.mdi.hBotones(false,true,true,false,false);
        habilitar(true);
        tdatos.setEnabled(false);
    }

    @Override
    public void borrar() {
        DAOusuarios dao = new DAOusuarios();  
        Usuarios u;
        ArrayList<Usuarios> listita = new ArrayList<>();
        int r;
        System.out.println("lent "+ Segundo.usuarios.size());
        System.out.println("fila "+tdatos.getSelectedRow());
        System.out.println("this id  -1 "+(this.id - 1));
        System.out.println(dao.obtener(id).getNombre());
        if((this.id ) > -1 ){
            u = dao.obtener((this.id));
            r = JOptionPane.showInternalConfirmDialog(Segundo.mdi.destop(), 
                    "Seguro que quieres eliminar a " + u.getNombre()+" ?", 
                    "Eliminar", JOptionPane.YES_NO_OPTION);
            if(r == JOptionPane.YES_OPTION){
                if(dao.borrar(this.id)){
                    this.id = -1;
                    System.out.println("borrado");
                    listita = dao.buscar();
                    for(Usuarios lu : listita){
                        System.out.println(lu.getId());
                    }
                    tfLimpiar();
                    salida();
                }else{
                    JOptionPane.showInternalMessageDialog(Segundo.mdi.destop(), 
                            "Tenemos problemas para eliminar esta cuenta, r"
                          + "einicie el dispositivo", "Eliminar",
                          JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    @Override
    public void salir() {
        Segundo.mdi.hBotones(false, false, false, false, false);
        this.hide();
    }

    @Override
    public void activar() {
        Segundo.mdi.hBotones(true, false, false, false, false);
        Segundo.ru.show();
        this.habilitar(false);
        this.tfLimpiar();
        tdatos.setEnabled(true);
    }
    
}
