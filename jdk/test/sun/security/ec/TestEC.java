/*
 * Copyright 2009 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/**
 * @test
 * @bug 6840752
 * @summary  Provide out-of-the-box support for ECC algorithms
 * @library ../pkcs11
 * @library ../pkcs11/ec
 * @run main TestEC
 */

import java.security.Provider;

/*
 * Leverage the collection of EC tests used by PKCS11
 *
 * NOTE: the following files were copied here from the PKCS11 EC Test area
 *       and must be kept in sync with the originals:
 *
 *           ../pkcs11/ec/p12passwords.txt
 *           ../pkcs11/ec/pkcs12/secp256r1server-secp384r1ca.p12
 *           ../pkcs11/ec/pkcs12/sect193r1server-rsa1024ca.p12
 */

public class TestEC {

    public static void main(String[] args) throws Exception {
        Provider p = new sun.security.ec.SunEC();
        System.out.println("Running tests with " + p.getName() +
            " provider...\n");

        long start = System.currentTimeMillis();
        new TestECDH().main(p);
        new TestECDSA().main(p);
        //new TestCurves().main(p);
        new TestKeyFactory().main(p);
        new TestECGenSpec().main(p);
        new ReadPKCS12().main(p);
        //new ReadCertificates().main(p);
        long stop = System.currentTimeMillis();

        System.out.println("\nCompleted tests with " + p.getName() +
            " provider (" + (stop - start) + " ms).");
    }
}