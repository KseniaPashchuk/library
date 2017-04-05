package by.epam.library.entity;

import by.epam.library.publicationtype.MagazinePeriod;
import by.epam.library.publicationtype.MagazineType;
import by.epam.library.publicationtype.PublicationType;

import java.math.BigDecimal;


public class Magazine extends Publication {
    public int volume;
    public MagazinePeriod period;
    public MagazineType magazineType;

    public Magazine() {
    }

    public Magazine(String name, String publisher, BigDecimal price, int pages,
                    int volume, MagazinePeriod period, MagazineType magazineType) {
        super(name, publisher, price, pages, PublicationType.MAGAZINE);
        this.volume = volume;
        this.period = period;
        this. magazineType = magazineType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MagazinePeriod getPeriod() {
        return period;
    }

    public void setPeriod(MagazinePeriod period) {
        this.period = period;
    }

    public MagazineType getMagazineType() {
        return  magazineType;
    }

    public void setType(MagazineType  magazineType) {
        this. magazineType =  magazineType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Volume = " + volume +
                ", Period = " + period +
                ", Magazine type = " +  magazineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)){
            return false;
        }

        Magazine magazinee = (Magazine) o;
        if (getVolume() != magazinee.getVolume()) {
            return false;
        }
        if (getPeriod() != magazinee.getPeriod()){
            return false;
        }
        return getType().equals(magazinee.getType());

    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = super.hashCode();
        result = prime * result + getVolume();
        result = prime * result + (getPeriod() != null ? getPeriod().hashCode() : 0);
        result = prime * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
