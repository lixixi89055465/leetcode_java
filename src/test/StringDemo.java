package test;

public class StringDemo{
  private static final String MESSAGE="taobao";
  public static void main(String [] args) {
    String a ="tao"+"bao";
    String b="tao";
    String c="bao";
    System.out.println(a==MESSAGE);
    System.out.println((b+"bao")==MESSAGE);
  }
}  