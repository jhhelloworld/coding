package leetcode;

import java.util.HashSet;

/**
 * jh
 * 2019年01月11日  10：57
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address,
 * mail sent there will be forwarded to the same address without dots in the local name.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.
 * How many different addresses actually receive mails?
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 */
public class Q_929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email :emails){
            int indexA = email.indexOf('@');
            String localName = email.substring(0,indexA);
            String domainName = email.substring(indexA);
            StringBuffer sb = new StringBuffer();
            for(char c:localName.toCharArray()){
                if(c == '.'){
                    continue;
                }else if(c == '+'){
                    break;
                }else {
                    sb.append(c);
                }
            }
            localName = sb.toString();
            set.add(new StringBuilder().append(localName).append(domainName).toString());
        }
        return set.size();

    }
}