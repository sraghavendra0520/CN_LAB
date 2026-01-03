import java.math.BigInteger;
import java.util.*;

class rsa1 {

    BigInteger p, q, n, phi, e, d;

    // Key generation
    void generateKeys(int bitLength) {
        Random r = new Random();

        p = BigInteger.probablePrime(bitLength, r);
        q = BigInteger.probablePrime(bitLength, r);

        n = p.multiply(q);   // n = p*q
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // e = BigInteger.valueOf(65537); // commonly used public key
        e = BigInteger.valueOf(3);
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.TWO);
        }

        d = e.modInverse(phi); // private key
    }

    // Encryption: c = m^e mod n
    BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    // Decryption: m = c^d mod n
    BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public static void main(String[] args) {

        rsa1 rsa = new rsa1();
        Scanner sc = new Scanner(System.in);

        rsa.generateKeys(256); // small size for demo
        
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        BigInteger m = new BigInteger(msg.getBytes());

        BigInteger cipher = rsa.encrypt(m);

        long enc=Math.abs(cipher.longValue());
        System.out.println("Encrypted Message: " + cipher);
        System.out.println("Encrypted Message: " + enc);

        BigInteger plain = rsa.decrypt(cipher);
        System.out.println("Decrypted Message: " + new String(plain.toByteArray()));

        sc.close();
    }
}
