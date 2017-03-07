package itsco.edu.contactos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lupita on 04/03/2017.
 */

public class agrega implements Parcelable{
    private String nombre;
    private String numero;
    private String email;

    public agrega(){

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(numero);
        parcel.writeString(email);

    }
    private agrega(Parcel parcel){
        this.nombre=parcel.readString();
        this.numero=parcel.readString();
        this.email=parcel.readString();

    }
    public static final Parcelable.Creator<agrega> CREATOR=new Parcelable.Creator<agrega>()
    {
        @Override
        public agrega createFromParcel(Parcel parcel) {
            return new agrega(parcel);
        }

        @Override
        public agrega[] newArray(int i) {
            return new agrega[i];
        }
    };
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
