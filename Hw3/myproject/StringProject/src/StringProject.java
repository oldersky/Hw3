import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by HP on 30.06.2017.
 */
public class StringProject {
    public static void main(String args[]) throws IOException {
        Locale.setDefault(Locale.ENGLISH);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        TreeMap<String, Integer> words = new TreeMap<String, Integer>();
//Р Р°Р·Р±РёРІР°РµРј СЃС‚СЂРѕРєСѓ РЅР° СЃР»РѕРІР°

        s = in.readLine();
        StringTokenizer st = new StringTokenizer(s, "., -\"!?:;");
//РЎС‡РёС‚Р°РµРј РєРѕР»РёС‡РµСЃС‚РІРѕ СЃР»РѕРІР° РІ СЃС‚СЂРѕРєРµ. РљР°Р¶РґРѕРµ СЃР»РѕРІРѕ С…СЂР°РЅРёС‚СЃСЏ РІ TreeMap Рё СЏРІР»СЏРµС‚СЃСЏ РєР»СЋС‡РѕРј.
//Рђ РєРѕР»РёС‡РµСЃС‚РІРѕ С‚Р°РєРёС… СЃР»РѕРІ - Р·РЅР°С‡РµРЅРёРµРј. Р•СЃРё СЃР»РѕРІРѕ СѓР¶Рµ РІСЃС‚СЂРµС‡Р°РѕР»СЃСЊ, СѓРґР°Р»СЏРµРј РµРіРѕ РёР· TreeMap
//Рё РІРѕР·РІСЂР°С‰Р°РµРј РїР°СЂСѓ СЃ С‚Р°РєРёРј Р¶Рµ РєР»СЋС‡РѕРј, РЅРѕ СЃРѕ Р·РЅР°С‡РµРЅРёРµРј РЅР° 1 Р±РѕР»СЊС€Рµ
        while (st.hasMoreTokens()) {
            String buf = st.nextToken().toLowerCase();
            if (words.containsKey(buf)) {
                int i = words.get(buf);
                words.remove(buf);
                i++;
                words.put(buf, i);
            } else {
                words.put(buf, 1);
            }
        }
//РџРµСЂРµРїРёСЃС‹РІР°РµРј РїР°СЂС‹ РєР»СЋС‡-Р·РЅР°С‡РµРЅРёРµ РІ РјР°СЃСЃРёРІ СЃР»РѕРІ РІ С„РѕСЂРјР°С‚Рµ "РєР»СЋС‡" + Р·РЅР°С‡РµРЅРёРµ. Р� РІС‹РІРѕРґРёРј РјР°СЃСЃРёРІ
        String[] arrString = new String[words.size()];
        int i = 0;
        for (Map.Entry w : words.entrySet()){
            arrString[i] = w.getKey() + ": " + w.getValue();
            System.out.println(arrString[i]);
            i++;
        }
    }
}
