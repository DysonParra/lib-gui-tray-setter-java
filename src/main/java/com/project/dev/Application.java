/*
 * @fileoverview {Application} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {Application} fue realizada el 31/07/2022.
 * @Dev - La primera version de {Application} fue escrita por Dyson A. Parra T.
 */
package com.project.dev;

import com.project.dev.tray.setter.TrayIconSetter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * TODO: Definición de {@code Application}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class Application {

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(320, 240);
        frame.setTitle("Tray setter example");

        // Agrega imagen al JFrame usando ruta relativa.
        //frame.setIconImage(new ImageIcon(TrayIconSetter.LINUX_ICON_PROJ_PATH).getImage());
        // Agrega imagen al JFrame usando un resource.
        frame.setIconImage(
                new ImageIcon(Application.class.getResource(TrayIconSetter.LINUX_ICON_RES_PATH))
                        .getImage());

        // Agrega el JFrame al área de notificación.
        TrayIconSetter.setTrayIconToFrame(frame);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
