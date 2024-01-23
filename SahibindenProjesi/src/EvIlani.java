
public class EvIlani extends Ilan {
    private final int metrekare;
    private final int odaSayisi;
    private final int binaYasi;
    private final int bulunduguKat;
    private final boolean esyali;

    public EvIlani(String baslik, String aciklama, double fiyat, int metrekare, int odaSayisi,
                   int binaYasi, int bulunduguKat, boolean esyali) {
        super(baslik, aciklama, fiyat);
        this.metrekare = metrekare;
        this.odaSayisi = odaSayisi;
        this.binaYasi = binaYasi;
        this.bulunduguKat = bulunduguKat;
        this.esyali = esyali;
    }
    @Override
    public String detayBilgileriString() {
        return String.format("Başlık: %s\nAçıklama: %s\nFiyat: %.2f\nMetrekare: %d\nOda Sayısı: %d\nBina Yaşı: %d\nBulunduğu Kat: %d\nEşyalı: %s",
                getBaslik(), getAciklama(), getFiyat(), metrekare, odaSayisi, binaYasi, bulunduguKat, (esyali ? "Evet" : "Hayır"));
    }


}
