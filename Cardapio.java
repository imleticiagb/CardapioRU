public class Cardapio {

    private String dia, proteina, veg, salada, acompanhamento, verdura, suco;

    public Cardapio(String dia, String proteina, String veg, String salada, String acompanhamento, String verdura, String suco) {

        this.dia = dia;
        this.acompanhamento = acompanhamento;
        this.proteina = proteina;
        this.verdura = verdura;
        this.veg = veg;
        this.salada = salada;
        this.suco = suco;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public String getVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public String getSalada() {
        return salada;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getVerdura() {
        return verdura;
    }

    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }

    public String getSuco() {
        return suco;
    }

    public void setSuco(String suco) {
        this.suco = suco;
    }

    @Override
    public String toString() {
        return "Cardapio de " + dia +
                "\nAcompanhamento: " + acompanhamento +
                "\nProteína: " + proteina +
                "\nOpção Vegetariana: " + veg +
                "\nSalada: " + salada +
                "\nVerdura: " + verdura +
                "\nSuco: " + suco;
    }
}
