public class BilgisayarIlani extends Ilan {
    private final String marka;
    private final String model;
    private final String islemci;
    private final int ramGB;
    private final int depolamaGB;

    public BilgisayarIlani(String baslik, String aciklama, double fiyat, String marka, String model,
                           String islemci, int ramGB, int depolamaGB) {
        super(baslik, aciklama, fiyat);
        this.marka = marka;
        this.model = model;
        this.islemci = islemci;
        this.ramGB = ramGB;
        this.depolamaGB = depolamaGB;
    }

    @Override
    public String detayBilgileriString() {
        return String.format("Başlık: %s\nAçıklama: %s\nFiyat: %.2f\nMarka: %s\nModel: %s\nİşlemci: %s\nRAM: %d GB\nDepolama Kapasitesi: %d GB",
                getBaslik(), getAciklama(), getFiyat(), marka, model, islemci, ramGB, depolamaGB);
    }

}
