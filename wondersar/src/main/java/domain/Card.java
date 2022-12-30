package domain;
public class Card {

	public final CardType front;
	public final CardBack back;

	public Card(CardType front, CardBack back) {
		this.front = front;
		this.back = back;
	}

	public CardBack getBack() {
		return back;
	}
	public CardType getFront() {
		return front;
	}
}

