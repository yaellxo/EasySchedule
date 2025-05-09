import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Clase> clases = new ArrayList<>();

    public static void main(String[] args) {
        // Crear la interfaz gráfica (IDE)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EasySchedule IDE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Área de texto para el código fuente
            JTextArea codeArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(codeArea);

            // Botón para ejecutar el código
            JButton runButton = new JButton("Ejecutar");
            runButton.addActionListener(e -> {
                String code = codeArea.getText();
                System.out.println("Ejecutando código:\n" + code);
                try {
                    ejecutarComando(code);
                    JOptionPane.showMessageDialog(frame, "Código ejecutado correctamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Panel inferior para el botón
            JPanel panel = new JPanel();
            panel.add(runButton);

            // Agregar componentes al frame
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.getContentPane().add(panel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void ejecutarComando(String code) {
        String[] parts = code.split(" ");
        switch (parts[0]) {
            case "add":
                clases.add(new Clase(parts[1], parts[2], parts[3]));
                System.out.println("Clase añadida.");
                break;
            case "show":
                StringBuilder sb = new StringBuilder("Clases:\n");
                for (Clase c : clases) {
                    sb.append(c).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
                break;
            case "delete":
                clases.removeIf(c -> c.getNombre().equals(parts[1]));
                System.out.println("Clase eliminada.");
                break;
            case "update":
                for (Clase c : clases) {
                    if (c.getNombre().equals(parts[1])) {
                        c.setHorario(parts[2]);
                        c.setProfesor(parts[3]);
                        System.out.println("Clase actualizada.");
                        break;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Comando no reconocido.");
        }
    }
}

