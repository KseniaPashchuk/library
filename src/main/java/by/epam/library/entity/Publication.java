package by.epam.library.entity;

import by.epam.library.publicationtype.PublicationType;

import java.math.BigDecimal;

public abstract class Publication {
    private String name;
    private String publisher;
    private BigDecimal price;
    private int pages;
    private PublicationType type;

    public Publication() {
    }

    public Publication(String name, String publisher, BigDecimal price, int pages, PublicationType type) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.pages = pages;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name = " + name + "Type = " + type + ", Publisher = " + publisher + ", Price = " + price + "Number of pages = " + pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        if (getPages() != that.getPages()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getPublisher() != null ? !getPublisher().equals(that.getPublisher()) : that.getPublisher() != null)
            return false;
        return getPrice() != null ? getPrice().equals(that.getPrice()) : that.getPrice() == null;

    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = getName() != null ? getName().hashCode() : 0;
        result = prime * result + (getPublisher() != null ? getPublisher().hashCode() : 0);
        result = prime * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = prime * result + getPages();
        return result;
    }
}
