import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;

//import org.apache.commons.codec.binary.Base64;
//import org.bouncycastle.asn1.ASN1Sequence;
//import org.bouncycastle.asn1.DERInteger;

public class TestReadKey {

	public static void main(String[] args) {

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get("/Users/juanmanuelcarrascal/projects/Moorea/anses-evidence-index/src/main/resources/certificates/privateKey.pem")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		try {
			PrivateKey pk = getPrivateKeyFromString(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

	public static PrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
		String privateKeyPEM = key;
		privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
		privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
		PKCS8EncodedKeySpec keySpecPKCS8 = null;//new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyPEM));

		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);
		return privKey;
	}

}
