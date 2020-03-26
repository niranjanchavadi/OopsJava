package com.userRegistration.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userRegistration {


        private static Pattern userNamePattern = Pattern.compile("^[A-Z]{1}[a-z]{2,}$");

private static Pattern email = Pattern.compile("^\\w+[\\+\\.\\w-]*@([\\w-]+\\.)*\\w+[\\w-]*\\.([a-z]{2,4}|\\d+)$");

        public static boolean validateUserName(String userName) {

            Matcher mtch = userNamePattern.matcher(userName);
            if (mtch.matches()) {
                return true;
            }
            return false;
        }




    public static boolean validateEmail(String emails) {

        Matcher mtch = email.matcher(emails);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    public static boolean validatepasswrd(String password) {

        return password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!*]).{8,40})");

    }

    public static boolean isvalidphonenum(String string) {
        return string.matches("^[1-9]{2}[-, ]?{1}[1-9][0-9]{9}$");
    }

 static   String [ ]invalid={"abc" ,"abc.com.my" ,"abc123@gmail.a" ,"abc123@.com" ,"abc123@.com.com" ,".abc@abc.com" ,"abc()*@gmail.com" ,"abc@%*.com"
            ,"abc.8.2002@gmail.com."  ,"abc@abc@gmail.com" ,"abc@gmail.com.1a" ,"abc@gmail.com.aa.a","acd@%*.com", "adsd..2002@gmail.coM", "dahgd.@gmail.com.",
         "adssfhsj@gmail.c1om", "afdjf@gmail.com.1a"};



   static String [ ] valid={"abc@yahoo.com" ,"abc-100@yahoo.com"  ,"abc.100@yahoo.com" , "abc111@abc.com" ,"abc-100@abc.net", "abc.100@abc.com.au",
            "abc@1.com" , "abc@gmail.com.com" ,"abc+100@gmail.com","abc@yahoo.com", "asdsf-100@yahoo.com",
            "sadsf.100@yahoo.com", "adfs111@journaldev.com", "xyz-100@journaldev.net",
            "journaldev.100@journaldev.com.au", "journaldev@1.com", "journaldev@gmail.com.com",
            "abc+100@gmail.com", "abc-100@yahoo-test.com"};

  static String [ ] validpwd={"nnchavadti@2M","nndakxfg4#L" , "badsspofG*1h", "masgafgt$T6i"};
    static String [ ] invalidpwd={"nnchavadti2M","nndakxfg#L" , "badsspofG1h", "masgafgt$6i","nnads","123znZ>v" , "gsftgf3;lhj"};


        public static void main(String args[]) {
            System.out.println(validateUserName("Niranjan"));
            System.out.println(validateEmail("nnchavad2@gmail.com"));
            System.out.println(isvalidphonenum("91 8892820622"));
            System.out.println(validatepasswrd("nnchavaui2@J"));
            System.out.println("-------------------------------------------- below for invalid email address------------------------------");

            for (int i=0 ; i<invalid.length;i++){

                System.out.println(validateEmail(invalid[i]));
            }
            System.out.println("-------------------------------------------- below for valid email address-----------------------------------");

            for (int i=0 ; i<valid.length;i++)
            {
                System.out.println(validateEmail(valid[i]));

            }

            System.out.println("-------------------------------------------- below for valid passwd-----------------------------------");

            for (int i=0 ; i<validpwd.length;i++)
            {
                System.out.println(validatepasswrd(validpwd[i]));

            }





            System.out.println("-------------------------------------------- below for Invalid passwd-----------------------------------");

            for (int i=0 ; i<invalidpwd.length;i++)
            {
                System.out.println(validatepasswrd(invalidpwd[i]));

            }
        }
}
/*
/ = Begin an expression
^ = The matched string must begin here, and only begin here
\w = any word (letters, digits, underscores)
+ = match previous expression at least once, unlimited number of times
[] = match any character inside the brackets, but only match one
\+\. = match a literal + or .
\w = another word
- = match a literal -
* = match the previous expression zero or infinite times
@ = match a literal @ symbol
() = make everything inside the parentheses a group (and make them referencable)
[] = another character set
\w- = match any word or a literal -
+ = another 1 to infinity quantifier
\. = match another literal .
* = another 0 to infinity quantifier
\w+ = match a word at least once
[\w-]*\. = match a word or a dash at least zero times, followed by a literal .
() = another group
[a-z]{2,4} = match lowercase letters at least 2 times but no more than 4 times
| = "or" (does not match pipe)
\d+ = match at least 1 digit
$ = the end of the string
/ = end an expression
i = test the string in a case i n sensitive manner
 */