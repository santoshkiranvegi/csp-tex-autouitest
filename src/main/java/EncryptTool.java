import ca.teranet.util.EncryptUtil;

public class EncryptTool {

	public static void main(String args[]) {
		System.out.println("Encryption Utility v1.0");
		if (args.length < 2) {
			System.out.println("Usage: java " + Thread.currentThread().getStackTrace()[1].getClassName() + " [File to be encrypted] [Encryption key]");
		} else {
			// Encrypt file
			String strFileToEncrypt = args[0];
			String strPssword = args[1];
			EncryptUtil.encryptFile(strFileToEncrypt, strPssword);

			// Decrypt file
			// String strFileToDecrypt = strFileToEncrypt.substring(0, strFileToEncrypt.lastIndexOf(".")) + ".enc";
			// String strDecryptedMsg = decryptFile(strFileToDecrypt);
			// System.out.println("Decrypted Message:\n\r" + strDecryptedMsg);
		}
	}

}