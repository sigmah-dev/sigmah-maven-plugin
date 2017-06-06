/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * Defines a person.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public abstract class Person {

	/**
	 * Name.
	 */
	@Parameter
	private String name;

	/**
	 * Email address.
	 */
	@Parameter
	private String email;

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
