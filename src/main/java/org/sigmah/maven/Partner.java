/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * Defines a partner.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public class Partner extends Manager {

	// Available roles: developer, ergonomist, designer
	private static enum Role {

		DEVELOPER("DEV"),
		ERGONOMIST("DES"),
		DESIGNER("GRA");

		private final String code;

		private Role(String code) {
			this.code = code;
		}

		/**
		 * Gets the role enum for the given string (not case sensitive).
		 * 
		 * @param str
		 *          The string.
		 * @return The role enum or <code>null</code>.
		 */
		private static Role forName(String str) {

			if (str == null) {
				return null;
			}

			str = str.trim().toUpperCase();

			try {
				return valueOf(str);
			} catch (IllegalArgumentException e) {
				return null;
			}

		}

	}

	/**
	 * Role.
	 */
	@Parameter
	private String role;

	public Partner() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleCode() {

		final Role roleEnum = Role.forName(role);

		// Default role.
		if (roleEnum == null) {
			return Role.DEVELOPER.code;
		} else {
			return roleEnum.code;
		}

	}

}
