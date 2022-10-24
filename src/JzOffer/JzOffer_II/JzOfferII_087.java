package JzOffer.JzOffer_II;

import Leet.Medium.LC_93;

import java.util.LinkedList;
import java.util.List;

public class JzOfferII_087 {
    /*
     * 同LC_93
     * */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12) return new LinkedList<>();
        return new LC_93().restoreIpAddresses(s);
    }
}
