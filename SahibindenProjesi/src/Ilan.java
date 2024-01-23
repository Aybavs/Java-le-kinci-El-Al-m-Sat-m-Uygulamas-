public abstract class Ilan {
    protected String baslik;
    protected String aciklama;

    protected double fiyat;

    public Ilan(String baslik, String aciklama, double fiyat) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
    }

    public abstract String detayBilgileriString();
    public String getBaslik() {
        return baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public double getFiyat() {
        return fiyat;
    }



}
