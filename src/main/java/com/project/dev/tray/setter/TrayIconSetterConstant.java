/*
 * @fileoverview    {TrayIconSetterConstant}
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

/**
 * TODO: Description of {@code TrayIconSetterConstant}.
 *
 * @author Dyson Parra
 * @since 11
 */
public interface TrayIconSetterConstant {

    public static final String RES_ROOT_PATH = "/assets/com/project/dev/tray/setter";
    public static final String PROJ_PATH = "src/main/resources";
    public static final String PROJ_RES_PATH = PROJ_PATH + RES_ROOT_PATH;

    public static final String DEFAULT_ICON_FILE = "default_tray_icon.png";
    public static final String DEFAULT_ICON_RES_PATH = RES_ROOT_PATH + "/" + DEFAULT_ICON_FILE;
    public static final String DEFAULT_ICON_PROJ_PATH = PROJ_RES_PATH + "/" + DEFAULT_ICON_FILE;

    public static final String LINUX_ICON_FILE = "linux_tray_icon.png";
    public static final String LINUX_ICON_RES_PATH = RES_ROOT_PATH + "/" + LINUX_ICON_FILE;
    public static final String LINUX_ICON_PROJ_PATH = PROJ_RES_PATH + "/" + LINUX_ICON_FILE;

}
