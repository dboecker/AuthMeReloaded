package fr.xephi.authme.security.crypts;

import static fr.xephi.authme.security.HashUtils.md5;

public class MD5VB extends HexSaltedMethod {

    @Override
    public String computeHash(String password, String salt, String name) {
        return "$MD5vb$" + salt + "$" + md5(md5(password) + salt);
    }

    @Override
    public boolean comparePassword(String hash, String password, String salt, String name) {
        String[] line = hash.split("\\$");
        return line.length == 4 && hash.equals(computeHash(password, line[2], name));
    }

    @Override
    public int getSaltLength() {
        return 16;
    }

}
