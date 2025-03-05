package gUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import clasesOperativas.*;
public class Proyecto extends JFrame implements ActionListener {
    JPanel jpNorte, jpSur, jpCentro;
    //Variables Cliente
    JLabel jlbCveCte, jlbNombre, jlbDireccion, jlbFolio, jlbFecha, jlbRFC;
    JTextField txtCveCte, txtNombre, txtDireccion, txtFolio, txtFecha, txtRFC;
    // Nuevo: crea una nueva columna en la tabla de productos
    // Guarda: Guarda el cliente y los productos
    // Modificar: Modifica una columna de la tabla productos
    // Eliminar: Elimina una columna en la tabla productos
    // Consultar: Abre un archivo con un cliente en especifico
    JButton btnNuevo, btnGuardar, btnModificar, btnEliminar,btnConsultar;
    // jpCNorte: contiene La tabla de productos
    // jpCSur: Contiene Los botones y datos para agregar eliminar y modificar productos
    JPanel jpCNorte, jpCSur;
    //Variables tabla productos
    JTable jtPuntoDeVenta;
    DefaultTableModel dftPuntoDeVenta;
    JLabel jlbCantidad, jlbDescripcion, jlbPrecioUnitario;
    JTextField txtCantidad, txtDescripcion, txtPrecioUnitario;
    JScrollPane jspPuntoDeVenta;
    // Valores calculadas
    JLabel jlbSubtotal, jlbDesc,jlbImpuesto, jlbTotal;
    JTextField txtSubtotal, txtDesc, txtImpuesto, txtTotal;
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Producto> productos = new ArrayList<Producto>();
    //Constructor
    public Proyecto() {
        super("Punto de venta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        initcomponentes();
    }

    private void initcomponentes() {
        jpNorte = new JPanel();
        jpNorte.setBackground(new Color(255, 255, 255));
        jpNorte.setLayout(new GridLayout(2, 4));
        add(jpNorte, BorderLayout.NORTH);
        initPanelNorte();
        jpSur = new JPanel();
        jpSur.setBackground(new Color(60, 86, 189));
        jpSur.setLayout(new FlowLayout());
        jpSur.setLayout(new GridLayout(5, 3));
        add(jpSur, BorderLayout.SOUTH);
        initPanelSur();
        jpCentro = new JPanel();
        jpCentro.setBackground(new Color(172, 172, 172));
        add(jpCentro, BorderLayout.CENTER);
        initPanelCentro();
    }

    private void initPanelCentro() {
        jpCNorte = new JPanel();
        dftPuntoDeVenta = new DefaultTableModel();
        jspPuntoDeVenta = new JScrollPane();
        //Area norte
        String NombreColumnas[] = {"Cantidad","Descripcion","Precio Unitario","Importe"};
        dftPuntoDeVenta.setColumnIdentifiers(NombreColumnas);
        jtPuntoDeVenta = new JTable(dftPuntoDeVenta);
        jspPuntoDeVenta.setViewportView(jtPuntoDeVenta);
        jpCNorte.add(jspPuntoDeVenta);
        jpCentro.add(jpCNorte);


        jpCSur = new JPanel();
        jpCSur.setLayout(new GridLayout(5, 2));
        //Area Sur
        //Renglon 1
        jlbCantidad = new JLabel("Cantidad: ");
        jpCSur.add(jlbCantidad);
        txtCantidad = new JTextField();
        jpCSur.add(txtCantidad);
        jlbDescripcion = new JLabel("Descripcion: ");
        jpCSur.add(jlbDescripcion);
        txtDescripcion = new JTextField();
        jpCSur.add(txtDescripcion);
        //Renglon 2
        jlbPrecioUnitario = new JLabel("Precio Unitario: ");
        jpCSur.add(jlbPrecioUnitario);
        txtPrecioUnitario = new JTextField();
        jpCSur.add(txtPrecioUnitario);
        //Renglon 3
        btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(this);
        jpCSur.add(btnNuevo);
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        jpCSur.add(btnModificar);
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        jpCSur.add(btnEliminar);

        jpCentro.add(jpCSur);

    }

    private void initPanelNorte() {
        //renglon 1
        jlbCveCte = new JLabel("Clave del cliente");
        jpNorte.add(jlbCveCte);
        txtCveCte = new JTextField();
        jpNorte.add(txtCveCte);
        jlbNombre = new JLabel("Nombre");
        jpNorte.add(jlbNombre);
        txtNombre = new JTextField();
        jpNorte.add(txtNombre);
        //renglon 2
        jlbDireccion = new JLabel("Direccion");
        jpNorte.add(jlbDireccion);
        txtDireccion = new JTextField();
        jpNorte.add(txtDireccion);
        jlbFolio = new JLabel("Folio");
        jpNorte.add(jlbFolio);
        txtFolio = new JTextField();
        jpNorte.add(txtFolio);
        //renglon 3
        jlbFecha = new JLabel("Fecha");
        jpNorte.add(jlbFecha);
        txtFecha = new JTextField();
        jpNorte.add(txtFecha);
        jlbRFC = new JLabel("RFC");
        jpNorte.add(jlbRFC);
        txtRFC = new JTextField();
        jpNorte.add(txtRFC);
    }

    private void initPanelSur() {
        //renglon 1
        jlbSubtotal = new JLabel("Subtotal");
        jpSur.add(jlbSubtotal);
        txtSubtotal = new JTextField();
        jpSur.add(txtSubtotal);
        //renglon 2
        jlbDesc = new JLabel("Desc");
        jpSur.add(jlbDesc);
        txtDesc = new JTextField();
        jpSur.add(txtDesc);
        //renglon 3
        jlbImpuesto = new JLabel("Impuesto");
        jpSur.add(jlbImpuesto);
        txtImpuesto = new JTextField();
        jpSur.add(txtImpuesto);
        //renglon 4
        jlbTotal = new JLabel("Total");
        jpSur.add(jlbTotal);
        txtTotal = new JTextField();
        jpSur.add(txtTotal);
        //renglon 5
        btnGuardar = new JButton("Guardar Cliente");
        btnGuardar.addActionListener(this);
        jpSur.add(btnGuardar);
        btnConsultar = new JButton("Consultar Cliente");
        btnConsultar.addActionListener(this);
        jpSur.add(btnConsultar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones de tabla de punto de venta
        if (e.getSource() == btnNuevo) {
            String descripcion = txtDescripcion.getText();  //Obtener texto
            txtDescripcion.setText("");                     //Limpiar el texto
            int cantidad = Integer.parseInt(txtCantidad.getText());
            txtCantidad.setText("");
            double precioUnitrario = Double.parseDouble(txtPrecioUnitario.getText());
            txtPrecioUnitario.setText("");
            double Importe = cantidad * precioUnitrario; //Calcula Importe
            dftPuntoDeVenta.addRow(new Object[] {cantidad, descripcion, precioUnitrario, Importe});
            productos.add(new Producto(descripcion,cantidad,precioUnitrario)); //agregar elemento al array List
        }
        if (e.getSource() == btnModificar) {
            //Modificar elemento en ArrayList
            productos.set(jtPuntoDeVenta.getSelectedRow(), new Producto(txtDescripcion.getText(), Integer.parseInt(txtCantidad.getText()), Double.parseDouble(txtPrecioUnitario.getText())));
            //Modificar elemento en la tabla de punto de venta
            dftPuntoDeVenta.setValueAt(txtCantidad.getText(), jtPuntoDeVenta.getSelectedRow(), 0);
            dftPuntoDeVenta.setValueAt(txtDescripcion.getText(), jtPuntoDeVenta.getSelectedRow(), 1);
            dftPuntoDeVenta.setValueAt(txtPrecioUnitario.getText(), jtPuntoDeVenta.getSelectedRow(), 2);
            dftPuntoDeVenta.setValueAt(Integer.parseInt(txtCantidad.getText()) * Double.parseDouble(txtPrecioUnitario.getText()),jtPuntoDeVenta.getSelectedRow(),3);
            txtPrecioUnitario.setText("");
            txtCantidad.setText("");
            txtDescripcion.setText("");
        }
        if (e.getSource() == btnEliminar) {
            productos.remove(jtPuntoDeVenta.getSelectedRow()); //Quitar Elemento del ArrayList
            dftPuntoDeVenta.removeRow(jtPuntoDeVenta.getSelectedRow()); // Eliminar elemento de la tabla
        }
        valoresCalculados(productos); //Actualizar los valores calculados cada vez que se realiza cambios en la tabla
        //Botones de cliente
        if(e.getSource() == btnGuardar) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar... ");
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setCurrentDirectory(new File("C://Users//sebas//Documents//SEBASTIAN//Topicos//Proyecto_Topicos//src//clientes"));
            chooser.setAcceptAllFileFilterUsed(true); // cuando es verdadero muestra la opcion de todos los archivos
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String nomArc = chooser.getSelectedFile().getName();
                clientes.clear();
                clientes.add(new Cliente(txtCveCte.getText(), txtNombre.getText(),txtDireccion.getText(), txtRFC.getText(),txtFolio.getText(),
                                            txtFecha.getText(), productos));
                System.out.println("C://Users//sebas//Documents//SEBASTIAN//Topicos//Proyecto_Topicos//src//clientes/"+nomArc);
                SerializarObjeto.serializarObjeto("C://Users//sebas//Documents//SEBASTIAN//Topicos//Proyecto_Topicos//src//clientes/"+nomArc, clientes);
            }
        }
        if(e.getSource() == btnConsultar) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Abrir... ");
            chooser.setCurrentDirectory(new File("C://Users//sebas//Documents//SEBASTIAN//Topicos//Proyecto_Topicos//src//clientes"));
            chooser.setAcceptAllFileFilterUsed(true); // cuando es verdadero muestra la opcion de todos los archivos
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String nomArc = chooser.getSelectedFile().getName();
                ArrayList<Cliente> clienteConsulta = SerializarObjeto.desealizarObjeto("C://Users//sebas//Documents//SEBASTIAN//Topicos//Proyecto_Topicos//src//clientes/"+nomArc, ArrayList.class);
                cargarDatos(clienteConsulta);
                clientes = clienteConsulta;
                productos = clienteConsulta.getFirst().getProductos();
            }

        }
    }


    public void valoresCalculados(ArrayList<Producto> pro) {
        double subtotal = 0;
        double impuesto = 10; //%
        double descuento = 0; //%
        double total;
        for (Producto p: pro) {
            subtotal += p.calcularImporte();
        }
        total = subtotal + ((impuesto / 100) * subtotal);
        total -= ((descuento / 100) *total);
        txtSubtotal.setText(Double.toString(subtotal));
        txtDesc.setText(Integer.toString((int)descuento) + "%");
        txtImpuesto.setText(Integer.toString((int)impuesto) + "%");
        txtTotal.setText(Double.toString(total));
    }
    public void cargarDatos(ArrayList<Cliente> cte){
        for(Cliente c: cte){
            //Datos Cliente
            txtCveCte.setText(c.getCveCte());
            txtNombre.setText(c.getNombre());
            txtDireccion.setText(c.getDireccion());
            txtFecha.setText(c.getFecha());
            txtRFC.setText(c.getrFC());
            txtFolio.setText(c.getFolio());
            //Datos Producto
            valoresCalculados(c.getProductos());
            //datos tabla de punto de venta
            //si hay elementos en la tabla los elimina
            dftPuntoDeVenta.getDataVector().removeAllElements();
            for(Producto p: c.getProductos()){
                dftPuntoDeVenta.addRow(new Object[] {p.getCantidad(), p.getDescripcion(), p.getPrecioUnitario(), p.getCantidad() * p.getPrecioUnitario()});
            }
        }
    }
}
