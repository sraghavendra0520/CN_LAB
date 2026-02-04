import java.math.BigInteger;
import java.util.*;

public class rsa2 {
    BigInteger p,q,n,phi,e,d;
    void genkey(int Bitlength){
        Random r=new Random();
        p=BigInteger.probablePrime(Bitlength,r);
        q=BigInteger.probablePrime(Bitlength,r);
        n=p.multiply(q);
        phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e=BigInteger.valueOf(3);
        while(!phi.gcd(e).equals(BigInteger.ONE)){
            e=e.add(BigInteger.TWO);
        }
        d=e.modInverse(phi);
    }
    BigInteger encrypt(BigInteger msg){
        return msg.modPow(e,n);
    }
    BigInteger decrypt(BigInteger cipher){
        return cipher.modPow(d,n);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        rsa2 rsa=new rsa2();
        rsa.genkey(512);
        System.out.println("Enter the msg to encrypt: ");
        String msg=sc.nextLine();
        BigInteger m=new BigInteger(msg.getBytes());
        BigInteger cipher=rsa.encrypt(m);
        System.out.println("Encrypted msg is: "+cipher);
        BigInteger plain=rsa.decrypt(cipher);
        System.out.println("Decrypted msg is: "+new String(plain.toByteArray()));
        sc.close();
    }
}
