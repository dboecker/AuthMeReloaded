package fr.xephi.authme.security.crypts;

import fr.xephi.authme.security.crypts.description.HasSalt;
import fr.xephi.authme.security.crypts.description.Recommendation;
import fr.xephi.authme.security.crypts.description.SaltType;
import fr.xephi.authme.security.crypts.description.Usage;

/**
 * Common supertype of encryption methods that use a player's username
 * (or something based on it) as salt.
 */
@Recommendation(Usage.DO_NOT_USE)
@HasSalt(SaltType.USERNAME)
public abstract class UsernameSaltMethod implements NewEncrMethod {

    @Override
    public abstract HashResult computeHash(String password, String name);

    @Override
    public boolean comparePassword(String hash, String password, String salt, String name) {
        return hash.equals(computeHash(password, name).getHash());
    }

    @Override
    @Deprecated
    public boolean comparePassword(String hash, String password, String playerName) {
        return false;
    }

    @Override
    public String computeHash(String password, String salt, String name) {
        return computeHash(password, name).getHash();
    }

    @Override
    public String generateSalt() {
        return null;
    }

    @Override
    public boolean hasSeparateSalt() {
        return false;
    }

}
