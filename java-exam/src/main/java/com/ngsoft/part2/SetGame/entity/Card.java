package com.ngsoft.part2.SetGame.entity;

import java.util.Objects;

public class Card {
    private CardFeatures.Shape shape;
    private CardFeatures.Color color;
    private CardFeatures.ItemCount itemCount;
    private CardFeatures.Texture texture;

    public static Card createNew(CardFeatures.Shape shape, CardFeatures.Color color, CardFeatures.ItemCount itemCount, CardFeatures.Texture texture){
        return new Card(shape,color,itemCount,texture);
    }

    public Card(CardFeatures.Shape shape, CardFeatures.Color color, CardFeatures.ItemCount itemCount, CardFeatures.Texture texture) {
        this.shape = shape;
        this.color = color;
        this.itemCount = itemCount;
        this.texture = texture;
    }

    public CardFeatures.Shape getShape() {
        return shape;
    }

    public CardFeatures.Color getColor() {
        return color;
    }

    public CardFeatures.ItemCount getItemCount() {
        return itemCount;
    }

    public CardFeatures.Texture getTexture() {
        return texture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getShape() == card.getShape() &&
                getColor() == card.getColor() &&
                getItemCount() == card.getItemCount() &&
                getTexture() == card.getTexture();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShape(), getColor(), getItemCount(), getTexture());
    }
}
