import java.math.BigInteger;
import java.util.*;

class rsa {
        BigInteger p,q,e,d,n,phi;
        void genKey(int bitlength){
                Random r=new Random();
                p=BigInteger.probablePrime(bitlength,r);
                q=BigInteger.probablePrime(bitlength,r);
                n=p.multiply(q);
                phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
                e=BigInteger.valueOf(3);
                while(!phi.gcd(e).equals(BigInteger.ONE)){
                        e=e.add(BigInteger.TWO);
                }
                d=e.modInverse(phi);
        }
        BigInteger encrypt(BigInteger msg){
                return msg.modPow(e, n);
        }
        BigInteger decrypt(BigInteger cipher){
                return cipher.modPow(d,n);
        }
        public static void main(String args[]){
                rsa rsa1=new rsa();
                Scanner sc=new Scanner(System.in);
                rsa1.genKey(512);
                System.out.print("Enter msg to encrypt: ");
                String msg=sc.nextLine();
                BigInteger m=new BigInteger(msg.getBytes());
                BigInteger cipher=rsa1.encrypt(m);
                System.out.print("Encrypted data: "+cipher);
                BigInteger plain=rsa1.decrypt(cipher);
                System.out.print("\nDecrypted msg: "+new String(plain.toByteArray()));
        }
}