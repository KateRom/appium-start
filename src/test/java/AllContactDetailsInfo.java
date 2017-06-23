import java.util.ArrayList;
import java.util.List;

/*Created by katr on 14.06.2017.
 */
public class AllContactDetailsInfo {
    public static List<List<String>> allDetailedInfo(){
        List<List<String>> allInfo = new ArrayList<List<String>>();
        List<String> firstContact = new ArrayList<String>(){{
           add("Jenny Cherry");
           add("+1(959)-1775994");
           add("jqjenny16@yopmail.com");
           add("201 Metz Bates");
           add("15840 New York");
        }};
        List<String> secondContact = new ArrayList<String>(){{
           add("Garance Epperson");
           add("+1(747)-8330134");
           add("duepperson20@gmail.com");
           add("542 American Circle");
           add("49100 Washington");
        }};
        List<String> thirdContact = new ArrayList<String>(){{
           add("Nadia Patten");
           add("+1(131)-9550402");
           add("jnnadia13@gmail.com");
           add("791 Bombardier Court");
           add("93809 New York");
        }};
        List<String> fourContact = new ArrayList<String>(){{
           add("Jennifer Krantz");
           add("+1(656)-6779916");
           add("eekrantz4@yopmail.com");
           add("413 Wescam Drive");
           add("43115 Miami");
        }};
        List<String> fiveContact = new ArrayList<String>(){{
           add("Christin Steinberg");
           add("+1(656)-1115633");
           add("awchristin22@yahoo.com");
           add("412 Barfield Trail");
           add("53713 Houston");
        }};
        allInfo.add(firstContact);
        allInfo.add(secondContact);
        allInfo.add(thirdContact);
        allInfo.add(fourContact);
        allInfo.add(fiveContact);

        return allInfo;
    }
}
