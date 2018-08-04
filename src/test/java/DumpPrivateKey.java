import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import sun.misc.BASE64Encoder;

public class DumpPrivateKey {

	static public void main(String[] args) throws Exception {

		final String keystoreName = "/Users/juanmanuelcarrascal/implementation/testjmc.p12";
		final String keystorePassword = "123456";
		final String alias = "jmc";
		final String keyPassword = getKeyPassword(args, keystorePassword);
		KeyStore ks = KeyStore.getInstance("pkcs12");
		ks.load(new FileInputStream(keystoreName), keystorePassword.toCharArray());
		Key key = ks.getKey(alias, keyPassword.toCharArray());
		String b64 = new BASE64Encoder().encode(key.getEncoded());
		System.out.println("-----BEGIN PRIVATE KEY-----");
		System.out.println(b64);
		System.out.println("-----END PRIVATE KEY-----");
	}

	private static String getKeyPassword(final String[] args, final String keystorePassword) {
		String keyPassword = keystorePassword; // default case
		if (args.length == 4) {
			keyPassword = args[3];
		}
		return keyPassword;
	}
}