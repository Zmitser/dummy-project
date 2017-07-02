package model;

import enums.Variants;
import lombok.NoArgsConstructor;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.sun.org.apache.bcel.internal.classfile.Utility.toHexString;


@NoArgsConstructor
public class PC {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public String choice() throws NoSuchAlgorithmException, InvalidKeyException {
        Integer key = 1000 + (int) (Math.random() * 8999);
        Integer choiceVariant = (int) (Math.random() * Variants.values().length);
        SecretKeySpec signingKey = new SecretKeySpec(key.toString().getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return toHexString(mac.doFinal(choiceVariant.toString().getBytes()));
    }
}
