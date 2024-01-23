public class ArabaIlani extends Ilan {
    private final String marka;
    private final String model;
    private final int yil;
    private final String yakitTipi;
    private final String vitesTipi;
    private final int motorGucu;

    public ArabaIlani(String baslik, String aciklama, double fiyat, String marka, String model,
                      int yil, String yakitTipi, String vitesTipi, int motorGucu) {
        super(baslik, aciklama, fiyat);
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.yakitTipi = yakitTipi;
        this.vitesTipi = vitesTipi;
        this.motorGucu = motorGucu;
    }

    @Override
    public String detayBilgileriString() {
        return String.format("Başlık: %s\nAçıklama: %s\nFiyat: %.2f\nMarka: %s\nModel: %s\nYıl: %d\nYakıt Tipi: %s\nVites Tipi: %s\nMotor Gücü: %d HP",
                getBaslik(), getAciklama(), getFiyat(), marka, model, yil, yakitTipi, vitesTipi, motorGucu);
    }

}
