/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * Defines a manager.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public class Manager {

	/**
	 * Name.
	 */
	@Parameter
	private String name;

	/**
	 * URL address.
	 */
	@Parameter
	private String url;

	public Manager() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
