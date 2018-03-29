package servlet.util;

import java.util.Random;

public class GeneratorKeys {
    private String key;
    private char[] abs = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f',
            'g','h','j','k','l','z','x','c','v','b','n','m','1','2','3','4','5','6',
            '7','8','9','0',};
    private Random random;

    public GeneratorKeys(){
        random = new Random();
        key = "";
    }

    public String randomGen(){
        for (int i = 0; i < abs.length / 2; i++){
            key += abs[random.nextInt(abs.length)];
        }
        System.out.println("CLASS GeneratorKeys -- " + key );
        return key;
    }
}
