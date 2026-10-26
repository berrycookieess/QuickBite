package QuickBite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    private String idPelanggan;

    private String nama;
    private String email;
    private String nomorTelepon;
    private String alamat;

    @OneToMany(mappedBy = "pelanggan")
    private List<Pesanan> daftarPesanan = new ArrayList<>();

    protected Pelanggan() {
    }

    public Pelanggan(String idPelanggan, String nama, String email,
                     String nomorTelepon, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public String getInfoPelanggan() {
        return nama + " (" + email + ")";
    }

    public void ubahAlamat(String alamatBaru) {
        this.alamat = alamatBaru;
    }
}

