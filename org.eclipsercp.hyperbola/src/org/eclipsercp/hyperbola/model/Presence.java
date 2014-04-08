/*******************************************************************************
 * Copyright (c) 2010 Jean-Michel Lemieux, Jeff McAffer, Chris Aniszczyk and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Hyperbola is an RCP application developed for the book
 *     Eclipse Rich Client Platform - 
 *         Designing, Coding, and Packaging Java Applications
 * See http://eclipsercp.org
 *
 * Contributors:
 *     Jean-Michel Lemieux and Jeff McAffer - initial API and implementation
 *     Chris Aniszczyk - edits for the second edition
 *******************************************************************************/
package org.eclipsercp.hyperbola.model;

public class Presence {
	public static final Presence ONLINE = new Presence("Online");

	public static final Presence AWAY = new Presence("Away");

	public static final Presence DO_NOT_DISTURB = new Presence("Do Not Disturb");

	public static final Presence INVISIBLE = new Presence("Offline");

	private String value;

	private Presence(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
