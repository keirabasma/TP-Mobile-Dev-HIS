package com.example.liste;

 import android.os.Parcel;
import android.os.Parcelable;

    public class Contact implements Parcelable {
        private String nom;
        private String prenom;
        private String numero;

        public Contact(String nom, String prenom, String numero) {
            this.nom = nom;
            this.prenom = prenom;
            this.numero = numero;
        }

        protected Contact(Parcel in) {
            nom = in.readString();
            prenom = in.readString();
            numero = in.readString();
        }

        public static final Creator<Contact> CREATOR = new Creator<Contact>() {
            @Override
            public Contact createFromParcel(Parcel in) {
                return new Contact(in);
            }

            @Override
            public Contact[] newArray(int size) {
                return new Contact[size];
            }
        };

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getNumero() {
            return numero;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(nom);
            dest.writeString(prenom);
            dest.writeString(numero);
        }
    }


