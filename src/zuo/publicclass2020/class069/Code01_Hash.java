package zuo.publicclass2020.class069;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

// 这个类所包含的jar包需要自己找到，然后导入项目

public class Code01_Hash {

	public static class Hash {

		private MessageDigest hash;

		public Hash(String algorithm) {
			try {
				hash = MessageDigest.getInstance(algorithm);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		public String hashCode(String input) {
			//为了其他代码运行，临时注解
//			return DatatypeConverter.printHexBinary(hash.digest(input.getBytes())).toUpperCase();
            return "";
		}
	}

	public static void main(String[] args) {
		System.out.println("支持的算法 : ");
		for (String str : Security.getAlgorithms("MessageDigest")) {
			System.out.println(str);
		}
		System.out.println("=======");

		String algorithm = "SHA-256";
		Hash hash = new Hash(algorithm);

		String input1 = "zuochengyunzuochengyun1";
		String input2 = "zuochengyunzuochengyun2";
		String input3 = "zuochengyunzuochengyun3";
		String input4 = "zuochengyunzuochengyun4";
		String input5 = "zuochengyunzuochengyun5";
		System.out.println(hash.hashCode(input1));
		System.out.println(hash.hashCode(input2));
		System.out.println(hash.hashCode(input3));
		System.out.println(hash.hashCode(input4));
		System.out.println(hash.hashCode(input5));

	}

}
