/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * Define the current Sigmah version.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public class Version {

	/**
	 * Number.
	 */
	@Parameter
	private String number;

	/**
	 * Name.
	 */
	@Parameter
	private String name;

	/**
	 * Name.
	 */
	@Parameter
	private String date;

	public Version() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
