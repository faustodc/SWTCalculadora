package com.visual.fausto;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;

public class AppSWT {

	protected Shell shlContador;
	private Text text_precio;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppSWT window = new AppSWT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlContador.open();
		shlContador.layout();
		while (!shlContador.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		final int[] contador = {0};
		
		shlContador = new Shell();
		shlContador.setSize(507, 367);
		shlContador.setText("Contador");
		shlContador.setLayout(new GridLayout(3, false));
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		
		Composite composite = new Composite(shlContador, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite.widthHint = 331;
		composite.setLayoutData(gd_composite);
		new Label(shlContador, SWT.NONE);
		
		Label lblTitulo = new Label(shlContador, SWT.NONE);
		lblTitulo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblTitulo.setAlignment(SWT.CENTER);
		lblTitulo.setText("Calculadora Precios");
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		
		Label lblUnidades = new Label(shlContador, SWT.NONE);
		lblUnidades.setAlignment(SWT.RIGHT);
		GridData gd_lblUnidades = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblUnidades.widthHint = 112;
		lblUnidades.setLayoutData(gd_lblUnidades);
		lblUnidades.setText("Unidades");
		
		Combo combo = new Combo(shlContador, SWT.NONE);
		combo.setItems(new String[] {"1", "2", "3", "4", "5"});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlContador, SWT.NONE);
		
		Label lblPrecio = new Label(shlContador, SWT.NONE);
		GridData gd_lblPrecio = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblPrecio.widthHint = 113;
		lblPrecio.setLayoutData(gd_lblPrecio);
		lblPrecio.setAlignment(SWT.RIGHT);
		lblPrecio.setText("Precio");
		
		text_precio = new Text(shlContador, SWT.BORDER);
		GridData gd_text_precio = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_precio.widthHint = 99;
		text_precio.setLayoutData(gd_text_precio);
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		
		Button btnCalcular = new Button(shlContador, SWT.NONE);
		GridData gd_btnCalcular = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnCalcular.widthHint = 163;
		btnCalcular.setLayoutData(gd_btnCalcular);
		btnCalcular.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnCalcular.setText("Calcular");
		
		
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		
		Label lblTotal = new Label(shlContador, SWT.NONE);
		lblTotal.setAlignment(SWT.CENTER);
		GridData gd_lblTotal = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblTotal.widthHint = 226;
		lblTotal.setLayoutData(gd_lblTotal);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 36, SWT.BOLD));
		lblTotal.setText(String.valueOf(contador[0]));
		new Label(shlContador, SWT.NONE);
		new Label(shlContador, SWT.NONE);
		
		Label lblAviso = new Label(shlContador, SWT.NONE);
		lblAviso.setText(" ");
		lblAviso.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		new Label(shlContador, SWT.NONE);
		
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int unidades = Integer.parseInt(combo.getItem(combo.getSelectionIndex()));
				float precio = Float.parseFloat(text_precio.getText());
				
				if(unidades <= 0 || precio <= 0f) {
					lblAviso.setText("Precio o unidades deben ser mayor a 0");
					lblTotal.setText("!");
				}
				else
				{
					lblAviso.setText("");
					lblTotal.setText(String.valueOf(unidades*precio));
				}
			}
		});
	}
}
