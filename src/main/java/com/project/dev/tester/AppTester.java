/*
 * @overview        {AppTester}
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
package com.project.dev.tester;

import com.project.dev.tray.setter.TrayIconSetter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * TODO: Description of {@code AppTester}.
 *
 * @author Dyson Parra
 * @since Java 17 (LTS), Gradle 7.3
 */
public class AppTester {

    /**
     * Ejecuta las pruebas de la aplicación.
     *
     * @param args argumentos pasados por consola.
     * @return {@code true} si se ejecutan las pruebas correctamente, {@code false} caso contrario.
     */
    public static boolean startTesting(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(320, 240);
        frame.setTitle("Tray setter example");

        // Agrega imagen al JFrame usando ruta relativa.
        //frame.setIconImage(new ImageIcon(TrayIconSetter.LINUX_ICON_PROJ_PATH).getImage());
        // Agrega imagen al JFrame usando un resource.
        frame.setIconImage(new ImageIcon(AppTester.class.getResource(TrayIconSetter.LINUX_ICON_RES_PATH))
                .getImage());

        // Agrega el JFrame al área de notificación.
        boolean result = TrayIconSetter.setTrayIconToFrame(frame);

        if (result)
            System.out.println("Tray icon added succesfully");
        else
            System.out.println("Tray icon could not be added");

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return result;
    }

}
