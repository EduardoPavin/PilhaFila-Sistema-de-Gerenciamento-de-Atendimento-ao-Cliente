public class Elemento {
    private String id;
    private String variavelX;
    private String variavelY;

    public String getId() {
        return id;
    }

    public Elemento(String id, String variavelX, String variavelY) {
        this.id = id;
        this.variavelX = variavelX;
        this.variavelY = variavelY;
    }


    public String getVariavelX() {
        return variavelX;
    }

    public String getVariavelY() {
        return variavelY;
    }
}
