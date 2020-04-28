package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

/**
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@PWA(name = "vaadin-typescript-app", shortName = "vaadin-typescript-app", enableInstallPrompt = false)
public class AppShell implements AppShellConfigurator {
}
