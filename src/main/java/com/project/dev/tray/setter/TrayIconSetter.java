/*
 * @fileoverview    {TrayIconSetter}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.tray.setter;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;

/**
 * TODO: Definición de {@code TrayIconSetter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class TrayIconSetter implements TrayIconSetterConstant {

    /**
     * FIXME: Definición de {@code setTrayIconToFrame}. Agrega un TrayIcon a un JFrame.
     *
     * @param frame es el JFrame al que se le agregará un TrayIcon.
     * @return Si fue posible asignar un trayIcon.
     */
    public static boolean setTrayIconToFrame(final JFrame frame) {

        // Si el sistema soporta systemTray.
        if (SystemTray.isSupported()) {

            if (frame.getIconImage() == null) {                                                 // Si el JFrame no tiene una imagen asociada.
                frame.setIconImage(
                        new ImageIcon(TrayIconSetter.class.getResource(DEFAULT_ICON_RES_PATH)
                        ).getImage());                                                          // Asigna imagen por defecto al JFrame.
            }
            PopupMenu trayPopupMenu = new PopupMenu();                                          // Crea un menú popup.

            // Configura el trayIcon.
            final SystemTray systemTray = SystemTray.getSystemTray();                           // Obtiene el systemTray del sistema.
            Image icon = frame.getIconImage();                                                  // Almacena el icono del frame.
            String title = frame.getTitle();                                                    // Almacena el titulo del frame.
            final TrayIcon trayIcon = new TrayIcon(icon, title, trayPopupMenu);                 // Crea un trayIcon con la imagen, el texto y el popup indicados.
            trayIcon.setImageAutoSize(true);                                                    // Ajusta el tamaño del icono al recomendado por el sistema.

            // Crea un item en el menú popup para abrir el JFrame y lo agrega al menú popup.
            MenuItem open = new MenuItem("abrir");
            open.addActionListener((ActionEvent e) -> {
                frame.setVisible(true);
                frame.setExtendedState(JFrame.NORMAL);
            });
            trayPopupMenu.add(open);

            // Crea un item en el menú popup para cerrar el JFrame y lo agrega al menú popup.
            MenuItem close = new MenuItem("cerrar");
            close.addActionListener((ActionEvent e) -> {
                systemTray.remove(trayIcon);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            });
            trayPopupMenu.add(close);

            // Agrega evento de maximizar al dar doble clic en el trayIcon.
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        frame.setVisible(true);
                        frame.setExtendedState(JFrame.NORMAL);
                    }
                }
            });

            // Agrega el listener de cambios de estado de la ventana.
            frame.addWindowStateListener((WindowEvent e) -> {
                if (e.getNewState() == ICONIFIED || e.getNewState() == 7) {
                    try {
                        systemTray.add(trayIcon);                                               // Agrega ventana al systemTray.
                        frame.setVisible(false);                                                // Pone invisible la ventana.
                    } catch (AWTException ignored) {
                    }
                } else if (e.getNewState() == MAXIMIZED_BOTH || e.getNewState() == NORMAL) {
                    systemTray.remove(trayIcon);                                                // Remove ventana al systemTray.
                    frame.setVisible(true);                                                     // Pone visible la ventana.
                }
            });
            return true;
        } else                                                                                  // Si el sistema no soporta systemTray.
            return false;
    }
}
