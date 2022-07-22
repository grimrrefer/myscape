/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.migrationsupport.rules;

/**
 * @since 5.0
 */
class FailAfterAllHelper {

	static void fail() {
		// hack: use this unrecoverable exception to fail the build, since all others would be swallowed...
		throw new OutOfMemoryError("a postcondition was violated");
	}

}