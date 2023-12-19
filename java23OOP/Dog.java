package java23OOP;

public class Dog extends Animal {
    @Override
    void voice() {
        System.out.println("java23OOP.Dog voice : Haw");
    }



    void voice(String angryVoice) {
        System.out.println(angryVoice);
    }



    void voice(int NumberofVoice) {
        for (int i = 0; i <= NumberofVoice; i++)
            System.out.println(i);

    }
}
