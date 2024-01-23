public class TelefonIlani extends Ilan {
    private final String marka;
    private final String model;
    private final int depolamaGB;
    private final boolean nfcVar;
    private final String kamera;


    public TelefonIlani(String baslik, String aciklama, double fiyat, String marka, String model,
                        int depolamaGB, boolean nfcVar, String kamera) {
        super(baslik, aciklama, fiyat);
        this.marka = marka;
        this.model = model;
        this.depolamaGB = depolamaGB;
        this.nfcVar = nfcVar;
        this.kamera = kamera;
    }

    @Override
    public String detayBilgileriString() {
        return String.format("Başlık: %s\nAçıklama: %s\nFiyat: %.2f\nMarka: %s\nModel: %s\nDepolama Kapasitesi: %d GB\nNFC Var mı? %s\nKamera Çözünürlüğü: %s",
                getBaslik(), getAciklama(), getFiyat(), marka, model, depolamaGB, (nfcVar ? "Evet" : "Hayır"), kamera);
    }

}
