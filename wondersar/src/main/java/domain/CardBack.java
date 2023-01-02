package domain;

public enum CardBack {

	CentralDeck(null, "card-back-question.png"), //
	
	Alexandrie(Wonder.Alexandrie, "card-back-alexandrie.png"), //
	Halicarnasse(Wonder.Halicarnasse, "card-back-halicarnasse.png"),
	Ephese(Wonder.Ephese, "card-back-ephese.png"), //
	Olympie(Wonder.Olympie, "card-back-olympie.png"), //,
	Babylone(Wonder.Babylone, "card-back-olympie.png"), //
	Rhodes(Wonder.Rhodes, "card-back-rhodes.png"), //
	Gizeh(Wonder.Gizeh, "card-back-gizeh.png"); //
	
	public final boolean centralDeck;
	// set only when not centralDeck
	public final Wonder wonderDeck;
	public final String imageResource;
	
	private CardBack(Wonder wonderDeck, String imageResource) {
		this.centralDeck = (wonderDeck == null);
		this.wonderDeck = wonderDeck;
		this.imageResource = "images/cards/" + imageResource;
	}
}
